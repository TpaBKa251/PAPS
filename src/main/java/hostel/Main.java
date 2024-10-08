package hostel;

import hostel.abstract_fabric.enums.CarType;
import hostel.abstract_fabric.car.Car;
import hostel.abstract_fabric.fabric.CarFabric;
import hostel.abstract_fabric.fabric.impl.TeslaFabric;
import hostel.abstract_fabric.fabric.impl.ToyotaFabric;
import hostel.flyweight.duty.Duty;
import hostel.mediator.mediator.ChatMediator;
import hostel.mediator.mediator.impl.ChatRoomMediator;
import hostel.mediator.colleague.impl.ChatUser;
import hostel.mediator.colleague.User;
import hostel.proxy.repository.impl.ProxyRepository;
import hostel.proxy.repository.impl.RealRepository;
import hostel.proxy.user.UserProxy;
import hostel.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------");

        // Проверка работы паттерна Singleton
        singleton();

        // Проверка работы паттерна Mediator
        mediator();

        // Проверка работы паттерна Абстрактная Фабрика
        abstractFabric();

        // Проверка работы паттерна Proxy
        proxy();

        // Проверка работы паттерна Flyweight
        flyweight();
    }

    private static void singleton() {
        System.out.println("Паттерн Singleton:\n");

        Singleton.getInstance().printMessage("Я синглтон");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(
                "Сравнение через ==: "
                        + (singleton1 == singleton2)
                        + ", сравнение через equals(): "
                        + singleton1.equals(singleton2));

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

        System.out.println("------------------------------------------");
    }

    private static void abstractFabric() {
        System.out.println("Паттерн Абстрактная Фабрика:\n");

        // Создание фабрики для Toyota
        CarFabric toyotaFabric = new ToyotaFabric();

        //Создание автомобилей Toyota
        Car toyotaSedan = toyotaFabric.getCar(CarType.SEDAN);
        Car toyotaSUV = toyotaFabric.getCar(CarType.SUV);

        // Создание фабрики для Tesla
        CarFabric teslaFabric = new TeslaFabric();

        // Создание автомобилей Tesla
        Car teslaSedan = teslaFabric.getCar(CarType.SEDAN);
        Car teslaSUV = teslaFabric.getCar(CarType.SUV);

        // Вождение машин
        toyotaSedan.drive();
        toyotaSUV.drive();

        teslaSedan.drive();
        teslaSUV.drive();

        System.out.println("------------------------------------------");
    }

    private static void proxy() {
        System.out.println("Паттерн Proxy:");

        // Создание реального репозитория и запись юзера
        RealRepository realRepository = new RealRepository();
        realRepository.saveUser(new UserProxy(1,"Илья", 102.0));

        // Создание прокси
        ProxyRepository proxyRepository = new ProxyRepository(realRepository);

        // Вывод баланса (102)
        System.out.println(proxyRepository.getBalance(1)); // кэширование, потом вывод
        System.out.println(proxyRepository.getBalance(1)); // уже закэширован - просто вывод

        proxyRepository.resetAllCash(); // сброс
        System.out.println(proxyRepository.getBalance(1)); // кэширование
        System.out.println(proxyRepository.getBalance(1)); // уже закэширован

        realRepository.addBalance(1, 98.0); // меняем данные в реальном репозитории (баланс 200)

        // Выводит 200, а не 102
        // Загадка - почему выводит актуальный баланс из реального репозитория, если кэш не обновлен?
        // Ответ - кэш хранит ссылку на юзера из реального репозитория. Меняешь в реальном - меняется и в кэше
        // Если нужно, чтобы кэш работал привычно (при обновлении реального значения кэш остается неизменным),
        // реальный репозиторий должен возвращать копию юзера.
        // Для этого можно воспользоваться паттерном Прототип (Prototype)
        System.out.println(proxyRepository.getBalance(1)); // уже закэширован
        System.out.println(proxyRepository.getName(1)); // уже закэширован

        System.out.println("\n------------------------------------------");
    }

    private static void flyweight() {
        System.out.println("Паттерн Flyweight:\n");

        // Создаем дежурства
        Duty duty1 = new Duty("2024-10-10", "Лапшин", "KITCHEN");
        Duty duty2 = new Duty("2024-10-11", "Иванов", "HALL");
        Duty duty3 = new Duty("2024-10-12", "Вадим", "SANITARY");
        Duty duty4 = new Duty("2024-10-13", "Вадим", "KITCHEN");

        // Дежурим
        duty1.performDuty();
        duty2.performDuty();
        duty3.performDuty();
        duty4.performDuty();

        System.out.println("\n------------------------------------------\nКОНЕЦЪ");
    }
}