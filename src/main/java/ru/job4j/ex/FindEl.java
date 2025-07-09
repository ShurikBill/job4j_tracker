package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Url could not be null");
    }

    public static void main(String[] args) {
        String[] value = {"Sasha", "Lesha", "Dima", "Petya", "Kolya"};
        String key= "Sasha";
        try {
            int index = indexOf(value,key);
            System.out.println("Индекс: " + index);
        } catch (ElementNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}