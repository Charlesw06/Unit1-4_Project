import java.util.Scanner;

public class QuestRunner {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.print("What is the name of your character? ");
        String userName = name.nextLine();

        Scanner role = new Scanner(System.in);
        System.out.print("What is the role of your character (k = knight, w = wizard, b = barbarian)? ");
        String userRole = role.nextLine();

        while (!(userRole.equals("k") || userRole.equals("w") || userRole.equals("b"))) {
            System.out.print("Please input a valid role: ");
            userRole = role.nextLine();
        }

        QuestSimulation newQuest = new QuestSimulation(userName, userRole);
        System.out.print(newQuest.title());
        System.out.print(newQuest.introductionText());

        Scanner answerToQuest = new Scanner(System.in);
        String questAccept = answerToQuest.nextLine();

        while (!(questAccept.equals("y") || questAccept.equals("n"))) {
            System.out.print("Please input a valid answer: ");
            questAccept = answerToQuest.nextLine();
        }

        System.out.println(newQuest.questInitiationText(questAccept));
        System.out.print(newQuest.knowledgeTestObstacle());

        Scanner action = new Scanner(System.in);
        String entranceAction = action.nextLine();

        while (!(entranceAction.equals("1") || entranceAction.equals("2") || entranceAction.equals("3"))) {
            System.out.print("Please input a valid answer: ");
            entranceAction = action.nextLine();
        }

        System.out.println(newQuest.knowledgeTestSolution(entranceAction));

        if (!newQuest.getGameOver()) {
            System.out.print(newQuest.determinationTestObstacle());
            Scanner standUp = new Scanner(System.in);
            String chairChoice = standUp.nextLine();

            for (int attemptNum = 1; attemptNum < 5; attemptNum++) {
                while (!(chairChoice.equals("y") || chairChoice.equals("n"))) {
                    System.out.print("Please input a valid answer: ");
                    chairChoice = standUp.nextLine();
                }
                System.out.print(newQuest.determinationTestSolution(attemptNum));
            }


        }
    }
}
