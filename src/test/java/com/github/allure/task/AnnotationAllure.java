package com.github.allure.task;

import org.junit.jupiter.api.Test;

public class AnnotationAllure {
    private GitHubIssuesSteps steps = new GitHubIssuesSteps();

    @Test
    public void testIssueSearchA() {
        steps.openMainPage();
        steps.searchForRepo("eroshenkoam/allure-example");
        steps.goToRepo("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber("Listeners NamedBy");
    }
}