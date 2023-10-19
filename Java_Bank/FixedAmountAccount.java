public class FixedAmountAccount extends AbstractAccount {
    public FixedAmountAccount(double initialBalance) {
        super(initialBalance);
    }

    public FixedAmountAccount() {
        super(0.0); // примерный начальный баланс
    }

    @Override
    public void put(double amount) {
        System.out.println("Операция недоступна для данного типа счета");
    }

    @Override
    public void take(double amount) {
        System.out.println("Операция недоступна для данного типа счета");
    }
}