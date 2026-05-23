package patrones._ToDoItem;

public class PausedState extends ItemState {
	
	@Override
	public void togglePause(ToDoItem item) {
		item.setState(new InProgressState());
	}

	@Override
	public void finish(ToDoItem item) {
		item.setState(new FinishedState());
	}
	
}
