package patrones._ToDoItem;

import java.time.Duration;

public class FinishedState extends ItemState {

	@Override
	public Duration workedTime(ToDoItem item) {
		return Duration.between(item.getFechaInicio(), item.getFechaFin());
	}
	
	@Override 
	public void addComment(ToDoItem item, String comment) {}
	
}
