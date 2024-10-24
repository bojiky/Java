package com.library;

public class Reader {
    private String name;
    private int readerNumber;
    private boolean isInBlacklist;

    public Reader(String name, int readerNumber) {
        this.name = name;
        this.readerNumber = readerNumber;
        this.isInBlacklist = false;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getReaderNumber() { return readerNumber; }
    public void setReaderNumber(int readerNumber) { this.readerNumber = readerNumber; }

    public boolean isInBlacklist() { return isInBlacklist; }
    public void setInBlacklist(boolean isInBlacklist) { this.isInBlacklist = isInBlacklist; }

    @Override
    public String toString() {
        return "Читатель: " + name + ", Номер читателя: " + readerNumber + ", В черном списке: " + isInBlacklist;
    }
}