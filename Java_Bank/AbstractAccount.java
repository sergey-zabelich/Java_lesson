public abstract class AbstractAccount implements Account {
    protected double balance;

    public AbstractAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void put(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен на " + amount);
        } else {
            System.out.println("Некорректная сумма для пополнения");
        }
    }
 
    public void take(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Со счёта снято " + amount);
        } else {
            System.out.println("Недостаточно средств на счёте");
        }
    }

    public double getAmount() {
        return balance;
    }
}