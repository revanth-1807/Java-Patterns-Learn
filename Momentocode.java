class Editor {
    String text;
    void setText(String text) {
        this.text = text;
    }
    String getText() {
        return text;
    }
    Memento save() {
        return new Memento(text);
    }
    void restore(Memento m) {
        text = m.getText();
    }
}

class Memento {
    private String text;
    Memento(String text) {
        this.text = text;
    }
    String getText() {
        return text;
    }
}

class Momentocode {
    public static void main(String[] args) {
        Editor e = new Editor();
        e.setText("Hello");
        Memento m = e.save();
        e.setText("Hello World");
        System.out.println(e.getText());
        e.restore(m);
        System.out.println(e.getText());
    }
}