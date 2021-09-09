package proj.lear.Learcorporation.DAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Repository.AprovLicRep;
import proj.lear.Learcorporation.Repository.CompteUserRepo;
import proj.lear.Learcorporation.Repository.LicenceRepo;


@Service
public class AprvLicDAOImpl implements IAprLicDAO{
	
	@Autowired
	private LicenceRepo licencerepo;
	
	@Autowired
	private AprovLicRep aprovlicrepo;
	
	@Autowired
	private ILicenceDAO licdao;
	
	@Autowired
	private CompteUserRepo compteusrepo;
	
	@Autowired
	private ICompteDAO comptedao;
	

	@Override
	public List<Licence> ListeLicencesApprovedUser(Long id_user) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compteusrepo.findById(id_user).orElse(null);
		return CU.getLicences();
	}

	@Override
	public void Approv_Licence_Use(Long id_dem_software) {
		// TODO Auto-generated method stub
		Aprov_Lic AL = aprovlicrepo.findById(id_dem_software).orElse(null);
		AL.setAcceptee(true);
		AL.setDate_Approv(LocalDate.now());
		aprovlicrepo.save(AL);
		Licence S = AL.getLicence();
		Compte_Utilisateur CU = AL.getUser();
		List<Licence> L = CU.getLicences();
		L.add(S);
	}
	
	@Override
	public Aprov_Lic Ajoute_Demande_Approve(Long id_Software, Long id_User) {
		// TODO Auto-generated method stub
		Licence S = licdao.ChercherLicence(id_Software);
		System.out.println(S.getCurrency());
		Compte_Utilisateur CU = (Compte_Utilisateur) comptedao.ChercherCompte(id_User);
		System.out.println(CU.getFirst_name());
		return aprovlicrepo.save(new Aprov_Lic(LocalDate.now(), null, false, S, CU));
	}

	@Override
	public List<Aprov_Lic> ListeAllApprovLic() {
		// TODO Auto-generated method stub
		return aprovlicrepo.findAll();
	}

	@Override
	public List<Aprov_Lic> ListeUserApprovLic(Long id_User) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = (Compte_Utilisateur) comptedao.ChercherCompte(id_User);
		List<Aprov_Lic> L = aprovlicrepo.findAll();
		List<Aprov_Lic> L1 = null;
		
		for(Aprov_Lic A : L) {
			Compte_Utilisateur C = A.getUser();
		   if(C == CU ) {
			   L1.add(A);
		   }
		} 
		return L1;
	}

	@Override
	public void Refuse_Licence_Use(Long id_dem_software) {
		// TODO Auto-generated method stub
		Aprov_Lic AL = aprovlicrepo.findById(id_dem_software).orElse(null);
		AL.setAcceptee(false);
		AL.setDate_Approv(LocalDate.now());
		aprovlicrepo.save(AL);
	}


	
	

}
