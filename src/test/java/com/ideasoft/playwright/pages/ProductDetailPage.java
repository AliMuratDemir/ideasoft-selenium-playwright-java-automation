package com.ideasoft.playwright.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ProductDetailPage {


    private Page page;

    private String quantityInput = "input[id='qty-input']";
    // Ürün adedini girmek için input alanının CSS selector'ü

    private String addToCartButton = "//a[@data-selector='add-to-cart']";
    // "Sepete ekle" butonunun CSS selector'ü

    private String successMessage = "text=SEPETİNİZE EKLENMİŞTİR";
    // Ürün sepete eklendikten sonra görünen başarı mesajı için text locator


    public ProductDetailPage(Page page) {
        this.page = page;
    }



    // Sepete ürün ekleme metodu
    public void addProductToCart(int quantity) {
        // quantityInput locator'ına istenen adet giriliyor
        page.fill(quantityInput, String.valueOf(quantity));

        page.click(addToCartButton);

    }

    // Sepete ekleme sonrası "SEPETİNİZE EKLENMİŞTİR" mesajını doğrulama
    public void verifyProductAddedMessage() {
        // assertThat ile successMessage locator'ının görünür olup olmadığı kontrol edilir
        page.waitForTimeout(1000);
        assertThat(page.locator(successMessage)).isVisible();
        System.out.println("SEPETİNİZE EKLENMİŞTİR mesajı geldi");
    }
}

