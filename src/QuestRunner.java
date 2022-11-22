import java.util.Scanner;

public class QuestRunner {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.print("Welcome to the Quest Simulator!\n\nWhat is the name of your character? ");
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
            if (chairChoice.equals("y")) {
                System.out.print(newQuest.getUpResult());
            }

            for (int attemptNum = 1; attemptNum < 5; attemptNum++) {
                while (!(chairChoice.equals("y") || chairChoice.equals("n"))) {
                    System.out.print("Please input a valid answer: ");
                    chairChoice = standUp.nextLine();
                }

                if (!newQuest.getGameOver()) {
                    System.out.print(newQuest.determinationTestDilemma(attemptNum));
                    chairChoice = standUp.nextLine();

                    if (chairChoice.equals("y")) {
                        attemptNum = 6;
                        System.out.print(newQuest.getUpResult());
                    }
                }
            }
        }

        if (!newQuest.getGameOver()) {
            System.out.print(newQuest.determinationTestSolution());
            System.out.print(newQuest.strengthTestObstacle());
            Scanner moveChoice = new Scanner(System.in);

            int turnNum = 1;
            while ((turnNum < 25) && (newQuest.getBossHealth() != 0) && (!newQuest.getGameOver())) {
                System.out.print(newQuest.strengthTestMoveChoice());
                String userMove = moveChoice.nextLine();

                while (!(userMove.equals("1") || userMove.equals("2") || userMove.equals("3"))) {
                    System.out.print("Please input a valid answer: ");
                    userMove = moveChoice.nextLine();
                }
                if (!newQuest.getGameOver()) {
                    System.out.print(newQuest.moveResult(userMove));
                    System.out.print(newQuest.toString());
                }
                turnNum++;
            }
            System.out.print(newQuest.strengthTestSolution());
        }

        if (!newQuest.getGameOver()) {
            System.out.print(newQuest.gettingArtifactText());

            Scanner returnDilemma = new Scanner(System.in);
            System.out.print(newQuest.runAwayDilemma());
            String answer = returnDilemma.nextLine();

            while (!(answer.equals("y") || (answer.equals("n")))) {
                System.out.print("Please input a valid answer: ");
                answer = returnDilemma.nextLine();
            }
            System.out.print(newQuest.runAwaySolution(answer));
        }

        if (!newQuest.getGameOver()) {
            Scanner handOver = new Scanner(System.in);

        }
    }
}
