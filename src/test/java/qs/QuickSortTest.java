package qs;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void sort() {
        var subject = new QuickSort();
        var l = new ArrayList<>(List.of(8, 7, 6, 1, 0, 9, 2));
        var expected = List.of(0, 1, 2, 6, 7, 8, 9);
        subject.sort(l);
        assertEquals(expected, l);
    }

    @Test
    public void sortWithDuplicates() {
        var subject = new QuickSort();
        var l = new ArrayList<>(List.of(8, 8, 7, 6, 1, 1, 9, 0, 9, 2));
        var expected = List.of(0, 1, 1, 2, 6, 7, 8, 8, 9, 9);
        subject.sort(l);
        assertEquals(expected, l);
    }
    @Test
    public void partitionTrivialExample() {
        var subject = new QuickSort();
        var l = new ArrayList<>(List.of(8, 7, 6, 1, 0, 9, 2));
        var expected = List.of(1, 0, 2, 8, 7, 9, 6);
        subject.partition(l, 0, l.size() - 1);
        assertEquals(expected, l);
    }

    @Test
    public void partitionWithDuplicateValues() {
        var subject = new QuickSort();
        var l = new ArrayList<>(List.of(8, 7, 6, 1, 0, 8, 2));
        var expected = List.of(1, 0, 2, 8, 7, 8, 6);
        subject.partition(l, 0, l.size() - 1);
        assertEquals(expected, l);
    }
}