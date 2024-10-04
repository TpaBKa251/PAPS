package hostel;

public class Main {
    public static void main(String[] args) {
        // Проверка работы паттерна Singleton
        Singleton.getInstance().printMessage("Я синглтон");
    }
}