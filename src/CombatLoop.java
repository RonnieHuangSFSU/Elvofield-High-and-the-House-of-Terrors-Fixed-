import java.util.Objects;
import java.util.Scanner;

class CombatLoop {
    public static String Player = DungeonExploration.Player, Ally = "Ally", Enemy1 = "Enemy", Enemy2 = "Enemy",
            Enemy3 = "Enemy", option;
    public static int PlayerHP = 20, PlayerMx = 20, PlayerAk = 4, PlayerMxAk = 4, PlayerDf = 1, PlayerMxDf = 1,
            Enemy1HP = 0, Enemy1Mx, Enemy1Ak, Enemy1MxDf, Enemy1Df, Enemy1Harmed, Run, Poison = 0,
            Condition = 0, Enemy2HP = 0, Enemy2Mx, Enemy2Ak, Enemy2MxDf, Enemy2Df, turn = 0, turn2 = 0, choice = 0,
            Enemy1Kindness = 0, Enemy3HP = 0, Enemy3Mx, Enemy3Ak, Enemy3MxDf, Enemy3Df, Potion = 0, Enemies = 1,
            AllyCondition = 0, AllyAk = 0, AllyDf = 0, Critical1 = 0, harmed, guard = 0;
    public static boolean TurnEnd;
    public static String Encounter(int Location){
        System.out.println();
        Enemy1HP = 0;
        Enemy2HP = 0;
        Enemy3HP = 0;
        Enemies = 1;
        double encounter = Math.random() * 10;
        switch (Location){
            case 1:
            case 11:
                System.out.println("-----------------------------");
                Enemy1 = "Ghost";
                System.out.println(Enemy1 + " shows up!");
                Enemy1HP = 10;
                Enemy1Mx = 10;
                Enemy1Ak = 0;
                Enemy1MxDf = 0;
                Enemy1Df = 0;
                Run = 1;
                break;
            case 5:
            case 13:
                System.out.println("-----------------------------");
                if (encounter > 6){
                    Enemy1 = "Skeleton";
                    System.out.println(Enemy1 + " blocks the way!");
                    Enemy1HP = 16;
                    Enemy1Mx = 16;
                    Enemy1Ak = 7;
                    Enemy1MxDf = 0;
                    Enemy1Df = 0;
                    Run = 2;
                }
                else if (encounter > 3){
                    Enemy1 = "Bat";
                    System.out.println(Enemy1 + " shows up!");
                    Enemy1HP = 20;
                    Enemy1Mx = 20;
                    Enemy1Ak = 7;
                    Enemy1MxDf = 1;
                    Enemy1Df = 1;
                    Run = 1;
                }
                else {
                    Enemy1 = "Fish Soldier";
                    System.out.println(Enemy1 + " appears!");
                    Enemy1HP = 15;
                    Enemy1Mx = 15;
                    Enemy1Ak = 9;
                    Enemy1MxDf = 2;
                    Enemy1Df = 2;
                    Run = 1;
                }
                break;
            case 6:
            case 14:
                System.out.println("-----------------------------");
                if (encounter > 5){
                    Enemy1 = "Skeleton";
                    Enemy1HP = 12;
                    Enemy1Mx = 12;
                    Enemy1Ak = 8;
                    Enemy1MxDf = 0;
                    Enemy1Df = 0;
                    Enemy2 = "Skeleton";
                    Enemy2HP = 12;
                    Enemy2Mx = 12;
                    Enemy2Ak = 9;
                    Enemy2MxDf = 0;
                    Enemy2Df = 0;
                    Run = 2;
                    Enemies = 2;
                    System.out.println("Two " + Enemy1 + "s block the way!");
                }
                else {
                    Enemy1 = "Cat";
                    System.out.println(Enemy1 + " sits confused!");
                    Enemy1HP = 19;
                    Enemy1Mx = 19;
                    Enemy1Ak = 5;
                    Enemy1MxDf = 2;
                    Enemy1Df = 2;
                    Critical1 = 1;
                    Run = 2;
                }
                break;
            case 7:
            case 15:
                System.out.println("-----------------------------");
                if (encounter >= 6){
                    Enemy1 = "Fish Soldier Captain";
                    System.out.println(Enemy1 + " appears!");
                    Enemy1HP = 30;
                    Enemy1Mx = 30;
                    Enemy1Ak = 6;
                    Enemy1MxDf = 4;
                    Enemy1Df = 4;
                    Run = 1;
                }
                else {
                    Enemy1 = "Lion";
                    System.out.println(Enemy1 + " stands in the way!");
                    Enemy1HP = 28;
                    Enemy1Mx = 28;
                    Enemy1Ak = 11;
                    Enemy1MxDf = 5;
                    Enemy1Df = 5;
                    Critical1 = 1;
                    Run = 3;
                }
                break;
            case 8:
            case 16:
                System.out.println("-----------------------------");
                if (encounter >= 7) {
                    Enemy1 = "Witch";
                    System.out.println(Enemy1 + " stands in the way!");
                    Enemy1HP = 25;
                    Enemy1Mx = 25;
                    Enemy1Ak = 8;
                    Enemy1MxDf = 9;
                    Enemy1Df = 9;
                    Run = 1;
                }
                else {
                    Enemy2 = "Cat";
                    System.out.println(Enemy2 + " sits confused!");
                    Enemy2HP = 26;
                    Enemy2Mx = 26;
                    Enemy2Ak = 13;
                    Enemy2MxDf = 2;
                    Enemy2Df = 2;
                    Run = 2;
                }
                break;
            case 9:
            case 17:
                System.out.println("-----------------------------");
                Enemy1 = "Mad Scientist";
                System.out.println(Enemy1 + " turns with a grin!");
                Enemy1HP = 30;
                Enemy1Mx = 30;
                Enemy1Ak = 13;
                Enemy1Df = 7;
                Enemy1MxDf = 7;
                break;
            default:
                System.out.print(DungeonExploration.Maze[DungeonExploration.Location_X]
                        [DungeonExploration.Location_Y]);
                Enemies = -1;
        }
        System.out.println();
        System.out.print(Battle());
        return"";
    }
    public static String Boss(){
        System.out.println();
        System.out.println("-----------------------------");
        Enemies = 1;
        Enemy1HP = 0;
        Enemy2HP = 0;
        Enemy3HP = 0;
        int Event = DungeonExploration.Event;
        Run = 3;
        switch (Event) {
            case 1:
                //Earthbound Beginnings reference :D
                System.out.println("Doll: !!!");
                System.out.println();
                Enemy1 = "Doll";
                System.out.println(Enemy1 + " flies in the sky!");
                Enemy1HP = 12;
                Enemy1Mx = 12;
                Enemy1Ak = 4;
                Enemy1MxDf = 0;
                Enemy1Df = 0;
                break;
            case 2:
                System.out.println("Vampire: Are you a brave individual, or a fool that doesn't know their place?");
                System.out.println();
                Enemy2 = "Vampire";
                System.out.println(Enemy2 + " appears!");
                Enemy2HP = 15;
                Enemy2Mx = 15;
                Enemy2Ak = 6;
                Enemy2MxDf = 1;
                Enemy2Df = 1;
                break;
            case 3:
                System.out.println("Spider Queen: Mhmhmhm, is that another treat I see?");
                System.out.println();
                Enemy3 = "Spider Queen";
                System.out.println(Enemy3 + " ambushes from above!");
                Enemy3HP = 27;
                Enemy3Mx = 27;
                Enemy3Ak = 9;
                Enemy3MxDf = 2;
                Enemy1Df = 2;
                System.out.println();
                System.out.println(Enemy3 + "'s turn!");
                System.out.println(Enemy3 + " called for help!");
                Enemy1 = "Spider";
                System.out.println(Enemy1 + " showed up!");
                Enemy1HP = 10;
                Enemy1Mx = 10;
                Enemy1Ak = 1;
                Enemy1MxDf = 0;
                Enemy1Df = 0;
                Enemies++;
                break;
            case 4:
                System.out.println("Siren: Oh my! What is a mere human like you doing in a place like this?" +
                        " Guards, help me dispose of this pest!");
                System.out.println();
                Enemy1 = "Fish Soldier";
                Enemy1HP = 15;
                Enemy1Mx = 15;
                Enemy1Ak = 9;
                Enemy1MxDf = 2;
                Enemy1Df = 2;
                Enemy2 = "Siren";
                System.out.println(Enemy2 + " and a bunch of fish soldiers show up!");
                Enemy2HP = 29;
                Enemy2Mx = 29;
                Enemy2Ak = 7;
                Enemy2MxDf = 4;
                Enemy2Df = 4;
                Enemy3 = "Fish Soldier";
                Enemy3HP = 15;
                Enemy3Mx = 15;
                Enemy3Ak = 8;
                Enemy3MxDf = 2;
                Enemy3Df = 2;
                Enemies = 3;
                break;
            case 5:
                Enemy3 = "Undead Warrior";
                System.out.println("Undead Warrior: I have searched far and wide for a worth opponent, surely " +
                        "you'll be able to finally end my search...");
                System.out.println();
                System.out.println(Enemy3 + " appears!");
                Enemy3HP = 33;
                Enemy3Mx = 33;
                Enemy3Ak = 10;
                Enemy3Df = 4;
                Enemy3MxDf = 4;
                break;
            case 6:
                Enemy1 = "Golem";
                System.out.println("Golem: You have done well so far, but your weak attacks won't penetrate my" +
                        " stone tough defense!");
                System.out.println();
                System.out.println(Enemy1 + " stands firm!");
                Enemy1HP = 41;
                Enemy1Mx = 41;
                Enemy1Ak = 16;
                Enemy1MxDf = PlayerMxAk;
                Enemy1Df = PlayerMxAk;
                break;
            case 7:
                Enemy1 = "Poltergeist of the Mansion";
                System.out.println("???: SO...YOU FINALLY FOUND ME, IT IS I, THE POLTERGEIST OF THE MANSION!");
                System.out.println();
                System.out.println("I feel is a big gust flying towards me, while chairs and tables are " +
                        "floating and flying on their own!");
                Enemy1HP = 50;
                Enemy1Mx = 50;
                Enemy1Ak = 11;
                Enemy1MxDf = 10;
                Enemy1Df = 10;
                break;
        }
        System.out.println();
        System.out.print(Battle());
        if (!Enemy1.equals("Poltergeist of the Mansion")) {
            System.out.print(LevelUp());
        }
        return"";
    }
    public static String Battle(){
        turn = 0;
        turn2 = 0;
        Enemy1Kindness = 0;
        Enemy1Harmed = 0;
        Condition = 0;
        AllyCondition = 0;
        while (Enemies > 0){
            if (Poison > 1){
                System.out.println(Player + " lost 1 health from poison!");
                Poison--;
                PlayerHP--;
                System.out.println();
            }
            else if (Poison == 1){
                System.out.println(Player + "'s poison has been cured!");
                Poison--;
                System.out.println();
            }
            TurnEnd = true;
            while (TurnEnd) {
                System.out.print(Player());
            }
            PlayerAk = PlayerMxAk;
            System.out.print(System());
            if (Enemies > 0) {
                if (!Ally.equals("Ally")) {
                    System.out.print(ally());
                    System.out.print(System());
                }
                if (Enemies > 0) {
                    if (Enemy3HP > 0) {
                        System.out.print(Enemy3());
                        System.out.print(System());
                    }
                    if (Enemies > 0) {
                        if (Enemy2HP > 0) {
                            System.out.print(Enemy2());
                            System.out.print(System());
                        }
                        if (Enemies > 0) {
                            if (Enemy1HP > 0) {
                                System.out.print(Enemy1());
                                System.out.print(System());
                            }
                        }
                    }
                }
            }
        }
        System.out.print(System());
        System.out.println();
        return"";
    }

