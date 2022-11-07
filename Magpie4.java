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
		return "Healthbot: Hello My name is HealthBot";
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
			response = "Healthbot: Say something, please.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Healthbot: Why are you so negative?";
		}
		else if ((findKeyword(statement, "will", 0) >= 0)) {
			response = "I dont know";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Healthbot: Tell me more about your family.";
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
				response = "Healthbot: Hello, I am great! My name is Healthbot, how are you doing today?";
			}
			else {
				response = "Healthbot: Hi! I'm Healthbot, here to speak about health and give you health tips!";
			}
		}

		else if ((findKeyword(statement, "How are you doing?", 0) >= 0) || (findKeyword(statement, "How are you?", 0) >= 0))
		{
			response = "Healthbot: Everything is well for me! How about you?";

		}
		else if(((findKeyword(statement, "doing", 0) >= 0) || (findKeyword(statement, "im", 0) >= 0) || (findKeyword(statement, "i'm", 0) >= 0) || (findKeyword(statement, "am", 0) >= 0) || (findKeyword(statement, "is", 0) >= 0)|| (findKeyword(statement, "are", 0) >= 0)) && (((findKeyword(statement, "good", 0) >= 0) || (findKeyword(statement, "great", 0) >= 0) || (findKeyword(statement, "awesome", 0) >= 0))))
		{
			response = "Healthbot: Nice! Let's talk about health!";

		}
		else if((findKeyword(statement, "doing", 0) >= 0) && (((findKeyword(statement, "bad", 0) >= 0) || (findKeyword(statement, "rough", 0) >= 0) || (findKeyword(statement, "terrible", 0) >= 0))))
		{
			response = "Healthbot: That's unfortunate, I hope I can cheer you up today.";
		}
		else if ((findKeyword(statement, "health", 0) >= 0) && (((findKeyword(statement, "advice", 0) >= 0))||(findKeyword(statement, "tips", 0) >= 0) || ((findKeyword(statement, "give", 0) >= 0))))
		{
			System.out.println("Healthbot: Sure");
			System.out.println("Do you exercise every day?");
			Scanner in = new Scanner (System.in);
			String statement1 = in.nextLine();
			if ((findKeyword(statement1, "yes" , 0) >=0)){
				System.out.println("Good job on exercising daily! It helps increase endorphin count and helps you lose weight!");
				ansq += 1;
			}
			else if ((findKeyword(statement1, "no" , 0) >=0)){
				System.out.println("Come on! Exercising daily is great for your health. Having a sedentary lifestyle increases your risk for diseases like heart attacks");
				ansq += 1;
			}
			else {
				response += "Say something next time";
			}
			if (ansq == 1){
				System.out.println("Healthbot: Next Question");
				System.out.println("Do you eat fruits and veggies every day?");
				response = "";
				Scanner in2 = new Scanner (System.in);
				String statement2 = in2.nextLine();
				if ((findKeyword(statement2, "yes" , 0) >=0)){
					System.out.println("Healthbot: Great job! Eating fruits and veggies gives you the nutrients you need to live a sustainable life.");
					ansq += 1;

				}
				else if ((findKeyword(statement2, "no" , 0) >=0)){
					System.out.println("Healthbot: That's not good. Fruits and veggies provide important nutrients that can help you and your body develop.");
					ansq += 1;

				}
				else {
					response += "Healthbot: Say something next time.";
					ansq += 1;

				}
				ansq -= 1;
			}
			else {
				response += "";

			}
			if (ansq == 1){
				System.out.println("Healthbot: FINAL Question");
				System.out.println("Do you take a few minutes to be mindful (meditation, breathing exercises, etc.) ?");
				response = "";
				Scanner in2 = new Scanner (System.in);
				String statement2 = in2.nextLine();
				if ((findKeyword(statement2, "yes" , 0) >=0)){
					response += "Healthbot: That's very good. Calmness is important because it brings us back to \"reality\" and away from the stress and troubles of our work lives.";
					ansq += 1;

				}
				else if ((findKeyword(statement2, "no" , 0) >=0)){
					response += "Healthbot: That's not good. Mindfulness helps us escape from the stress of our work lives and brings us back to \"reality\" Take a few minutes every day if you can!";
					ansq += 1;

				}
				else {
					response += "Healthbot: Say something next time.";
					ansq += 1;

				}
				ansq -= 1;
			}

		}
		else if ((findKeyword(statement, "you", 0) >= 0) && (findKeyword(statement, "date", 0) >= 0) && (findKeyword(statement, "me", 0) >= 0) ){
			response += "No, I will never date you, I am only here to give users health advice";
		}
		else if ((findKeyword(statement, "anything", 0) >= 0))
		{
			if ((findKeyword(statement, "want", 0) >= 0) && (findKeyword(statement, "you", 0) >= 0)) {
				response = "I want to help those in need of Health Advice";
			}
			else {
				response = "Nope, nothing!";
			}
		}



		else if ((findKeyword(statement, "Thanks", 0) >= 0))
		{
			response = "Your welcome";
		}



		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);
			int loc = findKeyword(statement, "wood", 0);
			int loc2 = findKeyword(statement, "wud", 0);
			int quest = findKeyword(statement, "they", 0);
			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			} else if (quest >=0 && (findKeyword(statement, "they", quest)>= 0))
			{
				response = "Who are you refering to as 'they'";
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
		return "Healthbot: What would it mean to " + restOfStatement + "?";
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
			return "Healthbot: Did you mean '" + startStatement +" would " + restOfStatement + "?' ";
		}
		else {
			return "Healthbot: Did you mean 'Would " + restOfStatement + "?' ";
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
		return "Healthbot: What makes you think that I " + restOfStatement + " you?";
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
			response = "Healthbot: Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Healthbot: Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Healthbot: Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "Healthbot: You don't say.";
		}

		return response;
	}

}
