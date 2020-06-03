package SharedCodeBase;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger BigInteger(long n) {
        if(n == 0) return BigInteger.ONE;
        return new BigInteger(String(n - 1)).multiply(BigInteger.valueOf(n));
    }

    public static String String(long n) {
        if(n == 0) return "1";
        return BigInteger(n).toString();
    }

    public static int Integer(long n) {
        if(n == 0) return 1;
        return BigInteger(n).intValueExact();
    }

    public static long Long(long n) {
        if(n == 0) return 1;
        return BigInteger(n).longValueExact();
    }
}
