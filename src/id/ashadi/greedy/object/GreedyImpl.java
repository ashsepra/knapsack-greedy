package id.ashadi.greedy.object;

import java.util.List;

/**
 * @author ashadi.pratama
 * Greedy implementation object
 */
public class GreedyImpl {

    /**
     * @param mode
     * @param type
     * @param knapsacks
     * Sort the list using Java Util sort implementation
     */
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

    /**
     * @param fractionalKnapsack
     * @param capacity
     * Fractional Knapsack problem solution
     */
    public void fractionalKnapsack(FractionalKnapsack fractionalKnapsack, int capacity) {
        int wtot = 0;
        int countW = 0;
        int ptot = 0;
        int tempCapacity = capacity;
        for (Knapsack knapsack: fractionalKnapsack.getKnapsackList()) {
            boolean isTaken = capacity >= knapsack.getWeight();
            knapsack.setTake(isTaken);
            if (isTaken) {
                wtot = wtot + knapsack.getWeight();
                ptot = ptot + knapsack.getProfit();
                countW++;
            }
            capacity = capacity - knapsack.getWeight();
        }

        int remaining = tempCapacity - wtot;
        fractionalKnapsack.setRemain(remaining);
        fractionalKnapsack.setPtot(ptot);
        fractionalKnapsack.setCountW(countW);
        fractionalKnapsack.setWtot(wtot);
        if (remaining > 0) {
            double wsel = fractionalKnapsack.getKnapsackList().get(countW).getWeight();
            double psel = fractionalKnapsack.getKnapsackList().get(countW).getProfit();
            double extraProfit = (remaining / wsel) * psel;
            fractionalKnapsack.setRemainProfit(extraProfit);
        }
    }

    /**
     * @param type
     * @param knapsacks
     * Quick sort the list using quick sort implementation
     */
    public void quickSortBy(SortType type, List<Knapsack> knapsacks) {
        SorterUtil sorterUtil = new SorterUtil();
        sorterUtil.quickSortByWeight(knapsacks, type);
    }
}
