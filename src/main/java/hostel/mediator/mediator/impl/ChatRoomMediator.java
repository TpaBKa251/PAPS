package hostel.mediator.mediator.impl;

import hostel.mediator.colleague.User;
import hostel.mediator.mediator.ChatMediator;

import java.util.ArrayList;
import java.util.List;

// Конкретный посредник
public class ChatRoomMediator implements ChatMediator {

    private final List<User> users;

    public ChatRoomMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Отправитель не получает свое сообщение
            if (u != user) {
                u.receive(message);
            }
        }
    }
}
