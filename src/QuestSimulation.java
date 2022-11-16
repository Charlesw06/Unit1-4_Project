import java.io.*;
public class QuestSimulation {
    private String name;
    private String role;
    private boolean gameOver;
    private int bossHealth = 100;
    private int userHealth = 50;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    public QuestSimulation(String userName, String userRole) {
        name = userName;
        role = userRole;
        gameOver = false;
    }

    public String title() {
        return ANSI_YELLOW + "\n-=| THE HUNT FOR THE EYE OF DAS |=-\n";
    }

    public String introductionText() {
        return ANSI_YELLOW + "\n-=| The Invitation |=-\n" + ANSI_BLUE + "\nThe silence is deafening as you kneel before the throne of Emperor Avalon. A whole minute passes before\nhe offers you a deal. You can either except your punishment or go on a quest for him. He wants you to\nretrieve the " + ANSI_YELLOW +  "Eye of Das" + ANSI_BLUE + ", a sacred artifact that lets the user view anywhere in the world that they wish.\n\n" + ANSI_RESET + "Do you accept his offer (y = yes, n = no)? ";
    }

    public String questInitiationText(String userResponse) {
        if (userResponse.equals("y")) {
            return ANSI_BLUE + "\nThe emperor grins. He tells you that a horse and supplies are already waiting for you at the gate.\nYour quest has begun." + ANSI_RESET;
        }
        else {
            return ANSI_BLUE + "\nThe emperor glares at you. Before you are able to get up, you feel the hilt of a guard's sword hit\nyour head and everything goes black. When you wake up, you are restrained on a wagon traveling through\nthe woods. Turns out you didn't have a choice at all. Your quest has begun." + ANSI_RESET;
        }
    }

    public String knowledgeTestObstacle() {
        String obstacleText = "";
        if (role.equals("k")) {
            obstacleText = "\nIn front of you stands the dim cave entrance that leads to the dungeon. As you are working up the\ncourage to step inside, a small green figure lunges at you from the darkness. You knock it away\nwith your shield and draw your sword. A goblin. Gross. As it gets up, two more run out \nthe dungeon to face you.\n\n" + ANSI_RESET + "What do you do (1 = attack, 2 = dodge, 3 = whistle): ";
        }
        else if (role.equals("w")) {
            obstacleText = "\nIf front of you stands the dim cave entrance that leads to the dungeon. As you step closer to the\ncave, you realize that a tangle of thorny enchanted vines block the way in. Great. The vines start\nto creep towards you as if they know you are there.\n\n" + ANSI_RESET + "What do you do (1 = run away, 2 = fireball, 3 = ice breath): ";
        }
        else {
            obstacleText = "\nIf front of you stands the dim cave entrance that leads to the dungeon. As you walk deep into the\ncave, you slam face-first into a giant boulder. Not the smartest move. Taking a step back, you\nrealize that the boulder is not a boulder at all. The rock giant opens its glowing eyes and roars.\n\n" + ANSI_RESET + "What do you do (1 = roar, 2 = shield smash, 3 = axe swing): ";
        }
        return ANSI_YELLOW + "\n-=| The Cave Entrance |=-\n" + ANSI_BLUE + obstacleText;
    }

    public String knowledgeTestSolution(String userAction) {
        String resultText = "";
        if (userAction.equals("1")) {
            gameOver = true;
            if (role.equals("k")) {
                resultText = "\nYou slash at the first goblin and the blade goes clean through. As you turn around face the others,\nyou feel a burning sensation in your thigh. A poison dagger. Didn't you listen during the knight\ntraining lesson last week? Your vision blurs and you fall to the ground.\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (role.equals("w")) {
                resultText = "\nThe vines grow faster and faster. Out of instinct, you turn to run away. For some dumb reason, you\nhave decided to wear a long cloak on this quest. Your cloak gets snagged on a thorn and you trip,\ngiving the vines time to wrap you up and drag you deep into its lair.\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                resultText = "\nThe rock giant's eyes glow with a burning anger. You let out an ear-splitting roar. Instead of cowering,\nthe giant stands to its full height, around three times your size. Turns out rock giants are\nare not easily intimidated. It brings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_RED + "GAME OVER";
            }
        }
        else if (userAction.equals("2")) {
            gameOver = true;
            if (role.equals("k")) {
                resultText = "\nYou hop to the side to avoid the first goblin's attack, but you are too slow. Turns out jumping with\ntons of armor on is not the best idea. You feel a knife stab into your back. Then another. And\nanother. The goblins drag you into the cave so they can loot you properly.\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (role.equals("w")) {
                resultText = "\nThe vines grow faster and faster. Yelling an ancient chant, you slam your staff onto the cave floor and\na ball of fire is fired towards th vines. Surprisingly, it has no effect. Apparently, the\nenchants account for fire. The vines wrap you up and drag you deep into its lair.\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                resultText = "\nThe rock giant's eyes glow with a burning anger. You charge at the beast shield-first. Your shield\nshatters on impact and the giant pushes you back. I honestly don't know what you were expecting.\nThe rock giant brings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_RED + "GAME OVER";
            }
        }
        else {
            if (role.equals("k")) {
                resultText = "\nYou side-step the first goblin and take out your whistle. The ear-splitting screech forces the goblins\nto cover their ears and escape into the forest. Good thing you listened in monster defence class.\nanother. You grab a poison dagger that one of them dropped and walk into the dungeon entrance.";
            }
            else if (role.equals("w")) {
                resultText = "\nThe vines grow faster and faster. You whisper an incantation and blow an icy mist onto the vines. The\nvines instantly freeze and after a few seconds, cracks form in the vines and they crumble to pieces.\nYou kick aside the remaining vines and summon a small flame to cast light as you descend into the dungeon.";
            }
            else {
                resultText = "\nThe rock giant's eyes glow with a burning anger. You take out your axe and swing it at the giant's\nchest. Your axe hits its weak point, a glowing purple crystal that gives the giant life. Pure luck if you\nask me. The giant collapses. Stepping over its body, you continue further into the cave.";
            }
        }
        return ANSI_BLUE + resultText + "\n\nYou have passed the test of knowledge.";
    }

    public String determinationTestObstacle() {
        return ANSI_YELLOW + "\n-=| The Chamber |=-\n" + ANSI_BLUE + "\nYou enter a dark chamber. The only light comes from a hole in the ceiling that shines down on a crude\nstone throne. After some time, you sit on the throne despite your instincts telling you otherwise. You\nstart to hear whispers in the shadows." + ANSI_RESET + "\n\nDo you get up (y = yes, n = no): ";
    }

    public String determinationTestSolution(int attemptNum) {
        if (attemptNum == 1) {
            return ANSI_BLUE + "\nThe whispers start to form into words. \"" + name + "...\"" + ANSI_RESET + "\n\nDo you get up (y = yes, n = no)";
        }
        else if (attemptNum == 2) {

        }
        else if (attemptNum == 3) {

        }
        else if (attemptNum == 4) {

        }
        return "";
    }

    public String determinationObstacleText () {
        return ANSI_YELLOW + "\n-=| He Who Sees All |=-\n";
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public int damage(String move) {
        int damage = 0;
        if (move.equals("1")) {
            damage = 3;
        }
        if (move.equals("2")) {
            damage = 2;
        }
        if (move.equals("3")) {

        }
        return damage;
    }

    public String toString() {
        return "";
    }
}
