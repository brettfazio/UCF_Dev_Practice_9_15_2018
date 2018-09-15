import java.util.Scanner;

public class centroid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = 1;
		
		while (sc.hasNext()) {
			int n = sc.nextInt();
			
			if (n < 0) {
				return;
			}
			
			double[] x = new double[n];
			double[] y=  new double[n];
			double[] m = new double[n];
			
			for (int i =0 ; i < n; i++) {
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
				m[i] = sc.nextDouble();
			}
			
			double sx = 0;
			double sy = 0;
			double sm = 0;
			for (int i =0 ; i < n; i++) {
				sx += (x[i])*m[i];
				sy += (y[i])*m[i];
				sm += m[i];
			}
			
			double a = sx/ (sm);
			double b = sy / sm;
			
			System.out.printf("Case %d: %.2f %.2f%n", cases, a, b);
			cases++;
		}
	}

}

/*

3
1 1 10
22 1 10
1 31 10

3
10 10 100
20 20 50
10 40 30

-4


*/
