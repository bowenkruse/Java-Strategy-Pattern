package HW3;
import java.util.*;

public class InventoryModule {
    private SortStrategy sortType;
    // array that will be sorted by various algorithms
    private final int[] ArrayToSort = new int[10];
    Random randomInt = new Random();

    public InventoryModule (SortStrategy defaultSortStrategy) {
        this.sortType = defaultSortStrategy;
        fillArray();
    }

    private void fillArray(){
        //fill array with random numbers
        for (int i = 0; i < ArrayToSort.length; i++) {
            ArrayToSort[i] = randomInt.nextInt(10);
        }
    }

    public void Sort() {
        System.out.println("Current default sort strategy: " + getName());
        sortType.sort(ArrayToSort);
    }

    // sets new default sort strategy(algorithm)
    public void setSortType(SortStrategy newDefaultStrategy) {
        this.sortType = newDefaultStrategy;
    }

    public String getName() {
        return sortType.getName();
    }
}