    public static String Player(){
        Scanner sc = new Scanner(System.in);
        System.out.println(Player + "'s turn!");
        DungeonExploration.turn++;
        guard = 0;
        PlayerDf = PlayerMxDf;
        if (Condition == 0){
            System.out.println("-------------------");
            System.out.println("| " + Player + " = " + PlayerHP + " / " + PlayerMx);
            System.out.println("| 1 = Attack");
            System.out.println("| 2 = Guard");
            System.out.println("| 3 = Spy");
            System.out.println("| 4 = Items");
            System.out.println("| 5 = Run");
            System.out.println("-------------------");
            String choice = sc.nextLine();
            System.out.println();
            switch (choice){
                case "1":
                    System.out.println(attack());
                    TurnEnd = false;
                    break;
                case "2":
                    System.out.println(guard());
                    guard = 1;
                    TurnEnd = false;
                    break;
                case "3":
                    System.out.println(spy());
                    if (!DungeonExploration.easy){
                        TurnEnd = false;
                    }
                    break;
                case "4":
                    System.out.println(Item());
                    break;
                case "5":
                    System.out.println(run());
                    TurnEnd = false;
                    break;
                case "debug":
                    System.out.println(PlayerDf);
                    break;
                case "a":
                case "w":
                case "d":
                    System.out.println(Player + " tried to move away but it didn't work!");
                    System.out.println();
                    break;
                default:
                    System.out.println(Player + " doesn't know how to do that!");
                    System.out.println();
            }
        }
        /*
         * This is for the condition mechanic, there's no way to trigger this even currently, as the only enemy that
         * could cause this event led to unfair Game Overs
         */
        else {
            Condition--;
            if (Condition != 0){
                System.out.println(Player + " can't think properly!");
            }
            else{
                System.out.println(Player + " recovered!");
            }
            System.out.println();
        }
        return"";
    }

    public static String attack(){
        Enemy1Harmed++;
        Scanner sd = new Scanner(System.in);
        if (Enemies == 1){
            if (Enemy1HP > 0){
                System.out.print(attack1());
            }
            else if (Enemy2HP > 0){
                System.out.print(attack2());
            }
            else{
                System.out.print(attack3());
            }
        }
        else {
            System.out.println("-------------------");
            System.out.println("| Attack who?");
            if (Enemy1HP > 0) {
                System.out.println("| 1. " + Enemy1);
            }
            if (Enemy2HP > 0) {
                System.out.println("| 2. " + Enemy2);
            }
            if (Enemy3HP > 0) {
                System.out.println("| 3. " + Enemy3);
            }
            System.out.println("-------------------");
            int option2 = sd.nextInt();
            System.out.println();
            if (option2 == 1){
                System.out.print(attack1());
            }
            else if (option2 == 2){
                System.out.print(attack2());
            }
            else if (option2 == 3){
                System.out.print(attack3());
            }
            else {
                System.out.println(Player + " attacks the air!");
                System.out.println("The air took no damage!");
            }
        }
        return "";
    }

