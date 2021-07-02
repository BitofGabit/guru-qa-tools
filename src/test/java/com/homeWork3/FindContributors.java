package com.homeWork3;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindContributors {

    void firstContributorsShouldBeSolntsev(){

        open("https://github.com/selenede/selenede");

        $(".class").setValue("selenide");

        $("").$(byText("Conti"))
                .closest("").$("li").hover();
    }

}
