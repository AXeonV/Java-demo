import java.util.Objects;
import java.util.Scanner;

public class User {
	private String account;
	private String password;
	private double money;

	public void setUser(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void introduce() {
		System.out.printf("%s's account has a balance of %.2f dollar\n", account, money);
	}

	public void withdraw(double money) {
		System.out.printf("Plan to withdraw %.2f, ", money);
		if (this.money >= money) {
			System.out.println("okay");
			int timeLeft = 3;
			while (timeLeft-- > 0) {
				System.out.println("Please input your password:");
				Scanner input = new Scanner(System.in);
				String password = input.nextLine();
				if (this.password.equals(password)) {
					this.money -= money;
					System.out.printf("Withdraw %.2f dollar and balance is %.2f dollar\n", money, this.money);
					return;
				}
				System.out.printf("password error,there are %d times left to try\n", timeLeft);
			}
		} else System.out.println("but no sufficient balance");
	}

	public void deposit(double money) {
		this.money += money;
		System.out.printf("Got %.2f as income, balance is %.2f dollar\n", money, this.money);
	}
}
