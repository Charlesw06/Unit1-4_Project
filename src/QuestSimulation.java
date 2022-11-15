public class QuestSimulation {
    private String name;
    private String role;
    private boolean gameOver;

    public QuestSimulation(String userName, String userRole) {
        name = userName;
        role = userRole;
        gameOver = false;
    }

    public String introductionText() {
        String intro = "The silence is deafening as you kneel before the throne of Emperor Avalon. A whole minute passes before\nhe offers you a deal. You can either except your punishment or go on a quest for him. He wants you to\nretrieve the Eye of Das, a sacred artifact that lets the user view anywhere in the world that they wish.";
        String question = "Do you accept his offer (y = yes, n = no)? ";
        return "\n" + intro + "\n\n" + question;
    }

    public String questInitiationText(String userResponse) {
        if (userResponse.equals("y")) {
            return "\nThe emperor grins. He tells you that a horse and supplies are already waiting for you at the gate.\nYour quest has begun.";
        }
        else {
            return "\nThe emperor glares at you. Before you are able to get up, you feel the hilt of a guard's sword hit\nyour head and everything goes black. When you wake up, you are restrained on a wagon traveling through\nthe woods. Turns out you didn't have a choice at all. Your quest has begun.";
        }
    }

    public String entranceObstacleText() {
        String obstacleText = "";
        if (role.equals("k")) {
            obstacleText = "\nIn front of you stands the dim cave entrance that leads to the dungeon. As you are working up the\ncourage to step inside, a small green figure lunges at you from the darkness. You knock it away\nwith your shield and draw your sword. A goblin. Gross. As it gets up, two more run out \nthe dungeon to face you.\n\nWhat do you do (1 = attack, 2 = dodge, 3 = whistle): ";
        }
        else if (role.equals("w")) {
            obstacleText = "\nIf front of you stands the dim cave entrance that leads to the dungeon. As you step closer to the\ncave, you realize that a tangle of thorny enchanted vines block the way in. Great. The vines start\nto creep towards you as if they know you are there.\n\nWhat do you do (1 = run away, 2 = fireball, 3 = ice breath): ";
        }
        else {
            obstacleText = "\nIf front of you stands the dim cave entrance that leads to the dungeon. As you walk deep into the\ncave, you slam face-first into a giant boulder. Not the smartest move. Taking a step back, you\nrealize that the boulder is not a boulder at all. The rock giant opens its glowing eyes and roars.\n\nWhat do you do (1 = roar, 2 = shield smash,3 = axe swing)";
        }
        return "\n-=| THE ENTRANCE |=-\n" + obstacleText;
    }

    public String entranceSolutionText(String userAction) {
        if (userAction.equals("1")) {
            gameOver = true;
            if (role.equals("k")) {
                return "\nYou slash at the first goblin and the blade goes clean through. As you turn around face the others,\nyou feel a burning sensation in your thigh. A poison dagger. Didn't you listen during the knight\ntraining lesson last week? Your vision blurs and you fall to the ground.\n\nGAME OVER";
            }
            else if (role.equals("w")) {
                return "\nThe vines grow faster and faster. Out of instinct, you turn to run away. For some dumb reason, you\nhave decided to wear a long cloak on this quest. Your cloak gets snagged on a thorn and you trip,\ngiving the vines time to wrap you up and drag you deep into its lair.\n\nGAME OVER";
            }
            else {
                return "\nThe rock giant's eyes glow with a burning anger. You let out an ear-splitting roar. Instead of cowering,\nthe giant stands to its full height, around three times your size. Turns out rock giants are\nare not easily intimidated. It brings down a massive stone arm on your head, crushing you instantly.\n\nGAME OVER";
            }
        }
        else if (userAction.equals("2")) {

        }
        else {
            return "";
        }
        return "";
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

}
