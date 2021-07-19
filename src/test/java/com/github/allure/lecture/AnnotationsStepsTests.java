package com.github.allure.lecture;

import org.junit.jupiter.api.Test;

public class AnnotationsStepsTests {

    private WebSteps steps = new WebSteps();

    @Test
    public void testIssueSearchA(){
        steps.openMainPage();
        steps.searchForRepo("eroshenkoam/allure-example");
        steps.goToRepo("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(68);
    }

}
