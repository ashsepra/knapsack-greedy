package id.ashadi.greedy.object;

import java.util.Arrays;
import java.util.List;

/**
 * @author ashadi
 */
public class QuickSort {
    private Knapsack[] knapsacks;
    private int number;

    public void quickSortKnapsack(List<Knapsack> knapsacks, SortType type) {
        // check for empty or null array
        if (knapsacks == null || knapsacks.size() == 0){
            return;
        }

        this.knapsacks = new Knapsack[knapsacks.size()];
        this.knapsacks = knapsacks.toArray(this.knapsacks);
        number = this.knapsacks.length;

        if (type == SortType.WEIGHT) {
            this.quickSortByWeight(0, number - 1);
        } else if (type == SortType.PROFIT) {
            this.quickSortByProfit(0, number - 1);
        } else if (type == SortType.DENSITY) {
            this.quickSortByDensity(0, number - 1);
        }

        knapsacks = Arrays.asList(this.knapsacks);
    }

    /**
     * @param low
     * @param high
     * Quick sort algorithm with descending sort order for Knapsack by weight point
     */
    private void quickSortByWeight(int low, int high) {
        int i = low, j = high;
        int pivot = this.knapsacks[low + (high-low)/2].getWeight();

        while (i <= j) {

            while (this.knapsacks[i].getWeight() > pivot) {
                i++;
            }

            while (this.knapsacks[j].getWeight() < pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSortByWeight(low, j);
        if (i < high)
            quickSortByWeight(i, high);
    }

    private void quickSortByProfit(int low, int high) {
        int i = low, j = high;
        int pivot = this.knapsacks[low + (high-low)/2].getProfit();

        while (i <= j) {

            while (this.knapsacks[i].getProfit() > pivot) {
                i++;
            }

            while (this.knapsacks[j].getProfit() < pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSortByProfit(low, j);
        if (i < high)
            quickSortByProfit(i, high);
    }

    private void quickSortByDensity(int low, int high) {
        int i = low, j = high;
        double pivot = this.knapsacks[low + (high-low)/2].getDensity();

        while (i <= j) {

            while (this.knapsacks[i].getDensity() > pivot) {
                i++;
            }

            while (this.knapsacks[j].getDensity() < pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSortByDensity(low, j);
        if (i < high)
            quickSortByDensity(i, high);
    }

    private void swap(int i, int j) {
        Knapsack knapsackTemp = new Knapsack();
        knapsackTemp.setIndex(knapsacks[i].getIndex());
        knapsackTemp.setWeight(knapsacks[i].getWeight());
        knapsackTemp.setProfit(knapsacks[i].getProfit());
        knapsackTemp.setDensity(knapsacks[i].getDensity());

        this.knapsacks[i].setIndex(this.knapsacks[j].getIndex());
        this.knapsacks[j].setIndex(knapsackTemp.getIndex());

        this.knapsacks[i].setWeight(this.knapsacks[j].getWeight());
        this.knapsacks[j].setWeight(knapsackTemp.getWeight());

        this.knapsacks[i].setProfit(this.knapsacks[j].getProfit());
        this.knapsacks[j].setProfit(knapsackTemp.getProfit());

        this.knapsacks[i].setDensity(this.knapsacks[j].getDensity());
        this.knapsacks[j].setDensity(knapsackTemp.getDensity());

    }
}
