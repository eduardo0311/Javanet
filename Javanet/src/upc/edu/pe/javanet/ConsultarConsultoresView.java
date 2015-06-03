package upc.edu.pe.javanet;

import java.util.ArrayList;
import java.util.HashMap;

import upc.edu.pe.javanet.solicitudService.Solicitud;
import upc.edu.pe.javanet.solicitudService.SolicitudDetalle;
import upc.edu.pe.javanet.solicitudService.SolicitudService;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class ConsultarConsultoresView extends CustomComponent implements View,
        Button.ClickListener {

	public static final String NAME = "";

    Label text = new Label();
    SolicitudService service = SolicitudService.createDemoService();

    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });
    
    
    public ConsultarConsultoresView() {
    
    	Label titulo = new Label();
    	titulo.setValue("Consultar Consultores");
    	titulo.addStyleName("titulo"); 
         
    	VerticalLayout frmDatosCliente = new VerticalLayout();
		frmDatosCliente.setSizeUndefined();
		frmDatosCliente.setWidth("100%"); // Default
		frmDatosCliente.setHeight("50%"); // Default
		
		frmDatosCliente.setMargin(true);
		
		VerticalLayout frmSolicitudConsultores = new VerticalLayout();
		frmSolicitudConsultores.setSizeUndefined();
		frmSolicitudConsultores.setWidth("100%"); // Default
		frmSolicitudConsultores.setHeight("50%"); // Default
		frmSolicitudConsultores.setMargin(true);
		
		HorizontalLayout frmSolConBotones = new HorizontalLayout();
		frmSolConBotones.setSizeUndefined();
		frmSolConBotones.setWidth("100%"); // Default
		frmSolConBotones.setHeight("50%"); // Default
		frmSolConBotones.setMargin(true);
		
		HorizontalLayout frmMsgError = new HorizontalLayout();
		frmMsgError.setSizeUndefined();
		frmMsgError.setWidth("100%"); // Default
		frmMsgError.setHeight("50%"); // Default
		frmMsgError.setMargin(true);
		
		
		final Table tableDetalle = new Table();
		tableDetalle.addStyleName("components-inside");
		
		tableDetalle.addContainerProperty("Consultor",            String.class,     null);
		tableDetalle.addContainerProperty("Categoria", String.class,  null);
		tableDetalle.addContainerProperty("Proyecto",       String.class, null);
		tableDetalle.setPageLength(tableDetalle.size());
		
		
		Button btnConsultar = new Button("Consultar");
		btnConsultar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	
		    }
		});   
    }

    @Override
    public void enter(ViewChangeEvent event) {
    	 String username = String.valueOf(getSession().getAttribute("user"));

         // And show the username
         text.setValue("BIENVENIDO " + username);
         text.addStyleName("bienvenido"); 
    }

	}
   
    
}