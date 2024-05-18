package apidiasfestivo.apidiasfestivos.core.interfaces.servicios;

import java.time.LocalDate;
import java.util.List;


import apidiasfestivo.apidiasfestivos.core.dominio.festivo;

public interface festivoServicio {
    
    public List<festivo> listar();

    public festivo obtener (int id);

    public List<festivo> buscar(String nombre);

    public festivo agregar(festivo festivo);

    public festivo modificar(festivo festivo);

    public boolean eliminar(int id);
    
    boolean esFestivo(LocalDate fecha);

    public String Calcular (int año, int mes, int dia);
    
    public List<festivo> listarFestivosFijos();
}
