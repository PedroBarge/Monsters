import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    static Random random = new Random();
    //----------------------------------

    public void startBattle(String nameP1, String nameP2) {
        System.out.println("Battle");

        while (!MonsterGame.listOfMonsters1.isEmpty() && !MonsterGame.listOfMonsters2.isEmpty()) {
            //Escolhe um número aleatorio tendo em conta o tamanho do array
            int valueRandomFromArray1 = random.nextInt(MonsterGame.listOfMonsters1.size());
            int valueRandomFromArray2 = random.nextInt(MonsterGame.listOfMonsters2.size());
            Monster monsterFrom1 = MonsterGame.listOfMonsters1.get(valueRandomFromArray1);
            Monster monsterFrom2 = MonsterGame.listOfMonsters2.get(valueRandomFromArray2);

            //Player 1 ataca player 2
            System.out.println();
            System.out.println("Player 1 attack Player 2");
            System.out.println(nameP1 + " Monster: " + monsterFrom1.getName() + " vs "
                    + nameP2 + " Monster: " + monsterFrom2.getName());
            if (monsterFrom2.health > 0) {
                monsterFrom2.takeDamage(monsterFrom1.attack());
                System.out.println(monsterFrom2.getName() + " HP: " + monsterFrom2.health);
            } else {
                System.out.println(monsterFrom2.getName() + " is dead...");
                MonsterGame.listOfMonsters2.remove(valueRandomFromArray2);
            }

            //Player 2 ataca player 1
            System.out.println();
            System.out.println("Player 2 attack Player 1");
            System.out.println(nameP2 + " Monster: " + monsterFrom2.getName() + " vs "
                    + nameP1 + " Monster: " + monsterFrom1.getName());
            if (monsterFrom1.health > 0) {
                monsterFrom1.takeDamage(monsterFrom2.attack());
                System.out.println(monsterFrom1.getName() + " HP: " + monsterFrom1.health);
            } else {
                System.out.println(monsterFrom1.getName() + " is dead...");
                MonsterGame.listOfMonsters1.remove(valueRandomFromArray1);
            }
        }
        if (MonsterGame.listOfMonsters1.isEmpty()) {
            System.out.println(nameP2 + " WINS");
        } else System.out.println(nameP1 + " WINS");
    }
}
