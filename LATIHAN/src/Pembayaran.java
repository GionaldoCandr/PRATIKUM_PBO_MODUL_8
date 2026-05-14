abstract class Pembayaran {
    // Hak akses protected agar bisa diturunkan ke subclass
    protected String namaPembayar;
    protected double nominal;

    // Constructor 
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    // Concrete method
    public void tampilkanDetail() {
        System.out.println("Nama Pembayar : " + this.namaPembayar);
        System.out.println("Nominal Awal  : Rp " + this.nominal);
    }

    // Abstract method
    public abstract void prosesPembayaran();
}

