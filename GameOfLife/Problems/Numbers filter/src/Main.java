class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            if (scanner.hasNext()) {
                int num = Integer.parseInt(scanner.nextLine());
                if (num == 0) {
                    break;
                } else if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
        }
    }
}