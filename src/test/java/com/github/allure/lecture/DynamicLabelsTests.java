package com.github.allure.lecture;

import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicLabelsTests {

    @Test
    @DisplayName("���� �� �������� �������� Issue (������������)")
    public void testIssueCreate() {
        Allure.feature("Issues");
        Allure.label("owner", "eroshenkoam");
        Allure.story("�������� Issues");
        Allure.label("severity", SeverityLevel.BLOCKER.toString());
        Allure.link("Github", "https://github.com");
    }
}
