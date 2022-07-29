package theunits;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DonorMaster.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class theunitsViewController {
	void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> chkmobile;

    @FXML
    private ImageView imgshow;

    @FXML
    private TextField txtbloodg;
    
    @FXML
    private DatePicker txtdonation;
    Connection con;
    PreparedStatement pst;
    ResultSet m;

    void getmobile() {
    	
    	try {
			pst=con.prepareStatement("select distinct mobile from donor");
			m=pst.executeQuery();
			while(m.next()) {
				String mobile1 = m.getString("mobile");
				mobile.add(String.valueOf(mobile1));
			}
			chkmobile.getItems().addAll(mobile);
//			pst.setString(1, chkmobile.getEditor().getText());
//			pst.setString(2,s);
//			pst.setString(2,String.valueOf(DatePicker.getvalue()));
//			pst.executeUpdate();
//			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
  
    @FXML
    void btnsearch(ActionEvent event) {
    	try {
    		pst=con.prepareStatement("select * from donor where mobile=?");
    		pst.setString(1, chkmobile.getEditor().getText());
    		m=pst.executeQuery();
    		while(m.next()) {
    			txtbloodg.setText(m.getString("bgroup"));
    			Date date=m.getDate("dor");
    			//java.sql.Date date1=java.sql.Date.valueOf(date);
    			//txtDOD.setText(date);
    			LocalDate date1=date.toLocalDate();
    			txtdonation.setValue(date1);
    			String f=m.getString("picpath");
    			System.out.println(f);
    			if(f!=null) {
    		    	
    	    		try {
    					Image img=new Image(new FileInputStream(f));
    					imgshow.setImage(img);
    					
    				} catch (Exception e) {
    					// TODO: handle exception
    				}
//    	    		prev.setImage(img);
    	    	}
    		}
    	}
    	catch(SQLException exp) {
    		
    	}
    }

    @FXML
    void btnuploaddata(ActionEvent event) {
    	String s=txtbloodg.getText();
    	try {
			pst=con.prepareStatement("insert into donations value(?,?,?)");
			pst.setString(1, chkmobile.getEditor().getText());
			pst.setString(2,s);
			pst.setString(3,String.valueOf(txtdonation.getValue()));
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		System.out.println(s);
			pst=con.prepareStatement("update bloodrecord set "+s+"="+s+"+?");
			pst.setInt(1,1);
			pst.executeUpdate();
			showMsg("Updated Successfully");
			
		} catch (Exception e) {
			System.out.println(e);
		}
    }	

    @FXML
    void donew(ActionEvent event) {
    	
    			txtbloodg.setText("");
    	    	chkmobile.getEditor().setText("");
    	    	txtdonation.setValue(null);
    	

    }
    ArrayList<String>mobile=new ArrayList<String>();
    @FXML
    void initialize() {
    	con=DataBaseConnection.doConnect();
    	getmobile();
    	chkmobile.getItems().setAll(mobile);
        		}

}
