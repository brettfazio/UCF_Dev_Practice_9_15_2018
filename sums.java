import java.util.Scanner;

public class sums {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i =0 ; i <cases; i++) {
			int points = sc.nextInt();
			
			int sum =0 ;
			
			for (int j = 1; j <= points; j++) {
				sum += j * (((j+1)*(j+2))/2);
			}
			
			System.out.println((i+1) + " " + points +" " +sum);
		}
	}

}

/*

4
3
4
5
10

*/