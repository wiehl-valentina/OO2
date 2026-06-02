package patrones._FileManager;

public class ModificationDateDecorator extends FileDecorator {

	public ModificationDateDecorator(FileItem wrappee) {
		super(wrappee);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.wrappee.getFechaModificacion();
	}
	

}
