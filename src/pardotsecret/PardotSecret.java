
package pardotsecret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alan Lee
 * @datetime Jun. 9, 2016
 */
public class PardotSecret {
    /**
     * Calculates prime numbers up to upper limit of finalValue
     * @param finalValue int The upper limit for finding prime numbers
     * @return List<Integer> The list of prime numbers up to finalValue
     */
    public static List<Integer> calculatePrimes(int finalValue) {
        boolean[] isPrime = new boolean[finalValue + 1]; 
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i <= Math.sqrt(finalValue); i++) { 
            if (isPrime[i]) {
                for (int j = i; i * j <= finalValue; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= finalValue; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
    /**
     * Creates a map of values using the secret() function
     * @param primes List<Integer>
     * @return List<Integer>
     */
    public static List<Integer> secretPrimes(List<Integer> primes) { 
        final List<Integer> secretValues = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            secretValues.add(secret(primes.get(i)));
        }
        return secretValues;
    }
    /**
     * The secret function to be tested
     * @param valueToSecret int
     * @return int 
     */
    public static int secret(int valueToSecret) { 
        int secret = (valueToSecret * 2) + 1;
        return secret;
    }
    /**
     * Determines the additivity of the secret() function
     * @param secretPrimes List<Integer>
     * @return boolean
     */
    public static boolean determineAdditivity(List<Integer> primes, List<Integer> secretPrimes) {
        for (int i = 0; i < primes.size(); i++) {
            for (int j = 0; j < primes.size(); j++) {
                int left = secret(primes.get(i) + primes.get(j));
                int right = secretPrimes.get(i) + secretPrimes.get(j);
                if (left != right) { 
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int finalValue;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a positive integer " + 
                           "greater than 1: ");
        while (!input.hasNextInt()) {
            System.out.println("The input is invalid.\n" +
                               "Please input a positive integer " + 
                               "greater than 1: ");
            input.next();
        }
        long startTime = System.currentTimeMillis();
        finalValue = input.nextInt();
        try {
            if (finalValue <= 1) {
                throw new IllegalArgumentException();
            }
            List<Integer> primes = calculatePrimes(finalValue);
            List<Integer> secretPrimes = secretPrimes(primes);
            System.out.println("\nThe list of primes under " + finalValue + " is: ");
            System.out.println(primes.toString());
            System.out.println("");
            if (determineAdditivity(primes, secretPrimes)) {
                System.out.println("The secret() function is additive.");
            }
            else {
                System.out.println("The secret() function is not additive.");
            }
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Runtime: " + totalTime + " ms");
        }
        catch (Exception ex) {
            System.out.println("The argument is invalid.");
            main(new String[0]);
        } 
    }
}
