class Attack {
    private String name;
    private int damage;
    private double accuracy;
    private int cost;

    public Attack(String atkName, int dmg, double acc, int atkCost) {
        name = atkName;
        damage = dmg;
        accuracy = acc;
        cost = atkCost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getCost() {
        return cost;
    }

    public String toString(){

        return name + " (" + cost + " AP - "+ damage + " DMG)";
    }
}