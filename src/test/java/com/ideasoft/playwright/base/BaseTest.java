package com.ideasoft.playwright.base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*; // Toolkit ve Dimension için gerekli

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    void setUp() {

        // EKRAN BOYUTUNU AL

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();   // ekran genişliği
        int height = (int) screenSize.getHeight(); // ekran yüksekliği


        // Playwright'i başlat

        playwright = Playwright.create();

        // Chromium tarayıcıyı headless=false (görünür) aç
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false) // tarayıcı görünür olacak
        );


        page = browser.newPage();

        // Viewport'u ekran boyutuna ayarla → tam ekran gibi
        page.setViewportSize(width, height);


    }

    @AfterEach
    void tearDown() {
        // Browser ve Playwright'i kapat
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
