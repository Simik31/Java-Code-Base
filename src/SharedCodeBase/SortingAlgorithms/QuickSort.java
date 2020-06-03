package SharedCodeBase.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {

    public static void sort(ArrayList<Integer> list) {
        pivots(list);
    }

    private static ArrayList<Integer> pivots(ArrayList<Integer> list) {
        if(list.size() < 2) return list;
        int num, pivot = new Random().nextInt(list.size() - 1), on_pivot = list.get(pivot);
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i != pivot) {
                num = list.get(i);
                if (num < on_pivot) smaller.add(num);
                else bigger.add(num);
            }
        }
        list.clear();
        list.addAll(pivots(smaller));
        list.add(on_pivot);
        list.addAll(pivots(bigger));
        return list;
    }
}
