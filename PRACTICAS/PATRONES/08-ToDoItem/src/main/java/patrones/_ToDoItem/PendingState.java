package patrones._ToDoItem;

import java.time.Instant;

public class PendingState extends ItemState {
	
	@Override
	public void start(ToDoItem item) {
		item.setState(new InProgressState());
		item.setFechaInicio(Instant.now());
	}

}
