import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       ArrayList<Integer> intArray=new ArrayList<>();
        int n=scanner.nextInt();



        while(n!=0){

            intArray.add(n);
            n=scanner.nextInt();

        }
        System.out.println(intArray.size());
    }
}