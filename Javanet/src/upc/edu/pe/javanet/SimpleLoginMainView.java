package upc.edu.pe.javanet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class SimpleLoginMainView extends CustomComponent implements View {

    public static final String NAME = "";
   
    Label text = new Label();
     

    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });
    
       
     
    

    public SimpleLoginMainView() {
    	
    	MenuBar menuPrincipal = new MenuBar();
		menuPrincipal.addStyleName("mybarmenu");
		   
		
		MenuBar.Command mycommand = new MenuBar.Command() {
		       MenuItem previous = null;

		       public void menuSelected(MenuItem selectedItem) {
		    	   if(selectedItem.getText().equals("Generar Solicitud")){
		    		   
		    		   Navigator navigator = getUI().getNavigator();
		    		   navigator.addView(PreGenerarSolicitudView.NAME, PreGenerarSolicitudView.class);
		    		   //navigator.addView(PreGenerarSolicitudMainView.NAME,PreGenerarSolicitudMainView.class);
		   	        
		    		   navigator.navigateTo(PreGenerarSolicitudView.NAME);
		    	   }
		    	  
                    if(selectedItem.getText().equals("Registrar Proyecto")){
		    		   
		    		   Navigator navigator = getUI().getNavigator();
		    		   //navigator.addView(RegistrarConsultorView.NAME, RegistrarConsultorView.class);
		    		  //navigator.addView(PreGenerarSolicitudView.NAME,PreGenerarSolicitudView.class);
		    		  navigator.addView(RegistrarProyectoView.NAME,RegistrarProyectoView.class);
		   	        
		    		   //navigator.navigateTo(PreGenerarSolicitudView.NAME);
		    		   navigator.navigateTo(RegistrarProyectoView.NAME);
		    	   }
                    
                    if(selectedItem.getText().equals("Asignar Consultor")){
 		    		   
 		    		   Navigator navigator = getUI().getNavigator();
 		    		   navigator.addView(GenerarAsignacionView.NAME, GenerarAsignacionView.class);
 		    		   //navigator.addView(PreGenerarSolicitudMainView.NAME,PreGenerarSolicitudMainView.class);
 		   	        
 		    		   navigator.navigateTo(GenerarAsignacionView.NAME);
 		    	   }
		    	   
                    if(selectedItem.getText().equals("Registrar Consultor")){
 		    		   
 		    		   Navigator navigator = getUI().getNavigator();
 		    		   //navigator.addView(RegistrarConsultorView.NAME, RegistrarConsultorView.class);
 		    		  //navigator.addView(PreGenerarSolicitudView.NAME,PreGenerarSolicitudView.class);
 		    		  navigator.addView(RegistrarConsultorView.NAME,RegistrarConsultorView.class);
 		   	        
 		    		   //navigator.navigateTo(PreGenerarSolicitudView.NAME);
 		    		   navigator.navigateTo(RegistrarConsultorView.NAME);
 		    	   }
	            if (previous != null)
	            	previous.setStyleName(null);
		            //selectedItem.setStyleName("highlight");
		            previous = selectedItem;
		        }  
		    };
		            
		   MenuItem cliente = menuPrincipal.addItem("Cliente", null, null);
		   MenuItem solicitud = menuPrincipal.addItem("Solicitud", null, null);
		   MenuItem consultor = menuPrincipal.addItem("Consultor", null, null);
		   
		   MenuItem generarSolicitud = solicitud.addItem("Generar Solicitud", null, mycommand);
		   MenuItem registrarCliente = cliente.addItem("Registrar Cliente", null, mycommand);
		   MenuItem registrarProyecto = cliente.addItem("Registrar Proyecto", null, mycommand);
		   MenuItem registrarConsultor = consultor.addItem("Registrar Consultor", null, mycommand);
		   MenuItem asignarConsultor = consultor.addItem("Asignar Consultor", null, mycommand);
		   MenuItem consultarDisponibilidadConsultor = consultor.addItem("Consultar Disponibilidad", null, mycommand);
		   
		   ThemeResource resource = new ThemeResource("imagen/Logo_MDP.jpg");
		   Embedded image = new Embedded("", resource);
		   		    
		    
		   VerticalLayout bienvenido = new VerticalLayout(text);
		   bienvenido.setSpacing(true);
		   bienvenido.setCaption(text.getValue());
	       bienvenido.setMargin(new MarginInfo(true, true, false, true));
		   //bienvenido.setSizeUndefined();
	       
	       VerticalLayout cuerpo = new VerticalLayout(image);
	       cuerpo.setSpacing(true);
	       cuerpo.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
	       cuerpo.setMargin(new MarginInfo(true, true, true, true));
		   	       
	       VerticalLayout salir = new VerticalLayout(logout);
	       salir.setSpacing(true);
		   salir.setMargin(new MarginInfo  (true, true, true, true));
		 		   
	       Panel panelMenu = new Panel("");
	       panelMenu.addStyleName("mypanel");
	       panelMenu.setSizeFull();
	       panelMenu.setContent(menuPrincipal);
	               
	       
	       VerticalLayout viewLayout = new VerticalLayout(panelMenu);
		   viewLayout.setSizeFull();
		   viewLayout.setSpacing(true);
		   viewLayout.setComponentAlignment(panelMenu, Alignment.TOP_LEFT);
		   viewLayout.setMargin(new MarginInfo  (true, true, true, true));
		   setCompositionRoot(new CssLayout(bienvenido, viewLayout,cuerpo, salir));
    	
    	
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("BIENVENIDO " + username);
        text.addStyleName("bienvenido"); 
        
    }

	    
}