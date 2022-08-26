/*
 * So, you might have noticed that I changed the setting in my game from a school setting to a haunted house
 * setting, the reason was because I couldn't find a way to make a big dungeon a school (or at least, I didn't
 * know at the time) I also didn't realize at the time that the game was a dungeon exploration, and thought it was
 * more like a point-and-click adventure like, where you choose where to go and you automatically get teleported
 * there. Of course, once I realized that, I had to start from scratch, though before then, I built this. Some
 * remnants from this early design did make its way to the final game, such as your allies "Peggy" and "Lance",
 * and some of the enemies are just edited versions of what they were originally (like how "Delinquent" became
 * "Skeleton"). I didn't really have any idea on what to do with this, maybe sometime in the future I'll try
 * remaking it with something like RPG Maker
 */
import java.util.Scanner;
public class ScrappedGame {
    public static String Player, Action3;
    public static int Location = 1, Action, Items = 1, Event = 0, Can = 0, Tour, Activity = 1, Bell = 0, Option,
            PlayerHP = 10, PlayerMx = 10, daily = 0;
    public static double Money = 2;
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        Player = sc.nextLine();
        System.out.println("-------------------");
        System.out.println("The school bus drops me off right outside Elvofield High, its my first day here and" +
                " I don't know what to expect");
        System.out.println("I got my class schedule on me, maybe I should ask around for where my class is");
        System.out.println("As I approach the entrance, I faintly hear the noise of students talking");
        while (Location != 0) {
            if (Bell == 14){
                System.out.println("You hear the sound of the bell ringing!");
                System.out.println("Lance: Oh, " + Player + ", you hear that? Sounds like we should get back to " +
                        "class!");
                System.out.println("-END OF GAME-");
                System.exit(0);
                Bell++;
                Event = 4;
            }
            else {
                System.out.println("-------------------");
                System.out.println("| Choose Action:");
                System.out.println("| 1. Move");
                if (Tour == 1) {
                    System.out.println("| 2. Guide");
                } else {
                    if (Activity == 1) {
                        System.out.println("| 2. Talk");
                    } else {
                        System.out.println("| 2. Check");
                    }
                }
                System.out.println("| 3. Menu");
                System.out.println("-------------------");
                Action = sc.nextInt();
                switch (Action) {
                    case 1:
                        System.out.println(Move());
                        break;
                    case 2:
                        System.out.println(Talk());
                        break;
                    case 3:
                        System.out.println(Menu());
                        break;
                    default:
                        System.out.println("?");
                        break;
                }
            }
        }
    }
    public static String Move(){
        Scanner sd = new Scanner(System.in);
        switch (Location){
            case 1:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Quad");
                System.out.println("| 2. Exit");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        Location = 2;
                        Activity = 1;
                        if (Event == 0 || Event == 1) {
                            System.out.println("There are many students hanging out here");
                        }
                        if (Event == 3) {
                            System.out.println("It is quiet, such the difference from earlier");
                        }
                        break;
                    case 2:
                        if (Event == 0||Event == 1||Event == 2){
                            System.out.println("It isn't time to leave school yet");
                        }
                        else if (Event == 3){
                            System.out.println("Lance: " + Player + ", it isn't time to leave school yet!");
                        }
                        else{
                            Location = 0;
                            System.out.println("The end...for now");
                        }
                        break;
                    default:
                        System.out.println("?");
                        break;
                }
                break;
            case 2:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Entrance");
                System.out.println("| 2. Building 1");
                System.out.println("| 3. Building 2");
                System.out.println("| 4. Back Entrance");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        System.out.println("There's nobody here");
                        Location = 1;
                        Activity = 1;
                        break;
                    case 2:
                        Location = 3;
                        Activity = 1;
                        if (Event == 0 || Event == 1) {
                            System.out.println("Some students wandering around here");
                        }
                        if (Event == 2){
                            System.out.println("Students are rushing to their class");
                        }
                        if (Event == 3) {
                            System.out.println("There are teachers walking around");
                        }
                        break;
                    case 3:
                        if (Event == 1){
                            System.out.println("My class isn't this way");
                        }
                        else {
                            Location = 15;
                            if (Event == 0) {
                                System.out.println("There aren't many students here");
                            }
                            if (Event == 3) {
                                System.out.println("I hear noises coming from the Gym");
                            }
                        }
                        break;
                    case 4:
                        Location = 18;
                        Activity = 2;
                        if (Event == 0 || Event == 1){
                            System.out.println("This doesn't seem to be going anywhere");
                        }
                        if (Event == 3){
                            System.out.println("Lance seems to be acting more nervous than usual");
                        }
                        break;
                    default:
                        System.out.println("?");
                        break;
                }
                break;
            case 3:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Quad");
                System.out.println("| 2. Facility Office");
                System.out.println("| 3. Counseling Office");
                System.out.println("| 4. Stairway 1");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 2;
                            Activity = 1;
                            if (Event == 0 || Event == 1) {
                                System.out.println("Students are hanging out here");
                            }
                            if (Event == 3) {
                                System.out.println("It is empty, so different from earlier");
                            }
                        }
                        break;
                    case 2:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 5;
                            Activity = 1;
                            if (Event == 0 || Event == 1) {
                                System.out.println("The lady on the front desk looks tired");
                            }
                            if (Event == 3) {
                                System.out.println("I could smell a scent of coffee");
                            }
                        }
                        break;
                    case 3:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 6;
                            Activity = 1;
                            if (Event == 0 || Event == 1) {
                                System.out.println("The counselor seems to be rearranging " +
                                        "his paperwork");
                            }
                            if (Event == 3) {
                                System.out.println("Lance looks nervous for some reason");
                            }
                        }
                        break;
                    case 4:
                        Location = 4;
                        Activity = 2;
                        if (Event == 0 || Event == 1) {
                            System.out.println("The stairs looks dusty");
                        }
                        if (Event == 2){
                            System.out.println("I should hurry if I don't want to be late on my first day");
                        }
                        if (Event == 3){
                            System.out.println("The vending machine seems to be working properly");
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 4:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 1");
                System.out.println("| 2. Stairway 2");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        Location = 3;
                        Activity = 1;
                        if (Event == 0 || Event == 1) {
                            System.out.println("Some students wandering around here");
                        }
                        if (Event == 2){
                            System.out.println("Students are rushing to their class");
                        }
                        if (Event == 3) {
                            System.out.println("There are teachers walking around");
                        }
                        break;
                    case 2:
                        if (Event == 0 || Event == 1){
                            System.out.println("I don't know where my class is");
                            System.out.println("I should TALK to people to find where I" +
                                    " should be heading");
                        }
                        else {
                            Location = 7;
                            Activity = 2;
                            if (Event == 2){
                                System.out.println("The dash up the stairs in a hurry");
                            }
                            if (Event == 3){
                                System.out.println("Lance seems to thinking to himself");
                            }
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 5:
            case 6:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 1");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                if (Action == 1) {
                    Location = 3;
                    Activity = 1;
                    if (Event == 0 || Event == 1) {
                        System.out.println("Some students wandering around here");
                    }
                    if (Event == 2){
                        System.out.println("Students are rushing to their class");
                    }
                    if (Event == 3) {
                        System.out.println("There are teachers walking around");
                    }
                }
                else {
                    System.out.println("...");
                }
                break;
            case 7:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 2");
                System.out.println("| 2. Stairway 1");
                System.out.println("| 3. Stairway 3");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else{
                            Location = 8;
                            if (Event == 3) {
                                System.out.println("The sun shining through the window" +
                                        " lights up the room");
                            }
                        }
                        break;
                    case 2:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 4;
                            if (Event == 0 || Event == 1) {
                                System.out.println("The stairs looks dusty");
                            }
                            if (Event == 2){
                                System.out.println("I should hurry if I don't want to be late on my first day");
                            }
                            if (Event == 3){
                                System.out.println("The vending machine seems to be working properly");
                            }
                        }
                        break;
                    case 3:
                        Location = 11;
                        Activity = 2;
                        if (Event == 2) {
                            System.out.println("I hear faint noises coming from the" +
                                    "hallway on the third floor");
                        }
                        if (Event == 3){
                            System.out.println("There vending machine's lights seems to be glitching up");
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 8:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Stairway 2");
                System.out.println("| 2. Library");
                System.out.println("| 3. Music Room");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        Location = 7;
                        Activity = 2;
                        if (Event == 2){
                            System.out.println("The dash up the stairs in a hurry");
                        }
                        if (Event == 3){
                            System.out.println("Lance seems to thinking to himself");
                        }
                        break;
                    case 2:
                        Location = 9;
                        Activity = 1;
                        if (Event == 3) {
                            System.out.println("There seems to be a class present in" +
                                    "the library currently");
                        }
                        break;
                    case 3:
                        Location = 10;
                        Activity = 1;
                        if (Event == 3) {
                            System.out.println("While I expected the music room to be loud, it is instead eerily" +
                                    " quiet");
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 9:
            case 10:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 2");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                if (Action == 1) {
                    Location = 8;
                    if (Event == 3) {
                        System.out.println("The sun shining through the window" +
                                " lights up the room");
                    }
                }
                else {
                    System.out.println("...");
                }
                break;
            case 11:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 3");
                System.out.println("| 2. Stairway 2");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        Location = 12;
                        if (Event == 2){
                            System.out.println("The hallway still has a few people," +
                                    "maybe I won't be late");
                        }
                        if (Event == 3){
                            System.out.println("Lance looks nervous");
                        }
                        break;
                    case 2:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 7;
                            Activity = 2;
                            if (Event == 3){
                                System.out.println("Lance seems to thinking to himself");
                            }
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 12:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Stairway 3");
                System.out.println("| 2. My Class");
                System.out.println("| 3. Other Class");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        else {
                            Location = 11;
                            Activity = 2;
                            if (Event == 3){
                                System.out.println("There vending machine's lights seems to be glitching up");
                            }
                        }
                        break;
                    case 2:
                        Location = 14;
                        Activity = 2;
                        if (Event == 2) {
                            System.out.println("I walk into the classroom and I see" +
                                    " a delinquent next to another uncomfortable looking lass");
                        }
                        break;
                    case 3:
                        if (Event == 2){
                            System.out.println("I should get going to my class");
                        }
                        if (Event == 3){
                            System.out.println("Lance: " + Player + "! They're having" +
                                    "class in their currently, let's not disturb them");
                        }
                        else {
                            Location = 13;
                            Activity = 1;
                            System.out.println("You shouldn't be here");
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 13:
            case 14:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway 3");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                if (Action == 1) {
                    Location = 12;
                    if (Event == 2){
                        System.out.println("The hallway still has a few people," +
                                "maybe I won't be late");
                    }
                    if (Event == 3){
                        System.out.println("Lance looks nervous");
                    }
                }
                else {
                    System.out.println("...");
                }
                break;
            case 15:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Quad");
                System.out.println("| 2. Cafeteria");
                System.out.println("| 3. Gym");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                switch (Action){
                    case 1:
                        Location = 2;
                        Activity = 1;
                        if (Event == 0 || Event == 1) {
                            System.out.println("Students are hanging out here");
                        }
                        if (Event == 3) {
                            System.out.println("It is empty, so different from earlier");
                        }
                        break;
                    case 2:
                        if (Event == 0){
                            System.out.println("I don't know where my class is");
                            System.out.println("I should TALK to people to find where I should be heading");

                        }
                        if (Event == 1){
                            System.out.println("Well, now that I know my classes are not here, I should check " +
                                    "somewhere else");
                        }
                        if (Event == 3){
                            System.out.println("Lance: " + Player + ", you shouldn't enter, its not even lunch " +
                                    "time!");
                        }
                        else {
                            Location = 16;
                            Activity = 2;
                            System.out.println("This area shouldn't be accessible yet");
                        }
                        break;
                    case 3:
                        if (Event == 0){
                            System.out.println("I don't know where my class is");
                            System.out.println("I should TALK to people to find where I should be heading");

                        }
                        if (Event == 1){
                            System.out.println("Well, now that I know my classes are not here, I should check " +
                                    "somewhere else");
                        }
                        if (Event == 3){
                            System.out.println("Lance: " + Player + "! There is a class in there currently");
                        }
                        else {
                            Location = 17;
                            Activity = 2;
//                            System.out.println("This might be a good place to say this, the original intent for " +
//                                    "this settings ");
                        }
                        break;
                    default:
                        System.out.println("...");
                        break;
                }
                break;
            case 16:
            case 17:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Hallway A");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                if (Action == 1) {
                    Location = 15;
                    Activity = 1;
                    if (Event == 0 || Event == 1){
                        System.out.println("There aren't many students here");
                    }
                    if (Event == 3){
                        System.out.println("I hear noises coming from the Gym");
                    }
                }
                else {
                    System.out.println("...");
                }
                break;
            case 18:
                System.out.println("-------------------");
                System.out.println("| Choose Area:");
                System.out.println("| 1. Quad");
                System.out.println("-------------------");
                Action = sd.nextInt();
                System.out.println();
                if (Action == 1) {
                    Location = 2;
                    Activity = 1;
                    if (Event == 0 || Event == 1) {
                        System.out.println("Students are hanging out here");
                    }
                    if (Event == 3) {
                        System.out.println("It is empty, so different from earlier");
                    }
                }
                else {
                    System.out.println("...");
                }
                break;
            default:
                System.out.println("?");
                break;
        }
        return"";
    }
    public static String Talk(){
        Scanner se = new Scanner(System.in);
        Scanner sf = new Scanner(System.in);
        switch(Location) {
            case 1:
                if (Event == 3) {
                    System.out.println("Lance:  This is the entrance to the school, were here earlier right"
                            + Player + "?");
                    Bell++;
                }
                else {
                    System.out.println("There's no one here though");
                }
                break;
            case 2:
                if (Event == 0 || Event == 1 || Event == 2) {
                    double random2 = Math.random();
                    double random1 = Math.ceil(random2 * 10);
                    if (random1 >= 9) {
                        System.out.println("There's someone here listening to music");
                        System.out.println(Player + ": Excuse me!");
                        System.out.println("Student: ...");
                        System.out.println("Looks like she couldn't hear me");
                        System.out.println("She seems to be beating her head to her music");
                    } else if (random1 >= 6) {
                        System.out.println("There's someone here stretching");
                        System.out.println(Player + ": Excuse me!");
                        System.out.println("Student: Thirteen, fourteen, fifteen...");
                        System.out.println("Looks like he couldn't hear me");
                        System.out.println("I should leave him alone");
                    } else {
                        System.out.println("There's someone here playing card games");
                        System.out.println(Player + ": Excuse me!");
                        System.out.println("Student: ...send his soul to the Shadow Realm!");
                        System.out.println("Looks like he couldn't hear me");
                        System.out.println("He does seem to be having fun");
                    }
                }
                if (Event == 3) {
                    System.out.println("Lance: This is quad, connecting both buildings," +
                            " most students just hangout here");
                    Bell++;
                }
                break;
            case 3:
                if (Event == 0 || Event == 1) {
                    System.out.println("There's someone here opening his locker");
                    System.out.println(Player + ": Excuse me!");
                    System.out.println("Student: Hm? What do you need?");
                    System.out.println(Player + ": I'm looking for Room 302");
                    System.out.println("Student : Oh, just go up to the third floor and turn to your left");
                    System.out.println(Player + ": Alright thanks");
                    System.out.println("The student leaves");
                    Event = 2;
                } else if (Event == 2) {
                    System.out.println("I should get going to my class");
                } else if (Event == 3) {
                    System.out.println("Lance: This is the first floor, the only rooms here are offices");
                    Bell++;
                }
                break;
            case 4:
                if (Event == 2) {
                    System.out.println("I should get going to my class");
                }
                else if (Event == 3) {
                    System.out.print("Lance: This is the first floor's staircase, there's a vending machine back "
                            + "there when you want to grab something to drink, assuming the other guys aren't " +
                            "hogging it for themselves");
                    Bell++;
                    if (daily != 1){
                        System.out.println(", actually since this is your first day, here's" +
                                " a free soda" + "on the house");
                        System.out.print("Lance inserted a quarter into the machine and gave me the can that fell"
                                + " out");
                        daily = 1;
                        Can++;
                    }
                    System.out.println();
                }
                else {
                    System.out.println("There's a vending machine back there");
                    if (Event != 0 && Event != 1) {
                        System.out.println("One can costs $2.00");
                        if (Money >= 2) {
                            System.out.println("Buy one?");
                            Action = se.nextInt();
                            System.out.println();
                            if (Action == 1) {
                                Items++;
                                Can++;
                                Money -= 2;
                            }
                        } else {
                            System.out.println("I should come back when I have more money");
                        }
                    }
                    break;
                }
            case 5:
                if (Event == 0 || Event == 1) {
                    System.out.println(Player + ": Excuse me!");
                    System.out.println("Assistant: What do you want...?");
                    System.out.println(Player + ": Do you know where Room 302 is?");
                    //Yes, this is Melaina you're speaking to
                    System.out.println("Assistant: Oh... sweetie, just go up to the third" +
                            " floor and turn to your left...");
                    System.out.println(Player + ": Alright, thank you");
                    Event = 2;
                }
                else if (Event == 2) {
                    System.out.println("I should get going to my class");
                }
                else if (Event == 3) {
                    System.out.println("Lance: This is the facility office, you'd really only come here for " +
                            "events related matters");
                    Bell++;
                }
                break;
            case 6:
                if (Event == 0 || Event == 1) {
                    System.out.println(Player + ": Excuse me!");
                    System.out.println("Assistant: Hm? What do you need?");
                    System.out.println("I showed him my paper");
                    System.out.println("Assistant: Oh, this isn't the office for that, you're suppose to go to " +
                            "the facility office for information related to this");
                    System.out.println("Assistant: It is right next door");
                } else if (Event == 2) {
                    System.out.println("I should get going to my class");
                } else if (Event == 3) {
                    System.out.println("Lance: This is the counseling office, from experience, you'd only come " +
                            "here if you ever get in trouble, heh");
                    System.out.println("I notice that Lance seems to be sweating");
                    Bell++;
                }
                break;
            case 7:
                if (Event == 2) {
                    System.out.println("I should get going to my class");
                } else if (Event == 3) {
                    System.out.println("Lance: This is the second floor's stairway, it connects both the first" +
                            " and third floor");
                    Bell++;
                }
                break;
            case 8:
                if (Event == 3) {
                    System.out.println("Lance: This is the second floor, this floor is where all the elective " +
                            "classes are located");
                    Bell++;
                }
                break;
            case 9:
                if (Event == 3) {
                    System.out.println("Lance leans close and begins talk quietly");
                    System.out.println("Lance: This is the library. You know what this place is for, right?");
                    Bell++;
                }
                break;
            case 10:
                if (Event == 3) {
                    System.out.println("Lance: This is the music room, there used to be" +
                            " a club here but all the members disbanded due to a disagreement");
                    System.out.println("Lance: The only person that ever comes here normally is Peggy, not sure " +
                            "why though");
                    Bell++;
                }
                break;
            case 11:
                if (Event == 2){
                    System.out.println("I should get going to my class");
                }
                else if (Event == 3){
                    System.out.print("Lance: This is the third floor's staircase, there's a vending machine back" +
                            " there when you want to grab something to drink, assuming the other guys aren't " +
                            "hogging it for themselves");
                    Bell++;
                    if (daily != 1){
                        System.out.println(", actually since this is your first day, here's" +
                                " a free soda on the house");
                        System.out.print("Lance inserted a quarter into the machine and gave me the can that fell"
                                + " out");
                        daily = 1;
                        Can++;
                    }
                    System.out.println();
                }
                else {
                    System.out.println("There's a vending machine back there");
                    if (Event != 0 && Event != 1){
                        System.out.println("One can costs $2.00");
                        if (Money >= 2){
                            System.out.println("Buy one?");
                            Action = se.nextInt();
                            System.out.println();
                            if (Action == 1) {
                                Items++;
                                Can++;
                                Money -= 2;
                            }
                        }
                        else{
                            System.out.println("I should come back when I have more money");
                        }
                    }
                    break;
                }
            case 12:
                if (Event == 3) {
                    System.out.println("Lance: This is the third floor, this floor is" +
                            " where all the non elective classes are located");
                    Bell++;
                }
                break;
            case 13:
                System.out.println("No really, you shouldn't be here yet, how did you get here?");
                break;
            case 14:
                if (Event == 2){
                    System.out.println("I walk towards the two and the delinquent turns" +
                            " and looks at me");
                    System.out.println("Delinquent: Whataya want?");
                    System.out.println(Player + ": ");
                    String Action = sf.nextLine();
                    System.out.println("Delinquent:  What do you mean " + Action + "?");
                    System.out.println("Delinquent: Look bud, you better back of if you don't wanna get hurt!");
                    System.out.println();
                    System.out.println("-------------------");
                    System.out.println("Delinquent blocks the way!");
                    System.out.println(Player + "'s turn!");
                    System.out.println("-------------------");
                    System.out.println("| " + Player + " = " + PlayerHP + " / " + PlayerMx);
                    System.out.println("| 1 = Attack");
                    System.out.println("| 2 = Guard");
                    System.out.println("| 3 = Spy");
                    System.out.println("| 4 = Run");
                    System.out.println("-------------------");
                    int Action2 = sf.nextInt();
                    if (Action2 != 1){
                        System.out.println("Yeah uh, there's no way to do anything else currently, you can only" +
                                " attack");
                    }
                    System.out.println(Player + " attacks!");
                    System.out.println(" Delinquent lost 3 health!");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("Teacher: That's enough!");
                    System.out.println("Delinquent: !");
                    System.out.println(Player + ": ");
                    Action3 = sf.nextLine();
                    System.out.println("Teacher: Riki, what did I tell you about staying away from Peggy?");
                    System.out.println("Delinquent: ...");
                    System.out.println("Teacher: (Sigh), go back to your class before the bell rings");
                    System.out.println("The delinquent rushes out of the classroom");
                    System.out.println("The lass tugs on my shoulder");
                    System.out.println("Lass: Thanks");
                    System.out.println("Teacher: " + Player + ", it is your first day here is it not? Come up " +
                            "here");
                    System.out.println("When the bell rings the teacher introduces me to the class and tells me" +
                            " to sit in the empty next the lass from earlier");
                    System.out.println("Teacher: Lance!");
                    System.out.println("The student sitting next to me looks up at the teacher in surprise");
                    System.out.println("Teacher: Can you give " + Player + " a guide around the facility?");
                    System.out.println("Lance: Uh, sure thing miss!");
                    System.out.println("The student gets up and walks to the door");
                    System.out.println("He waves at me when he's left the room");
                    Event = 3;
                    Tour = 1;
                }
                else if (Event == 3){
                    System.out.println("The student outside seems to be waiting for me nervously");
                    System.out.println("Teacher: " + Player + ", it is your first day here is it not? Lance will" +
                            " give you a guide around the facility");
                }
            case 15:
                if (Event == 0) {
                    System.out.println(Player + ": Excuse me, do you know where Room 302 is");
                    System.out.println("Student: Classrooms are not here, they're in the other building");
                    Event = 1;
                }
                else if (Event == 1){
                    System.out.println("I should get going to the other building");

                }
                else if (Event == 3){
                    System.out.println("Lance: This is the second building, the only places worth to note here " +
                            "are the cafeteria and the school's gym");
                    Bell++;
                }
                break;
            case 18:
                if (Event == 3) {
                    System.out.println("Lance: I'd rather not go anywhere further than here, just saying");
                    Bell++;
                }
                break;
        }
        return"";
    }
    public static String Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("| " + Player + " = " + PlayerHP + " / " + PlayerMx);
        System.out.println("| Money = $" + String.format("%.2f", Money));
        System.out.println("| Choose Action:");
        System.out.println("| 1. Items");
        System.out.println("| 2. Back");
        System.out.println("-------------------");
        Action = sc.nextInt();
        if (Items == 0){
            System.out.println("You currently have no items!");
        }
        else {
            if (Action == 1) {
                System.out.print(Items());
            }
        }
        return"";
    }
    public static String Items(){
        Scanner sb = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("| Choose Item:");
        System.out.println("| 1. Schedule");
        if (Can!=0){
            System.out.println("| 2. Can - " + Can);
        }
        System.out.println("-------------------");
        Option = sc.nextInt();
        switch (Option) {
            case 1:
                System.out.println("-------------------");
                System.out.println("Schedule:");
                System.out.println("Room 302");
                System.out.println("Room 216");
                System.out.println("Room 401");
                System.out.println("Room 302");
                System.out.println("-------------------");
                System.out.println();
                break;
            case 2:
                if (Can > 0) {
                    System.out.println("Can - Recover 5 HP");
                    if (PlayerHP != PlayerMx) {
                        System.out.println("-------------------");
                        System.out.println("| Drink one?");
                        System.out.println("| 1. Yes");
                        System.out.println("| 1. No");
                        System.out.println("-------------------");
                        Action = sb.nextInt();
                        if (Action == 1) {
                            Can--;
                            Items--;
                            PlayerHP += 5;
                            if (PlayerHP > PlayerMx) {
                                PlayerHP = PlayerMx;
                                System.out.println(Player + " recovered all their HP!");
                            } else {
                                System.out.println(Player + " recovered 5 HP!");
                            }
                        }

                    }
                }
                else{
                    System.out.println("That is not a valid item");
                }
                break;
            default:
                System.out.println("That is not a valid item");
                break;
        }
        return"";
    }
}