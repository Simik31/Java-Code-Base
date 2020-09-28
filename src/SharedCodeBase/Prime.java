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

    public static boolean check_set(long[] set) {
        for (long value : set) if (!check(value)) return false;
        return true;
    }

    public static boolean check_set(ArrayList<Long> set) {
        for (long value : set) if (!check(value)) return false;
        return true;
    }

    public static boolean check_set(String[] set) {
        for (String value : set) if (!check(value)) return false;
        return true;
    }

    public static ArrayList<Long> get_bellow(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 2; i <= n; i++) if (check(i)) list.add(i);
        return list;
    }

    public static ArrayList<Long> get_in_range(long start, long end) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = start; i <= end; i++) if (check(i)) list.add(i);
        return list;
    }

    public static long get_n_th(long n) {
        int counter = 0, i;
        long ret = 0;
        for (i = 2; counter < n; i++)
            if (check(i)) {
                counter++;
                ret = i;
            }
        return ret;
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

    public static ArrayList<Integer> prime_divisors(int n) {
        ArrayList<Integer> divs = new ArrayList<>();
        for(int number = 2; number < n; number++) {
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

    public static boolean relative_prime(long n, long i) {
        ArrayList<Long> divs_n = prime_divisors(n);
        ArrayList<Long> divs_i = prime_divisors(i);
        for (long div : divs_n) if (divs_i.contains(div)) return false;
        return true;
    }

}
