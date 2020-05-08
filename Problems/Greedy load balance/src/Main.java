import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        LoadBalancer balancer = new LoadBalancer();

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();
            String[] nums = input.split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            balancer.add(num1, num2);
        }

        balancer.print();
    }
}

class LoadBalancer {
    private LinkedList<Integer> list1;
    private LinkedList<Integer> list2;

    private int totalLoad1;
    private int totalLoad2;

    public LoadBalancer() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        totalLoad1 = 0;
        totalLoad2 = 0;
    }

    public void add(int num, int load) {
        if (totalLoad1 > totalLoad2) {
            totalLoad2 += load;
            list2.add(num);
        } else {
            totalLoad1 += load;
            list1.add(num);
        }
    }

    public void print() {
        for (Integer num : list1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (Integer num : list2) {
            System.out.print(num + " ");
        }
    }
}