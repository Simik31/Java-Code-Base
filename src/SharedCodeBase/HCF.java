package SharedCodeBase;

import java.util.ArrayList;

public class HCF
{
    public static boolean check(long a, long b)
    {
        ArrayList<Long> primes = Prime.get_bellow(a);
        for (long prime : primes) if (prime < a) if (a % prime == 0 && b % prime == 0) return false;
        return true;
    }

    public static boolean check(long a, long b, ArrayList<Long> primes)
    {
        for (long prime : primes) if (prime < a) if (a % prime == 0 && b % prime == 0) return false;
        return true;
    }
}
