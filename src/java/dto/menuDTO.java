package dto;

public class menuDTO {
    private Integer bandera;
    private Integer id;
    private String  nombre;
    private String  obsv;

    public void setBandera(Integer bandera) {
        this.bandera = bandera;
    }

    public Integer getBandera() {
        return bandera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObsv() {
        return obsv;
    }

    public void setObsv(String obsv) {
        this.obsv = obsv;
    }
  
}
