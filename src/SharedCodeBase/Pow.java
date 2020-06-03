package SharedCodeBase;

public class Pow {

    public static long Long(long a, long b) {
        long result = 1;
        while(b > 0) {
            if (b % 2 != 0) {
                result *= a;
                b--;
            }
            a *= a;
            b /= 2;
        }
        return result;
    }
}
