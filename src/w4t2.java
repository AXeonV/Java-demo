import java.util.Scanner;
public class w4t2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		int month = in.nextInt();
		String monthName = "";
		int days = 0;
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		switch (month) {
			case 1:
				monthName = "Janurary";
				days = 31;
				break;
			case 2:
				monthName = "February";
				days = isLeapYear ? 29 : 28;
				break;
			case 3:
				monthName = "March";
				days = 31;
				break;
			case 4:
				monthName = "April";
				days = 30;
				break;
			case 5:
				monthName = "May";
				days = 31;
				break;
			case 6:
				monthName = "June";
				days = 30;
				break;
			case 7:
				monthName = "July";
				days = 31;
				break;
			case 8:
				monthName = "August";
				days = 31;
				break;
			case 9:
				monthName = "September";
				days = 30;
				break;
			case 10:
				monthName = "October";
				days = 31;
				break;
			case 11:
				monthName = "November";
				days = 30;
				break;
			case 12:
				monthName = "December";
				days = 31;
				break;
			default:
				System.out.println("error!!!");
				break;
		}
		System.out.printf("%s of %d has %d days.%n", monthName, year, days);
	}
}