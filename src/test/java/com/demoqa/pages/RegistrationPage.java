package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("[for=gender-radio-2]"),
            resultsValue = $("tbody"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckbox1 = $("[for=hobbies-checkbox-1]"),
            hobbiesCheckbox2 = $("[for=hobbies-checkbox-2]"),
            uploadPictureButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropdown = $("#stateCity-wrapper").$(byText("Select State")),
            stateCityDropdown = $("#stateCity-wrapper").$(byText("Select City")),
            stateSelector = $("#state"),
            citySelector = $("#city"),
            submitButton = $("#submit");

    public CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage choseGender() {
        genderRadioButton.click();
        return this;
    }

    public RegistrationPage typeNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage choseDateOfBirth(String month, String year, String day) {
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationPage typeSubjects(String subject1, String subject2) {
        subjectsInput.setValue(subject1).pressEnter();
        subjectsInput.setValue(subject2).pressEnter();
        return this;
    }

    public RegistrationPage choseHobbies() {
        hobbiesCheckbox1.click();
        hobbiesCheckbox2.click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureButton.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage choseStateAndCity(String state, String city) {
        stateDropdown.scrollIntoView(true).click();
        stateSelector.$(byText(state)).click();
        stateCityDropdown.click();
        citySelector.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public void checkResultsValue(String firstName, String lastName, String userEmail, String userNumber, String subject1, String currentAddress, String city) {
        resultsValue.shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(userNumber),
                text(subject1),
                text(currentAddress),
                text(city)
        );
    }
}
