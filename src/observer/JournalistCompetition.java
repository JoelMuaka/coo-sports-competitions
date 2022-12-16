package observer;
import competition.*;
import observer.*;

public class JournalistCompetition implements CompetitionListener {

	/**
   	 * Announces the start of a competition
   	 */
	public void annonceCompetition(CompetitionEvent event) {
		Competition competition = (Competition) event.getSource();
		System.out.println("");
		System.out.println("Welcome in this Competition which will offer you very beautiful posters opposing "+competition.getCompetitors().size()+" great competitors !");
	}

	/**
   	 * Announces the end of a competition
   	 */
	public void reactEnd(CompetitionEvent event) {
		Competition competition = (Competition) event.getSource();
		System.out.println("");
		System.out.println("End of the competition!");
		System.out.println("");
		System.out.println("Here is the final ranking :");
		System.out.println("");
		competition.ranking();
		System.out.println("");
		System.out.println("The big winner of this edition is : "+competition.winner().getName()+" !!!");
		System.out.println("");
		System.out.println("Thank you for being with us and see you soon for a new edition!");
	}
}
