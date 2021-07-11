package com.github.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("eroshenkoam")
public class AnnotatedLabelsTests {

        @Test
        @Story("Создание Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("Тест на проверку создания Issue")
        public void testIssueCreate() {

        }

        @Test
        @Story("Удаление Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("Тест на проверку удаления Issue от имени автора")
        public void testIssueDelete() {

        }

        @Test
        @Story("Удаление Issues")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Github", url = "https://github.com")
        @DisplayName("Тест на проверку удаления Issue от имени владельца репозитория")
        public void testIssueDeleteFromRepositoryOwner() {

        }
}
