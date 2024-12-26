import java.util.Scanner;
import java.util.*;
public class FinalProject {
    public FinalProject(){
        //hello there
    }

    public static void choosePerk(Player player) {
        Random rand = new Random();
        int randNum = rand.nextInt(6) + 1;
        System.out.println("You got..");
        if (randNum == 1) {
            player.givePerkOne();
            System.out.println("UNYIELDING SPIRIT - AP Regeneration is increased by 50%. ");
        }
        else if (randNum == 2) {
            player.givePerkTwo();
            System.out.println("FLOAT LIKE A BUTTERFLY - All moves have a higher dodge chance.");
        }
        else if (randNum == 3) {
            player.givePerkThree();
            System.out.println("ADAMANTIUM SKELETON - All reactions significantly reduce damage taken");
        }
        else if (randNum == 4) {
            player.givePerkFour();
            System.out.println("HONED FISTS - You hit harder, dealing more damage on every attack.");
        }
        else if (randNum == 5) {
            player.givePerkFive();
            System.out.println("HEIGHTENED SENSES - It is easier to hit enemies with your attacks");
        }
        else if (randNum == 6) {
            player.givePerkSix();
            System.out.println("FASTER THAN A BULLET - You have one more move per turn.");
        }

    }
    /*
     * Creates Character
     */

    public static boolean playGame(boolean isComplete) {
        Roster roster = new Roster();
        Scanner scan = new Scanner(System.in);
        System.out.println("Create your character:");

        // Explains Stats
        System.out.println("Select your stats. Each affects gameplay in a different way, and can be set from 1-10. There are six stats that all start at 1, and you have 30 points to upgrade them. Here is what they do:");
        System.out.println("VIGOR - Affects how many hits you can take.");
        System.out.println("CONSTITUTION - Affects how easy it is for you to get back on your feet.");
        System.out.println("ENDURANCE - Affects how many attacks you can throw out without getting tired.");
        System.out.println("PERCEPTION - Determines how accurate your moves are.");
        System.out.println("SPEED - Affects speed of your attacks, and effectiveness of your dodges.");
        System.out.println("STRENGTH - How much power your attacks have.");
        System.out.println();

        // Handles Stat Input - FIX LATER PLEASE
        int[] stats = new int[6];
        int temp;
        int totalCount = 0;
        boolean invalid = true;
        while (invalid == true) {
            if (invalid == true) {
                System.out.println("Please input in the format of six space seperated integers summing up to 36, with a max of 10 and min of 1 for each:");
            }
            totalCount = 0;
            invalid = false;
            for (int i = 0; i < 6; i++) {
                temp = scan.nextInt();
                if (temp > 10 || temp < 1) {
                    invalid = true;
                }
                totalCount += temp;
                stats[i] = temp;
            }
            if (totalCount > 36 || totalCount < 36) {
                invalid = true;
            }
            scan.nextLine();
        }

        // Handles Style Input
        System.out.println();;
        System.out.println("CHOOSE YOUR STYLE: \nBoxing - A punch focused style - using different types of slips. \nTaekwondo - A style that utilizes multiple styles of kicks, with guards that deflect attacks away from the user. \nMuay Thai - A versatile style that uses a mix of punches, kicks, elbows, and knees, with a focus on low kicks and high damage.");
        System.out.println("Kung Fu - An hard-hitting style based on animal powers, learned from Master Oogway.");
        System.out.println("Karate - A japanese art of linear motion, with kicking and punching.");
        System.out.println("Aikido - The art of redirection of energy.");
        System.out.println("Jiu Jitsu - Uses throws, chokeholds and strikes.");
        System.out.println("Judo - Uses throws , pins, joint locks.");
        if (isComplete == true) {
            System.out.println("Драконая система - The pinnacle of fighting prowress");
        }
        System.out.println("Input which style you want:"); // add if statement for UTLIMATE STYLE here
        Style style = new Style(scan.nextLine());
        /* Tests Style class
        for (Attack item : style.getAttacks()){
            System.out.println(item.getName());
        }
     */
        System.out.println();


        
        // Create Player Object
        System.out.println("Enter your character's name:");
        String name = scan.nextLine();
        Player player = new Player(name, stats, style);

        System.out.println();
        System.err.println(player);
        System.out.println();

        Player opponent;
        Battle battle;
        for (int i = 0; i < 9; i++) { // runs battle loop
            opponent = roster.getNextOpponent();
            battle = new Battle(player,opponent);
            boolean win = battle.commenceBattle();
            if (win == false) {
                System.out.println("You have been defeated in battle. 👍 👍 ");
                return(false);
            }
            if (i == 2) {
                player.unlockSpecR();
            }
            else if (i == 5) {
                player.unlockSpecA();
            }
            else if(i == 8) {
                System.out.println("You win!  👎 👎");
                return(true);
            }
            else {
                choosePerk(player);
            }

        }
        
        return (false);

        

    }
    public static void main(String[] args){
        boolean isComplete = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("YOU ARE FORMALLY INVITED TO COMPETE IN THE TOURNAMENT OF ELEMENTS!");
        System.out.println();
        System.out.println("Do you want a tutorial? (y/n)");
        String ans = scan.nextLine();
        if (ans.equals("y")) {
            System.out.println("This is a turn based text fighter, where you battle against different opponents. Each turn, you can do attacks at the cost of your AP (action points), with the goal of reducing your opponent’s HP (health points) to 0. When your opponent attacks you, you can block or dodge to take less damage, but be careful! If you run out of AP, your turn automatically ends if you are attacking.\nDefeat your opponents and claim your rightful position as THE GREATEST FIGHTER IN THE WORLD!");
            System.out.println();
        }
        boolean gameisPlaying = true;
        boolean temp;
        while (gameisPlaying) {
            temp = playGame(isComplete);
            isComplete = temp;
            System.out.println("Would you like to play again? (y/n)");
            ans = scan.nextLine();
            if (!(ans.equals("y"))) {
                System.out.println("womp womp");
                gameisPlaying = false;
            }
        }

    }

}
