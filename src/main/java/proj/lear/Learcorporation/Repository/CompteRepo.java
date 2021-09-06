package proj.lear.Learcorporation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.lear.Learcorporation.Entity.Compte;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Long>{
	Compte findByEmailAndMotpasse(String email, String motpasse);

}
