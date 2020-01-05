package id.ashadi.greedy.object;

import java.util.List;
import java.util.Objects;

/**
 * @author ashadi.pratama
 * Fractional Knapsack class object
 */
public class FractionalKnapsack {
	private int wtot;
	private int countW;
	private int ptot;
	private int remain;
	private double remainProfit;
	private List<Knapsack> knapsackList;

	public FractionalKnapsack() {
	}

	public FractionalKnapsack(int wtot, int countW, int ptot, int remain, double remainProfit, List<Knapsack> knapsackList) {
		this.wtot = wtot;
		this.countW = countW;
		this.ptot = ptot;
		this.remain = remain;
		this.remainProfit = remainProfit;
		this.knapsackList = knapsackList;
	}

	public int getWtot() {
		return wtot;
	}

	public void setWtot(int wtot) {
		this.wtot = wtot;
	}

	public int getCountW() {
		return countW;
	}

	public void setCountW(int countW) {
		this.countW = countW;
	}

	public int getPtot() {
		return ptot;
	}

	public void setPtot(int ptot) {
		this.ptot = ptot;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public double getRemainProfit() {
		return remainProfit;
	}

	public void setRemainProfit(double remainProfit) {
		this.remainProfit = remainProfit;
	}

	public List<Knapsack> getKnapsackList() {
		return knapsackList;
	}

	public void setKnapsackList(List<Knapsack> knapsackList) {
		this.knapsackList = knapsackList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FractionalKnapsack that = (FractionalKnapsack) o;
		return wtot == that.wtot &&
				countW == that.countW &&
				ptot == that.ptot &&
				remain == that.remain &&
				Double.compare(that.remainProfit, remainProfit) == 0 &&
				Objects.equals(knapsackList, that.knapsackList);
	}

	@Override
	public int hashCode() {

		return Objects.hash(wtot, countW, ptot, remain, remainProfit, knapsackList);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
