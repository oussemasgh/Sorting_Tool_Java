import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void changeList(List<String> list) {
        String longestString="";
        for (int i = list.size() - 1; i >= 0; i--) {
            if (longestString.length() < list.get(i).length())
                longestString = list.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, longestString);
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}