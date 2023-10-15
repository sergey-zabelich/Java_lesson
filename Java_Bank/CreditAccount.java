public class CreditAccount extends Account {
    @Override
    public void take(double amount) {
        if (amount > 0 && amount <= getAmount()) {
            double commission = amount * 0.01; // Рассчитываем комиссию
            super.take(amount + commission); // Снимаем с учетом комиссии
            System.out.println("Комиссия составила: " + commission);
        } else {
            System.out.println("Недостаточно средств на счёте");
        }
    }
}