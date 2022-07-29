module bloodDonationJava {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens DonorMaster to javafx.graphics, javafx.fxml;
	opens Issued to javafx.graphics, javafx.fxml;
	opens theunits to javafx.graphics, javafx.fxml;
	opens tableview to javafx.graphics, javafx.fxml,javafx.base;
	opens bloodunitavaliable to javafx.graphics, javafx.fxml;
	opens bloodcollectiontableview to javafx.graphics, javafx.fxml,javafx.base;
	opens bloodissue to javafx.graphics, javafx.fxml,javafx.base;
	opens profile to javafx.graphics, javafx.fxml;
	opens login to javafx.graphics, javafx.fxml;
	opens Stock to javafx.graphics, javafx.fxml;
}
