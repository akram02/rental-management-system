package app.entity;

import java.util.Arrays;

public enum Color {
	WHITE(0),
	BLACK(1),
	RED(2),
	BLUE(3),
	YELLOW(4);

	private Integer id;

	Color(Integer id) {
		this.id = id;
	}

	public static Color getById(Integer id) {
		return Arrays
				.stream(Color.values())
				.filter(data -> data.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		switch (this) {
			case WHITE:
				return "White";
			case BLACK:
				return "Black";
			case RED:
				return "Red";
			case BLUE:
				return "Blue";
			case YELLOW:
				return "Yellow";
			default:
				return null;
		}
	}
}
