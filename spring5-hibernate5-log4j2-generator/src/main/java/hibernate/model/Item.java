package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item {

    @Id @Column(name = "itemid", unique = true, nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    private String itemname;
    private String description;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private Product product;
    
    @ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierid", referencedColumnName = "suppid")
    private Supplier supplier;

	public Item(String itemname, String description, Product product, Supplier supplier) {
		super();
		this.itemname = itemname;
		this.description = description;
		this.product = product;
		this.supplier = supplier;
	}
}
