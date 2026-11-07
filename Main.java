import java.util.List;
public class Main {
    public static void main(String[] args) {
        CafeteriaService service = new CafeteriaService();
        // Добавление элементов
        MenuItem item1 = new MenuItem("M01", "Кофе Латте", "Напитки", 150.0, 180);
        MenuItem item2 = new MenuItem("M02", "Сэндвич", "Выпечка", 200.0, 350);
        MenuItem item3 = new MenuItem("M03", "Чай Зеленый", "Напитки", 80.0, 0);

        service.addMenuItem(item1);
        service.addMenuItem(item2);
        service.addMenuItem(item3);

        // Поиск по O(1)
        System.out.println("Поиск M01: " + service.findById("M01"));

        // Работа с очередью заказов
        service.placeOrder(new Order("O-101", "Алихан", "Кофе Латте"));
        service.placeOrder(new Order("O-102", "Мадина", "Сэндвич"));

        System.out.println("\nОбработка очереди:");
        System.out.println("Обработан: " + service.processNextOrder());

        // Сортировка по цене с выводом через обычный цикл for
        System.out.println("\nСортировка по цене:");
        List<MenuItem> sortedByPrice = service.getSortedMenu(MenuItemComparators.BY_PRICE);
        for (int i = 0; i < sortedByPrice.size(); i++) {
            System.out.println(sortedByPrice.get(i));
        }
    }
}

