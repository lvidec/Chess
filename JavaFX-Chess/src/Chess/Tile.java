package Chess;

import Figures.Figure;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Tile extends Rectangle{
	
	private Figure figure;
	private boolean isHighlighted = false;

	
	
	public Tile(boolean lightBlock, int x, int y) {
		super();
		setWidth(ChessBoard.TILE_SIZE);
		setHeight(ChessBoard.TILE_SIZE);
		
		relocate(x * ChessBoard.TILE_SIZE, y * ChessBoard.TILE_SIZE);
		
		setFill(lightBlock ? Color.WHITE : Color.GREY);
	}
	
	
	public Figure getFigure() {
		return figure;
	}
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	public boolean isHighlighted() {
		return (isHighlighted);
	}
	
	public boolean hasFigure() {
		return figure != null;
	}
	
	public void removeFigure() {
		figure = null;
	}
	
	
	public void highlightTile(Color color) {
		setStrokeType(StrokeType.INSIDE);
		setStrokeWidth(4);
		setStroke(color);
		
		if( color == Color.GREEN)
			isHighlighted = true;
	
	}
	
	public void unhighlightTile() {
		setStroke(null);
		isHighlighted = false;
	}

	public static void unhighlightAllTiles(Tile board[][]) {
		for( int i = 0; i < ChessBoard.width; i++) {
			for( int j = 0; j < ChessBoard.height; j++) {
				board[i][j].unhighlightTile();
			}
		}
	}

	
	
	
}
