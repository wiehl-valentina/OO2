package patrones._ToDoItem;

public class InProgressState extends ItemState {
	
	@Override
	public void togglePause(ToDoItem item) {
		item.setState(new PausedState());
	}
	
	@Override
	public void finish(ToDoItem item) {
		item.setState(new FinishedState());
	}

}
