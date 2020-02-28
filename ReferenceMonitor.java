public class ReferenceMonitor {

	private InstructionObject instruction;

	public ReferenceMonitor(InstructionObject instruction) {

		this.instruction = instruction;
		this.subjectManager = new SubjectManager();

		if(instruction.getType().equals("read")) {
			if(instruction.subject.getLevel().level >= instruction.object.getLevel().level) {
				executeRead();
			} else {
				instruction.subject.setTemp(0);
			}

		} else if(instruction.getType().equals("write")) {
			if(instruction.subject.getLevel().level <= instruction.object.getLevel().level) {
				executeWrite();
			} 
		} else if(instruction.getType().equals("create")) {

			// if object already exists, don't do anything. for this lab we don't need to check if the object exists. 

			ObjectManager newObject = new ObjectManager(instruction.object.name);
			


		} else if(instruction.getType().equals("destroy")) {

			// if object exists and level of subject is greater than the level of the object, then you can destroy, otherwise NO-OP

		} else if(instruction.getType().equals("run")) {
			instruction.subject.run();
		}

	}

	public void executeRead() {
		instruction.subject.setTemp(instruction.object.getValue());
	}

	public void executeWrite() {
		instruction.object.setValue(instruction.getValue());
	}

}