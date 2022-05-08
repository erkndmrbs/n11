Feature:  n11 search

  @n11
  Scenario: n11 Search Testi
    Given n11 com sitesi acilir.
    And  Ana sayfanin acildigi kontrol edilir.
    And  Ana sayfanin header bolumunde giris buttonuna basilir.
    Then Giris yap sayfanin acildigi dogrulanir.
    And  Giris yap sayfasinda e posta adresi input box ina e posta adresi girilir.
    Then Giris yap sayfasinda şifre input box ina sifre girilir.
    And  Giris yap sayfasinda giris yap butonuna basilir.
    And  kullanici Login oldugunu dogrular
    Then kullanici arama kutusuna	iphone kelimesi yazar ve arama tusuna basar .
    And  iphone kelimesi aratildiği dogrulanir
    Then Arama sonuçlari sayfasindan ikinci sayfa açilir.
    And  2. sayfanin açildiği kontrol edilir.
    And  Sayfadaki 3. ürün favorilere eklenir.
    Then Hesabim istek Listem Favorilerim sayfasina gidilir.
    Then “Favorilerim” sayfasi açildiği kontrol edilir.
    Then Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.
    Then Üye çikiş işlemi yapilir.
