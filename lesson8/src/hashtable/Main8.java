package hashtable;

public class Main8 {
    public static void main(String[] args) {
        //SimpleAndDoubleHashTableTest();
        ChainedHashTableTest();


    }

    private static void ChainedHashTableTest() {
        HashTable chained = new ChainedHashTable(5);
        System.out.println("Добавим 6 элементов");
        System.out.println(chained.put(new Item(17, "Banana"), 130));
        System.out.println(chained.put(new Item(28, "BigBon"), 60));
        System.out.println(chained.put(new Item(66, "Tomato"), 190));
        System.out.println(chained.put(new Item(14, "Corn"), 65));
        System.out.println(chained.put(new Item(11, "Orange"),88 ));
        System.out.println(chained.put(new Item(45, "Apple"), 80));
        System.out.println(chained.size());

        System.out.println("Найдем стоимость элемента Apple с id=45");
        ((ChainedHashTable) chained).printValue(new Item(45, "Apple"));

        chained.display();

        System.out.println("Удалим элемент Apple с id=45");
        System.out.println(chained.remove(new Item(45, "Apple")));
        chained.display();
    }

}
