package apidiasfestivo.apidiasfestivos.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import apidiasfestivo.apidiasfestivos.core.dominio.festivo;
import apidiasfestivo.apidiasfestivos.core.interfaces.servicios.festivoServicio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/festivos")
public class    TipoControlador {
    
     private festivoServicio servicio;
     
     public TipoControlador(festivoServicio servicio){
      
        this.servicio=servicio;
     }

     @RequestMapping(value="/listar", method = RequestMethod.GET)
     public List<festivo> listar(){
        return servicio.listar();

    }
    @RequestMapping(value="/obtener/{id}", method = RequestMethod.GET)
     public festivo obtener(@PathVariable int id){
        return servicio.obtener(id);
      }
     

       
    @RequestMapping(value="/Calcular/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String Calcular (@PathVariable int año,@PathVariable int mes,@PathVariable int dia){
       return servicio.Calcular(año, mes, dia);  
      } 
}
