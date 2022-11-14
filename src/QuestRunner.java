import java.util.Scanner;

public class QuestRunner {
    public static void main(String[] args) {
        System.out.println("-=| THE HUNT FOR THE EYE OF DAS |=-\n");

        Scanner s = new Scanner(System.in);
        System.out.print("What is the name of your character? ");
        String userName = s.nextLine();

        Scanner role = new Scanner(System.in);
        System.out.print("What is the role of your character (k = knight, w = wizard, b = barbarian)? ");
        String userRole = role.nextLine();

        while (!(userRole.equals("k") || userRole.equals("w") || userRole.equals("b"))) {
            System.out.print("Please input a valid role: ");
            userRole = role.nextLine();
        }

        QuestSimulation newQuest = new QuestSimulation(userName, userRole);
        System.out.print(newQuest.introductionText());

        Scanner answerToQuest = new Scanner(System.in);
        String questAccept = answerToQuest.nextLine();

        while (!(questAccept.equals("y") || questAccept.equals("n"))) {
            System.out.print("Please input a valid answer: ");
            questAccept = answerToQuest.nextLine();
        }

        System.out.println(newQuest.questInitiationText(questAccept));
        System.out.print(newQuest.entranceObstacleText());

        Scanner action = new Scanner(System.in);
        String entranceAction = action.nextLine();

        while (!(entranceAction.equals("1") || entranceAction.equals("2") || entranceAction.equals("3"))) {
            System.out.print("Please input a valid answer: ");
            entranceAction = action.nextLine();
        }

        System.out.println(newQuest.entranceSolutionText(entranceAction));

        if (!newQuest.getGameOver()) {

        }
    }
}
