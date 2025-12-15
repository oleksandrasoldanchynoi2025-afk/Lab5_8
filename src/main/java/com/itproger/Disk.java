package com.itproger;
import java.io.*;
import java.util.*;

public class Disk {
    private Map<String, List<Composition>> cdChanger = new HashMap<>();
    private String currentDiskName = "Disk 1";
    private Scanner scanner = new Scanner(System.in);
    private final String FILE_NAME = "database_multi.txt";

    public Disk() {
        cdChanger.put("Disk 1", new ArrayList<>());
        cdChanger.put("All", new ArrayList<>());

        loadFromFile();
    }


    public void createDisk() {
        System.out.print("\nВведіть назву нового диску: ");
        String name = scanner.next();
        cdChanger.put(name, new ArrayList<>());
        System.out.println("Диск створено.");
        saveToFile();
    }


    public void removeDisk() {
        System.out.println("\nДоступні: " + cdChanger.keySet());
        System.out.print("Введіть назву для видалення: ");
        String name = scanner.next();

        cdChanger.remove(name);
        System.out.println("Диск видалено (якщо він був).");
        saveToFile();
    }


    public void switchDisk() {
        System.out.println("\n--- Вибір диску ---");
        System.out.println("Поточний: " + currentDiskName);

        List<String> disks = new ArrayList<>(cdChanger.keySet());
        for (int i = 0; i < disks.size(); i++) {
            System.out.println((i + 1) + ". " + disks.get(i));
        }

        System.out.print("Оберіть номер: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < disks.size()) {
            currentDiskName = disks.get(index);
            System.out.println("-> Активний диск: " + currentDiskName);
        }
    }
//    ----------------------------------------------------------
    // --- ДОДАВАННЯ ПІСНІ ---
//    public void addComposition() {
//        System.out.println("\n-> Додавання на " + currentDiskName);
//
//        System.out.print("Назва: "); String title = scanner.next();
//        System.out.print("Виконавець: "); String artist = scanner.next();
//        System.out.print("Стиль: "); String style = scanner.next();
//        System.out.print("Час: "); double duration = scanner.nextDouble();
//
//        Composition song = new Composition(title, artist, style, duration);
//
//
//        getCurrentPlaylist().add(song);
//
//
//        if (!currentDiskName.equals("All") && cdChanger.containsKey("All")) {
//            cdChanger.get("All").add(song);
//        }
//
//        System.out.println("Збережено.");
//        saveToFile();
//    }


    public void addComposition() {
        System.out.println("\n-> Додавання на " + currentDiskName);
        System.out.print("Назва: ");
        String title = scanner.next();
        System.out.print("Виконавець: ");
        String artist = scanner.next();
        System.out.print("Стиль (Pop, Rock, Jazz): ");
        String styleInput = scanner.next();
        Style style = Style.valueOf(styleInput.toUpperCase());
        System.out.print("Час: ");
        double duration = scanner.nextDouble();
        Composition song = new Composition(title, artist, style, (int) duration);
        addComposition(song);
    }

    // 2. Цей метод — для тестів (і для першого методу теж)
    public void addComposition(Composition song) {
        getCurrentPlaylist().add(song);

        if (!currentDiskName.equals("All") && cdChanger.containsKey("All")) {
            cdChanger.get("All").add(song);
        }
        System.out.println("Збережено.");
        saveToFile();
    }


    public void showCompositions() {
        System.out.println("\n-> Вміст " + currentDiskName + ":");
        List<Composition> list = getCurrentPlaylist();
        if (list == null || list.isEmpty()) System.out.println("Пусто.");
        else for (Composition c : list) System.out.println(c);
    }
//    ----------------------------------------------------------
//    public void calculateDuration() {
//        double total = 0;
//        List<Composition> list = getCurrentPlaylist();
//        if (list != null) for (Composition c : list) total += c.getDuration();
//        System.out.println("Тривалість: " + total + " хв.");
//    }


    public void calculateDuration() {
        System.out.println("Тривалість: " + calculateTotalDuration() + " хв.");
    }

    // LOGIC: Рахує і повертає число (для тесту)
    public double calculateTotalDuration() {
        double total = 0;
        List<Composition> list = getCurrentPlaylist();
        if (list != null) {
            for (Composition c : list) total += c.getDuration();
        }
        return total;
    }

//    ----------------------------------------------------------

//    public void sortByStyle() {
//        System.out.print("Стиль для фільтру: ");
//        String style = scanner.next();
//        List<Composition> list = getCurrentPlaylist();
//        if (list != null) {
//            for (Composition c : list) {
//                if (c.getStyle().equalsIgnoreCase(style)) System.out.println(c);
//            }
//        }
//    }



    public void sortByStyle() {
        System.out.print("Стиль для фільтру: ");
        String style = scanner.next();

        List<Composition> result = filterByStyle(style); // Виклик логіки

        for (Composition c : result) System.out.println(c);
    }

    // LOGIC: Шукає і повертає список (для тесту)
    public List<Composition> filterByStyle(String style) {
        List<Composition> result = new ArrayList<>();
        List<Composition> list = getCurrentPlaylist();

        if (list != null) {
            for (Composition c : list) {
                if (c.getStyle().name().equalsIgnoreCase(style)) {
                    result.add(c);
                }
            }
        }
        return result;
    }





//    public void findByArtist() {
//        System.out.print("Виконавець: ");
//        String name = scanner.next();
//        List<Composition> list = getCurrentPlaylist();
//        if (list != null) {
//            for (Composition c : list) {
//                if (c.getArtist().equalsIgnoreCase(name)) System.out.println(c);
//            }
//        }
//    }



    // UI
    public void findByArtist() {
        System.out.print("Виконавець: ");
        String name = scanner.next();

        List<Composition> result = filterByArtist(name); // Виклик логіки

        for (Composition c : result) System.out.println(c);
    }

    // LOGIC
    public List<Composition> filterByArtist(String name) {
        List<Composition> result = new ArrayList<>();
        List<Composition> list = getCurrentPlaylist();

        if (list != null) {
            for (Composition c : list) {
                if (c.getArtist().equalsIgnoreCase(name)) {
                    result.add(c);
                }
            }
        }
        return result;
    }




//    public void findByDurationRange() {
//        System.out.print("Від: "); double min = scanner.nextDouble();
//        System.out.print("До: "); double max = scanner.nextDouble();
//        List<Composition> list = getCurrentPlaylist();
//        if (list != null) {
//            for (Composition c : list) {
//                if (c.getDuration() >= min && c.getDuration() <= max) System.out.println(c);
//            }
//        }
//    }



    // UI
    public void findByDurationRange() {
        System.out.print("Від: "); double min = scanner.nextDouble();
        System.out.print("До: "); double max = scanner.nextDouble();

        List<Composition> result = filterByDuration(min, max); // Виклик логіки

        for (Composition c : result) System.out.println(c);
    }

    // LOGIC
    public List<Composition> filterByDuration(double min, double max) {
        List<Composition> result = new ArrayList<>();
        List<Composition> list = getCurrentPlaylist();

        if (list != null) {
            for (Composition c : list) {
                if (c.getDuration() >= min && c.getDuration() <= max) {
                    result.add(c);
                }
            }
        }
        return result;
    }





//    private List<Composition> getCurrentPlaylist() {
//        return cdChanger.get(currentDiskName);
//    }

    public List<Composition> getCurrentPlaylist() {
        return cdChanger.get(currentDiskName);
    }





    // файли
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(cdChanger);
        } catch (IOException e) {}
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            cdChanger = (Map<String, List<Composition>>) in.readObject();
        } catch (Exception e) {}
    }
}