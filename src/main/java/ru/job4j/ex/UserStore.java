package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователя с именем: " + login + " не найдено");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException ("Пользователь не валидный");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException ("Имя короткое");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eb) {
            System.err.println("Ошибка: " + eb.getMessage());
        } catch (UserNotFoundException ea) {
            System.err.println("Ошибка: " + ea.getMessage());
        }
    }
}