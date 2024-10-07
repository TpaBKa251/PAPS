package hostel.proxy.user;

// Класс юзера
public class UserProxy {

    private final int id;
    private final String name;
    private Double balance;

    public UserProxy(int id, String name, Double initialBalance) {
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void addBalance(Double amount) {
        this.balance += amount;
    }
}
