package proj.lear.Learcorporation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import proj.lear.Learcorporation.DAO.IAprLicDAO;
import proj.lear.Learcorporation.DAO.IAprSofDAO;
import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Aprov_Lic;
import proj.lear.Learcorporation.Entity.Compte;

@RestController
@RequestMapping("/AprLic")
public class ApprovLicController {
	
	@Autowired
	private IAprLicDAO aprvlic;
	
	@GetMapping("/accepter/{id}")
	public ResponseEntity<?> AccepterLocation(@PathVariable("id") Long id_dem_software){
		aprvlic.Approv_Licence_Use(id_dem_software);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/refuser/{id}")
	public ResponseEntity<?> RefuserLocation(@PathVariable("id") Long id_dem_software){
		aprvlic.Refuse_Licence_Use(id_dem_software);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/Ajouter")
	@ApiOperation(value = "Demmander Apprv Software",
    notes="vous devez specifier id_user et id_software")
	public ResponseEntity<Aprov_Lic> AjouterAprv(@ApiParam(value = "Software id",required = true)  @RequestParam Long id_software , @ApiParam(value = "user id",required = true) @RequestParam  Long id_user){
	    System.out.println("ANA HNA 1");
        Aprov_Lic APS = aprvlic.Ajoute_Demande_Approve(id_software, id_user);
	    System.out.println(APS.getDate_Request());
		return new ResponseEntity<>(APS,HttpStatus.OK);
	}
	
	@GetMapping("/listeDemAprv")
	public ResponseEntity<List<Aprov_Lic>> ListeDemAprv(){
		List<Aprov_Lic> L = aprvlic.ListeAllApprovLic();
		return new ResponseEntity<>(L,HttpStatus.OK);
	}

}

