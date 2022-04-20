package fa.training.methodoverloading;

public class TaxCollector {

	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * The grossIncome value gets from the first argument of main.
		 */
		double grossIncome = Double.parseDouble(args[0]);
		/*
		 * Create a new BasicRateTax object named: taxCalculator.
		 */
//	     HigherRateTax taxCalculator = new HigherRateTax();
		// Or
		BasicRateTax taxCalculator = new BasicRateTax();
		/*
		 * Call object's calcTax method.
		 */
		double tax = taxCalculator.calcTax(grossIncome);

		/*
		 * Print out result.
		 */
		System.out.println("Tax due is " + tax);
	}

}
