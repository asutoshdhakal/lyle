import java.io.*;

public class SubjectManager {

	private String name;
	private int temp; 
	private SecurityLevel level;
	private String byteString;


	public SubjectManager(String name, SecurityLevel level) {
		this.name = name;
		this.level = level;
		this.byteString = "";
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

	public void run(int bit, PrintWriter outWriter) {
		if(byteString.length() < 8) {
			byteString = byteString + Integer.toString(bit);
		} else {
			outWriter.print((char) Integer.parseInt(byteString,2));
			byteString = Integer.toString(bit);
			// byteString = byteString + Integer.toString(bit);
		}
	}

}
