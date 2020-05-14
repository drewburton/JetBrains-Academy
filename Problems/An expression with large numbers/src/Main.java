import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] nums = line.split("\\s");

        BigInteger[] bigNums = new BigInteger[4];
        for (int i = 0; i < 4; i++) {
            bigNums[i] = new BigInteger(nums[i]);
        }

        System.out.println(bigNums[0].negate().multiply(bigNums[1]).add(bigNums[2]).subtract(bigNums[3]));
    }
}