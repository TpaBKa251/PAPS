package hostel.mediator.colleague.impl;

import hostel.mediator.colleague.User;
import hostel.mediator.mediator.ChatMediator;

// Конкретные коллеги
public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " отправил(а): " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " получил(а): " + message);
    }
}
