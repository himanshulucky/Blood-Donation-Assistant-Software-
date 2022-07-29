package Stock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StockViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgavaliable;

    @FXML
    private ImageView imgdonation;

    @FXML
    private ImageView imgregister;
    
    @FXML
    void DoGithub(ActionEvent event) {

    }
    @FXML
    void doDonor(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/tableview/tableresultview.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)tabler.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    

    @FXML
    void doavaliable(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/bloodissue/bloodissueView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)tabler.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void dodonation(ActionEvent event) {
    	try{
    		Parent root=FXMLLoader.load(getClass().getResource("/bloodcollectiontableview/bloodcollectionView.fxml")); 
							//OR
			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide parent window
//			Scene scene1=(Scene)tabler.getScene();
//			   scene1.getWindow().hide();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert imgavaliable != null : "fx:id=\"imgavaliable\" was not injected: check your FXML file 'StockView.fxml'.";
        assert imgdonation != null : "fx:id=\"imgdonation\" was not injected: check your FXML file 'StockView.fxml'.";
        assert imgregister != null : "fx:id=\"imgregister\" was not injected: check your FXML file 'StockView.fxml'.";

    }

}
