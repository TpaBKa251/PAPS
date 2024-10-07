package hostel.proxy.repository.impl;

import hostel.proxy.user.UserProxy;
import hostel.proxy.repository.Repository;

import java.util.HashMap;

// Реальный репозиторий
public class RealRepository implements Repository {

    private final HashMap<Integer, UserProxy> users = new HashMap<>();

    @Override
    public String getName(int id) {
        return users.get(id).getName();
    }

    @Override
    public Double getBalance(int id) {
        return users.get(id).getBalance();
    }

    @Override
    public void saveUser(UserProxy user) {
        users.put(user.getId(), user);
    }

    @Override
    public void addBalance(int id, Double amount) {
        System.out.println("Накинули " + amount + " юзеру " + id + " через реальный репозиторий");
        users.get(id).addBalance(amount);
    }

    @Override
    public UserProxy getUser(int id) {
        System.out.print("Обратились к реальному репозиторию = ");
        return users.get(id);
    }
}
