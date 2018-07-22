package app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer userId;
	private Integer itemId;
	private Status status;
	private Date createdAt;
	private Date updatedAt;

	public Rental(Integer userId, Integer itemId) {
		this.userId = userId;
		this.itemId = itemId;
		this.status = Status.NEW;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}