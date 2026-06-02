package patrones._FileManager;

public class PermissionsDecorator extends FileDecorator {

	public PermissionsDecorator(FileItem wrappee) {
		super(wrappee);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.wrappee.getPermisos();
	}
	
}
