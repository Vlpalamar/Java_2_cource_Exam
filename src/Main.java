public class Main {
    public static void main(String[] args) {



       Client vasa= new Client("vasa");
       Account newAcc= vasa.tryToOpenNewAccount(100);
       vasa.tryToAskDeposite(1000, newAcc);



    }
}