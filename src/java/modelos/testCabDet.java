package modelos;

import dto.menuItemsDTO;
import dto.permisoDTO;
import java.util.ArrayList;
import java.util.List;

public class testCabDet {
    private permisoDTO dto;
    private menuItemsDTO menuItemDTO;
    private List<menuItemsDTO> listMenuItem;
    
    private permisosMDL modelo;
    
    
    public testCabDet() {
        //list del menu_item
        listMenuItem=new ArrayList<>();
    //manejo de detalle - menu_item
        for (int i = 1; i <= 3; i++) {
            menuItemDTO=new menuItemsDTO();
            menuItemDTO.setId(i);
            listMenuItem.add(menuItemDTO);
        }
        
//    var listaProductos = [];
//    tabladetalleproductos
//    $("#tabladetalleproductos  tr").each(function () {
//        //push => Agrega un nuevo elemento al Array [listaProductos]
//        listaProductos.push({
//            id: $(this).find("td").eq(0).html(),
//            cantidad: $(this).find("td").eq(2).html()
//        });
//    });
        
        
        
        //datos de la cab
        permisoDTO dto=new permisoDTO();
        dto.setGrupo("Test");
        dto.setObsv("Test OK");
        dto.setId_menu_item(listMenuItem);
        
        //modelo
        modelo=new permisosMDL();
        modelo.agregar(dto);
        
        
    }

    public static void main(String[] args) {
        new testCabDet();
    }
    
}
