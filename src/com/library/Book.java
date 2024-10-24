package com.library;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private BookStatus status;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public Reader getLender() { return null; }

    @Override
    public String toString() {
        return "Книга: " + title + ", Автор: " + author + ", Год издания: " + publicationYear;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookStatus getStatus() {
        return status;
    }
}