public class Main {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer("Aldo", 8500000.0);

        System.out.println("Nama Karyawan : " + programmer1.nama);
        System.out.println("Total Gaji    : Rp " + programmer1.hitungGaji());
    }
}