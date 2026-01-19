package com.ideasoft.playwright.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class CartPage {


    private Page page;


    private String quantityInCart = "input[data-selector='qty']";


    public CartPage(Page page) {
        this.page = page;
    }


    // Sepet sayfasına gitme metodu
    public void goToCart() {
        // Belirtilen URL'ye gider. Sepet sayfasına ulaşmak için kullanılır
        page.navigate("https://qatestcase.myideasoft.com/sepet");
        page.waitForTimeout(2000);
    }

    // Sepetteki ürün adedini doğrulama metodu
    public void verifyProductQuantity(int expectedQuantity) {
        //  input alanındaki mevcut değeri alır
        String actualQuantity = page.locator(quantityInCart).inputValue();

        System.out.println("Sepetteki adet: " + actualQuantity);

        // assertThat ile input değerinin beklenen quantity ile eşleşip eşleşmediğini kontrol eder
        assertThat(page.locator(quantityInCart))
                .hasValue(String.valueOf(expectedQuantity));
        // Eğer eşleşmezse test fail olur
    }
}


