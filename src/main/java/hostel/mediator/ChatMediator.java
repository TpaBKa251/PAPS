package hostel.mediator;

// Интерфейс посредника (Медиатора)
public interface ChatMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}
