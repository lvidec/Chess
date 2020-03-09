package Chess;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(ChessBoard.createContent());
			
			GameLogic.moveWhiteObject(ChessBoard.listOfFigures, scene);
			GameLogic.moveBlackObject(ChessBoard.listOfFigures, scene);

																//TODO Make Black_Rook at [0][0] an clickable object
																//TODO Switch turns
																//TODO En Passant
																//TODO Check & Checkmate
			
			primaryStage.setTitle("Videc - Chess GUI");
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
		e.printStackTrace();
		}
		
		}
	
	
	

	

	
//	private static void moveObject(Figure figure, Scene scene) {
//		
//			figure.setOnMouseClicked(new EventHandler<MouseEvent>() {
//				
//				
//				@Override
//				public void handle(MouseEvent event) {
////					TranslateTransition transition = ChessController.createTranslateTransition(image);
////					ChessController.createTranslateTransition(image);
//					
//					System.out.println("LMAO");
//					
//					ChessController.movePieceOnMousePress(scene, figure);
//				}
//			});
//			
//		}
//	}
	
	
	
	
//	private static void moveObject(List<ImageView> images, Scene scene) {
//		
//		for(int i = 1; i < images.size(); i++) {
//			ImageView image = images.get(i);
//					
//			image.setOnMouseClicked(new EventHandler<MouseEvent>() {
//				
//	
//				@Override
//				public void handle(MouseEvent event) {
////					TranslateTransition transition = ChessController.createTranslateTransition(image);
////					ChessController.createTranslateTransition(image);
//					
//					
//					
//					ChessController.movePieceOnMousePress(scene, image);
//				}
//			});
//	
//		}
//	}
	
	





//List<Figure> listOfFigures = ChessBoard.initializeBoardFigures();
//List<ImageView> listOfImages = ChessBoard.initializeBoardImages();
//
//
//pane.getChildren().addAll(listOfImages);

//Scene scene = new Scene(pane, width * ChessBoard.TILE_SIZE, height * ChessBoard.TILE_SIZE);
//
//moveObject(listOfImages, scene);
//
//primaryStage.setTitle("Videc - Chess GUI");
//primaryStage.setScene(scene);
//primaryStage.show();
//
//} catch(Exception e) {
//e.printStackTrace();
//}
//
//}






//private static ImageView getSelectedImage() {
//	image.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//		@Override
//		public void handle(MouseEvent arg0) {
//			
//		}
//	});
//	
//	return null;
//}




//listOfImages.get(5).setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//@Override
//public void handle(MouseEvent event) {
//	TranslateTransition transition = ChessController.createTranslateTransition(listOfImages.get(5));
//	ChessController.createTranslateTransition(listOfImages.get(5));
//	
//	ChessController.movePieceOnMousePress(scene, listOfImages.get(5), transition);
//}
//});









//@Override
//public void start(Stage primaryStage) throws Exception {
//	
//	
//	
//	primaryStage.setScene(new Scene(Board.createBoard()));
//	primaryStage.show();
//}







//			GridPane grid = new GridPane();
//			Image image = new Image("file:C:\\Java\\JavaFX\\JavaFX-Chess GUI\\images\\Knight.png");
//			grid.getChildren().add(new ImageView(image));  
			
//			Image chessKnight = new Image("file:C:\\Java\\JavaFX\\JavaFX-Chess GUI\\images\\Knight.png");
//			ImageView knight = new ImageView(chessKnight);
//			Image chessBishop = new Image("file:C:\\Java\\JavaFX\\JavaFX-Chess GUI\\images\\Bishop.png");
//			ImageView bishop = new ImageView(chessBishop);
//			Image chessRook = new Image("file:C:\\Java\\JavaFX\\JavaFX-Chess GUI\\images\\Rook.png");
//			ImageView rook = new ImageView(chessRook);
//			
//			
//			
//			grid.add(knight, 0, 0, 1, 1);
//			grid.add(bishop, 1, 2, 1, 1);
//			grid.add(rook, 2, 4, 1, 1);
//			grid.add(knight, 3, 6, 1, 1);
//			grid.add(bishop, 4, 8, 1, 1);
//			grid.add(rook, 5, 10, 1, 1);




}