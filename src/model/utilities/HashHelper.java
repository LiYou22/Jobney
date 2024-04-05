package model.utilities;

// generate id for other class with prefix
public abstract class BaseId {
	
	protected String id;
	
	// each class manage their id independently
	protected abstract void generateId(String prefix);
	
	public String getId() {
		return this.id;
	}
	

}
