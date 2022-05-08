package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petshorePojo;

import java.util.*;

import static io.restassured.RestAssured.given;

public class petshoreSteps {
    Response response;

    petshorePojo pojo = new petshorePojo("erkan", "erkan", "demirtas", "erkan@petshore.com", "abc123", "55551521", "0");

    @Given("kullanici post request icin gerekli pathprams ayarlarini yapar")
    public void kullaniciPostRequestIcinGerekliPathpramsAyarlariniYapar() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("id", 1212);
        body.put("username", "erkan");
        body.put("firstName", "erkan");
        body.put("lastName", "demirtas");
        body.put("email", "erkan@petshore.com");
        body.put("password", "abc123");
        body.put("phone", "45432423");
        body.put("userStatus", "121");

        List<HashMap<String, Object>> arr = new ArrayList<>();
        arr.add(body);
        // yeni.add(String.valueOf(pojo));

        response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123").body(arr)
                .when().post("https://petstore.swagger.io/v2/user/createWithList");

    }

    @Then("kullanici post sonrası aldıgı responsu ekrana yazdirir")
    public void kullaniciPostSonrasıAldıgıResponsuEkranaYazdirir() {
        response.prettyPrint();
    }

    @And("kullanici gelen veriyi dogrular")
    public void kullaniciGelenVeriyiDogrular() {
        //{
        //    "code": 200,
        //    "type": "unknown",
        //    "message": "ok"
        //}

        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("ok", json.get("message"));

    }

    @Given("kullanici get request icin pathparams ayarlarini yapar")
    public void kullaniciGetRequestIcinPathparamsAyarlariniYapar() {

        response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123")
                .when().get("https://petstore.swagger.io/v2/user/Erkan");
    }

    @And("kullanici get sonrasi aldigi responsu yazdırır")
    public void kullaniciGetSonrasiAldigiResponsuYazdırır() {
        response.prettyPrint();
    }

    @And("kullanici response ile gelen cevabi beklenen cevap ile karsilastirir")
    public void kullaniciResponseIleGelenCevabiBeklenenCevapIleKarsilastirir() {
        /**
         {

         "username": "Erkan",
         "firstName": "erkan",
         "lastName": "dmrbs",
         "email": "alıvelı@gmail.com",
         "password": "123456",
         "phone": "456789123",
         "userStatus": 0
         }
         */
        JsonPath json = response.jsonPath();
        Assert.assertEquals("Erkan", json.get("username"));
        Assert.assertEquals("erkan", json.get("firstName"));
        Assert.assertEquals("dmrbs", json.get("lastName"));
        Assert.assertEquals("alıvelı@gmail.com", json.get("email"));
        Assert.assertEquals("123456", json.get("password"));
        Assert.assertEquals("456789123", json.get("phone"));
        Assert.assertEquals(0, json.getInt("userStatus"));

    }

    @Given("kullanici put islemi icin request yollar")
    public void kullanici_put_islemi_icin_request_yollar() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("password", 123456789);

        response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123").body(map)
                .when().put("https://petstore.swagger.io/v2/user/Erkan");
    }

    @Given("kullanici put sonrasi aldigi responsu yazdirir")
    public void kullanici_put_sonrasi_aldigi_responsu_yazdirir() {
        response.prettyPrint();
    }

    @Given("kullanici put dan gelen veriyi dogrular")
    public void kullanici_put_dan_gelen_veriyi_dogrular() {
        //{
        //    "code": 200,
        //    "type": "unknown",
        //    "message": "0"
        //}
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("0", json.get("message"));

    }

    @Given("kullanici delete islemi icin request yollar")
    public void kullanici_delete_islemi_icin_request_yollar() {
        response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123")
                .when().delete("https://petstore.swagger.io/v2/user/Erkan");
    }
    @Given("kullanici delete sonrasi aldigi responsu yazdirir")
    public void kullanici_delete_sonrasi_aldigi_responsu_yazdirir() {
        response.prettyPrint();
    }
    @Given("Kullanici silme isleminin yapildigini dogrular")
    public void kullanici_silme_isleminin_yapildigini_dogrular() {
        //{
        //    "code": 200,
        //    "type": "unknown",
        //    "message": "Erkan"
        //}

        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("Erkan", json.get("message"));


    }


}