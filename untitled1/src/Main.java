import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            n = getCents();

            if (n >= 0) {
                int finalValue = calculateDimes(n) + calculateQuarters(n) + calculateNickels(n) + calculatePennies(n);
                System.out.println("Change owed: " + n);
                System.out.println(finalValue);
            } else {
                System.out.println("ERROR, enter positive value or 0");
            }
        } while (n < 0);

        scanner.close();
    }

    public static int getCents() {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter value:");
        return x.nextInt();
    }

    public static int calculateQuarters(int n)  {
        int quarterValue = 25;
        int quarters = 0;

        while (n >= quarterValue) {
            n -= quarterValue;
            quarters++;
        }

        return quarters;
    }

    public static int calculateDimes(int n)  {
        int dimeValue = 10;
        int dimes = 0;
        n = n - 25 * calculateQuarters(n);

        while (n >= dimeValue && n < 25) {
            n -= dimeValue;
            dimes++;
        }
        return dimes;
    }

    public static int calculateNickels(int n)  {
        int nickleValue = 5;
        int nickels = 0;
        n = n - 25 * calculateQuarters(n) - 10 * calculateDimes(n);

        while (n >= nickleValue && n < 10) {
            n -= nickleValue;
            nickels++;
        }
        return nickels;
    }

    public static int calculatePennies(int n)  {
        int pennyValue = 1;
        int pennies = 0;
        n = n - 25 * calculateQuarters(n) - 10 * calculateDimes(n) - 5 * calculateNickels(n);

        while (n >= pennyValue && n < 5) {
            n -= pennyValue;
            pennies++;
        }
        return pennies;
    }
}
