package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class StudentRegistrationFormTest extends TestBase{

    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormStudentRegistration() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        String month = "January";
        String year = "1997";
        String day = "7";
        String subject1 = "Computer Science";
        String subject2 = "Math";
        String fileName = "test.jpg";
        String currentAddress = faker.address().fullAddress();
        String state = "Haryana";
        String city = "Karnal";

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .choseGender()
                .typeNumber(userNumber)
                .choseDateOfBirth(month, year, day)
                .typeSubjects(subject1, subject2)
                .choseHobbies()
                .uploadPicture(fileName)
                .typeAddress(currentAddress)
                .choseStateAndCity(state, city)
                .clickSubmit()
                .checkResultsValue(firstName, lastName, userEmail, userNumber, subject1, currentAddress, city);
    }
}
