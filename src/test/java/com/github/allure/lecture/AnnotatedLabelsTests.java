package com.github.allure.lecture;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("eroshenkoam")
public class AnnotatedLabelsTests {

        @Test
        @Story("�������� Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("���� �� �������� �������� Issue")
        public void testIssueCreate() {

        }

        @Test
        @Story("�������� Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("���� �� �������� �������� Issue �� ����� ������")
        public void testIssueDelete() {

        }

        @Test
        @Story("�������� Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("���� �� �������� �������� Issue �� ����� ��������� �����������")
        public void testIssueDeleteFromRepositoryOwner() {

        }
}
