package homeworkBank;

public abstract class Account {     // Счет
    protected int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public abstract void pay(int amount);  // заплатить

    public abstract void transfer(Account account, int amount);   // перевести

    public abstract void addMoney(int amount);  // пополнить
}

