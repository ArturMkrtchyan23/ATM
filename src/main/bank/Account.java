package main.bank;

import main.common.BankCard;

public class Account {
    private BankCard bankCard;
    private final String accountNumber;
    private int balance;

    /**
     * @param bankCard
     * @param accountNumber
     */
    public Account(BankCard bankCard, String accountNumber) {
        this.bankCard = bankCard;
        this.accountNumber = accountNumber;
    }
    /**
     * @param bankCard
     * @param accountNumber
     * @param balance
     */
    public Account(BankCard bankCard, String accountNumber, int balance) {
        this.bankCard = bankCard;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Account{" +
                "bankCard=" + bankCard +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
