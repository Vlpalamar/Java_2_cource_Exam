public class Deposit {
    private int depositeID;
    private int depositeSumm;

    public int getDepositeSumm() {
        return depositeSumm;
    }

    public Deposit(int summ)
    {
        depositeSumm= summ;
        this.depositeID= (int) (Math.random()*1000000);
    }

    public int getDepositeID() {
        return depositeID;
    }
}
