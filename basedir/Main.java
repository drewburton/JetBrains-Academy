import java.io.File;

class Main {
    public static void main(String[] args) {
        basedir2();
    }

    public static void basedir1() {
        File home = new File("basedir");

        File biggestDirectory = null;
        int max = 0;
        for (File file : home.listFiles()) {
            int size = file.listFiles().length;
            if (size > max) {
                max = size;
                biggestDirectory = file;
            }
        }

        System.out.println("dir" + biggestDirectory + " " + max);
    }

    public static void basedir2() {
        File home = new File("basedir2");

        System.out.println(search(home, 0));
    }

    private static Info search(File file, int depth) {
        File[] list = file.listFiles();
        if (list.length == 0) {
            Info info = new Info();
            info.name = "null";
            info.depth = 0;
            return info;
        }

        File[] subFiles = new File[list.length];
        int n = 0;

        // save all directories inside of current
        for (File subFile : list) {
            if (subFile.isDirectory()) {
                subFiles[n++] = subFile;
            }
        }

        // has any sub-directories
        if (n > 0) {
            Info max = null;

            // search each directory and find the deepest file
            for (int i = 0; i < n; i++) {
                if (max == null) {
                    max = search(subFiles[i], depth + 1);
                    continue;
                }

                Info next = search(subFiles[i], depth + 1);
                if (next.depth > max.depth) {
                    max = next;
                }
            }
            return max;
        } else {
            Info info = new Info();
            info.name = list[0].getName();
            info.depth = depth;

            return info;
        }
    }

    private static class Info {
        String name;
        int depth;

        @Override
        public String toString() {
            return name + " " + depth;
        }
    }
}