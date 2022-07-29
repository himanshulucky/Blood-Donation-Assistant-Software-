package tableview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableresultviewController {

    @FXML
    private ResourceBundle resources;
    

    @FXML
    private URL location;

    @FXML
    private TableView<StudentBean> tabler;
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet table;
    ObservableList<StudentBean> getAllObjects(){
    	ObservableList<StudentBean> ary=FXCollections.observableArrayList();
    	PreparedStatement pst;
    	try {
    	pst=con.prepareStatement("select * from donor");
    	System.out.println(pst);
    	table=pst.executeQuery();
    	while(table.next())
    	{
    		
    		String name=table.getString("name");
    		String gender=table.getString("gender");
    		String address=table.getString("address");
    		String city=table.getString("city");
    		String bgroup=table.getString("bgroup");
    		String disease=table.getString("disease");
    		int age=table.getInt("age");//col wala name
    		String dor=table.getString("dor");
    		StudentBean obj=new StudentBean(name,gender,address,city,bgroup,disease,age,dor);
    		ary.add(obj);
		    		
    		System.out.println(name+"  "+gender+"  "+address+"  "+city+"  "+bgroup+"  "+disease+"  "+age+"  "+dor);
    	}
    	}
    	catch(Exception exp)
    	{ 	
    		System.out.println(exp);
    	}
    	System.out.println(ary.size());
    	return ary;
    } 
    
//    export codingl
    
    public void writeExcel( ObservableList<StudentBean> list) throws Exception {
        Writer writer = null;
        try {
        	File file = new File("DonorDetails.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="name,gender,address,city,bgroup,disease,age,dor\n";
            writer.write(text);
            for (StudentBean p : list)
            {
				text = p.getName()+ "," + p.getGender()+ "," + p.getAddress()+ "," + p.getCity()+"," + p.getBgroup()+"," + p.getDisease()+"," + p.getAddress()+"," + p.getDor()+"\n";
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }
    @FXML
    void doData(ActionEvent event) {
    	TableColumn<StudentBean, String> name=new TableColumn<StudentBean, String>("name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	name.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> gender=new TableColumn<StudentBean, String>("gender");
    	gender.setCellValueFactory(new PropertyValueFactory<>("gender"));//same as bean property
    	gender.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> address=new TableColumn<StudentBean, String>("address");
    	address.setCellValueFactory(new PropertyValueFactory<>("address"));//same as bean property
    	address.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> city=new TableColumn<StudentBean, String>("city");
    	city.setCellValueFactory(new PropertyValueFactory<>("city"));//same as bean property
    	city.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> bgroup=new TableColumn<StudentBean, String>("bgroup");
    	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
    	bgroup.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> disease=new TableColumn<StudentBean, String>("disease");
    	disease.setCellValueFactory(new PropertyValueFactory<>("disease"));//same as bean property
    	disease.setMinWidth(100);
    	
    	TableColumn<StudentBean, Integer> age=new TableColumn<StudentBean, Integer>("age");
    	age.setCellValueFactory(new PropertyValueFactory<>("age"));//same as bean property
    	age.setMinWidth(100);
    	
    	
    	TableColumn<StudentBean, String> dor=new TableColumn<StudentBean, String>("dor");
    	dor.setCellValueFactory(new PropertyValueFactory<>("dor"));//same as bean property
    	dor.setMinWidth(100);
    	
    	tabler.getColumns().addAll(name,gender,address,city,bgroup,disease,age,dor);
    	
    	//tblGrid.setItems(null);//remove existing records if any
    	   	
    	
    	ObservableList<StudentBean>allRecords=getAllObjects();	
    	

    	tabler.setItems(allRecords);
    	//getAllObjects();
    	
//    	//Export to excel
    	
//    	try {
//			writeExcel(allRecords);
//			System.out.println("Exported to excel..");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//


    }
    @FXML
    void dotable(ActionEvent event) {
    	
    }
    @FXML
    void doExpotp(ActionEvent event) {
    	
	getAllObjects();
	TableColumn<StudentBean, String> name=new TableColumn<StudentBean, String>("name");
	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
	name.setMinWidth(100);
	
	TableColumn<StudentBean, String> gender=new TableColumn<StudentBean, String>("gender");
	gender.setCellValueFactory(new PropertyValueFactory<>("gender"));//same as bean property
	gender.setMinWidth(100);
	
	TableColumn<StudentBean, String> address=new TableColumn<StudentBean, String>("address");
	address.setCellValueFactory(new PropertyValueFactory<>("address"));//same as bean property
	address.setMinWidth(100);
	
	TableColumn<StudentBean, String> city=new TableColumn<StudentBean, String>("city");
	city.setCellValueFactory(new PropertyValueFactory<>("city"));//same as bean property
	city.setMinWidth(100);
	
	TableColumn<StudentBean, String> bgroup=new TableColumn<StudentBean, String>("bgroup");
	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
	bgroup.setMinWidth(100);
	
	TableColumn<StudentBean, String> disease=new TableColumn<StudentBean, String>("disease");
	disease.setCellValueFactory(new PropertyValueFactory<>("disease"));//same as bean property
	disease.setMinWidth(100);
	
	TableColumn<StudentBean, Integer> age=new TableColumn<StudentBean, Integer>("age");
	age.setCellValueFactory(new PropertyValueFactory<>("age"));//same as bean property
	age.setMinWidth(100);
	
	
	TableColumn<StudentBean, String> dor=new TableColumn<StudentBean, String>("dor");
	dor.setCellValueFactory(new PropertyValueFactory<>("dor"));//same as bean property
	dor.setMinWidth(100);
	
	tabler.getColumns().addAll(name,gender,address,city,bgroup,disease,age,dor);
	
	//tblGrid.setItems(null);//remove existing records if any
	   	
	
	ObservableList<StudentBean>allRecords=getAllObjects();	
	
	
	tabler.setItems(allRecords);
    	//Export to excel
    	
    	try {
			writeExcel(allRecords);
			System.out.println("Exported to excel..");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	showMsg("Exported Successfully");

    }
    @FXML
    void initialize() {
    	 con=DataBaseConnection.doConnect();

    }

}
