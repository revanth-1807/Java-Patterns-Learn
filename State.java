interface AtmState {
    void insertCard();
    void withdraw();
}

class NoCard implements AtmState {
    public void insertCard() {
        System.out.println("Card inserted");
    }
    public void withdraw() {
        System.out.println("Please insert Card first");
    }
}

class CardInserted implements AtmState {
    public void insertCard() {
        System.out.println("Card already inserted");
    }
    public void withdraw() {
        System.out.println("Please enter pin first");
    }
}

class PinEntered implements AtmState {
    public void insertCard() {
        System.out.println("Card already inserted");
    }
    public void withdraw() {
        System.out.println("Money withdrawn");
    }
}

class ATM {
    private AtmState state;
    public ATM() {
        state=new NoCard();
    }
    public void setState(AtmState state) {
        this.state=state;
    }
    public void insertCard() {
        state.insertCard();
    }
    public void withdraw() {
        state.withdraw();
    }
}

class State {
    public static void main(String args[]) {
        ATM atm=new ATM();
        atm.withdraw();
        atm.insertCard();
        atm.setState(new CardInserted());
        atm.insertCard();
        atm.withdraw();
        atm.setState(new PinEntered());
        atm.insertCard();
        atm.withdraw();
    }
}