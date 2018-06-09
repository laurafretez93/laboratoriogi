package dto;

import java.util.List;

public class permisoDTO {
    private Integer bandera;
    private Integer id;
    private Integer id_grupo;
    private String grupo;
    private String obsv;
    private List<menuItemsDTO> id_menu_item;

    public void setBandera(Integer bandera) {
        this.bandera = bandera;
    }

    public Integer getBandera() {
        return bandera;
    }
    
    public void setObsv(String obsv) {
        this.obsv = obsv;
    }

    public String getObsv() {
        return obsv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Integer id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public List<menuItemsDTO> getId_menu_item() {
        return id_menu_item;
    }

    public void setId_menu_item(List<menuItemsDTO> id_menu_item) {
        this.id_menu_item = id_menu_item;
    }
    
    
    
}
