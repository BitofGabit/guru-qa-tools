package com.github.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepo(String repo){
        $("[data-scoped-placeholder=\"Search\"]")
                .setValue(repo)
                .submit();
    }
    @Step("Переходим в репозиторий {repo}")
    public void goToRepo(String repo){
        $(By.linkText(repo)).click();
    }
    @Step("Открываем Таб Issues в репозиторий")
    public void openIssueTab(){
        $("[data-content=\"Issues\"]").click();
    }
    @Step("Проверяем что Issues {number} существует")
    public void shouldSeeIssueWithNumber(int number){
        $(withText(String.valueOf(number))).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
