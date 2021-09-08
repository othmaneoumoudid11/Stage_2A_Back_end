package proj.lear.Learcorporation.DAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Software;
import proj.lear.Learcorporation.Repository.ApproSofRepo;
import proj.lear.Learcorporation.Repository.CompteUserRepo;


@Service
public class AprvSoftDAOImpl implements IAprSofDAO{
	
	@Autowired
	private ApproSofRepo approvsoft;
	
	@Autowired
	private ISoftwareDAO sofdao;
	
	@Autowired
	private CompteUserRepo compteusrepo;
	
	@Autowired
	private ICompteDAO comptedao;
	
	@Autowired
	private ApproSofRepo appsofrepo;

	@Override
	public List<Software> ListeSoftwaresApprovedUser(Long id_user) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = compteusrepo.findById(id_user).orElse(null);
		return CU.getSoftwares();
	}

	@Override
	public void Approv_Software_Use(Long id_dem_software) {
		// TODO Auto-generated method stub
		Approv_Soft AL = approvsoft.findById(id_dem_software).orElse(null);
		AL.setAcceptee(true);
		AL.setDate_Approv(LocalDate.now());
		AL.setStatus(1);
		approvsoft.save(AL);
		Software S = AL.getSoftware();
		Compte_Utilisateur CU = AL.getUser();
		List<Software> L = CU.getSoftwares();
		L.add(S);
	}
	
	@Override
	public Approv_Soft Ajoute_Demande_Approve(Long id_Software, Long id_User) {
		// TODO Auto-generated method stub
		Software S = sofdao.ChercherSoftware(id_Software);
		System.out.println(S.getSoft_Desc());
		Compte_Utilisateur CU = (Compte_Utilisateur) comptedao.ChercherCompte(id_User);
		System.out.println(CU.getFirst_name());
		return approvsoft.save(new Approv_Soft(LocalDate.now(), null, false, 0, S, CU));
	}

	@Override
	public List<Approv_Soft> ListeAllApprovSoft() {
		// TODO Auto-generated method stub
		return appsofrepo.findAll();
	}

	@Override
	public List<Approv_Soft> ListeUserApprovSoft(Long id_User) {
		// TODO Auto-generated method stub
		Compte_Utilisateur CU = (Compte_Utilisateur) comptedao.ChercherCompte(id_User);
		List<Approv_Soft> L = appsofrepo.findAll();
		List<Approv_Soft> L1 = null;
		
		for(Approv_Soft A : L) {
			Compte_Utilisateur C = A.getUser();
		   if(C == CU ) {
			   L1.add(A);
		   }
		} 
		return L1;
	}

	@Override
	public void Refuse_Software_Use(Long id_dem_software) {
		// TODO Auto-generated method stub
		Approv_Soft AL = approvsoft.findById(id_dem_software).orElse(null);
		AL.setAcceptee(false);
		AL.setDate_Approv(LocalDate.now());
		AL.setStatus(2);
		approvsoft.save(AL);
	}
}
