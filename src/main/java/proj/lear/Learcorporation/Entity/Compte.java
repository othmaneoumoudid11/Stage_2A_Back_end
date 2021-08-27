package proj.lear.Learcorporation.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


	@Entity
	@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
	@DiscriminatorColumn( name="type_Compte", discriminatorType = DiscriminatorType.STRING )
	public abstract class  Compte {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false, updatable = false)
		private Long id_compte ;
		
		private String First_name;
		private String Last_name;
		private String email;
		private String motpasse;
        private String Num_telephone;	
	   

		public String getNum_telephone() {
			return Num_telephone;
		}


		public void setNum_telephone(String num_telephone) {
			Num_telephone = num_telephone;
		}





		public Compte() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Compte(String first_name, String last_name, String email, String motpasse, String Num_telephone) {
			super();
			this.First_name = first_name;
			this.email = email;
			this.motpasse = motpasse;
			this.Num_telephone = Num_telephone;
			this.Last_name = last_name;
		}


		public Long getId_compte() {
			return id_compte;
		}


		public void setId_compte(Long id_compte) {
			this.id_compte = id_compte;
		}




		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getMotpasse() {
			return motpasse;
		}


		public void setMotpasse(String motpasse) {
			this.motpasse = motpasse;
		}


		public String getFirst_name() {
			return First_name;
		}


		public void setFirst_name(String first_name) {
			First_name = first_name;
		}


		public String getLast_name() {
			return Last_name;
		}


		public void setLast_name(String last_name) {
			Last_name = last_name;
		}
		
		
		
		
	
}
