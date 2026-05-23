package patrones._ToDoItem;

import java.time.Duration;
import java.time.Instant;

public abstract class ItemState {
	
	public void start(ToDoItem item) {}

	public void togglePause(ToDoItem item) {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}
	
	public void finish(ToDoItem item) {}
	
	public Duration workedTime(ToDoItem item) {
		if (item.getFechaInicio() == null)
			throw new RuntimeException("El objeto ToDoItem no se inició");
		return Duration.between(item.getFechaInicio(), Instant.now());
	}
	
	public void addComment(ToDoItem item, String comment) {
		item.getComments().add(comment);
	}

}
