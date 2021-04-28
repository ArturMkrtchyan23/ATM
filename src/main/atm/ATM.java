package main.atm;

import main.arca.ArcaService;
import main.common.BankCard;
import main.exception.ATMException;
import main.exception.ArcaException;
import main.exception.InvalidCardException;

public class ATM {

    BankCard currentCard;
    BankCardValidator validator;
    int availableMoney;
    ArcaService processingCentre;

    public ATM(){
        this.availableMoney = 1000000;
        this.validator = new BankCardValidator();
        this.processingCentre = new ArcaService();
    }

    /**
     * @param card
     * @throws ATMException
     */

    public void cardInput(BankCard card) throws ATMException {
        if(currentCard != null) {
            throw new ATMException("Current Card is not null");
        }
        try {
            validator.validateBankCard(card);
            this.currentCard = card;
        }catch (InvalidCardException e){
            e.printStackTrace();
            throw new ATMException(e.getMessage());
        }
    }

    /**
     * @param money
     * @throws ATMException
     */
    public void withdrawMoney(int money) throws ATMException {
        if (currentCard == null) {
            throw new ATMException("No card available");
        }
        if (availableMoney < money){
            currentCard = null;
            throw new ATMException("Not enough money");
        }

        try {
            processingCentre.processTransaction(currentCard,money);
            currentCard = null;
            availableMoney -= money;
            System.out.println(availableMoney);
        }catch (ArcaException e){
            e.printStackTrace();
            currentCard = null;
            throw new ATMException(e.getMessage());
        }
    }
}
