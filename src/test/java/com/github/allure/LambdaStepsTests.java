package com.github.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTests {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    void testIssueSearch(){
        step("Открываем главную страницу" + BASE_URL, (s) -> {
            s.parameter("Урл", BASE_URL);
            open("https://github.com");
            makeScreenshot();
        });
        step("Ищем репозиторий" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $("[data-scoped-placeholder=\"Search\"]")
                    .setValue("allure-example")
                    .submit();
            makeScreenshot();
        });
        step("Переходим в репозиторий" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText("eroshenkoam/allure-example")).click();
            makeScreenshot();
        });
        step("Открываем Таб Issues в репозиторий", () -> {
            $("[data-content=\"Issues\"]").click();
            makeScreenshot();
        });
        step("Проверяем что Issues" + ISSUE_NUMBER + "существует", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            $(withText("#68")).should(Condition.exist);
            makeScreenshot();
        });
        sleep(3000);
    }

    @Test
    void testIssueAntiSearch(){
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий", () -> {
            $("[data-scoped-placeholder=\"Search\"]")
                    .setValue("allure-example")
                    .submit();
        });
        step("Переходим в репозиторий", () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Открываем Таб Issues в репозиторий", () -> {
            $("[data-content=\"Issues\"]").click();
        });
        step("Проверяем что Issues 68 НЕ существует", () -> {
            $(withText("#68")).should(Condition.exist);
        });
        sleep(3000);
    }

    private void makeScreenshot() {
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", stream);
    }
}
