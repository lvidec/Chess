package Chess;

import Figures.Figure;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ChessController {

//  protected static final double KEYBOARD_MOVEMENT_DELTA = 5;
//	private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
	
	public static int oldX, oldY, newX, newY;
	protected static Figure globalFigure;
	
	public static void checkerFiguresOnboard() {
		System.out.println("\nFigures on a board: ");
		for( int j = 0; j < ChessBoard.height; j++) {
			for( int i = 0; i < ChessBoard.width; i++) {
				if( ChessBoard.board[i][j].hasFigure() && j != (ChessBoard.height - 2) && j != (ChessBoard.height - 1) && j != 0 && j != 1)
					System.out.println(i + ", " + j);
			}
		}
		System.out.println();
	}
	
	
	
	protected static void moveRookOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && GameLogic.rookMoves(oldX, oldY, newX, newY)) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile Rook: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile Rook: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	    
		    	  if(GameLogic.rookMoves(oldX, oldY, newX, newY)) {
		    		  
		    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
		    		  
		    		  Tile tile = ChessBoard.board[newX][newY];
		    		  if( tile.hasFigure() && GameLogic.canbeEaten(figure, tile.getFigure())) {
						  Figure tmpFigure;
						  tmpFigure = tile.getFigure();
						  tile.setFigure(null);
						  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
		    		  }


		    		  figure.setX(newX);
		    		  figure.setY(newY);
		    		  tile.setFigure(figure);
		    		  
//		    		  checkerFiguresOnboard();

		    	  }
			      
		      }
		    
		    });
			
		}




	protected static void moveKnightOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && GameLogic.knightMoves(oldX, oldY, newX, newY)) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile Knight: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile Knight: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	    
		    	  if( GameLogic.knightMoves(oldX, oldY, newX, newY)) {
		    		  
		    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
		    		  
		    		  Tile tile = ChessBoard.board[newX][newY];
		    		  if( tile.hasFigure() && GameLogic.canbeEaten(figure, tile.getFigure())) {
						  Figure tmpFigure;
						  tmpFigure = tile.getFigure();
						  tile.setFigure(null);
						  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
		    		  }


		    		  figure.setX(newX);
		    		  figure.setY(newY);
		    		  tile.setFigure(figure);
		    		  
//		    		  checkerFiguresOnboard();


		    	  }
		      }
		    
		    });
			
		}	
	                               
	                               
	
	protected static void moveBishopOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && GameLogic.bishopMoves(oldX, oldY, newX, newY)) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile Bishop: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile Bishop: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	    
		    	  if(GameLogic.bishopMoves(oldX, oldY, newX, newY)) {
		    		  
		    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
		    		  
		    		  Tile tile = ChessBoard.board[newX][newY];
//		    		  if( tile.hasFigure() && canbeEaten(figure, tile.getFigure())) {
		    		  if( tile.hasFigure() ){						
		    			  Figure tmpFigure;
						  tmpFigure = tile.getFigure();
						  tile.setFigure(null);
						  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
		    		  }


		    		  figure.setX(newX);
		    		  figure.setY(newY);
		    		  tile.setFigure(figure);

//		    		  checkerFiguresOnboard();

				  }
		      }
		    
		    });
			
		}		


	protected static void moveQueenOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && ( GameLogic.rookMoves(oldX, oldY, newX, newY) || GameLogic.bishopMoves(oldX, oldY, newX, newY) )) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile Queen: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile Queen: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	    
		    	  if( GameLogic.queenMoves(oldX, oldY, newX, newY) ) {
		    		  
		    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
		    		 
		    		  Tile tile = ChessBoard.board[newX][newY];
		    		  if( tile.hasFigure() && GameLogic.canbeEaten(figure, tile.getFigure())) {
						  Figure tmpFigure;
						  tmpFigure = tile.getFigure();
						  tile.setFigure(null);
						  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
		    		  }


		    		  figure.setX(newX);
		    		  figure.setY(newY);
		    		  tile.setFigure(figure);

//		    		  checkerFiguresOnboard();

		    	  }
		      }
		    
		    });
			
		}		


	protected static void moveKingOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && GameLogic.kingMoves(oldX, oldY, newX, newY)) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile King: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile King: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	  
		    	  
		    	  if( ChessBoard.board[newX][newY].hasFigure() && ChessBoard.board[newX][newY].getFigure().getName().equals("Rook")) 
			    		  GameLogic.canCastle(figure, ChessBoard.board[newX][newY].getFigure());
		    	  
		    	  
		    	  else {
			    	  if( GameLogic.kingMoves(oldX, oldY, newX, newY) ) {
			    		  
			    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
			    		  
			    		  Tile tile = ChessBoard.board[newX][newY];
			    		  if( tile.hasFigure() && GameLogic.canbeEaten(figure, tile.getFigure())) {
			    		  	  Figure tmpFigure;
							  tmpFigure = tile.getFigure();
							  tile.setFigure(null);
							  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
			    		  }
	
	
			    		  figure.setX(newX);
			    		  figure.setY(newY);
			    		  tile.setFigure(figure);
	
	//		    		  checkerFiguresOnboard();
	
			    	  }
		    	  }
		      }
		    
		    });
		
		}
		


	protected static void movePawnOnMousePress(Scene scene, Figure figure) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
		    
		      @Override public void handle(MouseEvent event) {
		    	  globalFigure = figure;
		    	  
		    	  oldX = figure.getX();
		    	  oldY = figure.getY();
		    	  
		    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
		    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
		    	  
	    		  Tile.unhighlightAllTiles(ChessBoard.board);
		    	  
		    	  if( ( oldX != newX || oldY != newY ) && GameLogic.pawnMoves(oldX, oldY, newX, newY)) {
			    	  Tile oldTile = ChessBoard.board[oldX][oldY];
//			    	  System.out.println("Old tile Pawn: " + oldX + ", " + oldY);
//			    	  System.out.println("New tile Pawn: " + newX + ", " + newY);
			    	  oldTile.removeFigure();
		    	  }
		    	    	  
		    	  if( GameLogic.pawnMoves(oldX, oldY, newX, newY)) {
		    		  
		    		  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
		    		  
		    		  Tile tile = ChessBoard.board[newX][newY];
		    		  if( tile.hasFigure() && GameLogic.canbeEaten(figure, tile.getFigure())) {
						  Figure tmpFigure;
						  tmpFigure = tile.getFigure();
						  tile.setFigure(null);
						  ChessBoard.figureGroup.getChildren().remove(tmpFigure);
		    		  }

//		    		  figure.setX(newX);
//		    		  figure.setY(newY);
//		    		  tile.setFigure(figure);
		    		  
		    		  if(GameLogic.pawnPromotion(figure, tile, scene))
		    			  assert true;    //Do nothing
		    		  else {
		    			  figure.setX(newX);
			    		  figure.setY(newY);
			    		  tile.setFigure(figure);
		    		  }
		    			  
		    			  
//		    		  checkerFiguresOnboard();

		    	  }
		      }
		    
		    });
			
		}		
	
	
	
	
	protected static void highlightMoveableTiles(Figure figure, Tile board[][]) {
		
		for( int i = 0; i < ChessBoard.width; i++) {
			for( int j = 0; j < ChessBoard.height; j++) {
				
				if( figure.getName().equals("Rook")) {
					globalFigure = figure;
					if( GameLogic.rookMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}				
				
				else if( figure.getName().equals("Knight")) {
					globalFigure = figure;
					if( GameLogic.knightMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}
				
				else if( figure.getName().equals("Bishop")) {
					globalFigure = figure;
					if( GameLogic.bishopMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}
				
				else if( figure.getName().equals("Queen")) {
					globalFigure = figure;
					if( GameLogic.queenMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}
				
				else if( figure.getName().equals("King")) {
					globalFigure = figure;
					if( GameLogic.kingMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}
				
				else if( figure.getName().equals("Pawn")) {
					globalFigure = figure;
					if( GameLogic.pawnMoves(figure.getX(), figure.getY(), i, j) )
						board[i][j].highlightTile(Color.GREEN);
				}
				
				
				
			}
		}
		
	}
	
	
	

}




//public static void movePieceOnMousePress(Scene scene, Figure figure) {
//	scene.setOnMousePressed(new EventHandler<MouseEvent>() {
//    
//      @Override public void handle(MouseEvent event) {
//    	  
//    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
//    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
//    	  
//    	  figure.relocate(newX * ChessBoard.TILE_SIZE, newY * ChessBoard.TILE_SIZE);
//    	  
//    	  
////    	  figure.getImage().setX(newX * ChessBoard.TILE_SIZE);
////    	  figure.getImage().setY(newY * ChessBoard.TILE_SIZE);
//    	  
////    	  image.setX(newX * ChessBoard.TILE_SIZE);
////    	  image.setY(newY * ChessBoard.TILE_SIZE);
//    	  
//    	  
//      }
//    
//    });
//	
//}





//public static void movePieceOnMousePress(Scene scene, ImageView image) {
//	scene.setOnMousePressed(new EventHandler<MouseEvent>() {
//    
//      @Override public void handle(MouseEvent event) {
//    	  
//    	  
//    	  
//    	  newX = (int)event.getSceneX() / ChessBoard.TILE_SIZE;
//    	  newY = (int)event.getSceneY() / ChessBoard.TILE_SIZE;
//    	  
//    	  image.setX(newX * ChessBoard.TILE_SIZE);
//    	  image.setY(newY * ChessBoard.TILE_SIZE);
//    	  
//    	  
//      }
//    
//    });
//  }
//
//
//}














//System.out.println(event.getSceneX() + ", " + event.getY());
//
//System.out.println(boardX + ", " + boardY);
//
//System.out.println(image.getX() + ",,, " + image.getY());
//
//System.out.println();
//
//System.out.println(event.getSceneX() - image.getX() - 50);
//System.out.println(event.getSceneY() - image.getY() - 50);
//
//System.out.println("\n\n");

//transition.setToX(event.getSceneX() - image.getX() - 50);
//transition.setToY(event.getSceneY() - image.getY() - 50);
//transition.playFromStart();




//public static TranslateTransition createTranslateTransition(final ImageView image) {
//final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, image);
//transition.setOnFinished(new EventHandler<ActionEvent>() {
//
//	@Override public void handle(ActionEvent t) {
//	  image.setX(image.getTranslateX() + image.getX());
//	  image.setY(image.getTranslateY() + image.getY());
//	  image.setTranslateX(0);
//	  image.setTranslateY(0);
//	}
//	
//});
//return transition;
//}




//@FXML public static ImageView RookL;
//
//@FXML private ImageView RookR;
//
//
//@FXML private ImageView KnightL;
//
//@FXML private ImageView BishopL;
//
//@FXML private ImageView Queen;
//
//@FXML private ImageView King;
//
//@FXML private ImageView BishopR;
//
//@FXML private ImageView KnightR;
//
//
//@FXML private ImageView Pawn1;
//@FXML private ImageView Pawn2;
//@FXML private ImageView Pawn3;
//@FXML private ImageView Pawn4;
//@FXML private ImageView Pawn5;
//@FXML private ImageView Pawn6;
//@FXML private ImageView Pawn7;
//@FXML private ImageView Pawn8;



