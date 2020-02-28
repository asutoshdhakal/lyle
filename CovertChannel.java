import java.io.*;
import java.util.*;
public class CovertChannel {
    public static void main(String[] args) throws FileNotFoundException,UnsupportedEncodingException {
        boolean verbose = false;
        File inputFile = null;
        File outputFile = null;
        File logFile = null;
        PrintWriter logWriter = null;
        PrintWriter outWriter = null;
        SecurityLevel low = new SecurityLevel(0);
		SecurityLevel high = new SecurityLevel(1);

        SubjectManager lyle = new SubjectManager("lyle", low);
        SubjectManager hal = new SubjectManager("hal", high);

        
        
        
        if(args == null || args.length == 0) {
            System.out.println("Parse error");
        }

        else {
            if(args.length == 2) {
                verbose = true;
                logFile = new File("log");
                inputFile = new File(args[1]);
                outputFile = new File(args[1] + ".out");
                logWriter = new PrintWriter(logFile);
                
            } else if (args.length == 1) {
                inputFile = new File(args[0]);
                outputFile = new File(args[0] + ".out");
            }
            Scanner sc = new Scanner(inputFile);
            outWriter = new PrintWriter(outputFile);

            while(sc.hasNextLine()) {
                String line = sc.nextLine();

                byte[] bytes = line.getBytes("UTF-8");

                for(byte b: bytes) {
                    String s1 = Integer.toBinaryString(b & 0xFF);
                    for(char c : s1.toCharArray()) {
                        InstructionObject halCreate = null;
                        InstructionObject halDestroy = null;
                        InstructionObject lyleCreate = null;
                        InstructionObject lyleWrite = null;
                        InstructionObject lyleRead = null;
                        InstructionObject lyleDestroy = null;
                        
                        if(c == '0') {
                            halCreate = new InstructionObject("create", hal, "obj", 0);
                            ReferenceMonitor monitor = new ReferenceMonitor(halCreate);
                            if(verbose) {
                                logWriter.println("CREATE HAL OBJ");
                            }
                        } 
                        
                        
                        lyleCreate = new InstructionObject("create", lyle, "obj", 0);
                        ReferenceMonitor monitor = new ReferenceMonitor(lyleCreate);

                        lyleWrite = new InstructionObject("write", lyle, "obj", 5);
                        ReferenceMonitor monitor = new ReferenceMonitor(lyleWrite);

                        lyleRead = new InstructionObject("read", lyle, "obj", 0);
                        ReferenceMonitor monitor = new ReferenceMonitor(lyleRead);

                        if(lyle.getTemp() == 5) {   // hal sent 1 bit
                            lyle.run(1,outWriter);
                        } else {                    // hal sent 0 bit
                            lyle.run(0,outWriter);
                        }

                        lyleDestroy = new InstructionObject("destroy", lyle, "obj", 0);
                        ReferenceMonitor monitor = new ReferenceMonitor(lyleDestroy);

                        if(verbose) {
                            logWriter.println("CREATE LYLE OBJ");
                            logWriter.println("WRITE LYLE OBJ 5");
                            logWriter.println("READ LYLE OBJ");
                            logWriter.println("DESTROY LYLE OBJ");
                            logWriter.println("RUN LYLE");
                        }

                    }
                }

                
                // ReferenceMonitor reference = new ReferenceMonitor(instruction);
    
    
                // if(instruction.getType() == "BAD") {
                //     System.out.println("bad " + lobj.getValue() + " " + hobj.getValue() + " " + lyle.getTemp() + " " + hal.getTemp());
                // } else {
                //     System.out.println(instruction.getType() + " " + lobj.getValue() + " " + hobj.getValue() + " " + lyle.getTemp() + " " + hal.getTemp());
    
                // }
            }

        }
        
    }
}