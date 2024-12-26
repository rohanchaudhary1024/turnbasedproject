import java.util.Scanner;
import java.util.Random;

public class Battle {
    private Player p,o;


    public Battle(Player player, Player opponent) {
        p = player;
        o = opponent;
    }

    public boolean commenceBattle() {
        boolean gamePlaying = true;
        // Flavor Text for introduction
        System.out.println("You step into the ring and face your opponent.\n\nYour opponent is...\n" + o.getName() + "\nYour opponent's style is: " + o.getStyle().getName());
        System.out.println(o.getHP() + " HP");
        System.out.println(o.getAP() + " AP");
        System.out.println();
        

        if (p.getOrder() > o.getOrder()) { // Determines who is faster
            System.out.println("Faster than your opponent, you have the advantage.");
            while (gamePlaying) {
                System.out.println();
                playerAttack();
                if (p.getHP() <= 0) {
                    System.out.println("You have been defeated");
                    return false;
                }
                else if (o.getHP() <= 0) {
                    System.out.println(o.getName() + " has been defeated");
                    return true;
                }
                playerReact();
                if (p.getHP() <= 0) {
                    System.out.println("You have been defeated");
                    return false;
                }
                else if (o.getHP() <= 0) {
                    System.out.println(o.getName() + " has been defeated");
                    return true;
                }
                p.regenAP();
                p.regenHP();
                o.regenAP();
                o.regenHP();
            }
        }
        else { //When you are slower
            System.out.println("Your opponent is faster than you, you are at a disadvantage.");
            while (gamePlaying) {
                System.out.println();
                playerReact();
                if (p.getHP() <= 0) {
                    System.out.println("You have been defeated");
                    return false;
                }
                else if (o.getHP() <= 0) {
                    System.out.println(o.getName() + " has been defeated");
                    return true;
                }
                playerAttack();
                if (p.getHP() <= 0) {
                    System.out.println("You have been defeated");
                    return false;
                }
                else if (o.getHP() <= 0) {
                    System.out.println(o.getName() + " has been defeated");
                    return true;
                }
                p.regenAP();
                p.regenHP();
                o.regenAP();
                o.regenHP();
            }
        }
        return(false);
    }
    
    
    

    public void playerAttack() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int numAttacks = p.getNumMoves();
        Attack[] atkSequence = new Attack[numAttacks];
        if (p.getAP() > 0){
            System.out.println("These are your attacks:");
            for (int i = 1; i <= p.getAttacks().size(); i++) { //Lists your attacks
                System.out.println(i + ": " + p.getAttacks().get(i-1));
            }
            System.out.println();
            System.out.println("What attack sequence would you like to do? (You have " + numAttacks + " moves)");
            boolean validAP = false;
            while (!validAP) { //Don't use more ap than you have
                int totalAPCost = 0;
                for (int i = 0; i < numAttacks; i++) {
                    boolean invalidScan = true;
                    int atkNumber;
                    while (invalidScan) {
                        atkNumber = scan.nextInt();
                        if ( atkNumber > 0 && atkNumber <= p.getAttacks().size() ) {
                            atkSequence[i] = p.getAttacks().get(atkNumber-1);
                            totalAPCost += atkSequence[i].getCost();
                            invalidScan = false;
                        }
                        else {
                            System.out.println("Invalid Number");
                        }
                        
                    }
                }
                if (totalAPCost > p.getAP()) {
                    System.out.println("You don't have enough AP to do that.");
                }
                else {
                    validAP = true;
                }
            }
            if (o.getAP() > 0) {
                for (int i = 0; i < numAttacks; i++) {
                    Reaction oReact = o.getReactions().get(rand.nextInt(o.getReactions().size()));
                    int curOpponentHP = o.getHP();
                    if (p.throwAttack(atkSequence[i], o, oReact)) {
                        System.out.println(o.getName() + " failed to use " + oReact.getName() + " against your " + atkSequence[i].getName());
                        int oDamageTaken = curOpponentHP - o.getHP();
                        System.out.println(o.getName() + " took " + oDamageTaken + " damage.");
                        System.out.println();
                    }
                    else {
                        System.out.println(o.getName() + " succeeded in using " + oReact.getName() + " against your "  + atkSequence[i].getName() );
                        int oDamageTaken = curOpponentHP - o.getHP();
                        System.out.println(o.getName() + " took " + oDamageTaken + " damage.");
                        System.out.println();
                    }
                }
            }
            else {
                for (int i = 0; i < numAttacks; i++) {
                    int curOpponentHP = o.getHP();
                    p.throwAttack(atkSequence[i], o , null);
                    System.out.println(o.getName() + " just took the hit from your " + atkSequence[i].getName());
                    int oDamageTaken = curOpponentHP - o.getHP();
                    System.out.println(o.getName() + " took " + oDamageTaken + " damage.");
                    System.out.println();
                }
            }   
            System.out.println(o.getName() + " has " + o.getHP() + " HP and " + o.getAP() + " AP left.");
            System.out.println( "You have " + p.getHP() + " HP and " + p.getAP() + " AP left.");
            System.out.println();
        }

