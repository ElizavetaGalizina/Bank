package exception;

import enity.BankWorker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для обработки исключений.
 */
public class MoneyException extends Exception {

    Logger log = Logger.getLogger(String.valueOf(MoneyException.class));

    public MoneyException() {

        log.log(Level.WARNING,"Недостаточно средств в кассе");
    }

}
