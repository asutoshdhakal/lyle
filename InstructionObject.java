public class InstructionObject {

	private String instructionType;
	public ObjectManager object;
	public SubjectManager subject;
	private int value; 	


	public InstructionObject(String instructionType, SubjectManager subject, ObjectManager object, int value) {
		this.instructionType = instructionType;
		this.subject = subject; 
		this.object = object; 
		this.value = value;
	}

	public InstructionObject(String instructionType, SubjectManager subject, String objectName, int value) {
		this.instructionType = instructionType;
		this.subject = subject; 
		this.object = object; 
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String getType() {
		return this.instructionType;
	}
}