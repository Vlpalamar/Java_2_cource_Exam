import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    private String name;
    private int id;
    private List<Account> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Client (String name)
    {
        this.name= name;
        this.id= (int) (Math.random()*1000000);

    }

    public Account tryToOpenNewAccount(int startCapital)
    {
       accounts.add(Bank.getInstance()
                .makeNewAccount(this,startCapital));

       return accounts.getLast();
    }

    public void tryToAskDeposite(int fundsToAsk, Account accountToAdd)
    {
        Bank.getInstance().createDeposit(fundsToAsk,accountToAdd.getAccountID());

    }

    public void askToMakeSendFunds(Account sender, Account recipient,int amountOfFunds,String comment) {
        if (!accounts.contains(sender)){
            System.out.print("цей рахунок вам не належить");
        return;
        }

        Bank.getInstance().sendFunds(sender,recipient,amountOfFunds,comment);
    }


}
