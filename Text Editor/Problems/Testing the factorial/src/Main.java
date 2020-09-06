public long get(int x) {
    if (x < 0) {
        return -1;
    } else if (x == 1 || x == 0) {
        return 1;
    }
    return x * get(x - 1);
}