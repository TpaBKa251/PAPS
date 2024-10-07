package hostel.mediator.mediator;

import hostel.mediator.colleague.User;

// Интерфейс посредника (Медиатора)
public interface ChatMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}
