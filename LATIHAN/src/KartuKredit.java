class KartuKredit extends Pembayaran implements Keamanan {
    // Atribut spesifik (Encapsulation)
    private String nomorKartu;

    // Constructor
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal); // Memanggil constructor induk
        this.nomorKartu = nomorKartu;
    }

    // Override metode dari Interface Keamanan
    @Override
    public boolean autentikasi() {
        System.out.println("[SISTEM] Autentikasi PIN berhasil untuk Kartu Kredit.");
        return true;
    }

    // Override metode dari Abstract Class Pembayaran
    @Override
    public void prosesPembayaran() {
        double biayaAdmin = this.nominal * 0.02; // 2% dari nominal
        double totalTagihan = this.nominal + biayaAdmin;
        
        System.out.println("Biaya Admin (2%)  : Rp " + biayaAdmin);
        System.out.println("Total Tagihan     : Rp " + totalTagihan);
    }
}