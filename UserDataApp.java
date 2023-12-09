import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в следующем порядке: Фамилия Имя Отчество дата рождения номер телефона пол");

            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                System.out.println("Введено неверное количество данных");
                return;
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            try {
                validateData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                saveUserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                System.out.println("Данные успешно сохранены");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateData(String lastName, String firstName, String middleName,
                                     String birthDate, String phoneNumber, String gender) {
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

        if (!gender.matches("[fm]")) {
            throw new IllegalArgumentException("Неверный формат пола");
        }
    }

    private static void saveUserData(String lastName, String firstName, String middleName,
                                     String birthDate, String phoneNumber, String gender) throws IOException {
        String fileName = lastName + ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender + "\n");
        }
    }
}