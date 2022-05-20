package pl.wsb.programowaniejava.maciejgowin.przyklad;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = BankAccount.builder().balance(10.0).build();
        bankAccount.add(20.0);
        System.out.println(bankAccount.getBalance());
    }
}
