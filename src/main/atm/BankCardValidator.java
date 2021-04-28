package main.atm;

import main.common.BankCard;
import main.exception.InvalidCardException;
import java.time.LocalDateTime;

public class BankCardValidator {

    /**
     * @param card
     * @throws InvalidCardException
     */
    public void validateBankCard(BankCard card) throws InvalidCardException {
        this.validateExpireDate(card.getExpireDate());
    }

    /**
     * @param owner
     * @throws InvalidCardException
     */
    private void validateOwner(String owner) throws InvalidCardException {
         if (!owner.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$")) {
             throw new InvalidCardException("invalid Name for Owner");
         }
    }

    /**
     * @param pan
     * @throws InvalidCardException
     */
    private void validatePan(String pan) throws InvalidCardException {
        if (!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            throw new InvalidCardException("Invalid Pan");
        }
    }

    /**
     * @param expireDate
     * @throws InvalidCardException
     */
    private void validateExpireDate(String expireDate) throws InvalidCardException {

        String[] exDate = expireDate.split("/");
        LocalDateTime now =  LocalDateTime.now();
        final int year = now.getYear();
        final int month = now.getMonthValue();
        if (year > (Integer.parseInt(exDate[1])+2000) || (year == (Integer.parseInt(exDate[1]) + 2000) && month > Integer.parseInt(exDate[1]))){
            throw new InvalidCardException("Card is expired");
        }
    }
}
