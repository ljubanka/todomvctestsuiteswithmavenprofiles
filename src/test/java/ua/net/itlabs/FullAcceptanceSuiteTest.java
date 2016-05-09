package ua.net.itlabs;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ua.net.itlabs.categories.Buggy;
import ua.net.itlabs.operations.TodosE2ETest;
import ua.net.itlabs.operations.TodosOperationsAtAllFilter;

@RunWith(Categories.class)
@Suite.SuiteClasses({TodosOperationsAtAllFilter.class, TodosE2ETest.class})
@Categories.ExcludeCategory(Buggy.class)
public class FullAcceptanceSuiteTest {
}
