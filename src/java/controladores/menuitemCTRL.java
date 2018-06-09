/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import dto.menuItemsDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.menuItemMDL;
import modelos.menuMDL;


@WebServlet(name = "menuitemCTRL", urlPatterns = {"/menuitemCTRL"})
public class menuitemCTRL extends HttpServlet {
    private menuItemsDTO dto;
    private menuItemMDL modelo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        BufferedReader br = new BufferedReader
                           (new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br.ready()) {
            json = br.readLine();
        }
        System.out.println(" json obtenido " + json);
        
        dto = new Gson().fromJson(json, menuItemsDTO.class);
        modelo=new menuItemMDL();
        switch (dto.getBandera()) {
            case 1:
                if (modelo.agregar(dto)) {
                    System.out.println(" Agregar True");
                }
            break;
            
            case 2:
                modelo.modificar(dto);
            break;
            
            case 3:
                modelo.eliminar(dto);
            break;
            
            case 4:
                response.setContentType("application/json, charset=UTF-8");
                String formatoJson = new Gson().toJson(modelo.consultarSegunID(dto));
                out.println("["+formatoJson+"]");
                out.close();
            break;
            
            case 5:
                response.setContentType("application/json, charset=UTF-8");
                String datosTabla = new Gson().toJson(modelo.consultarTodos());
                //System.out.println("Json MenuItem " + datosTabla);
                out.println(datosTabla);
                out.close();
            break;
            case 6:
                menuMDL modeloMenu=new menuMDL();
                response.setContentType("application/json, charset=UTF-8");
                String datosMenu = new Gson().toJson(modeloMenu.consultarTodos());
                out.println(datosMenu);
                out.close();
            break;
        }
//        
//        
////        System.out.println("id " + id_menuitem);
////        System.out.println("nombre " + nombre_menuitem);
////        System.out.println("obvs " + obvs_menuitem);
////        
////        id= ((request.getParameter("id_menu") == null || request.getParameter("id_menu").isEmpty()) ? 0 
////                    : Integer.parseInt(request.getParameter("id_menu")));
////
////        id_menuitem= ((request.getParameter("id_menu") == null || request.getParameter("id_menu").isEmpty()) ? 0 
////                    : Integer.parseInt(request.getParameter("id_menu")));
////
////        
////        nombre_menuitem= (request.getParameter("nombre_menu") == null ? "" 
////                    : request.getParameter("nombre_menu")) ;
////        
////        obvs_menuitem= (request.getParameter("obsv_menu") == null ? "" 
////                    : request.getParameter("obsv_menu"));
////
////        opc_Agregar=(request.getParameter("opc_agregar") != null);
////        opc_Modificar=(request.getParameter("opc_modificar") != null);
////        opc_Eliminar=(request.getParameter("opc_eliminar") != null);
////        
////        
////        dto=new menuItemsDTO();
////        modelo=new menuItemMDL();
////        
////        
////        dto.setId(id);
////        dto.setMenu_item(nombre_menuitem);
////        dto.setMenu_item_obs(obvs_menuitem);
////        dto.setId_menu(id_menuitem);
////        
////        if (opc_Agregar) {
////            modelo.agregar(dto);
////            response.sendRedirect("Paginas/menu.html");
////        }else if(opc_Modificar){
////            modelo.modificar(dto);
////            response.sendRedirect("Paginas/menu.html");
////        }else if(opc_Eliminar){
////            modelo.eliminar(dto);
////            response.sendRedirect("Paginas/menu.html");
////        }else{
////            
////            for (menuItemsDTO i : modelo.consultarTodos()) {
////                System.out.println("id " + i.getId());
////            }
////            
////            String formatoJson= new Gson().toJson( modelo.consultarTodos());
////            
////            
////            out.println( "DATOS... " + formatoJson);
////        }
//  
        
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
