package start;
	 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "org.sun.resorts.holidays.data.repository.jpa",
//entityManagerFactoryRef = "customEntityManagerFactory")

@Configuration
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class,
                                    DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "start, gestion.turnos.servicios.distribuidos.controlAcceso,"
		+ " gestion.turnos.aplicacion,"
		+ " gestion.turnos.transversal, " 
		+ " org.sun.resorts.holidays")
@EntityScan(basePackages = "org.sun.resorts.holidays.model.jpa")
@EnableJpaRepositories(basePackages = "org.sun.resorts.holidays.data.repository.jpa")
@ImportResource({"classpath:/spring/app_context_web.xml",
	"classpath:/spring/app_context_aplicacion.xml",
	"classpath:/spring-transversal/app_context_transversal.xml",
	"classpath:/spring-transversal/spring-security.xml",
	"classpath:/META-INF/spring/app_context_persistencia.xml"})

public class springBootStart {
     
    public static void main(String[] args) {
        SpringApplication.run(springBootStart.class, args);
    }
   
}
