package stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nicubucalaete
 * Date: 9/10/13
 * Time: 11:17 AM
 */
public class StackTest {
    private MyStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new MyStack();
    }

    @Test
    public void newStackShouldHaveSizeZero() throws Exception {
        assertThat(stack.size(), is(0));
    }

    @Test
    public void afterAPushSizeShouldBeOne() throws Exception {
        stack.push(0);

        assertThat(stack.size(), is(1));
    }

    @Test
    public void afterAPushAndAPopSizeShouldBeZero() throws Exception {
        stack.push(0);
        stack.pop();

        assertThat(stack.size(), is(0));
    }

    @Test(expected = MyStack.UnderflowException.class)
    public void poppingAnEmptyStackShouldThrowAnException() throws Exception {
        stack.pop();
    }

    @Test
    public void pushedElementShouldBeReturnedByPop() throws Exception {
        stack.push(0);

        assertThat(stack.pop(), is(0));
    }

    @Test
    public void pushedElementsShouldBePoppedInReverseOrder() throws Exception {
        stack.push(0);
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(0));
        assertThat(stack.size(),is(0));
    }
}
