package com.itproger;

import java.io.Serializable;

public class Composition implements Serializable, Comparable<Composition> {
    private String title;
    private String artist;
    private String style;
    private double duration;

    public Composition(String title, String artist, String style, double duration) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this.duration = duration;
    }

    // Геттери треба для сортування та пошуку
    public String getArtist() { return artist; }
    public String getStyle() { return style; }
    public double getDuration() { return duration; }

    @Override
    public String toString() {
        // Красивий вивід у рядок
        return String.format("Назва: %-15s | Виконавець: %-15s | Стиль: %-10s | Час: %.2f хв",
                title, artist, style, duration);
    }

    @Override
    public int compareTo(Composition o) {
        // Сортування за стилем (за алфавітом)
        return this.style.compareTo(o.style);
    }
}