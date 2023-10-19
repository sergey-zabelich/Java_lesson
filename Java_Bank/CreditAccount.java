public class CreditAccount extends AbstractAccount {
    public CreditAccount() {
        super(0.0);
    }

    @Override
    public void take(double amount) {
        if (amount <= getAmount()) {
            double commission = amount * 0.01; // Рассчитываем комиссию
            super.take(amount + commission); // Снимаем с учетом комиссии
            System.out.println("Комиссия составила: " + commission);
        } else {
            System.out.println("Недостаточно средств на счёте");
        }
    }
}