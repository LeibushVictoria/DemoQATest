package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            daySelect = $(".react-datepicker__month");

    public void setDate(String month, String year, String day) {
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.$(byText(day)).click();
    }
}
