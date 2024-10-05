package hostel;

import hostel.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        // Проверка работы паттерна Singleton
        Singleton.getInstance().printMessage("Я синглтон");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println((singleton1 == singleton2) + ", " + singleton1.equals(singleton2));
    }
}