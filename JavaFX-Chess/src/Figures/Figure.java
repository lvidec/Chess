package Figures;

import Chess.ChessBoard;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Figure extends StackPane {
	
	protected FigureType type;
	protected ImageView image;
	protected int x;
	protected int y;
	private String name;
	
	public Figure(FigureType type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
		
		relocate(x * ChessBoard.TILE_SIZE, y * ChessBoard.TILE_SIZE);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public ImageView getImage() {
		return image;
	}
	public void setImage(ImageView image) {
		this.image = image;
	}
	
	public FigureType getType() {
		return type;
	}
	public void setType(FigureType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public static final String rookBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\Rook.png";
	public static final String knightBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\Knight.png";
	public static final String bishopBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\Bishop.png";
	public static final String queenBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\Queen.png";
	public static final String kingBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\King.png";
	public static final String pawnBlack = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\Pawn.png";
	
	public static final String rookWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\RookWhite.png";
	public static final String knightWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\KnightWhite.png";
	public static final String bishopWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\BishopWhite.png";
	public static final String queenWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\QueenWhite.png";
	public static final String kingWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\KingWhite.png";
	public static final String pawnWhite = "file:C:\\Java\\Chess\\JavaFX-Chess\\Images\\PawnWhite.png";
	
}



