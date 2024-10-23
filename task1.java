

public class SumRationalNumbers {
    public static void main(String[] args) {
        int n = 10; // Replace with the desired number of terms
        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += (double) 1 / i; // Sum of reciprocals (1/1 + 1/2 + 1/3 + ... + 1/n)
        }

        System.out.println("Sum of first " + n + " rational numbers is: " + sum);
    }

}