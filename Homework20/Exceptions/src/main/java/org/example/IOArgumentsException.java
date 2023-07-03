package org.example;

import java.io.IOException;

public class IOArgumentsException extends Exception {
    public IOArgumentsException(){
        super("Ошибка ввода аргументов");
    }
    public IOArgumentsException(String e){
        super(e);
    }
}

class TooFewArguments extends IOArgumentsException {
    public TooFewArguments (){
        super("Введены не все аргументы");
    }
}

class TooManyArguments extends IOArgumentsException {
    public TooManyArguments (){
        super("Введено слишком много аргументов");
    }
}

class NumericInFIOException extends IOArgumentsException {
    public NumericInFIOException (){
        super("Наличие цифр в ФИО не допускается");
    }
}

class NotCurrentDateValueError extends IOArgumentsException {
    public NotCurrentDateValueError(String e){
        super(e);
    }

    public NotCurrentDateValueError(){
        super("Неверно введена дата");
    }
}

class SymbolsInPhoneException extends IOArgumentsException {
    public SymbolsInPhoneException(){
        super("Наличие символов в телефонном номере недопускается");
    }
}

class GenderError extends IOArgumentsException {
    public GenderError(){
        super("Пол существа не распознан");
    }
}

class NotAllArgsInDateException extends NotCurrentDateValueError {
    public NotAllArgsInDateException(){
        super("Не хватает аргументов в поле 'Дата'");
    }
}

class ExtraCharactersException extends NotCurrentDateValueError {
    public ExtraCharactersException(){
        super("Лишнии символы в полях введённой даты");
    }
}

class DateNotValidException extends NotCurrentDateValueError{
    public DateNotValidException(){
        super("Нет такого дня в календаре");
    }

    public DateNotValidException(String e) {
        super(e);
    }
}

class DataWrite extends IOException {
    public DataWrite(){
        super("Ошибка записи файла!");
    }
}