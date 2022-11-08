import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Professor Oak: Hello My name is Professor Oak"; //edit here
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
		String response = "";
		int ansq = 0;
		if (statement.length() == 0)
		{
			response = "Professor Oak: Say something, please."; //edit here
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Professor Oak: Don't be so negative?"; //edit here
		}
		else if ((findKeyword(statement, "will", 0) >= 0)) {
			response = "Professor Oak: I'm not sure";//edit here
		}
		else if (findKeyword(statement, "pokeball") >= 0 //edit here
				|| findKeyword(statement, "food") >= 0//edit here
				|| findKeyword(statement, "favorite") >= 0//edit here
				|| findKeyword(statement, "love") >= 0)//edit here
		{
			response = "Professor Oak: Tell me more!";//edit here
		}

		// Responses which require transformations
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		//our own personal code
		else if ((findKeyword(statement, "Hello", 0) >= 0) || (findKeyword(statement, "Hi", 0) >= 0))
		{
			if ((findKeyword(statement, "how", 0) >= 0)){
				response = "Professor Oak: Hello, I am Professor Oak! I'm here to give you advice and help on all things pokemon.";//edit here
			}
			else {
				response = "Professor Oak: Hi! I'm Professor Oak, here to give tips about taking care of pokemon and tell you everything you need to know about pokemon!";//edit here
			}
		}

		else if ((findKeyword(statement, "How are you doing?", 0) >= 0) || (findKeyword(statement, "How are you?", 0) >= 0))//edit here
		{
			response = "Professor Oak: Everything is well for me! How about you and your pokemon?";//edit here

		}
		else if(((findKeyword(statement, "doing", 0) >= 0) || (findKeyword(statement, "im", 0) >= 0) || (findKeyword(statement, "i'm", 0) >= 0) || (findKeyword(statement, "am", 0) >= 0) || (findKeyword(statement, "is", 0) >= 0)|| (findKeyword(statement, "are", 0) >= 0)) && (((findKeyword(statement, "good", 0) >= 0) || (findKeyword(statement, "great", 0) >= 0) || (findKeyword(statement, "awesome", 0) >= 0))))
		{
			response = "Professor Oak: Cool! Let's talk Pokemon!";//edit here

		}
		else if((findKeyword(statement, "doing", 0) >= 0) && (((findKeyword(statement, "bad", 0) >= 0) || (findKeyword(statement, "rough", 0) >= 0) || (findKeyword(statement, "terrible", 0) >= 0))))//edit here
		{
			response = "Professor Oak: That's unfortunate, I'll do what I can to help.";//edit here
		}
		else if ((findKeyword(statement, "pokemon", 0) >= 0) && (((findKeyword(statement, "advice", 0) >= 0))||(findKeyword(statement, "tips", 0) >= 0) || ((findKeyword(statement, "give", 0) >= 0))))
		{
			System.out.println("Professor Oak: Sure");//edit here
			System.out.println("Do you walk and play with your pokemon daily?");//edit here
			Scanner in = new Scanner (System.in);
			String statement1 = in.nextLine();
			if ((findKeyword(statement1, "yes" , 0) >=0)){
				System.out.println("Good job on exercising daily! It helps increase endorphin count and helps you lose weight!");//edit here
				ansq += 1;
			}
			else if ((findKeyword(statement1, "no" , 0) >=0)){
				System.out.println("Come on! Giving attention to your pokemon is great for their health. It increases pokemon and trainer bond");//edit here
				ansq += 1;
			}
			else {
				response += "Say something next time";
			}
			if (ansq == 1){
				System.out.println("Professor Oak: Next Question");//edit here
				System.out.println("Do you play with your pokemon every day?");//edit here
				response = "";
				Scanner in2 = new Scanner (System.in);
				String statement2 = in2.nextLine();
				if ((findKeyword(statement2, "yes" , 0) >=0)){
					System.out.println("Professor Oak: Great job! This is really good for your life and their life and your partnership.");//edit here
					ansq += 1;

				}
				else if ((findKeyword(statement2, "no" , 0) >=0)){
					System.out.println("Professor Oak: That's not good. You should exercise with your pokemon, play with them, and feed them often to increase pokemon trainer bond.");//edit here
					ansq += 1;

				}
				else {
					response += "Professor Oak: Say something next time.";//edit here
					ansq += 1;

				}
				ansq -= 1;
			}
			else {
				response += "";

			}
			if (ansq == 1){
				System.out.println("Professor Oak: Ok, last question");//edit here
				System.out.println("Do you take some time to take your pokemon to play with other pokemon?");//edit here
				response = "";
				Scanner in2 = new Scanner (System.in);
				String statement2 = in2.nextLine();
				if ((findKeyword(statement2, "yes" , 0) >=0)){
					response += "Pokemon: Ok good. Meeting other pokemon is good for their social life.";
					ansq += 1;

				}
				else if ((findKeyword(statement2, "no" , 0) >=0)){
					response += "Pokemon: That's not good. Your pokemon needs to socialize with other pokemon!";
					ansq += 1;

				}
				else {
					response += "Pokemon: Say something next time.";
					ansq += 1;

				}
				ansq -= 1;
			}

		}
		else if ((findKeyword(statement, "anything", 0) >= 0))
		{
			if ((findKeyword(statement, "want", 0) >= 0) && (findKeyword(statement, "you", 0) >= 0)) {
				response = "I want to help pokemon and trainers";//edit here
			}
			else {
				response = "Nope, nothing!";//edit here
			}
		}



		else if ((findKeyword(statement, "Thank you", 0) >= 0))
		{
			response = "Your welcome";
		}



		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);//edit here
			int loc = findKeyword(statement, "wood", 0);
			int loc2 = findKeyword(statement, "wud", 0);
			int quest = findKeyword(statement, "they", 0);
			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			} else if (quest >=0 && (findKeyword(statement, "they", quest)>= 0))
			{
				response = "Who are you refering to as 'they'";//edit here
			} else if ((loc >= 0 && ((findKeyword(statement,"wood",loc))) >=0) || (loc2 >= 0 && ((findKeyword(statement,"wud",loc2))) >=0)){
				response = clarification(statement);
			}
			else {
				response = getRandomResponse();
			}
		}
		return response;
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Professor Oak: What would it mean to " + restOfStatement + "?";//edit here
	}
	private String clarification(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = (findKeyword(statement, "wud", 0));
		int psn2 = (findKeyword(statement, "wood",0));
		psn = psn2;
		String restOfStatement = statement.substring(psn + 5).trim();
		if (psn >= 4) {
			String startStatement = statement.substring(psn - 4, psn + 0).trim();
			return "Professor Oak: Did you mean '" + startStatement +" would " + restOfStatement + "?' ";//edit here
		}
		else {
			return "Professor Oak: Did you mean 'Would " + restOfStatement + "?' ";//edit here
		}
	}


	/**
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "Professor Oak: What makes you think that I " + restOfStatement + " you?";//edit here
	}





	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
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
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}



	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Professor Oak: Interesting, tell me more.";//edit here
		}
		else if (whichResponse == 1)
		{
			response = "Professor Oak: Hmmm.";//edit here
		}
		else if (whichResponse == 2)
		{
			response = "Professor Oak: Do you really think so?";//edit here
		}
		else if (whichResponse == 3)
		{
			response = "Professor Oak: You don't say.";//edit here
		}

		return response;
	}

}
