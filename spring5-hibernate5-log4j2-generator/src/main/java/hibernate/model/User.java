package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User extends ExtJs{

	@Id
    private String email;
    
    @Column(name = "firstname",length = 80)
    private String firstName;

    @Column(name = "lastname",length = 80)
    private String lastName;

    @Column(length = 2)
    private String status;

    @Column(name = "address")
    private String address;

    @Column(length = 80)
    private String phone;

    @Column(length = 80)
    private String telephone;
    
    private String password;
	
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

}