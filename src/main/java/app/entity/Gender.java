package app.entity;

import java.util.Arrays;

public enum Gender {
	MALE(0),
	FEMALE(1),
	OTHER(2);

	private Integer id;

	Gender(Integer id) {
		this.id = id;
	}

	public static Gender getById(Integer id) {
		return Arrays
				.stream(Gender.values())
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
			case MALE:
				return "Male";
			case FEMALE:
				return "Female";
			case OTHER:
				return "Other";
			default:
				return null;
		}
	}
}