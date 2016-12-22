package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.HashMap;




import java.util.Random;

//import javafx.application.Application;
import comp1110.ass2.Tile;

/**
 * @author Shubhadeep Sarkar
 *
 */
public class Game implements Tantrix {

	/* Defining constants */
	public static int TILES = 13;
	public static int randomValue=0;

	/* Defining attributes */
	HashMap<String,Integer> commonEdgeMap = new HashMap<>();
	HashMap<String,Integer> commonEdgeMap1 = new HashMap<>();

	/* this ArrayList represents the 4-5-4 grid of cards */
	private static ArrayList<Tile> grid = new ArrayList<Tile>(Arrays.asList(
			null, null, null, null, null, null, null, null, null, null, null,
			null, null));

	/* constructor calling the parent class's (Object class) constructor */
	Game() {
		super();
		initialize();
	}
	
	/* To initialize*/
	private void initialize(){
		commonEdgeMap.put("01",1);
		commonEdgeMap.put("04",3);
		commonEdgeMap.put("05",2);
		commonEdgeMap.put("10",4);
		commonEdgeMap.put("12",1);
		commonEdgeMap.put("15",3);
		commonEdgeMap.put("16",2);
		commonEdgeMap.put("21",4);
		commonEdgeMap.put("23",1);
		commonEdgeMap.put("26",3);
		commonEdgeMap.put("27",2);
		commonEdgeMap.put("32",4);
		commonEdgeMap.put("38",2);
		commonEdgeMap.put("37",3);
		commonEdgeMap.put("40",0);
		commonEdgeMap.put("49",2);
		commonEdgeMap.put("45",1);
		commonEdgeMap.put("50",5);
		commonEdgeMap.put("51",0);
		commonEdgeMap.put("54",4);
		commonEdgeMap.put("56",1);
		commonEdgeMap.put("59",3);
		commonEdgeMap.put("510",2);
		commonEdgeMap.put("61",5);
		commonEdgeMap.put("62",0);
		commonEdgeMap.put("65",4);
		commonEdgeMap.put("67",1);
		commonEdgeMap.put("610",3);
		commonEdgeMap.put("611",2);
		commonEdgeMap.put("72",5);
		commonEdgeMap.put("73",0);
		commonEdgeMap.put("76",4);
		commonEdgeMap.put("78",1);
		commonEdgeMap.put("711",3);
		commonEdgeMap.put("712",2);
		commonEdgeMap.put("83",5);
		commonEdgeMap.put("87",4);
		commonEdgeMap.put("812",3);
		commonEdgeMap.put("910",1);
		commonEdgeMap.put("94",5);
		commonEdgeMap.put("95",0);
		commonEdgeMap.put("1011",1);
		commonEdgeMap.put("106",0);
		commonEdgeMap.put("105",5);
		commonEdgeMap.put("109",4);
		commonEdgeMap.put("1110",4);
		commonEdgeMap.put("1112",1);
		commonEdgeMap.put("116",5);
		commonEdgeMap.put("117",0);
		commonEdgeMap.put("127",5);
		commonEdgeMap.put("128",0);
		commonEdgeMap.put("1211",4);
		
		commonEdgeMap1.put("01", 1);
		commonEdgeMap1.put("02", 5);
		commonEdgeMap1.put("03", 4);
		commonEdgeMap1.put("11", 2);
		commonEdgeMap1.put("12", 6);
		commonEdgeMap1.put("13", 5);
		commonEdgeMap1.put("14", 0);
		commonEdgeMap1.put("21", 3);
		commonEdgeMap1.put("22", 7);
		commonEdgeMap1.put("23", 6);
		commonEdgeMap1.put("24", 1);
		commonEdgeMap1.put("32", 8);
		commonEdgeMap1.put("33", 7);
		commonEdgeMap1.put("34", 2);
		commonEdgeMap1.put("40", 0);
		commonEdgeMap1.put("41", 5);
		commonEdgeMap1.put("42", 9);
		commonEdgeMap1.put("50", 1);
		commonEdgeMap1.put("51", 6);
		commonEdgeMap1.put("52", 10);
		commonEdgeMap1.put("53", 9);
		commonEdgeMap1.put("54", 4);
		commonEdgeMap1.put("55", 0);
		commonEdgeMap1.put("60", 2);
		commonEdgeMap1.put("61", 7);
		commonEdgeMap1.put("62", 11);
		commonEdgeMap1.put("63", 10);
		commonEdgeMap1.put("64", 5);
		commonEdgeMap1.put("65", 1);
		commonEdgeMap1.put("70", 3);
		commonEdgeMap1.put("71", 8);
		commonEdgeMap1.put("72", 12);
		commonEdgeMap1.put("73", 11);
		commonEdgeMap1.put("74", 6);
		commonEdgeMap1.put("75", 2);
		commonEdgeMap1.put("83", 12);
		commonEdgeMap1.put("84", 7);
		commonEdgeMap1.put("85", 3);
		commonEdgeMap1.put("90", 5);
		commonEdgeMap1.put("91", 10);
		commonEdgeMap1.put("95", 4);
		commonEdgeMap1.put("100", 6);
		commonEdgeMap1.put("101", 11);
		commonEdgeMap1.put("104", 9);
		commonEdgeMap1.put("105", 5);
		commonEdgeMap1.put("110", 7);
		commonEdgeMap1.put("111", 12);
		commonEdgeMap1.put("114", 10);
		commonEdgeMap1.put("115", 6);
		commonEdgeMap1.put("120", 8);
		commonEdgeMap1.put("124", 11);
		commonEdgeMap1.put("125", 7);
		
	}

