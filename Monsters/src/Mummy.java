public class Mummy extends Monster {
    int consecutiveAttacks;
    int maxConsecutiveAttacks;

    Mummy() {
        super.health = 100;
        super.damage = 10;
        this.consecutiveAttacks = 0;
        this.maxConsecutiveAttacks = 2;
    }

    @Override
    int attack() {
        if (consecutiveAttacks < maxConsecutiveAttacks) {
            consecutiveAttacks++;
            return damage;
        } else {
            consecutiveAttacks = 0;
            this.health -= 5;
            System.out.println("Mummy failed attack!");
            return 0;
        }
    }

    @Override
    void takeDamage(int damageRecive) {
        health -= damageRecive;
    }

    @Override
    String getName() {
        return "Mummy";
    }
}
