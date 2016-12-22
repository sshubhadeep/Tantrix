package comp1110.ass2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Shubhadeep Sarkar
 *
 */
public class EdgeTest {

	/* Test to check if getColor is working fine*/
	@Test
	public void testGetColor() {
		Edge e = Edge.RED;
		assertTrue((e.getColor()).equals(Color.R));
	}

	/* Test to check if two edges are compatible */
	@Test
	public void testCompatible() {
		Edge e1 = Edge.RED;
		Edge e2 = Edge.GREEN;
		assertNotEquals("Returning true for incompatible edges", true,
				e1.compatible(e2));
	}

}
