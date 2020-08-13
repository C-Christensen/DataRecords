package college;

public enum Rank {
	FRESH("Freshman"),
	SOPH("Sophomore"),
	JUN("Junior"),
	SEN("Senior");
	
	private String rank;
	
	private Rank(String rank) {
		this.rank = rank;
	}
	
	public String toString() {
		return rank;
	}
	

}
