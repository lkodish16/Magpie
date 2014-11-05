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
    else if (statement.indexOf("mother") >= 0
               || statement.indexOf("father") >= 0
               || statement.indexOf("sister") >= 0
               || statement.indexOf("brother") >= 0)
    {
      response = "Tell me more about your family.";
    } 
    // gives response if teacher's name is mentioned
    else if (statement.indexOf("Kiang") >= 0)
    {
      response = "I bet he has very nice facial hair.";
    }
    else if (statement.indexOf("Landgraf") >= 0)
    {
      response = "I bet he's an awesome teacher.";
    }
    // gives response when user mentions a pet 
    else if (statement.indexOf("dog") >= 0
               || statement.indexOf("cat") >= 0
               || statement.indexOf("rabbit") >= 0
               || statement.indexOf("fish") >= 0
               || statement.indexOf("turtle") >= 0)
    {
      response = "Tell me more about your pets.";
    }
    // more keywords
    else if (statement.indexOf("math") >= 0
               || statement.indexOf("english") >= 0 
               || statement.indexOf("social studies") >= 0
               || statement.indexOf("language") >= 0
               || statement.indexOf("science") >= 0)
    {
      response = "Tell me more about your favorite subject.";
    }
    else if (statement.indexOf("football") >= 0
               || statement.indexOf("soccer") >= 0
               || statement.indexOf("running") >= 0
               || statement.indexOf("basketball") >= 0
               || statement.indexOf("hockey") >= 0 
               || statement.indexOf("swimming") >= 0
               || statement.indexOf("baseball") >= 0)
    {
      response = "Tell me more about your favorite sport.";
    }
    else if (statement.indexOf("uncle") >= 0
               || statement.indexOf("aunt") >= 0
               || statement.indexOf("cousin") >= 0
               || statement.indexOf("nephew") >= 0
               || statement.indexOf("niece") >= 0) 
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
