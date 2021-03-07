package enity;

/**
 * Класс, описывающий работу банка.
 */
public class Bank {

    /**
     * Касса банка.
     */
    private final Cashbox cashbox;

    /**
     * Сотрудники банка.
     */
    private final BankWorker bankWorker1;
    private final BankWorker bankWorker2;
    private final BankWorker bankWorker3;
    private final BankWorker bankWorker4;
    private final BankWorker bankWorker5;

    /**
     * Конструктор без параметров.
     */
    public Bank() {

        this.cashbox = new Cashbox(25500);

        this.bankWorker1 = new BankWorker(cashbox);
        this.bankWorker2 = new BankWorker(cashbox);
        this.bankWorker3 = new BankWorker(cashbox);
        this.bankWorker4 = new BankWorker(cashbox);
        this.bankWorker5 = new BankWorker(cashbox);

        this.bankWorker1.start();
        this.bankWorker2.start();
        this.bankWorker3.start();
        this.bankWorker4.start();
        this.bankWorker5.start();
    }

    /**
     * Метод доступа к кассе банка.
     * @return касса банка
     */
    public Cashbox getCashbox() {
        return cashbox;
    }

    /**
     * Метод доступа к первому сотруднику банка.
     * @return 1ый сотрудник банка
     */
    public BankWorker getBankWorker1() {
        return bankWorker1;
    }

    /**
     * Метод доступа ко второму сотруднику банка.
     * @return 2ой сотрудник банка
     */
    public BankWorker getBankWorker2() {
        return bankWorker2;
    }

    /**
     * Метод доступа к третьему сотруднику банка.
     * @return 3ий сотрудник банка
     */
    public BankWorker getBankWorker3() {
        return bankWorker3;
    }

    /**
     * Метод доступа к четвертому сотруднику банка.
     * @return 4ый сотрудник банка
     */
    public BankWorker getBankWorker4() {
        return bankWorker4;
    }

    /**
     * Метод доступа к пятому сотруднику банка.
     * @return 5ый сотрудник банка
     */
    public BankWorker getBankWorker5() {
        return bankWorker5;
    }

    /**
     * Подбор очереди с наименьшим числом клиентов.
     * @param client клиент
     */
    public void selectionQueue(BankClient client) {
        if (bankWorker1.getQueue().isEmpty()) {
            bankWorker1.addToQueue(client);
        } else if (bankWorker2.getQueue().isEmpty()) {
            bankWorker2.addToQueue(client);
        } else if (bankWorker3.getQueue().isEmpty()) {
            bankWorker3.addToQueue(client);
        } else if (bankWorker4.getQueue().isEmpty()) {
            bankWorker4.addToQueue(client);
        } else if (bankWorker5.getQueue().isEmpty()) {
            bankWorker5.addToQueue(client);
        } else if (bankWorker1.getQueue().size() < bankWorker2.getQueue().size()
                && bankWorker1.getQueue().size() < bankWorker3.getQueue().size()
                && bankWorker1.getQueue().size() < bankWorker4.getQueue().size()
                && bankWorker1.getQueue().size() < bankWorker5.getQueue().size()) {
            bankWorker1.addToQueue(client);
        } else if (bankWorker2.getQueue().size() < bankWorker1.getQueue().size()
                && bankWorker2.getQueue().size() < bankWorker3.getQueue().size()
                && bankWorker2.getQueue().size() < bankWorker4.getQueue().size()
                && bankWorker2.getQueue().size() < bankWorker5.getQueue().size()) {
            bankWorker2.addToQueue(client);
        } else if (bankWorker3.getQueue().size() < bankWorker1.getQueue().size()
                && bankWorker3.getQueue().size() < bankWorker2.getQueue().size()
                && bankWorker3.getQueue().size() < bankWorker4.getQueue().size()
                && bankWorker3.getQueue().size() < bankWorker5.getQueue().size()) {
            bankWorker3.addToQueue(client);
        } else if (bankWorker4.getQueue().size() < bankWorker1.getQueue().size()
                && bankWorker4.getQueue().size() < bankWorker2.getQueue().size()
                && bankWorker4.getQueue().size() < bankWorker3.getQueue().size()
                && bankWorker4.getQueue().size() < bankWorker5.getQueue().size()) {
            bankWorker4.addToQueue(client);
        } else {
            bankWorker5.addToQueue(client);
        }
    }
}
