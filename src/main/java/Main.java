import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your balance?");
        double theBalance = scanner.nextDouble();
        System.out.println("What is the APR on the card (as a percent)?");
        double theAPR = scanner.nextDouble();
        System.out.println("What is the monthly payment you can make?");
        double theMonthlyPay = scanner.nextDouble();
        calculateMonthsUntilPaidOff(theBalance, theAPR, theMonthlyPay);
    }

    private static void calculateMonthsUntilPaidOff(double balance, double APR, double monthlyPay)
    {
        double i = (APR/100)/365;
        double theFirst =Math.log(1+((balance/monthlyPay)*(1-(Math.pow((1+i),30)))));
        double theSecond = Math.pow((1 + i),30);
        double numMonths = -(theFirst/theSecond) * 100;
        System.out.printf("It will take you %.2f months to pay off this card.",numMonths);
    }
    /*
                n = -(1/30) * log(1 + b/p * (1 - (1 + i)^30)) / log(1 + i)

        n is the number of months.
        i is the daily rate (APR divided by 365).
                b is the balance.
                p is the monthly payment.
        Example Output
        What is your balance? 5000
        What is the APR on the card (as a percent)? 12
        What is the monthly payment you can make? 100
        It will take you 70 months to pay off this card.

     */
}
