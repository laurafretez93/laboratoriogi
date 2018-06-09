package genericos;

public interface baseCabDet <T>{
    Boolean agregar( T objeto );
    Boolean anular( T objeto );
    Boolean modificar( T objeto );
    T consultarSegunId(T objeto );
    Boolean enviarImpresion(T objeto);
}
