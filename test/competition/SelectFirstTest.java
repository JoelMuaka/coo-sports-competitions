package competition;
import competition.methods.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SelectFirstTest {

	private Competitor c1;
	private Competitor c2;
	private Competitor c3;
	private Competitor c4;
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
		this.method = new SelectFirst();
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
		this.league1.play();
		Map<Competitor, Integer> rank = this.league1.ranking();
		List<Competitor> liste1 = new ArrayList<Competitor>(rank.keySet());
		this.league2.addCompetitors(this.c3);
		this.league2.addCompetitors(this.c4);
		this.league2.play();
		Map<Competitor, Integer> rank1 = this.league2.ranking();
		List<Competitor> liste2 = new ArrayList<Competitor>(rank1.keySet());
		List<Competitor> liste3 = new ArrayList<Competitor>();
		liste3.add(liste1.get(0));
		liste3.add(liste2.get(0));
		List<Competitor> liste = this.method.selection(this.league);
		assertEquals(liste,liste3);
	}

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(competition.SelectFirstTest.class);
    }
}
