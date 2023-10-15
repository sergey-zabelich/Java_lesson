public class Account {
    private double balance;

    public void put(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен на " + amount);
        } else {
            System.out.println("Некорректная сумма для пополнения");
        }
    }
 
    public void take(double amount) {
        if (amount > 0 && amount <= balance) {
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