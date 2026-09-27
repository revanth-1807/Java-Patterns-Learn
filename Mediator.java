import java.util.*;

interface Chatroom {
    void addUser(User user);
    void sendMsg(String msg, User sender);
}

abstract class User {
    String name;
    Chatroom chatroom;

    User(Chatroom chatroom, String name) {
        this.chatroom = chatroom;
        this.name = name;
    }

    abstract void sendMsg(String msg);
    abstract void recieveMsg(String msg);
}

class Room1 implements Chatroom {

    private List<User> li = new ArrayList<>();

    String name;

    Room1(String name) {
        this.name = name;
    }

    public void addUser(User user) {
        li.add(user);
    }

    public void sendMsg(String msg, User sender) {

        for (User u : li) {
            if (u != sender) {
                u.recieveMsg(sender.name + ": " + msg);
            }
        }
    }
}

class UserWork extends User {

    UserWork(Chatroom chatroom, String name) {
        super(chatroom, name);
    }

    void sendMsg(String msg) {
        chatroom.sendMsg(msg, this);
    }

    void recieveMsg(String msg) {
        System.out.println(msg);
    }
}

class Mediator {

    public static void main(String args[]) {

        Chatroom r1 = new Room1("Room1");

        User user1 = new UserWork(r1, "ravi");
        User user2 = new UserWork(r1, "giri");
        User user3 = new UserWork(r1, "hari");

        r1.addUser(user1);
        r1.addUser(user2);
        r1.addUser(user3);

        user1.sendMsg("Hi everyone");
        user2.sendMsg("Hello, ravi!");
    }
}