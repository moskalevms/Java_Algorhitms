import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 1.	Создать массив большого размера (миллион элементов).
 * 2.	Написать методы удаления, добавления, поиска элемента массива.
 * 3.	Заполнить массив случайными числами.
 * 4.	Написать методы, реализующие рассмотренные виды сортировок,
 * и проверить скорость выполнения каждой.
 */
public class Main2 {

    private static Random rand = new Random();

    public static void main(String[] args) {
//        testArray();

        Array<Integer> arrayForBubble = new ArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForBubble.add(rand.nextInt(1000));
        }

        Array<Integer> arrayForSelect = new ArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForSelect.add(rand.nextInt(1000));
        }

        Array<Integer> arrayForInsert = new ArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForInsert.add(rand.nextInt(1000));
        }


        long t1 = System.currentTimeMillis();
        arrayForBubble.sortBubble();
        System.out.println("Time for Bubble Sort: " + (System.currentTimeMillis() - t1));

        long t2 = System.currentTimeMillis();
        arrayForSelect.sortSelect();
        System.out.println("Time for Select Sort: " + (System.currentTimeMillis() - t2));

        long t3 = System.currentTimeMillis();
        arrayForInsert.sortInsert();
        System.out.println("Time for Insert Sort: " + (System.currentTimeMillis() - t3));


        System.out.println("-------------------------------------------------------");

        Array<Integer> arrayForBubbleSorted = new SortedArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForBubbleSorted.add(rand.nextInt(1000));
        }

        Array<Integer> arrayForSelectSorted = new SortedArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForSelectSorted.add(rand.nextInt(1000));
        }

        Array<Integer> arrayForInsertSorted = new SortedArrayImpl<>();
        for (int i = 0; i < 10000; i++) {
            arrayForInsertSorted.add(rand.nextInt(1000));
        }


        long t4 = System.currentTimeMillis();
        arrayForBubbleSorted.sortBubble();
        System.out.println("Time for Bubble Sorted: " + (System.currentTimeMillis() - t4));

        long t5 = System.currentTimeMillis();
        arrayForSelectSorted.sortSelect();
        System.out.println("Time for Select Sorted: " + (System.currentTimeMillis() - t5));

        long t6 = System.currentTimeMillis();
        arrayForInsertSorted.sortInsert();
        System.out.println("Time for Insert Sorted: " + (System.currentTimeMillis() - t6));
//        System.nanoTime();
//        TimeUnit.NANOSECONDS.toMillis();

    }

    private static void testArray() {
        //        Array<Integer> array = new ArrayImpl<>();
        Array<Integer> array = new SortedArrayImpl<>();
        System.out.println(array);
        array.add(2);
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(3);

        System.out.println(array);

        System.out.println("Find 5 = " + array.contains(5));
        System.out.println("Index of 3 = " + array.indexOf(3));
        System.out.println("Index of 33 = " + array.indexOf(33));

        System.out.println("Remove 3: " + array.remove(3));
        System.out.println("Remove 33: " + array.remove(33));
        System.out.println("Index of 3 = " + array.indexOf(3));

        System.out.println(array);
        System.out.println("Size is " + array.getSize());

        System.out.println("----------");
        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }
    }


}
