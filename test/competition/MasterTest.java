package competition;
import competition.methods.*;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MasterTest{
	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Method method;
	private List<Competitor> liste = new ArrayList<Competitor>();
	private Master competition;

	@Before
	public void before() {
		this.c1 = new Competitor("comp1");
		this.c2 = new Competitor("comp2");
		this.c3 = new Competitor("comp3");
		this.c4 = new Competitor("comp4");
		this.method = new SelectFirst();
		this.competition = new Master(liste,2,method);
	}

	@Test
	public void testCreatePoules() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		List<League> league =  this.competition.createPoules(this.competition.getCompetitors());
		assertEquals(league.size(),2);
	}

	@Test
	public void testPlayLeagueRun() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.createPoules(this.competition.getCompetitors());
		assertTrue(this.c1.getPoints()<=2);
		assertTrue(this.c2.getPoints()<=2);
		assertTrue(this.c3.getPoints()<=2);
		assertTrue(this.c4.getPoints()<=2);
		assertTrue(this.c1.getPoints()+this.c2.getPoints()+this.c3.getPoints()+this.c4.getPoints()<=8);
	}

	@Test(expected=NumberNotPowerOf2Exception.class)
	public void testPlayLeagueNotRun() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.playLeague(this.competition.getCompetitors());
	}

	@Test
	public void testPlayTournament() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.playLeague(this.competition.getCompetitors());
		this.competition.playTournament();
		assertTrue(this.competition.getTournament().ranking().containsValue(1));
		assertTrue(this.competition.getTournament().ranking().containsValue(0));
	}

	@Test
	public void testPlay() throws NumberNotPowerOf2Exception{
		this.competition.addCompetitors(this.c1);
		this.competition.addCompetitors(this.c2);
		this.competition.addCompetitors(this.c3);
		this.competition.addCompetitors(this.c4);
		this.competition.play(this.competition.getCompetitors());
		assertEquals(this.competition.getLeague().size(),2);
		assertEquals(this.method.selection(this.competition.getLeague()).size(),2);
		assertEquals(this.competition.getTournament().getCompetitors().size(),2);
	}
	
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(competition.MasterTest.class);
    }
}