    public static String attack1(){
        if (Enemy1HP > 0) {
            System.out.println(Player + " attacks!");
            int damage = PlayerAk - Enemy1Df;
            if (damage <= 0) {
                System.out.println(Enemy1 + " took no damage!");
            }
            else {
                if (!Objects.equals(Critical1, 1)) {
                    double random2 = Math.random();
                    double random1 = Math.ceil(random2 * 10);
                    if (random1 >= 9) {
                        System.out.println("Critical Hit!");
                        damage = 2 * damage;
                    }
                }
                System.out.println(Enemy1 + " lost " + damage + " health!");
                Enemy1HP = Enemy1HP - damage;
            }
            if (Enemy1HP <= 0) {
                System.out.print(Enemy1Lose());
            }
        }
        else {
            System.out.println(Player + " attacks the air!");
            System.out.println("The air took no damage!");
        }
        return "";
    }

    public static String attack2(){
        if (Enemy2HP > 0) {
            System.out.println(Player + " attacks!");
            int damage = PlayerAk - Enemy2Df;
            if (damage <= 0) {
                System.out.println(Enemy2 + " took no damage!");
            }
            else {
                if (!Objects.equals(Critical1, 1)) {
                    double random2 = Math.random();
                    double random1 = Math.ceil(random2 * 10);
                    if (random1 >= 9) {
                        System.out.println("Critical Hit!");
                        damage = 2 * damage;
                    }
                }
                System.out.println(Enemy2 + " lost " + damage + " health!");
                Enemy2HP = Enemy2HP - damage;
            }
            if (Enemy2HP <= 0) {
                System.out.print(Enemy2Lose());
            }
        }
        else {
            System.out.println(Player + " attacks the air!");
            System.out.println("The air took no damage!");
        }
        return "";
    }

    public static String attack3(){
        if (Enemy3HP > 0) {
            System.out.println(Player + " attacks!");
            int damage = PlayerAk - Enemy3Df;
            if (damage <= 0) {
                System.out.println(Enemy3 + " took no damage!");
            }
            else {
                if (!Objects.equals(Critical1, 1)) {
                    double random2 = Math.random();
                    double random1 = Math.ceil(random2 * 10);
                    if (random1 >= 9) {
                        System.out.println("Critical Hit!");
                        damage = 2 * damage;
                    }
                }
                System.out.println(Enemy3 + " lost " + damage + " health!");
                Enemy3HP = Enemy3HP - damage;
            }
            if (Enemy3HP <= 0) {
                System.out.print(Enemy3Lose());
            }
        }
        else {
            System.out.println(Player + " attacks the air!");
            System.out.println("The air took no damage!");
        }
        return "";
    }

    public static String guard(){
        System.out.println(Player + " is on guard!");
        PlayerDf = PlayerDf * 2;
        Enemy1Kindness++;
        return "";
    }

    public static String spy(){
        if (Enemies == 1){
            System.out.println(Player + " checks his target!");
        }
        else{
            System.out.println(Player + " checks his targets!");
        }
        if (Enemy1HP > 0){
            if (Enemy1.equals("Golem")||Enemy1.equals("Doll")||Enemy1.equals("Poltergeist of the Mansion")
                    && !DungeonExploration.easy){
                System.out.println(Enemy1 + " = ? / ?");
                switch (Enemy1){
                    case "Golem":
                        System.out.println("- While strong and durable, it seems to be slowly crumbling...");
                        break;
                    case "Doll":
                        System.out.println("- Could it be possessed?");
                        break;
                    case "Poltergeist of the Mansion":
                        System.out.println("- This is it...");
                        if (!Ally.equals("Ally")){
                            System.out.println("I turn to my side to look at " + Ally);
                            System.out.println("They smile and nod back at me");
                        }
                        break;
                }
            }
            else {
                System.out.println(Enemy1 + " = " + Enemy1HP + " / " + Enemy1Mx);
            }
        }
        if (Enemy2HP > 0){
            if (Enemy2.equals("Vampire")||Enemy2.equals("Siren") && !DungeonExploration.easy){
                System.out.println(Enemy2 + " = ? / ?");
                switch (Enemy2){
                    case "Vampire":
                        System.out.println("- Has the ability to heal itself through sucking their blood");
                        break;
                    case "Siren":
                        if (!Ally.equals("Ally")){
                            System.out.println("- Has a soothing voice, but hopefully " + Ally + " won't be charmed by her voice");
                        }
                        else{
                            System.out.println("- Has a soothing voice that lures travelers");
                        }
                        break;
                }
            }
            else {
                System.out.println(Enemy2 + " = " + Enemy2HP + " / " + Enemy2Mx);
            }
        }
        if (Enemy3HP > 0){
            if (Enemy3.equals("Undead Warrior")||Enemy3.equals("Spider Queen") && !DungeonExploration.easy){
                System.out.println(Enemy3 + " = ? / ?");
                switch (Enemy3){
                    case "Undead Warrior":
                        System.out.println("- Spent the years finding a worthy opponent, perhaps I'll help him with that");
                        break;
                    case "Spider Queen":
                        System.out.println("- For a queen, she's quite cowardly, constantly calling for support and such");
                        break;
                }
            }
            else {
                System.out.println(Enemy3 + " = " + Enemy3HP + " / " + Enemy3Mx);
            }
        }
        return"";
    }

    public static String run(){
        double random1;
        System.out.println(Player + " tried to get away...");
        if (Run == 2){
            random1 = 4.20;
        }
        else if (Run == 3){
            random1 = 6.9;
        }
        else {
            double random2 = Math.random();
            random1 = Math.ceil(random2 * 10);
        }
        if (random1 <= 5){
            System.out.print("...and did!");
            Enemies = -3;
        }
        else {
            System.out.println("...but failed!");
        }
        return "";
    }

    public static String ally(){
        switch (Ally){
            case "Peggy":
            case "Sonata":
                System.out.println(Peggy());
                break;
            case "Lance":
            case "Acks":
                System.out.println(Lance());
                break;
            case "Ria":
            case "Melaina":
                System.out.println(Ria());
                break;
        }
        return"";
    }

