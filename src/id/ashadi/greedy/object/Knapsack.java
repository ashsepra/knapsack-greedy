package id.ashadi.greedy.object;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author ashadi.pratama
 * Knapsack class object
 */
public class Knapsack implements Serializable {
    private int index;
    private int weight;
    private int profit;
    private double density;
    private boolean take;

    public Knapsack() {
        super();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public boolean isTake() {
        return take;
    }

    public void setTake(boolean take) {
        this.take = take;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knapsack knapsack = (Knapsack) o;
        return index == knapsack.index &&
                weight == knapsack.weight &&
                profit == knapsack.profit &&
                Double.compare(knapsack.density, density) == 0 &&
                take == knapsack.take;
    }

    @Override
    public int hashCode() {

        return Objects.hash(index, weight, profit, density, take);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return super.toString();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }
}
