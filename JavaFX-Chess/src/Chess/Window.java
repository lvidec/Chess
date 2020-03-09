package Chess;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Window extends Group {
	
	private Rectangle rectangle;
	private boolean isHighlighted = false;


	public Window(Rectangle rectangle) {
		super();
		this.rectangle = rectangle;
	}
	
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	
	public void highlightWindow(Color color) {
		rectangle.setStrokeType(StrokeType.INSIDE);
		rectangle.setStrokeWidth(5);
		rectangle.setStroke(color);
		
		if( color == Color.GREEN)
			isHighlighted = true;
	
	}
	
	public void unhighlight() {
		rectangle.setStroke(null);
		isHighlighted = false;
	}
	
	public boolean isHighlighted() {
		return (isHighlighted);
	}

	
}
