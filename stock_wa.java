import java.util.Scanner;

public class stock_wa {

	static int days;
	static double fee,initm;

	static double[][] price;

	static double[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int scenarios = sc.nextInt();

		for (int i =0 ; i < scenarios; i++) {
			days = sc.nextInt();
			fee =sc.nextDouble();
			initm = sc.nextDouble();

			price = new double[2][days];
			memo = new double[days][3];
			for (int j =0 ; j < 2; j++) {
				for (int a =0 ;a < days; a++) {
					price[j][a] = sc.nextDouble();
				}
			}

			System.out.printf("%.2f%n",dp(0,initm,2,0));

		}
	}

	public static double dp(int day, double money, int stock, int shares) {
		double max =0 ;
//		System.out.println("start " + day + " " +money + " " +stock +" " + shares);
		//		System.out.println(day);
		if (day == days-1) {
			//			System.out.println("here");
			if (shares != 0) {
				money += price[stock][day]*shares;
				money -= fee;
			}
			return money;
		}
		if (day >= days) {
			return money;
		}

//		if (memo[day][stock] != 0) {
//			return memo[day][stock];
//		}

		max = dp(day+1, money, stock, shares);


		if (shares != 0) {
//			System.out.println("here");
			money += price[stock][day]*shares;
			money -= fee;
			shares = 0;
//			System.out.println("money after here = " + money);
			max = Math.max(max, dp(day+1,money,2,shares));
		}

		if (shares == 0) {
//			System.out.println("shares==0");
			int shares0 = (int) ((money)/price[0][day]);
			int shares1 = (int) ((money)/price[1][day]);
//			System.out.println(day + " money= " + money + " " +shares0 +" " +shares1);
			if(money-fee-shares0*price[0][day]>=0) {
				max = Math.max(max, dp(day+1,money-fee-shares0*price[0][day],0,shares0));
			}
			if(money-fee-shares1*price[1][day]>=0) {
//				System.out.println("sec " + shares1);
				max = Math.max(max, dp(day+1,money-fee-shares1*price[1][day],1,shares1));
			}
		}
		return memo[day][stock] = max;
	}

}

/*

2
3 50.00 10000.00
759.68 765.74 770.17
443.00 457.82 457.04
2 5.99 29999.99
59.99 58.99
22.67 20.73

 */
