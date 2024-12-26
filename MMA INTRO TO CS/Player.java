import java.util.ArrayList;

public class Player {
    private String name; // Name
    private int[] hp = new int[3]; // HP, Current HP, HP Regeneration.
    private int[] ap = new int[3]; // AP, Current AP, AP Regeneration
    private double blockMod;
    private double dodgeMod;
    private double attackMod;
    private double accuracyMod;
    private int order;
    private int numMoves;
    private ArrayList<Attack> attackList = new ArrayList<Attack>(4) ; //inital capacity not sure 
    private ArrayList<Reaction> reactionList = new ArrayList<Reaction>(3);
    private Attack sAttack;
    private Reaction sReaction;
    private Style style;
    private int[] stats;


    public Player(String n, int[] s, Style istyle) {
        name = n;
        // Setting of HP and AP
        style = istyle;
        stats = s;
        hp[0] = 100 + (10 * (s[0]-5)); // Determines Max HP off Vigor
        hp[1] = hp[0]; // Sets Current HP to Max HP
        hp[2] = (int)(5 * (1 + (0.1 * (s[1]-5)))); // Sets HP Regeneration off Constitution
        ap[0] = 50 + (5 * (s[2]-5)); // Determines Max AP off Endurance
        ap[1] = ap[0]; // Sets Current AP to Max AP
        ap[2] = (int)(3 * (1 + (0.1 * (s[2]-5)))); // Sets HP Regeneration off Constitution

        // Setting of Block, Attack, Accuracy, & Dodge Modifiers
        blockMod = (1 + (0.1 * (s[0]-5)));
        dodgeMod = (1 + (0.1 * (s[4]-5)));
        attackMod = (1 + (0.1 * (s[5]-5)));
        accuracyMod = (1 + (0.1 * (s[3]-5)));

        // Setting of Order and numMoves
        order = s[4];
        if (s[4] < 4) {
            numMoves = 1;
        }
        else if (s[4] > 6) {
            numMoves = 3;
        }
        else {
            numMoves = 2;
        }

        // Setting of Moves based off style
        Attack[] styleAttacks = style.getAttacks();
        Reaction[] styleReactions = style.getReactions();

        for (int i = 0; i < 4; i++) {
            attackList.add(styleAttacks[i]);
        }
        sAttack = styleAttacks[4];
        for (int i = 0; i < 3; i++) {
            reactionList.add(styleReactions[i]);
        }
        sReaction = styleReactions[3];

    }
    // Gets Name of Player.
    public String getName() {
        return(name);
    }
    // Methods that affect HP - Get, Set, Regenerate.
    public void regenHP() {
        hp[1] += hp[2];
    }
    public void setHP(int newHP) {
        hp[1] = newHP;
    }
    public int getHP() {
        return(hp[1]);
    }

    // Methods that affect AP - Get, Set, Regenerate.
    public void regenAP() {
        ap[1] += ap[2];
    }
    public void setAP(int newAP) {
        ap[1] = newAP;
    }
    public int getAP() {
        return(ap[1]);
    }

    // Returns Modifiers from Stats. Used for calculations
    public double getAcc() {
        return (accuracyMod);
    }
    public double getDod() {
        return (dodgeMod);
    }
    public double getStr() {
        return (attackMod);
    }
    public double getRed() {
        return (blockMod);
    }

    // Gets Misc. Stats
    public int getOrder() {
        return(order);
    }
    
    public int getNumMoves() {
        return(numMoves);
    }

    public Style getStyle() {
        return style;
    }

    public ArrayList<Attack> getAttacks() {
        return(attackList);
    }

    public ArrayList<Reaction> getReactions() {
        return(reactionList);
    }

    // Throws an attack on another player, and calculates damage based on the attack, reaction, and stats of both, editing HP.
    public boolean throwAttack(Attack attack, Player target, Reaction reaction) {
        if (reaction == null) {
            double chanceHit = (attack.getAccuracy() * accuracyMod);
            ap[1] = (ap[1] - attack.getCost());
            double randNum = Math.random();
            if (randNum <= chanceHit) {
                int damage = (int)((attack.getDamage() * attackMod));
                target.setHP(target.getHP() - damage);
                return(true);
            }
            return(false);
        }

        double chanceHit = (attack.getAccuracy() * accuracyMod) - (reaction.getDodgeChance() * target.getDod());
        double randNum = Math.random();

        // Handles AP Cost
        ap[1] = (ap[1] - attack.getCost());
        target.setAP(target.getAP() - reaction.getCost());

        if (randNum <= chanceHit) {
            int damage = (int)((attack.getDamage() * attackMod) * (reaction.getDamageMitigation() * target.getRed()));
            target.setHP(target.getHP() - damage);
            return(true);
        }
        return(false);
    }

    // Unlocks special attacks.
    public void unlockSpecA() {
        attackList.add(sAttack);
    }

    public void  unlockSpecR() {
        reactionList.add(sReaction);
    }

    public String toString(){ //fix later
        String string = "";
        string = string + name + "\n" + style.getName() + "\n";
        
        string = string + stats[0] + " VIGOR, ";
        string = string + stats[1] + " CONSTITUTION, ";
        string = string + stats[2] + " ENDURANCE, ";
        string = string + stats[3] + " PERCEPTION, ";
        string = string + stats[4] + " SPEED, ";
        string = string + stats[5] + " STRENGTH. \n";

        string = string + "HP - "+ hp[0] + "\n";
        string = string + "AP - " + ap[0] + "\n";

        string = " " + "\n" + string + "----------Attacks-----------\n";
        for (Attack item: attackList){
            string = string + item.getName() +" (" + item.getCost()+ " AP)\n";
        }

        string = " " + "\n" + string + "------------Reactions------------\n";
        for (Reaction item: reactionList){
            string = string + item.getName() +" (" + item.getCost()+ " AP)\n";
        }



        return string;
    }

    public void givePerkOne() {
        ap[2] = (int)(ap[2] * 1.5);
    }

    public void givePerkTwo() {
        dodgeMod = dodgeMod + 0.4;
    }

    public void givePerkThree() {
        blockMod = blockMod + 0.4;
    }

    public void givePerkFour() {
        attackMod = attackMod + 0.4;
    }

    public void givePerkFive() {
        accuracyMod = accuracyMod + 0.4;
    }

    public void givePerkSix() {
        numMoves += 1;
    }

}