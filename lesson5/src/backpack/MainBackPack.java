package backpack;

import java.util.ArrayList;
import java.util.List;

public class MainBackPack {

    public static void main(String[] args) {

        Backpack backpack = new Backpack(8);

        List<Item> items = new ArrayList();

        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));

        backpack.makeAllSets(items);
        System.out.println(items);
        System.out.println("_________________________________");
        System.out.println(backpack.getBestSet());

    }




}
