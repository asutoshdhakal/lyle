public class SubjectManager {

	private String name;
	private int temp; 
	private SecurityLevel level;


	public SubjectManager(String name, SecurityLevel level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public int getTemp() {
		return this.temp; 
	}

	public SecurityLevel getLevel() {
		return this.level;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

}
