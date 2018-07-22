package app.entity;

public enum Status {
	NEW,
	RESERVED,
	RENTED,
	RETURNED;

	@Override
	public String toString() {
		switch (this) {
			case NEW:
				return  "New";
			case RESERVED:
				return "Reserved";
			case RENTED:
				return "Rented";
			case RETURNED:
				return "Returned";
			default:
				return null;
		}
	}
}