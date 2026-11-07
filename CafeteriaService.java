import java.util.*;
public class CafeteriaService {
    private List<MenuItem> menuList = new ArrayList<>();
    private Map<String, MenuItem> itemIndex = new HashMap<>();
    private Map<String, List<MenuItem>> categoryMap = new HashMap<>();
    private Queue<Order> orderQueue = new ArrayDeque<>();

    public void addMenuItem(MenuItem item) {
        menuList.add(item);
        itemIndex.put(item.getId(), item);

        if (!categoryMap.containsKey(item.getCategory())) {
            categoryMap.put(item.getCategory(), new ArrayList<>());
        }
        categoryMap.get(item.getCategory()).add(item);
    }

    public MenuItem findById(String id) {
        return itemIndex.get(id);
    }

    public boolean removeMenuItem(String id) {
        MenuItem item = itemIndex.get(id);
        if (item == null) return false;

        itemIndex.remove(id);

        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getId().equals(id)) {
                menuList.remove(i);
                break;
            }
        }

        List<MenuItem> catList = categoryMap.get(item.getCategory());
        if (catList != null) {
            for (int i = 0; i < catList.size(); i++) {
                if (catList.get(i).getId().equals(id)) {
                    catList.remove(i);
                    break;
                }
            }
        }
        return true;
    }

    public void placeOrder(Order order) {
        orderQueue.add(order);
    }

    public Order processNextOrder() {
        return orderQueue.poll();
    }

    public List<MenuItem> getSortedMenu(Comparator<MenuItem> comparator) {
        List<MenuItem> sorted = new ArrayList<>(menuList);
        Collections.sort(sorted, comparator);
        return sorted;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
}