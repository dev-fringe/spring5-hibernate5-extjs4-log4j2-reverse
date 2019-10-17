package hibernate.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LineItemID implements Serializable {
	
	private static final long serialVersionUID = 2801662954202117799L;
	private Integer orderId;
	private Integer lineNumber;
}
