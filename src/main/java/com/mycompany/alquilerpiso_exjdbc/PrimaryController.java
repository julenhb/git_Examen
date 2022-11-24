package com.mycompany.alquilerpiso_exjdbc;

import static com.mycompany.alquilerpiso_exjdbc.CRUD_Pisos.fillArrayCombo;
import static com.mycompany.alquilerpiso_exjdbc.CRUD_Pisos.mostrarDisponibles;
import static com.mycompany.alquilerpiso_exjdbc.ConnectionDB.getConexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class PrimaryController implements Initializable{

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
	
	@FXML
	private ComboBox<String> opCbox;
	
	ArrayList<String> operaciones = new ArrayList<>();
	
	@FXML
	private RadioButton resTrue;
	
	@FXML
	private RadioButton resFalse;
        
        @FXML
        private ToggleGroup resGroup;
	
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
        
        @FXML 
        private TableView tabla;
        
        ObservableList<Piso> listaPisos;
        
        @FXML
        private TableColumn<Piso, String> Id_piso;
        
        @FXML
        private TableColumn<Piso, String> Metros;
        
        @FXML
        private TableColumn<Piso, String> Nombre_propietario;
        
        @FXML
        private TableColumn<Piso, String> Telefono_contacto;
        
        @FXML
        private TableColumn<Piso, String> Precio;
        
        @FXML
        private TableColumn<Piso, String> Reservado;
        
        
        @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
	
	private Connection con;
    public PrimaryController() throws SQLException{
        this.con = ConnectionDB.getConexion();
    }
	
    
    public void initialize(URL url, ResourceBundle rb) {
       
        fillArrayCombo(operaciones);
        System.out.println(operaciones.toString());
         
        for (int i = 0; i < operaciones.size(); i++) {
            opCbox.getItems().add(operaciones.get(i));
        }
        
        Id_piso.setCellValueFactory(new PropertyValueFactory<>("Id_piso"));
        Metros.setCellValueFactory(new PropertyValueFactory<>("Metros"));
        Nombre_propietario.setCellValueFactory(new PropertyValueFactory<>("Nombre_propietario"));
        Telefono_contacto.setCellValueFactory(new PropertyValueFactory<>("Telefono_contacto"));
        Precio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        Reservado.setCellValueFactory(new PropertyValueFactory<>("Reservado"));
            try {
                tabla.setItems(fillListaTabla());
            } catch (SQLException ex) {
                Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        
    }
    
    public static ObservableList<Piso> fillListaTabla() throws SQLException{
        Connection con;
        con = getConexion();
        ObservableList<Piso> list;
        list = FXCollections.observableArrayList();
        PreparedStatement ps;
        ResultSet rs;
        
        ps = con.prepareStatement("SELECT * FROM pisos");
        rs = ps.executeQuery();
        
        while(rs.next()){
            list.add(new Piso(rs.getInt("Id_Piso"), rs.getInt("Id_Zona"), rs.getString("Tipo_Operacion"), rs.getInt("Metros"), rs.getString("Nombre_propietario"), rs.getString("Telefono_contacto"), rs.getInt("Precio"), rs.getBoolean("Reservado")));
        }
        
        return list;
    }
    
    @FXML
    private void abrirBorrado() {
    	ventanaBorrar.setVisible(true);
    }
    
    @FXML
    private void eliminarPiso() throws SQLException {
    	int id = Integer.parseInt(id_Borrar.getText());
    	CRUD_Pisos.deletePiso(con, id);
    	ventanaBorrar.setVisible(false);
        tabla.setItems(fillListaTabla());
    }
    
	
	@FXML
	private void altaPiso() throws SQLException {
		boolean reservado = CRUD_Pisos.comprobarReservado(resTrue);
		int id_piso = Integer.parseInt(pisoCampo.getText());
		int id_zona = Integer.parseInt(zonaCampo.getText());
		String tipo_op = opCbox.getValue();
		int metros = Integer.parseInt(metrosCampo.getText());
		String nombreProp = nombreCampo.getText();
		String tlf = tlfCampo.getText();
		int precio = Integer.parseInt(precioCampo.getText());
		
		Piso p1 = new Piso(id_piso, id_zona, tipo_op, metros, nombreProp, tlf, precio, reservado);
		
		CRUD_Pisos.addPiso(con, p1);
                
                tabla.setItems(fillListaTabla());
	}
	
	@FXML 
        private void verDisponibles() throws SQLException{
            tabla.setItems(mostrarDisponibles());
        }
	
	
	
	
	@FXML
	private void limpiarCampos() {
		zonaCampo.setText("");
		metrosCampo.setText("");
		nombreCampo.setText("");
		tlfCampo.setText("");
		precioCampo.setText("");
		pisoCampo.setText("");
                opCbox.setValue("Seleccionar");
		resTrue.setSelected(false);
		resFalse.setSelected(false);
	}
    
}

