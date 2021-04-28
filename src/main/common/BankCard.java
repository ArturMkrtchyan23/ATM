package main.common;

import main.bank.Insure;
import java.util.Objects;

public class BankCard {
    private final String owner;
    private final String pan;
    private final String expireDate;
    private final Insure insureBank;

    /**
     * @param owner
     * @param pan
     * @param expireDate
     * @param bank
     */
    public BankCard(String owner, String pan, String expireDate, Insure bank) {
        this.owner = owner;
        this.pan = pan;
        this.expireDate = expireDate;
        this.insureBank = bank;
    }

    public String getOwner() {
        return owner;
    }

    public String getPan() {
        return pan;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public Insure getInsureBank() {
        return insureBank;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "BankCard{" +
                "owner='" + owner + '\'' +
                ", pan='" + pan + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(pan, bankCard.pan);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(owner, pan, expireDate, insureBank);
    }
}
