package com.quickstar.wicket.example;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	private int contadorModel = 0;
	private Label contadorLabel = null;
	@SuppressWarnings("rawtypes")
	private AjaxLink sumarContador = null;
	private TextField nombre = null;
	private TextField apellidoPaterno = null;
	private TextField apellidoMaterno = null;
	private TextField edad = null;
	private TextField numeroDeTelefono = null;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		// TODO Add your page's components here
		contadorModel = 0;
    }

	@SuppressWarnings({ "rawtypes" })
	@Override
	protected void onInitialize() {
		// TODO Auto-generated method stub
		super.onInitialize();

		//Crea un nuevo componente, asignandole a su contructor el wicket:id y el modelo
		contadorLabel = new Label("contador", contadorModel);
		contadorLabel.setOutputMarkupId(true); //Habilitamos que se muestre en el HTML final su ID para que sea visto por las peticiones AJAX
		
		sumarContador = new AjaxLink("sumarContador"){

			/**
			 * 
			 */
			private static final long serialVersionUID = -1504516625331546618L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				contadorModel = contadorModel + 1; //Incrementamos la variable
				contadorLabel.setDefaultModelObject(contadorModel); //Adjuntamos nuevamente la variable al componente Wicket
				target.add(contadorLabel);				
			}
			
			
		};
		
		add(contadorLabel);
		add(sumarContador);
		
	}
	
	
}
