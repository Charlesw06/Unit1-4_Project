import java.util.concurrent.TimeUnit;

/**
 * The QuestSimulation class represents a QuestSimulation. A QuestSimulation is a quest with a userName, userRole, gameOver, bossHealth, userHealth, useDamage, userMove, and ANSI color escape codes.
 */
public class QuestSimulation {
    private String userName;
    private String userRole;
    private boolean gameOver;
    private int bossHealth = 75;
    private int userHealth = 50;
    private int userDamage;
    private String userMove = "-1";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Constructor for the QuestSimulation class. This constructor creates a new instance of a QuestSimulation given the below parameters.
     *
     * @param userName represents the name of the user playing the QuestSimulation
     * @param userRole represents the role of the user playing the QuestSimulation
     */
    public QuestSimulation(String userName, String userRole) {
        this.userName = ANSI_CYAN + userName + ANSI_BLUE;
        this.userRole = userRole;
        gameOver = false;
    }

    /**
     * Constructor for the QuestSimulation class. This constructor creates a new instance of a QuestSimulation given the below parameters.
     *
     * @param userRole represents the role of the user playing the QuestSimulation
     * @param bossHealth represents the health remaining of the boss in the QuestSimulation
     * @param userHealth represents the health remaining of the user in the QuestSimulation
     */
    public QuestSimulation(String userRole, int bossHealth, int userHealth) {
        this.userRole = userRole;
        this.bossHealth = bossHealth;
        this.userHealth = userHealth;
    }

