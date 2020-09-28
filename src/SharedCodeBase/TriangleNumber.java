package SharedCodeBase;

public class TriangleNumber {

    public static long get(long n) {
        return n * (n + 1) / 2;
    }

    public static long reverse(long n) {
        long y = 1;
        while(get(y) != n) y++;
        return y;
    }
}
