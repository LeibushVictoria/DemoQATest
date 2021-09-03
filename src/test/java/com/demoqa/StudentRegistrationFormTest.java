package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormStudentRegistration() {
        String firstName = "Victoria";
        String lastName = "Leibush";
        String userEmail = "qwe@mail.ru";
        String userNumber = "9999999999";
        String month = "January";
        String year = "1997";
        String day = "7";
        String subject1 = "Computer Science";
        String subject2 = "Math";
        String currentAddress = "Address";
        String state = "Haryana";
        String city = "Karnal";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(userEmail);

        $("[for=gender-radio-2]").click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();

        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();

        $("#uploadPicture").uploadFromClasspath("test.jpg");

        $("#currentAddress").setValue(currentAddress);

        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#city").$(byText(city)).click();

        $("#submit").click();

        $("tbody").shouldHave(text("Victoria Leibush"),
                text("qwe@mail.ru"),
                text("Female"),
                text("9999999999"),
                text("07 January,1997"),
                text("Computer Science"),
                text("Math"),
                text("Sports"),
                text("Reading"),
                text("test.jpg"),
                text("Address"),
                text("Haryana"),
                text("Karnal"));
    }
}
