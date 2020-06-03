package SharedCodeBase;

import java.math.BigInteger;

public class Palindromic {
    public static boolean check(String num) {
        for(int i = 0; i < num.length(); i++) if(!num.substring(i, i + 1).equals(num.substring(num.length() - i - 1, num.length() - i))) return false;
        return true;
    }

    public static boolean check(int num) {
        return check(String.valueOf(num));
    }

    public static boolean check(long num) {
        return check(String.valueOf(num));
    }

    public static boolean check(BigInteger num) {
        return check(num.toString());
    }
}
