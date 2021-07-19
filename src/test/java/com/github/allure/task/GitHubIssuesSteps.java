package com.github.allure.task;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubIssuesSteps {

    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Search for this {repo}")
    public void searchForRepo(String repo){
        $("[data-scoped-placeholder=\"Search\"]")
                .setValue(repo)
                .submit();
    }
    @Step("Go to this {repo}")
    public void goToRepo(String repo){
        $(By.linkText(repo)).click();
    }
    @Step("Open Issues tab")
    public void openIssueTab(){
        $("[data-content=\"Issues\"]").click();
    }
    @Step("Check that the Issue {name} exists")
    public void shouldSeeIssueWithNumber(String name){
        $("#issue_68_link").shouldHave(Condition.text("Listeners NamedBy"));
    }
}
