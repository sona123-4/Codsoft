public class ATM {
    private Bankaccount account;

    public ATM(Bankaccount account) {
        this.account = account;
    }

    public boolean  withdraw(double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public int checkBalance() {
        return (int)account.getBalance();
    }
}