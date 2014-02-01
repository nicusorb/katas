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

    @Test
    public void doNotWrap_ifSmallerThanLength() throws Exception {
        assertThat(wrap("ab c", 4), is("ab c"));
    }

    @Test
    public void doNotWrap_ifFitsTheLength() throws Exception {
        assertThat(wrap("ab cd", 5), is("ab cd"));
    }

    @Test
    public void wrapLine_ifContainsOneSpace() throws Exception {
        assertThat(wrap("ab cd", 2), is("ab\ncd"));
    }

    @Test
    public void wrapLine_ifContainsMultipleSpaces() throws Exception {
        assertThat(wrap("abcd abcd abcd", 4), is("abcd\nabcd\nabcd"));
    }

    @Test
    public void wrapLineToTheFirstSpaceBeforeColumnLength() throws Exception {
        assertThat(wrap("ab cd e", 3), is("ab\ncd\ne"));
    }

    @Test
    public void wrapAfterColumnLength_ifNoSpacesAreFound() throws Exception {
        assertThat(wrap("abcd abc", 3), is("abcd\nabc"));
    }

    @Test
    public void doNotWrapLinesWithSpaces_ifFitTheLength() throws Exception {
        assertThat(wrap("abcd a  bc", 5), is("abcd\na  bc"));
        assertThat(wrap("a  d a  bc", 5), is("a  d\na  bc"));
    }
}
