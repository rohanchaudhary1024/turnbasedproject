public class Roster {
    private Player[] opponents = new Player[9];
    private int num = 0;
    public Roster() {
        Style boxing = new Style("Boxing");
        int[] bS = {3,3,5,2,1,7};
        opponents[0] = new Player("John John",bS, boxing);
        Style taek = new Style("Taekwondo");
        int[] tS = {5,5,2,5,5,2};
        opponents[1] = new Player("Kim Park Lee Choi Chung",tS, taek);
        Style muay = new Style("Muay Thai");
        int[] mS = {10,10,1,1,1,1};
        opponents[2] = new Player("John Ironshins",mS, muay);
        Style kungfu = new Style("Kung Fu");
        int[] kS = {5,5,5,5,5,5};
        opponents[3] = new Player("Master Oogway",kS, kungfu);
        Style karate = new Style("Karate");
        int[] kaS = {1,1,1,1,9 ,9 };
        opponents[4] = new Player("Mr. Kid",kaS, karate);
        Style aikido = new Style("Aikido");
        int[] aS = {1,1,1,1,9 ,9 };
        opponents[5] = new Player("Steven Seagal",aS, aikido);
        Style jiujitsu = new Style("Jiu Jitsu");
        int[] jS = {10, 10, 10, -1, -1, -1};
        opponents[6] = new Player("Bob",jS, jiujitsu);
        Style judo = new Style("Judo");
        int[] juS = {10, 10, 10, -5, -5, -5};
        opponents[7] = new Player("Kogoro Mouri",juS, judo);
        Style drag = new Style("Драконая система");
        int[] dS = {10, 10, 5, 10, 10, 10};
        opponents[8] = new Player("ULTIMATE BOSS OF ALL TIME: Chad Mcwomannnn",dS, drag);

    }

    public Player getNextOpponent() {
        Player ret = opponents[num];
        num++;
        return(ret);
    }
}