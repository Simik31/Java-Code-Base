package SharedCodeBase;

public class IsDigit {

    public static boolean check(String string_to_check) {
        try {
            Integer.parseInt(string_to_check);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
