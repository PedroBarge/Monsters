import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonsterGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    //----------------------------------
    static ArrayList<Monster> listOfMonsters1 = new ArrayList<>();
    static ArrayList<Monster> listOfMonsters2 = new ArrayList<>();
    //----------------------------------
    static int numMaxMonsters = 5;
    //----------------------------------
    static Werewolf werewolf = new Werewolf();
    static Vampire vampire = new Vampire();
    static Mummy mummy = new Mummy();

    public static void main(String[] args) {

        vampire.takeDamage(werewolf.attack());
        vampire.takeDamage(mummy.attack());
        System.out.println(vampire.health);
        //----------------------------------
        soutRules();
        //----------------------------------
        System.out.print("Player one name: ");
        String nameP1 = scanner.next();

        System.out.print("Player two name: ");
        String nameP2 = scanner.next();
        //----------------------------------
        maxNumMonstersFromUsers(nameP1, nameP2);
        //----------------------------------
        //Adicionar mosntros ao array de cada player
        setMonstersToPlayers(nameP1, nameP2);
        //----------------------------------
        //Battle
        Battle battle = new Battle();
        battle.startBattle(nameP1,nameP2);
    }

    public static void soutRules() {
        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t\tRULES");
        System.out.println("\t\t\t\t\t\tThis game is for two players\n");
        System.out.println("""
                \tWhen the game starts, each player will be asked to\s
                \tpick a number of monsters to play with. Both players have to\s
                \tpick the same number of monsters.""");
        System.out.println();
        System.out.println("If both player choose \"0\" they will receive a default number of mosnters to play with");
        System.out.println("+------------------------------------------------------------------------------------+");
    }

    public static void maxNumMonstersFromUsers(String nameP1, String nameP2) {
        int maxMonsterFrom1;
        int maxMonsterFrom2;
        do {
            System.out.print(nameP1 + " please choose a number of monsters: ");
            maxMonsterFrom1 = scanner.nextInt();
            System.out.print(nameP2 + " please choose a number of monsters: ");
            maxMonsterFrom2 = scanner.nextInt();
        } while (maxMonsterFrom1 != maxMonsterFrom2);

        if (maxMonsterFrom1 != 0) {
            numMaxMonsters = maxMonsterFrom1;
        }
    }

    public static void setMonstersToPlayers(String nameP1, String nameP2) {
        for (int i = 0; i < numMaxMonsters; i++) {
            int monsterRandom = random.nextInt(3) + 1;
            if (monsterRandom == 1) {
                listOfMonsters1.add(i, werewolf);
                listOfMonsters2.add(i, mummy);
            }
            if (monsterRandom == 2) {
                listOfMonsters1.add(i, vampire);
                listOfMonsters2.add(i, werewolf);
            }
            if (monsterRandom == 3) {
                listOfMonsters1.add(i, mummy);
                listOfMonsters2.add(i, vampire);
            }
        }

        System.out.println("List of monsters " + nameP1);
        for (int i = 0; i < listOfMonsters1.size(); i++) {
            System.out.println(i + "-" + listOfMonsters1.get(i).getName());
        }

        System.out.println("List of monsters " + nameP2);
        for (int i = 0; i < listOfMonsters2.size(); i++) {
            System.out.println(i + "-" + listOfMonsters2.get(i).getName());
        }
    }
}