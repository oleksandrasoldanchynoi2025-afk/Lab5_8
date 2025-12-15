package com.itproger;

import java.io.*;
import java.util.*;

public class Disk {
    private List<Composition> playlist = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final String FILE_NAME = "database.txt";

    public Disk() {
        loadFromFile();
    }

    public void addComposition() {
        System.out.println("\n-> Додавання нової пісні");

        System.out.print("Назва: ");
        String title = scanner.next();

        System.out.print("Виконавець: ");
        String artist = scanner.next();

        System.out.print("Стиль (Rock/Pop/Jazz): ");
        String style = scanner.next();

        System.out.print("Тривалість (хв, через кому, наприклад 3,5): ");
        double duration = scanner.nextDouble(); // Тут просто зчитуємо число


        playlist.add(new Composition(title, artist, style, duration));
        System.out.println("+ Успішно додано!");
        saveToFile();
    }


    public void showCompositions() {
        System.out.println("\n-> Вміст диску:");
        if (playlist.isEmpty()) {
            System.out.println("Пусто.");
        }
        for (Composition c : playlist) {
            System.out.println(c);
        }
    }


    public void calculateDuration() {
        double total = 0;
        for (Composition c : playlist) {
            total += c.getDuration();
        }
        System.out.println("\n-> Загальна тривалість: " + total + " хв.");
    }


    public void sortByStyle() {
        System.out.print("Введіть стиль, який показати (Rock/Pop/Jazz): ");
        String targetStyle = scanner.next(); // Зчитуємо бажаний стиль

        System.out.println("\n--- Композиції стилю " + targetStyle + " ---");
        boolean found = false;

        for (Composition c : playlist) {
            // equalsIgnoreCase означає, що "rock" і "Rock" будуть вважатися однаковими
            if (c.getStyle().equalsIgnoreCase(targetStyle)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Такого стилю не знайдено.");
        }
    }

    // --- ПОШУК ПО АВТОРУ ---
    public void findByArtist() {
        System.out.print("Введіть виконавця: ");
        String name = scanner.next();
        for (Composition c : playlist) {
            if (c.getArtist().equalsIgnoreCase(name)) {
                System.out.println(c);
            }
        }
    }

    // --- ПОШУК ПО ДІАПАЗОНУ ---
    public void findByDurationRange() {
        System.out.print("Від (хв): ");
        double min = scanner.nextDouble();
        System.out.print("До (хв): ");
        double max = scanner.nextDouble();

        for (Composition c : playlist) {
            if (c.getDuration() >= min && c.getDuration() <= max) {
                System.out.println(c);
            }
        }
    }

    // --- РОБОТА З ФАЙЛАМИ ---
    // (Тут try-catch обов'язковий за правилами мови Java)

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(playlist);
        } catch (IOException e) {
            System.out.println("Помилка запису файлу.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            playlist = (List<Composition>) in.readObject();
        } catch (Exception e) {
            // Якщо файлу нема або помилка - просто ігноруємо, список буде пустим
        }
    }
}