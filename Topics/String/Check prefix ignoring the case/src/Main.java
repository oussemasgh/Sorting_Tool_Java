import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String word=scanner.next();
        Boolean startwithJ = null;

        System.out.println(word.startsWith("j") || word.startsWith("J"));
    }
}