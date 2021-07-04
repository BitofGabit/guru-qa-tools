package com.theInternetHerokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    /**
     *  �� 1
     *  1. ���� �� ������� ����� $("h1 div"); � $("h1").$("div"); - ����� �� �������� � ���� ���, ����� ����� ������ ��������?
     *
     *  ����� �� �� 1
     *  ���� �������, � ������ ���� �������� ��� ������ ������� div ������ h1, �� ������ ��� �������� ��� ���� �� ������.
     */

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }


    @Test
    void dragAndDropTest(){
        // - ���������� ������������� � �� ����� �
        $("#column-a").dragAndDropTo("#column-b");
        // - ���������, ��� �������������� ������������� ����������
        $("#column-a").shouldNotBe(Condition.text("A"));
        $("#column-b").shouldNotBe(Condition.text("B"));

    }
}