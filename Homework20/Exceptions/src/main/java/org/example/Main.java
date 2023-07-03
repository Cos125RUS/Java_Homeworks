package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String line = enter();
        String[] arguments = new String[5];
        try {
            arguments = splitLine(line);
            Data data = new Data(arguments);
            try {
                writeData(data);
            } catch (DataWrite e) {
                e.printStackTrace();
            }
        } catch (IOArgumentsException e) {
            e.printStackTrace();
        }
    }

    public static String enter() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf("Введите через пробел:\n 'Фамилию' 'Имя' 'Отчество' " +
                    "'Дату рождения(дд.мм.гггг)' 'Номер телефона' 'Пол'\n>");
            return scanner.nextLine();
        }
    }

    public static String[] splitLine(String line) throws IOArgumentsException {
        String[] args = line.split(" ");
        if (args.length > 6)
            throw new TooManyArguments();
        else if (args.length < 6)
            throw new TooFewArguments();
        else if (!checkString(args[0]) || !checkString(args[1]) || !checkString(args[2]))
            throw new NumericInFIOException();
        else if (!checkDate(args[3]))
            throw new NotCurrentDateValueError();
        else if (!checkNumeric(args[4]))
            throw new SymbolsInPhoneException();
        else if (!(args[5] = replaceGender(args[5])).equals("f") && !args[5].equals("m"))
            throw new GenderError();
        else return args;
    }

    public static boolean checkString(String value) {
        for (char c : value.toCharArray()) {
            if ((int) c - 48 < 10)
                return false;
        }
        return true;
    }

    public static boolean checkDate(String value) throws NotCurrentDateValueError {
        value = value.replace(".", ",");
        String[] args = value.split(",");
        if (args.length != 3)
            throw new NotAllArgsInDateException();
        else if (args[0].length() != 2 && args[1].length() != 2 && args[2].length() != 4)
            throw new ExtraCharactersException();
        else if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 31)
            throw new DateNotValidException("Число дня рождения указано неверно");
        else if (Integer.parseInt(args[1]) < 1 || Integer.parseInt(args[1]) > 12)
            throw new DateNotValidException("Месяц дня рождения указан неверно");
        else if (Integer.parseInt(args[2]) < 1900 || Integer.parseInt(args[2]) > 2023)
            throw new DateNotValidException("Год дня рождения указан неверно");
        return true;
    }

    public static boolean checkNumeric(String value) {
        for (char c : value.toCharArray()) {
            if ((int) c - 48 > 9)
                return false;
        }
        return true;
    }

    public static String replaceGender(String value) throws GenderError {
        value = value.toLowerCase();
        switch (value) {
            case "m":
            case "men":
            case "male":
            case "м":
            case "муж":
            case "мужской":
            case "мужик":
            case "мальчик":
            case "мальчонка":
            case "мужчина":
            case "пацан":
            case "самец":
            case "кабель":
                return "m";

            case "f":
            case "woman":
            case "female":
            case "ж":
            case "жен":
            case "женский":
            case "женщина":
            case "девушка":
            case "девочка":
            case "девчонка":
            case "тёлочка":
            case "юбка":
                return "f";

            default:
                throw new GenderError();
        }
    }

    public static void writeData(Data data) throws DataWrite {
        if (!Files.exists(Path.of("data"))){
            new File("data").mkdir();
        }
        String filename = "data/" + data.getSurname();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(data.toString());
        } catch (IOException e) {
            throw new DataWrite();
        }
    }

}

class Data {
    private String Name;
    private String Surname;
    private String Patronymic;
    private String birthday;
    private String phone;
    private String gender;

    public Data(String name, String surname, String patronymic, String birthday, String phone, String gender) {
        this.Surname = surname;
        this.Name = name;
        this.Patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public Data(String[] arguments) {
        this.Surname = arguments[0];
        this.Name = arguments[1];
        this.Patronymic = arguments[2];
        this.birthday = arguments[3];
        this.phone = arguments[4];
        this.gender = arguments[5];
    }

    @Override
    public String toString() {
        return "<" + Surname + '>' +
                "<" + Name + '>' +
                "<" + Patronymic + '>' +
                "<" + birthday + '>' +
                "<" + phone + '>' +
                "<" + gender + ">\n";
    }

    public String getSurname() {
        return Surname;
    }
}