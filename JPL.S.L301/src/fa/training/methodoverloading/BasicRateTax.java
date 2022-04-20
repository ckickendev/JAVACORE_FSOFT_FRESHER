package fa.training.methodoverloading;

public class BasicRateTax {
	private static final double BASE_INCOME = 1000.00;
	  private static final double BASIC_TAX_RATE = 0.20;

	  /**
	   * This method calculates fixed base income.
	   * 
	   * @return returns 20% of a fixed base income of £1000.
	   */
	  public double calcTax() {
	    return BASE_INCOME * BASIC_TAX_RATE;
	  }

	  /**
	   * calculates the tax as 20% of the grossIncome.
	   * 
	   * @param grossIncome
	   * @return returns 20% of the grossIncome if it’s greater than the base income
	   *         of £1000.
	   */
	  public double calcTax(double grossIncome) {
	    if (grossIncome < BASE_INCOME) {
	      return calcTax();
	    }
	    return grossIncome * BASIC_TAX_RATE;
	  }
}
