package com.theInternetHerokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    /**
     *  ДЗ 1
     *  1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
     *
     *  Ответ на ДЗ 1
     *  Есть разница, в первом одна операция для поиска первого div внутри h1, во втором две операций для того же самого.
     */

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }


    @Test
    void dragAndDropTest(){
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldNotBe(Condition.text("A"));
        $("#column-b").shouldNotBe(Condition.text("B"));

    }
}