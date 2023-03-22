import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        String response;
        switch (n){
            case 1->response="Yes!";
            case 2->response="No!";
            case 3->response="No!";
            case 4->response="No!";
            default -> response="Unknown number";
        }
        System.out.println(response);
    }
}