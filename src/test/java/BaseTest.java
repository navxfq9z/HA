import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.WebDriverManager;

/**
 * Created by navaneeth.basavaraj on 6/27/2016.
 */
@Test(groups = "SELENIUM")
public abstract class BaseTest {

	protected ThreadLocal<WebDriverManager> webDriverManager = new ThreadLocal<WebDriverManager>();
	protected final int threadSize = 1;

	@BeforeMethod
	public final synchronized void setup(){
		webDriverManager.set(new WebDriverManager());
	}

	@AfterMethod
	public final synchronized void tearDown(){
		webDriverManager.get().cleanUp();
	}

}
