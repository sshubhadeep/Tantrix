package comp1110.ass2;

/*
 * Notation:
 * 
 * Game state will be represented by an array of 26 characters, organized as
 * 13 pairs, each identifying a tile ('A' .. 'M') and its rotation ('0' .. '5'),
 * with the ordering of pairs following the order below, according to
 * tile placement in the game:
 * 
 *   0  1  2  3
 *  4  5  6  7  8
 *   9 10 11 12
 *   
 * Unfilled places are identified by a pair of space ' ' characters.
 * 
 * The three colors are represented by a single character, 'R' (red), 
 * 'Y' (yellow), and 'G' (green).
 * 
 * The thirteen tiles are described here in terms of the color of each edge
 * when unrotated, starting with the top right color.
 * 
 * A: YRGGRY
 * B: GRGYRY
 * C: RGYGYR
 * D: YGGRRY
 * E: YRRGGY
 * F: RYGGYR
 * G: GYGRYR
 * H: YRGRGY
 * I: YGRGRY
 * J: RGYYGR
 * K: YGYRGR
 * L: GRYRYG
 * M: GYRYRG
 * 
 * Difficulty will be expressed as a double between (and inclusive of) 
 * 0 and 100.0, where 0 is no difficulty (the result is a fully solved 
 * game state), and 100.0 is maximum difficulty (the result is a completely
 * unsolved game state; ie the game state made entirely of spaces).
 */
/**
 * @author Shubhadeep Sarkar
 *
 */

public interface Tantrix {
	/**
	 * Produce a game state that gives a solution to the 'match' 
	 * problem, using the notation described above.
	 * @param difficulty The difficulty of solving the returned puzzle.
	 * @return An array of 26 characters reflecting the game state
	 */
	public char[] solveMatch(double difficulty);

	/**
	 * Produce a game state that gives a solution to the 'line' 
	 * problem, using the notation described above.
	 * @param color The color of the continuous line ('R', 'G', or ''Y')
	 * @param difficulty The difficulty of solving the returned puzzle.
	 * @return An array of 26 characters reflecting the game state
	 */
	public char[] solveLine(char color, double difficulty);

	/**
	 * Produce a game state that gives a solution to the 'loop' 
	 * problem, using the notation described above.
	 * @param color The color of the loop ('R', 'G', or ''Y')
	 * @param difficulty The difficulty of solving the returned puzzle.
	 * @return An array of 26 characters reflecting the game state
	 */
	public char[] solveLoop(char color, double difficulty);
	
	/**
	 * Determine whether a given game state is a match, using 
	 * the definition above.
	 * @param tiles An array of 26 characters encoding a game state
	 * @return true of the tiles represent a match
	 */
	public boolean isMatch(char[] tiles);

	/**
	 * Determine whether a given game state is a line of the given
	 * color, using the definition above.
	 * @param color The color of the line ('R', 'G', or ''Y')
	 * @param tiles An array of 26 characters encoding a game state
	 * @return true of the tiles represent a line of the given color
	 */
	public boolean isLine(char color, char[] tiles);

	/**
	 * Determine whether a given game state is a loop of the given
	 * color, using the definition above.
	 * @param color The color of the loop ('R', 'G', or ''Y')
	 * @param tiles An array of 26 characters encoding a game state
	 * @return true of the tiles represent a loop of the given color
	 */
	public boolean isLoop(char color, char[] tiles);
}
