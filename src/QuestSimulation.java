public class QuestSimulation {
    private String name;
    private String role;

    public QuestSimulation(String userName, String userRole) {
        name = userName;
        role = userRole;
    }

    public String introduction() {
        String intro = "The silence is deafening as you stand before the throne of Emperor Avalon. It was only a matter of time before you were caught by the emperor's forces.\nI don't blame you. Those royal pastries looked amazing. A whole minute passes before he offers you a deal. You can either except your punishment or go on a little quest for him. ";
        return intro;
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
