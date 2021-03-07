package enity;

import exception.MoneyException;

/**
 * Класс, описывающий кассу.
 */
public class Cashbox {

    /**
     * Количество денег.
     */
    private int money;

    /**
     * Конструктор с параметрами.
     * @param money наличность
     */
    public Cashbox(int money) {
        this.money = money;
    }

    /**
     * Пополнение кассы.
     * @param money количество денег для пополения.
     */
    public synchronized void addMoney(int money) {
        this.money += money;
    }

    /**
     * Получение денег из банка.
     * @param money количество денег для получения.
     * @throws MoneyException не хватает денег для выдачи.
     */
    public synchronized void getMoney(int money) throws MoneyException {
        if (money > this.money) {
            throw new MoneyException();
        } else {
            this.money -= money;
        }
    }

    /**
     * Метод получения денег.
     * @return доступные деньги
     */
    public int getMoney() {
        return money;
    }
}
