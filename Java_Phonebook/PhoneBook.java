import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем телефонную книгу в виде HashMap, где ключ - имя, значение - список телефонов
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу
        addEntry(phoneBook, "Антон Городецкий", "123456789");
        addEntry(phoneBook, "Завулон", "987654321");
        addEntry(phoneBook, "Антон Городецкий", "987654321");
        addEntry(phoneBook, "Завулон", "123456789");
        addEntry(phoneBook, "Антон Городецкий", "555555555");

        // Сортируем записи по убыванию числа телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparing(entry -> entry.getValue().size(), Comparator.reverseOrder()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    private static void addEntry(HashMap<String, List<String>> phoneBook, String name, String phone) {
        // Если имя уже существует в телефонной книге, добавляем телефон к списку
        if (phoneBook.containsKey(name)) {
            List<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            // Иначе создаем новую запись с именем и списком телефонов
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }
}