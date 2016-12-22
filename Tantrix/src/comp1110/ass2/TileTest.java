package comp1110.ass2;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author Shubhadeep Sarkar
 *
 */
public class TileTest extends TestCase {

	/* Test to check rotateRight() method */
	@Test
	public void testRotateRight() {
		Tile test = Tile.B;
		test.rotateRight();
		assertEquals(test.edges[0], Edge.YELLOW);
		test.rotateLeft();
	}

	/* Test to check rotateLeft() method */
	@Test
	public void testRotateLeft() {
		Tile test = Tile.B;
		test.rotateLeft();
		assertEquals(test.edges[0], Edge.RED);
		test.rotateRight();
	}

	/* Test to check compatobleRight() method*/
	@Test
	public void testCompatibleRight() {
		Tile A = Tile.A;
		Tile B = Tile.B;
		assertTrue(A.compatibleRight(B)) ;
	}
	
	/* Test to check compatobleBelowLeft() method*/
	@Test
	public void testCompatibleBelowLeft() {
	Tile A = Tile.A;
	Tile B = Tile.B;
	assertTrue(A.compatibleBelowLeft(B));
	}

	/* Test to check compatobleBelowRight() method*/
	@Test
	public void testCompatibleBelowRight() {
	Tile A = Tile.C;
	Tile B = Tile.D;
	assertTrue(A.compatibleBelowRight(B)); 
	}
}
