package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueNumber {

    //Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
    //Этот тест представить в трех вариантах:
    //1. Чистый Selenide
    //2. Лямбда шаги через step (name, () -> {})
    //3. Шаги с аннотацией @Step

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        open("");
    }

    @Test
    void issueNumberCheck(){
        $("").setValue("");
    }
}
