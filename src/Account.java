import java.util.ArrayList;
import java.util.List;

public class Account {
    private int amountFunds;
    private int accountID;
    private Client owner;
    private List<Deposit> deposits = new ArrayList<>();


    public Account(int amountFunds, Client owner)
    {
       this.amountFunds= amountFunds;
       this.owner= owner;
       this.accountID = (int)(Math.random()*100000);
    }

    public int getAmountFunds() {
        return amountFunds;
    }

    public void addFunds(int fundsToAdd)
    {
        amountFunds =amountFunds+fundsToAdd;
    }

    public void minusFunds(int fundsToMinus)
    {
        amountFunds= amountFunds-fundsToMinus;
    }

    public void showCurrentAmountOfFunds()
    {
        System.out.print("You Have "+ amountFunds+"$ on this account");
    }

    public int getAccountID() {
        return accountID;
    }

    public void   addDeposit(Deposit newDeposit)
    {
        deposits.add(newDeposit);
    }
}
