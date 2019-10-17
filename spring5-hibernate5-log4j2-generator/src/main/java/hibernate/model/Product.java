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
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    public Product(String name, String desc, Category category) {
    	this.name = name;
    	this.description = desc;
    	this.category = category;
	}

	@Id
    @Column(name = "productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    
    private String name;

    private String description;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", referencedColumnName = "catid")
    private Category category;
}
