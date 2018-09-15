import java.util.Scanner;

public class swan {

	static int k;
	static double angle,speed;

	static Lior[] items;
	static Lior[] perm;
	static boolean[] used;

	static double min;

	static double[][] dis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int i =0 ; i < cases; i++) {

			min = Integer.MAX_VALUE;

			k = sc.nextInt();
			angle = sc.nextInt();
			speed = sc.nextInt();

			items = new Lior[k];
			perm = new Lior[k];
			used = new boolean[k];

			for (int j =0 ; j < k; j++ ) {
				items[j] = new Lior(sc.nextDouble(),sc.nextDouble(),j);
			}

			dis = new double[k+1][k+1];

			for (int a = 0; a < k;a ++) {
				for (int b =0; b < k; b++) {
					dis[a][b] = dis[b][a] = distance(items[a].angle,items[a].dis,items[b].angle,items[b].dis);
				}
			}
			for (int a= 0; a < k; a++) {
				dis[k][a] = dis[a][k] = distance(angle,1000.0,items[a].angle,items[a].dis);
			}

			permute(0);
//			System.out.println("ANSWER EIS BELOW DSFKJSDLFJ SKDJ FLSD");
			System.out.printf("%.2f%n", min/speed);

		}
	}

	public static double distance(double a1, double d1, double a2, double d2) {

		a1 = Math.toRadians(a1);
		a2 = Math.toRadians(a2);

		double x1 = Math.cos(a1)*d1;
		double y1 = Math.sin(a1)*d1;
		//		System.out.println(a1 +" " + d1 + " " + x1 +" " + y1);
		double x2 = Math.cos(a2)*d2;
		double y2 = Math.sin(a2)*d2;

		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));

	}

	public static void permute(int pos) {
		int j =0 ;
		if (pos >= used.length) {

			double current = 0;

			current += dis[k][perm[0].og];
			//			System.out.println(perm[0].og + " " + perm[0].dis + " " + perm[0].angle);
			//			System.out.println("k -> perm[0].og = " + dis[k][perm[0].og] + " " + distance(angle,1000.0,perm[0].angle,perm[0].dis));
			//			current += distance(angle,1000.0,perm[0].angle,perm[0].dis);

			for (int i =0; i < perm.length-1; i++) {
				current += dis[perm[i].og][perm[i+1].og];
				//				current += distance(perm[i].angle, perm[i].dis, perm[i+1].angle, perm[i+1].dis);
			}

			current += dis[perm[perm.length-1].og][k];
			//			current += distance(perm[perm.length-1].angle,perm[perm.length-1].dis,angle,1000.0);

			min = Math.min(current, min);
		}
		else {
			for (j = 0; j < used.length; j++) {
				if (!used[j]) {
					used[j] = true;
					perm[pos] = items[j];
					permute(pos+1);
					used[j] = false;
				}
			}
		}
	}

}

class Lior {

	double dis;
	double angle;
	int og;
	public Lior(double d, double a, int o) {
		dis = d;
		angle = a;
		og = o;
	}

}

/*

2
1 0 100
1000 180
5 90 10
80 30
1000 180
280 40
678 235
995 209

1
10 0 100
10 50
400 355
200 10
150 50
1000 180
500 77
10 5
6 7
400 90
300 200

 */
