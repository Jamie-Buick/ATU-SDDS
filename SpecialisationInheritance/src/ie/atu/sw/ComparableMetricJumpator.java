package ie.atu.sw;


public interface ComparableMetricJumpator extends MetricJumpator, Comparable<ComparableMetricJumpator>{

	
	public default void jump(double height, Unit unit) throws Exception {
		// Completely override the inherited behaviour. Guarantees we don't have a DDoD.
	}
	
}
