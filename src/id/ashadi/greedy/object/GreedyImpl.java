package id.ashadi.greedy.object;

import java.util.ArrayList;
import java.util.List;

public class GreedyImpl {
    public void sortBy(int mode, SortType type, List<Knapsack> knapsacks) {
        SorterUtil sorterUtil = new SorterUtil();

        if (type.equals(SortType.WEIGHT)) {
            sorterUtil.sortByWeight(mode, knapsacks);
        } else if (type.equals(SortType.PROFIT)) {
            sorterUtil.sortByProfit(mode, knapsacks);
        } else {
            sorterUtil.sortByDensity(mode, knapsacks);
        }
    }

    public List<Knapsack> listOfGreedyDecider(List<Knapsack> knapsacks, int capacity) {
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

    public void quickSortBy(SortType type, List<Knapsack> knapsacks) {
        SorterUtil sorterUtil = new SorterUtil();
        sorterUtil.quickSortByWeight(knapsacks, type);
    }
}
