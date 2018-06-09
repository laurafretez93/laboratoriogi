package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import permisos.menuDinamico;
import permisos.menuItemDinamico;

public class permisosUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //1. mecanismo para obtener datos del login 
        
        //2. verificar los datos contra la BD
        
        //3. si existe y no está bloqueado recuperar el o los permisos del usuario
        
        Integer permiso=1;
        
        /*
         bloqueMovimiento = " <div class=\"w3-dropdown-hover\">\n"
                + "                    <button class=\"w3-button\">Referenciales</button>\n"
                + "                    <div class=\"w3-dropdown-content w3-bar-block w3-card-2\">\n"
                + "                        <a href=\"paginas/Perfil.html\" target=\"contenedor_paginas\" class=\"w3-bar-item w3-button\">Pedidos</a>\n"
                + "                        <a href=\"MantenerPerfil.html\" class=\"w3-bar-item w3-button\" target=\"contenedor_paginas\">Compras</a>\n"
                + "                        <a href=\"MantenerPerfil.html\" class=\"w3-bar-item w3-button\" target=\"contenedor_paginas\">Ventas</a>\n"
                + "                        <a href=\"MantenerPerfil.html\" class=\"w3-bar-item w3-button\" target=\"contenedor_paginas\">Produccion</a>\n"
                + "                    </div>\n"
                + "                </div> ";
        */
        String bloqueAdministrativo="";
        
        for (Object menu : menuDinamico.values()) {
            for (menuItemDinamico menuItem : menuItemDinamico.values()) {
                if (menu.equals(menuItem.getMenu())) {
                    
                }        
            }
            
        }

        
        
        
        switch (permiso) {
            case 1:
                bloqueAdministrativo += menuItemDinamico.MANTENERCIUDAD.getHref() +
                        " " + menuItemDinamico.MANTENERCIUDAD.getEstilo().getEstilo() + menuItemDinamico.MANTENERCIUDAD.getMenu();
                bloqueAdministrativo += menuItemDinamico.MANTENERGRUPO.getHref() +
                " " + menuItemDinamico.MANTENERGRUPO.getEstilo().getEstilo() + menuItemDinamico.MANTENERGRUPO.getMenu();
                bloqueAdministrativo += menuItemDinamico.MANTENERPERFIL.getHref()+
                        " " + menuItemDinamico.MANTENERPERFIL.getEstilo().getEstilo()+ menuItemDinamico.MANTENERPERFIL.getMenu();
            break;
            case 2:
                
            break;
            case 3:
                
            break;
        }
        System.out.println("Bloque " +  bloqueAdministrativo);  
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
