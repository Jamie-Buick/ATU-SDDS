package ie.atu.sw;

import static java.lang.System.out;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.StructuredTaskScope;

public class StructuredFileParser {

	private Set<String> words = new ConcurrentSkipListSet<>();
	
	public void go(String book) throws Throwable {
		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
			Files.lines(Paths.get(book)).forEach(text -> {
				scope.fork(() -> {
					process(text);
					return null;
				});
			});
			scope.join();
			scope.throwIfFailed(e -> e);  
			
			out.println(words);
			out.println(words.size());
		}
	}
	
	public void process(String text) {
		Arrays.stream(text.split("\\s+")).forEach(w -> words.add(w));
	}
	
	public static void main(String[] args) throws Throwable {
		new StructuredFileParser().go("./shakespeare.txt");
	}
}