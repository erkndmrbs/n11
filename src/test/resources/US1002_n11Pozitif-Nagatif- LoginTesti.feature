Feature: TC02 n11 pozitif

  @n11pozitif
  Scenario: n11 Positive login
    Given n11 com sitesi acilir.
    And Ana sayfanin acildigi kontrol edilir.
    Then Ana sayfanin header bolumunde giris buttonuna basilir.
    And  Giris yap sayfanin acildigi dogrulanir.
    And Giris yap sayfasinda e posta adresi input box ina e posta adresi girilir.
    Then Giris yap sayfasinda şifre input box ina sifre girilir.
    Then Giris yap sayfasinda giris yap butonuna basilir.
    And kullanici Login oldugunu dogrular

  @n11negatif
  Scenario Outline: negative test
    Given n11 com sitesi acilir.
    And Ana sayfanin acildigi kontrol edilir.
    Then Ana sayfanin header bolumunde giris buttonuna basilir.
    And  Giris yap sayfanin acildigi dogrulanir.
    Given Kullanıcı "<email>" ve "<password>" yanlış giriyor
    Then  Giris yap sayfasinda giris yap butonuna basilir.
    And   kullanici giris yapilamadigini test eder

    Examples:
      | email                 | password  |
      | erkndmrbs52@gmail.com | mirza123? |






