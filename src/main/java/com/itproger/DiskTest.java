package com.itproger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DiskTest {

    private Disk disk;

    @BeforeEach
    void setUp() {
        disk = new Disk();

        if (disk.getCurrentPlaylist() != null) {
            disk.getCurrentPlaylist().clear();
        }


        disk.addComposition(new Composition("Song A", "Artist 1", Style.ROCK, 300));
        disk.addComposition(new Composition("Song B", "Artist 2", Style.POP, 200));
        disk.addComposition(new Composition("Song C", "Artist 1", Style.JAZZ, 400));
    }

    @Test
    void testAddComposition() {
        Composition newSong = new Composition("New Song", "New Artist", Style.POP, 150);
        disk.addComposition(newSong);

        assertEquals(4, disk.getCurrentPlaylist().size());
        assertEquals("New Song", disk.getCurrentPlaylist().get(3).getTitle());
    }

    @Test
    void testCalculateDuration() {
        double expected = 900.0;
        double actual = disk.calculateTotalDuration();

        assertEquals(expected, actual);
    }

    @Test
    void testFilterByStyle() {
        List<Composition> results = disk.filterByStyle("Pop");

        assertEquals(1, results.size());
        assertEquals("Song B", results.get(0).getTitle());
    }

    @Test
    void testFilterByArtist() {
        List<Composition> results = disk.filterByArtist("Artist 1");

        assertEquals(2, results.size());
    }

    @Test
    void testFilterByDuration() {
        List<Composition> results = disk.filterByDuration(250, 500);

        assertEquals(2, results.size());
    }
}