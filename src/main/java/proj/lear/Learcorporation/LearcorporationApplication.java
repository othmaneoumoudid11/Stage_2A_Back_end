package proj.lear.Learcorporation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import proj.lear.Learcorporation.DAO.CompteDAOImpl;
import proj.lear.Learcorporation.DAO.IAprSofDAO;
import proj.lear.Learcorporation.DAO.ILicenceDAO;
import proj.lear.Learcorporation.DAO.ISoftwareDAO;
import proj.lear.Learcorporation.Entity.Approv_Soft;
import proj.lear.Learcorporation.Entity.Compte;
import proj.lear.Learcorporation.Entity.Compte_Utilisateur;
import proj.lear.Learcorporation.Entity.Licence;
import proj.lear.Learcorporation.Entity.Software;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class LearcorporationApplication implements CommandLineRunner{
	
	@Autowired
	private ILicenceDAO licencedao;

	@Autowired
	private ISoftwareDAO sotwaredao;
	
	@Autowired
	private IAprSofDAO aprsof;
	
	public static void main(String[] args) {
		SpringApplication.run(LearcorporationApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("proj.lear.Learcorporation.Controllers"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	private ApiInfo apiDetails() {
	    return new ApiInfoBuilder()
	            .title( "application de gestion de Licences et softwares" )
	            .description( "Toutes les demandes auxquelles le serveur r??pondra." )
	            .version( "1.0.0" )
	            .build();
	}
	
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Autowired
	CompteDAOImpl comptedao;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Software S = sotwaredao.AjouterSoftware(new Software("soft_ref", "soft_manif", "soft_suppl", "soft_familly", "soft_version","soft_Desc","hgcgh"));
		//Licence L = licencedao.AjouterLicence(new Licence("cvghjhccvh", "0", "khghjkbhhxxxx", "0", "xxxyy",
				//"cc", "cc", S));
		Compte C =  comptedao.AjouterCompteU(new Compte_Utilisateur("first_name", "last_name", "email", "motpasse", "Num_telephone"));
		
		Approv_Soft APRS = aprsof.Ajoute_Demande_Approve(1L, 1L);

	}
	


	
}
