import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        while (n>1){
            System.out.print(n+" ");
            n=n%2==1? n*3+1 : n/2;
        }
        System.out.print(n);
    }
}