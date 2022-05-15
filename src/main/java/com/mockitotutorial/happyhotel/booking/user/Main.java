package com.mockitotutorial.happyhotel.booking.user;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardian guardian = new Guardian(1, "Ebenezer Bentil Mensah",
                "0274494472", "IT", "ACS");

        User user = new User(1,"John", "Doe", "Box 4515 Nth Street",
                "0544704424", LocalDate.of(1957, 3, 6), guardian);

        UserRequestDTO convertedUser = new UserRequestDTO();
        System.out.println("----------------------------------");
        convertedUser.convert(user);
        mapUsersToDTO(getUsers());
    }

    private static List<User> getUsers(){
        Guardian guardian = new Guardian(1, "Ebenezer Bentil Mensah", "0274494472", "IT", "ACS");
        return Arrays.asList(
                new User(1,"John", "Doe", "Box 1515 South Door",
                        "0204067441", LocalDate.of(1990, 8, 6), guardian),

                new User(2,"Angelina", "Kyeah", "Box 215 Neelpina Ent.",
                        "0548670632", LocalDate.of(1987, 3, 6), guardian),

                new User(3,"Jose", "Anderson", "Box 206 Accra Newtown",
                        "0544704424", LocalDate.of(1957, 3, 26), guardian),

                new User(4,"Morgan", "Stanley", "Box 65 Avenor",
                        "0272827829", LocalDate.of(1957, 3, 17), guardian));
    }

    public static void mapUsersToDTO(List<User> users){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        users.stream()
                .filter(user -> user.getDateOfBirth().isAfter(LocalDate.of(1987, 5, 3)))
                .map(userRequestDTO::convert)
                .forEach(System.out::println);
    }
}
