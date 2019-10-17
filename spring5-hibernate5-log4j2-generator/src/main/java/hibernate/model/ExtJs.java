package hibernate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public abstract class ExtJs {

	@JsonProperty(access = Access.WRITE_ONLY)
	private int page = 0;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int size = 25;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int formRecord;
	
	public int getFormRecord() {
		int pageIndex = page -1 < 0 ? 0 :page - 1;
		return pageIndex * size;
	}
	
	
}
