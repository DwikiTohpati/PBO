import java.util.ArrayList;

class User {
    String username;
    String password;
    double saldo;
    ArrayList<Transaction> transactionHistory;
    String namaTujuan;
    String noTujuan;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.namaTujuan = "";
        this.noTujuan = "";
    }

    public void displayBalance() {
        System.out.println("Saldo : Rp. " + saldo);
    }

    public void displayTransactionHistory() {
        System.out.println("History Transaksi : ");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void topUp(double amount, String topUpMethod, String namaTujuan, String noTujuan) {
        saldo += amount;
        transactionHistory.add(new Transaction("Top-up", amount, namaTujuan, noTujuan, topUpMethod));
        System.out.println("Top-up successful. Saldo Baru : Rp. " + saldo);
    }

    public void makePayment(double amount, String namaTujuan, String noTujuan, String paymentMethod) {
        if (saldo >= amount) {
            saldo -= amount;
            transactionHistory.add(new Transaction("Payment", amount, namaTujuan, noTujuan, paymentMethod));
            System.out.println("Payment successful. Sisa Saldo : Rp. " + saldo);
        } else {
            System.out.println("Saldo Tidak Cukup. Please top-up.");
}
}
}
