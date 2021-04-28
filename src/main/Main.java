package main;

import main.atm.ATM;
import main.bank.AccountService;
import main.bank.Insure;
import main.common.BankCard;
import main.common.CardService;
import main.exception.ATMException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<BankCard> idBankCards = CardService.provideBankCardsForInsure(Insure.ID);
        ATM atmid = new ATM();
        for (BankCard card: idBankCards) {
            try {
                atmid.cardInput(card);
                atmid.withdrawMoney(50000);
            } catch (ATMException e) {
                e.printStackTrace();
            }
        }
        AccountService.prepareAccountForInsure(Insure.ID).stream().forEach(System.out::println);

        Set<BankCard> abbBankCards = CardService.provideBankCardsForInsure(Insure.ABB);
        ATM atmabb = new ATM();
        for (BankCard card: abbBankCards) {
            try {
                atmabb.cardInput(card);
                atmabb.withdrawMoney(20000);
            } catch (ATMException e) {
                e.printStackTrace();
            }
        }
        AccountService.prepareAccountForInsure(Insure.ABB).stream().forEach(System.out::println);

        Set<BankCard> hsbcBankCards = CardService.provideBankCardsForInsure(Insure.HSBC);
        ATM atmhsbc = new ATM();
        for (BankCard card: hsbcBankCards) {
            try {
                atmhsbc.cardInput(card);
                atmhsbc.withdrawMoney(30000);
            } catch (ATMException e) {
                e.printStackTrace();
            }
        }
        AccountService.prepareAccountForInsure(Insure.HSBC).stream().forEach(System.out::println);
    }
}
