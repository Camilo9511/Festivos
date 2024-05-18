package apidiasfestivo.apidiasfestivos.aplicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.stereotype.Service;

import apidiasfestivo.apidiasfestivos.core.dominio.festivo;
import apidiasfestivo.apidiasfestivos.core.interfaces.repositorios.festivoRepositorio;
import apidiasfestivo.apidiasfestivos.core.interfaces.servicios.festivoServicio;

@Service
public class TipoServicio implements festivoServicio {

    private festivoRepositorio repositorio;
    
    
    public TipoServicio(festivoRepositorio repositorio) {

        this.repositorio=repositorio;

    }

   

   

    @Override
    public List<festivo> listar() {

        return repositorio.findAll();
    }

    @Override
    public festivo obtener(int id) {
     Optional<festivo> festivo_e= repositorio.findById(id);

        return festivo_e.isEmpty()?null:festivo_e.get();
    }    

    @Override
    public List<festivo> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public festivo agregar(festivo festivo) {
       festivo.setid(0);
        return repositorio.save(festivo);
    }

    @Override
    public festivo modificar(festivo festivo) {
        Optional<festivo> festivo_encontrado= repositorio.findById(festivo.getid());
        return festivo_encontrado.isEmpty()? null: repositorio.save(festivo);
    }

    @Override
    public boolean eliminar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
   
    @Override
    public boolean esFestivo(LocalDate fecha) {
            Date fechaActu = new Date(fecha.getYear() - 1900, fecha.getMonthValue() - 1, fecha.getDayOfMonth());
    
            Date domingoRamos = OperacionesFechas.DomingoRamos(fecha.getYear());
            Date domingoPascua = OperacionesFechas.agregarDias(domingoRamos, 7);
            Date ascensionSenor = OperacionesFechas.siguienteLunes(OperacionesFechas.agregarDias(domingoPascua, 40));
            Date santosReyes = OperacionesFechas.siguienteLunes(new Date(fecha.getYear() - 1900, 0, 6));



  
        return OperacionesFechas.esMismaFecha(fechaActu, domingoRamos) ||
               OperacionesFechas.esMismaFecha(fechaActu, domingoPascua) ||
               OperacionesFechas.esMismaFecha(fechaActu, ascensionSenor) ||
               OperacionesFechas.esMismaFecha(fechaActu, santosReyes);
    }
   
    
    
    
    @Override
    public String Calcular(int dia, int mes, int año) {
        if (!OperacionesFechas.FechaValida(año, mes, dia)) {
            return "Fecha no válida";
        }

        
        Date fecha = new Date(año - 1900, mes - 1, dia);

        if ((dia == 1 && mes == 1) || 
            (dia == 20 && mes == 7)||
            (dia == 1 && mes == 5)||
            (dia == 7 && mes == 8)||
            (dia == 8 && mes == 12)|| 
            (dia == 25 && mes == 12)) { 
                
            return "es festivo";
        }

        if (OperacionesFechas.esMismaFecha(fecha, OperacionesFechas.DomingoRamos(año))) {
            return "es festivo";
        } else if (OperacionesFechas.esMismaFecha(fecha, OperacionesFechas.agregarDias(OperacionesFechas.DomingoRamos(año), 7))) {
            return "es festivo";
        } else if (OperacionesFechas.esMismaFecha(fecha, OperacionesFechas.siguienteLunes(OperacionesFechas.agregarDias(OperacionesFechas.DomingoRamos(año), 40)))) {
            return "es festivo";
        } else if (OperacionesFechas.esMismaFecha(fecha, OperacionesFechas.siguienteLunes(new Date(año - 1900, 0, 6)))) {
            return "es festivo";
        } else {
            return "No es festivo";
        }
    } 
   
   
   
    
}


