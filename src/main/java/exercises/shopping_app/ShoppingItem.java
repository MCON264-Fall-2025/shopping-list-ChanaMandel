package exercises.shopping_app;

/**
 * Requirements for ShoppingItem
 * Fields:
 * String aisle; (you may also use int if you prefer numeric aisles)
 * String name;
 * A constructor that sets both fields.
 * getAisle() and getName() accessor methods (and toString() for nice printing).
 * Implement Comparable<ShoppingItem> so that items are ordered by:
 * Aisle (ascending), then
 * Name (alphabetically) when aisles are equal
 */
public class ShoppingItem implements Comparable<ShoppingItem> {
    //TODO
    String aisle;
    String name;

    public ShoppingItem(String aisle, String name) {
        this.aisle = aisle;
        this.name = name;
    }

    public String getAisle() {
        return aisle;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShoppingItem: " + name);
        builder.append(" Aisle: " + aisle);
        return builder.toString();
    }

    @Override
    public int compareTo(ShoppingItem other) {
        int aisleCompare = this.aisle.compareTo(other.aisle);
        if (aisleCompare != 0) {
            return aisleCompare;
        }

        int  nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return 0;
    }

}