    public static String Peggy(){
        AllyAk = PlayerAk / 2;
        AllyDf = PlayerMxDf / 2;
        System.out.println(Ally + "'s turn!");
        if (AllyCondition == 0){
            if (turn == 3 && Enemy1.equals("Mad Scientist")){
                System.out.println(Ally + " is on guard!");
                AllyDf = 7;
            }
            else {
                double random2 = Math.random();
                double random1 = Math.ceil(random2 * 10);
                if (random1 >= 3 && PlayerHP <= PlayerMx/2){
                    if (Ally.equals("Peggy")) {
                        System.out.println(Ally + " sings a calming tune to " + Player + "!");
                    }
                    else{
                        System.out.println(Ally + " dances to " + Player + "!");
                    }
                    int Healed = PlayerMx * 7 / 10;
                    PlayerHP += Healed;
                    if (PlayerHP <= PlayerMx){
                        System.out.println(Player + "'s health has been restored by " + Healed + "!");
                    } else {
                        System.out.println("All of " + Player + "'s health has been restored!");
                        PlayerHP = PlayerMx;
                    }
                }
                else {
                    if (Enemy1HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy1 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy1Df;
                            if (damage <= 0){
                                System.out.println(Enemy1 + " took no damage!");
                            } else {
                                System.out.println(Enemy1 + " lost " + damage + " health!");
                                Enemy1HP -= damage;
                            }
                        }
                        if(Enemy1HP <= 0){
                            System.out.print(Enemy1Lose());
                        }
                    }
                    else if (Enemy2HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy2 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy2Df;
                            if (damage <= 0){
                                System.out.println(Enemy2 + " took no damage!");
                            } else {
                                System.out.println(Enemy2 + " lost " + damage + " health!");
                                Enemy2HP -= damage;
                            }
                        }
                        if(Enemy2HP <= 0){
                            System.out.print(Enemy2Lose());
                        }
                    }
                    else if (Enemy3HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy3 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy3Df;
                            if (damage <= 0){
                                System.out.println(Enemy3 + " took no damage!");
                            } else {
                                System.out.println(Enemy3 + " lost " + damage + " health!");
                                Enemy3HP -= damage;
                            }
                        }
                        if(Enemy3HP <= 0){
                            System.out.print(Enemy3Lose());
                        }
                    }
                }
            }
        }
        else {
            AllyCondition--;
            if (AllyCondition != 0){
                System.out.println(Ally + " can't think properly!");
            }
            else{
                System.out.println(Ally + " recovered!");
            }
        }
        return "";
    }

    public static String Ria(){
        AllyAk = PlayerAk / 2 * 3;
        AllyDf = PlayerMxDf / 2;
        System.out.println(Ally + "'s turn!");
        if (AllyCondition == 0){
            if (turn == 3 && Enemy1.equals("Mad Scientist")){
                System.out.println(Ally + " is on guard!");
                AllyDf = PlayerMxDf;
            }
            else {
                double random2 = Math.random();
                double random1 = Math.ceil(random2 * 14);
                if (random1 <= 2){
                    if (Ally.equals("Ria")) {
                        System.out.println(Ally + " casts fire!");
                    }
                    else{
                        System.out.println(Ally + " casts darkness!");
                    }
                    if (Enemy1HP > 0) {
                        int damage = AllyAk - Enemy1Df;
                        if (damage <= 0) {
                            System.out.println(Enemy1 + " took no damage!");
                        } else {
                            System.out.println(Enemy1 + " lost " + damage + " health!");
                            Enemy1HP -= damage;
                        }
                        if (Enemy1HP <= 0) {
                            System.out.print(Enemy1Lose());
                        }
                    }
                    else {
                        System.out.println(Ally + "'s attack flew to a random direction!");
                    }
                }
                else if (random1 <= 4){
                    if (Ally.equals("Ria")) {
                        System.out.println(Ally + " casts fire!");
                    }
                    else{
                        System.out.println(Ally + " casts darkness!");
                    }
                    if (Enemy2HP > 0) {
                        int damage = AllyAk - Enemy2Df;
                        if (damage <= 0) {
                            System.out.println(Enemy2 + " took no damage!");
                        } else {
                            System.out.println(Enemy2 + " lost " + damage + " health!");
                            Enemy2HP -= damage;
                        }
                        if (Enemy1HP <= 0) {
                            System.out.print(Enemy2Lose());
                        }
                    }
                    else {
                        System.out.println(Ally + "'s attack flew to a random direction!");
                    }
                }
                else if (random1 <= 6){
                    if (Ally.equals("Ria")) {
                        System.out.println(Ally + " casts fire!");
                    }
                    else{
                        System.out.println(Ally + " casts darkness!");
                    }
                    if (Enemy3HP > 0) {
                        int damage = AllyAk - Enemy3Df;
                        if (damage <= 0) {
                            System.out.println(Enemy3 + " took no damage!");
                        } else {
                            System.out.println(Enemy3 + " lost " + damage + " health!");
                            Enemy3HP -= damage;
                        }
                        if (Enemy3HP <= 0) {
                            System.out.print(Enemy3Lose());
                        }
                    }
                    else {
                        System.out.println(Ally + "'s attack flew to a random direction!");
                    }
                }
                else if (random1 <= 10){
                    System.out.println(Ally + " increased " + Player + "'s defence!");
                    PlayerDf = PlayerDf * 3 / 2;
                }
                else if (random1 <= 14){
                    System.out.println(Ally + " increased " + Player + "'s attack!");
                    PlayerAk = PlayerAk * 3 / 2;
                }
            }
        }
        else {
            AllyCondition--;
            if (AllyCondition != 0){
                System.out.println(Ally + " can't think properly!");
            }
            else{
                System.out.println(Ally + " recovered!");
            }
        }
        return "";
    }

    public static String Lance(){
        AllyAk = PlayerAk - 3;
        AllyDf = PlayerMxDf;
        System.out.println(Ally + "'s turn!");
        if (AllyCondition == 0){
            if (turn == 3 && Enemy1.equals("Mad Scientist")){
                System.out.println(Ally + " is on guard!");
                AllyDf = 7;
            }
            else {
                double random2 = Math.random();
                double random1 = Math.ceil(random2 * 10);
                if (random1 >= 2){
                    if (Enemy1HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy1 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy1Df;
                            if (damage <= 0){
                                System.out.println(Enemy1 + " took no damage!");
                            } else {
                                System.out.println(Enemy1 + " lost " + damage + " health!");
                                Enemy1HP -= damage;
                            }
                        }
                        if(Enemy1HP <= 0){
                            System.out.print(Enemy1Lose());
                        }
                    }
                    else if (Enemy2HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy2 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy2Df;
                            if (damage <= 0){
                                System.out.println(Enemy2 + " took no damage!");
                            } else {
                                System.out.println(Enemy2 + " lost " + damage + " health!");
                                Enemy2HP -= damage;
                            }
                        }
                        if(Enemy2HP <= 0){
                            System.out.print(Enemy2Lose());
                        }
                    }
                    else if (Enemy3HP > 0){
                        System.out.println(Ally + " attacks!");
                        double random6 = Math.random();
                        double random5 = Math.ceil(random6 * 10);
                        if (random5 >= 9){
                            System.out.println(Enemy3 + " dodges quickly!");
                            System.out.println(Ally + " misses!");
                        }
                        else {
                            int damage = AllyAk - Enemy3Df;
                            if (damage <= 0){
                                System.out.println(Enemy3 + " took no damage!");
                            } else {
                                System.out.println(Enemy3 + " lost " + damage + " health!");
                                Enemy3HP -= damage;
                            }
                        }
                        if(Enemy3HP <= 0){
                            System.out.print(Enemy3Lose());
                        }
                    }
                }
                else {
                    if (Ally.equals("Lance")) {
                        System.out.println(Ally + " wipes his sweat!");
                    }
                    else{
                        System.out.println(Ally + " starts yelling!");
                    }
                }
            }
        }
        else {
            AllyCondition--;
            if (AllyCondition != 0){
                System.out.println(Ally + " can't think properly!");
            }
            else{
                System.out.println(Ally + " recovered!");
            }
        }
        return "";
    }

    public static String Enemy1(){
        if (turn2 == 1 && Enemy2.equals("Siren")){
            System.out.println(Enemy1 + "'s attack returns to normal!");
            Enemy1Ak = Enemy1Ak / 2;
            turn2--;
            System.out.println();
        }
        System.out.println(Enemy1 + "'s turn!");
        Enemy1Df = Enemy1MxDf;
        switch (Enemy1){
            case "Skeleton":
                System.out.println(Skeleton());
                break;
            case "Fish Soldier Captain":
            case "Fish Soldier":
                System.out.println(Fish_Soldier());
                break;
            case "Bat":
                System.out.println(Bat());
                break;
            case "Ghost":
                System.out.println(Ghost());
                break;
            case "Cat":
                System.out.println(Cat());
                break;
            case "Wolf":
                System.out.println(Wolf());
                break;
            case "Witch":
                System.out.println(Witch());
                break;
            case "Spider":
                System.out.println(SpiderA());
                break;
            case "Golem":
                System.out.println(Golem());
                break;
            case "Lion":
                System.out.println(Lion());
                break;
            case "Mad Scientist":
                System.out.println(Mad_Scientist());
                break;
            case "Doll":
                System.out.println(Doll());
                break;
            case "Poltergeist of the Mansion":
                System.out.println(PoltergeistOfTheMansion());
                break;
            default:
                System.out.println(Enemy1 + " doesn't have a way to attack for 1!");
                Enemies = -3;
        }
        return "";
    }

    public static String Wolf(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 5){
            System.out.println(Enemy1 + " howls!");
        }
        else {
            System.out.println(Enemy1 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
        }
        return "";
    }

    public static String Bat(){
        System.out.println(Enemy1 + " swoops down at " + Player + "!");
        double random6 = Math.random();
        double random5 = Math.ceil(random6 * 10);
        if (random5 >= 4){
            System.out.println(Player + " dodges quickly!");
            System.out.println(Enemy1 + " misses!");
        }
        else {
            System.out.print(Enemy1Attack());
        }
        return "";
    }

    public static String Ghost(){
        System.out.println(Enemy1 + " floats around!");
        return "";
    }

    public static String Skeleton(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            System.out.println(Enemy1 + " is on guard!");
            Enemy1Df = Enemy1MxDf * 2;
        }
        else if (random3 >= 5){
            System.out.println(Enemy1 + " rattles his bones at " + Player + "!");
        }
        else {
            System.out.println(Enemy1 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
        }
        return "";
    }

    public static String MiniGolem(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 4){
            System.out.println(Enemy2 + " is on guard!");
            Enemy2Df = Enemy2MxDf * 2;
        }
        else {
            System.out.println(Enemy2 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy2 + " misses!");
            }
            else {
                System.out.print(Enemy2Attack());
            }
        }
        System.out.println(Enemy2 + " seems to be slowly falling apart!");
        Enemy2Df -= 3;
        Enemy2Ak -= 1;
        Enemy2MxDf -= 3;
        Enemy2Mx -= 1;
        if (Enemy2MxDf <= 0){
            Enemy2HP = 0;
        }
        return "";
    }

    public static String Vampire(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            System.out.println(Enemy2 + " is on guard!");
            Enemy2Df = Enemy2MxDf * 2;
        }
        else {
            System.out.println(Enemy2 + " bites " + Player + "!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy2 + " misses!");
            }
            else {
                System.out.print(Enemy2Attack());
                if (harmed > 0) {
                    System.out.println(Enemy2 + " regains " + harmed + " health!");
                    Enemy2HP += harmed;
                }
            }
        }
        return "";
    }

    public static String Fish_Soldier(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            System.out.println(Enemy1 + " is on guard!");
            Enemy1Df = Enemy1MxDf * 2;
        }
        else if (random3 >= 5){
            System.out.println(Enemy1 + " strikes a pose!");
        }
        else if (random3 >= 2 && Enemy1.equals("Fish Soldier Captain")){
            System.out.println(Enemy1 + " calls for help!");
            Enemy3 = "Fish Soldier";
            Enemy3HP = 15;
            Enemy3Mx = 15;
            Enemy3Ak = 9;
            Enemy3MxDf = 2;
            Enemy3Df = 2;
            Enemies++;
        }
        else {
            double special = Math.random() * 10;
            if (special < 5){
                System.out.println(Enemy1 + " throws a harpoon!");
            }
            else {
                System.out.println(Enemy1 + " attacks with his lance!");
            }
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 7){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
        }
        return "";
    }

    public static String Witch(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 5){
            Enemy1Ak = 8;
            System.out.println(Enemy1 + " attacks with her rod!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 6){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
        }
        else {
            Enemy1Ak = 13;
            System.out.println(Enemy1 + " casts Fire!");
            System.out.print(Enemy1Attack());
        }
        return "";
    }

    public static String Cat(){
        if (Enemy1HP < Enemy1Mx/2){
            System.out.println(Enemy1 + " called for help!");
            Enemies++;
            Enemy1 = "Lion";
            Enemy2 = "Cat";
            System.out.println();
            System.out.println(Enemy1 + " showed up!");
            Enemy2HP = Enemy1HP;
            Enemy2Mx = Enemy1Mx;
            Enemy2Ak = Enemy1Ak;
            Enemy2MxDf = Enemy1MxDf;
            Enemy2Df = Enemy1Df;
            Run = 3;
            Enemy1HP = 26;
            Enemy1Mx = 26;
            Enemy1Ak = 7;
            Enemy1MxDf = 4;
            Enemy1Df = 4;
            Critical1 = 1;
        }
        else if (Enemy1Kindness == 2){
            System.out.println(Enemy1 + " walks away!");
            Enemies--;
        }
        else{
            System.out.println(Enemy1 + " stands there in fear!");
        }
        return "";
    }

    public static String SpiderA(){
        System.out.println(Enemy1 + " bites " + Player + "!");
        double random6 = Math.random();
        double random5 = Math.ceil(random6 * 10);
        if (random5 >= 9){
            System.out.println(Player + " dodges quickly!");
            System.out.println(Enemy1 + " misses!");
        }
        else {
            System.out.println(Player + " lost 1 health!");
            PlayerHP -= 1;
        }
        return "";
    }

    public static String Golem(){
        turn++;
        if (turn == 1){
            System.out.println(Enemy1 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
            turn++;
        }
        if (turn == 3){
            System.out.println(Enemy1 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
            turn++;
        }
        if (turn == 5){
            System.out.println(Enemy1 + " digs out a rock!");
            turn++;
        }
        if (turn == 7){
            System.out.println(Enemy1 + " throws his a rock!");
            if (guard == 1){
                System.out.println(Player + " is on guard and dodges!");
                System.out.println(Enemy1 + " misses!");
            }
            else{
                int damage = 15;
                System.out.println(Player + " lost " + damage + " health!");
                PlayerHP = PlayerHP - damage;
            }
            turn++;
        }
        if (turn == 9){
            if (Enemy2HP > 0){
                System.out.println(Enemy1 + " attacks!");
                double random6 = Math.random();
                double random5 = Math.ceil(random6 * 10);
                if (random5 >= 9){
                    System.out.println(Player + " dodges quickly!");
                    System.out.println(Enemy1 + " misses!");
                }
                else {
                    System.out.print(Enemy1Attack());
                }
            }
            else{
                System.out.println(Enemy1 + " called for backup!");
                Enemies++;
                System.out.println();
                Enemy2 = "Mini Golem";
                System.out.println(Enemy2 + " showed up!");
                Enemy2HP = 25;
                Enemy2Mx = 25;
                Enemy2Ak = 12;
                Enemy2MxDf = 5;
                Enemy2Df = 5;
            }
            turn++;
        }
        if (turn == 11){
            System.out.println(Enemy1 + " seems to be slowly falling apart!");
            Enemy1Df -= 3;
            Enemy1Ak -= 1;
            Enemy1MxDf -= 3;
            Enemy1Mx -= 1;
            turn = 0;
        }
        if (turn==6 && !Ally.equals("Ally")){
            System.out.println();
            System.out.println(Ally + " yells: ");
            System.out.println("'" + Player + ", keep your guard up!'");
        }
        return "";
    }

    public static String Fish_Soldier2(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            System.out.println(Enemy3 + " is on guard!");
            Enemy3Df = Enemy3MxDf * 2;
        }
        else if (random3 >= 5){
            System.out.println(Enemy3 + " strikes a pose!");
        }
        else {
            double special = Math.random() * 10;
            if (special < 5){
                System.out.println(Enemy3 + " throws a harpoon!");
            }
            else {
                System.out.println(Enemy3 + " attacks with his lance!");
            }
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 7){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy3 + " misses!");
            }
            else {
                System.out.print(Enemy3Attack());
            }
        }
        return "";
    }

    public static String Doll(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
         if (random3 >= 5){
            System.out.println(Enemy1 + " flies around " + Player + "!");
        }
        else {
            System.out.println(Enemy1 + " flies towards " + Player + "!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy1 + " misses!");
            }
            else {
                System.out.print(Enemy1Attack());
            }
        }
        return "";
    }

    public static String Lion(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            System.out.println(Enemy1 + " defends itself!");
            Enemy1Df = Enemy1MxDf * 2;
        }
        else {
            System.out.println(Enemy1 + " attacks!");
            System.out.print(Enemy1Attack());
        }
        return "";
    }

    public static String Mad_Scientist(){
        if (turn == 3){
            System.out.println(Enemy1 + " throws the bomb!");
            if (guard == 1){
                System.out.println(Player + " lost 1 health!");
                PlayerHP = PlayerHP - 1;
            }
            else{
                int damage = 8 - PlayerDf;
                if (damage <= 0){
                    System.out.println(Player + " took no damage!");
                }
                else {
                    System.out.println(Player + " lost " + damage + " health!");
                    PlayerHP = PlayerHP - damage;
                }
            }
            if(PlayerHP <= 0){
                System.out.println();
                System.out.println(System());
            }
            if (!Ally.equals("Ally")) {
                int hurt = 8 - AllyDf;
                System.out.println(Ally + " lost " + hurt + " health!");
            }
            if (Enemy2HP > 0){
                int harmed = 8 - Enemy2Df;
                System.out.println(Enemy2 + " lost " + harmed + " health!");
                Enemy2HP = Enemy2HP - harmed;
                if(Enemy2HP <= 0){
                    System.out.print(Enemy2Lose());
                }
            }
            turn = 0;
        }
        else {
            double random3 = Math.random();
            double random4 = Math.ceil(random3 * 10);
            if (random4 >= 7 && turn == 2){
                System.out.println(Enemy1 + " pulls out a bomb!");
                turn++;
            }
            else if (random4 > 2){
                System.out.println(Enemy1 + " attacks!");
                System.out.print(Enemy1Attack());
                if(turn < 2){
                    turn++;
                }
            }
            else {
                System.out.println(Enemy1 + " is on guard!");
                Enemy1Df = Enemy1MxDf * 2;
            }
        }
        return "";
    }
    public static String PoltergeistOfTheMansion(){
        double random2 = Math.random();
        double random1 = Math.ceil(random2 * 10);
        if (random1 > 8 && Enemy2HP <= 0) {
            double random3 = Math.random();
            double random4 = Math.ceil(random3 * 10);
            if (random4 < 5) {
                Enemy2 = "Mini Golem";
                Enemy2HP = 25;
                Enemy2Mx = 25;
                Enemy2Ak = 12;
                Enemy2MxDf = 5;
                Enemy2Df = 5;
            }
            else {
                Enemy2 = "Vampire";
                Enemy2HP = 21;
                Enemy2Mx = 21;
                Enemy2Ak = 8;
                Enemy2MxDf = 1;
                Enemy2Df = 1;
            }
            Enemies++;
            System.out.println(Enemy2 + " appears?");
        }
        else if (random1 > 6 && Enemy3HP <= 0) {
            double random3 = Math.random();
            double random4 = Math.ceil(random3 * 10);
            if (random4 < 5) {
                Enemy3 = "Spider Queen";
                Enemy3HP = 27;
                Enemy3Mx = 27;
                Enemy3Ak = 6;
            }
            else {
                Enemy3 = "Undead Warrior";
                Enemy3HP = 33;
                Enemy3Mx = 33;
                Enemy3Ak = 10;
            }
            Enemy3Df = 5;
            Enemy3MxDf = 5;
            System.out.println(Enemy3 + " appears?");
            Enemies++;
        }
        else {
            double special = Math.random() * 10;
            if (special < 5){
                System.out.println("A flying table hits " + Player + "!");
            }
            else {
                System.out.println("A flying chair hits " + Player + "!");
            }
            System.out.println(Enemy1Attack());
        }
        return"";
    }

    public static String Enemy1Attack(){
        int damage = Enemy1Ak - PlayerDf;
        if (damage <= 0){
            System.out.println(Player + " took no damage!");
        }
        else {
            System.out.println(Player + " lost " + damage + " health!");
            PlayerHP = PlayerHP - damage;
        }
        return"";
    }

    public static String Enemy2(){
        System.out.println(Enemy2 + "'s turn!");
        Enemy2Df = Enemy2MxDf;
        switch (Enemy2){
            case "Skeleton":
                System.out.println(Skeleton2());
                break;
            case "Cat":
                System.out.println(Cat2());
                break;
            case "Siren":
                System.out.println(Siren());
                break;
            case "Spider":
                System.out.println(SpiderB());
                break;
            case "Vampire":
                System.out.println(Vampire());
                break;
            case "Mini Golem":
                System.out.println(MiniGolem());
                break;
            default:
                System.out.println(Enemy2 + " doesn't have a way to attack for 2!");
                Enemies = -3;
        }
        return "";
    }
    public static String Cat2(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 5){
            if (Enemy1HP > 0){
                System.out.println(Enemy2 + " stands behind " + Enemy1 + "!");
            }
            else {
                System.out.println(Enemy2 + " hisses at " + Player + "!");
            }
        }
        else{
            System.out.println(Enemy2 + " scratches " + Player + "!");
            System.out.print(Enemy2Attack());
        }
        return "";
    }

    public static String SpiderB(){
        System.out.println(Enemy2 + " bites " + Player + "!");
        double random6 = Math.random();
        double random5 = Math.ceil(random6 * 10);
        if (random5 >= 9){
            System.out.println(Player + " dodges quickly!");
            System.out.println(Enemy2 + " misses!");
        }
        else {
            System.out.println(Player + " lost 1 health!");
            PlayerHP -= 1;
        }
        return "";
    }

    public static String Siren(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 >= 8){
            Enemy2Df = 0;
            if (Enemies >= 2 && Objects.equals(turn2, 0)){
                System.out.println(Enemy2 + " sings to " + Enemy1 + "!");
                System.out.println(Enemy1 + "'s attack increases!");
                Enemy1Ak = Enemy1Ak * 2;
                turn2 = 5;
            }
            else if ( Enemies == 1 && Poison == 1){
                System.out.println(Enemy2 + " flips her poisonous hair at " + Player + "!");
                double random6 = Math.random();
                double random5 = Math.ceil(random6 * 10);
                if (random5 >= 4){
                    System.out.println(Player + " dodges quickly!");
                    System.out.println(Enemy2 + " misses!");
                }
                else {
                    System.out.println(Player + " was poisoned!");
                    Poison = 4;
                }
            }
            else{
                System.out.println(Enemy2 + " sings to herself!");
            }
        }
        else if (random3 >= 4 && !Ally.equals("Ally")){
            System.out.println(Enemy2 + " sings to " + Ally + "...");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 5){
                System.out.println("...and " + Ally + " was entranced!");
                AllyCondition = 1;
            }
            else{
                System.out.println("..but nothing happened!");

            }
        }
        else{
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 5){
                System.out.println(Enemy2 + " tries to slap the " + Player + "!");
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy2 + " misses!");
            }
            else {
                System.out.println(Enemy2 + " slaps the " + Player + "!");
                System.out.print(Enemy2Attack());
            }
        }
        if (turn2 > 1){
            turn2--;
        }
        if (Enemies == 1){
            System.out.println();
            System.out.println("More fish soldiers join in!");
            Enemy1HP = 15;
            Enemy3HP = 15;
        }
        return "";
    }
    public static String Skeleton2(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 8);
        if (random3 >= 5){
            System.out.println(Enemy2 + " rattles his bones at " + Player + "!");
        }
        else {
            System.out.println(Enemy2 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy2 + " misses!");
            }
            else {
                System.out.print(Enemy2Attack());
            }
        }
        return "";
    }

    public static String Enemy2Attack(){
        harmed = Enemy2Ak - PlayerDf;
        if (harmed <= 0){
            System.out.println(Player + " took no damage!");
        }
        else {
            System.out.println(Player + " lost " + harmed + " health!");
            PlayerHP = PlayerHP - harmed;
        }
        return"";
    }

    public static String Enemy3Attack(){
        int damage = Enemy3Ak - PlayerDf;
        if (damage <= 0){
            System.out.println(Player + " took no damage!");
        }
        else {
            System.out.println(Player + " lost " + damage + " health!");
            PlayerHP = PlayerHP - damage;
        }
        return"";
    }

    public static String Enemy3(){
        System.out.println(Enemy3 + "'s turn!");
        Enemy3Df = Enemy3MxDf;
        switch (Enemy3){
            case "Skeleton":
                System.out.println(Skeleton3());
                break;
            case "Spider Queen":
                System.out.println(SpiderQueen());
                break;
            case "Fish Soldier":
                System.out.println(Fish_Soldier2());
                break;
            case "Undead Warrior":
                System.out.println(UndeadWarrior());
                break;
            default:
                System.out.println(Enemy3 + " doesn't have a way to attack for 3");
                Enemies = -3;
        }
        return "";
    }

    public static String Skeleton3(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 8);
        if (random3 >= 5){
            System.out.println(Enemy3 + " rattles his bones at " + Player + "!");
        }
        else {
            System.out.println(Enemy3 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy3 + " misses!");
            }
            else {
                System.out.print(Enemy3Attack());
            }
        }
        return "";
    }

    public static String UndeadWarrior(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 8);
        if (random3 >= 8){
            System.out.println(Enemy3 + " is on guard!");
            Enemy3Df = Enemy3MxDf * 2;
        }
        else if (random3 >= 5 && !Enemy1.equals("Poltergeist of the Mansion")){
            if (Enemy3Ak >= 13){
                System.out.println(Enemy3 + " tries to store power...");
                System.out.println("but couldn't anymore!");
            }
            else {
                System.out.println(Enemy3 + " stores his power!");
                Enemy3Ak++;
            }
        }
        else {
            System.out.println(Enemy3 + " attacks!");
            double random6 = Math.random();
            double random5 = Math.ceil(random6 * 10);
            if (random5 >= 9){
                System.out.println(Player + " dodges quickly!");
                System.out.println(Enemy3 + " misses!");
            }
            else {
                System.out.print(Enemy3Attack());
            }
        }
        return "";
    }

    public static String SpiderQueen(){
        double random4 = Math.random();
        double random3 = Math.ceil(random4 * 10);
        if (random3 > 7 && Enemy1HP <= 0 && !Enemy1.equals("Poltergeist of the Mansion")) {
            System.out.println(Enemy3 + " called for help!");
            Enemy1 = "Spider";
            System.out.println(Enemy1 + " showed up!");
            Enemy1HP = 10;
            Enemy1Mx = 10;
            Enemy1Ak = 1;
            Enemy1MxDf = 0;
            Enemy1Df = 0;
            Enemies++;
        }
        else if (random3 > 4 && Enemy2HP <= 0 && !Enemy1.equals("Poltergeist of the Mansion")) {
            System.out.println(Enemy3 + " called for help!");
            Enemy2 = "Spider";
            System.out.println(Enemy2 + " showed up!");
            Enemy2HP = 10;
            Enemy2Mx = 10;
            Enemy2Ak = 1;
            Enemy2MxDf = 0;
            Enemy2Df = 0;
            Enemies++;
        }
        else {
            System.out.println(Enemy3 + " attacks with its front legs!");
            System.out.print(Enemy3Attack());
            System.out.println(Player + " was poisoned!");
            Poison = 3;
        }
        return "";
    }

    public static String Enemy1Lose(){
        System.out.println();
        switch (Enemy1){
            case "Skeleton":
                System.out.println(Enemy1 + " falls apart!");
                break;
            case "Wolf":
                System.out.println(Enemy1 + " faints!");
                break;
            case "Witch":
                System.out.println(Enemy1 + " disintegrates into air!");
                break;
            case "Fish Soldier Captain":
                System.out.println(Enemy1 + " ran away!");
                if (Enemies != 1){
                    System.out.println(Enemy2 + " follows suit!");
                }
                break;
            case "Fish Soldier":
                System.out.println(Enemy1 + " ran away!");
                break;
            case "Bat":
                System.out.println(Enemy1 + " flies off!");
                break;
            case "Ghost":
                System.out.println(Enemy1 + " disappears!");
                break;
            case "Lion":
                System.out.println(Enemy1 + " faints!");
                if (Enemy2.equals("Cat") && Enemy2HP > 0){
                    System.out.println();
                    System.out.println(Enemy2 + "'s turn!");
                    System.out.println(Enemy2 + " takes off!");
                    Enemies--;
                }
                break;
            case "Doll":
            case "Spider":
                System.out.println(Enemy1 + " stops moving!");
                break;
            case "Golem":
                System.out.println(Enemy1 + " crumbles to rocks!");
                if (Enemy2HP > 0){
                    System.out.println(Enemy2 + " ran away!");
                    Enemies--;
                }
                break;
            case "Mad Scientist":
                System.out.println(Enemy1 + " laughs manically then faints!");
                break;
            case "Cat":
                System.out.println(Enemy1 + " takes off!");
                break;
            case "Poltergeist of the Mansion":
                System.out.println("...");
                System.out.println("It is finally over");
                DungeonExploration.Encounter = false;
                Enemies = 0;
                break;
            default:
                System.out.println(Enemy1 + " doesn't have a lose message for 1");
                Enemies = -3;
        }
        Enemies--;
        return"";
    }

    public static String Enemy2Lose(){
        System.out.println();
        switch (Enemy2){
            case "Skeleton":
                System.out.println(Enemy2 + " falls apart!");
                break;
            case "Cat":
                if (Enemy1.equals("Lion") && Enemy1HP > 0){
                    System.out.println(Enemy2 + " faints!");
                    System.out.println();
                    System.out.println(Enemy1 + " got angry!");
                    Enemy1Ak = Enemy1Ak * 2;
                }
                else {
                    System.out.println(Enemy2 + " faints!");
                }
                break;
            case "Siren":
                System.out.println(Enemy2 + " smiles, and faints!");
                if (Enemies != 1 && !Enemy1.equals("Poltergeist of the Mansion")){
                    System.out.println();
                    System.out.print("All the fish soldiers run away!");
                    Enemies = 0;
                }
                break;
            case "Mini Golem":
                System.out.println(Enemy2 + " returns to rocks!");
                break;
            case "Spider":
                System.out.println(Enemy2 + " stops moving!");
                break;
            case "Vampire":
                System.out.println(Enemy2 + " dissipated!");
                if (Enemies != 1 && !Enemy1.equals("Poltergeist of the Mansion")) {
                    System.out.println();
                    System.out.println("The bat flies away!");
                    Enemies = 1;
                }
                break;
            default:
                System.out.println(Enemy2 + "doesn't have a lose message for 2!");
        }
        Enemies--;
        return"";
    }

    public static String Enemy3Lose(){
        System.out.println();
        switch (Enemy3){
            case "Skeleton":
                System.out.println(Enemy3 + " falls apart!");
                break;
            case "Bat":
                System.out.println(Enemy3 + " flies off!");
                break;
            case "Spider Queen":
                System.out.print(Enemy3 + " stops moving!");
                if (Enemies != 1 && !Enemy1.equals("Poltergeist of the Mansion")) {
                    System.out.println();
                    System.out.print("All the spiders crawl away!");
                    Enemies = 1;
                }
                break;
            case "Fish Soldier":
                System.out.println(Enemy3 + " ran away!");
                break;
            case "Undead Warrior":
                System.out.println(Enemy3 + " breaks apart!");
                break;
            default:
                System.out.println(Enemy3 + "doesn't have a lose message for 3!");
        }
        Enemies--;
        return"";
    }

    public static String System(){
        if (Enemies == 0){
            if (!Ally.equals("Ally")){
                System.out.println(Player + " and " + Ally + " won the fight!");
            }
            else {
                System.out.println(Player + " won the fight!");
            }
            Enemies--;
            System.out.println("The enemy dropped a Potion!");
            Potion++;
            Enemy1Kindness = 0;
            Critical1 = 0;
            Enemy1HP = 0;
            Enemy2HP = 0;
            Enemy3HP = 0;
            AllyCondition = 0;
            Condition = 0;
            turn=0;
            turn2 = 0;
            choice = 0;
            Poison = 0;
            Enemy1 = "";
            Enemy2 = "";
            Enemy3 = "";
            Run = 1;
        }
        if (Enemies == -3){
            Enemy1Kindness = 0;
            Critical1 = 0;
            Enemy1HP = 0;
            Enemy2HP = 0;
            Enemy3HP = 0;
            AllyCondition = 0;
            Condition = 0;
            turn=0;
            turn2 = 0;
            choice = 0;
            Poison = 0;
            Enemy1 = "";
            Enemy2 = "";
            Enemy3 = "";
            Run = 1;
        }
        if(PlayerHP <= 0){
            switch (Ally){
                case "Peggy":
                    System.out.println("Peggy: " + Player + "? Oh, if only I was stronger, I could've help you better");
                    break;
                case "Sonata":
                    System.out.println("Sonata: " + Player + "? Get up! You need to get me out of here!");
                    break;
                case "Lance":
                    System.out.println("Lance: " + Player + "? N-no! Don't leave me n-now of all times!");
                    break;
                case "Acks":
                    System.out.println("Acks: " + Player + "? What happened? No, don't ya die on me 'ere dammit!");
                    break;
                case "Ria":
                    System.out.println("Ria: " + Player + "? Snap out of it! I can't do this on my own!");
                    break;
                case "Melaina":
                    System.out.println("Melaina: " + Player + "...? Oh...I feel so alone...again...");
                    break;
            }
            System.out.println();
            System.out.println(Player + " lost the fight!");
            System.out.println();
            System.out.println("Game Over...");
            System.exit (0);
        }
        return"";
    }
    public static String Menu(){
        System.out.println();
        System.out.print(DungeonExploration.Player + " = " + PlayerHP + " / " + PlayerMx);
        if (Poison != 0){
            System.out.println(" (Currently Poisoned)");
        }
        else{
            System.out.println();
        }
        System.out.print(Item());
        return"";
    }
    public static String Item(){
        Scanner sd = new Scanner(System.in);
        if (Potion != 0){
            System.out.println("-------------------");
            System.out.println("1. Go back");
            if (Potion != 0) {
                System.out.println("2. Potion - " + Potion);
            }
            System.out.println("-------------------");
            option = sd.nextLine();
            if (option.equals("2")){
                if (PlayerHP == PlayerMx){
                    System.out.println("It will have no effect!");
                }
                else {
                    int healed = PlayerMx / 3;
                    PlayerHP += healed;
                    if (PlayerHP >= PlayerMx) {
                        PlayerHP = PlayerMx;
                        System.out.println(Player + "'s HP maxed out!");
                    }
                    else {
                        System.out.println(Player + "'s HP increased by 15!");
                    }
                    Potion--;
                    TurnEnd = false;
                }
            }
            else if (!option.equals("1")){
                System.out.println("?");
            }
        }
        else {
            System.out.println("You have no items!");
        }
        return"";
    }
    public static String LevelUp(){
        System.out.println(Player + " leveled up!");
        if (DungeonExploration.easy){
            System.out.println("HP increased by 71" +
                    "!");
            PlayerMx += 7;
            System.out.println("Attack increased by 3!");
            PlayerAk += 3;
            //System.out.println("Defence increased by 1!");
            //PlayerDf += 1;
        }
        else{
            System.out.println("HP increased by 5!");
            PlayerMx += 5;
            System.out.println("Attack increased by 2!");
            PlayerAk += 2;
            //System.out.println("Defence increased by 2!");
            //PlayerDf += 2;
        }
        PlayerMxAk = PlayerAk;
        PlayerMxDf = PlayerDf;
        System.out.println();
        return"";
    }
}