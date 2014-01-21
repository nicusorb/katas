package org.katas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.katas.WordWrap.wrap;

public class WordWrapTest {
    @Test
    public void doNotWrap_ifFitTheColumnLength() throws Exception {
        assertThat(wrap("abcd", 4), is("abcd"));
    }

    @Test
    public void doNotWrap_ifContainsNoSpaces() throws Exception {
        assertThat(wrap("abcd", 2), is("abcd"));
    }


}
