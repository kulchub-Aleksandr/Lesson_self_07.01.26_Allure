package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().safeEmailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            notFullUserNumber = faker.phoneNumber().subscriberNumber(9),
            day = String.format("%s", faker.number().numberBetween(10, 28)),
            month = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            year = String.format("%s", faker.number().numberBetween(1990, 2100)),
            subjects = faker.options().option("Chemistry", "Computer Science", "English", "Maths", "Physics", "Economics",
                    "Arts", "Social Studies", "History", "Civics", "Hindi", "Biology", "Commerce", "Accounting"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("icons_0.png", "icons_1.png"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String city(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public String submitFormText = "Thanks for submitting the form";

}
