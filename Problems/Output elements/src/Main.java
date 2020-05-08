// Posted from EduTools plugin
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        // write your code here
        for (String item : nameSet) {
            System.out.println(item);
        }
    }
}
