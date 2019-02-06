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
        return this.creditLimit ;
    }
    public void endOfMonth() {

    }
    public String getAccountType() {
        return "CC" ;
    }
}
