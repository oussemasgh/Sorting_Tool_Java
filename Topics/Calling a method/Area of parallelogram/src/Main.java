import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int b= scanner.nextInt();
        int h=scanner.nextInt();
        countAreaOfParallelogram(b,h);
        method();
        method(1, 2, 3);
        method(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
        method(new int[] { 1, 2, 3 });
        char[] array = new char[0];
        char[] array1 = { 'a', 'b', 'c', 'd' };
        char[] array2 = new char[1];
        System.out.println(array+ " "+array1+" "+array2);

    }
    public static int method(int[] array, int... vararg) { return 1; }
    // Do not change code below   
    public static void countAreaOfParallelogram(int b, int h) {
        System.out.println(b * h);
    }
}