/*
 * Author: Ronnie Huang
 * Class: CSC 211.07
 * File Name: TheMansionOfPoorDesign
 * Description: You are stuck in a mansion and try not to die
 */

import java.util.Arrays;
import java.util.Scanner;

public class DungeonExploration {
    public static String Player = "Hero";//Because Dragon Quest Reference :D
    public static int Can = 0, Direction = 2, Vision = 1, View, ResolveA = 0, ResolveB = 0, turn=0,
            Location_X = 1, Location_Y = 6, Event = 1, Spot = 0, Encountering = 2;
    public static boolean Options, Partner = false, Encounter = true, easy = false;
    public static String Movement;
    public static int [][] Maze;
    public static void main (String[]args){
        Maze = new int[24][15];
        for (int[] ints : Maze) {
            Arrays.fill(ints, 0);
        }
        /*
         * 0 = Wall
         * 1 = Area 1
         * 2 = Door
         * 3 = Exit
         * 4 = Player's Position
         * 5 = Area 2
         * 6 = Area 3
         * 7 = Area 4
         * 8 = Area 5
         * 9 = Area 6
         * 10 = Area 7
         * 11 = Entrance
         * 12 = Area 2 Hall
         * 13 = Area 3 Hall
         * 14 = Area 4 Hall
         * 15 = Area 5 Hall
         * 16 = Area 6 Hall
         * 17 = Area 7 Hall
         * 18 = Area right before exit
         * 19 = Boss
         */

        Maze[1][5] = 1;
        Maze[1][6] = 1;
        Maze[1][7] = 1;
        Maze[1][8] = 2;
        Maze[1][9] = 12;
        Maze[1][10] = 12;
        Maze[1][11] = 12;
        Maze[1][12] = 12;
        Maze[1][13] = 12;

        Maze[2][1] = 5;
        Maze[2][2] = 12;
        Maze[2][3] = 5;
        Maze[2][4] = 2;
        Maze[2][5] = 1;
        Maze[2][6] = 1;
        Maze[2][7] = 1;
        Maze[2][13] = 12;

        Maze[3][1] = 5;
        Maze[3][2] = 5;
        Maze[3][5] = 1;
        Maze[3][6] = 1;
        Maze[3][7] = 1;
        Maze[3][8] = 2;
        Maze[3][9] = 12;
        Maze[3][10] = 5;
        Maze[3][11] = 5;
        Maze[3][13] = 12;

        Maze[4][1] = 2;
        Maze[4][3] = 5;
        Maze[4][4] = 5;
        Maze[4][5] = 2;
        Maze[4][10] = 5;
        Maze[4][11] = 5;
        Maze[4][13] = 12;

        Maze[5][1] = 13;
        Maze[5][3] = 5;
        Maze[5][4] = 5;
        Maze[5][10] = 2;
        Maze[5][12] = 5;
        Maze[5][13] = 5;

        Maze[6][1] = 13;
        Maze[6][4] = 2;
        Maze[6][5] = 13;
        Maze[6][10] = 13;
        Maze[6][12] = 5;
        Maze[6][13] = 5;

        Maze[7][1] = 6;
        Maze[7][2] = 6;
        Maze[7][5] = 6;
        Maze[7][6] = 6;
        Maze[7][8] = 6;
        Maze[7][9] = 6;
        Maze[7][10] = 13;
        Maze[7][13] = 2;

        Maze[8][1] = 6;
        Maze[8][2] = 6;
        Maze[8][5] = 6;
        Maze[8][6] = 6;
        Maze[8][8] = 6;
        Maze[8][9] = 6;
        Maze[8][12] = 13;
        Maze[8][13] = 13;

        Maze[9][1] = 2;
        Maze[9][5] = 2;
        Maze[9][8] = 2;
        Maze[9][12] = 13;

        Maze[10][1] = 14;
        Maze[10][2] = 14;
        Maze[10][3] = 14;
        Maze[10][4] = 14;
        Maze[10][5] = 14;
        Maze[10][8] = 14;
        Maze[10][11] = 6;
        Maze[10][12] = 6;

        Maze[11][3] = 7;
        Maze[11][8] = 14;
        Maze[11][11] = 6;
        Maze[11][12] = 6;

        Maze[12][3] = 14;
        Maze[12][8] = 14;
        Maze[12][11] = 2;

        Maze[13][2] = 7;
        Maze[13][3] = 7;
        Maze[13][4] = 7;
        Maze[13][8] = 14;
        Maze[13][9] = 14;
        Maze[13][10] = 14;
        Maze[13][11] = 14;

        Maze[14][2] = 7;
        Maze[14][3] = 7;
        Maze[14][4] = 7;
        Maze[14][6] = 7;
        Maze[14][7] = 7;
        Maze[14][8] = 7;

        Maze[15][3] = 2;
        Maze[15][6] = 7;
        Maze[15][7] = 7;
        Maze[15][8] = 7;
        Maze[15][9] = 2;
        Maze[15][10] = 15;
        Maze[15][11] = 8;
        Maze[15][12] = 8;
        Maze[15][13] = 8;

        Maze[16][3] = 15;
        Maze[16][11] = 8;
        Maze[16][12] = 8;
        Maze[16][13] = 8;

        Maze[17][3] = 15;
        Maze[17][5] = 3;
        Maze[17][6] = 2;
        Maze[17][8] = 10;
        Maze[17][7] = 10;
        Maze[17][9] = 10;
        Maze[17][13] = 2;

        Maze[18][2] = 8;
        Maze[18][3] = 8;
        Maze[18][4] = 8;
        Maze[18][7] = 10;
        Maze[18][8] = 10;
        Maze[18][9] = 10;
        Maze[18][13] = 16;

        Maze[19][2] = 8;
        Maze[19][3] = 8;
        Maze[19][4] = 8;
        Maze[19][7] = 10;
        Maze[19][8] = 10;
        Maze[19][9] = 10;
        Maze[19][13] = 16;

        Maze[20][3] = 2;
        Maze[20][9] = 17;
        Maze[20][11] = 9;
        Maze[20][12] = 9;
        Maze[20][13] = 9;

        Maze[21][3] = 16;
        Maze[21][4] = 16;
        Maze[21][5] = 9;
        Maze[21][6] = 9;
        Maze[21][7] = 9;
        Maze[21][8] = 2;
        Maze[21][9] = 17;
        Maze[21][10] = 2;
        Maze[21][11] = 9;
        Maze[21][12] = 9;
        Maze[21][13] = 9;

        Maze[22][5] = 9;
        Maze[22][6] = 9;
        Maze[22][7] = 9;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        Player = sc.nextLine();
        System.out.println("I just entered the house, the doors around me seemed lock, maybe I should search " +
                "around");
        System.out.print(Around());
        while (Can != 1) {
            Vision = 1;
            System.out.print(Update());
            System.out.println("-------------------");
            System.out.println("| Type Your Action:");
            System.out.println("| WAD keys to move");
            System.out.println("| Menu");
            System.out.println("| Help");
            System.out.println("| Map");
            System.out.println("-------------------");
            Movement = sc.nextLine().toLowerCase();
            turn++;
            switch (Movement) {
                case "a":
                    Direction--;
                    if (Direction == 0) {
                        Direction = 4;
                    }
                    Options = false;
                    break;
                case "w":
                    System.out.print(Move());
                    Options = true;
                    break;
                case "d":
                    Direction++;
                    if (Direction == 5) {
                        Direction = 1;
                    }
                    Options = false;
                    break;
                case "s":
                    System.out.println("You tried to move back but then you realize you forgot how to...");
                    System.out.println("...because I was too lazy to program a 'move back' mechanic");
                    Options = false;
                    break;
                case "debug":
                    break;
                case "menu":
                    System.out.println(CombatLoop.Menu());
                    Options = false;
                    break;
                case "help":
                    System.out.println(Help());
                    Options = false;
                    break;
                case "easy":
                    easy = true;
                    Options = false;
                    break;
                case "map":
                    Options = false;
                    System.out.println(Map());
                    break;
                default:
                    Options = false;
                    System.out.println("?");
                    break;
            }
            if (Maze[Location_X][Location_Y] == 3){
                if (easy){
                    System.out.println("Congrats, you made it out of the mansion!");
                    System.out.println("Now try it without easy mode!");
                }
                else {
                    switch (CombatLoop.Ally) {
                        case "Lance":
                            System.out.println("Lance: W-we're finally out? Yes, I survived!");
                            System.out.println("Lance: Oh, " + Player + ", are you hungry?");
                            System.out.println("Lance: I'll pay for dinner today, if you want");
                            System.out.println("https://cdn.discordapp.com/attachments/517575103043731459/955322736903876638/unknown.png");
                            break;
                        case "Peggy":
                            System.out.println("Peggy: Oh hey, we've reached the end");
                            System.out.println("Peggy: You know " + Player + ", I'm glad we got to spend time"
                                    + " together, like the good old days");
                            System.out.println("Peggy: Well, see you around!");
                            System.out.println("https://cdn.discordapp.com/attachments/517575103043731459/955322737096785930/unknown.png");
                            break;
                        case "Ria":
                            if (!Player.toLowerCase().equals("melaina")) {
                                System.out.println("Ria: Alright, we're finally out of that mansion!");
                                System.out.println("Ria: I better go find my mother, she must be worried sick"
                                        +" about me!");
                                System.out.println("Ria: Oh, excuse my manners, thank you " + Player + " for"
                                        + " helping me get out, until we meet again!");
                            } else {
                                System.out.println("Ria: Alright, we're finally out of that mansion!");
                                System.out.println("Ria: Mom, I can't believe you came to find me!");
                                System.out.println("Ria: I always knew you'd show up!");
                            }
                            System.out.println("https://cdn.discordapp.com/attachments/517575103043731459/955322735914008576/unknown.png");
                            break;
                        case "Sonata":
                            System.out.println("Sonata: Finally, we out!");
                            System.out.println("Sonata: Well, I'm sure you're thankful for my help");
                            System.out.println("Sonata: Chao");
                            System.out.println("https://youtu.be/i20YhroYqiY?t=1546");
                            break;
                        case "Acks":
                            System.out.println("Acks: Ay look, we're finally made it outta' there!");
                            System.out.println("Acks: Oh, uh, sorry to ask but ya' got any money for food?");
                            System.out.println("Acks: Maybe we could hang-out after eatin', you're up for a lil'"
                                    + " weight liftin'?");
                            System.out.println("https://cdn.discordapp.com/attachments/517575103043731459/955322218278158407/unknown.png");
                            break;
                        case "Melaina":
                            System.out.println("Melaina: Ria...we've finally made it out...");
                            System.out.println("Melaina: Sweetie...I'm just glad that you're safe...");
                            System.out.println("Melaina: Let's go home...");
                            System.out.println("https://cdn.discordapp.com/attachments/517575103043731459/955322857922121738/unknown.png");
                            break;
                        default:
                            System.out.println("As you open the door, you feel the breeze of the wind against your"
                                    + " skin");
                            System.out.println("You take this moment to reflect on what just happened");
                            System.out.println("What is this mansion?");
                            System.out.println("Why am I here?");
                            System.out.println("What happened to the possibly innocent monsters I may or may not "
                                    + "have harmed?");
                            System.out.println("Will pleading 'self defense' hold up in court?");
                            System.out.println("But you realize that none of that matters now, as you're finally" +
                                    " free");
                            System.out.println("And " + Player + ", was happy...");
                    }
                }
                System.out.println();
                System.out.println("You took " + turn + " turns to get to the end!");
                System.exit(0);
            }
            if (Location_X == 1 && Location_Y == 6 && Event == 7 && !easy && CombatLoop.Ally.equals("Ally")){
                System.out.println("???: Ah, you finally found me!");
                System.out.println("???: Yes, my dear, it was I who trapped you in the alternate dimension " +
                        "dungeon");
                System.out.println("???: I was the ectoplasm that was guiding you along your voyage");
                System.out.println("???: Delighted am I to find that you haven't forgotten about me");
                System.out.println("???: May you find peace with the sadness that you've faced");
                System.out.println("???: Goodbye...");
                System.out.println();
                System.out.println("The door opened and I stepped outside to the open field");
                System.out.println("Then a fire started");
                System.out.println("The end!");
                System.exit(0);
            }
            if (Maze[Location_X][Location_Y] == 19 && Options) {
                System.out.print(CombatLoop.Boss());
                Event++;
            }
            else if (Encountering <= 0 && Options && Maze[Location_X][Location_Y] != 0
                    && Maze[Location_X][Location_Y] != 2 && Maze[Location_X][Location_Y] != 3
                    && Maze[Location_X][Location_Y] != 4 && Maze[Location_X][Location_Y] != 10
                    && Maze[Location_X][Location_Y] != 12 && Maze[Location_X][Location_Y] != 19
                    && Maze[Location_X][Location_Y] != 18 && Encounter){
                System.out.print(CombatLoop.Encounter(Maze[Location_X][Location_Y]));
                if (Options){
                    System.out.print(Around());
                    System.out.print(Intermission());
                    System.out.print(Left());
                    System.out.print(Right());
                }
                //Mechanic based off of what I've heard on random encounters works in the Earthbound Beginnings
                Encountering = (int) Math.ceil((Math.random() * 2) + 2);
            }
            else if (Location_X == 1 && Location_Y == 9 && !Partner){
                if (!Player.toLowerCase().equals("ria")) {
                    if (!Player.toLowerCase().equals("melaina")) {
                        System.out.println("Ria: Hey there! My name is Ria, I've been lost in this mansion for a"
                                + " while");
                        System.out.println("Ria: I can help by temporarily raising your stats, and I know how to "
                                + "fight with my inaccurate fireballs!");
                    }
                    else{
                        System.out.println("Ria: Huh? Mom?");
                        System.out.println("Ria: Well, I seemed to have been trapped in here");
                        System.out.println("Ria: Yes, I know, wandering on my own is never a good thing");
                    }
                    Partner = true; CombatLoop.Ally = "Ria";
                }
                else{
                    System.out.println("Melaina: Ria...sweetie...is that you? I've been looking all over for you"
                            + "...");
                    System.out.println("Melaina: What are you doing in a place like this...you know its "
                            + "dangerous to wander off on your own...");
                    Partner = true; CombatLoop.Ally = "Melaina";
                }
            }
            else if (Location_X == 2 && Location_Y == 3 && !Partner){
                if (!Player.toLowerCase().equals("lance")) {
                    if (!Player.toLowerCase().equals("acks")) {
                        System.out.println("Lance: I-is that really you " + Player + "? Remember me, Lance?");
                        System.out.println("Lance: D-don't worry, I can hold my own against most enemies!");
                    }
                    else{
                        System.out.println("Lance: A-acks?");
                        System.out.println("Lance: 'What am I doing here', I could ask you the same question!");
                    }
                    Partner = true; CombatLoop.Ally = "Lance";
                }
                else{
                    System.out.println("Acks: Lance? The hell are you doin' 'ere?");
                    System.out.println("Acks: Me? I was dragged into 'is by some feller");
                    Partner = true; CombatLoop.Ally = "Acks";
                }
            }
            else if (Location_X == 3 && Location_Y == 9 && !Partner){
                if (!Player.toLowerCase().equals("peggy")) {
                    if (!(Player.toLowerCase().equals("sonata"))) {
                        System.out.println("Peggy: " + Player + "? Hey, its me, Peggy! I see you're stuck here "
                                + "too");
                        System.out.println("Peggy: I can't fight, but my voice might be of some help to you");
                    }
                    else{
                        System.out.println("Peggy: Sonata? Why are you in a place like this?");
                        System.out.println("Peggy: Why don't we try and get out of here together?");
                        System.out.println("Peggy: Well, my voice can be helpful, though I can't fight, but can"
                                + " you?");
                    }
                    Partner = true; CombatLoop.Ally = "Peggy";
                }
                else{
                    System.out.println("Sonata: Huh? Well, if it isn't little miss Peggy");
                    System.out.println("Sonata: Well, as we both know, my dancing is far superior to your voice");
                    System.out.println("Sonata: Can I fight? Well, th-that's not relevant!");
                    Partner = true; CombatLoop.Ally = "Sonata";
                }
            }
            //There isn't a fourth partner, if you choose this route, you're choosing to go solo
            else if (Location_X == 4 && Location_Y == 5 && !Partner){
                Partner = true;
            }
            else if (Vision == 0){
                System.out.println("Ouch! I hit a wall!");
            }
            else if (Vision == 2){
                System.out.println("This door is locked!");
            }
            else if (Location_X == 21 && Location_Y == 9){
                switch (Direction) {
                    case 1:
                        System.out.println("I should check out the room with light coming from it on my left");
                        System.out.println("This hallway also continues ahead");
                        break;
                    case 2:
                        System.out.println("This hallway continues on both sides");
                        break;
                    case 3:
                        System.out.println("I should check out the room with light coming from it on my right");
                        System.out.println("This hallway also continues ahead");
                        break;
                    case 4:
                        System.out.println("There is a bright room ahead of me");
                        System.out.println("This hallway also continues both on my left and right");
                        break;
                }
            }
            else if (Location_X == 10 && Location_Y == 3){
                switch (Direction) {
                    case 1:
                        System.out.println("I should check out the room with the sound of water seems to be "
                                + "on my right");
                        System.out.println("This hallway also continues ahead");
                        break;
                    case 2:
                        System.out.println("I hear the sound of water splashing ahead");
                        System.out.println("This hallway also continues both on my left and right");
                        break;
                    case 3:
                        System.out.println("I should check out the room with the sound of water on my left");
                        System.out.println("This hallway also continues ahead");
                        break;
                    case 4:
                        System.out.println("This hallway continues both on my left and right");
                        break;
                }
            }
            else if (Location_X == 13 && Location_Y == 8){
                switch (Direction) {
                    case 1:
                        System.out.println("I should check out the room with the sound of water on my right");
                        System.out.println("This hallway also continues on my left");
                        break;
                    case 2:
                        System.out.println("I should check out the room with the sound of water in front of me");
                        System.out.println("This hallway also continues on my right");
                        break;
                    case 3:
                        System.out.println("I should check out the room with the sound of water on my left");
                        System.out.println("This hallway also continues both ahead and on my left");
                        break;
                    case 4:
                        System.out.println("This hallway continues both ahead and on my right");
                        break;
                }
            }
            else {
                if (Options){
                    System.out.print(Around());
                    System.out.print(Intermission());
                    System.out.print(Left());
                    System.out.print(Right());
                    Encountering--;
                }
            }
        }
    }
    public static String Move(){
        switch (Direction) {
            case 1:
                if (Maze[Location_X][Location_Y - 1] == 0) {
                    //For walls
                    Vision = 0;
                }
                else if (Maze[Location_X][Location_Y - 1] == 2) {
                    //For locked doors
                    Vision = 2;
                }
                else {
                    Location_Y -= 1;
                }
                break;
            case 2:
                if (Maze[Location_X + 1][Location_Y] == 0) {
                    Vision = 0;
                }
                else if (Maze[Location_X + 1][Location_Y] == 2) {
                    Vision = 2;
                }
                else {
                    Location_X += 1;
                }
                break;
            case 3:
                if (Maze[Location_X][Location_Y + 1] == 0) {
                    Vision = 0;
                }
                else if (Maze[Location_X][Location_Y + 1] == 2) {
                    Vision = 2;
                }
                else {
                    Location_Y += 1;
                }
                break;
            case 4:
                if (Maze[Location_X - 1][Location_Y] == 0) {
                    Vision = 0;
                }
                else if (Maze[Location_X - 1][Location_Y] == 2) {
                    Vision = 2;
                }
                else {
                    Location_X -= 1;
                }
                break;
            default:
                System.out.println();
                break;
        }
        return"";
    }
    public static String Update(){
        Maze[1][5] = 1;
        Maze[1][7] = 1;
        Maze[1][9] = 12;
        Maze[1][10] = 12;
        Maze[1][11] = 12;
        Maze[1][12] = 12;
        Maze[1][13] = 12;

        Maze[2][1] = 5;
        Maze[2][2] = 5;
        Maze[2][3] = 12;
        Maze[2][5] = 1;
        Maze[2][7] = 1;
        Maze[2][13] = 12;

        Maze[3][2] = 5;
        Maze[3][5] = 1;
        Maze[3][6] = 1;
        Maze[3][7] = 1;
        Maze[3][9] = 12;
        Maze[3][11] = 5;
        Maze[3][13] = 12;

        Maze[4][3] = 5;
        Maze[4][10] = 5;
        Maze[4][11] = 5;
        Maze[4][13] = 12;

        Maze[5][1] = 13;
        Maze[5][3] = 5;
        Maze[5][4] = 5;
        Maze[5][12] = 5;
        Maze[5][13] = 5;

        Maze[6][1] = 13;
        Maze[6][5] = 13;
        Maze[6][10] = 13;
        Maze[6][13] = 5;

        Maze[7][1] = 6;
        Maze[7][2] = 6;
        Maze[7][5] = 6;
        Maze[7][8] = 6;
        Maze[7][9] = 6;
        Maze[7][10] = 13;

        Maze[8][1] = 6;
        Maze[8][5] = 6;
        Maze[8][6] = 6;
        Maze[8][8] = 6;
        Maze[8][12] = 13;
        Maze[8][13] = 13;

        Maze[9][12] = 13;

        Maze[10][1] = 14;
        Maze[10][2] = 14;
        Maze[10][3] = 14;
        Maze[10][4] = 14;
        Maze[10][5] = 14;
        Maze[10][8] = 14;
        Maze[10][12] = 6;

        Maze[11][3] = 14;
        Maze[11][8] = 14;
        Maze[11][11] = 6;
        Maze[11][12] = 6;

        Maze[12][3] = 14;
        Maze[12][8] = 14;

        Maze[13][2] = 7;
        Maze[13][3] = 7;
        Maze[13][4] = 7;
        Maze[13][8] = 14;
        Maze[13][9] = 14;
        Maze[13][10] = 14;
        Maze[13][11] = 14;

        Maze[14][3] = 7;
        Maze[14][4] = 7;
        Maze[14][6] = 7;
        Maze[14][7] = 7;

        Maze[15][6] = 7;
        Maze[15][7] = 7;
        Maze[15][8] = 7;
        Maze[15][10] = 15;
        Maze[15][11] = 8;
        Maze[15][13] = 8;

        Maze[16][3] = 15;
        Maze[16][11] = 8;
        Maze[16][12] = 8;
        Maze[16][13] = 8;

        Maze[17][3] = 15;
        Maze[17][5] = 3;
        Maze[17][7] = 10;
        Maze[17][9] = 10;

        Maze[18][3] = 8;
        Maze[18][4] = 8;
        Maze[18][7] = 10;
        Maze[18][8] = 10;
        Maze[18][9] = 10;
        Maze[18][13] = 16;

        Maze[19][2] = 8;
        Maze[19][3] = 8;
        Maze[19][4] = 8;
        Maze[19][7] = 10;
        Maze[19][8] = 10;
        Maze[19][9] = 10;
        Maze[19][13] = 16;

        Maze[20][9] = 17;
        Maze[20][11] = 9;
        Maze[20][12] = 9;
        Maze[20][13] = 9;

        Maze[21][3] = 16;
        Maze[21][4] = 16;
        Maze[21][5] = 9;
        Maze[21][7] = 9;
        Maze[21][9] = 17;
        Maze[21][12] = 9;
        Maze[21][13] = 9;

        Maze[22][5] = 9;
        Maze[22][6] = 9;
        Maze[22][7] = 9;
        if (Event == 1) {
            Maze[2][6] = 19;
        }
        else {
            Maze[2][6] = 1;
        }
        if (Event == 2){
            Maze[3][1] = 19;
            Maze[3][10] = 19;
            Maze[4][4] = 19;
            Maze[6][12] = 19;
        }
        else{
            Maze[3][1] = 5;
            Maze[3][10] = 5;
            Maze[4][4] = 5;
            Maze[6][12] = 5;
        }
        if (Event >= 2) {
            Maze[1][8] = 12;
            Maze[2][4] = 12;
            Maze[3][8] = 12;
            Maze[4][5] = 12;
        }
        if (Event == 3){
            Maze[7][6] = 19;
            Maze[8][2] = 19;
            Maze[8][9] = 19;
            Maze[10][11] = 19;
        }
        else{
            Maze[7][6] = 6;
            Maze[8][2] = 6;
            Maze[8][9] = 6;
            Maze[10][11] = 6;
        }
        if (Event >= 3) {
            Maze[4][1] = 13;
            Maze[5][10] = 13;
            Maze[6][4] = 13;
            Maze[7][13] = 13;
        }
        if (Event == 4){
            Maze[14][2] = 19;
            Maze[14][8] = 19;
        }
        else{
            Maze[14][2] = 7;
            Maze[14][8] = 7;
        }
        if (Event >= 4) {
            Maze[9][1] = 14;
            Maze[9][5] = 14;
            Maze[9][8] = 14;
            Maze[12][11] = 14;
        }
        if (Event == 5){
            Maze[15][12] = 19;
            Maze[18][2] = 19;
        }
        else{
            Maze[15][12] = 8;
            Maze[18][2] = 8;
        }
        if (Event >= 5) {
            Maze[15][3] = 15;
            Maze[15][9] = 15;
        }
        if (Event == 6){
            Maze[21][6] = 19;
            Maze[21][11] = 19;
        }
        else{
            Maze[21][6] = 9;
            Maze[21][11] = 9;
        }
        if (Event >= 6) {
            Maze[17][13] = 16;
            Maze[20][3] = 16;
        }
        if (Event == 7){
            Maze[17][8] = 19;
        }
        else{
            Maze[17][8] = 10;
        }
        if (Event >= 7) {
            Maze[21][8] = 17;
            Maze[21][10] = 17;
        }
        if (Event >= 8) {
            Maze[17][6] = 18;
        }
        return"";
    }
    public static String Help(){
        System.out.println("Welcome to the maze that I couldn't come up with a good name for");
        System.out.println("You start of at 'E' and have to go to 'e'");
        System.out.println("Use the WAD keys to move");
        System.out.println("(There's no way to move back without turning around 180 degrees)");
        System.out.println("If you're ever lost, you always got your trusty map on you");
        System.out.println("On the map, the arrow represents your current location and which way you're facing");
        System.out.println("Every new room you enter is locked and you need to defeat the boss in the room");
        System.out.println("The boss sticks out on the floor, and they're hard to miss");
        System.out.println("After defeating the boss, all doors in said room automatically unlocks");
        if (easy) {
            System.out.println();
            System.out.println("Easy mode will also allow you to see the bosses' HP during battles");
            System.out.println("In fact you can see any enemies' HP during battles without your turn ending");
            System.out.println("Also your stat growths in level ups has been increased making combat...a joke");
        }
        else {
            System.out.println("If finding the bosses are ever too difficult, there's an easy mode");
            System.out.println("Type 'easy' when the game asks you to 'Type Your Action'");
        }
        if (Partner){
            System.out.println();
            switch (CombatLoop.Ally){
                case "Peggy":
                    System.out.println("Peggy, a pianist with a soothing voice");
                    System.out.println("Although she's a weak fighter, she can sing to heal you");
                    System.out.println("However, she would rather not waste her breath");
                    System.out.println("Because of that, she'll only sing when you're low on health");
                    break;
                case "Lance":
                    System.out.println("Lance, a shy and nervous teenager");
                    System.out.println("He's a somewhat strong fighter, and that's all he knows how to do");
                    System.out.println("Due to being very nervous (especially in battles), he is often wiping"
                            + " off his sweat");
                    break;
                case "Ria":
                    System.out.println("Ria, a young magician");
                    System.out.println("She is able to help you by raising either your attack or defence");
                    System.out.println("She also can summon a ball of fire, but she can't control its direction");
                    System.out.println("This may result in her ball of fire flying to random directions and"
                            + " hitting nothing");
                    System.out.println("Its more accurate when fighting multiple enemies");
                    break;
                case "Sonata":
                    System.out.println("Sonata, an attention seeking dancer");
                    System.out.println("She has a thing for attention and can heal you by dancing");
                    System.out.println("Because of those two points, she'll only dance for you when you are"
                            + " showing her attention");
                    System.out.println("More specifically, when you're low on health");
                    System.out.println("She's also scared to fight on her own");
                    break;
                case "Acks":
                    System.out.println("Acks, an energetic teenager");
                    System.out.println("He's really good at fighting, and he's weight lifts on his free time");
                    System.out.println("Due to being having so much energy, he sometimes feels the need to yell");
                    break;
                case "Melaina":
                    System.out.println("Melaina, my mother");
                    System.out.println("She is able to help me by raising either my attack or defence");
                    System.out.println("She also can summon a shard of ice, though she's often tired and dizzy");
                    System.out.println("This may result in her shard of ice flying to random directions and"
                            + " hitting nothing");
                    System.out.println("Its more accurate when fighting multiple enemies");
                    break;
                default:
                    System.out.println("You'll be on your own on this adventure, good luck!");
            }
        }
        return"";
    }
    public static String Map(){
        Maze[1][6] = 11;
        Spot = Maze[Location_X][Location_Y];
        Maze[Location_X][Location_Y] = 4;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 24; j++) {
                if ((Maze[j][i])==2){
                    System.out.print("▒");
                }
                else if ((Maze[j][i])==3){
                    System.out.print("e");
                }
                else if ((Maze[j][i])==19){
                    if (easy) {
                        System.out.print("B");
                    }
                    if (!easy) {
                        System.out.print(" ");
                    }
                }
                else if ((Maze[j][i])==4) {
                    if (Direction == 1){
                        System.out.print("^");
                    }
                    if (Direction == 2){
                        System.out.print(">");
                    }
                    if (Direction == 3){
                        System.out.print("v");
                    }
                    if (Direction == 4){
                        System.out.print("<");
                    }
                }
                else if ((Maze[j][i])==0){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==12 && Event < 2){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==5 && Event < 2){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==13 && Event < 3){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==6 && Event < 3){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==14 && Event < 4){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==7 && Event < 4){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==15 && Event < 5){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==8 && Event < 5){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==16 && Event < 6){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==9 && Event < 6){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==17 && Event < 7){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==10 && Event < 7){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==18 && Event < 8){
                    System.out.print("█");
                }
                else if ((Maze[j][i])==11) {
                    System.out.print("E");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        Maze[Location_X][Location_Y] = Spot;
        Maze[1][6] = 1;
        return"";
    }
    public static String Around(){
        if (Maze[Location_X][Location_Y] == 1){
            System.out.println("The torches around me line the wall, making the area pretty bright");
        }
        else if (Maze[Location_X][Location_Y] == 2) {
            System.out.println("I'm stuck on a door, because that's totally possible");
        }
        else if (Maze[Location_X][Location_Y] == 3){
            System.out.println("I'm outside, and the field out here is entirely on fire...jk");
        }
        else if (Maze[Location_X][Location_Y] == 4){
            System.out.println("The area around me seemed to glitch for a second, strange");
        }
        else if (Maze[Location_X][Location_Y] == 5){
            double special = Math.random() * 10;
            if (special < 5){
                System.out.println("This area doesn't seem as well lit as the room before");
            }
            else {
                System.out.println("The fires coming from the torches seem to be about to die out");
            }
        }
        else if (Maze[Location_X][Location_Y] == 6){
            double special = Math.random() * 10;
            if (special < 9){
                System.out.println("There are spiders, cobwebs, and skeletons around here");
            }
            else {
                System.out.println("I notice a spider crawl in front of me...horrifying");
            }
        }
        else if (Maze[Location_X][Location_Y] == 7){
            double special = Math.random() * 10;
            if (special < 9){
                System.out.println("I see a pool of glowing water and some fountains");
            }
            else {
                System.out.println("...? I think a drop of water fell on my head");
            }
        }
        else if (Maze[Location_X][Location_Y] == 8){
            double special = Math.random() * 10;
            if (special < 1){
                System.out.println("ACHOO...ugh, wish I brought some tissues with me");
            }
            else {
                System.out.println("The area here seem dusty, I feel like I might sneeze");
            }
        }
        else if (Maze[Location_X][Location_Y] == 9){
            double special = Math.random() * 10;
            if (special < 5){
                System.out.println("The room's walls seem to barely be holding up");
            }
            else {
                System.out.println("I could see moonlight from outside seeping through the walls");
            }
        }
        else if (Maze[Location_X][Location_Y] == 10){
            double special = Math.random() * 10;
            if (special < 8){
                System.out.println("I feel a slight breeze coming from somewhere");
            }
            else {
                System.out.println("I'm almost out of here, I can feel it!");
            }
        }
        else if (Maze[Location_X][Location_Y] == 11){
            System.out.println("You know, sarcastic teachers are better than formal teachers...formal teachers "
                    + "are very common, and pretty boring, so getting a sarcastic one once in a while is pretty "
                    + "refreshing");
        }
        else if (Maze[Location_X][Location_Y] == 12){
            System.out.println("The torches on the wall are somewhat well lit");
        }
        else if (Maze[Location_X][Location_Y] == 13){
            double special = Math.random() * 10;
            if (special < 6){
                System.out.println("As I walk, dust on my feet spread apart");
            }
            else {
                System.out.println("I think I might sneeze");
            }
        }
        else if (Maze[Location_X][Location_Y] == 14){
            double special = Math.random() * 10;
            if (special < 9.5){
                System.out.println("There are puddles of water on the floor");
            }
            else {
                System.out.println("Is that a fish hopping about on its own?");
            }
        }
        else if (Maze[Location_X][Location_Y] == 15){
            System.out.println("There seems to be cobwebs along this wall");
        }
        else if (Maze[Location_X][Location_Y] == 16){
            System.out.println("I feel nervous from the environment around me");
        }
        else if (Maze[Location_X][Location_Y] == 17){
            System.out.println("I'm almost out of here, I can feel it!");
        }
        else if (Maze[Location_X][Location_Y] == 18){
            System.out.println("I hear the strong wind outside");
        }
        return"";
    }
    public static String Hallway_or_no(){
        if ((Maze[ResolveA][ResolveB]) == 12) {
            if (Event >= 2){
                //Room 1 to Hallway 2
                if (Maze[Location_X][Location_Y] == 1){
                    System.out.println("The hallway ahead seems to get darker the more it goes on");
                }
                //Room 2 to Hallway 2
                else if (Maze[Location_X][Location_Y] == 5){
                    System.out.println("The hallway ahead seems to get brighter the more it goes on");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 5) {
            if (Event >= 2){
                //Hallway 2 to Room 2
                if (Maze[Location_X][Location_Y] == 12){
                    System.out.println("There is hall gets darker up ahead");
                }
                //Hallway 3 to Room 2
                else if (Maze[Location_X][Location_Y] == 13){
                    System.out.println("The room ahead doesn't have much light coming from it");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 13) {
            if (Event >= 3){
                //Room 2 to Hallway 3
                if (Maze[Location_X][Location_Y] == 5){
                    System.out.println("I can barely make out what looks like a small spider in front of me");
                }
                //Room 3 to Hallway 3
                else if (Maze[Location_X][Location_Y] == 6){
                    System.out.println("This way leads back to the room that was dimly lit");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 6) {
            if (Event >= 3){
                //Hallway 3 to Room 3
                if (Maze[Location_X][Location_Y] == 13){
                    System.out.println("I could see some spiders crawling around");
                }
                //Hallway 4 to Room 3
                else if (Maze[Location_X][Location_Y] == 14){
                    System.out.println("Seems to be spiders crawling around ahead");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 14) {
            if (Event >= 4){
                //Room 3 to Hallway 4
                if (Maze[Location_X][Location_Y] == 6){
                    System.out.println("There's water dripping in the hallway ahead");
                }
                //Room 4 to Hallway 4
                else if (Maze[Location_X][Location_Y] == 7){
                    System.out.println();
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 7) {
            if (Event >= 4){
                //Hallway 4 to Room 4
                if (Maze[Location_X][Location_Y] == 14){
                    System.out.println("I hear the sound of water splashing ahead");
                }
                //Hallway 5 to Room 4
                else if (Maze[Location_X][Location_Y] == 15){
                    System.out.println("I believe this was the area with pools of water");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 15) {
            if (Event >= 5){
                //Room 4 to Hallway 5
                if (Maze[Location_X][Location_Y] == 7){
                    System.out.println("I think I might sneeze from what's ahead of me");
                }
                //Room 5 to Hallway 5
                else if (Maze[Location_X][Location_Y] == 8){
                    System.out.println("I hear the sound of water splashing in the room I'm facing");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 8) {
            if (Event >= 5){
                //Hallway 5 to Room 5
                if (Maze[Location_X][Location_Y] == 15){
                    System.out.println("This area is really dusty coming from ahead");
                }
                //Hallway 6 to Room 5
                else if (Maze[Location_X][Location_Y] == 16){
                    System.out.println("Wait, I think I just missed the next room!");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 16) {
            if (Event >= 6){
                //Room 5 to Hallway 6
                if (Maze[Location_X][Location_Y] == 8){
                    System.out.println("The walls ahead don't look very stable");
                }
                //Room 6 to Hallway 6
                else if (Maze[Location_X][Location_Y] == 9){
                    System.out.println("The area ahead is the room that was dusty");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 9) {
            if (Event >= 6) {
                //Hallway 6 to Room 6
                if (Maze[Location_X][Location_Y] == 16){
                    System.out.println("I see a room in front of me with bricks on the walls barely holding "
                            + "together");
                }
                //Hallway 7 to Room 6
                else if (Maze[Location_X][Location_Y] == 17){
                    System.out.println("The room up ahead seems to be unstable");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 17) {
            if (Event >= 7) {
                //Room 6 to Hallway 7
                if (Maze[Location_X][Location_Y] == 9){
                    System.out.println("I see light coming from a room ahead");
                }
                //Room 7 to Hallway 7
                else if (Maze[Location_X][Location_Y] == 10){
                    System.out.println("The wall in area in front of me seem unstable");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 10) {
            if (Event >= 7) {
                //Hallway 7 to Room 7
                if (Maze[Location_X][Location_Y] == 17){
                    System.out.println("The room up ahead looks bright");
                }
                //Hallway 8/Exit to Room 7
                else if (Maze[Location_X][Location_Y] == 18){
                    System.out.println("Wait, did I see something from the previous room?");
                }
            }
        } else if ((Maze[ResolveA][ResolveB]) == 18) {
            if (Event < 8) {
                //Room 7 to Hallway 8/Exit
                if (Maze[Location_X][Location_Y] == 10){
                    System.out.println("The exit is up ahead");
                }
                //Exit to...yeah this isn't able to be viewed in normal gameplay
                else if (Maze[Location_X][Location_Y] == 3){
                    System.out.println("P.S. You should be out by now, why are you still here?");
                }
            }
        } else {
            System.out.println("This area continues ahead");
        }
        return"";
    }
    public static String Hallway_or_no_Left(){
        if ((Maze[ResolveA][ResolveB]) != 12 && Event >= 2 ||
        (Maze[ResolveA][ResolveB]) != 5 && Event >= 2 ||
        (Maze[ResolveA][ResolveB]) != 13 && Event >= 3 ||
        (Maze[ResolveA][ResolveB]) != 6 && Event >= 3 ||
        (Maze[ResolveA][ResolveB]) != 14 && Event >= 4 ||
        (Maze[ResolveA][ResolveB]) != 7 && Event >= 4 ||
        (Maze[ResolveA][ResolveB]) != 15 && Event >= 5 ||
        (Maze[ResolveA][ResolveB]) != 8 && Event >= 5 ||
        (Maze[ResolveA][ResolveB]) != 16 && Event >= 6 ||
        (Maze[ResolveA][ResolveB]) != 9 && Event >= 6 ||
        (Maze[ResolveA][ResolveB]) != 17 && Event >= 7 ||
        (Maze[ResolveA][ResolveB]) != 10 && Event >= 7 ||
        (Maze[ResolveA][ResolveB]) != 18 && Event >= 8) {
            System.out.println("There is a hallway to my left");
        }
        return"";
    }
    public static String Hallway_or_no_Right() {
        if ((Maze[ResolveA][ResolveB]) == 12 && Event < 2 ||
        (Maze[ResolveA][ResolveB]) != 5 && Event >= 2 ||
        (Maze[ResolveA][ResolveB]) != 13 && Event >= 3 ||
        (Maze[ResolveA][ResolveB]) != 6 && Event >= 3 ||
        (Maze[ResolveA][ResolveB]) != 14 && Event >= 4 ||
        (Maze[ResolveA][ResolveB]) != 7 && Event >= 4 ||
        (Maze[ResolveA][ResolveB]) != 15 && Event >= 5 ||
        (Maze[ResolveA][ResolveB]) != 8 && Event >= 5 ||
        (Maze[ResolveA][ResolveB]) != 16 && Event >= 6 ||
        (Maze[ResolveA][ResolveB]) != 9 && Event >= 6 ||
        (Maze[ResolveA][ResolveB]) != 17 && Event >= 7 ||
        (Maze[ResolveA][ResolveB]) != 10 && Event >= 7 ||
        (Maze[ResolveA][ResolveB]) != 18 && Event >= 8){
            System.out.println("There is a hallway to my right");
        }
        return"";
    }
    public static String Intermission() {
        View=1;
            switch (Direction) {
                case 1:
                    View = Location_Y;
                    if (Maze[Location_X][Location_Y-1] == 19) {
                        System.out.println("I see something strange in front of me");
                        View = 0;
                    } else if (Maze[Location_X][Location_Y-1] == 2) {
                        System.out.println("There's a door in front of me");
                        View = 0;
                    } else if (Maze[Location_X][Location_Y-1] == 0) {
                        System.out.println("There's a wall in front of me");
                        View = 0;
                    } else if (Maze[Location_X][Location_Y-1] == 3) {
                        System.out.println("I see the light seeping from the exit door");
                        View = 0;
                    } else if (Maze[Location_X][Location_Y-1] != Maze[Location_X][Location_Y]){
                        ResolveA = Location_X;
                        ResolveB = Location_Y - 1;
                        System.out.print(Hallway_or_no());
                    } else {
                        View -= 2;
                        while (View >= 0) {
                            if (Maze[Location_X][View] == 2) {
                                System.out.println("There's a door ahead");
                                View = -1;
                            } else if (Maze[Location_X][View] == 0) {
                                View = -1;
                            } else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                                ResolveA = Location_X;
                                ResolveB = View;
                                System.out.print(Hallway_or_no());
                                View = -1;
                            }
                            View--;
                        }
                    }
                    break;
                case 2:
                    View = Location_X;
                    if (Maze[Location_X+1][Location_Y] == 19) {
                        System.out.println("I see something strange in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X+1][Location_Y] == 0) {
                        System.out.println("There's a wall in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X+1][Location_Y] == 2) {
                        System.out.println("There's a door in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X+1][Location_Y] != Maze[Location_X][Location_Y]){
                        ResolveA = Location_X + 1;
                        ResolveB = Location_Y;
                        System.out.print(Hallway_or_no());
                    } else {
                        View += 2;
                        while (View < Maze.length) {
                            if (Maze[View][Location_Y] == 2) {
                                System.out.println("There's a door ahead");
                                View = Maze.length;
                            } else if (Maze[View][Location_Y] == 0) {
                                View = Maze.length;
                            } else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                                ResolveA = View;
                                ResolveB = Location_Y;
                                System.out.print(Hallway_or_no());
                                View = Maze.length;
                            }
                            View++;
                        }
                    }
                    break;
                case 3:
                    View = Location_Y;
                    if (Maze[Location_X][Location_Y + 1] == 19) {
                        System.out.println("I see something strange in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X][Location_Y + 1] == 0) {
                        System.out.println("There's a wall in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X][Location_Y + 1] == 2) {
                        System.out.println("There's a door in front of me");
                        View = Maze.length;
                    } else if (Maze[Location_X][Location_Y + 1] != Maze[Location_X][Location_Y]){
                        ResolveA = Location_X;
                        ResolveB = Location_Y + 1;
                        System.out.print(Hallway_or_no());
                    } else {
                        View += 2;
                        while (View < Maze.length) {
                            if (Maze[Location_X][View] == 0) {
                                View = Maze.length;
                            } else if (Maze[Location_X][View] == 2) {
                                System.out.println("There's a door ahead");
                                View = Maze.length;
                            } else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                                ResolveA = Location_X;
                                ResolveB = View;
                                System.out.print(Hallway_or_no());
                                View = Maze.length;
                            }
                            View++;
                        }
                    }
                    break;
                case 4:
                    View = Location_X;
                    if (Maze[Location_X-1][Location_Y] == 19) {
                        System.out.println("I see something strange in front of me");
                        View = 0;
                    } else if (Maze[Location_X-1][Location_Y] == 0) {
                        System.out.println("There's a wall in front of me");
                        View = 0;
                    } else if (Maze[Location_X-1][Location_Y] == 2) {
                        System.out.println("There's a door in front of me");
                        View = 0;
                    } else if (Maze[Location_X-1][Location_Y] != Maze[Location_X][Location_Y]){
                        ResolveA = Location_X-1;
                        ResolveB = Location_Y;
                        System.out.print(Hallway_or_no());
                    } else {
                        View -= 2;
                        while (View >= 0) {
                            if (Maze[View][Location_Y] == 0) {
                                View = -1;
                            } else if (Maze[View][Location_Y] == 2) {
                                System.out.println("There's a door ahead");
                                View = -1;
                            } else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                                ResolveA = View;
                                ResolveB = Location_Y;
                                System.out.print(Hallway_or_no());
                                View = -1;
                            }
                            View--;
                        }
                    }
                    break;
                default:
                    System.out.println("Warning, You've Entered An Unknown Location");
                    break;
            }
        return "";
    }
    public static String Left() {
        switch (Direction) {
            case 2:
                View = Location_Y;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[Location_X][View-1] == 19){
                    System.out.println("I see something strange to my left");
                    View = 0;
                }
                else if (Maze[Location_X][View-1] == 2){
                    System.out.println("There's a door to my left");
                    View = 0;
                }
                else if (Maze[Location_X][View-1] == 0){
                    View = 0;
                }
                else {
                    View-=2;
                    while (View >= 0) {
                        if (Maze[Location_X][View] == 2) {
                            System.out.println("There's a door to my left");
                            View = -1;
                        }
                        else if (Maze[Location_X][View] == 0) {
                            View = -1;
                        }
                        else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                            ResolveA = Location_X;
                            ResolveB = View;
                            System.out.print(Hallway_or_no_Left());
                            View = -1;
                        }
                        View--;
                    }
                }
                break;
            case 3:
                View = Location_X;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[View+1][Location_Y] == 19){
                    System.out.println("I see something strange to my left");
                    View = Maze.length;
                }
                else if (Maze[View+1][Location_Y] == 0){
                    View = Maze.length;
                }
                else if (Maze[View+1][Location_Y] == 2){
                    System.out.println("There's a door to my left");
                    View = Maze.length;
                }
                else {
                    View+=2;
                    while (View < Maze.length) {
                        if (Maze[View][Location_Y] == 2) {
                            System.out.println("There's a door to my left");
                            View = Maze.length;
                        }
                        else if (Maze[View][Location_Y] == 0) {
                            View = Maze.length;
                        }
                        else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                            ResolveA = View;
                            ResolveB = Location_Y;
                            System.out.print(Hallway_or_no_Left());
                            View = Maze.length;
                        }
                        View++;
                    }
                }
                break;
            case 4:
                View = Location_Y;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[Location_X][View+1] == 19){
                    System.out.println("I see something strange to my left");
                    View = Maze.length;
                }
                else if (Maze[Location_X][View+1] == 0){
                    View = Maze.length;
                }
                else if (Maze[Location_X][View+1] == 2){
                    System.out.println("There's a door to my left");
                    View = Maze.length;
                }
                else {
                    View+=2;
                    while (View < Maze.length) {
                        if (Maze[Location_X][View] == 0) {
                            View = Maze.length;
                        }
                        else if (Maze[Location_X][View] == 2) {
                            System.out.println("There's a door to my left");
                            View = Maze.length;
                        }
                        else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                            ResolveA = Location_X;
                            ResolveB = View;
                            System.out.print(Hallway_or_no_Left());
                            View = Maze.length;
                        }
                        View++;
                    }
                }
                break;
            case 1:
                View = Location_X;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[View-1][Location_Y] == 19){
                    System.out.println("I see something strange to my left");
                    View = 0;
                }
                else if (Maze[View-1][Location_Y] == 0){
                    View = 0;
                }
                else if (Maze[View-1][Location_Y] == 2){
                    System.out.println("There's a door to my left");
                    View = 0;
                }
                else {
                    View-=2;
                    while (View >= 0) {
                        if (Maze[View][Location_Y] == 0) {
                            View = -1;
                        }
                        else if (Maze[View][Location_Y] == 2) {
                            System.out.println("There's a door to my left");
                            View = -1;
                        }
                        else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                            ResolveA = View;
                            ResolveB = Location_Y;
                            System.out.print(Hallway_or_no_Left());
                            View = -1;
                        }
                        View--;
                    }
                }
                break;
            default:
                System.out.println("Warning, You've Entered An Unknown Location");
                break;
        }
        return "";
    }
    public static String Right() {
        switch (Direction) {
            case 4:
                View = Location_Y;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[Location_X][View-1] == 19){
                    System.out.println("I see something strange to my right");
                    View = 0;
                }
                else if (Maze[Location_X][View-1] == 2){
                    System.out.println("There's a door to my right");
                    View = 0;
                }
                else if (Maze[Location_X][View-1] == 0){
                    View = 0;
                }
                else {
                    View-=2;
                    while (View >= 0) {
                        if (Maze[Location_X][View] == 2) {
                            System.out.println("There's a door to my right");
                            View = -1;
                        }
                        else if (Maze[Location_X][View] == 0) {
                            View = -1;
                        }
                        else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                            ResolveA = Location_X;
                            ResolveB = View;
                            System.out.print(Hallway_or_no_Right());
                            View = -1;
                        }
                        View--;
                    }
                }
                break;
            case 1:
                View = Location_X;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[View+1][Location_Y] == 19){
                    System.out.println("I see something strange to my right");
                    View = Maze.length;
                }
                else if (Maze[View+1][Location_Y] == 0){
                    View = Maze.length;
                }
                else if (Maze[View+1][Location_Y] == 2){
                    System.out.println("There's a door to my right");
                    View = Maze.length;
                }
                else {
                    View+=2;
                    while (View < Maze.length) {
                        if (Maze[View][Location_Y] == 2) {
                            System.out.println("There's a door to my right");
                            View = Maze.length;
                        }
                        else if (Maze[View][Location_Y] == 0) {
                            View = Maze.length;
                        }
                        else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                            ResolveA = View;
                            ResolveB = Location_Y;
                            System.out.print(Hallway_or_no_Right());
                            View = Maze.length;
                        }
                        View++;
                    }
                }
                break;
            case 2:
                View = Location_Y;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[Location_X][View+1] == 19){
                    System.out.println("I see something strange to my right");
                    View = Maze.length;
                }
                else if (Maze[Location_X][View+1] == 0){
                    View = Maze.length;
                }
                else if (Maze[Location_X][View+1] == 2){
                    System.out.println("There's a door to my right");
                    View = Maze.length;
                }
                else {
                    View+=2;
                    while (View < Maze.length) {
                        if (Maze[Location_X][View] == 0) {
                            View = Maze.length;
                        }
                        else if (Maze[Location_X][View] == 2) {
                            System.out.println("There's a door to my right");
                            View = Maze.length;
                        }
                        else if (Maze[Location_X][View] != Maze[Location_X][Location_Y]) {
                            ResolveA = Location_X;
                            ResolveB = View;
                            System.out.print(Hallway_or_no_Right());
                            View = Maze.length;
                        }
                        View++;
                    }
                }
                break;
            case 3:
                View = Location_X;
                if (View < 0){
                    View *= -1;
                }
                if (Maze[View-1][Location_Y] == 19){
                    System.out.println("I see something strange to my right");
                    View = 0;
                }
                else if (Maze[View-1][Location_Y] == 0){
                    View = 0;
                }
                else if (Maze[View-1][Location_Y] == 2){
                    System.out.println("There's a door to my right");
                    View = 0;
                }
                else {
                    View-=2;
                    while (View >= 0) {
                        if (Maze[View][Location_Y] == 0) {
                            View = -1;
                        }
                        else if (Maze[View][Location_Y] == 2) {
                            System.out.println("There's a door to my right");
                            View = -1;
                        }
                        else if (Maze[View][Location_Y] != Maze[Location_X][Location_Y]) {
                            ResolveA = View;
                            ResolveB = Location_Y;
                            System.out.print(Hallway_or_no_Right());
                            View = -1;
                        }
                        View--;
                    }
                }
                break;
            default:
                System.out.println("Warning, You've Entered An Unknown Location");
                break;
        }
        return "";
    }
}