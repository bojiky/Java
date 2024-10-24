package com.library;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Library {
    private Administrator admin;
    private List<Reader> readers;
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;
    private List<String> blackList;

    public Library() {
        this.readers = new ArrayList<>();
        this.availableBooks = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.blackList = new ArrayList<>();
    }

    public Library(Administrator admin) {
        this.admin = admin;
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public boolean isReaderRegistered(int readerNumber) {
        return readers.stream().anyMatch(r -> r.getReaderNumber() == readerNumber);
    }

    public void addAvailableBook(Book book) {
        availableBooks.add(book);
    }

    public boolean lendBook(Reader reader, Book book) {
        if (!isReaderRegistered(reader.getReaderNumber())) {
            System.out.println("Читатель не зарегистрирован.");
            return false;
        }

        if (availableBooks.contains(book)) {
            borrowedBooks.add(book);
            System.out.println("Книга выдана читателю.");
            return true;
        } else {
            System.out.println("Книга недоступна.");
            return false;
        }
    }

    public void returnBook(Reader reader, Book book) {
        if (borrowedBooks.remove(book)) {
            availableBooks.add(book);
            System.out.println("Книга возвращена.");
        } else {
            System.out.println("Книга не найдена или уже возвращена.");
        }
    }

    public void checkDueDate(Book book) {
        LocalDate dueDate = LocalDate.now().plusDays(14); // Предполагаемый срок возврата - 14 дней
        if (LocalDate.now().isAfter(dueDate)) {
            book.setStatus(BookStatus.OVERDUE);
            admin.blacklistReader(book.getLender()); // Добавляем в черный список зачитывающего читателя
            System.out.println("Книга " + book.getTitle() + " просрочена. Читатель добавлен в черный список.");
        } else {
            System.out.println("Срок возврата не истек для книги " + book.getTitle());
        }
    }

    public void displayBlacklist() {
        System.out.println("Список читателей в черном списке в библиотеке:");
        for (Reader reader : admin.blacklistedReaders) {
            System.out.println(reader);
        }
    }

    public boolean isBookAvailable(Book book) {
        return availableBooks.contains(book);
    }

    public void displayLibraryInfo() {
        System.out.println("Информация о библиотеке:");
        System.out.println("Количество читателей: " + readers.size());
        System.out.println("Доступных книг: " + availableBooks.size());
        System.out.println("Забронированных книг: " + borrowedBooks.size());
        System.out.println("Число читателей в черном списке: " + blackList.size());
    }
}