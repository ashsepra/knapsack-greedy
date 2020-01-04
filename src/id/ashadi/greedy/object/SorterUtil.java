package id.ashadi.greedy.object;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SorterUtil {

    public List<Knapsack> sortByWeight(int mode, List<Knapsack> knapsacks) {
        Comparator<Knapsack> compareValue = new Comparator<Knapsack>() {
            @Override
            public int compare(Knapsack o1, Knapsack o2) {
                if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                } else if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                }
                return 0;
            }
        };

        if (mode == 0) {// ascending
            Collections.sort(knapsacks, compareValue);
        } else {// descending
            Collections.sort(knapsacks, compareValue.reversed());
        }

        return knapsacks;
    }

    public List<Knapsack> sortByProfit(int mode, List<Knapsack> knapsacks) {
        Comparator<Knapsack> compareValue = new Comparator<Knapsack>() {
            @Override
            public int compare(Knapsack o1, Knapsack o2) {
                if (o1.getProfit() < o2.getProfit()) {
                    return -1;
                } else if (o1.getProfit() > o2.getProfit()) {
                    return 1;
                }
                return 0;
            }
        };

        if (mode == 0) {// ascending
            Collections.sort(knapsacks, compareValue);
        } else {// descending
            Collections.sort(knapsacks, compareValue.reversed());
        }

        return knapsacks;
    }

    public List<Knapsack> sortByDensity(int mode, List<Knapsack> knapsacks) {
        Comparator<Knapsack> compareValue = new Comparator<Knapsack>() {
            @Override
            public int compare(Knapsack o1, Knapsack o2) {
                if (o1.getDensity() < o2.getDensity()) {
                    return -1;
                } else if (o1.getDensity() > o2.getDensity()) {
                    return 1;
                }
                return 0;
            }
        };

        if (mode == 0) {// ascending
            Collections.sort(knapsacks, compareValue);
        } else {// descending
            Collections.sort(knapsacks, compareValue.reversed());
        }

        return knapsacks;
    }

    public void quickSortByWeight(List<Knapsack> knapsacks, SortType type) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortKnapsack(knapsacks, type);
    }
}
