package college;

public enum Title {
	ASTR("ASTR", 100),
	CSC("CSC", 142),
	ENG("ENG", 110),
	MATH("MATH", 152),
	PHYS("PHYS", 221);
	
	private String prefix;
	private int    number;
	
	private Title(String prefix, int number) {
		this.prefix = prefix;
		this.number = number;
	}
	
	public String toString() {
		return prefix + " " + number;
	}
}
