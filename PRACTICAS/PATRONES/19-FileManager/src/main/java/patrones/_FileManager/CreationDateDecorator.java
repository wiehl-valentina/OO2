package patrones._FileManager;

public class CreationDateDecorator extends FileDecorator {

	public CreationDateDecorator(FileItem wrappee) {
		super(wrappee);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.wrappee.getFechaCreacion();
	}
	
}
