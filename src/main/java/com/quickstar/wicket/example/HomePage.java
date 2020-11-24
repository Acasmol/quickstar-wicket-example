package com.quickstar.wicket.example;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.quickstar.wicket.entity.dao.impl.HibernatePersonaDAO;
import com.quickstar.wicket.example.enity.dao.PersonaDAO;
import com.quickstar.wicket.example.entity.Persona;
import com.quickstar.wicket.example.entity.loadable.LoadablePersonaEntity;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * Para que una clase represente una página web necesita extender de la clase WebPage
 * o de alguna otra clase que extienda de la clase WebPage
 * 
 * @author Acasmol
 *
 */
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	private int contadorModel = 0;
	private Label contadorLabel = null;
	@SuppressWarnings("rawtypes")
	private AjaxLink sumarContador = null;
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	@SuppressWarnings("rawtypes")
	private TextField nombre = null;
	@SuppressWarnings("rawtypes")
	private TextField apellidoPaterno = null;
	@SuppressWarnings("rawtypes")
	private TextField apellidoMaterno = null;
	@SuppressWarnings("rawtypes")
	private TextField edad = null;
	@SuppressWarnings("rawtypes")
	private TextField numeroDeTelefono = null;
	private AjaxButton submitFormButton = null;
	@SuppressWarnings("rawtypes")
	private Form form = null;
	private IModel<Persona> loadablePersonaEntity;	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	private FeedbackPanel feedbackPanel = null;

	
	/**
	 * 
	 * @param parameters Este parámetro es un objeto que contiene los parámetros con los que fue invocada
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HomePage(final PageParameters parameters) {
		super(parameters);

		// TODO Add your page's components here
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------

		//Crea un nuevo componente, asignandole a su contructor el wicket:id y el modelo
		contadorLabel = new Label("contador", contadorModel);
		contadorLabel.setOutputMarkupId(true); //Habilitamos que se muestre en el HTML final su ID para que sea visto por las peticiones AJAX
		
		//Crea un componente AjaxLink, el cual incrementará el contador al hacer click en él
		sumarContador = new AjaxLink("sumarContador"){

			/**
			 * 
			 */
			private static final long serialVersionUID = -1504516625331546618L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				contadorModel = contadorModel + 1; //Incrementamos la variable
				contadorLabel.setDefaultModelObject(contadorModel); //Adjuntamos nuevamente el modelo al componente Wicket
				target.add(contadorLabel);				
			}
			
			
		};
		
		//Añadimos al contenedor, en este caso la página
		add(contadorLabel);
		add(sumarContador);
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------		
	
		//Instanciamos un LoadableModel
		loadablePersonaEntity = new LoadablePersonaEntity(0L);
		
		nombre = new TextField("nombre");
		apellidoPaterno = new TextField("apellidoPaterno");
		apellidoMaterno = new TextField("apellidoMaterno");
		edad = new TextField("edad");
		numeroDeTelefono = new TextField("numeroDeTelefono"); 
		submitFormButton = new AjaxButton("submitFormButton", form)
				{

					/**
					 * 
					 */
					private static final long serialVersionUID = -8104402537101025363L;

					@Override
					protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
						// TODO Auto-generated method stub
						super.onSubmit(target, form);
						System.err.println("Método 'onSubmit()' del componente submitFormButton");
						System.err.println("Objeto Persona:" + loadablePersonaEntity.getObject().toString());
						PersonaDAO personaDAO = new HibernatePersonaDAO();
						try
						{
							personaDAO.insert(loadablePersonaEntity.getObject());
						}
						catch(Exception ex)
						{
							System.err.println("Error en 'onSubmit()' : " + ex.getMessage());
						}
						finally 
						{
							//Queremos que se actualize el FeedbackPanel, por lo que lo añadimos al AjaxRequest
							target.add(feedbackPanel);						
						}
					}

					@Override
					protected void onError(AjaxRequestTarget target, Form<?> form) {
						// TODO Auto-generated method stub
						super.onError(target, form);
						//Queremos que en caso de que ocurra un error, se actualize el FeedbackPanel, por lo que lo añadimos al AjaxRequest
						target.add(feedbackPanel);
					}
					
					
					
				};
		
			
		//Pasamos al constructor el wicket id y un objecto que extienda de LoadableDetachableModel
		//De esta forma, al ser un LoadableDetachableModel, las propiedades del POJO envuelto dentro
		//de este modelo, serán enlazados a los componentes 'hijos' de este form cuyo valor
		//del wicket id sea el mismo al nombre de las propiedades del POJO
		form = new Form("form",loadablePersonaEntity) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5369608285028079465L;

			@Override
			protected void onInitialize() {
				// TODO Auto-generated method stub
				super.onInitialize();
				//El LoadableModel instanciado anteriormente lo utilizamos para crear un CompundPropertyModel, de esta forma, hacemos que los valores
				//de los componentes Wicket del formulario "se peguen" o "se transfieran" automaticamente al POJO que esta envuelto del Loadable Model
				setModel(new CompoundPropertyModel(loadablePersonaEntity));
			}

			@Override
			protected void onSubmit() {
				// TODO Auto-generated method stub
				super.onSubmit();
				System.err.println("Método 'onSubmit()' del componente Form");
				System.err.println("Objeto Persona:" + loadablePersonaEntity.getObject().toString());				
			}
			
		};
		
		form.add(nombre);
		form.add(apellidoPaterno);
		form.add(apellidoMaterno);
		form.add(edad);
		form.add(numeroDeTelefono);
		form.add(submitFormButton);
		add(form);
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------	
		
		
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------
		feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupId(true);
		form.add(feedbackPanel);
		//---------------------------------------------------------------------------------------------------------------------------------------------------		
		
    }


	@Override
	protected void onInitialize() {
		// TODO Auto-generated method stub
		super.onInitialize();

	}
	
	
}
