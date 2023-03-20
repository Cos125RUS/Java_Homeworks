package org.example.Model.Members;

import java.time.LocalDate;

public abstract class User {
    String dateBirth;
    String fio;
    int id;
    static int count = 0;

    public User(String dateBirth, String fio, int id) {
        this.dateBirth = dateBirth;
        this.fio = fio;
        this.id = id;
    }

    public User() {
        this.dateBirth = LocalDate.now().toString();
        this.fio = "Ivanov I.O.";
        this.id = 23;
    }

    public User(String dateBirth, String fio) {
        this.dateBirth = dateBirth;
        this.fio = fio;
        this.id = ++count;
    }

    @Override
    public String toString() {
        return "User{" +
                "dateBirth=" + dateBirth +
                ", fio='" + fio + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFio() {
        return fio;
    }

    //    LocalDate vacation;
}
