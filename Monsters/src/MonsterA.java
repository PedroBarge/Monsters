public interface MonsterA {
    int damage = 0;
    int health = 0;
    String name = null;

     int attack();

     void takeDamage(int damageRecive);

     default String getName(){
         System.out.println(name);
         return null;
     };
}
