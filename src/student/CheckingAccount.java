/**
 * CheckingAccount.java
 * Author: Kyle McCoy krm7269@rit.edu
 * simulates a CA account for the Bank Account super class
 */

package student;

import edu.rit.cs.Currency;

import static bank.AccountType.DEBIT;

/**
 * subclass of the abstract class BankAccount
 */
public class CheckingAccount extends BankAccount {
    // if they receive interest gains
    private boolean bonus ;
    // interest rates
    public static final double BONUS_MONTHLY_RATE = 0.001 / NUM_PERIODS_PER_YEAR ;
    // account type
    public final String chkAcctType ;
    // min balance to receive bonus interest
    public static final Currency PREMIUM_CHECKING_MINIMUM_BALANCE = new Currency(500, 0) ;

    /**
     * constructor for a CA
     * @param newMoney current balance
     * @param owner string of name
     * @param bonus if they receive interest
     */
    public CheckingAccount(Currency newMoney, String owner, boolean bonus) {
        super(newMoney, owner, DEBIT) ;
        this.bonus = bonus ;
        if (this.bonus) {
            this.chkAcctType = "CI" ;
        }else{
            this.chkAcctType = "CN" ;
        }
    }

    /**
     * Calculate the interest and update the balance for this account.
     * Interest earned is calculated monthly,
     * and added to the current balance.
     * The value returned by {@link BankAccount#getInterest()} will be
     * the interest computed by this method.
     */
    public void endOfMonth() {
        if (bonus && this.getCurrentBalance().compareTo(PREMIUM_CHECKING_MINIMUM_BALANCE) > 0) {
            Currency intEarned = getCurrentBalance().multiply(BONUS_MONTHLY_RATE) ;
            setInterestAccrued( intEarned ) ;
            addInterest( intEarned ) ;
        }else{
            setInterestAccrued(Currency.ZERO) ;
        }
    }

    /**
     * The account type designation for this account.
     *
     * @return "CN" or "CI"
     */
    public String getAccountType() {
        return this.chkAcctType ;
    }

    /**
     * A printable version of this account
     *
     * @return the owner name, current balance and the literal "Checking" to
     * identify this account
     */
    @Override
    public String toString() {
        return super.toString() + " Checking" ;
    }
}
