package enity;

import java.util.Random;

/**
 * Класс, описывающий работу клиента банка.
 */
public class BankClient extends Thread{

    /**
     * Пополнение или снятие денег в банке.
     */
    private final boolean depositOrWithdrawal;
    /**
     * Среднее время обслуживания.
     */
    private final long serviceTime;
    /**
     * Количество денег.
     */
    private final int money;
    /**
     * Банк.
     */
    private final Bank bank;

    /**
     * Конструктор с параметром.
     * @param bank банк, в который пришел клиент
     */
    public BankClient(Bank bank) {
        Random random = new Random();

        this.serviceTime = random.nextInt(20000);
        this.money = random.nextInt(20000);
        this.depositOrWithdrawal = random.nextBoolean();
        this.bank = bank;
    }

    /**
     * Метод доступа к операции клиента.
     * @return пополнение или снятие
     */
    public boolean isDepositOrWithdrawal() {
        return depositOrWithdrawal;
    }

    /**
     * Метод доступа к среднему времени обслуживания.
     * @return среднее время обслуживания
     */
    public long getServiceTime() {
        return serviceTime;
    }

    /**
     * Метод доступа к деньгам.
     * @return количество денег в кассе
     */
    public int getMoney() {
        return money;
    }

    /**
     * Метод доступа к банку.
     * @return банк
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Функция потока.
     * Клиент становится в очередь.
     */
    @Override
    public void run() {
        bank.selectionQueue(this);
    }
}
