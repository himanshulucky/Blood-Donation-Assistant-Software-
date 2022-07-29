package bloodcollectiontableview;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import DonorMaster.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class bloodcollectionViewController {
	

    Connection con;
    PreparedStatement pst;
    ResultSet m;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnalldonation;

    @FXML
    private Button btndonation;

    @FXML
    private TextField donormobile;

    @FXML
    private TableView<bloodcollection> table;
    
    ObservableList<bloodcollection> getAllObjects(){
    	ObservableList<bloodcollection> ary=FXCollections.observableArrayList();
    	PreparedStatement pst;
    	try {
    	pst=con.prepareStatement("select * from donations");
    	System.out.println(pst);
    	m=pst.executeQuery();
    	while(m.next())
    	{
    		
    		String mobile=m.getString("mobile");
    		String bgroup=m.getString("bgroup");
    		String dateofdonation=m.getString("dateofdonation");
//    		
    		bloodcollection obj=new bloodcollection(mobile,bgroup,dateofdonation);
    		ary.add(obj);
//		    		
    		System.out.println(mobile+"  "+bgroup+"  "+dateofdonation);
    	}
    	}
    	catch(Exception exp)
    	{ 	
    		System.out.println(exp);
    	}
    	System.out.println(ary.size());
    	return ary;
    } 
    
    ObservableList<bloodcollection> getonlyobject(){
    	ObservableList<bloodcollection> ary=FXCollections.observableArrayList();
    	PreparedStatement pst;
    	try {
    	pst=con.prepareStatement("select * from donations where mobile=?");
    	pst.setString(1,donormobile.getText());
    	System.out.println(pst);
    	m=pst.executeQuery();
    	while(m.next())
    	{
    		
    		String mobile=m.getString("mobile");
    		String bgroup=m.getString("bgroup");
    		String dateofdonation=m.getString("dateofdonation");
//    		
    		bloodcollection obj=new bloodcollection(mobile,bgroup,dateofdonation);
    		ary.add(obj);
//		    		
    		System.out.println(mobile+"  "+bgroup+"  "+dateofdonation);
    	}
    	}
    	catch(Exception exp)
    	{ 	
    		System.out.println(exp);
    	}
    	System.out.println(ary.size());
    	return ary;
    } 
    @FXML
    void dobtnalldonation(ActionEvent event) {
    	TableColumn<bloodcollection, String> mobile=new TableColumn<bloodcollection, String>("mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<bloodcollection, String> bgroup=new TableColumn<bloodcollection, String>("Blood Group");
    	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
    	bgroup.setMinWidth(100);
    	
    	TableColumn<bloodcollection, String> dateofdonation=new TableColumn<bloodcollection, String>("Date of Donation");
    	dateofdonation.setCellValueFactory(new PropertyValueFactory<>("dateofdonation"));//same as bean property
    	dateofdonation.setMinWidth(100);
    	
//    	table.getColumns().addAll(null);
    	table.getColumns().addAll(mobile,bgroup,dateofdonation);
    	
    	//tblGrid.setItems(null);//remove existing records if any
    	   	
    	
    	ObservableList<bloodcollection>allRecords=getAllObjects();	
    	

    	table.setItems(allRecords);
    	//getAllObjects();
    	
//    	//Export to excel
//    	
//    	try {
//			writeExcel(allRecords);
//			System.out.println("Exported to excel..");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}



    }

    @FXML
    void dobtndonation(ActionEvent event) {
    	TableColumn<bloodcollection, String> mobile=new TableColumn<bloodcollection, String>("mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<bloodcollection, String> bgroup=new TableColumn<bloodcollection, String>("Blood Group");
    	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
    	bgroup.setMinWidth(100);
    	
    	TableColumn<bloodcollection, String> dateofdonation=new TableColumn<bloodcollection, String>("Date of Donation");
    	dateofdonation.setCellValueFactory(new PropertyValueFactory<>("dateofdonation"));//same as bean property
    	dateofdonation.setMinWidth(100);
    	
//    	table.getColumns().addAll(null);
    	table.getColumns().addAll(mobile,bgroup,dateofdonation);
    	
    	//tblGrid.setItems(null);//remove existing records if any
    	   	
    	
    	ObservableList<bloodcollection>allRecords=getonlyobject();	
    	

    	table.setItems(allRecords);
    	//getAllObjects();
    	
//    	//Export to excel
//    	
//    	try {
//			writeExcel(allRecords);
//			System.out.println("Exported to excel..");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}



    }


    @FXML
    void initialize() {
       
    	con=DataBaseConnection.doConnect();
    }

}
