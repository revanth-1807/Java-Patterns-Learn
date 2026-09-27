import java.util.*;
interface Channel {
    void addSub(Observer observer);
    void remSub(Observer observer);
    void notifyall(String course);
}
interface Observer {
    void notify(String msg);
}
class Youtube implements Channel {
    private List<Observer> li=new ArrayList<>();
    public void addSub(Observer observer) {
        li.add(observer);
    }
    public void remSub(Observer observer) {
        li.remove(observer);
    }
    public void notifyall(String course) {
        for(Observer o:li) {
            o.notify(course);
        }
    }
}
class User implements Observer {
    public void notify(String msg) {
        System.out.println("New course is added: "+msg);
    }
}

class SubAndObs {
    public static void main(String[] args) {    
        Youtube y=new Youtube();
        User a=new User();
        User b=new User();
        User c=new User();
        y.addSub(a);
        y.addSub(b);
        y.addSub(c);
        y.notifyall("DSA");
        System.out.println();
        y.remSub(b);
        y.notifyall("JAVA");
    }
}