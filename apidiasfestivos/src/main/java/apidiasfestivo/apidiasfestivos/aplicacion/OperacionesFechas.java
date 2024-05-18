
package apidiasfestivo.apidiasfestivos.aplicacion;
import java.util.Calendar;
import java.util.Date;
public class OperacionesFechas {
    
    public static Date  DomingoRamos(int año){
      int a= año %19;
      int b = año%4;
      int c = año%7;
      int d= (19*a+24) % 30;
      int dias = d + (2*b+4*c+6*d+5) % 7;

      int dia = 15+dias;
      int mes=3;

      if(dia>31){
        dia=dia-31;
        mes=4;
      }

      return new Date(año-1900,mes-1,dia);
    }

    public static Date agregarDias (Date fecha, int dias){
        Calendar calendario=Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, dias);

        return calendario.getTime();

    }

    public static Date siguienteLunes(Date fecha){
        Calendar calendario=Calendar.getInstance();
        calendario.setTime(fecha);
        if(calendario.get(Calendar.DAY_OF_WEEK)>Calendar.MONDAY){
           fecha=agregarDias(fecha, 9-calendario.get(Calendar.DAY_OF_WEEK));
        }
        else{
            fecha=agregarDias(fecha,1);
        }
        return fecha;
    }
    public static boolean esMismaFecha(Date fecha1, Date fecha2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(fecha1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(fecha2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public static boolean FechaValida(int año, int mes, int dia) {
        Calendar calendario = Calendar.getInstance();
        calendario.setLenient(false); 
        try {
            calendario.set(año, mes - 1, dia);
            calendario.getTime(); 
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
 }

