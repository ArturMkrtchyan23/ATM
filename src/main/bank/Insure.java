package main.bank;

import main.common.BankCard;
import main.exception.BankException;
import java.util.Iterator;
import java.util.Set;

public enum Insure {
    ID{
        @Override
        public void processTransaction(BankCard card, int money) throws BankException {
           Set<Account> accountSet = AccountService.prepareAccountForInsure(this);
            for (Iterator<Account> it = accountSet.iterator(); it.hasNext();) {
                Account account = it.next();
                if (account.getBankCard().equals(card) ){
                    if (account.getBalance()< money){
                        throw new BankException("not  enough available balance");
                    }
                    account.setBalance(account.getBalance()  - money);
                    break;
                }
                if (!it.hasNext()){
                    throw new BankException("Card not found");
                }
            }
        }
    },

    ABB{
        @Override
        public void processTransaction(BankCard card, int money) throws BankException {
            Set<Account> accountSet = AccountService.prepareAccountForInsure(this);
            for (Iterator<Account> it = accountSet.iterator(); it.hasNext();) {
                Account account = it.next();
                if (account.getBankCard().equals(card) ){
                    if (account.getBalance()< money){
                        throw new BankException("not  enough available balance");
                    }
                    account.setBalance(account.getBalance()  - money);
                    break;
                }
                if (!it.hasNext()){
                    throw new BankException("Card not found");
                }
            }
        }
    },

    HSBC{
        @Override

        public void processTransaction(BankCard card, int money) throws BankException {
            Set<Account> accountSet = AccountService.prepareAccountForInsure(this);
            for (Iterator<Account> it = accountSet.iterator(); it.hasNext();) {
                Account account = it.next();
                if (account.getBankCard().equals(card) ){
                    if (account.getBalance()< money){
                        throw new BankException("not  enough available balance");
                    }
                    account.setBalance(account.getBalance()  - money);
                    break;
                }
                if (!it.hasNext()){
                    throw new BankException("Card not found");
                }
            }
        }
    };

    public abstract void processTransaction(BankCard card, int money) throws BankException;
}
