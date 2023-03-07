import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 8, 9};
        Main.comparisonAverage(arr1);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the shift value: ");
        int shift = in.nextInt();
        double[] arr2 = new double[4+shift];
        for (int i = 0; i < arr2.length-shift; i++) {
            System.out.println("Enter the value of "+(i+1)+" element of the array: ");
            arr2[i] = in.nextDouble();
        }
        Main.shiftRight(arr2, shift);

        Boolean result1 = Main.isPangram(" The quick brown fox jumps over the lazy dog is a pangram");
        System.out.println("The result 1 is: "+result1);

        Boolean result2 = Main.isPangram(" The quick brown");
        System.out.println("The result 2 is: "+result2);

    }

    public static void comparisonAverage(int[] n) {
        double average = 0;
        for (int i = 0; i < n.length; i++) {
            average += n[i];
        }
        average /= n.length;

        double k = 0;
        for (int i = 0; i < n.length; i++) {
            if(n[i] > average) k++;
        }
        System.out.println("Percentage of numbers larger than average: "+Math.round((k / n.length)*100)+"%");
    }

    public static void shiftRight(double[] array, int shift) {
        System.out.println("Input array:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int k = array.length-1;
        int b = array.length -1 - shift;
        for (int i = 0; i < array.length; i++) {
            if(b<0 && k>=0) {
                array[k] = 0.0;
                k--;
                b--;
            }
            else if(b<0 && k<0) break;
            else {
                array[k] = array[b];
                k--;
                b--;
            }
        }

        System.out.println("Output array:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static boolean isPangram(String str) {
        if (str == null) {
            return false;
        }
        Boolean[] alphabetMarker = new Boolean[26];
        Arrays.fill(alphabetMarker, false);
        int alphabetIndex = 0;
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                alphabetIndex = str.charAt(i) - 'A';
                alphabetMarker[alphabetIndex] = true;
            }
        }
        for (boolean index : alphabetMarker) {
            if (!index) {
                return false;
            }
        }
        return true;
    }
}