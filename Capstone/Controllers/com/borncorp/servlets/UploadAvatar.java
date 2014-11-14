package com.borncorp.servlets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 




import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.imgscalr.Scalr;

import com.borncorp.models.DBConnection;


/**
 * Servlet implementation class UploadAvatar
 */
@MultipartConfig(maxFileSize = 500000)    // upload file's size up to 16MB
@WebServlet("/UploadAvatar")
public class UploadAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAvatar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getSession().getAttribute("isLoggedIn").toString();
		
		        InputStream avatar = null; // input stream of the upload file
		         
		        // obtains the upload file part in this multipart request
		        Part filePart = request.getPart("photo");
		        if (filePart != null) {
		            // prints out some information for debugging
		            System.out.println(filePart.getName());
		            System.out.println(filePart.getSize());
		            System.out.println(filePart.getContentType());
		             
		            // obtains input stream of the upload file
		            avatar = filePart.getInputStream();
		        }
		        
		        if (avatar != null) {
	                // fetches input stream of the upload file for the blob column
			        BufferedImage avatarthumb = ImageIO.read(avatar);
			        avatarthumb = Scalr.resize(avatarthumb, 64);
		        	
			        new DBConnection().uploadAvatar(username, avatarthumb);
	            }
    
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
     
    }
}
