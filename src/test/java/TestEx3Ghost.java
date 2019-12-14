import framework.TestBase;
import org.testng.annotations.Test;
import pages.ghost.GhostHomePage;

public class TestEx3Ghost extends TestBase {

    @Test
    public void searchBlog() {
        /*
            a. Navigate to https://ghost.org/
            b. Navigate to "Community Forum" section using the "Resources" menu.
            c. Search for “create new blog”
            d. Open one of the search results
        */

        new GhostHomePage(driver)
                .goToForumPage()
                .searchData("create new blog")
                .openOneSearchResult();
    }
}
