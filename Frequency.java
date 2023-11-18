import java.util.Scanner;

public class Frequency
 {
    private static int[] numbers;
    private static int[] array;
    public static void FrequentNumbers(int[] numbers,int threshold)
    {
         array = numbers;

        sorter();
        // Print the top K frequent numbers
        for (int i = 0; i < threshold; i++) {
        System.out.print(array[i] + " ");
         }
        
        System.out.println();
        
        
    }

    private static void sorter() {
        int n = array.length;
        for(int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                int freq_compare = Freq_Counter(array[j+1]) - Freq_Counter(array[j]);
                if((freq_compare == 0 && array[j+1] > array[j]) || freq_compare == 0) 
                {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }

    public static int Freq_Counter(int num)
    {
        int count = 0;
        for(int i = 0 ; i < array.length; i++)
        {
            if(array[i] == num)
            count++;
        }
        return count;
    }

    public static void readNumber(int lim)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < lim; i++)
        {
            numbers[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Frequency fc = new Frequency();
        /*System.out.println("Enter the limit of the array:");
        int limit = sc.nextInt();
        // if(k < 0) {System.out.println("Enter a positive number.");} else {exit}
        System.out.println("Enter the numbers:");
        readNumber(limit);
        System.out.println("Enter the frequency threshold value:");
        int k = sc.nextInt();
        System.out.println("The Frequency in the array is:");*/
        int[] numbers = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        FrequentNumbers(numbers,k);
        sc.close();
    }
}
