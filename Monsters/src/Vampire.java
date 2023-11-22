public class Vampire extends Monster {
    double biteChance;
    int biteHeal;

    Vampire() {
        super.health = 100;
        super.damage = 10;
        this.biteChance = 0.3;
        this.biteHeal = 5;
    }

    @Override
    int attack() {
        if (Math.random() <= biteChance) {
            super.health += biteHeal;
            System.out.println("Vampire bites and heals!");
        }
        super.damage = 10;
        return super.damage;
    }

    @Override
    void takeDamage(int damageRecive) {
        health -= damageRecive;
    }

    @Override
    String getName() {
        return "Vampire";
    }

}
