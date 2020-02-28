public class SecurityLevel {

	public static int high = 1;
	public static int low = 0;
	public int level;


	public SecurityLevel(int value) {
		if(value == 1) {
			this.level = high;
		} else {
			this.level = low;
		}
	} 
}