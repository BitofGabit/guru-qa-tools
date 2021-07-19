package com.github.allure.lecture;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("���� ����������� {repo}")
    public void searchForRepo(String repo){
        $("[data-scoped-placeholder=\"Search\"]")
                .setValue(repo)
                .submit();
    }
    @Step("��������� � ����������� {repo}")
    public void goToRepo(String repo){
        $(By.linkText(repo)).click();
    }
    @Step("��������� ��� Issues � �����������")
    public void openIssueTab(){
        $("[data-content=\"Issues\"]").click();
    }
    @Step("��������� ��� Issues {number} ����������")
    public void shouldSeeIssueWithNumber(int number){
        $(withText(String.valueOf(number))).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
