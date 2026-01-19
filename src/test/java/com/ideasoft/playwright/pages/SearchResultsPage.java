package com.ideasoft.playwright.pages;

import com.microsoft.playwright.Page;

public class SearchResultsPage {


    private Page page;


    // LOCATORLAR (Sayfadaki elementleri seçmek için)

    private String firstProduct = "a[title='YeniUrun']";


    // CONSTRUCTOR

    // Testlerden gelen Page nesnesini class'a set ediyoruz
    // Böylece tüm metodlar aynı sayfa üzerinde çalışabilir
    public SearchResultsPage(Page page) {
        this.page = page;
    }


    // Arama sonuçlarından ilk ürüne tıklar
    public void clickFirstProduct() {
        // .first() → locator birden fazla element döndürebilir, ilkini seçiyoruz
        page.locator(firstProduct).first().click();
        page.waitForTimeout(4000);
    }
}

