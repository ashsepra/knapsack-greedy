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
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input  = new Scanner(System.in);

        // input number of input
        System.out.print("Please input number of goods will enter to box car : ");
        int dataCount = input.nextInt();

        // input number of input
        System.out.print("Please input capacity of box car (kg) : ");
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

        // save unsorted list to prevent memory affect
        Knapsack[] arrayData2 = new Knapsack[knapSackList.size()];
        arrayData2 = knapSackList.toArray(arrayData2);

        Knapsack[] arrayData3 = new Knapsack[knapSackList.size()];
        arrayData3 = knapSackList.toArray(arrayData3);

        new GreedyImpl().sortBy(1, SortType.WEIGHT, knapSackList);
        List<Knapsack> knapsackList1 = new GreedyImpl().ListOfGreedyDecider(knapSackList, capacity);
        System.out.println("\nSolution by Weight (kg) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + "  |  " + knapsack.getWeight() + "  |  " + knapsack.getProfit() + "  |  " +
                    knapsack.getDensity() + "  |  " + knapsack.isTake());
        }
        System.out.println("========================================================");

        knapSackList = Arrays.asList(arrayData2);
        new GreedyImpl().sortBy(1, SortType.PROFIT, knapSackList);
        List<Knapsack> knapsackList2 = new GreedyImpl().ListOfGreedyDecider(knapSackList, capacity);
        System.out.println("\nSolution by Profit (Rp) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + "  |  " + knapsack.getWeight() + "  |  " + knapsack.getProfit() + "  |  " +
                    knapsack.getDensity() + "  |  " + knapsack.isTake());
        }
        System.out.println("========================================================");

        knapSackList = Arrays.asList(arrayData3);
        new GreedyImpl().sortBy(1, SortType.DENSITY, knapSackList);
        List<Knapsack> knapsackList3 = new GreedyImpl().ListOfGreedyDecider(knapSackList, capacity);
        System.out.println("\nSolution by Profit per kg (Rp/kg) of Goods");
        System.out.println("Index | Weight | Profit | Profit/Kg | Take");
        for (Knapsack knapsack: knapSackList) {
            System.out.println("========================================================");
            System.out.println(knapsack.getIndex() + " | " + knapsack.getWeight() + " | " + knapsack.getProfit() + " | " +
                    knapsack.getDensity() + " | " + knapsack.isTake());
        }
        System.out.println("========================================================");

        // Solution
        int wtot1 = 0;
        int countW1 = 0;
        int ptot1 = 0;
        for (Knapsack knapsack: knapsackList1) {
            wtot1 = wtot1 + knapsack.getWeight();
            ptot1 = ptot1 + (knapsack.getProfit() * knapsack.getWeight());
            countW1++;
        }
        int remain1 = capacity - wtot1;

        int wtot2 = 0;
        int countW2 = 0;
        int ptot2 = 0;
        for (Knapsack knapsack: knapsackList2) {
            wtot2 = wtot2 + knapsack.getWeight();
            ptot2 = ptot2 + (knapsack.getProfit() * knapsack.getWeight());
            countW2++;
        }
        int remain2 = capacity - wtot2;

        int wtot3 = 0;
        int countW3 = 0;
        int ptot3 = 0;
        for (Knapsack knapsack: knapsackList3) {
            wtot3 = wtot3 + knapsack.getWeight();
            ptot3 = ptot3 + (knapsack.getProfit() * knapsack.getWeight());
            countW3++;
        }
        int remain3 = capacity - wtot3;

        System.out.println("Solution by goods weight can carry " + wtot1 + "kg (" + countW1 + " goods), " +
                " with profit Rp " + ptot1 + " and remaining capacity of car box capacity is " + remain1 + "kg");
        System.out.println("Solution by goods profit can carry " + wtot2 + "kg (" + countW2 + " goods), " +
                " with profit Rp" + ptot2 + " and remaining capacity of car box capacity is " + remain2 + "kg");
        System.out.println("Solution by goods profit per kg can carry " + wtot3 + "kg (" + countW3 + " goods), " +
                " with profit Rp" + ptot3 + " and remaining capacity of car box capacity is " + remain3 + "kg");
    }
}
