public abstract class Transaction {

    private int transactionID;
    protected Account client;
    protected int ammountOfFunds;
    private String comment;

    protected Transaction(Account client, int amountOfFunds) {
        this.client =client;
        this.ammountOfFunds= amountOfFunds;
        transactionID = (int)(Math.random()*10000);
    }
    abstract protected void makeTransaction();

    public int getTransactionID() {
        return transactionID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

