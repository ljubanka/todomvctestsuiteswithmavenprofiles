package ua.net.itlabs;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import ua.net.itlabs.categories.Buggy;
import ua.net.itlabs.categories.Smoke;
import ua.net.itlabs.testconfig.BaseTest;

import static ua.net.itlabs.pages.TodoMVC.*;
import static ua.net.itlabs.pages.TodoMVC.TaskType.ACTIVE;
import static ua.net.itlabs.pages.TodoMVC.TaskType.COMPLETED;

public class TodosOperationsAtAllFilterTest extends BaseTest {


    @Test
    @Category(Smoke.class)
    public void testComplete() {
        givenAtAll(ACTIVE, "1", "2");

        toggle("2");
        assertTasks("1", "2");
        assertItemsLeft(1);
    }

    @Test
    @Category(Buggy.class)
    public void testReopen() {
        givenAtAll(COMPLETED, "1", "2");

        toggle("2");
        assertTasks("1", "2");
        assertItemsLeft(2);
    }

    @Test
    public void testCompleteAll() {
        givenAtAll(aTask("1", ACTIVE), aTask("2", COMPLETED), aTask("3", ACTIVE));

        toggleAll();
        assertTasks("1", "2", "3");
        assertItemsLeft(0);
    }

    @Test
    @Category(Smoke.class)
    public void testClearCompleted() {
        givenAtAll(COMPLETED, "1", "2", "3");

        clearCompleted();
        assertNoTasks();
    }

    @Test
    public void testCancelEdit() {
        givenAtAll(ACTIVE, "1");

        startEdit("1", "1 cancel edit").pressEscape();
        assertTasks("1");
        assertItemsLeft(1);
    }

    @Test
    public void testEditClickTab() {
        givenAtAll(ACTIVE, "1", "2", "3");

        startEdit("2", "2 edited").pressTab();
        assertTasks("1", "2 edited", "3");
        assertItemsLeft(3);
    }

    @Test
    public void testDeleteByEmpty() {
        givenAtAll(ACTIVE, "1", "2", "3");

        startEdit("2", "").pressEnter();
        assertTasks("1", "3");
    }
}
