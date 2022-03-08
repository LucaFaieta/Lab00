package it.polito.tdp.Lab00;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
	
    @FXML
    private HBox boxBtn;

    @FXML
    private HBox boxPassword;

    @FXML
    private HBox boxUser;

    @FXML
    private Button clearBtn;

    @FXML
    private Label txtMessaggio;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label txtTentativi;
    
    @FXML
    private TextField txtUser;
    
    private final int ACMAX = 3;
    private int nAcc = 0;

    @FXML
    void handleAccedi(ActionEvent event) {
    	if(nAcc == ACMAX) {
    		boxBtn.setDisable(true);
    		boxUser.setDisable(true);
    		boxPassword.setDisable(true);
    		clearBtn.setVisible(true);
    		clearBtn.setDisable(false);
    		return;
    	}
    	if(txtUser.getText() == "") {
    		txtMessaggio.setText("Inserire un username");
    		return;
    	}
    	
    	txtUser.setDisable(true);
    	if(txtPassword.getText() == "") {
    		txtMessaggio.setText("Inserire una password");
    		nAcc++;
    		txtTentativi.setText(""+(ACMAX-nAcc));
    		if(tentativiEsauriti())
    			return;
    		return;
    	}
    	
    	if(!(txtPassword.getText().length() >= 7 && (txtPassword.getText().contains("!") || txtPassword.getText().contains("?") || txtPassword.getText().contains("@") || txtPassword.getText().contains("#")))) {
    		txtMessaggio.setText("Inserire una password piu' lunga o inserire caratteri speciali");
    		nAcc++;
    		txtTentativi.setText(""+(ACMAX-nAcc));
    		if(tentativiEsauriti())
    			return;
    		return;
    	}
    	boolean flag = false;
    	for(int i = 0; i < 10 && flag == false; i++) {
    		if(txtPassword.getText().contains(""+i))
    			flag = true;
    	}
    	if(flag == false) {
    		txtMessaggio.setText("Inserire dei numeri nella password");
    		nAcc++;
    		txtTentativi.setText(""+(ACMAX-nAcc));
    		if(tentativiEsauriti())
    			return;
			return;
    	}
    	flag = false;
    	for(int i = 0; i < txtPassword.getText().length() && flag == false;i++) {
    		char c = txtPassword.getText().charAt(i);
    		if(Character.isUpperCase(c))
    			flag = true;
    	}
    	if(flag == false) {
    		txtMessaggio.setText("La password non contiene maiuscole");
    		nAcc++;
    		txtTentativi.setText(""+(ACMAX-nAcc));
    		if(tentativiEsauriti())
    			return;
			return;
    	}
    	txtMessaggio.setText("La password e' corretta");
    	clearBtn.setVisible(true);
		clearBtn.setDisable(false);
    	
    }
    @FXML
    void handleClearBrn(ActionEvent event) {
    	nAcc = 0;
    	boxUser.setDisable(false);
    	boxPassword.setDisable(false);
    	boxBtn.setDisable(false);
    	txtUser.clear();
    	txtUser.setDisable(false);
    	txtPassword.clear();
    	txtMessaggio.setText("");
    	txtTentativi.setText("");
    	clearBtn.setVisible(false);
    	clearBtn.setDisable(true);
    	return;

    }
    private boolean tentativiEsauriti() {
    	if(nAcc == ACMAX) {
    		boxBtn.setDisable(true);
    		boxUser.setDisable(true);
    		boxPassword.setDisable(true);
    		clearBtn.setVisible(true);
    		clearBtn.setDisable(false);
    		return true;
    	}
    	return false;
    }

}
