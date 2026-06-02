package patrones._AccesoABaseDeDatos;

import java.util.Collection;
import java.util.List;

public class DatabaseProxy implements DatabaseAccess {
	
	private DatabaseRealAccess realDatabase;
	private boolean isAuthenticated;
	private final String validPassword = "admin";
	
	public DatabaseProxy() {
		this.isAuthenticated = false;
	}
	
	public void login(String password) {
		if (validPassword.equals(password)) {
			this.isAuthenticated = true;
			if (this.realDatabase == null)
				this.realDatabase = new DatabaseRealAccess();
		} else {
			throw new SecurityException("Credenciales incorrectas.");
		}
	}
	
	public void logout() {
		this.isAuthenticated = false;
	}
	
	private void checkAccess() {
		if (!this.isAuthenticated)
			throw new SecurityException("Acceso denegado: el usuario no está autenticado.");
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		checkAccess();
		return this.realDatabase.getSearchResults(queryString);
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		checkAccess();
		return this.realDatabase.insertNewRow(rowData);
	}

}
