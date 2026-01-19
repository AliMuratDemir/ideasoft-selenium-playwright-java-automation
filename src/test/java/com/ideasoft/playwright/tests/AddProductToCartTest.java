package com.ideasoft.playwright.tests;

import com.ideasoft.playwright.base.BaseTest;
import com.ideasoft.playwright.pages.CartPage;
import com.ideasoft.playwright.pages.HomePage;
import com.ideasoft.playwright.pages.ProductDetailPage;
import com.ideasoft.playwright.pages.SearchResultsPage;
import org.junit.jupiter.api.Test;
import com.ideasoft.playwright.pages.*;

public class AddProductToCartTest extends BaseTest {

    @Test
    void addProductToCartAndVerify() {


        // BaseTest'ten gelen 'page' nesnesi kullanılıyor

        HomePage homePage = new HomePage(page);
        SearchResultsPage searchResultsPage = new SearchResultsPage(page);
        ProductDetailPage productDetailPage = new ProductDetailPage(page);
        CartPage cartPage = new CartPage(page);


        // 1. Siteye git

        homePage.goToHomePage();
        // goToHomePage() metoduyla ana sayfaya gidiyoruz


        // 2. Ürün ara

        homePage.searchProduct("ürün");
        // Arama kutusuna "ürün" yazıp arama butonuna tıklıyoruz


        // 3. Arama sonucundan ürüne gir

        searchResultsPage.clickFirstProduct();
        // Arama sonuçlarının ilk ürününe tıklıyoruz


        // 4. 5 adet sepete ekle

        productDetailPage.addProductToCart(5);
        // Ürün adedini 5 olarak girip "Sepete Ekle" butonuna tıklıyoruz


        // 5. Başarılı mesajı kontrol et

        productDetailPage.verifyProductAddedMessage();
        // Ürün sepete eklendikten sonra "SEPETİNİZE EKLENMİŞTİR" mesajı görünür mü kontrol ediyoruz


        // 6. Sepete git

        cartPage.goToCart();
        // Sepet sayfasına gidiyoruz


        // 7. Sepette 5 adet olduğunu kontrol et

        cartPage.verifyProductQuantity(5);
        // Sepette ürün adedinin 5 olup olmadığını doğruluyoruz
    }
}

