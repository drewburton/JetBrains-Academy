class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.matches(".*[a-z].*")) {
                    System.out.println(line.toUpperCase());
                } else {
                    System.out.println("FINISHED");
                    break;
                }
            }
        }
    }
}