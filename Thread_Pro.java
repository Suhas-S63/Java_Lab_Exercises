// importing necessary modules
import java.util.*;

class Thread1 extends Thread
{
    public void run()
    {
        System.out.println("Welcome to Java Programming Practical Test 2");
    }
}

class Thread2 extends Thread
{
    public void run()
    {

    }
}

class Thread3 extends Thread
{
    private String str1;
    private String str2;

    public Thread3(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public void run() {
        check();
    }

    private void check() {
        char[] Array1 = str1.toCharArray();
        char[] Array2 = str2.toCharArray();

        Arrays.sort(Array1);
        Arrays.sort(Array2);

        boolean isSame = Arrays.equals(Array1, Array2);

        System.out.println("Are the strings '" + str1 + "' and '" + str2 + "' anagrams? " + isSame);
    }

}
class Thread_Pro extends Thread
{
    public static void main(String[] args)
    {
        
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3("christ","stirch");

        t1.start();
        t3.start();

    }
}