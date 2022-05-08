Feature: Petshore shcemas

  Scenario: Post Request
    Given kullanici post request icin gerekli pathprams ayarlarini yapar
    Then  kullanici post sonrası aldıgı responsu ekrana yazdirir
    And   kullanici gelen veriyi dogrular

  Scenario: Get Request
    Given kullanici get request icin pathparams ayarlarini yapar
    And   kullanici get sonrasi aldigi responsu yazdırır
    And   kullanici response ile gelen cevabi beklenen cevap ile karsilastirir


  Scenario: Put Request
    Given  kullanici put islemi icin request yollar
    And    kullanici put sonrasi aldigi responsu yazdirir
    And    kullanici put dan gelen veriyi dogrular


  Scenario:  Delete Request
    Given kullanici delete islemi icin request yollar
    And   kullanici delete sonrasi aldigi responsu yazdirir
    And   Kullanici silme isleminin yapildigini dogrular