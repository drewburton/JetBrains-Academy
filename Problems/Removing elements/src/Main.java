// Posted from EduTools plugin
import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] nums = str.split("\\s+");
        HashSet<Integer> list = new HashSet<>();
        for (String num : nums) {
            list.add(Integer.parseInt(num));
        }
        return list;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(e -> e > 10);
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