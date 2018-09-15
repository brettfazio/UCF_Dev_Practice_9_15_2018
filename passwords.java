import java.util.Scanner;

public class passwords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i =0 ; i < cases; i++) {
			
			int length = sc.nextInt();
			
			char[][] in = new char[length][];
			
			for (int j =0 ; j < length; j++) {
				in[j] = sc.next().toCharArray();
			}
			
			int placement = sc.nextInt();
			
			int[] location = new int[length];
			
			for (int j = 1; j < placement; j++) {
				location[length-1]++;
				
				int pos = length-1;
				
				while (location[pos] == in[pos].length) {
					location[pos] = 0;
					pos--;
					location[pos]++;
				}
			}
			
			for (int j =0; j < length; j++) {
				System.out.print(in[j][location[j]]);
			}
			System.out.println();
			
		}
	}
	
}

/*

2
3
abc
xy
dmnr
10
2
abcdefghijklmnopqrstuvwxyz
abcdefghijklmnopqrstuvwxyz
676


*/
