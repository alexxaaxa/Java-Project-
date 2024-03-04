import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopStore {

    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell XPS", 16, 512, "Windows", "Silver"));
        laptops.add(new Laptop("MacBook Pro", 32, 1_024, "macOS", "Space Gray"));
        laptops.add(new Laptop("HP Spectre", 8, 256, "Windows", "Copper"));

        // Метод фильтрации
        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        // Создание Map для хранения критериев фильтрации
        Map<Integer, Object> filterCriteria = new HashMap<>();

        // Запрос критериев у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую критерию фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = 0;
        try {
            criterion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите цифру.");
            return;
        } finally {
            // Закрытие Scanner в блоке finally для обеспечения выполнения
            scanner.close();
        }

        // Запрос минимальных значений для выбранных критериев
        switch (criterion) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = 0;
                try {
                    minRam = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    return;
                }
                filterCriteria.put(criterion, minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = 0;
                try {
                    minStorage = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                    return;
                }
                filterCriteria.put(criterion, minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filterCriteria.put(criterion, os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filterCriteria.put(criterion, color);
                break;
            default:
                System.out.println("Некорректный ввод");
                return;
        }

        // Фильтрация ноутбуков
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            switch (criterion) {
                case 1:
                    if (laptop.getRam() >= (int) filterCriteria.get(criterion)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 2:
                    if (laptop.getStorageCapacity() >= (int) filterCriteria.get(criterion)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 3:
                    if (laptop.getOperatingSystem().equalsIgnoreCase((String) filterCriteria.get(criterion))) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 4:
                    if (laptop.getColor().equalsIgnoreCase((String) filterCriteria.get(criterion))) {
                        filteredLaptops.add(laptop);
                    }
                    break;
            }
        }

        // Вывод отфильтрованных ноутбуков
        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println("Модель: " + laptop.getModel() +
                    ", ОЗУ: " + laptop.getRam() +
                    ", Объем ЖД: " + laptop.getStorageCapacity() +
                    ", ОС: " + laptop.getOperatingSystem() +
                    ", Цвет: " + laptop.getColor());
        }
    }
}