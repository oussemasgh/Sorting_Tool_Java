import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        String basicText="You have chosen a ";
        switch (n) {
            case 1 -> basicText += "square";
            case 2 -> basicText += "circle";
            case 3 -> basicText += "triangle";
            case 4 -> basicText += "rhombus";
            default -> basicText = "There is no such shape!";
        }
        System.out.println(basicText);
    }
}