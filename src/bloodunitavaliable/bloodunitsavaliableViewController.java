package bloodunitavaliable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DonorMaster.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class bloodunitsavaliableViewController {

    @FXML
    private ResourceBundle resources;

    Connection con;
    PreparedStatement pst;
    ResultSet m;

    @FXML
    private URL location;

    @FXML
    private TextField txtOn;

    @FXML
    private TextField txtOp;

    @FXML
    private TextField txtabn;

    @FXML
    private TextField txtabp;

    @FXML
    private TextField txtan;

    @FXML
    private TextField txtap;

    @FXML
    private TextField txtbn;

    @FXML
    private TextField txtbp;

    @FXML
    void initialize() {
    	con=DataBaseConnection.doConnect();
    	try {
			pst=con.prepareStatement("select * from bloodrecord");
			m=pst.executeQuery();
			while(m.next()) {
				txtOp.setText(m.getString("opos"));
				txtOn.setText(m.getString("oneg"));
				txtap.setText(m.getString("apos"));
				txtan.setText(m.getString("aneg"));
				txtbp.setText(m.getString("bpos"));
				txtbn.setText(m.getString("bneg"));
				txtabp.setText(m.getString("abpos"));
				txtabn.setText(m.getString("abneg"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
	

    }

}
