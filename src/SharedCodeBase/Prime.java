package SharedCodeBase;

import java.util.ArrayList;

public class Prime {

    public static boolean check(long number) {
        if(number == 1) return false;
        if(number == 2) return true;
        for (int i = 2; i <= Math.sqrt(number) + 1; i++) if (number % i == 0) return false;
        return true;
    }

    public static boolean check(String number) {
        return check(Long.parseLong(number));
    }

    public static ArrayList<Long> get_bellow(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 2; i <= n; i++) if (SharedCodeBase.Prime.check(i)) list.add(i);
        return list;
    }

    public static Long biggest_prime_divisor(long n) {
        for(long number = 2; number < n; number++) if(n % number == 0) n /= number;
        return n;
    }

    public static ArrayList<Long> prime_divisors(long n) {
        ArrayList<Long> divs = new ArrayList<>();
        for(long number = 2; number < n; number++) {
            if(check(number)) {
                if (n % number == 0) {
                    divs.add(number);
                    n /= number;
                }
            }
        }
        if(!divs.contains(n) && check(n)) divs.add(n);
        return divs;
    }

}
