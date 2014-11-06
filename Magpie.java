/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *       Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
  /**
   * Get a default greeting  
   * @return a greeting
   */
  public String getGreeting()
  {
    return "Hello, let's talk.";
  }
  
  /**
   * Gives a response to a user statement
   * 
   * @param statement
   *            the user statement
   * @return a response based on the rules given
   */
  public String getResponse(String statement)
  {
    /* if more than one keyword appears in the statement, then the output depends
     * on what keyword you check for first. So prioritize your keywords by checking 
     * some first and others after.
     */
    // change the input to lowercase characters so the checks are not case-sensitive
    statement = statement.toLowerCase();
    String response = "";
    if (statement.indexOf("no") >= 0)
    {
      response = "Why so negative?";
    }
    // checks if nothing or just spaces have been inputted
    else if (statement.trim().length() == 0)
    {
      response = "Say, something please.";
    }
    else if (findKeyword(statement, "mother", 0) >= 0
               || findKeyword(statement, "father", 0) >= 0
               || findKeyword(statement, "sister", 0) >= 0
               || findKeyword(statement, "brother", 0) >= 0)
    {
      response = "Tell me more about your family.";
    } 
    // gives response if teacher's name is mentioned
    else if (findKeyword(statement, "Kiang", 0) >= 0)
    {
      response = "I bet he has very nice facial hair.";
    }
    else if (findKeyword(statement, "Landgraf", 0) >= 0)
    {
      response = "I bet he's an awesome teacher.";
    }
    // gives response when user mentions a pet 
    else if (findKeyword(statement, "dog", 0) >= 0
               || findKeyword(statement, "cat", 0) >= 0
               || findKeyword(statement, "rabbit", 0) >= 0
               || findKeyword(statement, "fish", 0) >= 0
               || findKeyword(statement, "turtle", 0) >= 0)
    {
      response = "Tell me more about your pets.";
    }
    // more keywords
    else if (findKeyword(statement, "math", 0) >= 0
               || findKeyword(statement, "english", 0) >= 0 
               || findKeyword(statement, "social studies", 0) >= 0
               || findKeyword(statement, "language", 0) >= 0
               || findKeyword(statement, "science", 0) >= 0)
    {
      response = "Tell me more about your favorite subject.";
    }
    else if (findKeyword(statement, "football", 0) >= 0
               || findKeyword(statement, "soccer", 0) >= 0
               || findKeyword(statement, "running", 0) >= 0
               || findKeyword(statement, "basketball", 0) >= 0
               || findKeyword(statement, "hockey", 0) >= 0 
               || findKeyword(statement, "swimming", 0) >= 0
               || findKeyword(statement, "baseball", 0) >= 0)
    {
      response = "Tell me more about your favorite sport.";
    }
    else if (findKeyword(statement, "uncle", 0) >= 0
               || findKeyword(statement, "aunt", 0) >= 0
               || findKeyword(statement, "cousin", 0) >= 0
               || findKeyword(statement, "nephew", 0) >= 0
               || findKeyword(statement, "niece", 0) >= 0) 
    {
      response = "Tell me more about your relatives.";
    }          
    
    else
    {
      response = getRandomResponse();
    }
    return response;
  }
  
  
  /**
   * Search for one word in phrase. The search is not case
   * sensitive. This method will check that the given goal
   * is not a substring of a longer string (so, for
   * example, "I know" does not contain "no").
   * 
   * @param statement
   *            the string to search
   * @param goal
   *            the string to search for
   * @param startPos
   *            the character of the string to begin the
   *            search at
   * @return the index of the first occurrence of goal in
   *         statement or -1 if it's not found
   */
  private int findKeyword(String statement, String goal,
                          int startPos)
  {
    String phrase = statement.trim();
    // The only change to incorporate the startPos is in
    // the line below
    int psn = phrase.toLowerCase().indexOf(
                                           goal.toLowerCase(), startPos);
    
    // Refinement--make sure the goal isn't part of a
    // word
    while (psn >= 0)
    {
      // Find the string of length 1 before and after
      // the word
      String before = " ", after = " ";
      if (psn > 0)
      {
        before = phrase.substring(psn - 1, psn)
          .toLowerCase();
      }
      if (psn + goal.length() < phrase.length())
      {
        after = phrase.substring(
                                 psn + goal.length(),
                                 psn + goal.length() + 1)
          .toLowerCase();
      }
      
      // If before and after aren't letters, we've
      // found the word
      if (((before.compareTo("a") < 0) || (before
                                             .compareTo("z") > 0)) // before is not a
            // letter
            && ((after.compareTo("a") < 0) || (after
                                                 .compareTo("z") > 0)))
      {
        return psn;
      }
      
      // The last position didn't work, so let's find
      // the next, if there is one.
      psn = phrase.indexOf(goal.toLowerCase(),
                           psn + 1);
      
    }
    
    return -1;
  }
  
  
  /**
   * Pick a default response to use if nothing else fits.
   * @return a non-committal string
   */
  private String getRandomResponse()
  {
    final int NUMBER_OF_RESPONSES = 6;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";
    
    if (whichResponse == 0)
    {
      response = "Interesting, tell me more.";
    }
    else if (whichResponse == 1)
    {
      response = "Hmmm.";
    }
    else if (whichResponse == 2)
    {
      response = "Do you really think so?";
    }
    else if (whichResponse == 3)
    {
      response = "You don't say.";
    }
    // two more non-commital responses
    else if (whichResponse == 4)
    {
      response = "Wow, keep talking.";
    }
    else if (whichResponse  == 5)
    {
      response = "Let me know more about that.";
    }
    
    return response;
  }
}
