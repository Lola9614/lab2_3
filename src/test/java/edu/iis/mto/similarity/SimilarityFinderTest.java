package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class SimilarityFinderTest {

    @Test
    public void caseThatSequenceHaveSameLengthAndAreSame() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcher() {

            @Override public SearchResult search(int key, int[] seq) {
                return SearchResult.builder().withFound(true).build();
            }
        });

        int[] firstSequence = {1, 2, 3};
        int[] secondSequence = {1, 2, 3};
        double expectedResult = 1.0;

        double similarityResult = finder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assert.assertThat(similarityResult, is(expectedResult));
    }

    @Test
    public void caseThatSequenceHaveSameLengthAndNotTheSame() {

        SimilarityFinder finder = new SimilarityFinder(new SequenceSearcher() {

            @Override public SearchResult search(int key, int[] seq) {
                return SearchResult.builder().withFound(false).build();
            }
        });

        int[] firstSequence = {1, 2, 3};
        int[] secondSequence = {1, 2, 3};
        double expectedResult = 0.0;

        double similarityResult = finder.calculateJackardSimilarity(firstSequence, secondSequence);

        Assert.assertThat(similarityResult, is(expectedResult));
    }
}