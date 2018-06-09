package controladores;

import com.google.gson.Gson;
import dto.permisoDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.permisosMDL;

public class permisoCTRL extends HttpServlet {
    private permisoDTO  dto;
    private permisosMDL modelo;
    
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
        System.out.println(" json obtenido " + json);
        
        dto=new Gson().fromJson(json, permisoDTO.class);
        modelo=new permisosMDL();
        switch (dto.getBandera()) {
            case 1:
                modelo.agregar(dto);
            break;
            case 2:
                modelo.anular(dto);
            break;
            case 3:
                modelo.consultarSegunId(dto);
            break;
            
        }
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
