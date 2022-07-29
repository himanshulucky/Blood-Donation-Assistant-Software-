package Issued;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

public class IssuBloodViewController {

	 Connection con;
	 PreparedStatement pst;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private ComboBox<String> chkbloodg;
    @FXML
    private TextField txtbloodgroup;

    @FXML
    private TextField txtdateofissue;

    @FXML
    private TextField txthospital;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtreason;

    @FXML
    private TextField txtunit;
    
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }

    @FXML
    void btnupdatedatabase(ActionEvent event) {
    	try {
    		
			pst=con.prepareStatement("insert into issued values(?,?,?,?,current_date(),?,?)");
			pst.setString(1,txtname.getText());
			System.out.println(txtname.getText());
			pst.setString(2,txtmobile.getText());
			System.out.println(txtmobile.getText());
			pst.setString(3,txthospital.getText());
			System.out.println(txthospital.getText());
			pst.setString(4,chkbloodg.getEditor().getText());
			System.out.println(chkbloodg.getEditor().getText());
			pst.setString(5,txtreason.getText());
			pst.setString(6,txtunit.getText());
//			pst.setString(5,txtdateofissue.getText());
			pst.executeUpdate();
//			showMsg("Registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String bg=chkbloodg.getEditor().getText();
    	int i=Integer.parseInt(txtunit.getText()); 
//    	String v=txtunit.getText();
    	try {
//			pst=con.prepareStatement("update bloodrecord set "+s+"="+s+"+?");
    		pst=con.prepareStatement("update bloodrecord set "+bg+"="+bg+"-?");
			pst.setInt(1,i);
			pst.executeUpdate();
			
			showMsg("Registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @FXML
    void initialize() {
      con= DataBaseConnection.doConnect();
      ArrayList<String> items=new ArrayList<String>(Arrays.asList("apos","aneg","bpos","bneg","abpos","abneg","opos","oneg"));
      chkbloodg.getItems().setAll(items);
    }

}
