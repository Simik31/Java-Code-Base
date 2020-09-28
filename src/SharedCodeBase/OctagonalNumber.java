package SharedCodeBase;

public class OctagonalNumber {

    public static long get(long n) {
        return n * (3 * n - 2);
    }

    public static long reverse(long n) {
        long y = 1;
        while(get(y) != n) y++;
        return y;
    }
}
