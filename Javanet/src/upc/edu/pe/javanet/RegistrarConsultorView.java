package upc.edu.pe.javanet;

import java.util.ArrayList;
import java.util.HashMap;

import upc.edu.pe.javanet.solicitudService.Solicitud;
import upc.edu.pe.javanet.solicitudService.SolicitudDetalle;
import upc.edu.pe.javanet.consultorService.ConsultorService;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
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

public class RegistrarConsultorView extends CustomComponent implements View,
        Button.ClickListener {

	public static final String NAME = "";
	Label text = new Label();
	
	    ConsultorService service = new ConsultorService();

    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });
    

    public RegistrarConsultorView() {
    
    	Label titulo = new Label();
    	titulo.setValue("Registro de Consultores");
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
		
			
		HorizontalLayout hlCliente = new HorizontalLayout();
		hlCliente.setWidth("100%");
		hlCliente.setHeight("20%"); // Default
		Label lblCliente = new Label("Nombre:");
		lblCliente.setWidth("50%");
		lblCliente.setHeight("10%"); // Default
		final TextField txtNombreCliente = new TextField("");
		txtNombreCliente.setValue("Nombre");
		txtNombreCliente.setWidth("100%");
		txtNombreCliente.setHeight("10%"); // Default
		hlCliente.addComponent(lblCliente);
		hlCliente.addComponent(txtNombreCliente);
		hlCliente.setComponentAlignment(lblCliente, Alignment.MIDDLE_RIGHT);
		hlCliente.setComponentAlignment(txtNombreCliente, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlCliente);
		frmDatosCliente.setComponentAlignment(hlCliente, Alignment.MIDDLE_CENTER);
		
		
		HorizontalLayout hlaCliente = new HorizontalLayout();
		hlaCliente.setWidth("100%");
		hlaCliente.setHeight("20%"); // Default
		Label lblaCliente = new Label("Apellido:");
		lblaCliente.setWidth("50%");
		lblaCliente.setHeight("10%"); // Default
		final TextField txtApellidoCliente = new TextField("");
		txtApellidoCliente.setValue("Apellido");
		txtApellidoCliente.setWidth("100%");
		txtApellidoCliente.setHeight("10%"); // Default
		hlaCliente.addComponent(lblaCliente);
		hlaCliente.addComponent(txtApellidoCliente);
		hlaCliente.setComponentAlignment(lblaCliente, Alignment.MIDDLE_RIGHT);
		hlaCliente.setComponentAlignment(txtApellidoCliente, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlaCliente);
		frmDatosCliente.setComponentAlignment(hlaCliente, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout hlcCliente = new HorizontalLayout();
		hlcCliente.setWidth("100%");
		hlcCliente.setHeight("20%"); // Default
		Label lblcCliente = new Label("Especialidad:");
		lblcCliente.setWidth("50%");
		lblcCliente.setHeight("10%"); // Default
		final TextField txtEspecialCliente = new TextField("");
		txtEspecialCliente.setValue("HHRR");
		txtEspecialCliente.setWidth("100%");
		txtEspecialCliente.setHeight("10%"); // Default
		hlcCliente.addComponent(lblcCliente);
		hlcCliente.addComponent(txtEspecialCliente);
		hlcCliente.setComponentAlignment(lblcCliente, Alignment.MIDDLE_RIGHT);
		hlcCliente.setComponentAlignment(txtEspecialCliente, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlcCliente);
		frmDatosCliente.setComponentAlignment(hlcCliente, Alignment.MIDDLE_CENTER);

		
		
		HorizontalLayout hlProyecto = new HorizontalLayout();
		hlProyecto.setWidth("100%");
		Label lblProyecto = new Label("Categoria Consultor");
		lblProyecto.setWidth("80%");
		lblProyecto.setHeight("10%"); // Default
		
		final ComboBox cmbProyecto = new ComboBox("");
		cmbProyecto.setWidth("100%");
		cmbProyecto.setHeight("10%"); // Default
	/*	cmbProyecto.setNullSelectionAllowed(true); */
		cmbProyecto.addItem("-SELECCIONE-");
		cmbProyecto.setNullSelectionItemId("-SELECCIONE-");
        
		cmbProyecto.addItem("Senior");
		cmbProyecto.addItem("Semi Senior");
		cmbProyecto.addItem("Junior");
		cmbProyecto.setImmediate(true);
		
		HorizontalLayout hlProyectoMsg = new HorizontalLayout();
		hlProyectoMsg.setWidth("100%");
		hlProyectoMsg.setHeight("10%");
		//new Notification("Seleccione un categoria.).show(Page.getCurrent());
		
		
		final Label lblProyectoMsgError = new Label("Seleccione una Categoria!");
		lblProyectoMsgError.setVisible(false);
		lblProyectoMsgError.setWidth("100%");
		lblProyectoMsgError.setHeight("10%");
		hlProyectoMsg.addComponent(new Label(""));
		hlProyectoMsg.addComponent(lblProyectoMsgError);
		hlProyectoMsg.setComponentAlignment(lblProyectoMsgError, Alignment.MIDDLE_LEFT);
		
		hlProyecto.addComponent(lblProyecto);
		hlProyecto.addComponent(cmbProyecto);
		hlProyecto.setComponentAlignment(lblProyecto, Alignment.MIDDLE_RIGHT);
		hlProyecto.setComponentAlignment(cmbProyecto, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlProyecto);
		frmDatosCliente.setComponentAlignment(hlProyecto, Alignment.MIDDLE_CENTER);
		frmDatosCliente.addComponent(hlProyectoMsg);
		frmDatosCliente.setComponentAlignment(hlProyectoMsg, Alignment.MIDDLE_CENTER);
		
		
		FormLayout flDatosSolicitus = new FormLayout();
		
				
		final Label lblMsgError = new Label("El Consultor se creó con éxito");
		lblMsgError.setWidth("100%");
		lblMsgError.setHeight("10%"); // Default
		lblMsgError.setVisible(false);
		
				
		final Table tableDetalle = new Table();
		tableDetalle.addStyleName("components-inside");
		
		tableDetalle.addContainerProperty("Categoria",            String.class,     null);
		tableDetalle.addContainerProperty("Especialidad", String.class,  null);
		tableDetalle.addContainerProperty("Nombre",       String.class, null);
		tableDetalle.addContainerProperty("Apellido",        String.class,    null);
		tableDetalle.addContainerProperty("",        Button.class,    null);
		tableDetalle.setPageLength(tableDetalle.size());
		
		
		Button btnGrabar = new Button("Grabar");
		btnGrabar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	int verifica = 0;
		    	if( txtNombreCliente.getValue() ==  null){
		    		lblProyectoMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblProyectoMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	if( txtApellidoCliente.getValue() ==  null){
		    		lblProyectoMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblProyectoMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	if( txtEspecialCliente.getValue() ==  null){
		    		lblProyectoMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblProyectoMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	if(verifica == 0){
		    		
		    		int verificaGrabar = service.grabarConsultor("101", txtNombreCliente.getValue(), txtApellidoCliente.getValue(), txtEspecialCliente.getValue());
		    		if(verificaGrabar == 0){
		    			lblMsgError.setVisible(true);
		    		}else{
		    			lblMsgError.setValue("ERROR! NO se añadio consultor");
		    			lblMsgError.setVisible(true);
		    		}
             	   
		    	}else{
		    		lblMsgError.setVisible(false);
		    	}
		    	
		    	
		    }
		});

		
		Button btnAgregar = new Button("Agregar");
				
		btnAgregar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		      	int verifica = 0;
		    	if( cmbProyecto.getValue() ==  null){
		    		lblProyectoMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblProyectoMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(verifica == 0){
		    		//lblMsgError.setVisible(true);
		    		   
             	    Button generarSolicitudField = new Button("Eliminar");
             	    generarSolicitudField.setData(tableDetalle.size()+1);
             	    generarSolicitudField.addClickListener(new Button.ClickListener() {
             	    	public void buttonClick(ClickEvent event) {
             	    		Integer iid = (Integer)event.getButton().getData();
             	    		tableDetalle.removeItem(iid);
             	    		
             	    	} 
             	    });
             	    generarSolicitudField.addStyleName("link");
         	    
             	   tableDetalle.addItem(new Object[] {cmbProyecto.getValue().toString(), txtEspecialCliente.getValue(),
             			  txtNombreCliente.getValue(),txtApellidoCliente.getValue(), generarSolicitudField},
          	                  tableDetalle.size()+1);
              	   tableDetalle.setPageLength(tableDetalle.size());
 		    	}else{
 		    		lblMsgError.setVisible(false);
 		    	}   
		    	
		    }  
		});
		
		Button btnCancelar = new Button("Cancelar");
		
		btnCancelar.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	cmbProyecto.select(null);
		    	
		    	lblProyectoMsgError.setVisible(false);
		    	lblMsgError.setVisible(false);
		    }
		});
		
		
		frmSolConBotones.setWidth("600px");
		frmSolConBotones.setHeight("10%");
		frmSolConBotones.addComponent(btnAgregar);
		frmSolConBotones.addComponent(btnCancelar);
		frmMsgError.addComponent(lblMsgError);
		
		 VerticalLayout bienvenido = new VerticalLayout(text);
		 bienvenido.setSpacing(true);
		 bienvenido.setCaption(text.getValue());
	     bienvenido.setMargin(new MarginInfo(true, true, false, true));
	     
	     VerticalLayout salir = new VerticalLayout(logout);
	     salir.setSpacing(true);
		 salir.setMargin(new MarginInfo  (true, true, true, true));
	    	
		VerticalLayout frmSolColabPadre = new VerticalLayout(titulo, frmDatosCliente,frmSolicitudConsultores, frmSolConBotones, frmMsgError);
		
		frmSolColabPadre.setSizeFull();
		frmSolColabPadre.setSpacing(true);
		frmSolColabPadre.setComponentAlignment(titulo, Alignment.TOP_LEFT);
		frmSolColabPadre.setMargin(new MarginInfo  (true, true, true, true));
		
		 VerticalLayout tablaDatos = new VerticalLayout(tableDetalle, btnGrabar);
		 //tablaDatos.setCaption("Hola");
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 tablaDatos.setSpacing(true);
		 //tablaDatos.setSizeFull();
		 tableDetalle.setSizeFull();
		 //tableDetalle.setWidth("50%");
		 tablaDatos.setExpandRatio(tableDetalle, 1);
		 
		
        HorizontalLayout viewLayout = new HorizontalLayout(frmSolColabPadre, tablaDatos );
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(frmSolColabPadre, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        //viewLayout.setExpandRatio(tablaDatos, 2);
        setCompositionRoot(new CssLayout(bienvenido, viewLayout, salir));
    
    }

    @Override
    public void enter(ViewChangeEvent event) {
    	 String username = String.valueOf(getSession().getAttribute("user"));

         // And show the username
         text.setValue("BIENVENIDO " + username);
         text.addStyleName("bienvenido"); 
    }

	@Override
	public void buttonClick(ClickEvent event) {
		
		
	}
	
	
	
	public int grabar(Table tableDetalle) {
		ArrayList arrayList = new ArrayList();
		Solicitud solicitud = new Solicitud();
		solicitud.setId(1);
		solicitud.setCodProyecto(1);
		Item item = tableDetalle.getItem(1);
		Property prop =  item.getItemProperty(1);
		
		Notification.show("datos " + tableDetalle.getItem(1));
		String cadena =  tableDetalle.getItem(1).toString();
		String caden [] = cadena.split("");
		
		for(int i=0; i< tableDetalle.size(); i++){
			SolicitudDetalle solicitudDetalle = new SolicitudDetalle();
			solicitudDetalle.setId(1);
		
			
		}
		return 1;
	}
   
    
}