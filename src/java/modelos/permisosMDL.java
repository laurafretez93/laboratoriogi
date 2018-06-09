package modelos;

import dto.menuItemsDTO;
import dto.permisoDTO;
import genericos.ConexionBD;
import genericos.TipoMotorBD;
import genericos.baseCabDet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class permisosMDL implements baseCabDet<permisoDTO>{
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;
    private final ConexionBD conec;

    public permisosMDL() {
        this.conec = new ConexionBD(TipoMotorBD.POSTGRESQL);
    }
    
    @Override
    public Boolean agregar(permisoDTO objeto) {
        try {
            query="INSERT INTO grupos(nombre, obsv) VALUES ( ?, ?);";
            ps=conec.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, objeto.getGrupo().trim());
            ps.setString(2, objeto.getObsv().trim());
            if (ps.executeUpdate() > 0) {
                int id_grupo;
                rs=ps.getGeneratedKeys();
                if (rs.next()) {
                    id_grupo=rs.getInt(1);
                    for (menuItemsDTO itemDTO : objeto.getId_menu_item()) {
                        query="INSERT INTO permisos(id_menu_item, id_grupo) VALUES (?, ?);";
                        ps=conec.getConnection().prepareStatement(query);
                        ps.setInt(1, itemDTO.getId());
                        ps.setInt(2, id_grupo);
                        if (ps.executeUpdate() <=0) {
                            return false;
                            //roollbact
                        }
                    }
                    
                }
            } else {
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(permisosMDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Boolean anular(permisoDTO objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean modificar(permisoDTO objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public permisoDTO consultarSegunId(permisoDTO objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean enviarImpresion(permisoDTO objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
