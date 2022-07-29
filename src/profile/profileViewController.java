package profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class profileViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgavaliable;

    @FXML
    private ImageView imgchk;

    @FXML
    private ImageView imgdonation;

    @FXML
    private ImageView imghistory;

    @FXML
    private ImageView imgissuse;

    @FXML
    private ImageView imgregister;

    @FXML
    void doavaliable(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/bloodunitavaliable/bloodunitsavaliableView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void dochk(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/login/loginView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
			Scene scene1=(Scene)imgissuse.getScene();
			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void dodonation(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/theunits/theunitsView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void dohistory(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/Stock/StockView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doissuse(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/issued/issuBloodView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void domeet(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/issued/issuBloodView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doregister(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/DonorMaster/DonorMasterView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)imgissuse.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert imgavaliable != null : "fx:id=\"imgavaliable\" was not injected: check your FXML file 'profileView.fxml'.";
        assert imgchk != null : "fx:id=\"imgchk\" was not injected: check your FXML file 'profileView.fxml'.";
        assert imgdonation != null : "fx:id=\"imgdonation\" was not injected: check your FXML file 'profileView.fxml'.";
        assert imghistory != null : "fx:id=\"imghistory\" was not injected: check your FXML file 'profileView.fxml'.";
        assert imgissuse != null : "fx:id=\"imgissuse\" was not injected: check your FXML file 'profileView.fxml'.";
        assert imgregister != null : "fx:id=\"imgregister\" was not injected: check your FXML file 'profileView.fxml'.";

    }

}
