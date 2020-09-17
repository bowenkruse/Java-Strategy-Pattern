package HW3;
import java.util.*;

public class doesSortDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // three types of sorting algorithms and their respective multiple choice options
        SortStrategy Strategy1 = new bubbleSortStrategy();
        SortStrategy Strategy2 = new mergeSortStrategy();
        SortStrategy Strategy3 = new quickSortStrategy();
        Hashtable<String,Object> StrategyChoiceDictionary = new Hashtable<>();
        StrategyChoiceDictionary.put("a",Strategy1);
        StrategyChoiceDictionary.put("b",Strategy2);
        StrategyChoiceDictionary.put("c",Strategy3);

        // three different Inventory Modules with different default sort strategies
        InventoryModule Module1 = new InventoryModule(Strategy1);
        InventoryModule Module2 = new InventoryModule(Strategy2);
        InventoryModule Module3 = new InventoryModule(Strategy3);
        Hashtable<String,Object> ModuleChoiceDictionary = new Hashtable<>();
        ModuleChoiceDictionary.put("a",Module1);
        ModuleChoiceDictionary.put("b",Module2);
        ModuleChoiceDictionary.put("c",Module3);

        // request selection of sorting algorithm
        while(true) {
            // get module selection
            PrintModuleChoice();
            String moduleSelection = in.nextLine();
            if (moduleSelection.equals("d"))
                break;
            if (!isValid(moduleSelection)) continue;
            InventoryModule ModuleToSort = (InventoryModule) ModuleChoiceDictionary.get(moduleSelection);
            // sort chosen module using default sort strategy
            ModuleToSort.Sort();

            // get new type of sorting strategy
            PrintStrategyChoice();
            String userSelection = in.nextLine();
            if (userSelection.equals("d"))
                break;
            if (!isValid(userSelection)) continue;
            SortStrategy newDefaultStrategy = (SortStrategy) StrategyChoiceDictionary.get(userSelection);

            // set new default sort strategy and sort
            ModuleToSort.setSortType(newDefaultStrategy);
            ModuleToSort.Sort();
        }
    }

    public static void PrintModuleChoice() {
        System.out.println("Which module would you like to choose:\na. Module1\nb. Module2\nc. Module3\nd. quit");
    }

    public static void PrintStrategyChoice() {
        System.out.println("\nWhich algorithm would you like to use to sort:\na. bubble \nb. merge\nc. quick\nd. quit");
    }
    public static boolean isValid(String choice) {
        //valid answers for sort type
        List<String> validSelections = new ArrayList<>(List.of("a", "b", "c"));
        return validSelections.contains(choice);
    }
}
