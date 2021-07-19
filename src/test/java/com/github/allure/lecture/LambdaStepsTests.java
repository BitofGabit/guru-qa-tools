package com.github.allure.lecture;

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
        Allure.parameter("Base URL", BASE_URL);
        Allure.parameter("Repository", REPOSITORY);
        Allure.parameter("Issue number", ISSUE_NUMBER);


        step("��������� ������� ��������" + BASE_URL, (s) -> {
            s.parameter("���", BASE_URL);
            open("https://github.com");
            makeScreenshot();
        });
        step("���� �����������" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $("[data-scoped-placeholder=\"Search\"]")
                    .setValue("allure-example")
                    .submit();
            makeScreenshot();
        });
        step("��������� � �����������" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText("eroshenkoam/allure-example")).click();
            makeScreenshot();
        });
        step("��������� ��� Issues � �����������", () -> {
            $("[data-content=\"Issues\"]").click();
            makeScreenshot();
        });
        step("��������� ��� Issues" + ISSUE_NUMBER + "����������", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            $(withText("#68")).should(Condition.exist);
            makeScreenshot();
        });
        sleep(3000);
    }

    @Test
    void testIssueAntiSearch(){
        step("��������� ������� ��������", () -> {
            open("https://github.com");
        });
        step("���� �����������", () -> {
            $("[data-scoped-placeholder=\"Search\"]")
                    .setValue("allure-example")
                    .submit();
        });
        step("��������� � �����������", () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("��������� ��� Issues � �����������", () -> {
            $("[data-content=\"Issues\"]").click();
        });
        step("��������� ��� Issues 68 �� ����������", () -> {
            $(withText("#68")).should(Condition.exist);
        });
        sleep(3000);
    }

    private void makeScreenshot() {
        InputStream stream = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", stream);
    }
}
