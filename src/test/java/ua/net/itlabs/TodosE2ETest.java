package ua.net.itlabs;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import ua.net.itlabs.categories.Smoke;
import ua.net.itlabs.testconfig.BaseTest;

import static ua.net.itlabs.pages.TodoMVC.*;

@Category(Smoke.class)
public class TodosE2ETest extends BaseTest {

    @Test
    public void testTasksCommonFlow() {
        givenAtAll();

        add("1");
        startEdit("1", "1 edited").pressEnter();
        assertTasks("1 edited");
        assertItemsLeft(1);

        filterActive();
        assertTasks("1 edited");

        //complete
        toggle("1 edited");
        assertNoTasks();

        filterCompleted();
        assertTasks("1 edited");

        filterAll();
        assertTasks("1 edited");

        delete("1 edited");
        assertNoTasks();
    }
}
