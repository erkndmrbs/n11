package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class N11Pages {
    public N11Pages() {PageFactory.initElements(Driver.getDriver(),this);  }



    @FindBy (css = "[class=\"btnSignIn\"]")
    public WebElement headerGirisButton;

    @FindBy (css = "[id=\"email\"]")
    public WebElement emailGirisİnput;


    @FindBy (css = "[id=\"password\"]")
    public WebElement passwordGirisİnput;

    @FindBy (id="loginButton")
    public WebElement girisyapButton;

    @FindBy (xpath = "(//a[@title='Hesabım'])[1]")
    public WebElement myAccountButton;

    @FindBy (css="[id=\"searchData\"]")
    public WebElement aramaKutusu;

    @FindBy (xpath = "([class=\"resultText \"]")
    public WebElement iphonearamasonucyazisi;

    @FindBy (xpath = "(//a[@href=\"https://www.n11.com/arama?q=iphone&pg=2\"])[1]")
    public WebElement ikincisayfa;

    @FindBy(css = "[title=\"Favorilerim / Listelerim\"]")
    public WebElement headerLoginUnderFavorilerimButonu;

    @FindBy(xpath = "(//h4[@class=\"listItemTitle\"])[1]")
    public WebElement favoriPageFavorilerimButton;

    @FindBy(css = "[class=\"deleteProFromFavorites\"]")
    public WebElement favoripageDeleteProductButon;
    @FindBy(xpath = "(//h3[@class=\"productName \"])[1]")
    public List<WebElement> favoriListemIlkUrun;
    @FindBy(css = "[class=\"logoutBtn\"]")
    public WebElement headerLoginUnderLogOutButonu;
    @FindBy(css = "[class=\"btn btnBlack confirm\"]")
    public WebElement confirmDeleteButonu;
    @FindBy(xpath = "(//div[@class=\"errorMessage\"])")
    public List<WebElement> loginPageErrorTexts;


    public void ClearBrowserCache()  {
        Driver.getDriver().manage().deleteAllCookies();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}