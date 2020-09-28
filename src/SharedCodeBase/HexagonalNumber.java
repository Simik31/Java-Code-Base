package SharedCodeBase;

public class HexagonalNumber {

    public static long get(long n) {
        return n * (2 * n - 1);
    }

    public static long reverse(long n) {
        long y = 1;
        while(get(y) != n) y++;
        return y;
    }
}
