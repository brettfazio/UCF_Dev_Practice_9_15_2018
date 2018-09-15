import java.util.Scanner;

public class change {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases =sc.nextInt();
		
		for (int i =0 ; i < cases; i++) {
			int in = sc.nextInt();
			
			int q = 0;
			int d =0;
			int n = 0;
			int p =0;
			
			while (in >= 25) {
				in -= 25;
				q++;
			}
			while (in >= 10) {
				in -= 10;
				d ++;
			}
			while (in >= 5) {
				in -= 5;
				n++;
			}
			while (in >= 1) {
				in -= 1;
				p++;
			}
			
			System.out.printf("%d %d QUARTER(S), %d DIME(S), %d NICKEL(S), %d PENNY(S)%n",i+1,q,d,n,p);
		}
	}

}

/*

3
124
25
194

*/
