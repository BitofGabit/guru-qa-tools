package com.demoqa.componets;

import static com.codeborne.selenide.Selenide.$;

public class calendarComponent {

    public void calendarComp(int month, String day, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month > div > div:nth-child(1)").click();
        day = null; //don't know how to do it yet
    }

    public void calendarComp(int month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month > div > div:nth-child(1)").click();
    }

}
