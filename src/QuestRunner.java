import java.util.Scanner;

public class QuestRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the name of your character? ");
        String userName = s.nextLine();

        Scanner n = new Scanner(System.in);
        System.out.print("What is the role of your character (k = knight, w = wizard, b = barbarian)? ");
        String userRole = n.nextLine();
        System.out.println();

        QuestSimulation newQuest = new QuestSimulation(userName, userRole);

        System.out.println(newQuest.introduction());

    }
}
