public class Werewolf extends Monster {
    Werewolf() {
        super.health = 100;
        super.damage = 10;
    }

    @Override
    int attack() {
        return damage;
    }

    @Override
    void takeDamage(int damageRecive) {
        super.health -= damageRecive;
    }

    @Override
    String getName() {
        return "Werewolf";
    }
}
