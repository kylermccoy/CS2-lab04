package student;

import edu.rit.cs.Currency;
import static bank.AccountType.CREDIT;

public class CreditCard extends BankAccount {
    private Currency creditLimit ;
    private double monthlyInterestRate ;

    public CreditCard(Currency creditLimit, double interestRate, String owner) {
        super(creditLimit, owner, CREDIT) ;
        this.creditLimit = creditLimit ;
        this.monthlyInterestRate = interestRate / NUM_PERIODS_PER_YEAR ;
    }

    public Currency getCurrentBalance() {
        return super.getCurrentBalance().subtract(this.creditLimit) ;
    }
    public void endOfMonth() {
        Currency intEarned = getCurrentBalance().multiply(monthlyInterestRate) ;
        setInterestAccrued( intEarned ) ;
        addInterest( intEarned ) ;
    }
    public String getAccountType() {
        return "CC" ;
    }
}
