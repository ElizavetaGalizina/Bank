package enity;

import exception.MoneyException;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс, описывающий работу банковского сотрудника.
 */
public class BankWorker extends Thread{

    Logger log = Logger.getLogger(String.valueOf(BankWorker.class));

    /**
     * Очередь клиентов.
     */
    private final LinkedList<BankClient> queue;

    /**
     * Касса.
     */
    private Cashbox cashbox;

    /**
     * Конструктор с параметром.
     * @param cashbox касса.
     */
    public BankWorker(Cashbox cashbox) {
        this.queue = new LinkedList<>();
        this.cashbox = cashbox;
    }

    /**
     * Добавление клиента в очередь.
     * @param client клиент.
     */
    public void addToQueue(BankClient client) {
        synchronized(queue) {
            queue.addLast(client);
            queue.notify();
        }
    }

    /**
     * Функция потока.
     * Работник банка ждёт до тех пор, пока клиент не появится в очереди.
     * Обслужив одного клиента, работник банка начинает обслуживать следующего клиента
     * или ждёт пока в очереди не появится следующий клиент.
     */
    @Override
    public void run() {
        BankClient client;

        while (true) {
            synchronized(queue) {
                while (queue.isEmpty()) {
                    try
                    {
                        queue.wait();
                    }
                    catch (InterruptedException ignored)
                    {
                    }
                }
                client = queue.removeFirst();
            }

            try {
                if (client.isDepositOrWithdrawal()) {
                    this.getCashbox().addMoney(client.getMoney());
                    log.log(Level.INFO,"Клиент внес " + client.getMoney() + " денег.");
                    log.log(Level.INFO,"Время обслуживания " + client.getServiceTime());
                } else {
                    this.getCashbox().getMoney(client.getMoney());
                    log.log(Level.INFO,"Клиент взял " + client.getMoney() + " денег.");
                    log.log(Level.INFO,"Время обслуживания " + client.getServiceTime());
                }
                log.log(Level.INFO,"Общее количество денег в банке: " + this.getCashbox().getMoney());
                Thread.sleep(client.getServiceTime());
            }
            catch (RuntimeException | InterruptedException | MoneyException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод доступа к очереди клиентов.
     * @return очередь клиентов.
     */
    public LinkedList<BankClient> getQueue() {
        return queue;
    }

    /**
     * Метод доступа к касссе.
     * @return касса
     */
    public Cashbox getCashbox() {
        return cashbox;
    }
}
