package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.demoqa.componets.CalendarComponent;
import com.demoqa.utils.StudentDataUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm extends CalendarComponent {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentRegistrationForm() {
        String fakeAddress = StudentDataUtils.fakeAddress();

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Sonic");
        $("#lastName").setValue("Hedgehog");
        $("#userEmail").setValue("hedgehog@sonic.zz");
        $("#genterWrapper .custom-control-label").click();
        $("#userNumber").setValue("6669990001");
        calendarComp(1,"1984");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper #hobbies-checkbox-1 ~ label").click();
        $("#hobbiesWrapper #hobbies-checkbox-3 ~ label").click();
        $(".form-file #uploadPicture ").uploadFile(new File("src/test/resources/table.js"));
        $("#currentAddress-wrapper > div ~ div #currentAddress").setValue(fakeAddress);
        $("#stateCity-wrapper #react-select-3-input").setValue("NCR").pressEnter();
        $("#stateCity-wrapper #react-select-4-input").setValue("Delhi").pressEnter().pressTab().pressEnter();

        $(".modal-content .modal-body .table-responsive .table > tbody")
                .shouldHave(text("Student Name"), text("Sonic Hedgehog"))
                .shouldHave(text("Student Email"), text("hedgehog@sonic.zz"))
                .shouldHave(text("Gender"), text("Male"))
                .shouldHave(text("Mobile"), text("6669990001"))
                .shouldHave(text("Date of Birth"), text("29 January,1984"))
                .shouldHave(text("Subjects"), text("English"))
                .shouldHave(text("Hobbies"), text("Sports, Music"))
                .shouldHave(text("Picture"), text("table.js"))
                .shouldHave(text("Address"), text(fakeAddress))
                .shouldHave(text("State and City"), text("NCR Delhi"));
        sleep(5);
    }
}