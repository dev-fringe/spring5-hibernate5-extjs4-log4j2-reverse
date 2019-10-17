package hibernate.support;

import java.util.List;

import com.google.gson.Gson;

import lombok.Data;

@Data
public class SuccessData {

	private List<Object> data; 
	private boolean success;
	private int total;
	public SuccessData(List data) {
		this.data = data;
		this.success = true;
		this.total = data.size();
	}
	public SuccessData() {
		super();
	}
	
	public SuccessData(List data, Long count) {
		this.data = data;
		this.success = true;
		this.total = count.intValue();
	}
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
