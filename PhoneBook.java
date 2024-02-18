import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        Set<String> phoneNumbers = phoneBook.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> entry1, Map.Entry<String, Set<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Alex", "5678904321");
        phoneBook.addContact("Miki", "3478650912");
        phoneBook.addContact("Anna", "7986543210");
        phoneBook.addContact("Smit", "7906542310");

        phoneBook.printPhoneBook();
    }
}