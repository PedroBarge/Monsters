import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    //----------------------------------
    static ArrayList<Monster> listOfMonsters1 = new ArrayList<>();
    static ArrayList<Monster> listOfMonsters2 = new ArrayList<>();

    public void startBattle(String nameP1, String nameP2) {
        System.out.println("Battle");
        while (!listOfMonsters1.isEmpty() && !listOfMonsters2.isEmpty()) {
            //Escolhe um número aleatorio tendo em conta o tamanho do array
            int valueRandomFromArray1 = random.nextInt(listOfMonsters1.size());
            int valueRandomFromArray2 = random.nextInt(listOfMonsters2.size());
            Monster monsterFrom1 = listOfMonsters1.get(valueRandomFromArray1);
            Monster monsterFrom2 = listOfMonsters2.get(valueRandomFromArray2);

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
                listOfMonsters2.remove(valueRandomFromArray2);
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
                listOfMonsters1.remove(valueRandomFromArray1);
            }
        }
        if (listOfMonsters1.isEmpty()) {
            System.out.println(nameP2 + " WINS");
        } else System.out.println(nameP1 + " WINS");
    }
}