    /**
     * The sleep method will cause the execution of the code to pause given the amount of time in milliseconds.
     *
     * @param time represents the amount of time to pause for in milliseconds
     */
    public void sleep(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The title method will return a String containing the title of the quest.
     *
     * @return returns a String that contains the title of the quest
     */
    public String title() {
        return ANSI_YELLOW + "\n-=| THE HUNT FOR THE EYE OF DAS |=-\n";
    }

    /**
     * The introductionText method will return a String containing the introduction for the quest.
     *
     * @return returns a String that contains the introduction for the quest.
     */
    public String introductionText() {
        return ANSI_YELLOW + "\n-=| The Invitation |=-\n" + ANSI_BLUE + "\nAs you kneel before Emperor Avalon's throne, he offers you a deal. You can accept\nthe punishment for your crimes or go on his quest. He wants you to retrieve the\n" + ANSI_YELLOW +  "Eye of Das" + ANSI_BLUE + ", which would let him see anywhere in the world.\n\n" + ANSI_RESET + "Do you accept his offer (y = yes, n = no)? ";
    }

    /**
     * The questInitiationText method will return a String containing the quest initiation for the quest depending on userResponse.
     *
     * @param userResponse represents the user's response to the emperor's offer
     * @return returns a String that contains the quest initiation for the quest
     */
    public String questInitiationText(String userResponse) {
        if (userResponse.equals("y")) {
            return ANSI_BLUE + "\nThe emperor grins. He tells you that a horse and supplies are already waiting for\nyou at the gate. Your quest has begun.\n";
        }
        else {
            return ANSI_BLUE + "\nThe emperor glares at you. Everything goes black as the hilt of a guard's sword\nhit your head. When you wake up, you are restrained on a moving wagon. Turns out\nyou didn't have a choice. Your quest has begun.\n";
        }
    }

    /**
     * The knowledgeTestObstacle method will return a String containing the text for the knowledge test obstacle depending on userRole
     *
     * @return returns a String that contains the text for the knowledge test obstacle
     */
    public String knowledgeTestObstacle() {
        String obstacleText;
        if (userRole.equals("k")) {
            obstacleText = "\nYou stand in front of the dim dungeon entrance. Suddenly, a small green figure\nlunges at you from the darkness. You knock it away and draw your sword. A goblin.\nGross. Two more run out the dungeon to face you.\n\n" + ANSI_RESET + "What do you do (1 = attack, 2 = dodge, 3 = whistle): ";
        }
        else if (userRole.equals("w")) {
            obstacleText = "\nYou stand in front of the dim dungeon entrance. As you step closer to the cave,\nyou see a tangle of thorny enchanted vines block the way. Great. The vines creep\ntowards you as if they know you are there.\n\n" + ANSI_RESET + "What do you do (1 = run away, 2 = fireball, 3 = ice breath): ";
        }
        else {
            obstacleText = "\nYou stand in front of the dim dungeon entrance. Walking into the cave, you slam\nface-first into a boulder. Not the smartest move. Then you realize that the boulder\nis a rock giant. It opens its glowing eyes and roars.\n\n" + ANSI_RESET + "What do you do (1 = roar, 2 = shield smash, 3 = axe swing): ";
        }
        return ANSI_YELLOW + "\n-=| The Cave Entrance |=-\n" + ANSI_BLUE + obstacleText;
    }

    /**
     * The knowledgeTestSolution method will return a String containing the text for the knowledge test solution depending on userRole and userAction.
     *
     * @param userAction represents action of the user during the test of knowledge
     * @return returns a String that contains the text for the knowledge test solution
     */
    public String knowledgeTestSolution(String userAction) {
        String resultText;
        if (userAction.equals("1")) {
            gameOver = true;
            if (userRole.equals("k")) {
                return ANSI_BLUE + "\nYou slash clean through the first goblin. As you turn around, your thigh starts\nburning. A poison dagger. Didn't you listen to the training lesson last week? Your\nvision blurs and you fall to the ground.\n\n" + ANSI_CYAN + "You achieved ending #1 of 12: THAT STINGS\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (userRole.equals("w")) {
                return ANSI_BLUE + "\nThe vines grow faster and faster. You turn to run away, but or some dumb reason, you\ndecided to wear a long cloak on this quest. It gets snagged on a thorn and you trip,\nallowing the vines to wrap you up and drag you into the lair.\n\n" + ANSI_CYAN + "You achieved ending #2 of 12: BLAME IT ON THE WARDROBE\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                return ANSI_BLUE + "\nYou let out an ear-splitting roar. Instead of cowering, the giant stands to its full\nheight, three times your size. Turns out rock giants are are not easily intimidated.\nIt brings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_CYAN + "You achieved ending #3 of 12: HOLD UP - THAT'S NOT A ROCK\n\n" + ANSI_RED + "GAME OVER";
            }
        }
        else if (userAction.equals("2")) {
            gameOver = true;
            if (userRole.equals("k")) {
                return ANSI_BLUE + "\nYou fail to avoid the first goblin's attack. Turns out dodging with tons of armor on\nis not the best idea. You feel a knife stab into your back. Then two more. The\ngoblins drag you into the cave to loot you.\n\n" + ANSI_CYAN + "You achieved ending #4 of 12: NOT MY GOLD\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (userRole.equals("w")) {
                return ANSI_BLUE + "\nThe vines grow faster and faster. You slam your staff on the floor and throw a\nfireball into the vines. Surprisingly, it has no effect. Apparently, the enchants\naccounted for fire. The vines drag you into its lair.\n\n" + ANSI_CYAN + "You achieved ending #5 of 12: DANG ENCHANTS\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                return ANSI_BLUE + "\nYou charge at the giant shield-first. Your shield shatters on impact and the giant\nbrings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_CYAN + "You achieved ending #6 of 12: WEAK SHIELD\n\n" + ANSI_RED + "GAME OVER";
            }
        }
        else {
            if (userRole.equals("k")) {
                resultText = "\nYou side-step a goblin and take out a whistle. The ear-splitting screech forces them\nto cover their ears and escape into the forest. You grab a poison dagger that one of\nthem dropped and walk into the dungeon.";
            }
            else if (userRole.equals("w")) {
                resultText = "\nThe vines grow faster and faster. Whispering an incantation, you blow out icy mist.\n Cracks form in the vines and they crumble to pieces. You kick aside the remaining\nvines and descend into the dungeon.";
            }
            else {
                resultText = "\nYou take out an axe and swing it at the giant's chest. It hits the weak point, a\ncrystal that gives the giant life. Pure luck if you ask me. The giant collapses and you\ncontinue further into the cave.";
            }
        }
        return ANSI_BLUE + resultText + "\n\nA booming voice echoes from the cave. " + ANSI_GREEN + "\"YOU HAVE PASSED THE TEST OF KNOWLEDGE.\"\n";
    }

    /**
     * The determinationTestObstacle method will return a String containing the text for the determination test obstacle.
     *
     * @return returns a String that contains the text for the determination test obstacle
     */
    public String determinationTestObstacle() {
        return ANSI_YELLOW + "\n-=| The Chamber |=-\n" + ANSI_BLUE + "\nYou enter a dark chamber. Light shines down on a stone chair in the center of the\nroom. You sit on the throne despite your instincts telling you otherwise. You start\nto hear whispers in the shadows." + ANSI_RESET + "\n\nDo you get up (y = yes, n = no): ";
    }

    /**
     * The determinationTestDilemma method will return a String containing the text for the determination test dilemma stage depending on stageNum.
     *
     * @param stageNum represents how what stage of the determination test the user is on
     * @return returns a String that contains the text for the determination test dilemma stage
     */
    public String determinationTestDilemma(int stageNum) {
        String text = "";
        if (stageNum == 1) {
            text = "\nThe whispers start to form into words. \"" + userName + "...\"";
        }
        else if (stageNum == 2) {
            text = "\nThe voices become louder. \"Give in " + userName + ".\"";
        }
        else if (stageNum == 3) {
            text = "\nYou feel a burning sensation as a shadowy hand grips your leg.";
        }
        else if (stageNum == 4) {
            text = "\nMore hands wrap around you, starting to bind you to the chair. This could be your\nlast chance to escape.";
        }
        return ANSI_BLUE + text + ANSI_RESET + "\n\nDo you get up (y = yes, n = no): ";
    }

    /**
     * The getUpResult method will return a String containing the text for getting out of the chair during the determination test.
     *
     * @return returns a String that contains the text for getting out of the chair during the determination test
     */
    public String getUpResult() {
        gameOver = true;
        return ANSI_BLUE + "\nAs you stand up the light goes out and the whispers get louder. Eventually, the\nwhispers break your mind and you are engulfed in madness.\n\n" + ANSI_CYAN + "You achieved ending #7 of 12: LOST TO THE DARKNESS" + ANSI_RED + "\n\nGAME OVER";
    }

    /**
     * The determinationTestSolution method will return a String containing the text for the determination test solution.
     *
     * @return returns a String that contains the text for the determination test solution
     */
    public String determinationTestSolution() {
        return ANSI_BLUE + "\nThe hands start to cover your body, but the light burns them, forcing them to\nwithdraw. A door opens on the other side of the chamber. You get up and walk to\nthe doorway with shaky legs.\n\nThe booming voice speaks up again, seeming to come from the door. " + ANSI_GREEN + "\"YOU HAVE PASSED\nTHE TEST OF DETERMINATION.\"\n";
    }

    /**
     * The strengthTestObstacle method will return a String containing the text for the strength test obstacle.
     *
     * @return returns a String that contains the text for the strength test obstacle
     */
    public String strengthTestObstacle() {
        String text = "\nAfter you stepping through the doorway, you enter a large crystal cavern. The\nCrepice, a legendary giant diamond spider, rests in the center. It opens its shining\neyes and lets out a terrifying screech. It wants to fight.";
        return ANSI_YELLOW + "\n-=| The Beast |=-\n" + ANSI_BLUE + text;
    }

    /**
     * The strengthTestMoveChoice method will return a String containing the text for the possible move choices depending on userRole
     *
     * @return returns a String that contains the text for the possible move choices
     */
    public String strengthTestMoveChoice() {
        String moveOptions = "\n\nWhat is your move ";
        if (userRole.equals("k")) {
            moveOptions += "(1 = poison dagger throw, 2 = sword slash, 3 = shield): ";
        }
        else if (userRole.equals("w")) {
            moveOptions += "(1 = acid spray, 2 = lightning bolt, 3 = magic barrier): ";
        }
        else {
            moveOptions += "(1 = spiked club bash, 2 = axe slash, 3 = shield): ";
        }
        return ANSI_RESET + moveOptions;
    }

    /**
     * The moveResult method will return a String containing the text for the result of a turn depending on userMove and bossMove.
     *
     * @param userMove represents the move that the user made during their turn
     * @return returns a String containing the text for the result of a turn
     */
    public String moveResult(String userMove) {
        int bossMove = (int) (Math.random() * 2);
        userDamage(userMove);
        this.userMove = userMove;
        if ((bossMove == 0) && !(userMove.equals("3"))) {
            bossHealth -= userDamage;
            userHealth -= 5;
            if (userRole.equals("k")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider knocks you over, but you stab your dagger into one of its legs.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches crystals at you. One hits you. You stab into the spider's\narmored body.";
                }
            }
            if (userRole.equals("w")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider knocks you over, but you raise your staff to spray it with acid.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches crystals at you. One hits you. You strike the creature with\na lightning bolt.";
                }
            }
            if (userRole.equals("b")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider knocks you over, but you bash the crystal armor with your club.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches crystals at you. One hits you. You hack into its body with a\nheavy swing of your axe.";
                }
            }
        }
        if ((bossMove == 0) && userMove.equals("3")) {
            return ANSI_BLUE + "\nAs you protect yourself, one of the Crepice's legs pushes you down. You stand up\nto face the beast.";
        }
        if (!userMove.equals("3")) {
            bossHealth -= userDamage;
            return ANSI_BLUE + "\nYou attack and the creature roars in pain. It misses its counterstrike as you jump\nto the side.";
        }
        return ANSI_BLUE + "\nYou get ready to protect yourself, but the Crepice does not attack to store energy.";
    }

    /**
     * The outOfStamina method returns a String containing the text for the user taking too many turns during the strength test.
     *
     * @return returns a String that contains the text for the user taking too many turns
     */
    public String outOfStamina() {
        gameOver = true;
        return ANSI_BLUE + "\nYou start feeling tired from the battle. You collapse from exhaustion.\n\n" + ANSI_CYAN + "You achieved ending #8 of 12: TOO TIRED" + ANSI_RED + "\n\nGAME OVER\n";
    }

    /**
     * The strengthTestSolution method returns a String containing the text for the end of the strength test depending on userRole, gameOver, and userMove.
     *
     * @return returns a String that contains the text for the end of the strengthTest
     */
    public String strengthTestSolution() {
        if (gameOver) {
            return ANSI_BLUE + "\n\nThe Crepice launches itself at you. You are knocked off your feet and the Crepice\nuses this opportunity to show off the sharpness of its pincers.\n\n" + ANSI_CYAN + "You achieved ending #9 of 12: THE BEAST'S DINNER" + ANSI_RED + "\n\nGAME OVER";
        }
        String winText = "";
        if (userRole.equals("k")) {
            if (userMove.equals("1")) {
                winText = ANSI_BLUE + "\n\nYou throw your poison dagger into a weak point under its stomach. The spider\ncollapses as the poison spreads through its body.";
            }
            if (userMove.equals("2")) {
                winText = ANSI_BLUE + "\n\nYou throw your sword into a weak point under its stomach. The spider collapses as\nthe blade slices straight through its body.";
            }
        }
        if (userRole.equals("w")) {
            if (userMove.equals("1")) {
                winText = ANSI_BLUE + "\n\nYou throw a ball of acid into a weak point under its stomach. The spider collapses\nas the its body burns from the inside.;";
            }
            if (userMove.equals("2")) {
                winText = ANSI_BLUE + "\n\nYou throw a lightning bolt into a weak point under its stomach. The spider\ncollapses as the blade slices straight through its body.";
            }
        }
        if (userRole.equals("b")) {
            if (userMove.equals("1")) {
                winText = ANSI_BLUE + "\n\nYou smash your club into a weak point under its stomach. The spider collapses\nas the its body burns from the inside.;";
            }
            if (userMove.equals("2")) {
                winText = ANSI_BLUE + "\n\nYou throw your axe into a weak point under its stomach. The spider collapses\nas the blade slices straight through its body.";
            }
        }
        return winText + "\n\nThe voice echoes through the cavern. " + ANSI_GREEN + "\"YOU HAVE PASSED THE TEST OF STRENGTH.\"" + ANSI_BLUE + " It\nadds something else this time. "+ ANSI_GREEN + "\"JOIN ME TO RECEIVE YOUR REWARD.\" " + ANSI_BLUE + "A light flashes\nand you are transported out of the cave.";
    }

    /**
     * The gettingArtifactText method returns a String containing the text for the user obtaining the artifact.
     *
     * @return returns a String that contains the text for the user obtaining the artifact
     */
    public String gettingArtifactText() {
        String text = "\nYou stand in an open clearing. In the center, a ring with an emerald eye rests on a\npedestal. The " + ANSI_YELLOW + "Eye of Das" + ANSI_BLUE + ". A cloaked figure steps out of the trees. He Who Sees All:\nSorcerer Das. He snaps and the ring floats into your hands. A wave of light\ntransports you out of the dungeon.";
        return ANSI_YELLOW + "\n\n-=| He Who Sees All |=-\n" + ANSI_BLUE + text;
    }

    /**
     * The runAwayDilemma method returns a String containing the text for the runaway dilemma.
     *
     * @return returns a String that contains the text for the runaway dilemma
     */
    public String runAwayDilemma() {
        String text = "\nYou walk to your horse getting ready to return to the king until a thought enters\nyour mind. Does the emperor deserve this power? He did not endure the trials himself." + ANSI_RESET + "\n\nReturn to kingdom (y = return to kingdom, n = run away with artifact)? ";
        return ANSI_YELLOW + "\n\n-=| The Final Dilemma |=-\n" + ANSI_BLUE + text;
    }

    /**
     * The runAwaySolution method returns a String containing the text for the result for the runaway dilemma depending on userAction
     *
     * @param userAction represent the user's response to the runaway dilemma
     * @return returns a String that contains the text for the solution for the result for the runaway dilemma
     */
    public String runAwaySolution(String userAction) {
        if (userAction.equals("y")) {
            return ANSI_BLUE + "\nYou return to the kingdom where the emperor awaits you with his personal guards.\n\"I see you have acquired the artifact.\" He stretches out his hand. \"Bring it to\nme and you shall be free.\"" + ANSI_RESET + "\n\nDo you step forward (y = step forward, n = remain on horse)? ";
        }
        gameOver = true;
        return ANSI_BLUE + "\nYou take off the other direction. Over the next few years, you learn the secrets of\nthe " + ANSI_YELLOW + "Eye of Das" + ANSI_BLUE + " and become the artifact's new guardian. Eventually, you find a\ncavern to set up a new dungeon, waiting for a new hero to take up your place." + ANSI_CYAN + "\n\nYou achieved ending #10 of 12: THE ENDLESS CYCLE" + ANSI_GREEN + "\n\nYou finished the game!";
    }

    /**
     * The handOVerSolution method returns a String containing the text for the result of the user's handover decision depending on userAction.
     *
     * @param userAction represents the user's response to the handover dilemma
     * @return returns a String that contains the text for the result of the user's handover decision
     */
    public String handOverSolution(String userAction) {
        gameOver = true;
        if (userAction.equals("y")) {
            return ANSI_BLUE + "\nYou step forward to hand over the ring. You see the greed in his eyes as admires\nit. In the years ahead, he increases his control over the kingdom with his new\npower. The kingdom may be safe, but Emperor Avalon rules with an iron fist." + ANSI_CYAN + "\n\nYou achieved ending #11 of 12: THE IRON RULER" + ANSI_GREEN + "\n\nYou finished the game!";
        }
        return ANSI_BLUE + "\nThe emperor grows impatient and orders his guards to surround you. Knowing you can't\nafford to be captured, you snap the horse's reigns and speed away. The king's\nyells quickly fade away. You spend the next years on the run to find a trustworthy\nwizard to guard the ring." + ANSI_CYAN + "\n\nYou achieved ending #12 of 12: FOREVER ON THE RUN" + ANSI_GREEN + "\n\nYou finished the game!";
    }

    /**
     * The getGameOver method returns a boolean containing a value that represents if the quest is over using gameOver.
     *
     * @return returns gameOver, a boolean that contains a value representing if the game is over
     */
    public boolean getGameOver() {
        return gameOver;
    }

    /**
     * The getBossHealth method returns an integer that represents the health of the boss using bossHealth.
     *
     * @return returns bossHealth, an integer that contains a value representing the boss' health
     */
    public int getBossHealth() {
        return bossHealth;
    }

    /**
     * The userDamage uses Math.random() to calculate the damage done by the user depending on move.
     *
     * @param move represents the move made by the user during the strength test
     */
    public void userDamage(String move) {
        int damage = 0;
        if (move.equals("1")) {
            damage = (int) (Math.random() * 3) + 2;
        }
        if (move.equals("2")) {
            damage = (int) (Math.random() * 3) + 5;
        }
        userDamage = damage;
    }

    /**
     * toString method for the QuestSimulation class. This method will return a String showing the userHealth and bossHealth in proper format.
     *
     * @return returns a String properly formatted to include userHealth and bossHealth
     */
    public String toString() {
        if (userHealth < 0) {
            userHealth = 0;
        }
        if (bossHealth < 0) {
            bossHealth = 0;
        }
        if (userHealth == 0) {
            gameOver = true;
        }
        return ANSI_BLUE + "\nYour health: " + userHealth + ", Boss Health: " + bossHealth;
    }
}