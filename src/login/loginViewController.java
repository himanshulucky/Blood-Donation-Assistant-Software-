package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField doemail;

    @FXML
    private TextField dopassword;

    @FXML
    void dologin(ActionEvent event) {
    	if (doemail.getText().equals("h") && dopassword.getText().equals("h")) {
    		try{
        		Parent root=FXMLLoader.load(getClass().getResource("/profile/profileView.fxml")); 
    							//OR
    			//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("marks/card/MarksCard.fxml")); 
    			Scene scene = new Scene(root);
    			Stage stage=new Stage();
    			stage.setScene(scene);
    			stage.show();
    			//to hide parent window
    			Scene scene1=(Scene)doemail.getScene();
    			   scene1.getWindow().hide();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			
    		}
		}
    }

    @FXML
    void initialize() {
      
    }

}
