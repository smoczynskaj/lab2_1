import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class SearchTest {

    private SearchResult searchResult;
    private int key;
    private int[] seq;

    @Test
    public void searchShouldReturnExceptionWhenZeroElementInputSequence() {
        key = 1;
        seq = new int[] {};
        searchResult = BinarySearch.search(key, seq);
        assertNotNull(IllegalArgumentException.class);
    }

    @Test
    public void searchShouldReturnIsInSequenceWhenOneElementInputSequence() {
        key = 1;
        seq = new int[] {1};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(true));
    }

    @Test
    public void searchShouldReturnIsNotInSequenceWhenOneElementInputSequence() {
        key = 1;
        seq = new int[] {2};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(false));
    }

    @Test
    public void searchShouldReturnIsFirstInSequenceWhenMultiElementInputSequence() {
        key = 1;
        seq = new int[] {1, 2, 3};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.is(0));
    }

    @Test
    public void searchShouldReturnIsLastInSequenceWhenMultiElementInputSequence() {
        key = 3;
        seq = new int[] {1, 2, 3};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.is(seq.length - 1));
    }

    @Test
    public void searchShouldReturnIsMiddleInSequenceWhenMultiElementInputSequence() {
        key = 2;
        seq = new int[] {1, 2, 3};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.is(seq.length / 2));
    }

    @Test
    public void searchShouldReturnIsNotInSequenceWhenMultiElementInputSequence() {
        key = 4;
        seq = new int[] {1, 2, 3};
        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.is(-1));
    }
}
