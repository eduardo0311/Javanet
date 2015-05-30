package upc.edu.pe.javanet.consultorService;

//import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import upc.edu.pe.javanet.solicitudService.Solicitud;
import upc.edu.pe.javanet.solicitudService.SolicitudDetalle;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

public class ConsultorService {
	final int CODIGOM_MENSAJE_EXITO = 200;
	
	public ConsultorService() {
		// TODO Auto-generated constructor stub
	}
	
	// http://localhost:8080/RESTfulExample/json/product/post
		/*public static void main(String[] args) {
	 
		
		  try {
	 
			//URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
			URL url = new URL("http://localhost:58823/Consultores.svc/Consultores");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
	 
			String input = "{\"Codigo\":4,\"Nombre\":\"Erika\",\"Apellido\":\"Abregu\",\"Especialidad\":\"Java\"}";
	 
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
			//if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				if (conn.getResponseCode() != CODIGOM_MENSAJE_EXITO) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
	 
		}*/
		
		 public int grabarConsultor(String codigo, String nombre, String apellido, String especialidad) {
			  try {
					 
					//URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
					URL url = new URL("http://localhost:58823/Consultores.svc/Consultores");
					
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");
			 
					String input = "{\"Codigo\":"+codigo+",\"Nombre\":\"" + nombre+"\",\"Apellido\":\""+apellido+"\",\"Especialidad\":\""+especialidad+"\"}";
			 
					OutputStream os = conn.getOutputStream();
					os.write(input.getBytes());
					os.flush();
			 
					//if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
						if (conn.getResponseCode() != CODIGOM_MENSAJE_EXITO) {
						throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
					}
			 
					BufferedReader br = new BufferedReader(new InputStreamReader(
							(conn.getInputStream())));
			 
					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}
			 
					conn.disconnect();
					return 1;//exito
			 
				  } catch (MalformedURLException e) {
			 
					e.printStackTrace();
			 
				  } catch (IOException e) {
			 
					e.printStackTrace();
			 
				 }
			 
				return 1;
			}
	 

}
