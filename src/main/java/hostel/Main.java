package hostel;

import hostel.mediator.ChatMediator;
import hostel.mediator.ChatRoomMediator;
import hostel.mediator.ChatUser;
import hostel.mediator.User;
import hostel.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        // Проверка работы паттерна Singleton
        singleton();

        // Проверка работы паттерна Mediator
        mediator();
    }

    private static void singleton() {
        System.out.println("Паттерн Singleton:\n");

        Singleton.getInstance().printMessage("Я синглтон");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println((singleton1 == singleton2) + ", " + singleton1.equals(singleton2));

        System.out.println("------------------------------------------");
    }

    private static void mediator() {
        System.out.println("Паттерн Mediator:\n");

        ChatMediator mediator = new ChatRoomMediator();

        User user1 = new ChatUser(mediator, "Илья");
        User user2 = new ChatUser(mediator, "Вадим");
        User user3 = new ChatUser(mediator, "Маша");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("Как дела?");
        System.out.println();
        user2.send("Нормально");
        System.out.println();
        user3.send("Пойдет");

        System.out.println();
    }
}