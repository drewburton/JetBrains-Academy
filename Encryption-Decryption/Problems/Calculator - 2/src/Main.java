/* Please, do not rename it */
class Problem {
    public static void max(String[] args) {
       int max = Integer.parseInt(args[1]);
       for (int i = 2; i < args.length; i++) {
           int number = Integer.parseInt(args[i]);
           if (number > max) {
               max = number;
           }
       }
       System.out.println(max);
    }

    public static void min(String[] args) {
        int min = Integer.parseInt(args[1]);
        for (int i = 2; i < args.length; i++) {
            int number = Integer.parseInt(args[i]);
            if (number < min) {
                min = number;
            }
        }
        System.out.println(min);
    }

    public static void sum(String[] args) {
        int sum = Integer.parseInt(args[1]);
        for (int i = 2; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        String operator = args[0];
        switch (operator) {
            case "MAX": max(args);
                break;
            case "MIN": min(args);
                break;
            case "SUM": sum(args);
                break;
            default: break;
        }
    }
}