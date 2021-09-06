package proj.lear.Learcorporation.DAO;

import java.util.List;

import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;

public interface IAprSofDAO {

	
	public List<Software> ListeSoftwaresApprovedUser(Long id_user);
	public void Approv_Software_Use(Long id_dem_software);
	public Approv_Soft Ajoute_Demande_Approve(Long id_Software, Long id_User);
	public List<Approv_Soft> ListeAllApprovSoft();
	public List<Approv_Soft> ListeUserApprovSoft(Long id_User);
	public void Refuse_Software_Use(Long id_dem_software);


}
