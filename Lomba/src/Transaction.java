
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    String type;
    double Saldo;
    Date date = new Date();
    String namaTujuan;
    String noTujuan;
    String topUpMethod;

    public Transaction(String type, double Saldo, String namaTujuan, String noTujuan, String topUpMethod) {
        this.type = type;
        this.Saldo = Saldo;
        this.namaTujuan = namaTujuan;
        this.noTujuan = noTujuan;
        this.topUpMethod = topUpMethod;
    }


    @Override
    public String toString() {
        SimpleDateFormat Tanggal = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return type + ": Rp." + Saldo + " | Tanggal : " + Tanggal.format(date) +
                " | Nama Tujuan : " + namaTujuan + " (" + noTujuan + ")" +
                " | Method : " + topUpMethod;
}
}
