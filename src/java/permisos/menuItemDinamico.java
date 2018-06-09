package permisos;

import static permisos.sintaxisOpcionesMenuItems.a;
import static permisos.menuDinamico.*;

public enum menuItemDinamico {
    
    //<a href="#" class="w3-bar-item w3-button">
    //\"paginas/Perfil.html\

    MANTENERCIUDAD(a,"\"Paginas/ciudad.html\"","Mantener Ciudad",REFERENCIALES),
    MANTENERGRUPO(a,"\"Paginas/grupo.html\"","Mantener Grupo",COMPRAS),
    MANTENERPERFIL(a,"\"Paginas/perfil.html\"","Mantener Perfil",VENTAS);
    

    
    private final sintaxisOpcionesMenuItems estilo;
    private final String href;
    private final String titulo;
    private final menuDinamico menu;

    private menuItemDinamico(sintaxisOpcionesMenuItems estilo, String href, String titulo, menuDinamico menu) {
        this.estilo = estilo;
        this.href = href;
        this.titulo = titulo;
        this.menu = menu;
    }

    public String getHref() {
        return href;
    }

    public String getTitulo() {
        return titulo;
    }

    public menuDinamico getMenu() {
        return menu;
    }

    public sintaxisOpcionesMenuItems getEstilo() {
        return estilo;
    }

    
    
}
