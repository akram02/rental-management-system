package app.entity;

import java.util.Arrays;

public enum Size {
	S(0),
	M(1),
	L(2);

	private Integer id;

	Size(Integer id) {
		this.id = id;
	}

	public static Size getById(Integer id) {
		return Arrays
				.stream(Size.values())
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
			case S:
				return "S";
			case M:
				return "M";
			case L:
				return "L";
			default:
				return null;
		}
	}
}