public static BigInteger calcDoubleFactorial(int n) {
    BigInteger answer = new BigInteger("1");
    for (int i = 1; i <= n; i++) {
        if (n % 2 == 0 && i % 2 == 0) {
            answer = answer.multiply(new BigInteger(i + ""));
        } else if (n % 2 == 1 && i % 2 == 1) {
            answer = answer.multiply(new BigInteger(i + ""));
        }
    }
    return answer;
}
