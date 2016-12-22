/**
 * @author Shubhadeep Sarkar
 *
 */
package comp1110.ass2;

import java.net.URL;

import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class MovableTile extends ImageView {
	/*creating constants*/
	private static final String TILE_BASE_URI = "/resources/images/tile";
	private final URL AUDIO_BASE_URI = MovableTile.class
			.getResource("/resources/music/128919__ecfike__click-2.wav");
	
	/*creating attributes*/
	private int deckPosition;
	private int tileRotation=0;
	private double scenex, sceney, xbase, ybase;
	private boolean dragged = false;
	Tile tile;
	GameGUI gameGUI;

	/**
	 * @return the deckPosition
	 */
	public int getDeckPosition() {
		return deckPosition;
	}

	/**
	 * @param deckPosition the deckPosition to set
	 */
	public void setDeckPosition(int deckPosition) {
		this.deckPosition = deckPosition;
	}
	

	/**
	 * @return the tileRotation
	 */
	public char getTileRotation() {
		String s=Integer.toString(tileRotation);
		return s.charAt(0) ;
	}

	/**
	 * @param tileRotation the tileRotation to set
	 */
	public void setTileRotation(int tileRotation) {
		this.tileRotation = tileRotation;
	}

    /* constructor for MovableTile*/
	public MovableTile(Tile Tile, GameGUI gameGUI, int deckPosition) {
		super(MovableTile.class.getResource(
				TILE_BASE_URI + Tile.toString() + ".png").toString());
		this.tile = Tile;
		this.gameGUI = gameGUI;
		this.setDeckPosition(deckPosition);
		
		/*Invoked when the mouse is pressed on a Movable Tile*/
		this.setOnMousePressed(event -> {
			scenex = event.getSceneX();
			sceney = event.getSceneY();
			xbase = getLayoutX();
			ybase = getLayoutY();
			event.consume();
		});
		
		/*Invoked when the mouse dragged a Movable Tile*/
		this.setOnMouseDragged(event -> {
			toFront();
			dragged = true;
			
			/* move Tile by same amount as the mouse */
			setLayoutX(xbase + event.getSceneX() - scenex);
			setLayoutY(ybase + event.getSceneY() - sceney);
			scenex = event.getSceneX();
			sceney = event.getSceneY();
			xbase = getLayoutX();
			ybase = getLayoutY();
			
			gameGUI.highlightNearestHexagon(this);
			event.consume();
		});
		
		/*Invoked when the mouse is released from the Movable Tile*/
		this.setOnMouseReleased(event -> {
			AudioClip tileReleaseClip = new AudioClip(AUDIO_BASE_URI.toString());
			tileReleaseClip.play();
			if (!dragged){
				rotate();
			}
			else {
				gameGUI.attemptToMove(this,deckPosition);
				dragged = false;
			}
			gameGUI.checkPuzzle();
			event.consume();
		});
	}
	
	/*Rotate the tiles by 60 degree on mouse click*/
	@SuppressWarnings("static-access")
	private void rotate() {
		char x;
		switch (tileRotation) {
		case 0:
			this.setRotate(60);
			tileRotation++;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;
		case 1:
			this.setRotate(120);
			tileRotation++;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;
		case 2:
			this.setRotate(180);
			tileRotation++;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;
		case 3:
			this.setRotate(240);
			tileRotation++;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;
		case 4:
			this.setRotate(300);
			tileRotation++;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;
		case 5:
			this.setRotate(360);
			tileRotation = 0;
			x=this.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gameGUI.gridArray[i*2] == x)
					gameGUI.gridArray[i*2 + 1] = this.getTileRotation();
			}
			break;

		default:this.setRotate(0);
			break;
		}
	
	}
	
	/*Rotate the tiles by 60 degree on mouse click used for display() method in GameGUI.java*/
	public void rotateRight(int rotate) {
		switch (rotate) {
		case 0:
			this.setRotate(0);
			this.tileRotation=rotate;
			break;
		case 1:
			this.setRotate(60);
			this.tileRotation=rotate;
			break;
		case 2:
			this.setRotate(120);
			this.tileRotation=rotate;
			break;
		case 3:
			this.setRotate(180);
			this.tileRotation=rotate;
			break;
		case 4:
			this.setRotate(240);
			this.tileRotation=rotate;
			break;
		case 5:
			this.setRotate(300);
			this.tileRotation=rotate;
			break;

		default:this.setRotate(0);
			break;
		}
	
	}
}
