package comp1110.ass2;

/**
 * @author Shubhadeep Sarkar
 *
 */

/*Enum to represent every tile of the puzzle*/
public enum Tile {
		A (new Edge[] { Edge.YELLOW, Edge.RED, Edge.GREEN, Edge.GREEN, Edge.RED, Edge.YELLOW}),
		B (new Edge[] { Edge.GREEN, Edge.RED, Edge.GREEN, Edge.YELLOW, Edge.RED, Edge.YELLOW}),
		C (new Edge[] { Edge.RED, Edge.GREEN, Edge.YELLOW, Edge.GREEN, Edge.YELLOW, Edge.RED}),
		D (new Edge[] { Edge.YELLOW, Edge.GREEN, Edge.GREEN, Edge.RED, Edge.RED, Edge.YELLOW}),
		E (new Edge[] { Edge.YELLOW, Edge.RED, Edge.RED, Edge.GREEN, Edge.GREEN, Edge.YELLOW}),
		F (new Edge[] { Edge.RED, Edge.YELLOW, Edge.GREEN, Edge.GREEN, Edge.YELLOW, Edge.RED}),
		G (new Edge[] { Edge.GREEN, Edge.YELLOW, Edge.GREEN, Edge.RED, Edge.YELLOW, Edge.RED}),
		H (new Edge[] { Edge.YELLOW, Edge.RED, Edge.GREEN, Edge.RED, Edge.GREEN, Edge.YELLOW}),
		I (new Edge[] { Edge.YELLOW, Edge.GREEN, Edge.RED, Edge.GREEN, Edge.RED, Edge.YELLOW}),
		J (new Edge[] { Edge.RED, Edge.GREEN, Edge.YELLOW, Edge.YELLOW, Edge.GREEN, Edge.RED}),
		K (new Edge[] { Edge.YELLOW, Edge.GREEN, Edge.YELLOW, Edge.RED, Edge.GREEN, Edge.RED}),
		L (new Edge[] { Edge.GREEN, Edge.RED, Edge.YELLOW, Edge.RED, Edge.YELLOW, Edge.GREEN}),
		M (new Edge[] { Edge.GREEN, Edge.YELLOW, Edge.RED, Edge.YELLOW, Edge.RED, Edge.GREEN});
		
		public Edge[] edges;
		
		Tile(Edge[] edges) {
			this.edges = edges;
		}
		
		/*Retrieve the tile*/
		public static Tile getTile(char x){
			switch(x){
				case 'A' : 	return Tile.A;
				case 'B' : 	return Tile.B;
				case 'C' : 	return Tile.C;
				case 'D' : 	return Tile.D;
				case 'E' : 	return Tile.E;
				case 'F' : 	return Tile.F;
				case 'G' : 	return Tile.G;
				case 'H' : 	return Tile.H;
				case 'I' : 	return Tile.I;
				case 'J' : 	return Tile.J;
				case 'K' : 	return Tile.K;
				case 'L' : 	return Tile.L;
				case 'M' : 	return Tile.M;
				default : 	return null;
			}
		}
		
		/*Rotate the tile on mouse click logic*/
		public void rotateRight() {
			Edge e;
			e = this.edges[5];
			for (int i=5; i>0; i--)	
				this.edges[i] = this.edges[i-1];
			this.edges[0] = e;
		}
		
		/*Method to put the rotated Tile back to original position*/
		public void rotateLeft() {
			Edge e;
			e = this.edges[0];
			for (int i=0; i<5; i++)	
				this.edges[i] = this.edges[i+1];
			this.edges[5] = e;
		}
		
		/*Check if Tile is compatible to the Tile on Right*/
		public boolean compatibleRight(Tile right) {
			if ((this.edges[1]).compatible(right.edges[4]))
				return true;
			return false;
		}
		
		/*Check if Tile is compatible to the Tile placed below towards left*/
		public boolean compatibleBelowLeft(Tile belowLeft) {
			if ((this.edges[3]).compatible(belowLeft.edges[0]))
				return true;
			return false;
		}
		
		/*Check if Tile is compatible to the Tile placed below towards right*/
		public boolean compatibleBelowRight(Tile belowRight) {
			if ((this.edges[2]).compatible(belowRight.edges[5]))
				return true;
			return false;
		}
}
