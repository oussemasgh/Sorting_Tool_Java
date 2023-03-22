import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        SortedSet<Integer> setOfNumbers = new TreeSet<>(Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).boxed().toList());
        return setOfNumbers;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.retainAll(List.of(0,1,2,3,4,5,6,7,8,9,10));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}