package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");

    }

    @Test
    void studentRegistrationForm(){
        $("#firstName").setValue("Sonic");
        $("#lastName").setValue("Hedgehog");
        $("#userEmail").setValue("hedgehog@sonic.zz");
        $("#genterWrapper .custom-control-label").click();
        $("#userNumber").setValue("6669990001");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(0);
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month > div > div:nth-child(1)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper #hobbies-checkbox-1 ~ label").click();
        $("#hobbiesWrapper #hobbies-checkbox-3 ~ label").click();
        $(".form-file #uploadPicture ").uploadFile(new File("README.md"));
        $("#currentAddress-wrapper > div ~ div #currentAddress").setValue("Maybe Earth");
        $("#stateCity-wrapper #react-select-3-input").setValue("NCR").pressEnter();
        $("#stateCity-wrapper #react-select-4-input").setValue("Delhi").pressEnter().pressTab().pressEnter();

        $(".modal-content .modal-body .table-responsive .table > tbody")
                .shouldHave(text("Student Name"), text("Sonic Hedgehog"))
                .shouldHave(text("Student Email"), text("hedgehog@sonic.zz"))
                .shouldHave(text("Gender"), text("Male"))
                .shouldHave(text("Mobile"), text("6669990001"))
                .shouldHave(text("Date of Birth"), text("01 January,1984"))
                .shouldHave(text("Subjects"), text("English"))
                .shouldHave(text("Hobbies"), text("Sports, Music"))
                .shouldHave(text("Picture"), text("README.md"))
                .shouldHave(text("Address"), text("Maybe Earth"))
                .shouldHave(text("State and City"), text("NCR Delhi"));

        Configuration.timeout = 10;
    }
}