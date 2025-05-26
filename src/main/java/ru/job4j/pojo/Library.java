package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book selinger = new Book("Над пропастью по ржи", 213);
        Book hemingway = new Book("Старик и море", 107);
        Book roberts = new Book("Шантарам", 1016);
        Book martin = new Book("Чистый код", 464);
        Book[] books = new Book[4];
        books[0] = selinger;
        books[1] = hemingway;
        books[2] = roberts;
        books[3] = martin;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage() + " страниц");
        }
        System.out.println("\n");
        books[0] = martin;
        books[3] = selinger;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage() + " страниц");
        }
        System.out.println("\n");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Чистый код")) {
                System.out.println(book.getName() + " - " + book.getPage() + " страниц");
            }
        }
    }
}
