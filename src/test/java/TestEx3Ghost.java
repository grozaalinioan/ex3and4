import framework.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ghost.GhostForumPage;
import pages.ghost.GhostHomePage;

public class TestEx3Ghost extends TestBase {
    private GhostHomePage ghostHomePage;
    private GhostForumPage ghostForumPage;

    @Test
    public void searchBlog() {

        // a. Navigate to https://ghost.org/
        navigateToURL("https://ghost.org/");

        //b. Navigate to "Community Forum" section using the "Resources" menu.
        ghostHomePage = PageFactory.initElements(driver, GhostHomePage.class);
        ghostForumPage = ghostHomePage.goToForumPage();

        //c. Search for “create new blog”
        //d. Open one of the search results
        ghostForumPage.searchData("create new blog")
                .openOneSearchResult();
    }
}
