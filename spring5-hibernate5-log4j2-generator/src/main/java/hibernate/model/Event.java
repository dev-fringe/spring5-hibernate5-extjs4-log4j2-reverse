package hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.Gson;

import lombok.Data;

@Entity
@Table(name = "EVENTS")
@Data
public class Event extends ExtJs{

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String name;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	private Date date;
	
	public Event(String name, Date date) {
		this.name = name;
		this.date = date;
		this.email = "dev.fringe@gmail.com";
	}

	public Event() {
	}

	public String toString() {
		return new Gson().toJson(this);
	}
	
}