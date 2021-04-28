package main.arca;

import main.common.BankCard;
import main.exception.ArcaException;
import main.exception.BankException;

public class ArcaService {
    /**
     * @param card
     * @param money
     * @throws ArcaException
     */
    public void processTransaction(BankCard card, int money) throws ArcaException {
        try {
            card.getInsureBank().processTransaction(card, money);
        } catch (BankException e) {
            e.printStackTrace();
            throw new ArcaException(e.getMessage());
        }
    }
}
