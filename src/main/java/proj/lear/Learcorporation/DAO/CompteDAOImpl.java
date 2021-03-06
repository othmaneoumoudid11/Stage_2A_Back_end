package proj.lear.Learcorporation.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Compte;
import proj.lear.Learcorporation.Entity.Compte_Gérants;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;
import proj.lear.Learcorporation.Repository.CompteGerantRepo;
import proj.lear.Learcorporation.Repository.CompteRepo;
import proj.lear.Learcorporation.Repository.CompteUserRepo;


@Service
public class CompteDAOImpl implements ICompteDAO {
	
	@Autowired
	private CompteRepo compterepo;

	@Autowired
	private CompteUserRepo compteutilisarepo;
	
	@Autowired 
	private CompteGerantRepo comptegerantrepo;
	
	
	@Override
	public void SupprimerCompte(Long id_compte) {
		// TODO Auto-generated method stub
		compterepo.deleteById(id_compte);
	}

	@Override
	public Compte ChercherCompte(Long id_compte) {
		// TODO Auto-generated method stub
		return compterepo.findById(id_compte).orElse(null);
	}

	@Override
	public Compte VerifierCompte(String email, String motpasse) {
		// TODO Auto-generated method stub
		return compterepo.findByEmailAndMotpasse(email, motpasse);
	}

	@Override
	public List<Compte_Utilisateur> ListeCompteUtilisateurs() {
		// TODO Auto-generated method stubs
		return compteutilisarepo.findAll();
	}

	@Override
	public List<Compte_Gérants> ListeCompteGerants() {
		// TODO Auto-generated method stub
		return comptegerantrepo.findAll();
	}

	@Override
	public List<Licence> ListeLicencesReqCompte(Long id_compte) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compteutilisarepo.findById(id_compte).orElse(null);
		return CU.getLicences();
	}

	@Override
	public List<Software> ListeSoftwaresReqCompte(Long id_compte) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compteutilisarepo.findById(id_compte).orElse(null);
		return CU.getSoftwares();
	}

	@Override
	public Compte AjouterCompteU(Compte_Utilisateur C) {
		// TODO Auto-generated method stub
		return compteutilisarepo.save(C);
	}

	@Override
	public void ModifierCompteU(Compte_Utilisateur C) {
		// TODO Auto-generated method stub
		compteutilisarepo.save(C);
	}

	@Override
	public Compte AjouterCompteG(Compte_Gérants C) {
		// TODO Auto-generated method stub
		return comptegerantrepo.save(C);
	}

	@Override
	public void ModifierCompteG(Compte_Gérants C) {
		// TODO Auto-generated method stub
		comptegerantrepo.save(C);
	}

}
