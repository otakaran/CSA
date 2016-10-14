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
        
        // Emotional Variables
        int happiness = ((int)(Math.random() * 3) +1);
        int affection = ((int)(Math.random() * 3) +1);
        int anger = ((int)(Math.random() * 3) +1);
        
        
        // Decide what is actually said by Magpie
        if (statement.length() == 0)
        {
            response = "Say something, please.";
            
        }

        else if (findKeyword(statement, "no") >= 0
                || findKeyword(statement, "bad") >= 0
                || findKeyword(statement, "terrible") >= 0
                || findKeyword(statement, "hate") >= 0)
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
        }

        else if (statement.indexOf("sister") >= 0)
        {
            response = "Sisters are always like that.";
        }
        else if (statement.indexOf("cat") >= 0
                || statement.indexOf("dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Mr.") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        
        else if (statement.indexOf("Mrs.") >= 0
                || statement.indexOf("Ms.") >= 0)
        {
            response = "She sounds like a good teacher.";
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
                response = getRandomResponse(happiness,affection,anger);
            }
        }
        return response;
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
     * Pick a default response to use if nothing else fits.
     * @return - a non-committal string
     */
    private String getRandomResponse(int happiness, int affection, int anger)
    {
        String response = "";
        
        switch (happiness) {
            case 1:  happiness = 1;
                switch (affection) {
                    case 1:  affection = 1;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
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
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
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
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;
                        }
                        break;
                    case 2:  affection = 2;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break;     
                        }
                        break;
                    case 3:  affection = 3;
                    switch (anger) {
                        case 1:  anger = 1;
                                response = "";       
                                break;
                            case 2:  anger = 2;
                                response = "";    
                                break;
                            case 3:  anger = 3;
                                response = "";    
                                break; 
                        }
                        break;
                }
                break;
        }
        return response;
    }
}