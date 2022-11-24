module com.mycompany.alquilerpiso_exjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.alquilerpiso_exjdbc to javafx.fxml;
    exports com.mycompany.alquilerpiso_exjdbc;
}
