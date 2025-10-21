package data;
import com.github.javafaker.Faker;
import tests.TestBase;
import java.util.Locale;


public class TestData extends TestBase {
    Faker faker = new Faker(new Locale("en"));
    public String  firstName = faker.name().firstName(), // Emory
            lastName = faker.name().lastName(), // Barton
            email = faker.internet().emailAddress(), // Barton
            address = faker.address().streetAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phone = faker.phoneNumber().subscriberNumber(10),
            year = String.format("%s", faker.number().numberBetween(1900, 2024)),
            month = faker.options().option("January", "February", "March", "April",
                                                   "May", "June", "July", "August", "September",
                                                   "October", "November", "December"),
            day = String.format("%02d", faker.number().numberBetween(1, 30)),
            subjects = faker.options().option("Math", "Chemistry", "Computer Science", "Commerce", "Economics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            pathImage = faker.options().option("AtomicHeart_sample.jpg", "AtomicHeart_sample2.jpg", "AtomicHeart_sample3.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Raijasthan"),
            city = getRandomCity(state);

    public static String getRandomCity(String state) {

        Faker faker = new Faker();

        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                // Добавляем города для Uttar Pradesh
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                // Добавляем города для Haryana
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                // Добавляем города для Rajasthan
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return "Unknown city for state: " + state;
        }
    }
}
