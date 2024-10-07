package hostel.proxy.repository;

import hostel.proxy.user.UserProxy;

// Интерфейс для реального и прокси-репозитория
public interface Repository {

    String getName(int id);

    Double getBalance(int id);

    void saveUser(UserProxy user);

    void addBalance(int id, Double amount);

    UserProxy getUser(int id);
}
