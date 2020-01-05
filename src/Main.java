import id.ashadi.greedy.object.FractionalKnapsack;
import id.ashadi.greedy.object.GreedyImpl;
import id.ashadi.greedy.object.Knapsack;
import id.ashadi.greedy.object.SortType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashadi.pratama
 * Fractional Knapsack Problem with Greedy Algorithm
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input  = new Scanner(System.in);

        // input number of input
        System.out.print("Please input number of goods will enter to box truck : ");
        int dataCount = input.nextInt();

        // input number of input
        System.out.print("Please input capacity of box truck (kg) : ");
        int capacity = input.nextInt();

        List<Knapsack> knapSackList = new ArrayList<>();
        for (int index = 0; index < dataCount; index++) {
            // input weight
            System.out.println("Goods data " + (index + 1) + " : ");
            System.out.print("    Goods weight (kg) : ");
            double weight = input.nextDouble();
            System.out.print("    Goods profit (Rp) : ");
            double profit = input.nextDouble();
            double density = (profit / weight);
            System.out.println("    Goods profit per kg (Rp/kg) : " + density);

            Knapsack knapsack = new Knapsack();
            knapsack.setIndex(index);
            knapsack.setWeight((int) weight);
            knapsack.setProfit((int) profit);
            knapsack.setDensity(density);
            knapsack.setTake(false);
            knapSackList.add(knapsack);
        }

        // save unsorted list to prevent replacement Knapsack list
        Knapsack[] arrayData2 = new Knapsack[knapSackList.size()];
        arrayData2 = knapSackList.toArray(arrayData2);

        Knapsack[] arrayData3 = new Knapsack[knapSackList.size()];
        arrayData3 = knapSackList.toArray(arrayData3);

        // Solution
        int wtot1 = 0, countW1 = 0, ptot1 = 0, remain1 = 0;
        double remainProfit1 = 0;
        new GreedyImpl().quickSortBy(SortType.WEIGHT, knapSackList);
        FractionalKnapsack fractionalKnapsack1 = new FractionalKnapsack(wtot1, countW1, ptot1, remain1, remainProfit1, knapSackList);
        new GreedyImpl().fractionalKnapsack(fractionalKnapsack1, capacity);
        System.out.println("\nSolution by Weight (kg) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + "  |  " + knapsack.getWeight() + "  |  " + knapsack.getProfit() + "  |  " +
                    knapsack.getDensity() + "  |  " + knapsack.isTake());
        }
        System.out.println("========================================================");

        int wtot2 = 0, countW2 = 0, ptot2 = 0, remain2 = 0;
        double remainProfit2 = 0;
        knapSackList = Arrays.asList(arrayData2);
        new GreedyImpl().quickSortBy(SortType.PROFIT, knapSackList);
        FractionalKnapsack fractionalKnapsack2 = new FractionalKnapsack(wtot2, countW2, ptot2, remain2, remainProfit2, knapSackList);
        new GreedyImpl().fractionalKnapsack(fractionalKnapsack2, capacity);
        System.out.println("\nSolution by Profit (Rp) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + "  |  " + knapsack.getWeight() + "  |  " + knapsack.getProfit() + "  |  " +
                    knapsack.getDensity() + "  |  " + knapsack.isTake());
        }
        System.out.println("========================================================");

        int wtot3 = 0, countW3 = 0, ptot3 = 0, remain3 = 0;
        double remainProfit3 = 0;
        knapSackList = Arrays.asList(arrayData3);
        new GreedyImpl().quickSortBy(SortType.DENSITY, knapSackList);
        FractionalKnapsack fractionalKnapsack3 = new FractionalKnapsack(wtot3, countW3, ptot3, remain3, remainProfit3, knapSackList);
        new GreedyImpl().fractionalKnapsack(fractionalKnapsack3, capacity);
        System.out.println("\nSolution by Profit per kg (Rp/kg) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + " | " + knapsack.getWeight() + " | " + knapsack.getProfit() + " | " +
                    knapsack.getDensity() + " | " + knapsack.isTake());
        }
        System.out.println("========================================================");

        // Display solution
        System.out.println("\nSolution by goods weight can carry " + fractionalKnapsack1.getWtot() + "kg (" +
                fractionalKnapsack1.getCountW() + " goods), " + " with profit Rp" + fractionalKnapsack1.getPtot()
                + " and remaining capacity of box truck capacity is " + fractionalKnapsack1.getRemain() + "kg");
        System.out.println("Remaining capacity can be the benefit value for first solution because box truck can put " +
                fractionalKnapsack1.getRemain() + "kg with" + " profit Rp" + fractionalKnapsack1.getRemainProfit() +
                ", and the total of the profit is Rp" +
                (fractionalKnapsack1.getRemainProfit() + fractionalKnapsack1.getPtot()));

        System.out.println("\nSolution by goods profit can carry " + fractionalKnapsack2.getWtot() + "kg (" +
                fractionalKnapsack2.getCountW() + " goods), " + " with profit Rp" + fractionalKnapsack2.getPtot()
                + " and remaining capacity of box truck capacity is " + fractionalKnapsack2.getRemain() + "kg");
        System.out.println("Remaining capacity can be the benefit value for second solution because box truck can put " +
                fractionalKnapsack2.getRemain() + "kg with" + " profit Rp" + fractionalKnapsack2.getRemainProfit() +
                ", and the total of the profit is Rp" +
                (fractionalKnapsack2.getRemainProfit() + fractionalKnapsack2.getPtot()));

        System.out.println("\nSolution by goods profit per kg can carry " + fractionalKnapsack3.getWtot() + "kg (" +
                fractionalKnapsack3.getCountW() + " goods), " + " with profit Rp" + fractionalKnapsack3.getPtot()
                + " and remaining capacity of box truck capacity is " + fractionalKnapsack3.getRemain() + "kg");
        System.out.println("Remaining capacity can be the benefit value for third solution because box truck can put " +
                fractionalKnapsack3.getRemain() + "kg with" + " profit Rp" + fractionalKnapsack3.getRemainProfit() +
                ", and the total of the profit is Rp" +
                (fractionalKnapsack3.getRemainProfit() + fractionalKnapsack3.getPtot()));

    }
}
