import java.util.Scanner;

public class QuestRunner {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.print("Welcome to the Quest Simulator!\n\nWhat is your name? ");
        String userName = name.nextLine();

        Scanner role = new Scanner(System.in);
        System.out.print("What is your role (k = knight, w = wizard, b = barbarian)? ");
        String userRole = role.nextLine();

        while (!(userRole.equals("k") || userRole.equals("w") || userRole.equals("b"))) {
            System.out.print("Please input a valid role: ");
            userRole = role.nextLine();
        }

        QuestSimulation newQuest = new QuestSimulation(userName, userRole);
        System.out.print(newQuest.title());
        newQuest.sleep(1000);
        System.out.print(newQuest.introductionText());

        Scanner answerToQuest = new Scanner(System.in);
        String questAccept = answerToQuest.nextLine();

        while (!(questAccept.equals("y") || questAccept.equals("n"))) {
            System.out.print("Please input a valid answer: ");
            questAccept = answerToQuest.nextLine();
        }

        System.out.print(newQuest.questInitiationText(questAccept));
        newQuest.sleep(2000);
        System.out.print(newQuest.knowledgeTestObstacle());

        Scanner action = new Scanner(System.in);
        String entranceAction = action.nextLine();

        while (!(entranceAction.equals("1") || entranceAction.equals("2") || entranceAction.equals("3"))) {
            System.out.print("Please input a valid answer: ");
            entranceAction = action.nextLine();
        }

        System.out.print(newQuest.knowledgeTestSolution(entranceAction));

        if (!newQuest.getGameOver()) {
            newQuest.sleep(2000);
            System.out.print(newQuest.determinationTestObstacle());
            Scanner standUp = new Scanner(System.in);
            String chairChoice = standUp.nextLine();
            if (chairChoice.equals("y")) {
                System.out.print(newQuest.getUpResult());
            }

            for (int stageNum = 1; stageNum < 5; stageNum++) {
                while (!(chairChoice.equals("y") || chairChoice.equals("n"))) {
                    System.out.print("Please input a valid answer: ");
                    chairChoice = standUp.nextLine();
                }

                if (!newQuest.getGameOver()) {
                    System.out.print(newQuest.determinationTestDilemma(stageNum));
                    chairChoice = standUp.nextLine();

                    if (chairChoice.equals("y")) {
                        stageNum = 6;
                        System.out.print(newQuest.getUpResult());
                    }
                }
            }
        }

        QuestSimulation newBattle = new QuestSimulation(userRole, 75, 50);

        if (!newQuest.getGameOver()) {
            System.out.print(newQuest.determinationTestSolution());
            newQuest.sleep(2000);
            System.out.print(newQuest.strengthTestObstacle());
            Scanner moveChoice = new Scanner(System.in);

            int turnNum = 1;
            while ((turnNum < 25) && (newBattle.getBossHealth() != 0) && (!newBattle.getGameOver())) {
                System.out.print(newQuest.strengthTestMoveChoice());
                String userMove = moveChoice.nextLine();

                while (!(userMove.equals("1") || userMove.equals("2") || userMove.equals("3"))) {
                    System.out.print("Please input a valid answer: ");
                    userMove = moveChoice.nextLine();
                }

                System.out.print(newBattle.moveResult(userMove));
                System.out.print(newBattle.toString());
                turnNum++;
            }

            if (turnNum >= 25) {
                System.out.print(newBattle.outOfStamina());
            }
            else {
                System.out.print(newBattle.strengthTestSolution());
            }
        }

        if (!newBattle.getGameOver() && !newQuest.getGameOver()) {
            newQuest.sleep(2000);
            System.out.print(newQuest.gettingArtifactText());

            Scanner returnDilemma = new Scanner(System.in);
            newQuest.sleep(2000);
            System.out.print(newQuest.runAwayDilemma());
            String returnToKingdom = returnDilemma.nextLine();

            while (!(returnToKingdom.equals("y") || (returnToKingdom.equals("n")))) {
                System.out.print("Please input a valid answer: ");
                returnToKingdom = returnDilemma.nextLine();
            }
            System.out.print(newQuest.runAwaySolution(returnToKingdom));
        }

        if (!newBattle.getGameOver() && !newQuest.getGameOver()) {
            Scanner handOver = new Scanner(System.in);
            String handOverArtifact = handOver.nextLine();

            while (!(handOverArtifact.equals("y") || (handOverArtifact.equals("n")))) {
                System.out.print("Please input a valid answer: ");
                handOverArtifact = handOver.nextLine();
            }
            System.out.print(newQuest.handOverSolution(handOverArtifact));
        }
    }
}
