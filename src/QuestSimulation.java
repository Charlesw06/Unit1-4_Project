import java.io.*;
public class QuestSimulation {
    private String name;
    private String role;
    private boolean gameOver;
    private int bossHealth = 75;
    private int userHealth = 50;
    private int userDamage;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public QuestSimulation(String userName, String userRole) {
        name = ANSI_CYAN + userName + ANSI_BLUE;
        role = userRole;
        gameOver = false;
    }

    public QuestSimulation(String userRole, int bossHealth, int userHealth) {
        role = userRole;
        this.bossHealth = bossHealth;
        this.userHealth = userHealth;
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
                return ANSI_BLUE + "\nYou slash at the first goblin and the blade goes clean through. As you turn around face the others,\nyou feel a burning sensation in your thigh. A poison dagger. Didn't you listen during the knight\ntraining lesson last week? Your vision blurs and you fall to the ground.\n\n" + ANSI_CYAN + "You achieved ending #1 of 12: THAT STINGS\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (role.equals("w")) {
                return ANSI_BLUE + "\nThe vines grow faster and faster. Out of instinct, you turn to run away. For some dumb reason, you\nhave decided to wear a long cloak on this quest. Your cloak gets snagged on a thorn and you trip,\ngiving the vines time to wrap you up and drag you deep into its lair.\n\n" + ANSI_CYAN + "You achieved ending #2 of 12: BLAME IT ON THE WARDROBE\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                return ANSI_BLUE + "\nThe rock giant's eyes glow with a burning anger. You let out an ear-splitting roar. Instead of cowering,\nthe giant stands to its full height, around three times your size. Turns out rock giants are\nare not easily intimidated. It brings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_CYAN + "You achieved ending #3 of 12: HOLD UP - THAT'S NOT A ROCK\n\n" + ANSI_RED + "GAME OVER";
            }
        }
        else if (userAction.equals("2")) {
            gameOver = true;
            if (role.equals("k")) {
                return ANSI_BLUE + "\nYou hop to the side to avoid the first goblin's attack, but you are too slow. Turns out jumping with\ntons of armor on is not the best idea. You feel a knife stab into your back. Then another. And\nanother. The goblins drag you into the cave so they can loot you properly.\n\n" + ANSI_CYAN + "You achieved ending #4 of 12: NOT MY GOLD\n\n" + ANSI_RED + "GAME OVER";
            }
            else if (role.equals("w")) {
                return ANSI_BLUE + "\nThe vines grow faster and faster. Yelling an ancient chant, you slam your staff onto the cave floor and\na ball of fire is fired towards th vines. Surprisingly, it has no effect. Apparently, the\nenchants account for fire. The vines wrap you up and drag you deep into its lair.\n\n" + ANSI_CYAN + "You achieved ending #5 of 12: DANG ENCHANTS\n\n" + ANSI_RED + "GAME OVER";
            }
            else {
                return ANSI_BLUE + "\nThe rock giant's eyes glow with a burning anger. You charge at the beast shield-first. Your shield\nshatters on impact and the giant pushes you back. I honestly don't know what you were expecting.\nThe rock giant brings down a massive stone arm on your head, crushing you instantly.\n\n" + ANSI_CYAN + "You achieved ending #6 of 12: WEAK SHIELD\n\n" + ANSI_RED + "GAME OVER";
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
        return ANSI_BLUE + resultText + "\n\nA booming voice echoes from the cave. \"YOU HAVE PASSED THE TET OF KNOWLEDGE.\"";
    }

    public String determinationTestObstacle() {
        return ANSI_YELLOW + "\n-=| The Chamber |=-\n" + ANSI_BLUE + "\nYou enter a dark chamber. The only light comes from a hole in the ceiling that shines down on a crude\nstone throne. After some time, you sit on the throne despite your instincts telling you otherwise. You\nstart to hear whispers in the shadows." + ANSI_RESET + "\n\nDo you get up (y = yes, n = no): ";
    }

    public String determinationTestDilemma(int attemptNum) {
        String text = "";
        if (attemptNum == 1) {
            text = "\nThe whispers start to form into words. \"" + name + "...\"";
        }
        else if (attemptNum == 2) {
            text = "\nThe voices become louder. \"Give in " + name + ".\"";
        }
        else if (attemptNum == 3) {
            text = "\nA burning sensation runs through your body as a shadowy hand grips your leg. The voice continue to\nwhisper your name.";
        }
        else if (attemptNum == 4) {
            text = "\nMore hands and arms wrap around you, starting to bind you to the chair. This could be your last chance\nto escape.";
        }
        return ANSI_BLUE + text + ANSI_RESET + "\n\nDo you get up (y = yes, n = no): ";
    }

    public String getUpResult() {
        gameOver = true;
        return ANSI_BLUE + "\nAs you stand up, shadowy hands grab you. The light goes out and you start to feel like you are being\nwatched. Thousands of glowing white ghoul eyes fixate on you. It is only a matter of minutes before\nyou become one of them, mind broken from being lost in the dark.\n\n" + ANSI_CYAN + "You achieved ending #7 of 12: LOST IN THE DARK" + ANSI_RED + "\n\nGAME OVER";
    }

    public String determinationTestSolution() {
        return ANSI_BLUE + "\nAs the hands are starting cover your body, you start to smell burning flesh. The hands develop burn\nmarks and withdraw from your body. The light was burning the hands of the shadows. A door opens on the\nother side of the chamber. You get up from the chair and walk to the doorway with shaky legs.\n\nThe booming speaks up again, even louder than last time. It seems to come from the door.\n\"YOU HAVE PASSED THE TEST OF DETERMINATION.\"\n";
    }

    public String strengthTestObstacle() {
        String text = "\nAfter taking a shaky breath, you step through the doorway. You are standing in a large crystal cavern.\nYour heart skips a beat as you see the creature resting in the center. The Crepice, a legendary giant\nspider encrusted with a layer of diamonds. The beast opens its shining eyes and lets out a terrifying\nscreech. It wants to fight.";
        return ANSI_YELLOW + "\n-=| The Beast |=-\n" + ANSI_BLUE + text;
    }

    public String strengthTestMoveChoice() {
        String moveOptions = "\n\nWhat is your move ";
        if (role.equals("k")) {
            moveOptions += "(1 = poison dagger throw, 2 = sword slash, 3 = shield): ";
        }
        else if (role.equals("w")) {
            moveOptions += "(1 = acid spray, 2 = lightning bolt, 3 = magic barrier): ";
        }
        else {
            moveOptions += "(1 = spiked club bash, 2 = axe slash, 3 = shield): ";
        }
        return ANSI_RESET + moveOptions;
    }

    public String moveResult(String userMove) {
        int bossMove = (int) (Math.random() * 2);
        userDamage(userMove);
        if ((bossMove == 0) && !(userMove.equals("3"))) {
            bossHealth -= userDamage;
            userHealth -= 5;
            if (role.equals("k")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider swipes a leg at you. It knocks you over, but you are able to stab your dagger\ninto the leg as it passes.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches a spiky crystals at you. One hits you. You stab into a chink in the spider's\narmored body.";
                }
            }
            if (role.equals("w")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider swipes a leg at you. It knocks you over, but you are able to raise your staff\nand spray the Crepice with acid.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches a spiky crystals at you. One hits you. However, you are able to concentrate\nenough to strike the creature with a lightning bolt.";
                }
            }
            if (role.equals("b")) {
                if (userMove.equals("1")) {
                    return ANSI_BLUE + "\nThe giant spider swipes a leg at you. It knocks you over, but you are able to bash the crystal\narmor with your club, taking off a small chunk.";
                }
                if (userMove.equals("2")) {
                    return ANSI_BLUE + "\nThe Crepice launches a spiky crystals at you. One hits you. You hack into a chink in the\nspider's armored body with a heavy swing of your axe.";
                }
            }
        }
        if ((bossMove == 0) && userMove.equals("3")) {
            return ANSI_BLUE + "\nAs you protect yourself, you feel the impact of one of the Crepice's legs push you back. You roll to\nthe side to avoid getting crushed and stand up to face the beast.";
        }
        if (!userMove.equals("3")) {
            bossHealth -= userDamage;
            return ANSI_BLUE + "\nYou launch your attack making the creature roar in pain. It misses its counterstrike as you jump\nto the side.";
        }
        return ANSI_BLUE + "\nYou get ready to protect yourself, but the Crepice does not make a move. It seems to be storing energy.";
    }

    public String outOfStamina() {
        gameOver = true;
        return ANSI_BLUE + "\nYou feel yourself getting tired from the battle. After a few more strikes from the beast, you collapse\nfrom exhaustion. You are knocked out at your head hits a crystal poking out of the ground.\n\n" + ANSI_CYAN + "You achieved ending #8 of 12: TOO TIRED" + ANSI_RED + "\n\nGAME OVER";
    }
    public String strengthTestSolution() {
        if (gameOver) {
            return ANSI_BLUE + "\n\nThe Crepice launches itself at you. You manage to block the first leg swipe but a second one swipes\nyou off your feet. The Crepice uses this opportunity to show off the sharpness of its pincers.\n\n" + ANSI_CYAN + "You achieved ending #9 of 12: THE BEAST'S DINNER" + ANSI_RED + "\n\nGAME OVER";
        }
        String winText = "";
        if (role.equals("k")) {
            winText = ANSI_BLUE + "\n\nDodging another swipe from the Crepice, you find its weak point, under its stomach. Mustering all\nyour strength, you chuck your poison dagger into the gap in the armor. The spider collapses as\nthe poison spreads through its body.";
        }
        if (role.equals("w")) {
            winText = ANSI_BLUE + "\n\nDodging another swipe from the Crepice, you find its weak point, under its stomach. Mustering all\nyour strength, focus a ball of fire into the gap in the armor. The spider collapses as the its\nbody burns from the inside.\";";
        }
        if (role.equals("b")) {
            winText = ANSI_BLUE + "\n\nDodging another swipe from the Crepice, you find its weak point, under its stomach. Mustering all\nyour strength, you chuck your axe into the gap in the armor. It collapses as the weapon slices\nright through its body.";
        }
        return winText + "\n\nThe booming voice echoes through the crystal cavern. \"YOU HAVE PASSED THE TEST OF STRENGTH.\" This\ntime, it adds something else. \"JOIN ME AND REVIECE YOUR REWARD.\" Suddenly, a bright light flashes\nand you feel your body being transported out of the cave.";
    }

    public String gettingArtifactText() {
        String text = "\nAfter your eyes adjust, you see that you are standing in an open clearing. In the center, an eyeball\ncarved out of emerald stands on a golden pedestal. The " + ANSI_YELLOW + "Eye of Das" + ANSI_BLUE + ". A figure steps out from the trees.\nHe Who Sees All. Sorcerer Das. He silently waves his hand and the artifact floats into your hands.\nAnother wave of light transports you back to the entrance of the dungeon.";
        return ANSI_YELLOW + "\n\n-=| He Who Sees All |=-\n" + ANSI_BLUE + text;
    }

    public String runAwayDilemma() {
        String text = "\nYou walk over to your horse getting ready to return to the king with the artifact until a nagging\nthought enters your mind. Does Emperor Avalon really deserve this power? He did not endure the\ntrials himself." + ANSI_RESET + "\n\nReturn to kingdom (y = return to kingdom, n = run away with artifact)? ";
        return ANSI_YELLOW + "\n\n-=| The Final Dilemma |=-\n" + ANSI_BLUE + text;
    }

    public String runAwaySolution(String userAction) {
        if (userAction.equals("y")) {
            return ANSI_BLUE + "\nYou return to the kingdom where the emperor awaits you with his personal guards. \"I see you have acquired\nthe artifact.\" He stretches out his hand. \"Bring it to me and you shall be free.\"" + ANSI_RESET + "\n\nDo you step forward (y = step forward, n = remain on horse)? ";
        }
        gameOver = true;
        return ANSI_BLUE + "\nYou take off the other direction. Over the next few years, you learn the secrets of the " + ANSI_YELLOW + "Eye of Das" + ANSI_BLUE + " and\nbecome the artifact's next guardian. The next Sorcerer Das. Eventually, you find a cavern to set up a\nnew dungeon, waiting for a new hero to take up your place." + ANSI_CYAN + "\n\nYou achieved ending #10 of 12: THE ENDLESS CYCLE" + ANSI_GREEN + "\n\nYou finished the game!";
    }

    public String handOverSolution(String userAction) {
        gameOver = true;
        if (userAction.equals("y")) {
            return ANSI_BLUE + "\nYou get off your horse and hand over the artifact. You can see the greed in his eyes as he signals one of\nhis guards to toss you a pouch of gold as extra compensation. In the following years, the emperor\nincreases his control over the kingdom with his new incredible power. The people of the kingdom may be\nsafe, but Emperor Avalon rules the following era with an iron fist." + ANSI_CYAN + "\n\nYou achieved ending #11 of 12: THE IRON RULER" + ANSI_GREEN + "\n\nYou finished the game!";
        }
        return ANSI_BLUE + "\nThe emperor grows impatient when he notices your hesitancy. He orders his guards to surround you. Knowing that\nyou can't afford to be captured again, you snap your horse's reigns and speed away from the gate.\nYou hear the king's yelling at you, but his demands quickly fade away. You spend the next few years\non the run until you find a trustworthy wizard to guard the artifact." + ANSI_CYAN + "\n\nYou achieved ending #12 of 12: FOREVER ON THE RUN" + ANSI_GREEN + "\n\nYou finished the game!";
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public int getBossHealth() {
        return bossHealth;
    }

    public void userDamage(String move) {
        int damage = 0;
        if (move.equals("1")) {
            damage = (int) (Math.random() * 3) + 3;
        }
        if (move.equals("2")) {
            damage = (int) (Math.random() * 3) + 6;
        }
        userDamage = damage;
    }

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