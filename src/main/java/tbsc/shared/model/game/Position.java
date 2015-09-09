package tbsc.shared.model.game;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Position {

	public int x = 0;
	public int y = 0;
	
	public Position(){
		
	}
	
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
