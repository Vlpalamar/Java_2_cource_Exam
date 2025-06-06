import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private List<Account> accounts= new ArrayList<>();
    private List<Client> clients= new ArrayList<>();
    private HashMap<Integer,Integer> accountIdDepositId= new HashMap<Integer,Integer>();
    private HashMap<Integer,Integer> accountIdTransactionId= new HashMap<Integer,Integer>();


    private static Bank INSTANCE;

    public static Bank getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Bank();
        }
        return INSTANCE;
    }


    public void addClient(Client client)
    {
        if (clients.contains(client))
            return;

        clients.add(client);
    }

    public Account makeNewAccount(Client client, int startDeposite)
    {
        Account newAccount= new Account(startDeposite,client);
        accounts.add(newAccount);

        return newAccount;
    }


    public void createDeposit(int amount, int accountId)
    {
        Deposit newDeposit= new Deposit(amount);
        Account account=  accounts.stream().filter(x->x.getAccountID()==accountId).findFirst().get();
        account.addFunds(newDeposit.getDepositeSumm());
        accountIdDepositId.put(accountId,newDeposit.getDepositeID());
        account.addDeposit(newDeposit);

    }

    public  Transaction withdrowMoney(Account accountToWithdrow,int amountToWithdrow)
    {
        Transaction newTransaction = new WithdrowTransaction(accountToWithdrow,amountToWithdrow);
        newTransaction.setComment("withdrow this summ:"+ amountToWithdrow);
        newTransaction.makeTransaction();
        accountIdTransactionId.put(accountToWithdrow.getAccountID(),newTransaction.getTransactionID());

        return newTransaction;
    }

    public Transaction sendFunds(Account sender, Account recipient, int amountOfFunds, String sendersComm) {
       Transaction newTransaction = new TranferTransaction(sender,recipient,amountOfFunds);
       newTransaction.setComment("sender:"+sender.getAccountID()+"send"+amountOfFunds+"$ to recipient:"+recipient.getAccountID()+"with commentary:\""+sendersComm+"\"");
       newTransaction.makeTransaction();
       accountIdTransactionId.put(sender.getAccountID(),newTransaction.getTransactionID());
       accountIdTransactionId.put(recipient.getAccountID(),newTransaction.getTransactionID());

       return newTransaction;
    }

    public void transactionInfo(Transaction transaction)
    {
        if (transaction instanceof TranferTransaction)
        {
            System.out.println("sender:"+transaction.client.getAccountID());
            System.out.println("recipient:"+((TranferTransaction) transaction).recipient.getAccountID());
            System.out.println("amount:"+transaction.ammountOfFunds);
            System.out.println("comment:"+transaction.getComment());
        }
        if (transaction instanceof WithdrowTransaction)
        {
            System.out.println("owner:"+transaction.client.getAccountID());
            System.out.println("amount to withdrow:"+transaction.ammountOfFunds);

        }

    }
}
