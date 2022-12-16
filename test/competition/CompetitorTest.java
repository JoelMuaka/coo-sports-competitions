package competition;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {

	private Competitor c1;

	@Before
	public void before() {
		this.c1 = new Competitor("comp1");
	}

	@Test
	public void testGetPoints() {
		assertEquals(0,this.c1.getPoints());
		this.c1.addPoint();
		assertEquals(1,this.c1.getPoints());
	}

	@Test
	public void testGetName() {
		assertEquals("comp1",this.c1.getName());
	}

	@Test
	public void testAddPoint() {
		assertEquals(0,this.c1.getPoints());
		this.c1.addPoint();
		assertEquals(1,this.c1.getPoints());
	}

    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(competition.CompetitorTest.class);
    }

}
