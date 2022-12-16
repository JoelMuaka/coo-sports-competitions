package competition;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TournamentTest extends CompetitionTest{

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Competition competition;
	private List<Competitor> liste = new ArrayList<Competitor>();

	protected Competition createCompetition(){
		return new Tournament(liste);
	}

	@Before
	public void before() {
		this.c1 = new Competitor("comp1");
		this.c2 = new Competitor("comp2");
		this.c3 = new Competitor("comp3");
		this.c4 = new Competitor("comp4");
		this.competition = new Tournament(liste);
	}

	@Test
	public void testPlayRun() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play(this.competition.getCompetitors());
		assertTrue(this.competition.ranking().containsValue(2));
		assertTrue(this.competition.ranking().containsValue(1));
		assertTrue(this.competition.ranking().containsValue(0));
	}

	@Test(expected=NumberNotPowerOf2Exception.class)
	public void testPlayNotRun() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.play(this.competition.getCompetitors());
	}

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(competition.TournamentTest.class);
    }

}
