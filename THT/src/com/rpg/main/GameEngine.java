package com.rpg.main;
import com.rpg.entitas.Pahlawan;
import com.rpg.entitas.Monster;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("DUNGEON SURVIVAL ARENA RPG");
        
        System.out.print("Masukkan nama Pahlawan Anda: ");
        String namaPemain = input.nextLine();

        // Instansiasi Pahlawan
        Pahlawan hero = new Pahlawan(namaPemain, 150, 15, 50, 2);

        // Array yang berisi 3 objek Monster berbeda
        Monster[] daftarMonster = new Monster[3];
        daftarMonster [0]= new Monster("Goblin Kroco", 40, 10, "Common");
        daftarMonster[1] = new Monster("Orc Petarung", 80, 20, "Elite");
        daftarMonster[2] = new Monster("Naga Purba", 150, 35, "Boss");

        // Perulangan Bersarang (Nested Loop)
        for (int i = 0; i < daftarMonster.length; i++) {
            Monster musuh = daftarMonster[i];
            System.out.println("\n>>> PERINGATAN: " + musuh.getNama() + " menghadang jalan Anda! <<<");

            // Battle Loop: Berjalan selama keduanya masih hidup
            while (hero.getHp() > 0 && musuh.getHp() > 0) {
                System.out.println("\n-----------------------------------------");
                hero.tampilkanStatus();
                musuh.tampilkanStatus();
                System.out.println("-----------------------------------------");
                
                System.out.println("Giliran Anda! Pilih aksi:");
                System.out.println("1. Serang Biasa");
                System.out.println("2. Gunakan Skill (Cost: 20 Mana)");
                System.out.println("3. Bertahan & Heal");
                System.out.print("Pilihan > ");
                int pilihan = input.nextInt();

                int damageDiberikan = 0;

                // Switch-case opsi pemain
                switch (pilihan) {
                    case 1:
                        damageDiberikan = hero.serang();
                        System.out.println("\n" + hero.getNama() + " menebas dengan " + damageDiberikan + " damage!");
                        musuh.terimaDamage(damageDiberikan);
                        break;
                    case 2:
                        damageDiberikan = hero.serang("Excalibur Slash", 20); // Overloading
                        if (damageDiberikan > 0) {
                            System.out.println("Menghasilkan " + damageDiberikan + " damage kritis!");
                            musuh.terimaDamage(damageDiberikan);
                        }
                        break;
                    case 3:
                        hero.bertahan();
                        hero.gunakanItem();
                        break;
                    default:
                        System.out.println("\nPilihan tidak valid! Anda kehilangan momen untuk menyerang.");
                        break;
                }

                // Giliran serangan Monster (jika monster masih hidup)
                if (musuh.getHp() > 0) {
                    System.out.println("\n-- Giliran Musuh --");
                    // Monster memililki sedikit logika agar tidak selalu menyerang
                    if (musuh.getHp() < 20 && Math.random() > 0.5) {
                        musuh.bertahan();
                    } else {
                        int damageMonster = musuh.serang();
                        hero.terimaDamage(damageMonster);
                        System.out.println(musuh.getNama() + " menyerang balik dan memberikan " + damageMonster + " damage dasar!");
                    }
                } else {
                    System.out.println("\n>>> " + musuh.getNama() + " BERHASIL DIKALAHKAN! <<<");
                }
            }

            // Jika pahlawan mati di tengah loop for, keluar dari iterasi
            if (hero.getHp() <= 0) {
                break; 
            }
        }

        // Pengecekan If-Else Final Kondisi
        if (hero.getHp() > 0) {
            System.out.println("SELAMAT! " + hero.getNama() + " berhasil menamatkan Dungeon!");
        } else {
            System.out.println("GAME OVER! " + hero.getNama() + " gugur dalam pertempuran... ><");
        }

        input.close();
    }
}