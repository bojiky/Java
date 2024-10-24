package com.library;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private String name;
    private String password;
    protected List<Reader> blacklistedReaders;

    public Administrator(String name, String password) {
        this.name = name;
        this.password = password;
        this.blacklistedReaders = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getPassword() { return password; }

    public void blacklistReader(Reader reader) {
        if (!blacklistedReaders.contains(reader)) {
            blacklistedReaders.add(reader);
            System.out.println("Читатель " + reader.getName() + " добавлен в черный список.");
        } else {
            System.out.println("Читатель " + reader.getName() + " уже находится в черном списке.");
        }
    }

    public void unblacklistReader(Reader reader) {
        if (blacklistedReaders.contains(reader)) {
            blacklistedReaders.remove(reader);
            System.out.println("Читатель " + reader.getName() + " удален из черного списка.");
        } else {
            System.out.println("Читатель " + reader.getName() + " не находится в черном списке.");
        }
    }

    public boolean isReaderBlacklisted(Reader reader) {
        return blacklistedReaders.contains(reader);
    }

    public void displayBlacklist() {
        System.out.println("Список читателей в черном списке:");
        for (Reader reader : blacklistedReaders) {
            System.out.println(reader);
        }
    }
}