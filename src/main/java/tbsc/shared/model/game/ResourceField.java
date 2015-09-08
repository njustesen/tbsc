package tbsc.shared.model.game;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ResourceField {

	private static final int MIN_FIELDS = 9;
	private static final int MIN = 50 * 25;
	private static final int GAS_FIELDS = 2;
	private static final int GAS = 50 * 2 * 17;
	
	@Embedded
	public Direction direction;
	
	public List<Integer> mineralFields;
	public List<Integer> gasFields;
	
	public ResourceField(){
		
	}
	
	public ResourceField(int numMinFields, int minerals, int numGasFields, int gas, Direction direction){
		
		this.mineralFields = new ArrayList<Integer>();
		this.gasFields = new ArrayList<Integer>();
		
		for(int m = 0; m < numMinFields; m++)
			this.mineralFields.add(minerals);
		
		for(int g = 0; g < numGasFields; g++)
			this.gasFields.add(gas);
			
	}
	
	public ResourceField(Direction direction){
		
		this.mineralFields = new ArrayList<Integer>();
		this.gasFields = new ArrayList<Integer>();
		
		for(int m = 0; m < MIN_FIELDS; m++)
			this.mineralFields.add(MIN);
		
		for(int g = 0; g < GAS_FIELDS; g++)
			this.gasFields.add(GAS);
			
	}
	
}
