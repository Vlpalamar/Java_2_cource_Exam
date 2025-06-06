public  class WithdrowTransaction extends Transaction
{

    protected WithdrowTransaction(Account client,int amountOfFunds) {
        super(client,amountOfFunds);
    }

    @Override
    protected void makeTransaction() {
        this.client.minusFunds(ammountOfFunds);

    }
}
