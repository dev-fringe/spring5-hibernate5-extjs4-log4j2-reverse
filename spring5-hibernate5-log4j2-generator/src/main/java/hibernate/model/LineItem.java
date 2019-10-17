package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lineItem")
@IdClass(LineItemID.class)
@Data
@NoArgsConstructor
public class LineItem {

	@Id
	@Column(name = "orderId")
	private int orderId;

	@Id @Column(name = "linenum")
	private Integer lineNumber;
	
	@Column(name = "itemId")
	private int itemId;
	
	private Integer quantity;

	private transient Item item;
	
}