        else{
            System.out.println("In terms of AP you have no AP. Your turn has ended.");
        }
    }

    public void playerReact() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int numAttacks = o.getNumMoves();
        Attack[] oAtkSequence = new Attack[numAttacks];
        Reaction[] reactSequence = new Reaction[numAttacks];
        if(o.getAP() > 0){ //Opponent attacks
            System.out.println(o.getName() + " is attempting to do:");
            for (int i = 0; i < numAttacks; i++) {
                oAtkSequence[i] = o.getAttacks().get(rand.nextInt(o.getAttacks().size()));
                System.out.println(oAtkSequence[i].getName());
            }
            System.out.println();
            if (p.getAP() > 0) {
                System.out.println("These are your reactions:"); 
                for (int i = 1; i <= p.getReactions().size(); i++) { //Lists your reactions
                    System.out.println(i + ": " + p.getReactions().get(i-1));
                }
                System.out.println(p.getReactions().size() + 1 + ": Nothing"); //option to do nothing
                System.out.println();
                System.out.println("How do you want to react?");
                boolean validAP = false;
                while (!validAP) {//Don't use more ap than you have
                    int totalAPCost = 0;
                    for (int i = 0; i < numAttacks; i++) {
                        boolean invalidScan = true;
                        int reactNumber;
                        while (invalidScan) {
                            reactNumber = scan.nextInt();
                            if ( reactNumber > 0 && reactNumber <= p.getReactions().size() ) {
                                reactSequence[i] = p.getReactions().get(reactNumber-1);
                                totalAPCost += reactSequence[i].getCost();
                                invalidScan = false;
                            }
                            else if (reactNumber == p.getReactions().size() + 1) {//for doing nothing
                                reactSequence[i] = null;
                                invalidScan = false;
                            }
                            else {
                                System.out.println("Invalid Number");
                            }
                        }
                    }
                    if (totalAPCost > p.getAP()) {
                        System.out.println("You don't have enough AP to do that.");
                    }
                    else {
                        validAP = true;
                    }

                }
                for (int i = 0; i < numAttacks; i++) {
                    int curHP = p.getHP();//used to find how much damage is taken
                    if (o.throwAttack(oAtkSequence[i], p, reactSequence[i])) {
                        if (reactSequence[i] == null)  {//null makes the program die
                            System.out.println("You got hit by " + oAtkSequence[i].getName());
                        }
                        else {
                            System.out.println("You failed in using " + reactSequence[i].getName() + " against " + o.getName() + "'s " + oAtkSequence[i].getName());
                        }
                        int damageTaken = curHP - p.getHP();
                        System.out.println("You took " + damageTaken + " damage.");
                        System.out.println();
                    }
                    else {
                        if (reactSequence[i] == null)  {//null makes the program die
                            System.out.println("Somehow, your opponent missed you while using " + oAtkSequence[i].getName());
                        }
                        else {
                            System.out.println("You succeeded in using " + reactSequence[i].getName() + " against " + o.getName() + "'s " + oAtkSequence[i].getName());
                        }
                        int damageTaken = curHP - p.getHP();
                        System.out.println("You took " + damageTaken + " damage.");
                        System.out.println();
                    }
                }
                System.out.println(o.getName() + " has " + o.getHP() + " HP and " + o.getAP() + " AP left.");
                System.out.println( "You have " + p.getHP() + " HP and " + p.getAP() + " AP left.");
                System.out.println();
            }
            else {
                System.out.println("You have no AP, you can't react.");
                int curHP = p.getHP();
                for (int i = 0; i < numAttacks; i++) {
                    o.throwAttack(oAtkSequence[i], p, null);
                    int damageTaken = curHP - p.getHP();
                    System.out.println("You took " + damageTaken + " damage.");
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("Your opponent has no AP. Your opponent's turn has ended.");
        }
    }


}
