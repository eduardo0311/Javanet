package upc.edu.pe.javanet;

import java.util.ArrayList;
import java.util.HashMap;

import upc.edu.pe.javanet.solicitudService.Solicitud;
import upc.edu.pe.javanet.solicitudService.SolicitudDetalle;
import upc.edu.pe.javanet.solicitudService.SolicitudService;

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

public class RegistrarProyectoView extends CustomComponent implements View,
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
    
    
    public RegistrarProyectoView() {
    
    	Label titulo = new Label();
    	titulo.setValue("Solicitud de consultores pruebaaaa");
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
		Label lblCliente = new Label("Cliente");
		lblCliente.setWidth("50%");
		lblCliente.setHeight("10%"); // Default
		TextField txtNombreCliente = new TextField("");
		txtNombreCliente.setValue("Banco de Credito del Perú");
		txtNombreCliente.setReadOnly(true); 
		txtNombreCliente.setWidth("100%");
		txtNombreCliente.setHeight("10%"); // Default
		hlCliente.addComponent(lblCliente);
		hlCliente.addComponent(txtNombreCliente);
		hlCliente.setComponentAlignment(lblCliente, Alignment.MIDDLE_RIGHT);
		hlCliente.setComponentAlignment(txtNombreCliente, Alignment.MIDDLE_LEFT);
		frmDatosCliente.addComponent(hlCliente);
		frmDatosCliente.setComponentAlignment(hlCliente, Alignment.MIDDLE_CENTER);
				
		HorizontalLayout hlProyecto = new HorizontalLayout();
		hlProyecto.setWidth("100%");
		Label lblProyecto = new Label("Nombre Proyecto");
		lblProyecto.setWidth("80%");
		lblProyecto.setHeight("10%"); // Default
		final ComboBox cmbProyecto = new ComboBox("");
		cmbProyecto.setWidth("100%");
		cmbProyecto.setHeight("10%"); // Default
		cmbProyecto.setNullSelectionAllowed(true);
		cmbProyecto.addItem("-SELECCIONE-");
		cmbProyecto.setNullSelectionItemId("-SELECCIONE-");
        
		cmbProyecto.addItem("Proyecto Home Banking");
		cmbProyecto.addItem("Proyecto Compra Virtual");
		cmbProyecto.addItem("Proyecto Televentas");
		//cmbProyecto.setWidth("400px");
		cmbProyecto.setImmediate(true);
		
		HorizontalLayout hlProyectoMsg = new HorizontalLayout();
		hlProyectoMsg.setWidth("100%");
		hlProyectoMsg.setHeight("10%");
		//new Notification("Seleccione un proyecto!",,Type.).show(Page.getCurrent());
		
		
		final Label lblProyectoMsgError = new Label("Seleccione un proyecto!");
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
		
				
		// combobox para cantidad de colaboradores
		final ComboBox cmbCantColab = new ComboBox("Cantidad de Colaboradores");
		cmbCantColab.setNullSelectionAllowed(true);
		cmbCantColab.setWidth("100%");
		cmbCantColab.setHeight("10%"); // Default
		cmbCantColab.addItem("-SELECCIONE-");
		cmbCantColab.setNullSelectionItemId("-SELECCIONE-");
		cmbCantColab.setWidth("100%");
		cmbCantColab.addItem("1");
		cmbCantColab.addItem("2");
		cmbCantColab.addItem("3");
		cmbCantColab.addItem("4");
		cmbCantColab.addItem("5");
		cmbCantColab.addItem("6");
		
		final Label lblCantColabMsgError = new Label("Seleccione cantidad de colaboradores!");
		lblCantColabMsgError.setVisible(false);
		lblCantColabMsgError.setWidth("100%");
		lblCantColabMsgError.setHeight("10%"); // Default
		
		final ComboBox cmbPerfil = new ComboBox("Perfil de Colaborador");
		cmbPerfil.setNullSelectionAllowed(true);
		cmbPerfil.setWidth("100%");
		cmbPerfil.setHeight("10%"); // Default
		cmbPerfil.addItem("-SELECCIONE-");
		cmbPerfil.setNullSelectionItemId("-SELECCIONE-");
		cmbPerfil.addItem("Junior");
		cmbPerfil.addItem("Semi Senior");
		cmbPerfil.addItem("Senior");
		
		final Label lblPerfilMsgError = new Label("Seleccione un perfil!");
		lblPerfilMsgError.setVisible(false);
		lblPerfilMsgError.setWidth("100%");
		lblPerfilMsgError.setHeight("10%"); // Default
		
		final ComboBox cmbTecnologia = new ComboBox("Tecnología");
		cmbTecnologia.setNullSelectionAllowed(true);
		cmbTecnologia.setWidth("100%");
		cmbTecnologia.setHeight("10%"); // Default
		cmbTecnologia.addItem("-SELECCIONE-");
		cmbTecnologia.setNullSelectionItemId("-SELECCIONE-");
		cmbTecnologia.addItem("JAVA");
		cmbTecnologia.addItem("NET");
		cmbTecnologia.addItem("PHP");
		
		final Label lblTecnologiaMsgError = new Label("Seleccione una tecnología!");
		lblTecnologiaMsgError.setVisible(false);
		lblTecnologiaMsgError.setWidth("100%");
		lblTecnologiaMsgError.setHeight("10%"); // Default
		
		final ComboBox cmbExperRubro = new ComboBox("Experiencia en rubro");
		cmbExperRubro.setNullSelectionAllowed(true);
		cmbExperRubro.setWidth("100%");
		cmbExperRubro.setHeight("10%"); // Default
		cmbExperRubro.addItem("-SELECCIONE-");
		cmbExperRubro.setNullSelectionItemId("-SELECCIONE-");
		cmbExperRubro.addItem("Financiero");
		cmbExperRubro.addItem("Gobierno");
		cmbExperRubro.addItem("Mineria");
		
		final Label lblExperienciaRubroMsgError = new Label("Seleccione rubro de la experiencia!");
		lblExperienciaRubroMsgError.setVisible(false);
		lblExperienciaRubroMsgError.setWidth("100%");
		lblExperienciaRubroMsgError.setHeight("10%"); // Default
		
		final TextArea txtComentario = new TextArea("Comentario");
		txtComentario.setWidth("100%");
		txtComentario.setHeight("10%"); // Default
	
		flDatosSolicitus.addComponent(cmbCantColab);
		flDatosSolicitus.setComponentAlignment(cmbCantColab, Alignment.MIDDLE_LEFT);
		flDatosSolicitus.addComponent(lblCantColabMsgError);
		flDatosSolicitus.setComponentAlignment(lblCantColabMsgError, Alignment.MIDDLE_LEFT);
    
		flDatosSolicitus.addComponent(cmbPerfil);
		flDatosSolicitus.setComponentAlignment(cmbPerfil, Alignment.MIDDLE_LEFT);
		flDatosSolicitus.addComponent(lblPerfilMsgError);
		flDatosSolicitus.setComponentAlignment(lblPerfilMsgError, Alignment.MIDDLE_LEFT);
		
		flDatosSolicitus.addComponent(cmbTecnologia);
		flDatosSolicitus.setComponentAlignment(cmbTecnologia, Alignment.MIDDLE_LEFT);
		flDatosSolicitus.addComponent(lblTecnologiaMsgError);
		flDatosSolicitus.setComponentAlignment(lblTecnologiaMsgError, Alignment.MIDDLE_LEFT);
		
		flDatosSolicitus.addComponent(cmbExperRubro);
		flDatosSolicitus.setComponentAlignment(cmbExperRubro, Alignment.MIDDLE_LEFT);
		flDatosSolicitus.addComponent(lblExperienciaRubroMsgError);
		flDatosSolicitus.setComponentAlignment(lblExperienciaRubroMsgError, Alignment.MIDDLE_LEFT);
		
		flDatosSolicitus.addComponent(txtComentario);
		flDatosSolicitus.setComponentAlignment(txtComentario, Alignment.MIDDLE_LEFT);
		
		frmSolicitudConsultores.addComponent(flDatosSolicitus);
		frmSolicitudConsultores.setComponentAlignment(flDatosSolicitus, Alignment.MIDDLE_CENTER);
		
		final Label lblMsgError = new Label("La Solicitud se creó con éxito");
		lblMsgError.setWidth("100%");
		lblMsgError.setHeight("10%"); // Default
		lblMsgError.setVisible(false);
		
		 /*Grid solicitudList = new Grid();
		 solicitudList.setContainerDataSource(new BeanItemContainer<SolicitudDetalle>(
	                SolicitudDetalle.class));
		 solicitudList.setColumnOrder("cantidad", "perfil", "tecnologia", "experRubro");
		 solicitudList.removeColumn("id");
		 solicitudList.removeColumn("comentario");*/
		 //solicitudList.removeColumn("phone");
		 //solicitudList.setSelectionMode(Grid.SelectionMode.SINGLE);
		 /*solicitudList.addSelectionListener(new SelectionListener() {

	            @Override
	            public void select(SelectionEvent event) {
	                contactForm.edit((Contact) contactList.getSelectedRow());
	            }
	        });*/
		// refreshSolicitudes(solicitudList);
		
		final Table tableDetalle = new Table();
		tableDetalle.addStyleName("components-inside");
		
		tableDetalle.addContainerProperty("Cantidad",            String.class,     null);
		tableDetalle.addContainerProperty("Perfil", String.class,  null);
		tableDetalle.addContainerProperty("Tecnología",       String.class, null);
		tableDetalle.addContainerProperty("Experiencia en Rubro",        String.class,    null);
		tableDetalle.addContainerProperty("",        Button.class,    null);
		tableDetalle.setPageLength(tableDetalle.size());
		
		
		Button btnGrabar = new Button("Grabar");
		btnGrabar.addClickListener(new Button.ClickListener() {
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
		    	
		    	if(cmbCantColab.getValue() ==  null){
		    		lblCantColabMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblCantColabMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbPerfil.getValue() ==  null){
		    		lblPerfilMsgError.setVisible(true);
		    		verifica++;
		    		lblMsgError.setVisible(false);
		    	}else{
		    		lblPerfilMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbTecnologia.getValue() ==  null){
		    		lblTecnologiaMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblTecnologiaMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbExperRubro.getValue() ==  null){
		    		lblExperienciaRubroMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblExperienciaRubroMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(verifica == 0){
		    		
		    		//tableDetalle.size();     
		    		//Notification.show("Tala tiene " +
		    		//		tableDetalle.size() + " clicked.");
		    		//int verificaGrabar = service.grabar(tableDetalle);
		    		int verificaGrabar = grabar(tableDetalle);
		    		if(verificaGrabar == 0){
		    			lblMsgError.setVisible(true);
		    		}else{
		    			lblMsgError.setValue("ERROR! La solicitud no se generó");
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
		    	
		    	if(cmbCantColab.getValue() ==  null){
		    		lblCantColabMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblCantColabMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbPerfil.getValue() ==  null){
		    		lblPerfilMsgError.setVisible(true);
		    		verifica++;
		    		lblMsgError.setVisible(false);
		    	}else{
		    		lblPerfilMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbTecnologia.getValue() ==  null){
		    		lblTecnologiaMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblTecnologiaMsgError.setVisible(false);
		    		//verifica--;
		    	}
		    	
		    	if(cmbExperRubro.getValue() ==  null){
		    		lblExperienciaRubroMsgError.setVisible(true);
		    		verifica++;
			    	lblMsgError.setVisible(false);
		    	}else{
		    		lblExperienciaRubroMsgError.setVisible(false);
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
         	    
             	   tableDetalle.addItem(new Object[] {cmbCantColab.getValue().toString(), cmbPerfil.getValue().toString(),
             			  cmbTecnologia.getValue().toString(), cmbExperRubro.getValue().toString(), generarSolicitudField},
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
		    	cmbCantColab.select(null);
		    	cmbPerfil.select(null);
		    	cmbTecnologia.select(null);
		    	cmbExperRubro.select(null);
		    	txtComentario.setValue("");
		    	lblProyectoMsgError.setVisible(false);
		    	lblCantColabMsgError.setVisible(false);
		    	lblPerfilMsgError.setVisible(false);
		    	lblTecnologiaMsgError.setVisible(false);
		    	lblExperienciaRubroMsgError.setVisible(false);
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
		 //tablaDatos.setComponentAlignment(titulo, Alignment.BOTTOM_CENTER);
		 //tablaDatos.setMargin(new MarginInfo  (true, true, true, true));
		 
		
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
	
	
	
	//void refreshSolicitudes(Grid solicitudList) {
	//	solicitudList.setContainerDataSource(new BeanItemContainer<SolicitudDetalle>(
	//                SolicitudDetalle.class, service.findAll()));
	     //contactForm.setVisible(false);
    //}
	//final HashMap<Integer,TextField> valueFields =
	//	    new HashMap<Integer,TextField>();
	//BeanFieldGroup<Item> formFieldBindings;
	public int grabar(Table tableDetalle) {
		ArrayList arrayList = new ArrayList();
		Solicitud solicitud = new Solicitud();
		solicitud.setId(1);
		solicitud.setCodProyecto(1);
		Item item = tableDetalle.getItem(1);
		Property prop =  item.getItemProperty(1);
		
		Notification.show("datos " + tableDetalle.getItem(1));
		//Notification.show("datos " + prop.getValue());
		//formFieldBindings = BeanFieldGroup
              //  .bindFieldsBuffered(tableDetalle.getItem(1), this);
		//valueFields = tableDetalle.getItem(1);
		String cadena =  tableDetalle.getItem(1).toString();
		String caden [] = cadena.split("");
		
		for(int i=0; i< tableDetalle.size(); i++){
			SolicitudDetalle solicitudDetalle = new SolicitudDetalle();
			solicitudDetalle.setId(1);
			//solicitudDetalle.setCantidad(tableDetalle.getItem(new Integer(i));
			
		}
		return 1;
	}
   
    
}