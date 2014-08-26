package LangFun;

public class City {
	private boolean isCapitalCity;
	private int numberOfCitizen;
	private double taxPerCitizen;
	private boolean isMetroplis;
	
	public City(boolean isCapitalCity, int numberOfCitizen, double taxPerCitizen){
		this.isCapitalCity = isCapitalCity;
		this.numberOfCitizen = numberOfCitizen;
		this.taxPerCitizen = taxPerCitizen;
		isMetroplis = ((isCapitalCity&&numberOfCitizen>100000)||
				(numberOfCitizen>200000&&(taxPerCitizen*numberOfCitizen>720000000)));
	}
	
	public boolean getIsMetroplis(){
	 	return isMetroplis;
	}
		

}
