package opgave5;

public class SpiritusAdapter extends Vare {

	private Spiritus spiritus;
	
	public SpiritusAdapter(String name, String description, double price, Spiritus spiritus) {
		super(name, description, price);
		setSpiritus(spiritus);
	}

	public Spiritus getSpiritus() {
		return spiritus;
	}

	public void setSpiritus(Spiritus spiritus) {
		this.spiritus = spiritus;
	}
	
	

}
