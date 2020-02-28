import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecureSystem {
	
	public static final InstructionObject BadInstruction = new InstructionObject("BAD", null, null, -1);


	public static void main(String[] args) throws FileNotFoundException {


		SecurityLevel low = new SecurityLevel(0);
		SecurityLevel high = new SecurityLevel(1);

		SubjectManager lyle = new SubjectManager("lyle", low);
		SubjectManager hal = new SubjectManager("hal", high);

		ObjectManager lobj = new ObjectManager("lobj", low);
		ObjectManager hobj = new ObjectManager("hobj", high);


		
		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);

		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			InstructionObject instruction = parseInstruction(line, lyle, hal, lobj, hobj);
			ReferenceMonitor reference = new ReferenceMonitor(instruction);


			if(instruction.getType() == "BAD") {
				System.out.println("bad " + lobj.getValue() + " " + hobj.getValue() + " " + lyle.getTemp() + " " + hal.getTemp());
			} else {
				System.out.println(instruction.getType() + " " + lobj.getValue() + " " + hobj.getValue() + " " + lyle.getTemp() + " " + hal.getTemp());

			}
		}

}


public static InstructionObject parseInstruction(String line, SubjectManager lyle, SubjectManager hal, ObjectManager lobj, ObjectManager hobj) {
	line = line.toLowerCase();
	String[] ins = line.split(" ");
	if(ins.length > 0) {
		if(ins[0].matches("read")) {
			if(ins.length == 3) {
				if(ins[1].matches("hal") || ins[1].matches("lyle")) {
					if(ins[2].matches("lobj") || ins[2].matches("hobj")) {
						return new InstructionObject(ins[0],ins[1].matches("lyle") ? lyle : hal, ins[2].matches("lobj") ? lobj : hobj, 0);
					} else {
						return BadInstruction;
					}
				} else {
					return BadInstruction;
				}
			} else {
				return BadInstruction;
			}
		} 
		else if(ins[0].matches("write")) {
			if(ins.length == 4) {
				if(ins[1].matches("hal") || ins[1].matches("lyle")) {
					if(ins[2].matches("lobj") || ins[2].matches("hobj")) {
						try {
							int value = Integer.parseInt(ins[3]);
							return new InstructionObject(ins[0],ins[1].matches("lyle") ? lyle : hal, ins[2].matches("lobj") ? lobj : hobj, value);
						} catch (NumberFormatException e) {
							return BadInstruction;
						}
					} else {
						return BadInstruction;
					}
				} else {
					return BadInstruction;
				}
			} else {
				return BadInstruction;
			}
		} else {
			return BadInstruction;
		}
	} else {
		return BadInstruction;
	}

}

	
}