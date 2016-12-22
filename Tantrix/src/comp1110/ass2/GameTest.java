package comp1110.ass2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Shubhadeep Sarkar
 *
 */
public class GameTest {
	
	/*Test to check if the isMatch method is correctly executed*/
	@Test
	public void testIsMatch(){
		Game g=new Game();
		char [] tiles=new char[]{'J','0','E','0','G','1','L','4','A','0','B','0','C','5','D','5','F','1','H','1','K','4','I','2','M','1'};
		assertEquals("Failed to identify green line J0E0G1L4A0B0C5D5F1H1K4I2M1", true ,g.isMatch(tiles));
	}
	
	/*Test to check if the isLine method is correctly executed*/
	@Test
    public void testIsLine(){
       	Game g=new Game();
		char [] tiles=new char[]{'H','3','J','0','K','0','M','4','A','0','D','0','C','1','F','4','L','4','B','5','E','1','I','4','G','4'};
		assertEquals("Failed to identify green line H3J0K0M4A0D0C1F4L4B5E1I4G4",true,g.isLine('g', tiles));
    }
	
	/*Test to check if the isLoop method is correctly executed*/
	@Test
    public void testIsLoop(){
    	Game g=new Game();
		char [] tiles=new char[]{'C','2','B','0','A','0','I','0','J','2','D','1','L','0','E','2','G','0','K','2','H','3','F','1','M','2'};
		assertEquals("Failed to identify red loop C2B0A0I0J2D1L0E2G0K2H3F1M2",true,g.isLoop('r', tiles));
    }
	
	/*Test to check if the solveMatch method is correctly executed*/
	@Test
	public void testSolveMatch(){
		Game g=new Game();
		if(g.solveMatch(0).equals(null))
			throw new NullPointerException();
		assertTrue(g.isMatch(g.solveMatch(0)));
	}
	
	/*Test to check if the solveLoop method is correctly executed*/
	@Test
	public void testSolveLoop(){
		Game g=new Game();
		if(g.solveLoop('r', 0).equals(null))
			throw new NullPointerException();
		assertTrue(g.isLoop('r',g.solveLoop('r',0)));
	}
	
	/*Test to check if the solveLine method is correctly executed*/
	@Test
	public void testSolveLine(){
		Game g=new Game();
		if(g.solveLine('g', 0).equals(null))
			throw new NullPointerException();
		assertEquals("Not a valid solved line", true, g.isLine('g', g.solveLine('g',0)));
	}
}
