import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max= scanner.nextInt();
        int n=1;
        int squareOfN=1;
        while(squareOfN<=max){

            System.out.println(squareOfN);

            n++;
            squareOfN=n*n;
        }
    }
}