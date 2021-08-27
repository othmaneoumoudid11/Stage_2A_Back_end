package proj.lear.Learcorporation.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("cg")
public class Compte_Gérants extends Compte implements Serializable{

	public Compte_Gérants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte_Gérants(String first_name, String last_name, String email, String motpasse, String Num_telephone) {
		super(first_name, last_name, email, motpasse, Num_telephone);
		// TODO Auto-generated constructor stub
	}
	

}
