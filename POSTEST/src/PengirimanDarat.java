class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    // Mewarisi LayananPengiriman dan hanya mengimplementasikan LacakKargo
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh); // Panggil constructor induk
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir"; // Nilai default status
    }

    // Override dari Abstract Class LayananPengiriman
    @Override
    public double hitungOngkosKirim() {
        double ongkirDasar = (this.beratBarang * 5000) + (this.jarakTempuh * 2000);
        // Cek jika truk Tronton (abaikan huruf besar/kecil)
        if (this.jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkirDasar += 150000;
        }
        return ongkirDasar;
    }

    // Override dari Interface LacakKargo
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return this.statusSaatIni;
    }
}