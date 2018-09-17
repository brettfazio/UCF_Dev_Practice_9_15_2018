
import java.util.Scanner;

public class stock {

	static int days;
	static double fee, initm;
	static double[][] price;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int i=0; i < cases ;i ++) {

			days = sc.nextInt();
			fee = sc.nextDouble();
			initm = sc.nextDouble();

			price = new double[2][days];

			for (int j =0; j < 2; j++) {
				for (int a =0 ;a  <days; a++) {
					price[j][a] = sc.nextDouble();
				}
			}

			double res = dp(0,0,0,initm);

			System.out.printf("%.2f%n",res);

		}
	}

	static double dp(int day, int stock, int shares, double money) {

		if (day == days-1) {
			if (shares > 0) {
				money += price[stock][day]*shares;
				money -=fee;
			}
			return money;
		}

		//hold shares (or nothing)
		//sell shares
		//	hold money
		//	buy stock1
		//	buy stock2

		double max = 0;

		//hold shares (or nothing)
		max = Math.max(max, dp(day+1, stock, shares, money));

		//sell shares
		if (shares > 0) {
			money += price[stock][day]*shares;
			money -= fee;
			shares = 0;
			//hold money
			max = Math.max(max, dp(day+1,stock,0,money));
			
			int oppshares = (int)((money-fee)/price[1-stock][day]);
			max = Math.max(max, dp(day+1, 1-stock, oppshares,
					money-(oppshares*price[1-stock][day])-fee));
			
		}else {

			//buy stock1
			int shares0 = (int) ((money-fee)/ price[0][day]);
//			if (money - shares0*price[0][day]-fee >= 0) {
				max = Math.max(max, dp(day+1, 0, shares0, money-shares0*price[0][day]-fee));
//			}
			//buy stock2
			int shares1 = (int) ((money-fee) / price[1][day]);
//			if (money - shares1*price[1][day]-fee >= 0) {
				max = Math.max(max, dp(day+1, 1, shares1, money-shares1*price[1][day]-fee));
//			}
		}

		return max;


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
