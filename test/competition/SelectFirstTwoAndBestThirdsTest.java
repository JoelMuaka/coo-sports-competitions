package competition;
import competition.methods.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SelectFirstTwoAndBestThirdsTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
	private Competitor c5;
	private Competitor c6;
	private Method method;
	private List<League> league;
	private League league1;
	private League league2;

	@Before
	public void before() {
		this.c1 = new Competitor("comp1");
		this.c2 = new Competitor("comp2");
		this.c3 = new Competitor("comp3");
		this.c4 = new Competitor("comp4");
		this.c5 = new Competitor("comp5");
		this.c6 = new Competitor("comp6");
		this.method = new SelectFirstTwoAndBestThirds();
		this.league = new ArrayList<League>();
		this.league1 = new League(new ArrayList<Competitor>());
		this.league2 = new League(new ArrayList<Competitor>());
	}

	@Test
	public void testSelection() throws NumberNotPowerOf2Exception{
		this.league.add(league1);
		this.league.add(league2);
		this.league1.addCompetitors(this.c1);
		this.league1.addCompetitors(this.c2);
		this.league1.addCompetitors(this.c3);
		this.league1.play();
		List<Competitor> liste1 = new ArrayList<Competitor>(league1.getCompetitors());
		this.league2.addCompetitors(this.c4);
		this.league2.addCompetitors(this.c5);
		this.league2.addCompetitors(this.c6);
		this.league2.play();
		List<Competitor> liste2 = new ArrayList<Competitor>(league2.getCompetitors());
		List<Competitor> liste = this.method.selection(this.league);
		assertTrue(liste.contains(liste1.get(0)));
		assertTrue(liste.contains(liste1.get(1)));
		assertTrue(liste.contains(liste2.get(0)));
		assertTrue(liste.contains(liste2.get(1)));
		assertTrue(liste.contains(liste1.get(2)));
		assertTrue(liste.contains(liste2.get(2)));
	}

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(competition.SelectFirstTwoAndBestThirdsTest.class);
    }
}
