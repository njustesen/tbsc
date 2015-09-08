package tbsc.models.game;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ResourceField {
	
	@Embedded
	Direction direction;
	@Embedded
	List<Integer> mineralFields;
	@Embedded
	List<Integer> gasFields;
	
}
