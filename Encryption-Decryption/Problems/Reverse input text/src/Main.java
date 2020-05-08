import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
           int input = reader.read();
           StringBuilder output = new StringBuilder();
           while (input != -1) {
              output.append((char) input);
              input = reader.read();
           }
           System.out.println(output.reverse().toString());

        }
    }
}