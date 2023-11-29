package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {
	

	public SelectAllQuestion(String prompt, String answer, int totPoints, String[] choices) {
		super(prompt,answer,answer.length() * 3,choices);
	}
	
	public int checkAnswer(String givenAnswer) {
		int score = 0;
		for(int i = 0; i < givenAnswer.length(); i ++) {
			if(this.getAnswer().contains((Character.toString(givenAnswer.charAt(i))))) {
				score +=3; //three points for contain correct answer
			}
			else {
				score -=1;
			}
		}
		if(score < 0) score = 0; //set negative score to 0
		return score;
	}
	
	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", 0,choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points
		System.out.println(selectAll.checkAnswer("23")); //2 points
		System.out.println(selectAll.checkAnswer("34")); //2 points
		System.out.println(selectAll.checkAnswer("4")); //1 point
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points
		
	}
}
