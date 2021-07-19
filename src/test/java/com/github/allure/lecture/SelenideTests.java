package com.github.allure.lecture;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $("[data-scoped-placeholder=\"Search\"]")
                .setValue(REPOSITORY)
                .submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("[data-content=\"Isues\"]").click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }
}