package Chess;
import java.util.ArrayList;
import java.util.List;

import Figures.Bishop;
import Figures.Figure;
import Figures.FigureType;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class ChessBoard {
	
	public static final int TILE_SIZE = 100;

	protected static Pane pane = new Pane();
	
	public static final int width = 8;
	public static final int height = 8;

	protected static Tile[][] board = new Tile[width][height];
	
	protected static Group tileGroup = new Group();
	protected static Group figureGroup = new Group();

	protected static List<Figure> listOfFigures = new ArrayList<>();
	
	
	
	protected static Parent createContent() {
		pane.setPrefSize(width * ChessBoard.TILE_SIZE, height * ChessBoard.TILE_SIZE);
		pane.getChildren().addAll(tileGroup, /*ChessBoard.board,*/ figureGroup);
		
		for( int x = 0; x < height; x++) {
			for( int y = 0; y < width; y++) {
				boolean light;
				if( (x + y) % 2 == 0)
					light = true;
				else
					light = false;
				
				Tile tile = new Tile(light, x, y);
				board[x][y] = tile;
				
				tileGroup.getChildren().add(tile);
				
				
				
				//Black Figures
				if( x == 0 && y == 0 ) {
					Figure figure = new Rook(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if( x == 7 && y == 0) {
					Figure figure = new Rook(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if( x == 1 && y == 0 || x == 6 && y == 0) {
					Figure figure = new Knight(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}				
				else if( x == 2 && y == 0 || x == 5 && y == 0) {
					Figure figure = new Bishop(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if( x == 3 && y == 0) {
					Figure figure = new Queen(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}				
				else if( x == 4 && y == 0) {
					Figure figure = new King(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if(y == 1) {
					Figure figure = new Pawn(FigureType.BLACK, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}

				//White Figures
				else if( x == 0 && y == 7 || x == 7 && y == 7) {
					Figure figure = new Rook(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if( x == 1 && y == 7 || x == 6 && y == 7) {
					Figure figure = new Knight(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}				
				else if( x == 2 && y == 7 || x == 5 && y == 7) {
					Figure figure = new Bishop(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if( x == 3 && y == 7) {
					Figure figure = new Queen(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}				
				else if( x == 4 && y == 7) {
					Figure figure = new King(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
				else if(y == 6) {
					Figure figure = new Pawn(FigureType.WHITE, x, y);
					listOfFigures.add(figure);
					tile.setFigure(figure);
					figureGroup.getChildren().add(figure);
				}
			
			}
		}
		
		
		
		return pane;
	}
	
	
	
	
	
}
	
//	public static Figure rookL = new Rook(FigureType.BLACK, 0, 0);
//	public static Figure knightL = new Knight(FigureType.BLACK, 1, 0);
//	public static Figure bishopL = new Bishop(FigureType.BLACK, 2, 0);
//	public static Figure queen = new Queen(FigureType.BLACK, 3, 0);
//	public static Figure king = new King(FigureType.BLACK, 4, 0);
//	public static Figure bishopR = new Bishop(FigureType.BLACK, 5, 0);
//	public static Figure knightR = new Knight(FigureType.BLACK, 6, 0); 
//	public static Figure rookR = new Rook(FigureType.BLACK, 7, 0);
//		
//	
//	
//	public static final ImageView board = new ImageView(new Image("file:C:\\Java\\JavaFX\\JavaFX-Chess GUI\\images\\wood_board.png"));
//	
//	
//	public static List<ImageView> initializeBoardImages() {
//		
//		
//		ScaleImage(rookL.getImage());
//		ScaleImage(rookR.getImage());
//		ScaleImage(bishopL.getImage());
//		ScaleImage(bishopR.getImage());
//		ScaleImage(knightL.getImage());
//		ScaleImage(knightR.getImage());
//		ScaleImage(queen.getImage());
//		ScaleImage(king.getImage());
//		
//		rookL.getImage().setX(700);
//		knightR.getImage().setX(600);
//		bishopR.getImage().setX(500);
//		king.getImage().setX(400);
//		queen.getImage().setX(300);
//		bishopL.getImage().setX(200);
//		knightL.getImage().setX(100);
//		
//		List<ImageView> listOfImages = new ArrayList<>();
//		listOfImages.add(board);
//		listOfImages.add(rookL.getImage());
//		listOfImages.add(knightL.getImage());
//		listOfImages.add(bishopL.getImage());
//		listOfImages.add(queen.getImage());
//		listOfImages.add(king.getImage());
//		listOfImages.add(bishopR.getImage());
//		listOfImages.add(knightR.getImage());
//		listOfImages.add(rookR.getImage());
//		
//		return listOfImages;
//	}
//	
//	
//	
//	public static List<Figure> initializeBoardFigures() {
//		
//		
//		ScaleImage(rookL.getImage());
//		ScaleImage(rookR.getImage());
//		ScaleImage(bishopL.getImage());
//		ScaleImage(bishopR.getImage());
//		ScaleImage(knightL.getImage());
//		ScaleImage(knightR.getImage());
//		ScaleImage(queen.getImage());
//		ScaleImage(king.getImage());
//		
//		rookL.getImage().setX(700);
//		knightR.getImage().setX(600);
//		bishopR.getImage().setX(500);
//		king.getImage().setX(400);
//		queen.getImage().setX(300);
//		bishopL.getImage().setX(200);
//		knightL.getImage().setX(100);
//
//		List<Figure> listOfFigures = new ArrayList<>();
//		listOfFigures.add(rookL);
//		listOfFigures.add(knightL);
//		listOfFigures.add(bishopL);
//		listOfFigures.add(queen);
//		listOfFigures.add(king);
//		listOfFigures.add(bishopR);
//		listOfFigures.add(knightR);
//		listOfFigures.add(rookR);
//
//		
//		return listOfFigures;
//	}
//	
//	
//	
//	
//	
//	private static void ScaleImage(ImageView image) {
//		image.setFitHeight(100);
//		image.setFitWidth(100);
//	}
//}

