package apidiasfestivo.apidiasfestivos;

import java.util.Date;
import apidiasfestivo.apidiasfestivos.aplicacion.OperacionesFechas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ApidiasfestivosApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication.run(ApidiasfestivosApplication.class, args);
	    
		int año=2024;

		Date domingoramos= OperacionesFechas.DomingoRamos(año);

		System.out.println("domingo de ramos" + domingoramos);
	    
		Date domingoPascua= OperacionesFechas.agregarDias(domingoramos,7);

		System.out.println("domingo de pascua " + domingoPascua);

		Date ascensioNSeñor=OperacionesFechas.siguienteLunes(OperacionesFechas.agregarDias(domingoPascua,40));

		System.out.println("ascencion del señor " + ascensioNSeñor);
        
		Date santosReyes=OperacionesFechas.siguienteLunes(new Date(2024-1900,0,6));
		System.out.println("santos reyes " + santosReyes);
	}

}