	@Override
	/* Overriding solveMatch method of Tantrix interface */
	public char[] solveMatch(double difficulty) {
		/* testing and returning some hard coded solution of solveMatch method */
		String solStr = "";
		Random random=new Random();
		int i=random.nextInt(5);
		
		while (i==randomValue)
			i=random.nextInt(5);
		if(i==0)
			solStr = "K0L4D0I1J0C3E5H3M5B2A4F2G1";
		else if(i==1)
			solStr = "J0F1L1E0K0G4D0H2M1A5B2I4C1";
		else if(i==2)
			solStr = "H0E2C0I1D2G3J2L3K4F4B4M1A2";
		else if(i==3)
			solStr = "B0C4E0L1D0A2I5F5G2H3K3M5J4";
		else
			solStr = "H0L1E0M0A2C2J5B1D2F4I3K5G0";
		
		char[] sol = solStr.toCharArray();
		randomValue=i;
		if (isMatch(sol))
			return sol;

		/* if the above hard coded solutions are not a match then return null */
		return null;
	}

	@Override
	/* Overriding solveLine method of Tantrix interface */
	public char[] solveLine(char color, double difficulty) {
		/* testing and returning some hard coded solution of solveLine method */
		String solStr = "";
		Random random=new Random();
		int i=random.nextInt(5);
		
		while (i==randomValue)
			i=random.nextInt(5);
		
		if(color == 'G' || color == 'g'){
			if(i==0)
				solStr = "H3J0K0M4A0D0C1F4L4B5E1I4G4";
			else if(i==1)
				solStr = "K0L4I0A1M2G4B0C5F0H3J3E1D4";
			else if(i==2)
				solStr = "K0L4I0M4A5G4B0C5F0H3J3E1D4";
			else if(i==3)
				solStr = "H0L1F1D1M2E1A4C3G3I4K0J0B4";
			else
				solStr = "H0B0G1E0M2F2A3L1D2C4K0J3I3";
		}
		else if(color == 'R' || color == 'r'){
			if(i==0)
				solStr = "A3E2D4I0C2G1J3B4H4K2M2L4F5";
			else if(i==1)
				solStr = "E0L1H0D0M0B1J0A2K4I3F5C1G1";
			else if(i==2)
				solStr = "A0E2B1J3D4H3C3F0G0L4M2I3K1";
			else if(i==3)
				solStr = "M0H4F4E1C2D1J1L3G0I3B3A3K1";
			else
				solStr = "L0B0C4E0G1H0I2D5K0F1A3M2J0";
		} 
		else if (color == 'Y' || color == 'y') {
			if(i==0)
				solStr = "E1L0H1K2A2F0D5I3M2C3G3B1J3";
			else if(i==1)
				solStr = "K0E1G0L0I2A5D2B5C1M4F3H5J3";
			else if(i==2)
				solStr = "J0L4H1I4K0C3D5A1E4M4F0G0B1";
			else if(i==3)
				solStr = "C0E1D4H3J5A5I1M3B0L3G3F3K4";
			else
				solStr = "L0C4I3A3D2H5J3E0M2K5F0G0B1";
		}
		
		randomValue=i;
		char[] sol = solStr.toCharArray();
		if (isLine(color, sol))
			return sol;
		
		/* if the above hard coded solutions are not a line then return null */
		return null;
	}

