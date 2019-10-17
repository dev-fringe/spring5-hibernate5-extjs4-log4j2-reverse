package hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "HTTP")
public class HttpRestLog extends ExtJs{

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")	
	private Date date;
	@Lob
	@Column(length = Integer.MAX_VALUE)
	private String body;
	private String type;
	private String method;
	private String uri;
	public HttpRestLog() {
		super();
	}
	public HttpRestLog(String type,String method,String uri, String body) {
		this.type = type;
		this.uri = uri;
		this.body = body;
		this.method = method;
		this.date = new Date();
	}
	
	public String toString() {
		return "HttpRestLog [id=" + id + ", date=" + date + ", body=" + body + ", type=" + type + ", method=" + method
				+ ", uri=" + uri + "]";
	}
}
