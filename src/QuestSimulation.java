public class QuestSimulation {
    private String name;
    private String role;

    public QuestSimulation(String userName, String userRole) {
        name = userName;
        role = userRole;
    }

    public String introduction() {
        String intro = "The silence is deafening as you kneel before the throne of Emperor Avalon. A whole minute passes before\nhe offers you a deal. You can either except your punishment or go on a quest for him. He wants you to\nretrieve the Eye of Das, a sacred artifact that lets the user view anywhere in the world that they wish.";
        String question = "Do you accept his offer (y = yes, n = no)? ";
        return intro + "\n\n" + question;
    }

    public String questInitiation(String userResponse) {
        if (userResponse.equals("y")) {
            return "The emperor grins. He tells you that a horse and supplies are already waiting for you at the gate.\nYour quest has begun.";
        }
        else {
            return "The emperor glares at you. Before you are able to get up, you feel the hilt of a guard's sword hit\nyour head and everything goes black. When you wake up, you are restrained on a wagon traveling through\nthe woods. Turns out you didn't have a choice at all. Your quest has begun.";
        }
    }

    public String chapter1() {
        if (role.equals("k")) {
            String obstacleText = "In front of you stands the dim cave entrance that leads to the dungeon. As you are\nworking up the courage to step inside, you hear crackling echoing from the opening. All of a sudden,\n a small green figure lunges at you from the darkness. You knock it away with your shield and draw your sword. As the goblin gets up, two more run out of the dungeon to face you. ";
        }
        return "";
    }

    public int wizardDamage(int move) {
        int damage = 0;
        if (move == 1) {
            damage = 10;
        }
        if (move == 2) {
            damage = 7;
        }
        return damage;
    }

    public int knightDamage() {
        int damage = 0;
        return damage;
    }

    public int barbarianDamage() {
        int damage = 0;
        return damage;
    }

}
