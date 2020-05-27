import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        for (String string : strings) {
            if (map.get(string) == null) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}