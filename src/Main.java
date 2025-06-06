public class Main {
    public static void main(String[] args) {



       Client vasa= new Client("vasa");
       Account newAcc= vasa.askToOpenNewAccount(100);
       vasa.tryToAskDeposite(1000, newAcc);
       vasa.checkAccount(newAcc);
       Transaction withdrowTransaction =vasa.askToWithdrowFunds(newAcc,100);
       vasa.checkAccount(newAcc);
       Account secAcc= vasa.askToOpenNewAccount(100);
       Transaction transToSend= vasa.askToSendFunds(newAcc,secAcc,100,"gift");
       vasa.checkAccount(newAcc);
       vasa.checkAccount(secAcc);

       vasa.askToCheckTransactionInfo(transToSend);
       vasa.askToCheckTransactionInfo(withdrowTransaction);





    }
}