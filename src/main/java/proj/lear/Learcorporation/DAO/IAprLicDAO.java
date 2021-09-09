package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Licence;

public interface IAprLicDAO {
	
	public List<Licence> ListeLicencesApprovedUser(Long id_user);
	public void Approv_Licence_Use(Long id_dem_licence);
	public Aprov_Lic Ajoute_Demande_Approve(Long id_Licence, Long id_User);
	public List<Aprov_Lic> ListeAllApprovLic();
	public List<Aprov_Lic> ListeUserApprovLic(Long id_User);
	public void Refuse_Licence_Use(Long id_dem_licence);

}
