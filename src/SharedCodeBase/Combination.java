package SharedCodeBase;

import java.math.BigInteger;

public class Combination {

    public static BigInteger BigInteger(long n, long r) {
        return Factorial.BigInteger(n).divide(Factorial.BigInteger(r).multiply(Factorial.BigInteger(n - r)));
    }

}
