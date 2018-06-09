package permisos;

public enum sintaxisOpcionesMenuItems {
    a("class=\"w3-bar-item w3-button\"");
    
    private final String estilo;

    private sintaxisOpcionesMenuItems(String estilo) {
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }
    
    
    
}
