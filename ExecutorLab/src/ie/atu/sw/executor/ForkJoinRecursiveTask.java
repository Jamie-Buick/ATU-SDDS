package ie.atu.sw.executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import static java.lang.System.*;
public class ForkJoinRecursiveTask{

	public void go() {
		int[] numbers = IntStream.rangeClosed(1, 100).toArray(); //1->100
		try(var pool = new ForkJoinPool()){
			var task = new ListAdder(numbers, 0, numbers.length);
			out.println(pool.invoke(task));
		}
	}
	
	/*
	 * Triangular series: (n(n + 1)) / 2
	 */
	@SuppressWarnings("serial")
	private class ListAdder extends RecursiveTask<Integer>{
		int[] list;
		int start, end;
		
		ListAdder(int[] list, int start, int end){
			this.list = list;
			this.start = start;
			this.end = end;
		}
		
		protected Integer compute() {
			int length = end - start;
			
			if (length < list.length) {
				int sum = 0;
		        for (int i = start; i < end; i++) sum += list[i];
		        return sum;
		    }			

			var subTask1 = new ListAdder(list, start, start + length / 2);
	        subTask1.fork();
	        
	        var subTask2 = new ListAdder(list, start + length / 2, end);
	        int res1 = subTask2.compute();
	        int res2 = subTask1.join();
	        
			return res1 + res2;
		}
	}
	
	public static void main(String[] args) {
		new ForkJoinRecursiveTask().go();
	}
}