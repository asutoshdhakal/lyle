public class ObjectManager {

	private String name;
	private int value; 
	private SecurityLevel level;


	public ObjectManager(String name, SecurityLevel level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public int getValue() {
		return this.value; 
	}

	public SecurityLevel getLevel() {
		return this.level;
	}

	public void setValue(int value) {
		this.value = value; 
	}

}