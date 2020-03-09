package Chess;

import java.util.List;

import Figures.Bishop;
import Figures.Figure;
import Figures.FigureType;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class GameLogic {
	
	protected static boolean hasPawnMoved; 
	
	protected static void moveWhiteObject(List<Figure> figures, Scene scene) {
		
		for(int i = 1; i < figures.size(); i++) {
			Figure figure = figures.get(i);
			
			if( figure.getType().equals(FigureType.WHITE)) {
					
				figure.setOnMouseClicked(new EventHandler<MouseEvent>() {
					
					@Override
					public void handle(MouseEvent event) {
	//					TranslateTransition transition = ChessController.createTranslateTransition(image);
	//					ChessController.createTranslateTransition(image);
							
		
						if( figure instanceof Rook) {
							System.out.println("Object White_Rook is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveRookOnMousePress(scene, figure);
						}
						else if( figure instanceof Knight) {
							System.out.println("Object White_Knight is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveKnightOnMousePress(scene, figure);
						}
						else if( figure instanceof Bishop) {
							System.out.println("Object White_Bishop is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveBishopOnMousePress(scene, figure);
						}
						else if( figure instanceof Queen) {
							System.out.println("Object White_Queen is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveQueenOnMousePress(scene, figure);
						}
						else if( figure instanceof King) {
							System.out.println("Object White_King is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveKingOnMousePress(scene, figure);
						}
						else if( figure instanceof Pawn) {
							System.out.println("Object White_Pawn is clicked");
							
							if( figure.getY() == 6)
								hasPawnMoved = false;
							else
								hasPawnMoved = true;
							
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.movePawnOnMousePress(scene, figure);
						}
					
					}
				
				});
			}
		}
	}
	
	protected static void moveBlackObject(List<Figure> figures, Scene scene) {
		
		for(int i = 1; i < figures.size(); i++) {
			Figure figure = figures.get(i);
			
			if( figure.getType().equals(FigureType.BLACK)) {
				
				figure.setOnMouseClicked(new EventHandler<MouseEvent>() {
					
					@Override
					public void handle(MouseEvent event) {
//					TranslateTransition transition = ChessController.createTranslateTransition(image);
//					ChessController.createTranslateTransition(image);
						
						
						if( figure instanceof Rook) {
							System.out.println("Object Black_Rook is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveRookOnMousePress(scene, figure);
						}
						else if( figure instanceof Knight) {
							System.out.println("Object Black_Knight is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveKnightOnMousePress(scene, figure);
						}
						else if( figure instanceof Bishop) {
							System.out.println("Object Black_Bishop is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveBishopOnMousePress(scene, figure);
						}
						else if( figure instanceof Queen) {
							System.out.println("Object Black_Queen is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveQueenOnMousePress(scene, figure);
						}
						else if( figure instanceof King) {
							System.out.println("Object Black_King is clicked");
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.moveKingOnMousePress(scene, figure);
						}
						else if( figure instanceof Pawn) {
							System.out.println("Object Black_Pawn is clicked");
							
							if( figure.getY() == 1)
								hasPawnMoved = false;
							else
								hasPawnMoved = true;
							
							ChessController.highlightMoveableTiles(figure, ChessBoard.board);             
							ChessController.movePawnOnMousePress(scene, figure);
						}
						
					}
					
				});
			}
			
		}
	}
	
	
	protected static void canCastle(Figure king, Figure rook) {
		
		if( rook.getName().equals("Rook")) {
			
			System.out.println("USLI");
			
			if( king.getType() == FigureType.BLACK && rook.getType() == FigureType.BLACK) {
				if( king.getX() == 4 && king.getY() == 0 && rook.getX() == 0 && rook.getY() == 0 && !ChessBoard.board[1][0].hasFigure() && !ChessBoard.board[2][0].hasFigure() && !ChessBoard.board[3][0].hasFigure()) {
					
					ChessBoard.board[king.getX()][king.getY()].removeFigure();
					ChessBoard.board[rook.getX()][rook.getY()].removeFigure();
					
					king.relocate(2 * ChessBoard.TILE_SIZE, 0 * ChessBoard.TILE_SIZE);
					rook.relocate(3 * ChessBoard.TILE_SIZE, 0 * ChessBoard.TILE_SIZE);
					
					king.setX(2);
					king.setY(0);
					rook.setX(3);
					rook.setY(0);
					
					ChessBoard.board[2][0].setFigure(king);
					ChessBoard.board[3][0].setFigure(rook);
					
					Tile.unhighlightAllTiles(ChessBoard.board);		
					
					System.out.println("1");
					
//					return true;
				}
				else if( king.getX() == 4 && king.getY() == 0 && rook.getX() == 7 && rook.getY() == 0 && !ChessBoard.board[5][0].hasFigure() && !ChessBoard.board[6][0].hasFigure()) {

					ChessBoard.board[king.getX()][king.getY()].removeFigure();
					ChessBoard.board[rook.getX()][rook.getY()].removeFigure();
					
					king.relocate(6 * ChessBoard.TILE_SIZE, 0 * ChessBoard.TILE_SIZE);
					rook.relocate(5 * ChessBoard.TILE_SIZE, 0 * ChessBoard.TILE_SIZE);
					
					king.setX(6);
					king.setY(0);
					rook.setX(5);
					rook.setY(0);

					ChessBoard.board[6][0].setFigure(king);
					ChessBoard.board[5][0].setFigure(rook);
					
					Tile.unhighlightAllTiles(ChessBoard.board);		
					
					System.out.println("2");
		
//					return true;
				}
			}
			
			else if( king.getType() == FigureType.WHITE && rook.getType() == FigureType.WHITE) {
				if( king.getX() == 4 && king.getY() == (ChessBoard.height - 1) && rook.getX() == 0 && rook.getY() == (ChessBoard.height - 1) && !ChessBoard.board[1][ChessBoard.height - 1].hasFigure() && !ChessBoard.board[2][ChessBoard.height - 1].hasFigure() && !ChessBoard.board[3][ChessBoard.height - 1].hasFigure() ) {

					ChessBoard.board[king.getX()][king.getY()].removeFigure();
					ChessBoard.board[rook.getX()][rook.getY()].removeFigure();
					
					king.relocate(2 * ChessBoard.TILE_SIZE, (ChessBoard.height - 1) * ChessBoard.TILE_SIZE);
					rook.relocate(3 * ChessBoard.TILE_SIZE, (ChessBoard.height - 1) * ChessBoard.TILE_SIZE);
					
					king.setX(2);
					king.setY(ChessBoard.height - 1);
					rook.setX(3);
					rook.setY(ChessBoard.height - 1);

					ChessBoard.board[2][ChessBoard.height - 1].setFigure(king);
					ChessBoard.board[3][ChessBoard.height - 1].setFigure(rook);
					
					Tile.unhighlightAllTiles(ChessBoard.board);		

					System.out.println("3");
		
//					return true;
				}
				else if( king.getX() == 4 && king.getY() == (ChessBoard.height - 1) && rook.getX() == (ChessBoard.height - 1) && rook.getY() == (ChessBoard.height - 1) && !ChessBoard.board[5][ChessBoard.height - 1].hasFigure() && !ChessBoard.board[6][ChessBoard.height - 1].hasFigure()) {

					ChessBoard.board[king.getX()][king.getY()].removeFigure();
					ChessBoard.board[rook.getX()][rook.getY()].removeFigure();
					
					king.relocate(6 * ChessBoard.TILE_SIZE, (ChessBoard.height - 1) * ChessBoard.TILE_SIZE);
					rook.relocate(5 * ChessBoard.TILE_SIZE, (ChessBoard.height - 1) * ChessBoard.TILE_SIZE);
					
					king.setX(6);
					king.setY(ChessBoard.height - 1);
					rook.setX(5);
					rook.setY(ChessBoard.height - 1);
					
					ChessBoard.board[6][ChessBoard.height - 1].setFigure(king);
					ChessBoard.board[5][ChessBoard.height - 1].setFigure(rook);
					
					Tile.unhighlightAllTiles(ChessBoard.board);		

					System.out.println("4");
		
//					return true;
				}
			}
			
//			else
//				return false;
		}
	
//		return false;
	}
	
	
	protected static boolean pawnPromotion(Figure figure, Tile tile, Scene scene) {	
		
		if( ChessController.newY == (ChessBoard.height - 1) && figure.getType() == FigureType.BLACK) {
			  tile.setFigure(null);
			  ChessBoard.figureGroup.getChildren().remove(figure);
			  
			  Figure replacementBlackQueen = new Queen(FigureType.BLACK, figure.getX(), (ChessBoard.height - 1));
			  
			  ChessBoard.listOfFigures.add(replacementBlackQueen);
			  tile.setFigure(replacementBlackQueen);
			  ChessBoard.figureGroup.getChildren().add(replacementBlackQueen);
			  
			  moveBlackObject(ChessBoard.listOfFigures, scene);
			  
			  return true;
		  }
		  else if( ChessController.newY == 0 && figure.getType() == FigureType.WHITE) {
			  tile.setFigure(null);
			  ChessBoard.figureGroup.getChildren().remove(figure);
			  
			  Figure replacementWhiteQueen = new Queen(FigureType.WHITE, figure.getX(), 0);
			  
			  ChessBoard.listOfFigures.add(replacementWhiteQueen);
			  tile.setFigure(replacementWhiteQueen);
			  ChessBoard.figureGroup.getChildren().add(replacementWhiteQueen);
			  
			  moveWhiteObject(ChessBoard.listOfFigures, scene);
		  
			  return true;
		  }
		  else
			  return false;
	
	}


	protected static boolean pawnMoves(int oldX, int oldY, int newX, int newY) {	
		
		if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		}
		
		
		
		
		
		if( 	(newY == (oldY - 1) && (newX == oldX) && ChessController.globalFigure.getType().equals(FigureType.WHITE) && !ChessBoard.board[newX][newY].hasFigure() ) || 
				(newY == (oldY + 1) && (newX == oldX) && ChessController.globalFigure.getType().equals(FigureType.BLACK) && !ChessBoard.board[newX][newY].hasFigure() ) ||
				
				(newY == (oldY - 2) && (newX == oldX) && ChessController.globalFigure.getType().equals(FigureType.WHITE) && !ChessBoard.board[newX][newY].hasFigure() && hasPawnMoved == false ) || 
				(newY == (oldY + 2) && (newX == oldX) && ChessController.globalFigure.getType().equals(FigureType.BLACK) && !ChessBoard.board[newX][newY].hasFigure() && hasPawnMoved == false ) ||
		
				(newY == (oldY - 1) && ( (newX == oldX + 1) || (newX == oldX - 1)) && ChessController.globalFigure.getType().equals(FigureType.WHITE) && ChessBoard.board[newX][newY].hasFigure() ) ||
				(newY == (oldY + 1) && ( (newX == oldX + 1) || (newX == oldX - 1)) && ChessController.globalFigure.getType().equals(FigureType.BLACK) && ChessBoard.board[newX][newY].hasFigure() ) )
			return true;
		else 
			return false;
		
	}
	
	
	protected static boolean queenMoves(int oldX, int oldY, int newX, int newY) {
		
		if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		}
		
		if( rookMoves(oldX, oldY, newX, newY) || bishopMoves(oldX, oldY, newX, newY) )
			return true;
		else
			return false;
	}
	
	
	protected static boolean kingMoves(int oldX, int oldY, int newX, int newY) {	
		 
		if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		}
		
		if( (newX == (oldX - 1) && ((newY == oldY - 1) || newY == oldY + 1)) || (newX == (oldX + 1) && ((newY == oldY - 1) || newY == oldY + 1)) ||
				newY == (oldY - 1) && (newX == oldX) || (newY == (oldY + 1) && newX == oldX) || ((newX == oldX - 1) || (newX == oldX + 1)) && newY == oldY )
			return true;
		
		else 
			return false;
		
	}

	
	protected static boolean knightMoves(int oldX, int oldY, int newX, int newY) {	
		
		if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		}
		
		if( (newX == (oldX - 1) && ((newY == oldY - 2) || newY == oldY + 2)) || (newX == (oldX - 2) && ((newY == oldY - 1) || newY == oldY + 1)) || 
				(newX == (oldX + 1) && ((newY == oldY - 2) || newY == oldY + 2)) || (newX == (oldX + 2) && ((newY == oldY - 1) || newY == oldY + 1)))
			return true;
		
		else 
			return false;
		
	}

	protected static boolean rookMoves(int oldX, int oldY, int newX, int newY) {	

		 boolean hasFigure = false;
		
		 if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		 }
		 
		 if( newX == oldX || newY == oldY) {
			 if( findMax(oldX, newX) == oldX) {
				 for( int i = newX + 1, j = oldY; i < oldX; i++) {
					 if( ChessBoard.board[i][j].hasFigure()) {
						 hasFigure = true;
//						 System.out.println("Left");
					 }
				 }
			 }
			 else {
				 for( int i = oldX + 1, j = oldY; i < newX; i++) {
					 if( ChessBoard.board[i][j].hasFigure()) {
						 hasFigure = true;
//						 System.out.println("Right");
					 }
				 }
			 }
			 if( findMax(oldY, newY) == oldY) {
				 for( int j = newY + 1, i = oldX; j < oldY; j++) {
					 if( ChessBoard.board[i][j].hasFigure() ) {
						 hasFigure = true;
//						 System.out.println("Up");
					 }
				 }
			 }
			 else {
				 for( int j = oldY + 1, i = oldX; j < newY; j++) {
					 if( ChessBoard.board[i][j].hasFigure()) {
						 hasFigure = true;
//						 System.out.println("Down");
					 }
				 }
			 }
			 
			 if( hasFigure )
				 return false;
			 else
				 return true;
		 }
		 else 
		 	 return false;
		
	}

	protected static boolean bishopMoves(int oldX, int oldY, int newX, int newY) {	

		boolean hasFigure = false;

		if( ChessBoard.board[newX][newY].hasFigure()) {
			 if( ChessBoard.board[newX][newY].getFigure().getType() == ChessController.globalFigure.getType())
				 return false;
		}
				
		if( (findMax(oldX, newX) == oldX) && (findMax(oldY, newY) == newY) ) {
			for(int i = oldX - 1, j = oldY + 1; i > (newX - 1) && j < (newY + 1) ; i--, j++) {
				if( i != (newX) && j != (newY)) {
					if( ChessBoard.board[i][j].hasFigure()) {
//						System.out.println("NEMOS BA (--, ++) -> " + i + ", " + j);	
						hasFigure = true;
					}
				}
				if( newX == i && newY == j && hasFigure == false ) {
//					System.out.println("-- ++");
					return true;
				}
			}
		}
		else if( (findMax(oldX, newX) == newX) && (findMax(oldY, newY) == newY) ) {
			for(int i = oldX + 1, j = oldY + 1; i < (newX + 1) && j < (newY + 1) ; i++, j++) {
				if( i != (newX) && j != (newY)) {
					if( ChessBoard.board[i][j].hasFigure()) {
//						System.out.println("NEMOS BA (++, ++) -> " + i + ", " + j);	
						hasFigure = true;
					}
				}
				if( newX == i && newY == j && hasFigure == false ) {
//					System.out.println("++ ++");
					return true;
				}
			}
		}
		else if( (findMax(oldX, newX) == oldX) && (findMax(oldY, newY) == oldY) ) {
			for(int i = oldX - 1, j = oldY - 1; i > (newX - 1) && j > (newY - 1); i--, j--) {
				if( i != (newX) && j != (newY)) {
					if( ChessBoard.board[i][j].hasFigure()) {
//						System.out.println("NEMOS BA (--, --) -> " + i + ", " + j);	
						hasFigure = true;
					}
				}
				if( newX == i && newY == j && hasFigure == false ) {
//					System.out.println("-- --");
					return true;
				}
			}
		}
		else if( (findMax(oldX, newX) == newX) && (findMax(oldY, newY) == oldY) ) {
			for(int i = oldX + 1, j = oldY - 1; i < (newX + 1) && j > (newY - 1); i++, j--) {
				if( i != (newX) && j != (newY)) {
					if( ChessBoard.board[i][j].hasFigure()) {
//						System.out.println("NEMOS BA (++, --) -> " + i + ", " + j);	
						hasFigure = true;
					}
				}
				if( newX == i && newY == j && hasFigure == false ) {
//					System.out.println("++ --");
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	protected static int findMax(int a, int b) {
		int max = (a > b) ? a : b;
		return max;
	}

	
	protected static boolean canbeEaten(Figure figure1, Figure figure2) {
		if( figure1.getType() != figure2.getType() )
			return true;
		else
			return false;
	}


}
