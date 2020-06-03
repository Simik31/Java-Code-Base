package SharedCodeBase.SortingAlgorithms;

import java.util.ArrayList;

public class Bubble {

    public static void sort(ArrayList<Integer> list) {
        int tmp, n = list.size();
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n - i); j++) {
                if (list.get(j - 1) > list.get(j)) {
                    tmp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}