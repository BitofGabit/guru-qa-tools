package com.google;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    static Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @BeforeAll
    static void config() {
        logger.info("BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.headless = true;
    }

    @BeforeEach
    void openGooglePage() {
        logger.info("BeforeEach method");
        open("https://google.com/");
    }

    @Test
    void selenideSearchTest() {
        logger.info("This is selenide test!");
        $(byName("q")).setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        logger.info("This is allure test!");
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
}