	@Override
	/* Overriding solveLoop method of Tantrix interface */
	public char[] solveLoop(char color, double difficulty) {
		/* testing and returning some hard coded solutions of solveLoop method */
		String solStr = "";
		Random random=new Random();
		int i=random.nextInt(5);
		while (i==randomValue)
			i=random.nextInt(5);
		if(i==0)
			solStr = "F2G5E0H1C2D1K2J5L2I3A3B0M2";
		else if(i==1)
			solStr = "M5D0C3F3L5E5H3J0I1K2B3A0G1";
		else if(i==2)
			solStr = "K4F4J3E1H5D3L3C0I1G2B0A3M2";
		else if(i==3)
			solStr = "C2H1D4L1J2E3G2F5I1M3A0B3K1";
		else
			solStr = "H0C4J3E1I4D3L3F0G0M3B0A3K1";
		
		char[] sol = solStr.toCharArray();
		randomValue=i;
		if (isLoop(color, sol))
			return sol;

		/* if the above hard coded solutions are not a loop then return null */
		return null;
	}

	@Override
	/* Overriding isMatch method of Tantrix interface */
	public boolean isMatch(char[] tiles) {
		Tile[] g = new Tile[TILES];

		/* checking for any null character */
		for (int i = 0; i < tiles.length; i++)
			if (tiles[i] == ' ')
				return false;

		/* rotating the tiles as per the character array received */
		for (int i = 0; i < (tiles.length - 1); i = i + 2) {
			char x = tiles[i];
			int k;
			Character y = tiles[i + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateRight();

			/*
			 * adding the tiles to grid with proper position as per the received
			 * array
			 */
			grid.set(i / 2, e);
		}

		/* converting the grid to an array of Tiles */
		grid.toArray(g);
		Boolean state = true;

		/* check logic to figure if it is a match or not */
		for (int i = 0; i < (g.length - 1); i++) {
			if (i < 4) {
				if ((i == 3)
						&& (g[i + 4] == null || g[i]
								.compatibleBelowLeft(g[i + 4]))
						&& (g[i + 5] == null || g[i]
								.compatibleBelowRight(g[i + 5])) && state)
					state = true;
				else if ((g[i + 4] == null || g[i]
						.compatibleBelowLeft(g[i + 4]))
						&& (g[i + 5] == null || g[i]
								.compatibleBelowRight(g[i + 5]))
						&& (g[i + 1] == null || g[i].compatibleRight(g[i + 1]))
						&& state)
					state = true;
				else
					state = false;
			} else if (i < 9) {
				if (i == 8
						&& (g[i + 4] == null || g[i]
								.compatibleBelowLeft(g[i + 4])) && state)
					state = true;
				else if (i == 4
						&& (g[i + 1] == null || g[i].compatibleRight(g[i + 1]))
						&& (g[i + 5] == null || g[i]
								.compatibleBelowRight(g[i + 5])) && state)
					state = true;
				else if (i != 8
						&& (g[i + 4] == null || g[i]
								.compatibleBelowLeft(g[i + 4]))
						&& (g[i + 5] == null || g[i]
								.compatibleBelowRight(g[i + 5]))
						&& (g[i + 1] == null || g[i].compatibleRight(g[i + 1]))
						&& state)
					state = true;
				else
					state = false;
			} else {
				if ((g[i + 1] == null || g[i].compatibleRight(g[i + 1]))
						&& state)
					state = true;
				else
					state = false;
			}

		}

		/* Rotating back the Tiles to their actual positions */
		for (int i = 0; i < (tiles.length - 1); i = i + 2) {
			char x = tiles[i];
			int k;
			Character y = tiles[i + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateLeft();
		}

		/* state will be true if it is a match */
		return state;
	}

	@Override
	/* Overriding isLine method of Tantrix interface */
	public boolean isLine(char color, char[] tiles) {
		
		if(isMatch(tiles)){
		Color c;
		switch (color) {
		case 'r':
		case 'R':
			c = Color.R;
			break;
		case 'y':
		case 'Y':c = Color.Y;
		break;
		case 'g':
		case 'G':
		default:
			c = Color.G;
		}
		Tile[] g = new Tile[TILES];

		/* checking for any null character */
		for (int i = 0; i < tiles.length; i++)
			if (tiles[i] == ' ')
				return false;

		/* rotating the tiles as per the character array received */
		for (int i = 0; i < (tiles.length - 1); i = i + 2) {
			char x = tiles[i];
			int k;
			Character y = tiles[i + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateRight();
			grid.set(i / 2, e);
		}

		/* converting the grid to an array of Tiles */
		grid.toArray(g);
		
		ArrayList<Boolean> flaBoolean = new ArrayList<>();
		
		/*check which edge of tile class has the given color*/
		for (int i = 0; i < g.length; i++) {
			ArrayList<Integer> matchedEdges = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
					if(g[i].edges[j].getColor().equals(c)){
						matchedEdges.add(j);
					}
			}
			
			int matchCnt = 0;
			for (int l = 0; l < matchedEdges.size(); l++) {
				Integer cardNumber  = getCommonEdge1(i, matchedEdges.get(l));
				if(cardNumber != -1  && g[i].edges[matchedEdges.get(l)].getColor().equals(c) && (g[cardNumber].edges[getCommonEdge(cardNumber, i)]).getColor().equals(c)){
					matchCnt++;
				}
			}
			if(matchCnt == matchedEdges.size())
			{
				flaBoolean.add(true);
			}
		}
		
		/* Rotating back the Tiles to their actual positions */
		for (int u = 0; u < (tiles.length - 1); u = u + 2) {
			char x = tiles[u];
			int k;
			Character y = tiles[u + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateLeft();
		}
		if(flaBoolean.size() == 11)
			return true;
		}
		return false;
	}
	
	/* To get the common edge */
	public int getCommonEdge(int tile1,int tileNum){
		if(commonEdgeMap.get(""+tile1+tileNum) == null)
			return -1;
		return commonEdgeMap.get(""+tile1+tileNum);
	}
	
	/* To get the common edge */
	public int getCommonEdge1(int tile1,int tileNum){
		if(commonEdgeMap1.get(""+tile1+tileNum) == null)
			return -1;
		return commonEdgeMap1.get(""+tile1+tileNum);
	}

	@Override
	/* Overriding isLoop method of Tantrix interface */
	public boolean isLoop(char color, char[] tiles) {

		/* determining input color using switch structure */
		Color c;
		switch (color) {
		case 'r':
		case 'R':
			c = Color.R;
			break;
		case 'y':
		case 'Y':c = Color.Y;
		break;
		case 'g':
		case 'G':
		default:
			c = Color.G;
		}
		Tile[] g = new Tile[TILES];

		/* checking for any null character */
		for (int i = 0; i < tiles.length; i++)
			if (tiles[i] == ' ')
				return false;

		/* rotating the tiles as per the character array received */
		for (int i = 0; i < (tiles.length - 1); i = i + 2) {
			char x = tiles[i];
			int k;
			Character y = tiles[i + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateRight();
			grid.set(i / 2, e);
		}

		/* converting the grid to an array of Tiles */
		grid.toArray(g);

		boolean[] flag = new boolean[] { false, false, false, false, false,
				false, false, false, false, false, false, false, false };

		/* start testing from initial Tile */
		int next = 0;
		int prev = 0;
		flag[0] = true;

		/* check logic to figure if it is a loop or not */
		for (int i = 0; i <=g.length; i++) {
			if (next == 0) {
				if(prev == 0){
					if (g[next].edges[1].getColor() == c) {
						prev = next;
						next = 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c) {
						prev = next;
						next = 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c) {
						prev = next;
						next = 4;
						flag[next] = true;
					}
				}else if (prev == 1){
					if(g[next].edges[1].getColor() == c)
						flag[next] = true;
					else
						flag[next] = false;
				}else if (prev == 4){
					if(g[next].edges[3].getColor() == c)
						flag[next] = true;
					else
						flag[next] = false;
				}else if (prev == 5){
					if(g[next].edges[2].getColor() == c)
						flag[next] = true;
					else
						flag[next] = false;
				}
			} else if (next == 3) {
				if (prev == 2) {
					if (g[next].edges[3].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					}
				} else if (prev == 7) {
					if (g[next].edges[4].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					}
				} else if (prev == 8) {
					if (g[next].edges[4].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				}
			} else if (next == 4) {
				if (prev == 0) {
					if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					}
				} else if (prev == 5) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					}
				} else if (prev == 9) {
					if (g[next].edges[0].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					}
				}
			} else if (next == 8) {
				if (prev == 3) {
					if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				} else if (prev == 7) {
					if (g[next].edges[3].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 12) {
					if (g[next].edges[4].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				}
			} else if (next == 9) {
				if (prev == 4) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					}
				} else if (prev == 5) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					}
				} else if (prev == 10) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				}
			} else if (next == 12) {
				if (prev == 7) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 8) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 11) {
					if (g[next].edges[0].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				}
			} else if (next == 1) {
				if (prev == 0) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				} else if (prev == 5) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 6) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				} else if (prev == 2) {
					if (g[next].edges[2].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 2) {
				if (prev == 1) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				} else if (prev == 6) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 7) {
					if (g[next].edges[1].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					}
				} else if (prev == 3) {
					if (g[next].edges[2].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c  && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 10) {
				if (prev == 5) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 6) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 9) {
					if (g[next].edges[0].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 11) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 11) {
				if (prev == 6) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 7) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 10) {
					if (g[next].edges[0].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 12) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 5) {
				if (prev == 0) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 1) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 4) {
					if (g[next].edges[0].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 6) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 9) {
					if (g[next].edges[0].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 10) {
					if (g[next].edges[0].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 6) {
				if (prev == 1) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 2) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 5) {
					if (g[next].edges[0].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 7) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 10) {
					if (g[next].edges[0].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 11) {
					if (g[next].edges[0].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[2].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			} else if (next == 7) {
				if (prev == 2) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 3) {
					if (g[next].edges[5].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[0].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 6) {
					if (g[next].edges[0].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[4].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					}
				} else if (prev == 8) {
					if (g[next].edges[0].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[1].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 11) {
					if (g[next].edges[0].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[2].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next + 5;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[3].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				} else if (prev == 12) {
					if (g[next].edges[0].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 4;
						flag[next] = true;
					} else if (g[next].edges[1].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 1;
						flag[next] = true;
					} else if (g[next].edges[5].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 5;
						flag[next] = true;
					} else if (g[next].edges[3].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next + 4;
						flag[next] = true;
					} else if (g[next].edges[4].getColor() == c && g[next].edges[5].getColor() == c) {
						prev = next;
						next = next - 1;
						flag[next] = true;
					}
				}
			}
		}

		/* Rotating back the Tiles to their actual positions */
		for (int i = 0; i < (tiles.length - 1); i = i + 2) {
			char x = tiles[i];
			int k;
			Character y = tiles[i + 1];
			String s = y.toString();
			k = Integer.parseInt(s);
			Tile e = Tile.getTile(x);
			for (int j = 0; j < k; j++)
				e.rotateLeft();
		}

		boolean loop = true;

		/*
		 * check logic to figure out if any Tile is missed while forming the
		 * loop
		 */
		for (int i = 0; i < flag.length; i++) {
			if (flag[i] != true)
				loop = false;
		}

		/*
		 * if the control is back to the start Tile and if all Tile traversed it
		 * is a Loop
		 */
		if (next == 0 && loop)
			return true;

		/* If not a loop */
		return false;
	}

	public static void main(String[] args) {
		
		
		/* Call start method to start displaying the GUI of Tantrix */
		GameGUI.start();
	}
}
