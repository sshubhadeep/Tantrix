/**
 * @author Shubhadeep Sarkar
 *
 */
package comp1110.ass2;


import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameGUI extends Application {

	/* Creating the constants */
	//private static int WIDTH = 1024;
	private static int WIDTH = 1024;
	//private static int HEIGHT = 768;
	private static int HEIGHT = 700;
	private static int TILES = 13;
	private static int STARTPOINTX = 150;
	private static int STARTPOINTY = 100;
	private static int HEX_SIDE = 52;
	private static int TILE_HEIGHT = 100;
	private static int TILE_WIDTH = 90;
	private static String SMILE_BASE_URI = "/resources/images/smiley.png";
	private static int SMILE_SIDE = 100;
	private static int SMILE_COX = 724;
	private static int SMILE_COY = 500;
	private static int CREDIT_WIDTH = 450;
	private static int CREDIT_HEIGHT = 250;
	
	/* Creating the attributes */
	private Button match;
	private Button line;
	private Button loop;
	private ToggleGroup toggleGroup;
	private RadioButton red;
	private RadioButton yellow;
	private RadioButton green;
	private Button createPuzzle;
	private ImageView smiley;
	private Text displayNoSoluion;
	private Text displayMatch;
	private Text displayLoop;
	private Text displayLine;
	private Text displayDifficulty;
	private Text displayDifficultyLevel;
	private Text displayCredit;
	private Text displayCreditShubhadeep;
	private Text displayHowToPlay;
	private Text displayAbout;
	private Text displayContact;
	private Text displayError;
	private Font font = new Font("Bookman Old Style", 25);
	private Font font1 = new Font("Bookman Old Style", 15);
	private char color='R';
	private ComboBox<String> comboBox=new ComboBox<String>();
	private Text displaySelction;
	private MenuBar menuBar;
	private Stage creditStage=new Stage();
	private Stage howToPlayStage=new Stage();
	private Stage aboutStage=new Stage();
	private Stage contactStage=new Stage();
	private Stage errorStage=new Stage();
	
	ArrayList<Integer> al=new ArrayList<Integer>();

	private MovableTile[] deck = new MovableTile[TILES];
	private static Polygon[] baseGrid = new Polygon[TILES];
	private static double[] baseCoX = new double[TILES];
	private static double[] baseCoY = new double[TILES];
	private static double[] deckCoX = new double[TILES];
	private static double[] deckCoY = new double[TILES];
	public Slider slider = new Slider();

	public static char[] gridArray = new char[] { ' ', ' ', ' ', ' ', ' ',
			' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
			' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	Game game=new Game();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tantrix Puzzle");
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		scene.setFill(Color.WHITESMOKE);

		/* Layout design for the base grid */
		createBase(root);

		/* Layout of the deck */
		createTileDeck(root);

		/* Layout of all buttons */
		createButtons(root);

		/* Layout of radio buttons */
		createRadioButtons(root);
		
		/* Layout of difficulty slider */
		createSlider(root);
		
		/* Layout of ComboBox */
		createComboBox(root);
		
		/* Layout of  createPuzzle Button*/
		createPuzzleButton(root);
		
		/* Layout of menuBar */
		createMenuBar(root);
		
		/* Layout of creditStage */
		createCreditStage(creditStage);
		
		/* Layout of howToPlayStage */
		createHowToPlayStage(howToPlayStage);
		
		/* Layout of aboutStage */
		createAboutStage(aboutStage);
		
		/* Layout of contactStage */
		createContactStage(contactStage);
		
		/* Layout of errorStage */
		createErrorStage(errorStage);
		
		/* Layout of smiley on successful solution */
		createSmiley(root);
		
		/* Layout to inform the user if solution is correct or not*/
		displayResult(root);

		/* Adding the window to the main container */
		primaryStage.setScene(scene);
		
		/* to display the layout */
		primaryStage.show();
	}

	/*
	 * generating coordinates of hexagons based on position and returning to
	 * createBase() method
	 */
	private double[] createCoordinates(int position) {
		double sin60 = Math.sin(Math.PI / 3);
		double baseX = 0;
		double baseY = 0;
		double A = HEX_SIDE / 2;
		double B = HEX_SIDE * sin60;
		double C = HEX_SIDE;

		/* creating the base points for hexagon */
		if (position < 4) {
			baseX = STARTPOINTX + (position * 2 * B);
			baseY = STARTPOINTY;
		}
		if (position >= 4 && position < 9) {
			baseX = STARTPOINTX - B + ((position - 4) * B * 2);
			baseY = STARTPOINTY + A + C;
		}
		if (position >= 9) {
			baseX = STARTPOINTX + ((position - 9) * B * 2);
			baseY = STARTPOINTY + 3 * C;
		}

		/* creating coordinate points based on base coordinate of each hexagon */
		double[] points = new double[] { baseX + B, baseY, baseX + 2 * B,
				baseY + A, baseX + 2 * B, baseY + A + C, baseX + B,
				baseY + 2 * C, baseX, baseY + A + C, baseX, baseY + A };
        
		/* saving the base co-ordinates for future use */
		baseCoX[position] = baseX;
		baseCoY[position] = baseY;
		return points;
	}

	/* creating the base layout */
	private void createBase(Group root) {
		for (int i = 0; i < TILES; i++) {
			Polygon p = new Polygon(createCoordinates(i));
			p.setFill(Color.PINK);
			root.getChildren().add(p);
			baseGrid[i] = p;
		}
	}

	/* create puzzle tile deck */
	private void createTileDeck(Group root) {
		for (int i = 0; i < TILES; i++) {
			deck[i] = new MovableTile(Tile.values()[i], this, i);
			deck[i].setFitHeight(TILE_HEIGHT);
			deck[i].setFitWidth(TILE_WIDTH);
			root.getChildren().add(deck[i]);
			if (i < 4) {
				deck[i].setLayoutX(7 * TILE_HEIGHT);
				deck[i].setLayoutY(2 * HEX_SIDE + i * (TILE_HEIGHT + 5));
			} else if (i < 8) {
				deck[i].setLayoutX(8 * TILE_HEIGHT);
				deck[i].setLayoutY(2 * HEX_SIDE + (i - 4) * (TILE_HEIGHT + 5));
			} else {
				deck[i].setLayoutX(9 * TILE_HEIGHT);
				deck[i].setLayoutY(HEX_SIDE + (i - 8) * (TILE_HEIGHT + 5));
			}

			deckCoX[i] = deck[i].getLayoutX();
			deckCoY[i] = deck[i].getLayoutY();

		}
	}

	/*Creating buttons to select solve match, solve line and solve loop*/
	private void createButtons(Group root) {
		match = new Button("Solve Match");
		match.setLayoutX(HEX_SIDE);
		match.setLayoutY(HEIGHT - 4 * HEX_SIDE + 10);
		root.getChildren().add(match);
		match.setOnMouseClicked(event -> {
			smiley.setOpacity(0);
			displayLoop.setOpacity(0);
			displayLine.setOpacity(0);
			displayMatch.setOpacity(0);
			displayNoSoluion.setOpacity(0);

			gridArray=game.solveMatch(0);
			display(gridArray);
		});

		line = new Button("Solve Line    ");
		line.setLayoutX(HEX_SIDE);
		line.setLayoutY(HEIGHT - 3 * HEX_SIDE);
		root.getChildren().add(line);
		line.setOnMouseClicked(event -> {
			smiley.setOpacity(0);
			displayLoop.setOpacity(0);
			displayLine.setOpacity(0);
			displayMatch.setOpacity(0);
			displayNoSoluion.setOpacity(0);

			gridArray=game.solveLine(color,0);
			display(gridArray);
		});

		loop = new Button("Solve Loop  ");
		loop.setLayoutX(HEX_SIDE);
		loop.setLayoutY(HEIGHT - 2 * HEX_SIDE - 10);
		root.getChildren().add(loop);
		loop.setOnMouseClicked(event -> {
			smiley.setOpacity(0);
			displayLoop.setOpacity(0);
			displayLine.setOpacity(0);
			displayMatch.setOpacity(0);
			displayNoSoluion.setOpacity(0);

			if(this.color=='Y' || this.color=='G')
				errorStage.show();
			else{
			gridArray=game.solveLoop('R',0);
			display(gridArray);
			}
		});
	}

	/* Creating radio buttons for color selection */
	private void createRadioButtons(Group root) {
		toggleGroup = new ToggleGroup();
		red = new RadioButton("Red");
		red.setLayoutX(4 * HEX_SIDE);
		red.setLayoutY(HEIGHT - 4 * HEX_SIDE + 10);
		red.setToggleGroup(toggleGroup);
		red.setSelected(true);
		root.getChildren().add(red);
		red.setOnMouseClicked(event -> {
			this.color='R';
		});
		
		yellow = new RadioButton("Yellow");
		yellow.setLayoutX(4 * HEX_SIDE);
		yellow.setLayoutY(HEIGHT - 3 * HEX_SIDE);
		yellow.setToggleGroup(toggleGroup);
		root.getChildren().add(yellow);
		yellow.setOnMouseClicked(event -> {
			this.color='Y';
		});
		
		green = new RadioButton("Green");
		green.setLayoutX(4 * HEX_SIDE);
		green.setLayoutY(HEIGHT - 2 * HEX_SIDE - 10);
		green.setToggleGroup(toggleGroup);
		root.getChildren().add(green);
		green.setOnMouseClicked(event -> {
			this.color='G';
		});

	}
	
	/* Creating slider to choose difficulty level of Tantrix */
	public void createSlider(Group root) {
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(100);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(20.0f);
		slider.setLayoutX(6 * HEX_SIDE);
		slider.setLayoutY(HEIGHT - 3 * HEX_SIDE -40);
		root.getChildren().add(slider);
		displayDifficulty = new Text(6 * HEX_SIDE + 20, HEIGHT - 3 * HEX_SIDE + 50, "Set Difficulty");
		displayDifficulty.toBack();
		displayDifficulty.setFont(font1);
		displayDifficulty.setOpacity(100);
		root.getChildren().add(displayDifficulty);
		Double d=slider.getValue();
		displayDifficultyLevel = new Text(6 * HEX_SIDE + 50, HEIGHT - 3 * HEX_SIDE + 20, d.toString());
		displayDifficultyLevel.toBack();
		displayDifficultyLevel.setFont(font1);
		displayDifficultyLevel.setOpacity(100);
		root.getChildren().add(displayDifficultyLevel);
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0,
					Number arg1, Number arg2) {
				long roundedValue=Math.round((double)arg2);
				Double changedValue=(double) roundedValue;
				displayDifficultyLevel.setText(changedValue.toString());
				
			}
		});
	}
	
	/* Creating comboBox to choose game type of Tantrix */
	public void createComboBox(Group root){
		comboBox.getItems().addAll("Match","Loop","Line");
		comboBox.toBack();
		comboBox.setValue("Match");
		comboBox.setLayoutX(10 * HEX_SIDE);
		comboBox.setLayoutY(HEIGHT - 3 * HEX_SIDE -40);
		comboBox.setOpacity(100);
		root.getChildren().add(comboBox);
		displaySelction = new Text(10 * HEX_SIDE -20, HEIGHT - 3 * HEX_SIDE + 20, "Set Puzzle Type");
		displaySelction.toBack();
		displaySelction.setFont(font1);
		displaySelction.setOpacity(100);
		root.getChildren().add(displaySelction);
	}
	
	/* Creating slider to generate a new game of Tantrix based on user specifications */
	public void createPuzzleButton(Group root){
		createPuzzle = new Button(" Create Puzzle ");
		createPuzzle.setLayoutX(10 * HEX_SIDE-7);
		createPuzzle.setLayoutY(HEIGHT - 3 * HEX_SIDE +40);
		root.getChildren().add(createPuzzle);
		createPuzzle.setOnMouseClicked(event -> {
			for (int i = 0; i < TILES; i++) {
				baseGrid[i].setOpacity(1);
			}
			displayLoop.setOpacity(0);
			displayLine.setOpacity(0);
			displayMatch.setOpacity(0);
			displayNoSoluion.setOpacity(0);
			String type=comboBox.getValue();
			if(type.equals("Match")){
				//System.out.println("Match is selected");
				gridArray=game.solveMatch(0);
				display(gridArray);
				removeTile();				
			}else if(type.equals("Loop")){
				//System.out.println("Loop is selected");
				gridArray=game.solveLoop('R',0);
				display(gridArray);
				removeTile();
			}else if(type.equals("Line")){
				//System.out.println("Line is selected");
				gridArray=game.solveLine(color,0);
				display(gridArray);
				removeTile();
			}
		});
	}
	
	/* To check if an element is existing in the arraylist, called by removeTile() method */
	public boolean checkInArrayList(int j){
		for(int i=0;i<al.size();i++){
			if(al.get(i)==j)
				return true;
		}
		return false;
	}
	
	/* To determine the difficulty level based on slider input, called by removeTile() method */
	public double getDifficultyLevel(double val){
		double margin=7.5;
		double diff=0.0;
		if(val<=margin)
			diff=0.0;
		else if(val>margin && val<=2*margin)
			diff=1.0;
		else if(val>2*margin && val<=3*margin)
			diff=2.0;
		else if(val>3*margin && val<=4*margin)
			diff=3.0;
		else if(val>4*margin && val<=5*margin)
			diff=4.0;
		else if(val>5*margin && val<=6*margin)
			diff=5.0;
		else if(val>6*margin && val<=7*margin)
			diff=6.0;
		else if(val>7*margin && val<=8*margin)
			diff=7.0;
		else if(val>8*margin && val<=9*margin)
			diff=8.0;
		else if(val>9*margin && val<=10*margin)
			diff=9.0;
		else if(val>10*margin && val<=11*margin)
			diff=10.0;
		else if(val>11*margin && val<=12*margin)
			diff=11.0;
		else if(val>12*margin)
			diff=12.0;
		return diff;
	}
	
	/* To remove tiles from the baseGrid as per the difficulty level */
	public void removeTile(){
		double val=slider.getValue();
		double diff=0.0;
		diff=getDifficultyLevel(val);
		//System.out.println(diff);
		int x=(int)diff;
		//System.out.println(x);
		for (int i=0;i<=x;i++){
			Random r =new Random();
			int j=r.nextInt(13);
			while(checkInArrayList(j)){
				j=r.nextInt(13);
			}
			for(MovableTile mt : deck){
				if (mt.getDeckPosition()==j){
					char ch=mt.tile.name().charAt(0);
					for(int s = 0; s < 13; s++){
						if (gridArray[s*2] == ch){
							gridArray[s*2] = ' ';
							gridArray[s*2 + 1] = ' ';
						}
					}
					mt.setLayoutX(deckCoX[j]);
					mt.setLayoutY(deckCoY[j]);
				}
			}
			//System.out.print(" "+j);
			al.add(j);
		}
		al.clear();
	}
	
	/* Creating menu bar to add menus to Tantrix */
	public void createMenuBar(Group root){
		menuBar = new MenuBar();
		menuBar.toBack();
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(0);
		menuBar.setPrefWidth(Double.MAX_VALUE);
		menuBar.setOpacity(0.5);;
		Menu file = new Menu("File");
		MenuItem newGame=new MenuItem("New");
		newGame.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		newGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	startNew();
            }
        });
		MenuItem exit=new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        
        file.getItems().addAll(newGame,exit);
        
        Menu help = new Menu("Help");
        MenuItem howToPlay=new MenuItem("How to play");
        howToPlay.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
        howToPlay.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	howToPlayStage.show();
            }
        });
        MenuItem credit=new MenuItem("Credit");
        credit.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        credit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	creditStage.show();
            }
        });
        MenuItem about=new MenuItem("About");
        about.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        about.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	aboutStage.show();
            }
        });
        
        help.getItems().addAll(about,credit,howToPlay);
        
        Menu feedback = new Menu("Feedback");
        MenuItem contactUs=new MenuItem("Contact Us");
        contactUs.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
        contactUs.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	contactStage.show();
            }
        });
        
        feedback.getItems().addAll(contactUs);
        
        menuBar.getMenus().addAll(file, /*edit, view,*/ help,feedback);
		root.getChildren().add(menuBar);
		menuBar.setOpacity(100);
	}
	
	/* To restart the Tantrix */
	public void startNew(){
		for(int i=0;i<13;i++){
			for(MovableTile mt : deck){
				if (mt.getDeckPosition()==i){
					char ch=mt.tile.name().charAt(0);
					for(int s = 0; s < 13; s++){
						if (gridArray[s*2] == ch){
							gridArray[s*2] = ' ';
							gridArray[s*2 + 1] = ' ';
						}
					}
					mt.setLayoutX(deckCoX[i]);
					mt.setLayoutY(deckCoY[i]);
				}
			}
		}
		
		for (int i = 0; i < TILES; i++) {
			baseGrid[i].setOpacity(1);
		}
		
		
		red.setSelected(true);
		color='R';
		slider.setValue(100);
		comboBox.setValue("Match");
		smiley.setOpacity(0);
		displayLoop.setOpacity(0);
		displayLine.setOpacity(0);
		displayMatch.setOpacity(0);
		displayNoSoluion.setOpacity(0);
	}
	
	/* Creating credit stage to display the credits of Tantrix */
	public void createCreditStage(Stage creditStage){
		creditStage.setTitle("Credits for Tantrix Puzzle");
		Group rootCredit = new Group();
		Scene sceneCredit = new Scene(rootCredit, CREDIT_WIDTH, CREDIT_HEIGHT);
		sceneCredit.setFill(Color.WHITE);
		creditStage.setScene(sceneCredit);
		displayCredit = new Text(100,50,"Designed and created by");
		displayCredit.toBack();
		displayCredit.setFont(font1);
		displayCredit.setOpacity(100);
		rootCredit.getChildren().add(displayCredit);
		displayCreditShubhadeep=new Text(100,100,"Shubhadeep Sarkar");
		displayCreditShubhadeep.toBack();
		displayCreditShubhadeep.setFont(font);
		displayCreditShubhadeep.setOpacity(100);
		rootCredit.getChildren().add(displayCreditShubhadeep);
	}
	
	/* Creating how to play stage to display the instructions of Tantrix */
	public void createHowToPlayStage(Stage howToPlayStage){
		howToPlayStage.setTitle("Instructions to play");
		Group rootHowToPlay = new Group();
		Scene sceneHowToPlay = new Scene(rootHowToPlay,600,300);
		sceneHowToPlay.setFill(Color.WHITE);
		howToPlayStage.setScene(sceneHowToPlay);
		displayHowToPlay = new Text(50,50,"1. Select difficulties using slider \n2. Select color using radio buttons \n3. Select game type from dropdown and then \n4. Click on create puzzle button to start a game. \n\nRemember, Loop is only possible for red color and \nMatch is not color dependent. \n\nTo check a sample solution to Solve Match, Solve Line, Solve Loop \nClick on respected buttons \nYou may choose color only for Solve Line");
		displayHowToPlay.toBack();
		displayHowToPlay.setFont(font1);
		displayHowToPlay.setOpacity(100);
		rootHowToPlay.getChildren().add(displayHowToPlay);
	}
	
	/* Creating about stage to display the brief idea of Tantrix */
	public void createAboutStage(Stage aboutStage){
		aboutStage.setTitle("About Tantrix");
		Group rootAbout = new Group();
		Scene sceneAbout = new Scene(rootAbout,370,160);
		sceneAbout.setFill(Color.WHITE);
		aboutStage.setScene(sceneAbout);
		displayAbout = new Text(20,20,"Tantrix is a hexagonal tile based abstract \ngame with 13 tiles. Each tile has 3 lines, \ngoing from one edge to another. These lines \nare of color Red,Green and Yellow. No two \ntiles are same. While playing tantrix player \nneeds to match the lines with nearby \ntiles to progress further in the \ngame.");
		displayAbout.toBack();
		displayAbout.setFont(font1);
		displayAbout.setOpacity(100);
		rootAbout.getChildren().add(displayAbout);
	}
	
	/* Creating contact stage to display the contact details for this game of Tantrix */
	public void createContactStage(Stage contactStage){
		contactStage.setTitle("Contact Us");
		Group rootContact = new Group();
		Scene sceneContact = new Scene(rootContact,370,160);
		sceneContact.setFill(Color.WHITE);
		contactStage.setScene(sceneContact);
		displayContact = new Text(75,50," Please drop me a mail \n\n with your feedback \n\n to sshubhadeep@gmail.com");
		displayContact.toBack();
		displayContact.setFont(font1);
		displayContact.setOpacity(100);
		rootContact.getChildren().add(displayContact);
		
	}
	
	/* Creating error stage to display the error on wrong input */
	public void createErrorStage(Stage errorStage){
		errorStage.setTitle("Error!!!");
		Group rootError = new Group();
		Scene sceneError = new Scene(rootError,300,100);
		sceneError.setFill(Color.WHITE);
		errorStage.setScene(sceneError);
		displayError = new Text(20,30,"Loop is not possible with this color. \n\nPlease select Red and try again");
		displayError.toBack();
		displayError.setFont(font1);
		displayError.setOpacity(100);
		rootError.getChildren().add(displayError);
	}
	
	/* Creating smiley to display when a solution is correct */
	private void createSmiley(Group root) {
		
		smiley = new ImageView(SMILE_BASE_URI);
		smiley.toBack();
		smiley.setLayoutX(SMILE_COX);
		smiley.setLayoutY(SMILE_COY);
		smiley.setFitHeight(SMILE_SIDE);
		smiley.setFitWidth(SMILE_SIDE);
		root.getChildren().add(smiley);
		smiley.setOpacity(0);
	}
	
	/* To display the result of a solution provided by a player */
	private void displayResult(Group root) {
		displayNoSoluion=new Text(SMILE_COX-70, 620, "This is not a Solution");
		displayNoSoluion.toBack();
		displayNoSoluion.setFont(font);
		displayNoSoluion.setOpacity(0);
		root.getChildren().add(displayNoSoluion);
        displayMatch = new Text(SMILE_COX-70, 640, "The solution is a Match");
        displayMatch.toBack();
        displayMatch.setFont(font);
        displayMatch.setOpacity(0);
		root.getChildren().add(displayMatch);
		displayLine = new Text(SMILE_COX-70, 660, "The solution is a Line");
		displayLine.toBack();
		displayLine.setFont(font);
		displayLine.setOpacity(0);
		root.getChildren().add(displayLine);
		displayLoop = new Text(SMILE_COX-70, 680, "The solution is a Loop");
		displayLoop.toBack();
		displayLoop.setFont(font);
		displayLoop.setOpacity(0);
		root.getChildren().add(displayLoop);
	}

	/* Re-painting the tiles based on a predefined combination*/
	public void display(char []  arr){
		for (int i = 0; i < TILES; i++){
			char tileName= arr[2*i];
			char tileRotation=arr[2*i+1];
			int rotation=Character.getNumericValue(tileRotation);
			for(MovableTile mt : deck){
				if (mt.tile.name().charAt(0)==tileName){
					mt.setLayoutX(baseCoX[i]);
					mt.setLayoutY(baseCoY[i]);
					mt.rotateRight(rotation);
				}
			}
		}
		displayLoop.setOpacity(0);
		displayLine.setOpacity(0);
		displayMatch.setOpacity(0);
		displayNoSoluion.setOpacity(0);
	}

	/* Highlight the nearest hexagon where tile is being dragged */
	public void highlightNearestHexagon(MovableTile m) {
		int position = nearestHexagon(m);
		for (int i = 0; i < TILES; i++) {
			baseGrid[i].setOpacity((i == position) ? 0.3 : 1);
		}
	}
	
	/* Find out the nearest hexagon to the dragged tile */
	public int nearestHexagon(MovableTile m) {
		double coX = m.getLayoutX() + 3 * TILE_WIDTH / 2;
		double coY = m.getLayoutY() + 3 * TILE_HEIGHT / 2;

		for (int i = 0; i < 13; i++) {
			if (coX >= baseCoX[i] && coX < baseCoX[i] + 2 * TILE_WIDTH
					&& coY >= baseCoY[i] && coY < baseCoY[i] + 2 * TILE_HEIGHT && gridArray[i*2] == ' ')
				return i;
		}
		return -1;
	}

	/* Gives the position where tiles are allowed or disallowed */
	public void attemptToMove(MovableTile m, int deckPosition) {
		int position = nearestHexagon(m);
		if (position == -1) {
			char x=m.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gridArray[i*2] == x){
					gridArray[i*2] = ' ';
					gridArray[i*2 + 1] = ' ';
				}
			}
			
			for (int i = 0; i < 13; i++)
				//System.out.print(" " + gridArray[i*2] + gridArray[i*2 +1]);
				m.setLayoutX(deckCoX[deckPosition]);
				m.setLayoutY(deckCoY[deckPosition]);
		}else {
			char x=m.tile.name().charAt(0);
			for(int i = 0; i < 13; i++){
				if (gridArray[i*2] == x){
					gridArray[i*2] = ' ';
					gridArray[i*2 + 1] = ' ';
				}
			}
			gridArray[position * 2] = x;
			gridArray[position*2 + 1] = m.getTileRotation();
			m.setLayoutX(baseCoX[position]);
			m.setLayoutY(baseCoY[position]);
		}
		
	}
	
	/* Solution check after every move of any Tile */
	public void checkPuzzle(){
		boolean check=true;
		
		/*System.out.println();
		for (int i = 0; i < 13; i++)
			System.out.print(" " + gridArray[i*2] + gridArray[i*2 +1]);*/
		
		/* check if the solution is complete*/
		for(int i = 0; i < 26; i++){
			if (gridArray[i] == ' '){
				check=false;
				smiley.setOpacity(0);
				displayLoop.setOpacity(0);
				displayLine.setOpacity(0);
				displayMatch.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}
		}
		
		/* check the complete solution is correct or wrong */
		if(check){
			if (game.isLoop('R',gridArray))
			{
				smiley.setOpacity(100);
				displayLoop.setOpacity(100);
				displayLine.setOpacity(0);
				displayMatch.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}
			else if (game.isLine('G',gridArray))
			{
				smiley.setOpacity(100);
				displayLine.setOpacity(100);
				displayLoop.setOpacity(0);
				displayMatch.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}else if (game.isLine('Y',gridArray))
			{
				smiley.setOpacity(100);
				displayLine.setOpacity(100);
				displayLoop.setOpacity(0);
				displayMatch.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}else if (game.isLine('R',gridArray))
			{
				smiley.setOpacity(100);
				displayLine.setOpacity(100);
				displayLoop.setOpacity(0);
				displayMatch.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}
			else if (game.isMatch(gridArray))
			{
				smiley.setOpacity(100);
				displayMatch.setOpacity(100);
				displayLine.setOpacity(0);
				displayLoop.setOpacity(0);
				displayNoSoluion.setOpacity(0);
			}else {
				displayNoSoluion.setOpacity(100);
				displayLine.setOpacity(0);
				displayMatch.setOpacity(0);
				displayLoop.setOpacity(0);
				smiley.setOpacity(0);
			}
		}
	}
	
	/*Method to start the GUI of the game*/
	public static void start() {
		Application.launch();
	}
}
