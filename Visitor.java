interface Visit {
    void visit(Book book);
    void visit(Laptop laptop);
}
class Tax implements Visit {
    public void visit(Book book) {
        System.out.println("Book Tax is :"+0.5*book.getPrice());
    }
    public void visit(Laptop laptop) {
        System.out.println("Laptop Tax is :"+0.2*laptop.getPrice());
    }
}
class Book {
    private double price;
    Book(double price) {
        this.price = price;
    }
    double getPrice() {
        return price;
    }
    void accept(Visit visitor) {
        visitor.visit(this);
    }
}
class Laptop {
    private double price;
    Laptop(double price) {
        this.price = price;
    }
    double getPrice() {
        return price;
    }
    void accept(Visit visitor) {
        visitor.visit(this);
    }
}
class Visitor {
    public static void main(String args[]) {
        Book book = new Book(100.0);
        Laptop laptop = new Laptop(500.0);
        Visit tax = new Tax();
        book.accept(tax);
        laptop.accept(tax);
    }
}