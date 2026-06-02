package patrones._FileManager;

public class SizeDecorator extends FileDecorator {

	public SizeDecorator(FileItem wrappee) {
		super(wrappee);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.wrappee.getTamaño();
	}
	
}
