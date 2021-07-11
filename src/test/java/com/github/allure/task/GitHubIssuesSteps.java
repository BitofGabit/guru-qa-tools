package com.github.allure.task;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubIssuesSteps {

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
    @Step("��������� ��� Issue {name} ����������")
    public void shouldSeeIssueWithNumber(String name){
        $("#issue_68_link").shouldHave(Condition.text("Listeners NamedBy"));
    }
}
