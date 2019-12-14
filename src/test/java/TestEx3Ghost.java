import framework.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ghost.GhostHomePage;

public class TestEx3Ghost extends TestBase {
    private GhostHomePage ghostHomePage;

    @Test
    public void searchBlog() {

        //  a. Navigate to https://ghost.org/
        navigateToURL("https://ghost.org/");
        ghostHomePage = PageFactory.initElements(driver, GhostHomePage.class);

        /*
            b. Navigate to "Community Forum" section using the "Resources" menu.
            c. Search for “create new blog”
            d. Open one of the search results
        */
        ghostHomePage.goToForumPage()
                .searchData("create new blog")
                .openOneSearchResult();


    }
}
