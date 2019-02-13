package student;

import edu.rit.cs.Currency;

import static bank.AccountType.DEBIT;

public class CDAccount extends BankAccount {
    public static final Currency MINIMUM_BALANCE = new Currency(1000, 0) ;
    public static final double MONTHLY_INTEREST_RATE = 0.006 / NUM_PERIODS_PER_YEAR ;

    public CDAccount(Currency newMoney, String owner){
        super(newMoney, owner, DEBIT) ;
    }

    public void endOfMonth(){
        if (this.getCurrentBalance().compareTo(MINIMUM_BALANCE) > 0) {
            Currency intEarned = getCurrentBalance().subtract(MINIMUM_BALANCE).multiply(MONTHLY_INTEREST_RATE);
            setInterestAccrued(intEarned);
            addInterest(intEarned);
        }
    }
    public String getAccountType(){
        return "CD" ;
    }
    @Override
    public String toString(){
        return super.toString() + " CD" ;
    }
}
