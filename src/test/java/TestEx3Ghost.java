import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ghost.GhostForumPage;
import pages.ghost.GhostHomePage;

public class TestEx3Ghost extends Base {
    protected static WebDriver driver;

    private GhostHomePage ghostHomePage;
    private GhostForumPage ghostForumPage;


    @Test
    public void searchBlog() throws Exception {

        ghostHomePage = PageFactory.initElements(driver, GhostHomePage.class);
        ghostForumPage = ghostHomePage.goToForumPage();
    }

}
