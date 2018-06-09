
package permisos;

public enum menuDinamico {

REFERENCIALES("MENU SOLO ADMINISTRATIVO"),
COMPRAS(""),
VENTAS(""),
SERVICIOS(""),
AYUDA("MENU SOLO AYUDA AL USUARIO");
    
private final String titulo;

    private menuDinamico(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

}
