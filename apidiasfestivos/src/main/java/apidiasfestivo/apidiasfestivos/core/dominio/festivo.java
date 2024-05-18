package apidiasfestivo.apidiasfestivos.core.dominio;


import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity

@Table(name = "festivo")
public class festivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_dias")
    @GenericGenerator(name = "secuencia_dias", strategy = "increment")
    @Column(name="id")
    private int id;
    
    @Column(name= "dia")
    private int dia;

    @Column(name="mes")
    private int mes;
   
    @Column(name= "nombre", length = 100, unique  = true)
    private String nombre;
    
    @Column(name="Idtipo")
    private int Idtipo;
    
    @Column(name="dia_pascua")
    private Integer dia_pascua;

    public festivo(){

    }

    public festivo (int id,int dia,int mes,String nombre,int Idtipo, Integer dia_pascua){
        this.id=id;
        this.dia= dia;
        this.mes=mes;
        this.nombre= nombre;
        this.Idtipo=Idtipo;
        this.dia_pascua=dia_pascua;
    }
    
    public int getid() {
        return id;
    }
    
    public void setid(int id) {
        this.id = id;

    }   
    public int getDia() {
        return dia;
    
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return Idtipo;
    }

    public void setIdTipo(int Idtipo) {
        this.Idtipo = Idtipo;
    }

    public Integer getDia_pascua() {
        return dia_pascua;
    }

    public void setDia_pascua(Integer dia_pascua) {
        this.dia_pascua = dia_pascua;
    }
    
    
}
