public class ReferenceMonitor {

	private InstructionObject instruction;

	public ReferenceMonitor(InstructionObject instruction) {

		this.instruction = instruction;

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
		} 

	}

	public void executeRead() {
		instruction.subject.setTemp(instruction.object.getValue());
	}

	public void executeWrite() {
		instruction.object.setValue(instruction.getValue());
	}

}