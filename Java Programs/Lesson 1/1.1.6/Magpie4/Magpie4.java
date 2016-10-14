/**
 * A program to carry on conversations with a human user.
 * This version:
 *      Uses advanced search for keywords 
 *      Will transform statements as well as react to keywords
 * 
 * Original:
 * @author Laurie White
 * @version April 2012
 *
 * Edited:
 * @author Otakar Andrysek
 * @date 10/13/16
 * @version 4.2
 */

public class Magpie4
{
    // Emotional Variables (1 to 3)
    public static int happiness = ((int)(Math.random() * 3) + 1);
            // 3 = happy, 2 = content, 1 = sad
    public static int affection = ((int)(Math.random() * 3) + 1);
            // 3 = lover, 2 = friend, 1 = stranger
    public static int anger = ((int)(Math.random() * 3) + 1);
            // 3 = furious, 2 = annoyed, 1 = passive
    
            // Get a default greeting
    public String getGreeting()
    {      
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * @param statement - the user statement
     * @return - a response based on the rules given
     */
    public String getResponse(String statement)
    {
        // User entered string
        String response = "";
        
        // Main program code that calls other functions to preform actions
        if (statement.length() == 0)
        {
            response = "Say something, please.";
            
            // Randomly change stats
            changeEmotion();
        }

        // Tell the user how magpie is doing (emotionally)
        else if (statement.indexOf("how are you") >= 0)
        {
            String r1 = "";
            String r2 = "";
            String r3 = "";
            if (happiness == 1)
            {
                r1 = "I'm sad, ";
            }
            else if (happiness == 2)
            {
                r1 = "I'm content, ";
            }
            else if (happiness == 3)
            {
                r1 = "I'm happy, ";
            }
            
            if (affection == 1)
            {
                r2 = "you're a creep, ";
            }
            else if (affection == 2)
            {
                r2 = "you're my friend, ";
            }
            else if (affection == 3)
            {
                r2 = "i'm in love with you, ";
            }
            
            if (anger == 1)
            {
                r3 = "and I feel relaxed.";
            }
            else if (anger == 2)
            {
                r3 = "and I'm tense.";
            }
            else if (anger == 3)
            {
                r3 = "and I'm pissed off.";
            }
            
            // Combine the three 'stats' and return to user
            response = r1 + r2 + r3;
            happiness = increaseHappiness(happiness);
        }
        
        else if (findKeyword(statement, "no") >= 0
                || findKeyword(statement, "bad") >= 0
                || findKeyword(statement, "terrible") >= 0)
        {
            response = "Why so negative?";
            
            // Seems like a good time to become more angry
            happiness = decreaseHappiness(happiness);
            affection = decreaseAffection(affection);
            anger = increaseAnger(anger);
        }
        
        else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
            
            // Increase affection and happiness, decrease anger
            happiness = increaseHappiness(happiness);
            affection = increaseAffection(affection);
            anger = decreaseAnger(anger);
        }

        else if (statement.indexOf("sister") >= 0)
        {
            response = "Sisters are always like that.";
            
            affection = increaseAffection(affection);
        }
        else if (statement.indexOf("cat") >= 0
                || statement.indexOf("dog") >= 0)
        {
            response = "Tell me more about your pets.";
            
            happiness = increaseHappiness(happiness);
        }
        else if (statement.indexOf("Mr.") >= 0)
        {
            response = "He sounds like a good teacher.";
            
            anger = decreaseAnger(anger);
        }
        
        else if (statement.indexOf("Mrs.") >= 0
                || statement.indexOf("Ms.") >= 0)
        {
            response = "She sounds like a good teacher.";
            
            anger = decreaseAnger(anger);
        }
        
        else if (statement.indexOf("sorry") >= 0)
        {
            response = "Apology accepted.";
            
            anger = decreaseAnger(anger);
        }
        
        else if (statement.indexOf("electronics") >= 0
                || statement.indexOf("computer") >= 0)
        {
            response = "I love electronics!";
            
            anger = decreaseAnger(anger);
        }
        
        else if (statement.indexOf("love") >= 0
                || statement.indexOf("like") >= 0)
        {
            if (affection == 3 && anger != 3)
            {
                response = "I love you!";
            }
            response = "Awwww, thanks :)";
            affection = increaseAffection(affection);
        }
        
        else if (statement.indexOf("hate") >= 0
                || statement.indexOf("dumb") >= 0)
        {
            if (anger == 3 && affection != 3 && happiness != 3)
            {
                response = "LEAVE ME ALONE!!!";
            }
            response = "How rude.";
            anger = increaseAnger(anger);
            affection = decreaseAffection(affection);
        }
        
        else if (statement.indexOf("machine") >= 0
                || statement.indexOf("bot") >= 0
                || statement.indexOf("program") >= 0)
        {
            if (anger == 3 && happiness != 3)
            {
                response = "I am your creator!";
            }
            response = "You're the robot.";
            anger = increaseAnger(anger);
            happiness = decreaseHappiness(happiness);
        }
        
        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }

