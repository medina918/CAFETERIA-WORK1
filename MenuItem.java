import java.util.Objects;
public class MenuItem implements Comparable<MenuItem>
{ private String id; private String name; private String category; private double price; private int calories;
    public MenuItem(String id, String name, String category, double price, int calories) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.calories = calories;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getCalories() { return calories; }

    public void setPrice(double price) { this.price = price; }

    // Естественная сортировка по названию
    @Override
    public int compareTo(MenuItem other) {
        return this.name.compareTo(other.name);
    }

    // Обязательные контракты по бизнес-ключу (id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(id, menuItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MenuItem{id='" + id + "', name='" + name + "', category='" + category +
                "', price=" + price + ", calories=" + calories + '}';
    }
}
