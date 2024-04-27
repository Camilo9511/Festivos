package apidiasfestivo.apidiasfestivos.core.dominio;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.DialectOverride.GeneratedColumns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity

@Table(name = "nombre")
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
    private int dia_pascua;

    public festivo(){

    }

    public festivo (int id,int dia,int mes,String nombre,int Idtipo, int dia_pascua){
        this.id=id;
        this.dia= dia;
        this.mes=mes;
        this.nombre= nombre;
        this.Idtipo=Idtipo;
        this.dia_pascua=dia_pascua;
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

    public void setNombres(String nombres) {
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return Idtipo;
    }

    public void setIdTipo(int tipo) {
        this.Idtipo = Idtipo;
    }

    public int getDia_pascua() {
        return dia_pascua;
    }

    public void setDia_pascua(int dia_pascua) {
        this.dia_pascua = dia_pascua;
    }
    
}
