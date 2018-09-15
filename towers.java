import java.util.Scanner;

public class towers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		while (sc.hasNext()) {
			int move = sc.nextInt();
			int disks = sc.nextInt();
			
			if (move == 0 && disks == 0) {
				return;
			}
			
			
		}
	}
	
	
	static void solve(int count, char s, char d, char i) {
		if (count == 1) {
			System.out.printf("move top disc from pole %c to pole %c\n",s,d);
		}else {
			solve(count-1,s,i,d);
			solve(1,s,d,i);
			solve(count-1,i,d,s);
		}
	}

}
