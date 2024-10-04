package hostel;

public class Singleton {

    //  Приватный конструктор
    private Singleton() {}

    // Вложенный статический класс, гарантирующий потокобезопасность
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Метод получения экземпляра
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // Основной метод класса
    public void printMessage(String message) {
        System.out.println(message);
    }
}
