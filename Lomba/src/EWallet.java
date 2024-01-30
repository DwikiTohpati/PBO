import java.util.Scanner;

public class EWallet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        User user = new User("username", "password");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan : ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    if (username.equals(user.username) && password.equals(user.password)) {
                        System.out.println("Login Berhasil.");
                        wallet(user, scanner);
                    } else {
                        System.out.println("Username / Password Tidak Valid. Coba Lagi");
                    }
                    break;

                case 2:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.next();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();

                    user = new User(newUsername, newPassword);
                    System.out.println("Registrasi Berhasil. ");
//                    wallet(user, scanner);
                    break;

                case 3:
                    System.out.println("Keluar...");
                    System.exit(0);

                default:
                    System.out.println("Pilihan Tidak Valid. Mohon Coba Kembali.");
                    break;
            }
        }
    }

    private static void wallet(User user, Scanner scanner) {
        while (true) {
            System.out.println("\nWallet Opsi : ");
            System.out.println("1. Check Saldo");
            System.out.println("2. Top-up");
            System.out.println("3. Pembayaran");
            System.out.println("4. History Transaksi");
            System.out.println("5. Logout");
            System.out.print("Masukkan Pilihan : ");
            int pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    user.displayBalance();
                    break;

                case 2:
                    System.out.print("Banyaknya Uang   : Rp.");
                    double topUpAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Metode           : ");
                    String topUpMethod = scanner.nextLine();
                    System.out.print("Nama Tujuan      : ");
                    String namaTujuan = scanner.nextLine();
                    System.out.print("No. Telp Tujuan  : ");
                    String noTujuan = scanner.nextLine();
                    user.topUp(topUpAmount, topUpMethod, namaTujuan, noTujuan);
                    break;

                case 3:
                    System.out.println("Opsi Pembayaran");
                    System.out.println("1. Bayar Tagihan");
                    System.out.println("2. Transfer");
                    System.out.print("Masukkan Opsi Pembayaran  : ");
                    int paymentOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (paymentOption) {
                        case 1:
                            // Pembayaran Tagihan
                            System.out.print("Banyaknya Uang   : Rp.");
                            double Tagihan = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Penerima         : ");
                            String bill = scanner.nextLine();
                            System.out.print("No. Tujuan       : ");
                            noTujuan = scanner.nextLine();
                            user.makePayment(Tagihan, bill, noTujuan, "Bayar Tagihan");
                            break;

                        case 2:
                            // Transfer
                            System.out.print("Banyaknya Uang : Rp.");
                            double transfer = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            System.out.print("Nama Tujuan    : ");
                            namaTujuan = scanner.nextLine();
                            System.out.print("No. Tujuan     : ");
                            noTujuan = scanner.nextLine();
                            user.makePayment(transfer, namaTujuan, noTujuan, "Transfer");
                            break;

                        default:
                            System.out.println("Opsi Pembayaran Tidak Valid. Mohon Coba Kembali.");
                            break;
                    }
                    break;

                case 4:
                    user.displayTransactionHistory();
                    break;

                case 5:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Pilihan Tidak Valid. Mohon Coba Kembali.");
                    break;
            }
}
}
}
