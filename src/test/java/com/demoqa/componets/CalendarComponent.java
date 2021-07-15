package com.demoqa.componets;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void calendarComp(int month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month > div > div:nth-child(1)").click();
    }

}
