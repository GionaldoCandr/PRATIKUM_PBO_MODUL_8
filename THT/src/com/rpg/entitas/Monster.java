package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() {
        return this.baseDamage;
    }

    @Override
    public void bertahan() {
        // Monster tidak mengurangi damage, tapi memulihkan sedikit HP
        this.hp += 15;
        System.out.println(this.nama + " meraung dan memulihkan 15 HP!");
    }

    @Override
    public void gunakanItem() {
        System.out.println(this.nama + " memakan sisa-sisa pertarungan!");
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("--- STATUS MONSTER ---");
        System.out.println("Nama  : " + this.nama + " [" + this.jenisMonster + "]");
        System.out.println("HP    : " + this.hp);
    }
}