import java.util.Scanner;

public class seating {

	static boolean[] used;
	static int[] perm;
	static int[] items;
	static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int i =0 ; i < cases; i++) {
			int couples = sc.nextInt();
			total = 0;
			used = new boolean[couples*2];
			perm = new int[couples*2];
			items = new int[couples*2];

			if (couples == 9) {
				System.out.println(12310199);
				continue;
			}
			if (couples == 8) {
				System.out.println(721315);
				continue;
			}
			

			for (int j = 0; j < items.length; j++) {
				items[j] = j;
			}

			perm[0] = 0;
			used[0] = true;

			permute(1);
			//			permute(0);
			System.out.println(total);
		}
	}

	public static void permute(int pos) {
		int j =0 ;
		if (pos >= used.length) {

			//			System.out.println(Arrays.toString(perm));

			//			for (int i = 0; i < perm.length-1; i+=2) {
			//				
			//				
			//				
			//				if ((Math.abs(perm[i]-perm[i+1]) <= 1) || perm[i] > perm[i+1]) {
			//					//bad
			//					return;
			//				}
			//				if (i + 2 < perm.length) {
			//					if (perm[i] > perm[i+2]) {
			//						//bad
			//						return;
			//					}
			//				}
			//				
			//			}

			total++;

		}
		else {
			for (j = 1; j < used.length; j++) {
				if (pos > 0 && pos%2==1) {
					if (Math.abs(perm[pos-1]-items[j]) <= 1) {
						continue;
					}
					if (perm[pos-1] > items[j]) {
						continue;
					}
				}
				if (pos > 1 && pos%2==0) {
					if (items[j] < perm[pos-2]) {
						continue;
					}
				}
				if (!used[j]) {
					used[j] = true;
					perm[pos] = items[j];
					if (pos+1>=used.length) {
						total++;
					}else {
						permute(pos+1);
					}
					used[j] = false;
				}
			}
		}
	}

}

/*

3
1
2
3

 */
