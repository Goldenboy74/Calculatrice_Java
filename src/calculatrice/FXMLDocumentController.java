/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculatrice;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Golden74
 */
public class FXMLDocumentController implements Initializable {
	
	  @FXML
	  private TextField txt_result;
	  
	  String op ="";
	  double nombre1;
	  double nombre2;
	
	public void  Number(ActionEvent ae){
	
		String number = ((Button)ae.getSource()).getText();
		txt_result.setText(txt_result.getText()+ number);
	
	}
	
	public void Operateur(ActionEvent ae) {
	    String operateur = ((Button)ae.getSource()).getText();
	    if (!operateur.equals("=")) {
		if (!op.equals("")) {
		    return;
		}
		op = operateur;
		// Remplacer la virgule par un point pour permettre la conversion en nombre
		String nombreText = txt_result.getText().replace(',', '.');
		nombre1 = Double.parseDouble(nombreText);
		txt_result.setText("");
	    } else {
		if (op.equals("")) {
		    return;
		}
		String nombreText = txt_result.getText().replace(',', '.');
		nombre2 = Double.parseDouble(nombreText);
		Calculateur(nombre1, nombre2, op);
		op = "";
	    }
	}


	
	public void  Calculateur(double n1, double n2, String op){
	
		switch(op){
		
			case "+" -> txt_result.setText(n1 + n2 + "");
			case "-" -> txt_result.setText(n1 - n2 + "");
			case "*" -> txt_result.setText(n1 * n2 + "");
			case "/" -> { 
				if(n2==0){
					txt_result.setText("0");
					break;
				}
				txt_result.setText(n1 / n2 + "");
			  }
			
	
		}
	
	}
	public void textCleaner(ActionEvent ae){
		txt_result.clear();
	}
	 public void clearLastCharacter(ActionEvent event) {
		String currentText = txt_result.getText();
		if (!currentText.isEmpty()) {
			// Supprimer le dernier caractère de la chaîne
			String newText = currentText.substring(0, currentText.length() - 1);
			txt_result.setText(newText);
		}
	}
	 public void addDecimalPoint() {
		// Vérifiez si la virgule n'a pas déjà été ajoutée
		if (!txt_result.getText().contains(",")) {
			txt_result.setText(txt_result.getText() + ",");
		}
	}

	@Override
		    public void initialize(URL url, ResourceBundle rb) {
			    // TODO
		    }	

	    }
