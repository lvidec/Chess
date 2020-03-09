package Figures;

import Chess.ChessBoard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Figure {
	
	private ImageView image = new ImageView();
	private String name = "Rook";

	public Rook(FigureType type, int x, int y) {
		super(type, x, y);
		
		if( type.equals(FigureType.BLACK))
			image = new ImageView(new Image(Figure.rookBlack));
		
		else if( type.equals(FigureType.WHITE)) 
			image = new ImageView(new Image(Figure.rookWhite));
		
		else {
			System.out.println("NO TYPE, I GUESS!");
		}
		
		image.setFitHeight(ChessBoard.TILE_SIZE);
		image.setFitWidth(ChessBoard.TILE_SIZE);
		getChildren().add(image);
	}
	
	@Override
	public ImageView getImage() {
		return image;				
	}

	public void setImage(ImageView image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
