package bloodissue;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import DonorMaster.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class bloodissueViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<issusetable> table;
    
    @FXML
    private ComboBox<String> chkbloodg;

    @FXML
    private TextField txtgroup;

    @FXML
    private DatePicker txtissue;

    Connection con;
    PreparedStatement pst;
    ResultSet m;
    ObservableList<issusetable> getAllObjects(){
    	ObservableList<issusetable> ary=FXCollections.observableArrayList();
    	LocalDate local=txtissue.getValue();
    	PreparedStatement pst;
    	try {
    	pst=con.prepareStatement("select * from issued where bgroup=? and doi=?");
    	java.sql.Date date=java.sql.Date.valueOf(local);
    	pst.setString(1, chkbloodg.getEditor().getText());
    	pst.setDate(2,date);
    	System.out.println(pst);
    	m=pst.executeQuery();
    	while(m.next())
    	{
    		
    		
    		String name=m.getString("name");
    		String mobile=m.getString("mobile");
    		String hospital=m.getString("hospital");
    		String bgroup=m.getString("bgroup");
    		String doi=m.getString("doi");
    		String purpose=m.getString("purpose");

    		String noofunits=m.getString("noofunits");
//    		
    		issusetable obj=new issusetable(name,mobile,hospital,bgroup,doi,purpose,noofunits);
    		ary.add(obj);
//		    		
    		System.out.println(name+"  "+mobile+"  "+hospital+"  "+bgroup+"  "+doi+"  "+purpose+"  "+noofunits);
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
    void dolistall(ActionEvent event) {
    	TableColumn<issusetable, String> name=new TableColumn<issusetable, String>("name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	name.setMinWidth(100);
    	
    	TableColumn<issusetable, String> mobile=new TableColumn<issusetable, String>("mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<issusetable, String> hospital=new TableColumn<issusetable, String>("hospital");
    	hospital.setCellValueFactory(new PropertyValueFactory<>("hospital"));//same as bean property
    	hospital.setMinWidth(100);
    	
    	TableColumn<issusetable, String> bgroup=new TableColumn<issusetable, String>("bgroup");
    	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
    	bgroup.setMinWidth(100);
    	
    	TableColumn<issusetable, String> doi=new TableColumn<issusetable, String>("Date of Issuse");
    	doi.setCellValueFactory(new PropertyValueFactory<>("doi"));//same as bean property
    	doi.setMinWidth(100);
    	
    	TableColumn<issusetable, String> purpose=new TableColumn<issusetable, String>("purpose");
    	purpose.setCellValueFactory(new PropertyValueFactory<>("purpose"));//same as bean property
    	purpose.setMinWidth(100);
    	
    	TableColumn<issusetable, String> noofunits=new TableColumn<issusetable, String>("no of units");
    	noofunits.setCellValueFactory(new PropertyValueFactory<>("noofunits"));//same as bean property
    	noofunits.setMinWidth(100);
    	
    	
//    	table.getColumns().addAll(null);
    	table.getColumns().addAll(name,mobile,hospital,bgroup,doi,purpose,noofunits);
    	
    	//tblGrid.setItems(null);//remove existing records if any
    	   	
    	
    	ObservableList<issusetable>allRecords=getAllObjects();	
    	

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
    	 ArrayList<String> items=new ArrayList<String>(Arrays.asList("apos","aneg","bpos","bneg","abpos","abneg","opos","oneg"));
         chkbloodg.getItems().setAll(items);
    }

}
