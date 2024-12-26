public class Reaction {
    private String name;
    private double dodgeChance;
    private double damageMitigation;
    private int cost;

    public Reaction(String reactName, double dodge, double dmgMitigation, int reactCost) {
        name = reactName;
        dodgeChance = dodge;
        damageMitigation = dmgMitigation;
        cost = reactCost;
    }
    
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public double getDamageMitigation() {
        return damageMitigation;
    }

    public String toString(){

        return name + " (" + cost + " AP)";
    }

}
