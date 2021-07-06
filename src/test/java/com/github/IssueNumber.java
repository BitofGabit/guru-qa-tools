package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueNumber {

    //�������� ���� �� �������� �������� Issue � ����������� ����� Web-���������.
    //���� ���� ����������� � ���� ���������:
    //1. ������ Selenide
    //2. ������ ���� ����� step (name, () -> {})
    //3. ���� � ���������� @Step

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
