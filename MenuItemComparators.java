import java.util.Comparator;
public class MenuItemComparators {
    // 1. По цене (от дешевых к дорогим)
    public static Comparator<MenuItem> BY_PRICE = new Comparator<MenuItem>() {
        @Override
        public int compare(MenuItem m1, MenuItem m2) {
            return Double.compare(m1.getPrice(), m2.getPrice());
        }
    };

    // 2. По калорийности
    public static Comparator<MenuItem> BY_CALORIES = new Comparator<MenuItem>() {
        @Override
        public int compare(MenuItem m1, MenuItem m2) {
            return Integer.compare(m1.getCalories(), m2.getCalories());
        }
    };

    // 3. По категории
    public static Comparator<MenuItem> BY_CATEGORY = new Comparator<MenuItem>() {
        @Override
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getCategory().compareTo(m2.getCategory());
        }
    };
}
