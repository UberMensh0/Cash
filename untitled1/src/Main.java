import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            n = getCents();

            if (n >= 0) {
                int finalValue = calculateDimes(n) + calculateQuarters(n) + calculateNickels(n) + calculatePennies(n);
                System.out.println("Change owned: " + n);
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
        int quarters = 0;

        while (n >= 25) {
            n -= 25;
            quarters++;
        }

        return quarters;
    }
    public static int calculateDimes(int n)  {
        int dimes = 0;
        n = n - 25 * calculateQuarters(n);

        while (n >= 10 && n < 25) {
            n -= 10;
            dimes++;
        }
        return dimes;
    }
    public static int calculateNickels(int n)  {
        int nickels = 0;
        n = n - 25 * calculateQuarters(n) - 10 * calculateDimes(n);

        while (n >= 5 && n < 10) {
            n -= 5;
            nickels++;
        }
        return nickels;
    }
    public static int calculatePennies(int n)  {
        int pennies = 0;
        n = n - 25 * calculateQuarters(n) - 10 * calculateDimes(n) - 5 * calculateNickels(n);

        while (n >= 1 && n < 5) {
            n -= 1;
            pennies++;
        }
        return pennies;
    }
}
