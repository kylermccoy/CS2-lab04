package student;

import edu.rit.cs.Currency;

import static bank.AccountType.DEBIT;

public class CheckingAccount extends BankAccount {
    private boolean bonus ;
    public static final double BONUS_MONTHLY_RATE = 0.001 / NUM_PERIODS_PER_YEAR ;
    public final String chkAcctType ;
    public static final Currency PREMIUM_CHECKING_MINIMUM_BALANCE = new Currency(500, 0) ;

    public CheckingAccount(Currency newMoney, String owner, boolean bonus) {
        super(newMoney, owner, DEBIT) ;
        this.bonus = bonus ;
        if (this.bonus) {
            this.chkAcctType = "CI" ;
        }else{
            this.chkAcctType = "CN" ;
        }
    }

    public void endOfMonth() {

    }
    public String getAccountType() {
        return this.chkAcctType ;
    }
    @Override
    public String toString() {
        return super.toString() + " Checking" ;
    }
}
