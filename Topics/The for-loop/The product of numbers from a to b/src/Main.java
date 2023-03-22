import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int b= scanner.nextInt();
        int accumulator = 1;                   // (1)
        for (int i = a; i <  b; i++) {   // (2)
            accumulator *= i;                  // (3)
        }
        System.out.println(accumulator);
    }
}