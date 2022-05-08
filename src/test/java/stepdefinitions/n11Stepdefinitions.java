package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.N11Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.List;


public class n11Stepdefinitions {

    WebDriverWait wait;
    N11Pages obje = new N11Pages();
    Actions actions;

    @Given("n{int} com sitesi acilir.")
    public void nComSitesiAcilir(int arg0) throws Exception {

        Driver.getDriver().navigate().to(ConfigReader.getProperty("n11Url"));
        obje.ClearBrowserCache();

    }

    @And("Ana sayfanin acildigi kontrol edilir.")
    public void anaSayfaninAcildigiKontrolEdilir() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(webDriver-> ((JavascriptExecutor)Driver.getDriver()).executeScript("return document.readyState").equals("complete"));
        // JavascriptExecutor kullanarak sayfanin yüklenmesini bekliyoruz
        String actual= Driver.getDriver().getCurrentUrl();
        String expected = "https://www.n11.com/";
        Assert.assertEquals(expected,actual);
    }

    @And("Ana sayfanin header bolumunde giris buttonuna basilir.")
    public void anaSayfaninHeaderBolumundeGirisButtonunaBasilir() {
        obje.headerGirisButton.click();
    }


    @Then("Giris yap sayfanin acildigi dogrulanir.")
    public void girisYapSayfaninAcildigiDogrulanir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("giris-yap"));
    }

    @And("Giris yap sayfasinda e posta adresi input box ina e posta adresi girilir.")
    public void girisYapSayfasindaEPostaAdresiInputBoxInaEPostaAdresiGirilir() {
      obje.emailGirisİnput.sendKeys(ConfigReader.getProperty("n11email"));
    }

    @Then("Giris yap sayfasinda şifre input box ina sifre girilir.")
    public void girisYapSayfasindaŞifreInputBoxInaSifreGirilir() {
        obje.passwordGirisİnput.sendKeys(ConfigReader.getProperty("n11sifre"));
    }

    @And("Giris yap sayfasinda giris yap butonuna basilir.")
    public void girisYapSayfasindaGirisYapButonunaBasilir() {

        obje.girisyapButton.click();
        ReusableMethods.waitFor(2);
    }

    @And("kullanici Login oldugunu dogrular")
    public void kullaniciLoginOldugunuDogrular() throws Exception {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(webDriver-> ((JavascriptExecutor)Driver.getDriver()).executeScript("return document.readyState").equals("complete"));
        // JavascriptExecutor kullanarak sayfanin yüklenmesini bekliyoruz
        Assert.assertTrue(obje.myAccountButton.isDisplayed());
    }


    @Then("kullanici arama kutusuna	iphone kelimesi yazar ve arama tusuna basar .")
    public void kullaniciAramaKutusunaIphoneKelimesiYazarVeAramaTusunaBasar() {

    obje.aramaKutusu.clear();
    obje.aramaKutusu.sendKeys("iphone",Keys.ENTER);
    }
    @And("iphone kelimesi aratildiği dogrulanir")
    public void iphoneKelimesiAratildiğiDogrulanir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("iphone"));

    }


    @Then("Arama sonuçlari sayfasindan ikinci sayfa açilir.")
    public void aramaSonuçlariSayfasindanIkinciSayfaAçilir() {
        JSUtils.scrollIntoVIewJS(obje.ikincisayfa);
   ReusableMethods.waitFor(2);
      JSUtils.clickElementByJS(obje.ikincisayfa);


    }

    @And("{int}. sayfanin açildiği kontrol edilir.")
    public void sayfaninAçildiğiKontrolEdilir(int sayfa) {
ReusableMethods.waitFor(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("pg=2"));

    }

    @And("Sayfadaki {int}. ürün favorilere eklenir.")
    public void sayfadakiÜrünFavorilereEklenir(int urunSirasi) {
        String urunPath="(//span[@title=\"Favorilere ekle\"])["+urunSirasi+"]";
        Driver.getDriver().findElement(By.xpath(urunPath)).click();
    }

    @Then("Hesabim istek Listem Favorilerim sayfasina gidilir.")
    public void hesabimIstekListemFavorilerimSayfasinaGidilir() {
       JSUtils.scrollIntoVIewJS(obje.myAccountButton);
        ReusableMethods.hover(obje.myAccountButton);
        ReusableMethods.waitFor(2);
        obje.headerLoginUnderFavorilerimButonu.click();
    }

    @Then("“Favorilerim” sayfasi açildiği kontrol edilir.")
    public void favorilerimSayfasiAçildiğiKontrolEdilir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("istek-listelerim"));

    }

    @Then("Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.")
    public void eklenenÜrünFavorilerdenSilinirVeSilmeIşlemiKontrolEdilir() {
        obje.favoriPageFavorilerimButton.click();
        ReusableMethods.waitFor(3);
        String urun=obje.favoriListemIlkUrun.get(0).getText();
        System.out.println("Favori Listesine Eklenilen Urun: " + urun);
        obje.favoripageDeleteProductButon.click();
        ReusableMethods.waitFor(2);
        obje.confirmDeleteButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(urun+" urun silinmedi.",obje.favoriListemIlkUrun.size()==0);


    }

    @Then("Üye çikiş işlemi yapilir.")
    public void üyeÇikişIşlemiYapilir() {
        ReusableMethods.hover(obje.myAccountButton);
        ReusableMethods.waitFor(2);
        obje.headerLoginUnderLogOutButonu.click();
    }



  //   >>> Negative>>>>
    @Given("Kullanıcı {string} ve {string} yanlış giriyor")
    public void kullanıcıVeYanlışGiriyor(String  email  , String password ) {
        actions=new Actions(Driver.getDriver());
        obje.emailGirisİnput.clear();
        obje.passwordGirisİnput.clear();
        //Scenario Outline ile veri gonderme
        actions.click(obje.emailGirisİnput).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(password).perform();

        ReusableMethods.waitFor(2);
        obje.girisyapButton.click();


    }

    @And("kullanici giris yapilamadigini test eder")
    public void kullaniciGirisYapilamadiginiTestEder() {
      ReusableMethods.waitFor(2);
       List<String>hatamesaji= ReusableMethods.getElementsText(By.xpath("(//div[@class=\"errorMessage\"])"));
        System.out.println(hatamesaji);
        System.out.println(hatamesaji.size());
        Assert.assertTrue(hatamesaji.size()!=0);
        obje.ClearBrowserCache();
        Driver.closeDriver();
    }




}
