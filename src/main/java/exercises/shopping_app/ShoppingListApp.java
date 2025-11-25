package exercises.shopping_app;

import edu.touro.mcon264.apps.collections.ArrayBasedList;
import edu.touro.mcon264.apps.collections.LinkedBasedList;
import edu.touro.mcon264.apps.collections.ListInterface;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Creates a ListInterface<ShoppingItem> instance.
 * Has a main method that runs a console application.
 * Provides a simple text-based menu to:
 * Add items (in sorted order).
 * View the current list.
 * “Shop” the next item on the list.
 * Exit the program.
 */
public class ShoppingListApp {
    public static void main(String[] args) {
        //TODO
        ListInterface<ShoppingItem> shoppingList;
        shoppingList = new ArrayBasedList<>();
        shoppingList = new LinkedBasedList<>();

        Scanner user =  new Scanner(System.in);
        int choice = user.nextInt();
        while (choice !=  0) {
            displayMenu();
            switch (choice) {
                case 1:
                    System.out.println("enter the name of your item");
                    String name = user.nextLine();
                    System.out.println("enter the aisle of your item");
                    String aisle = user.nextLine();
                    insertSorted(shoppingList, new ShoppingItem(name, aisle));
                    break;
                case 2:
                    printList(shoppingList);
                    break;
                case 3:
                    ShoppingItem next = shopNext(shoppingList);
                    if (next == null) {
                        System.out.println("All done! No items left to shop.");
                    } else {
                        System.out.println("Next item to buy: " + next);
                    }
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("=== Shopping List Menu ===");
        System.out.println("1. Add Item");
        System.out.println("2. Show current Shopping List");
        System.out.println("3. Shop next item");
        System.out.println("4. Exit");
        System.out.println("Enter your choice");
    }

    /**
     * Inserts the given item into the list so that the list remains sorted
     * by aisle and then item name.
     */
    public static void insertSorted(ListInterface<ShoppingItem> list, ShoppingItem item) {
        // TODO: implement using list.get(i), list.add(i, item), list.size()
        for(int index = 0; index < list.size(); index++) {
            ShoppingItem currentItem = list.get(index);
            if(item.compareTo(currentItem) < 0) {
                list.add(index, item);
                return;
            }
        }
        list.add(list.size(), item);
    }
    /**
     * Returns the "next" item to shop and removes it from the list.
     * If the list is empty, returns null.
     */
    public static ShoppingItem shopNext(ListInterface<ShoppingItem> list) {
        // TODO: implement using ListInterface methods
        if(list.size() == 0)
            return null;
        ShoppingItem next = list.get(0);
        list.remove(0);
        return next;
    }

    private static void printList(ListInterface<ShoppingItem> list) {
        Iterator<ShoppingItem> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
