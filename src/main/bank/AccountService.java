package main.bank;

import main.common.BankCard;
import java.util.*;

public class AccountService {

    private static Map<Insure, Set<Account>> accountData = new HashMap<>();
    /**
     * @param bank
     * @return
     */
    public static Set<Account> prepareAccountForInsure(Insure bank) {

        if (accountData.get(bank) == null ||accountData.get(bank).isEmpty()) {
            Set<Account> accountSet = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                accountSet.add(openBankAccount(printBankCard(bank)));
            }
            accountData.put(bank,accountSet);
            return accountSet;
        }
        return accountData.get(bank);
    }
    /**
     * @param bank
     * @return
     */
    public static BankCard printBankCard(Insure bank) {

        BankCard result = new BankCard("name surname", AccountService.generatePan(), "02/25", bank);
        return result;
    }
    /**
     * @return
     */
    public static String generatePan(){

        String panNumber = "";
        for (int i = 0; i < 16; i++){
            int k = (int) (Math.random() * 10);
            panNumber += k;
        }
        return panNumber;
    }
    /**
     * @param bankCard
     * @return
     */
    public static Account openBankAccount(BankCard bankCard) {

        String accountNumber = "";
        for (int i = 0; i < 12; i++) {
            int k = (int) (Math.random() * 10);
            accountNumber += k;
        }
        return new Account(bankCard, accountNumber, 500000);
    }

}
