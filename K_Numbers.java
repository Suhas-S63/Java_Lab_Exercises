import java.util.Scanner;

public class K_Numbers {

    static void Compute_K_Freq_Num(int[] array, int size, int k) {
        int[] num_freq_array = new int[size];

        // Count the frequency of each number
        for (int i = 0; i < size; i++) {
            num_freq_array[array[i]]++;
        }

        // Create an array to store unique numbers
        int[] unique_num_array = new int[size];
        int count = 0;
        for (int i = 0; i < num_freq_array.length; i++) {
            if (num_freq_array[i] > 0) {
                unique_num_array[count++] = i;
            }
        }

        // Custom sorting based on frequency and then on the key in descending order
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int num1 = unique_num_array[j];
                int num2 = unique_num_array[j + 1];

                if (num_freq_array[num1] < num_freq_array[num2] || (num_freq_array[num1] == num_freq_array[num2] && num1 < num2)) {
                    unique_num_array[j] = unique_num_array[j] ^ unique_num_array[j + 1];
                    unique_num_array[j + 1] = unique_num_array[j] ^ unique_num_array[j + 1];
                    unique_num_array[j] = unique_num_array[j] ^ unique_num_array[j + 1];
                }
            }
        }

        System.out.print(k + " numbers with most occurrences are: ");
        for (int index = 0; index < k && index < unique_num_array.length; index++) {
            System.out.print(unique_num_array[index] + " ");
        }
    }

    public static void readNumber(int lim) {
        int numbers[] = new int[lim];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < lim; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int N = numbers.length;
        int K = 2;

        // Alternatively, you can call the readNumber method if you want to read input from the user
        // K_Numbers.readNumber(N);

        // Function call
        Compute_K_Freq_Num(numbers, N, K);
        sc.close();
    }
}
