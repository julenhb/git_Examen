package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.ConnectionDB;
import application.CRUD_Pisos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PrincipalController {
	@FXML
	private Label id_zona;
	
	@FXML
	private Label tipoOp;
	
	@FXML
	private Label metros;
	
	@FXML
	private Label nombreProp;
	
	@FXML
	private Label tlfCon;
	
	@FXML
	private Label res;
	
	@FXML
	private Label precio;
	
	@FXML
	private Label piso;
	
	@FXML
	private TextField zonaCampo;	
	
	@FXML
	private TextField metrosCampo;	
	
	@FXML
	private TextField nombreCampo;	
	
	@FXML
	private TextField tlfCampo;	
	
	@FXML
	private TextField precioCampo;	
	
	@FXML
	private TextField pisoCampo;
	
	/*NO ME DEJA METER VALORES EN EL COMBOBOX DE NINGUNA FORMA, LO HARÉ POR TEXTFIELD
	
	@FXML
	private ComboBox<String> operacionBox;
	
	ArrayList<String> operaciones = new ArrayList<>();
	*/
	
	@FXML
	private TextField operacionBox;
	
	@FXML
	private RadioButton resTrue;
	
	@FXML
	private RadioButton resFalse;
	
	@FXML private TableView tabla;
	
	
	@FXML 
	private Button altaBoton;
	
	@FXML 
	private Button verBoton;
	
	@FXML 
	private Button reservarBoton;
	
	@FXML 
	private Button borrarBoton;
	
	@FXML 
	private Button limpiar;
	
	@FXML
	private Button borrar2;
	
	@FXML 
	private TextField id_Borrar;
	@FXML
	private AnchorPane ventanaBorrar;
	
	private Connection con;
    public PrincipalController() throws SQLException{
        this.con = ConnectionDB.getConexion();
    }
	
    
    public void initialize(URL url, ResourceBundle rb) {
        /*
        CRUD_Pisos.fillArrayCombo(operaciones);
         
        for (int i = 0; i < operaciones.size(); i++) {
            operacionBox.getItems().add(operaciones.get(i));
        }ASÍ SERÍA CON COMBOBOX*/

        

    }
    
    @FXML
    private void abrirBorrado() {
    	ventanaBorrar.setVisible(true);
    }
    
    private void eliminarPiso() {
    	int id = Integer.parseInt(id_Borrar.getText());
    	CRUD_Pisos.deletePiso(con, id);
    	ventanaBorrar.setVisible(false);
    }
    
	
	@FXML
	private void altaPiso() {
		boolean reservado = CRUD_Pisos.comprobarReservado(resTrue);
		int id_piso = Integer.parseInt(pisoCampo.getText());
		int id_zona = Integer.parseInt(zonaCampo.getText());
		String tipo_op = operacionBox.getText();
		int metros = Integer.parseInt(metrosCampo.getText());
		String nombreProp = nombreCampo.getText();
		String tlf = tlfCampo.getText();
		int precio = Integer.parseInt(precioCampo.getText());
		
		Piso p1 = new Piso(id_piso, id_zona, tipo_op, metros, nombreProp, tlf, precio, reservado);
		
		CRUD_Pisos.addPiso(con, p1);
	}
	
	
	
	
	
	
	@FXML
	private void limpiarCampos() {
		zonaCampo.setText("");
		metrosCampo.setText("");
		nombreCampo.setText("");
		tlfCampo.setText("");
		precioCampo.setText("");
		pisoCampo.setText("");
		resTrue.setSelected(false);
		resFalse.setSelected(false);
	}
	
	
}
