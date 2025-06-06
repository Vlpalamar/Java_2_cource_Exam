import java.util.ArrayList;
import java.util.List;

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

    public Client(String name) {
        this.name = name;
        this.id = (int) (Math.random() * 1000000);

    }

    public Account askToOpenNewAccount(int startCapital) {
        accounts.add(Bank.getInstance()
                .makeNewAccount(this, startCapital));

        return accounts.getLast();
    }

    public void tryToAskDeposite(int fundsToAsk, Account accountToAdd) {
        Bank.getInstance().createDeposit(fundsToAsk, accountToAdd.getAccountID());

    }

    public Transaction askToSendFunds(Account sender, Account recipient, int amountOfFunds, String comment) {
        if (!accounts.contains(sender)) {
            System.out.print("цей рахунок вам не належить");
            return null;
        }

       return Bank.getInstance().sendFunds(sender, recipient, amountOfFunds, comment);
    }

    public void checkAccount(Account accountToCheck) {
        if (!accounts.contains(accountToCheck)) {
            System.out.print("цей рахунок вам не належить");
            return;
        }

        accountToCheck.showCurrentAmountOfFunds();
    }

    public Transaction askToWithdrowFunds(Account owner, int amountOfFunds) {
        if (!accounts.contains(owner)) {
            System.out.print("цей рахунок вам не належить");
            return null;
        }

       return  Bank.getInstance().withdrowMoney(owner,  amountOfFunds);
    }

    public void askToCheckTransactionInfo(Transaction transaction)
    {
        Bank.getInstance().transactionInfo(transaction);
    }
}
