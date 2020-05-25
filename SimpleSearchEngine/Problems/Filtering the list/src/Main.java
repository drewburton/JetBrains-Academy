import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> list = Arrays.asList(line.split("\\s"));
        ArrayList<String> newList = new ArrayList<>(list);
        for (int i = 0; i < newList.size(); i++) {
            if (i % 2 == 0) {
                newList.set(i, "");
            }
        }
        Collections.reverse(newList);
        for (String element : newList) {
            if (!"".equals(element)) {
                System.out.print(element + " ");
            }
        }
    }
}