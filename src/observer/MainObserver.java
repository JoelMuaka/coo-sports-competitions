package observer;
import competition.*;
import competition.methods.*;
import java.util.*;

public class MainObserver {

	public static void main(String[] args) {
		try{
			Competitor c1 = new Competitor("comp1");
			Competitor c2 = new Competitor("comp2");
			Competitor c3 = new Competitor("comp3");
			Competitor c4 = new Competitor("comp4");
			Competition competition = new Master(new ArrayList<Competitor>(),2,new SelectFirst());
			competition.addCompetitors(c1);
			competition.addCompetitors(c2);
			competition.addCompetitors(c3);
			competition.addCompetitors(c4);
			Bookmaker b = new Bookmaker();
			JournalistMatch jm = new JournalistMatch();
			JournalistCompetition jc = new JournalistCompetition();
			competition.addMatchListener(jm);
			competition.addMatchListener(b);
			competition.addCompetitionListener(jc);
			competition.play();
		}
		catch(NumberNotPowerOf2Exception e){
      ;
    }
	}
}
