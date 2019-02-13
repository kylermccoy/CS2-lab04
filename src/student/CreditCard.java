/**
 * CreditCard.java
 * Author: Kyle McCoy krm7269@rit.edu
 * simulates a CD account for the Bank Account super class
 */

package student;

import edu.rit.cs.Currency;
import static bank.AccountType.CREDIT;

/**
 * subclass of the abstract class BankAccount
 */
public class CreditCard extends BankAccount {
    // credit limit
    private Currency creditLimit ;
    // monthly interest growth rate
    private double monthlyInterestRate ;

    /**
     * constructor for credit card account
     * @param creditLimit current balance
     * @param interestRate rate of interest
     * @param owner string of name
     */
    public CreditCard(Currency creditLimit, double interestRate, String owner) {
        super(creditLimit, owner, CREDIT) ;
        this.creditLimit = creditLimit ;
        this.monthlyInterestRate = interestRate / NUM_PERIODS_PER_YEAR ;
    }

    /**
     *  returns the current amount own
     */
    public Currency getCurrentBalance() {
        return super.getCurrentBalance().subtract(this.creditLimit) ;
    }

    /**
     * Calculate the interest and update the balance for this account.
     * Interest earned is calculated monthly,
     * and added to the current balance.
     * The value returned by {@link BankAccount#getInterest()} will be
     * the interest computed by this method.
     */
    public void endOfMonth() {
        Currency intEarned = getCurrentBalance().multiply(monthlyInterestRate) ;
        setInterestAccrued( intEarned ) ;
        addInterest( intEarned ) ;
    }

    /**
     * The account type designation for this account.
     *
     * @return "CC"
     */
    public String getAccountType() {
        return "CC" ;
    }
}
