package comp1110.ass2;

/*defining an enum Edge with three possible colors*/
/**
 * @author Shubhadeep Sarkar
 *
 */

public enum Edge {
	RED(Color.R), YELLOW(Color.Y), GREEN(Color.G);

	private final Color color;

	Edge(Color color) {
		this.color = color;
	}

	/* this will return the current objects color */
	public Color getColor() {
		return this.color;
	}

	/*
	 * this will return true if the current edge color and the other edge color
	 * matches
	 */
	public boolean compatible(Edge other) {
		if (other.color == this.color)
			return true;
		return false;
	}
}