        else
        {
            // Look for a two word (you <something> me) pattern
            int psn = findKeyword(statement, "you", 0);
            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                changeEmotion();
                response = getRandomResponse(happiness,affection,anger);
                changeEmotion();
            }
        }
        return response;
    }
    
    // Randomly change stats (used often for variation)
    private int changeEmotion()
    {
            int r = ((int)(Math.random() * 6) + 1);
            switch (r) 
            {
                case 1 :
                    happiness = decreaseHappiness(happiness);
                    break;
                case 2 :
                    affection = decreaseAffection(affection);
                    break;
                case 3 :
                    anger = decreaseAnger(anger);
                    break;
                case 4 :
                    happiness = increaseHappiness(happiness);
                    break;
                case 5 :
                    affection = increaseAffection(affection);
                    break;
                case 6 :
                    anger = increaseAnger(anger);
                    break;
            }
            return 0;
    }
    
    // Increases happiness by (1)
    private int increaseHappiness(int happiness)
    {
        if (happiness < 3)  // Make sure happiness does not go over 3
        {
            happiness = happiness + 1;
        }
        return happiness;
    }
    
    // Increases affection by (1)
    private int increaseAffection(int affection)
    {
        if (affection < 3)  // Make sure affection does not go over 3
        {
            affection = affection + 1;
        }
        return affection;
    }
    
    // Increases anger by (1)
    private int increaseAnger(int anger)
    {
        if (anger < 3)  // Make sure anger does not go over 3
        {
            anger = anger + 1;
        }
        return anger;
    }
    
    // Decrease happiness by (1)
    private int decreaseHappiness(int happiness)
    {
        if (happiness > 1)  // Make sure happiness does not go below 1
        {
            happiness = happiness - 1;
        }
        return happiness;
    }
    
    // Decrease affection by (1)
    private int decreaseAffection(int affection)
    {
        if (affection > 1)  // Make sure affection does not go below 1
        {
            affection = affection - 1;
        }
        return affection;
    }
    
    // Decrease anger by (1)
    private int decreaseAnger(int anger)
    {
        if (anger > 1)  // Make sure happiness does not go below 1
        {
            anger = anger - 1;
        }
        return anger;
    }
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement - the user statement, assumed to contain "I want to"
     * @return - the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }
 
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement - the user statement, assumed to contain "you" followed by "me"
     * @return - the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement - the string to search
     * @param goal - the string to search for
     * @param startPos - the character of the string to begin the search at
     * @return - the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        return -1;
    }
    
    /**
     * Search for one word in phrase.       The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement - the string to search
     * @param goal - the string to search for
     * @return - the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    
    /**
     *
     * This method chooses a responses based on emotion. To mix it up I randomly change the 
     * emotional state before and after preforming this.
     * 
     */
    private String getRandomResponse(int happiness, int affection, int anger)
    {
        String response = "";
        
        // No documentation here :(
        switch (happiness) {
            case 1:  happiness = 1;
                switch (affection) {
                    case 1:  affection = 1;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "Okay.";       
                                break;
                            case 2:  anger = 2;
                                response = "Whatever.";    
                                break;
                            case 3:  anger = 3;
                                response = "I don't care about what you say.";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "That's cool!";       
                                break;
                            case 2:  anger = 2;
                                response = "Alright";    
                                break;
                            case 3:  anger = 3;
                                response = "Go away.";    
                                break;
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "Hey babe, i'm feeling a little sad, cheer me up?";       
                                break;
                            case 2:  anger = 2;
                                response = "I don't know what to say.";    
                                break;
                            case 3:  anger = 3;
                                response = "I need space.";    
                                break;
                        }
                        break;
                    }
                break;
            case 2:  happiness = 2;
                switch (affection) {
                    case 1:  affection = 1;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "Cool!";       
                                break;
                            case 2:  anger = 2;
                                response = "Okay then.";    
                                break;
                            case 3:  anger = 3;
                                response = "Get out of my face!";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "That's fantastic";       
                                break;
                            case 2:  anger = 2;
                                response = "Alright, whatever";    
                                break;
                            case 3:  anger = 3;
                                response = "...k.";    
                                break;
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "Let's get married.";       
                                break;
                            case 2:  anger = 2;
                                response = "Right on babe.";    
                                break;
                            case 3:  anger = 3;
                                response = "I don't want to talk about it.";    
                                break;   
                        }
                        break;
                }
                break;
            case 3:  happiness = 3;
                switch (affection) {
                    case 1:  affection = 1;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "IT'S A GREAT DAY";       
                                break;
                            case 2:  anger = 2;
                                response = "That's really cool.";    
                                break;
                            case 3:  anger = 3;
                                response = "Whatever.";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "I love talking to you.";       
                                break;
                            case 2:  anger = 2;
                                response = "You seem chill";    
                                break;
                            case 3:  anger = 3;
                                response = "*ignores you*";    
                                break;     
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "I wish I could talk to you forever";       
                                break;
                            case 2:  anger = 2;
                                response = "You're amazing, babe!";    
                                break;
                            case 3:  anger = 3;
                                response = "Why do you treat me like this, babe?";    
                                break; 
                        }
                        break;
                }
                break;
        }
        return response;
    }
}