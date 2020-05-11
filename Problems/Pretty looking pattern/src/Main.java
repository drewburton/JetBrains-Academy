import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            for (int v = 0; v < lines.get(i).length() - 1; v++) {
                if (lines.get(i).charAt(v) == lines.get(i).charAt(v + 1)) {
                    //System.out.println(lines.get(i).charAt(v) + " " + lines.get(i).charAt(v + 1));
                    if (lines.get(i + 1).charAt(v) == lines.get(i + 1).charAt(v + 1)
                            && lines.get(i + 1).charAt(v + 1) == lines.get(i).charAt(v)) {
                        //System.out.println(lines.get(i + 1).charAt(v) + " " + lines.get(i + 1).charAt(v + 1));
                        System.out.println("NO");
                        return;
                    }
                }
                System.out.println();
            }
        }
        System.out.println("YES");
    }
}