import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // Get the frequency of the value in both lists
        int count1 = Collections.frequency(list1, elem);
        int count2 = Collections.frequency(list2, elem);

        // Return true if the counts are equal, false otherwise
        return count1 == count2;
    }
}