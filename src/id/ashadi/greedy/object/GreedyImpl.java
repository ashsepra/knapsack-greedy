package id.ashadi.greedy.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GreedyImpl {
    public void sortBy(int mode, SortType type, List<Knapsack> knapsacks) {
        if (type.equals(SortType.WEIGHT)) {
            sortByWeight(mode, knapsacks);
        } else if (type.equals(SortType.PROFIT)) {
            sortByProfit(mode, knapsacks);
        } else {
            sortByDensity(mode, knapsacks);
        }
    }

    public List<Knapsack> ListOfGreedyDecider(List<Knapsack> knapsacks, int capacity) {
        List<Knapsack> knapsackList = new ArrayList<>();
        for (Knapsack knapsack: knapsacks) {
            boolean isTaken = capacity >= knapsack.getWeight();
            knapsack.setTake(isTaken);
            if (isTaken) {
                knapsackList.add(knapsack);
            }
            capacity = capacity - knapsack.getWeight();
        }

        return knapsackList;
    }

    private List<Knapsack> sortByWeight(int mode, List<Knapsack> knapsacks) {
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

    private List<Knapsack> sortByProfit(int mode, List<Knapsack> knapsacks) {
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

    private List<Knapsack> sortByDensity(int mode, List<Knapsack> knapsacks) {
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
}
