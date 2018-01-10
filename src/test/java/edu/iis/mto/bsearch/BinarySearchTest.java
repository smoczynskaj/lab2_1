package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Justyna on 10.01.2018.
 */
public class BinarySearchTest {

    @Test
    public void hasElementInSingleSequence() throws Exception {

        int[] seq = new int[]{5};

        SearchResult result = BinarySearch.search(5, seq);

        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    public void hasNotElementInSingleSequence() throws Exception {

        int[] seq = new int[]{5};

        SearchResult result = BinarySearch.search(7, seq);

        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    public void isFirstElement() throws Exception {

        int[] seq = new int[]{2, 3, 5, 11, 13, 17};

        SearchResult result = BinarySearch.search(2, seq);

        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    public void isLastElement() throws Exception {

        int[] seq = new int[]{2, 3, 5, 11, 13, 17};

        SearchResult result = BinarySearch.search(17, seq);

        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 6);
    }
}