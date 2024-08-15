package HN_JV240617_HoangThiHaiYen_CoBan.ra.run;

public class Console {
    // Định nghĩa các mã màu
    public static final String RESET = "\033[0m"; // Reset to default color
    public static final String RED = "\033[31m"; // Red text
    public static final String GREEN = "\033[32m"; // Green text
    public static final String YELLOW = "\033[33m"; // Yellow text
    public static final String BLUE = "\033[34m"; // Blue text
    public static final String MAGENTA = "\033[35m"; // Magenta text
    public static final String CYAN = "\033[36m"; // Cyan text
    public static final String WHITE = "\033[37m"; // White text

    public static void error(String msg) {
        System.out.println(RED + msg + RESET);
    }

    public static void message(String msg) {
        System.out.print(YELLOW + msg + RESET);
    }

    public static void exit(String msg) {
        System.out.print(BLUE + msg + RESET);
    }
}
