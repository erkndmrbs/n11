package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;

public class Hooks {

    // Cucumber'da feature ve stepdefinition eslesmesi class seviyesinde degil
    // package seviyesindedir
    // dolayisiyla @Before ve @After stepdefinitions package'i altinda herhangi bir yerde olabilir
    // ancak uygulamada genellikle Hooks isminde bir class olusturup onun
    // icine konulur

    @Before
    public void setUp(){

    }

    @AfterStep
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        String actualURL="";
        if (actualURL.length()!=Driver.getDriver().getCurrentUrl().length()) {
        scenario.attach(screenshot, "image/jpg",Driver.getDriver().getTitle()+" screenshots");

      }
     // Driver.closeDriver();
    }

    static int count=1;
    public static void getscreenshot() throws Exception {

        File scr = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File(("user.dir")+"screenshot" + (count++) +".png");
        FileUtils.copyFile(scr, dest);
        Thread.sleep(3000);
    }

}