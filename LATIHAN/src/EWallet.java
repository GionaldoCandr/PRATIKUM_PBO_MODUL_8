class EWallet extends Pembayaran implements Keamanan {
    // Atribut spesifik (Encapsulation)
    private String nomorHP;

    // Constructor
    public EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal); // Memanggil constructor induk
        this.nomorHP = nomorHP;
    }

    // Override metode dari Interface Keamanan
    @Override
    public boolean autentikasi() {
        System.out.println("[SISTEM] Autentikasi berhasil untuk E-Wallet.");
        return true;
    }

    // Override metode dari Abstract Class Pembayaran
    @Override
    public void prosesPembayaran() {
        System.out.println("Biaya Admin       : Rp 0");
        System.out.println("Total Tagihan     : Rp " + this.nominal);
    }
}
