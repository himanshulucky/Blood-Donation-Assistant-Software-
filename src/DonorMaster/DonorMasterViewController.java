package DonorMaster;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class DonorMasterViewController {

	
	FileChooser fc=new FileChooser();
	File f;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> chkbloodg;

    @FXML
    private ComboBox<String> chkgender;

    @FXML
    private ImageView imgshow;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtage;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtdisease;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnumber;
    
    
    Connection con;
    PreparedStatement pst;


    @FXML
    void dobrowse(ActionEvent event) {
    	
//    	fc.setTitle("Choose File to be uploaded");
    	
    	fc.getExtensionFilters().add(new ExtensionFilter("JPG FILES", "*.jpg"));
    	f=fc.showOpenDialog(null);
    	
//    	FileChooser selectFile=fc.showOpenDialog(null);
    	
//    	Image img=new Image(selectFile.getAbsolutePath());
//    	picpath=selectFile.getAbsolutePath();
    	if(f!=null) {
    	
    		try {
				Image img=new Image(new FileInputStream(f.getAbsoluteFile()));
				imgshow.setImage(img);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
//    		prev.setImage(img);
    	}
    }

    @FXML
    void docancel(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from donor where mobile=?");
			pst.setString(1,txtnumber.getText());
			int count=pst.executeUpdate();
			if(count==0)
				showMsg("Invalid Number");
			else
			showMsg("Deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void dochkblood(ActionEvent event) {

    }

    @FXML
    void donew(ActionEvent event) {
    
    	txtnumber.setText(null);
    	txtaddress.setText(null);
    	txtname.setText(null);
    	txtage.setText(null);
    	txtcity.setText(null);
    	txtdisease.setText(null);
    	imgshow.setImage(null);
    	chkbloodg.setValue(null);
    	chkgender.setValue(null);
    	
    	
    	
    	

    }
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }

    @FXML
    void doregister(ActionEvent event){
    	try {
//	showMsg("Record Inserted Successfullyyyy");
    		System.out.println(f);
    		String s=  f.getAbsolutePath();
//    		showMsg("Record Ied Successfullyyyy");
			pst=con.prepareStatement("insert into donor values(?,?,?,?,?,?,?,?,?,current_date())");
			pst.setString(1,txtnumber.getText());
//			System.out.println(txtnumber.getText());
			pst.setString(2,s);
			pst.setString(3,txtname.getText());
			pst.setString(4, chkgender.getEditor().getText());
			pst.setString(5,txtaddress.getText());
			pst.setString(6,txtcity.getText());
			pst.setString(7, chkbloodg.getEditor().getText());
			pst.setString(8,txtage.getText());
			pst.setString(9,txtdisease.getText());
			pst.executeUpdate();
			showMsg("Record Inserted Successfullyyyy");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    void doupdate(ActionEvent event) {
    	try {
    		System.out.println(f);
			pst=con.prepareStatement("update donor set picpath=?,name=?,gender=?,address=?,city=?,bgroup=?,age=?,disease=? where mobile=?");
//			pst.setInt(3, Integer.parseInt(comboRoll.getEditor().getText()));
//			pst.setString(1, txtName.getText());
//			pst.setFloat(2, Float.parseFloat(txtPer.getText()));
				
			String s=f.getAbsolutePath();
			pst.setString(1,s);
			pst.setString(2,txtname.getText());
			pst.setString(3, chkgender.getEditor().getText());
			pst.setString(4,txtaddress.getText());
			pst.setString(5,txtcity.getText());
			pst.setString(6, chkbloodg.getEditor().getText());
			pst.setString(7,txtage.getText());
			pst.setString(8,txtdisease.getText());
			pst.setString(9,txtnumber.getText());
			int count=pst.executeUpdate();
			if(count==0)
				showMsg("Inavlid Number");
			else
				
			showMsg("Record Inserted Successfullyyyy");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
      con=DataBaseConnection.doConnect();
      ArrayList<String> items=new ArrayList<String>(Arrays.asList("apos","aneg","bpos","bneg","abpos","abneg","opos","oneg"));
      chkbloodg.getItems().setAll(items);
      ArrayList<String> gender=new ArrayList<String>(Arrays.asList("Male","Female","Other"));
      chkgender.getItems().setAll(gender);
      
    }

}
