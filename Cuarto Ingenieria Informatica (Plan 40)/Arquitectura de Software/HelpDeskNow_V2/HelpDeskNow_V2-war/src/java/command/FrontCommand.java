/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Entrar
 */
public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) {
        this.context = servletContext;
        this.request = request;
        this.response = response;
    }
    
    public abstract void execute();
    
    public void forward(String target) throws ServletException, IOException{
        RequestDispatcher dp = context.getRequestDispatcher(target);
        if(dp != null){
            dp.forward(request, response);
        } else {
            
        }
    }

}
