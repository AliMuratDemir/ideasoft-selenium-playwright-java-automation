package com.ideasoft.playwright.pages;

import com.microsoft.playwright.Page;

public class HomePage {


    private Page page; // Bu class tüm aksiyonlarını bu Page nesnesi üzerinden yapacak


    // LOCATORLAR (Sayfadaki elementleri seçmek için)

    private String searchInput = "input[name='q']"; // Arama input kutusunun CSS selector'ü


    // CONSTRUCTOR
    // Page nesnesini class içerisine set ediyoruz, böylece testlerde aynı page üzerinden işlem yapabiliriz
    public HomePage(Page page) {
        this.page = page;
    }


    public void goToHomePage() {

        page.navigate("https://qatestcase.myideasoft.com/");
    }


    // ÜRÜN ARAMA METODU
    public void searchProduct(String productName) {
        page.fill(searchInput, productName);
        page.waitForTimeout(4000);
        page.press(searchInput, "Enter");
    }
}
