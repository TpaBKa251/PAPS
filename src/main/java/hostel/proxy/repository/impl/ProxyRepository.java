package hostel.proxy.repository.impl;

import hostel.proxy.user.UserProxy;
import hostel.proxy.repository.Repository;

import java.util.HashMap;

// Прокси-репозиторий. Используется для кэша
public class ProxyRepository implements Repository {

    // Ссылка на реальный репозиторий
    private final Repository realRepository;

    // Закэшированные юзеры
    private final HashMap<Integer, UserProxy> users = new HashMap<>();

    public ProxyRepository(Repository realRepository) {
        this.realRepository = realRepository;
    }

    // В тернарном операторе происходит проверка, закэширован ли юзер.
    // Да - значение берется из кэша.
    // Нет - юзер кэшируется и возвращается значение только что закэшированного юзера
    @Override
    public String getName(int id) {
        System.out.print("\nОбратились к кэшу и... ");
        return checkUser(id) ? users.get(id).getName() : cashUser(id).getName();
    }

    @Override
    public Double getBalance(int id) {
        System.out.print("\nОбратились к кэшу и... ");
        return checkUser(id) ? users.get(id).getBalance() : cashUser(id).getBalance();
    }

    @Override
    public void saveUser(UserProxy user) {
        realRepository.saveUser(user);
        cashUser(user.getId());
    }

    @Override
    public void addBalance(int id, Double amount) {
        realRepository.addBalance(id, amount);
        users.get(id).addBalance(amount);
    }

    @Override
    public UserProxy getUser(int id) {
        System.out.print("\nОбратились к кэшу и... ");
        return checkUser(id) ? users.get(id) : cashUser(id);
    }

    // Кэширование юзера.
    // Происходит обращение к реальному репозиторию для получения юзера,
    // его кэширование, после чего юзер сразу возвращается
    private UserProxy cashUser(int id) {
        UserProxy user = realRepository.getUser(id); // получаем юзера из реального репозитория
        users.put(id, user); // кэшируем (помещаем в маппу прокси-репозитория)
        return user; // возвращаем юзера
    }

    // Сброс кэша конкретного юзера
    public void resetCashUser(int id) {
        System.out.print("\nОчистили кэш юзера " + id);
        users.remove(id);
    }

    // Сброс всего кэша
    public void resetAllCash() {
        System.out.print("\nОчистили весь кэш");
        users.clear();
    }

    private boolean checkUser(int id) {
        return users.containsKey(id);
    }
}
