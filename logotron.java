import java.util.Arrays;
import java.util.Scanner;

public class logotron {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);

		int cases = sc.nextInt();

		for (int i =0; i < cases; i++) {
			int robots = sc.nextInt();
			int statements = sc.nextInt();

			int[] r1 = new int[statements];
			int[] r2 = new int[statements];
			char[] type = new char[statements];

			for (int j = 0; j < statements; j++) {
				r1[j] = sc.nextInt()-1;
				r2[j] = sc.nextInt()-1;
				type[j] = sc.next().charAt(0);
			}

			int poss =0;

			for (int subset = 0; subset < (1 << robots); subset++) {

				boolean good = true;

				char[] gen = new char[robots];
				
				for (int k =0 ; k < robots; k++) {
					int res = subset&(1 <<k);
//					System.out.println(Integer.toBinaryString(subset) + " "+Integer.toBinaryString(i<<k));
					if (res != 0) {
						//robot is T
						gen[k] ='T';
					}else {
						//robot is C
						gen[k] = 'C';
					}
				}
//				System.out.println(Arrays.toString(gen));
				for (int j = 0; j < statements; j++) {
					if (gen[r1[j]] == 'T') {
						if (gen[r1[j]] == 'T' && gen[r2[j]]==type[j]) {
							//good
						}else {
							good = false;
							break;
						}
					}
					if (gen[r1[j]] == 'C') {
						if (gen[r1[j]] == 'C' && gen[r2[j]]==type[j]) {
							good = false;
							break;
						}else {
							//good
						}
					}
				}
				
				if (good) {
					poss++;
				}

			}

			System.out.printf("Case #%d: %d%n", i+1,poss);


		}
	}

}

/*

3
3 2
1 2 T
2 3 C
4 2
1 2 T
2 3 C
2 0


*/