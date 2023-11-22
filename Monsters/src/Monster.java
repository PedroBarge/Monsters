abstract class Monster {
    int damage;
    int health;
    String name;

    abstract int attack();

    abstract void takeDamage(int damageRecive);

    abstract String getName ();
}
