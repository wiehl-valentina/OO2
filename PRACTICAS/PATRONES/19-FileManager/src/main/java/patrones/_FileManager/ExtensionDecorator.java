package patrones._FileManager;

public class ExtensionDecorator extends FileDecorator {

	public ExtensionDecorator(FileItem item) {
		super(item);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.wrappee.getExtension();
	}
	
}
