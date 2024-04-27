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
@Table(name= "tipo")
public class tipo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivos")
    @GenericGenerator(name = "secuencia_festivos", strategy = "increment")
    @Column(name="id")
    private int id;

    
    @Column(name= "tipo", length = 100, unique=true)
    private String tipo;


    public tipo() {
    }


    public tipo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
  
}
