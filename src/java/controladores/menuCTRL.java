
package controladores;

import com.google.gson.Gson;
import dto.menuDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.menuMDL;


public class menuCTRL extends HttpServlet {
    private menuDTO dto;
    private menuMDL modelo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        BufferedReader br = new BufferedReader
                           (new InputStreamReader(
                                   request.getInputStream()));
        String json = "";
        if (br.ready()) {
            json = br.readLine();
        }
        
        
        
        
        dto = new Gson().fromJson(json, menuDTO.class);
        modelo=new menuMDL();
        switch (dto.getBandera()) {
            case 1:
                if (modelo.agregar(dto)) {
                    out.println("ok");
                    out.close();
                }
                //response.sendRedirect("Paginas/menu.html");
            break;
            case 2:
                modelo.modificar(dto);
                //response.sendRedirect("Paginas/menu.html");
            break;
            case 3:
                modelo.eliminar(dto);
                //response.sendRedirect("Paginas/menu.html");
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
                out.println(datosTabla);
                out.close();
                //response.sendRedirect("Paginas/menu.html");
              //  RequestDispatcher rd = request.getRequestDispatcher("/Paginas/menu.html");
              //  rd.forward(request, response);
                break;
        
        }
        
        
        
        
        
        
//        System.out.println("Estamos en el controlador....");  
//        System.out.println("id " + id_menu);
//        System.out.println("nombre " + nombre_menu);
//        System.out.println("obvs " + obvs_menu);
//        
//        id_menu= ((request.getParameter("id_menu") == null || request.getParameter("id_menu").isEmpty()) ? 0 
//                    : Integer.parseInt(request.getParameter("id_menu")));
//
//        nombre_menu= (request.getParameter("nombre_menu") == null ? "" 
//                    : request.getParameter("nombre_menu")) ;
//        
//        obvs_menu= (request.getParameter("obsv_menu") == null ? "" 
//                    : request.getParameter("obsv_menu"));
//
//        
//        opc_Agregar=(request.getParameter("opc_agregar") != null);
//        opc_Modificar=(request.getParameter("opc_modificar") != null);
//        opc_Eliminar=(request.getParameter("opc_eliminar") != null);
//        opc_Recuperar=(request.getParameter("opc_recuperar") != null);
//                
//        dto=new menuDTO();
//        modelo=new menuMDL();
        
//        dto.setId(id_menu);
//        dto.setNombre(nombre_menu);
//        dto.setObsv(obvs_menu);
//        
//        if (opc_Agregar) {
//            modelo.agregar(dto);
//            response.sendRedirect("Paginas/menu.html");
//        }else if(opc_Modificar){
//            modelo.modificar(dto);
//            response.sendRedirect("Paginas/menu.html");
//        }else if(opc_Eliminar){
//            modelo.eliminar(dto);
//            response.sendRedirect("Paginas/menu.html");
//        }else if(opc_Recuperar){
//            System.out.println("opc_Recuperar ON");
//            
//            String formatoJson = new Gson().toJson(modelo.consultarSegunID(dto));
//            out.println(formatoJson);
//            System.out.println("Json Obtenido " + formatoJson);
//            RequestDispatcher rd=request.getRequestDispatcher("Paginas/menu.html");
//            rd.forward(request, response);
//        // response.sendRedirect("Paginas/menu.html");
//        }else{
//            String formatoJson = new Gson().toJson( modelo.consultarTodos());
//            out.println(formatoJson);
//            //System.out.println("Objeto Obtenido " + modelo.consultarTodos());
//            //System.out.println("Json Obtenido " + formatoJson);
//
//        }

        
        
        
        
        
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
