package com.github.wiki;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiPage {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        open("https://github.com");
    }

    @Test
    void checkPageForJUnut5Example(){
        // �������� �������� Selenide � Github
        $("[data-scoped-placeholder=\"Search\"]")
                .setValue("selenide").pressEnter();
        $(".repo-list a").click();
        // ��������� � ������ Wiki �������
        $("[data-content=\"Wiki\"]").click();
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
        // ���������, ��� � ������ ������� (Pages) ���� �������� SoftAssertions
//        $(".js-wiki-sidebar-toggle-display li:last-child > button").click();
//        $(".js-wiki-sidebar-toggle-display .wiki-more-pages > strong > a")
//                .shouldHave(text("SoftAssertions"));
//        $(".js-wiki-sidebar-toggle-display .wiki-more-pages > strong > a").click();
//        // ��������� ��� ������ ���� ������ ���� ��� JUnit5
//        $("[start=\"3\"] > li")
//                .shouldHave(text("Using JUnit5 extend test class:"));
    }
}