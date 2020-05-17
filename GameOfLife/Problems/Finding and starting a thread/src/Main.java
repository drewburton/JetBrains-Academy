public static void findAndStartThread(Thread... threads) throws InterruptedException {
    for (Thread T : threads) {
        if (T.getState() == Thread.State.NEW) {
            T.start();
            T.join();
        }
    }
}
