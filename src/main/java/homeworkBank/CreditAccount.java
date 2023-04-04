package homeworkBank;

public class CreditAccount extends Account {   //  Кредитный счет
    public CreditAccount(int balance) {
        super(balance);
    }

    @Override
    public void setBalance(int balance) {
        this.balance += balance;
        if (this.balance > 0) {
            this.balance -= balance;
            System.out.println("Лимит перевода превышен на: " + (balance + this.balance));

        }
    }

    @Override
    public void pay(int amount) {
        if (amount < balance) {
            System.out.println("Кредитный счет: Недостаточно средств");
        } else {
            int balance = -(amount);
            setBalance(balance);
            System.out.println("Кредитный счет: Списание на сумму: " + amount + " Баланс: " + getBalance());
        }
    }

    @Override
    public void transfer(Account account, int amount) {
        if (amount < balance) {
            System.out.println("Кредитный счет: Недостаточно средств");
        } else {
            int destination = account.getBalance();
            int balance = amount;
            account.setBalance(balance);
            if (destination == account.getBalance())
                System.out.println("Money transfer error!");
            else {
                balance = -balance;
                setBalance(balance);
                System.out.println("Кредитный счет: перевод в размере: " + amount + " Баланс: " + getBalance());
            }
        }
    }

    @Override
    public void addMoney(int amount) {
        if (getBalance() > (-amount)) {
            System.out.println("Кредитный счет: ОШИБКА! Пополнение возможно на сумму:" + getBalance());
        } else {
            int balance = amount;
            setBalance(balance);
            System.out.println("Кредитный счет: Пополнение на: " + amount + " Баланс: " + getBalance());
        }
    }
}