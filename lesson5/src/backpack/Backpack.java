package backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {


    private List<Item> items = new ArrayList<>();
    private int weight;
    private int bestPrice;

    public Backpack(int weight) {
        this.weight = weight;
    }


    public int calcWeight(List<Item> item){
        int weightAmount = 0;

        for (Item i : item) {
            weightAmount += i.getWeight();
        }

        return weightAmount;

    }


    public int calcCost(List<Item> item){
        int costAmount = 0;

        for (Item i : item) {
            costAmount += i.getCost();
        }

        return costAmount;
    }

    public void checkSet(List<Item> item){
            if(items == null){
                if(calcWeight(item) <= weight){
                    items = item;
                    bestPrice = calcCost(item);
                }
            }else
            {
                if(calcWeight(item) <= weight && calcCost(item) > bestPrice) {
                    items = item;
                    bestPrice = calcCost(item);
                }
            }
    }


    public void makeAllSets(List<Item> items)
    {
        if (items.size()> 0)
            checkSet(items);

        for (int i = 0; i < items.size(); i++)
        {
            List<Item> newSet = new ArrayList<>(items);

            newSet.remove(i);
            makeAllSets(newSet);
        }

    }

    public List<Item> getBestSet()
    {
        return items;
    }

}

