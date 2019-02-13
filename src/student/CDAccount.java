/**
 * CDAccount.java
 * Author: Kyle McCoy krm7269@rit.edu
 * simulates a CD account for the Bank Account super class
 */

package student;

import edu.rit.cs.Currency;

import static bank.AccountType.DEBIT;

/**
 * subclass of the abstract class BankAccount
 */
public class CDAccount extends BankAccount {
    // minimum balance needed to gain interest
    public static final Currency MINIMUM_BALANCE = new Currency(1000, 0) ;
    // monthly interest rate
    public static final double MONTHLY_INTEREST_RATE = 0.006 / NUM_PERIODS_PER_YEAR ;

    /**
     * constructor for CDAccount class
     * @param newMoney current balance
     * @param owner string of name
     */
    public CDAccount(Currency newMoney, String owner){
        super(newMoney, owner, DEBIT) ;
    }

    /**
     * Calculate the interest and update the balance for this account.
     * Interest earned is calculated monthly,
     * and added to the current balance.
     * The value returned by {@link BankAccount#getInterest()} will be
     * the interest computed by this method.
     */
    public void endOfMonth(){
        if (this.getCurrentBalance().compareTo(MINIMUM_BALANCE) > 0) {
            Currency intEarned = getCurrentBalance().subtract(MINIMUM_BALANCE).multiply(MONTHLY_INTEREST_RATE);
            setInterestAccrued(intEarned);
            addInterest(intEarned);
        }
    }

    /**
     * The account type designation for this account.
     *
     * @return "CD"
     */
    public String getAccountType(){
        return "CD" ;
    }

    /**
     * A printable version of this account
     *
     * @return the owner name, current balance and the literal "CD" to
     * identify this account
     */
    @Override
    public String toString(){
        return super.toString() + " CD" ;
    }
}
