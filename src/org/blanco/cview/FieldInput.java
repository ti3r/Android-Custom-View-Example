package org.blanco.cview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FieldInput extends LinearLayout {
	TextView text = null; //Estos miembros nos serviran de referencia para manejar los
	EditText edit = null; //controles internos de nuestra vista
	
	{	//Declaramos un inicializador de instancia para inflar nuestro archivo xml base
		LayoutInflater.from(this.getContext()).inflate(R.layout.field_input, this,true);
		//es importante agregar el "this" y "true" al final del metodo inflate para
		//que nuestra vista quede adjuntada a la vista principal de la aplicacion.
		
		//Luego asignamos nuestros controles internos a los miembros de la clase.
		text = (TextView) findViewById(R.id.field_input_text_field);
		edit = (EditText) findViewById(R.id.field_input_input_field);
	}
	
	//Declaramos los constructores necesarios para nuestra nueva vista
	public FieldInput(Context context) {
		super(context);
	}
	public FieldInput(Context context, AttributeSet attributes){
		super(context,attributes);
		loadAttributes(attributes);		
	}
	//Declaramos un metodo el cual retraera los atributos pasados a nuestra vista
	//y los asignara a nuestros controles internos. En este ejemplo nuestra nueva vista
	//podra recibir dos attributos "texto" y "entrada_defecto" los cuales asignara a los
	//textos de nuestros controles internos.
	private void loadAttributes(AttributeSet atts){
		 String txtValue = atts.getAttributeValue(null, "texto");
		 text.setText((txtValue != null)?txtValue:"texto");
		 String inValue = atts.getAttributeValue(null, "entrada_defecto");
		 edit.setText((inValue != null)?inValue:"entrada");
	}
	//Al final declaramos un metodo por el cual podemos retraer el valor que el usuario 
	//haya introducido
	public String getInput(){
		if (edit != null)
			return edit.getText().toString();
		else
			return null;
	}
}
