import enity.Bank;
import enity.BankClient;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Bank bank = new Bank();

        while (true) {
            if (random.nextInt(100000) == 1) {
                BankClient client = new BankClient(bank);
                client.start();
            }
        }
    }
}
