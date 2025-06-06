public class TranferTransaction extends  Transaction{

    Account recipient;


    protected TranferTransaction(Account client, Account recipient,int amountOfFunds) {
        super(client,amountOfFunds);
       this.recipient= recipient;

    }

    @Override
    protected void makeTransaction() {
       this.client.minusFunds(this.ammountOfFunds);
       this.recipient.addFunds(this.ammountOfFunds);


    }
}
