package SharedCodeBase;

public class COLOR {

    public static final String BLACK = "\033[0;90m";
    public static final String RED = "\033[0;91m";
    public static final String ORANGE = "\033[38;5;202m";
    public static final String GREEN = "\033[0;92m";
    public static final String YELLOW = "\033[0;93m";
    public static final String BLUE = "\033[0;94m";
    public static final String PURPLE = "\033[0;95m";
    public static final String CYAN = "\033[0;96m";
    public static final String WHITE = "\033[0;97m";

    public static final String RESET = "\033[0m";

    public static String[] toArray() {
        return new String[]{BLACK, RED, ORANGE, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, RESET};
    }

    public static String[] colorNamesToArray() {
        return new String[]{"BLACK", "RED", "ORANGE", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN", "WHITE", "RESET"};
    }
}
