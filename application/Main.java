package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;

public class Main extends Application{
	ComboBox<String> select = new ComboBox();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Account> accounts = new ArrayList<Account>();
	Label pageName = new Label("Home");
	public void start(Stage primaryStage) {
		Scene scene = new Scene (getPane(), 600, 200);
		primaryStage.setTitle("Bank");
		primaryStage.setScene(scene);
		primaryStage.show();
	} 
	
	// This is the Main Pane for the Entire Project
	protected BorderPane getPane() {
		/*
		 * Creates the Main Page for the Bank,
		 * Initializes with Create Checking Account
		 */
		BorderPane mainPane = new BorderPane();
		
		mainPane.setPadding(new Insets(5,5,5,5));
		HBox topBar = getTopBar(pageName);
		BorderPane selection = getSelection(mainPane);
		
		
		
		mainPane.setCenter(select);
		mainPane.setTop(topBar);
		mainPane.setBottom(getSplashScreen());
		
		
		return mainPane;
	}
	
	public HBox getTopBar(Label pageName) {
		// This is the Top Bar that displays what page the user is on
		HBox topBar = new HBox(140);
		
		Label bankName = new Label("Team Black Bank");
		topBar.getChildren().add(bankName);
		topBar.getChildren().add(pageName);
		
		return topBar;
	}
	
	public BorderPane getSplashScreen() {
		// This is the Welcome/ Main screen with instructions
		BorderPane splashScreen = new BorderPane();
		
		// Welcome note
		Label welcome = new Label("Welcome to the Black Bank Application");
		// Instructions
		String[] instructions = {"From the Combo Box in the top left, choose an option"
		, "After making a selection, fill out all fields "};
		
		VBox vbInstructions = new VBox();
		vbInstructions.getChildren().add(new Label("Instructions:"));
		for (String instruction: instructions) {
			vbInstructions.getChildren().add(new Label("*" + instruction));
		}
		
		splashScreen.setTop(welcome);
		splashScreen.setCenter(vbInstructions);
		splashScreen.setMinHeight(75);
		return splashScreen;
	}
	
	private BorderPane getCreateGoldAccount(BorderPane mainPane, String typeOfAccount) {
		/*
		 * Creates a gold account
		 */
		BorderPane createGoldAccount = new BorderPane();
		// Ask about Customer
		createGoldAccount.setCenter(getCustomerSelection(mainPane, typeOfAccount));
		
		
		return createGoldAccount;
	}
	private BorderPane getCreateRegularAccount(BorderPane mainPane, String typeOfAccount) {
		/*
		 * Creates a gold account
		 */
		BorderPane createRegularAccount = new BorderPane();
		// Ask about Customer
		createRegularAccount.setCenter(getCustomerSelection(mainPane, typeOfAccount));
		
		
		return createRegularAccount;
	}
	
	
	private BorderPane getCustomerSelection(BorderPane mainPane, String typeOfAccount) {
		/*
		 * This returns a BorderPane of a GUI
		 * where the user can select to create
		 * a new customer or select an existing
		 * With the selection initialized to 
		 * Create a new Customer
		 */
		BorderPane customerSelection = new BorderPane();
			RadioButton rbUseExistingCustomer = new RadioButton("Use Exisiting Customer");
			RadioButton rbCreateNewCustomer = new RadioButton("Create New Customer");
			
			HBox hbForRadioBtns = new HBox();
			hbForRadioBtns.getChildren().addAll(rbUseExistingCustomer, rbCreateNewCustomer);
			hbForRadioBtns.setAlignment(Pos.CENTER);
			hbForRadioBtns.setSpacing(10);
			customerSelection.setTop(hbForRadioBtns);
			ToggleGroup customer = new ToggleGroup();
			rbUseExistingCustomer.setToggleGroup(customer);
			rbCreateNewCustomer.setToggleGroup(customer);
			rbCreateNewCustomer.setSelected(true);
			customerSelection.setCenter(getCreateNewCustomer(mainPane, typeOfAccount));
			
			
			// Handlers 
			
			/*
			 * If the Create new Customer Radio Button
			 * is the selected option, then it will show 
			 * the create a new customer display
			 */
			rbCreateNewCustomer.setOnAction(e->{
				customerSelection.setCenter(getCreateNewCustomer(mainPane, typeOfAccount));
			});
			/*
			 * If the Use Existing Customer option
			 * is the selection, then it will
			 * instead show the GUI Customer Search
			 */
			rbUseExistingCustomer.setOnAction(e->{
				customerSelection.setCenter(getSearchCustomer(mainPane, typeOfAccount));
			});
			
			
		return customerSelection;
	}
	
	private BorderPane getCreateCheckingAccount(BorderPane mainPane, String typeOfAccount) {
		/*
		 * This returns a GUI of creating a Checking Account
		 * It first asks About the customer
		 * Then Asks about Account Info
		 */
		BorderPane createCheckingAccount = new BorderPane();
		
		// Start With Customer Selection
		createCheckingAccount.setCenter(getCustomerSelection(mainPane, typeOfAccount));
		
		
		return createCheckingAccount;
	}
	
	
	
	private BorderPane getCreateNewCustomer(BorderPane mainPane, String typeOfAccount) {
		BorderPane createNewCustomer = new BorderPane();
		// Customer(String customerID, String firstName, String lastName, 
		// String Address, String phoneNumber)
		
		FlowPane flow = new FlowPane();
		
		VBox vbCustomerID = new VBox();
		Label lbCustomerID = new Label("Customer ID: ");
		TextField tfCustomerID = new TextField();
		vbCustomerID.getChildren().addAll(lbCustomerID, tfCustomerID);
		
		VBox vbFirstName = new VBox();
		Label lbFirstName = new Label("First Name: ");
		TextField tfFirstName = new TextField();
		vbFirstName.getChildren().addAll(lbFirstName, tfFirstName);
		
		VBox vbLastName = new VBox();
		Label lbLastName = new Label("Last Name: ");
		TextField tfLastName = new TextField();
		vbLastName.getChildren().addAll(lbLastName, tfLastName);
		
		VBox vbAddress = new VBox();
		Label lbAddress = new Label("Address");
		TextField tfAddress = new TextField();
		vbAddress.getChildren().addAll(lbAddress, tfAddress);
		
		VBox vbPhoneNumber = new VBox();
		Label lbPhoneNumber = new Label("Phone Number: ");
		TextField tfPhoneNumber = new TextField();
		vbPhoneNumber.getChildren().addAll(lbPhoneNumber, tfPhoneNumber);
		
		Button create = new Button("Create Customer");
		flow.setHgap(5);
		flow.setVgap(5);
		flow.getChildren().
			addAll(vbCustomerID, vbFirstName, vbLastName,
				vbAddress, vbPhoneNumber, create);
		createNewCustomer.setCenter(flow);
		
		// Button Handler
		create.setOnAction(e ->{
			// This Portion Creates the Customer Object and Adds
			// It to the customers List, it also checks if the 
			// user entered all values
			String customerID = tfCustomerID.getText();
			String firstName = tfFirstName.getText();
			String lastName = tfLastName.getText();
			String address = tfAddress.getText();
			String phoneNumber = tfPhoneNumber.getText();
			if(customerID == "") {
				lbCustomerID.setText("ERROR: Customer ID:");
			} else {
				Customer newCustomer = new Customer(customerID, 
						firstName, lastName, address, phoneNumber);
				customers.add(newCustomer);
				mainPane.setCenter(getCreateAccountForm(newCustomer, mainPane, typeOfAccount));
				
			}
			
			
		});
		
		return createNewCustomer;
	}
	
	public BorderPane getCreateAccountForm(Customer customer, BorderPane mainPane, String typeOfAccount) {
		/*
		 * This method creates a GUI for all of the Create Account Forms,
		 * It uses a switch statement to identify which kind of account
		 * to create. 
		 */
		BorderPane createAccountForm = new BorderPane();
		
		// public Account(Customer customer, double balance)
		Label lbCustomerName = new Label("Customer: " + customer.toString());
		
		//Create Input for Initial Balance
		HBox hbInputBalance = new HBox();
		TextField tfInputBalance = new TextField();
		hbInputBalance.getChildren().
		addAll(new Label("Input Balance: "), tfInputBalance);
		
		// Create Submit Button
		Button btnSubmit = new Button("Create Account");
		
		btnSubmit.setOnAction(e->{
			// When the Submit it pressed,
			// Access the text field and
			// reference the customer
			// to create a CheckingAccount
			int inputBalance = Integer.parseInt(tfInputBalance.getText()); 
			Account newAccount = null;
			// Make the account based off of the type 
			// of account provided earlier
			switch(typeOfAccount) {
			case "Checking":
				newAccount = new CheckingAccount(customer, inputBalance);
				break;
			case "Gold":
				newAccount = new GoldAccount(customer, inputBalance);
				break;
			case "Regular":
				newAccount = new RegularAccount(customer, inputBalance);
			}
			if(newAccount == null) {
				// Error Creating Account
			} else {
				customer.addAccount(newAccount);
				accounts.add(newAccount);
				mainPage(mainPane);
				
			}
			
			
		});
		
		createAccountForm.setTop(lbCustomerName);
		createAccountForm.setCenter(hbInputBalance);
		createAccountForm.setBottom(btnSubmit);
		createAccountForm.setMinSize(100, 100);
		createAccountForm.setAlignment(btnSubmit, Pos.BASELINE_RIGHT);
		createAccountForm.setAlignment(hbInputBalance, Pos.CENTER);
		return createAccountForm;
	}
	
	private BorderPane getSearchCustomer(BorderPane main, String typeOfAccount) {
		/*
		 * This method creates a GUI that prompts the user to 
		 * search a Customer ID, It will then display if the account is not found
		 * Or if it is, then validate that this is the one you are looking for.
		 * 
		 */
		BorderPane searchCustomer = new BorderPane();
		searchCustomer.setPadding(new Insets(5,5,3,3));
		HBox hbCustomer = new HBox();
		VBox vbCustomerID = new VBox();
		Label lbCustomerID = new Label("Customer ID:");
		TextField tfCustomerID = new TextField();
		vbCustomerID.getChildren().addAll(lbCustomerID, tfCustomerID);
	
		Button search = new Button("Search!");
		Label lbSearchResult = new Label();
		hbCustomer.getChildren().addAll(lbCustomerID, tfCustomerID, search, lbSearchResult);
		searchCustomer.setCenter(hbCustomer);
		searchCustomer.setAlignment(search, Pos.CENTER_RIGHT);
		
		// Handle the Search Button
		search.setOnAction(e->{
			Customer foundCustomer = null;
			String customerNum = tfCustomerID.getText();
			foundCustomer = searchCustomers(customerNum);
			if(foundCustomer == null) {
				// If an account wasn't found,
				// Change the text
				lbSearchResult.setText("Customer not found");
			}else {
				validateCustomer(foundCustomer, searchCustomer, main, typeOfAccount);
			}
			
			
		});
		
		return searchCustomer;
	}
	
	public BorderPane createAccountFromFoundCustomer(Customer customer, BorderPane main, String typeOfAccount) {
		// This Creates a GUI of showing the account initial balance prompt and the Customers info
		BorderPane createAccountFromFoundCustomer = new BorderPane();
		VBox customerInfo = getCustomerInfo(customer);
		
		BorderPane vbInitialBalance = getCreateAccountForm(customer, main, typeOfAccount);
		HBox createAccount = new HBox();
		
		createAccount.getChildren().addAll(vbInitialBalance, customerInfo);
		createAccountFromFoundCustomer.setCenter(createAccount);
		
		
		return createAccountFromFoundCustomer;
	}
	
	public void validateCustomer(Customer customer, BorderPane searchCustomer, BorderPane main, String typeOfAccount) {
		/*
		 * This Method checks to make sure that this is the correct Account. 
		 */
		VBox customerInfo = getCustomerInfo(customer);
		Button yes = new Button("Yes, this account");
		Button no = new Button("No, not this account");
		HBox hbAccounts = new HBox();
		hbAccounts.getChildren().addAll( new Label("Is this the account?"),yes, no);
		customerInfo.getChildren().addAll(hbAccounts);
		searchCustomer.setBottom(customerInfo);
		
		// Handle Yes,
		yes.setOnAction(e->{
			searchCustomer.setBottom(null);
			searchCustomer.setCenter(createAccountFromFoundCustomer(customer, main, typeOfAccount));
		});
		//Handle No
		no.setOnAction(e->{
			searchCustomer.setBottom(null);
		});
	}
	
	public Customer searchCustomers(String customerId) {
		/*
		 * This method searches through the Customers arrayList
		 * It returns the customer found or null if not found 
		 */
		Customer customerRef = null;
		for(Customer customer:customers) {
			if(customer.getCustomerID().equalsIgnoreCase(customerId)) {
				customerRef = customer;
			}
		}
		
		return customerRef;
	}
	
	public VBox getCustomerInfo(Customer customer) {
		// This method displays a GUI for a Customer's info given a customer,
		//This will be called within displayAccountInfo and the customer will
		// be located from the account
		VBox vbCustomerInfo = new VBox();
		
		Label lbCustomerName = new Label("Name: " 
										+ customer.toString());
		
		Label lbCustomerAddress = new Label("Address: " 
											+ customer.getAddress());
		Label lbCustomerID = new Label("ID: " 
										+ customer.getCustomerID());
		Label lbPhoneNumber = new Label("Phone Number: " 
										+ customer.getPhoneNumber());
		vbCustomerInfo.getChildren().addAll(lbCustomerName, 
				lbCustomerAddress, lbCustomerID, lbPhoneNumber );
		
		return vbCustomerInfo;
	}
	
	
	
	
	
	
	// Deposit and WithdrawFunction
	public BorderPane getDW(String typeOf, BorderPane mainPane) {
		// GUI Part of Deposit & Withdraw
		BorderPane depositAndWithdraw = new BorderPane();
		Label title = new Label();
		Label DorP = new Label(); // Deposit or Withdraw
		Label lbAccountFound = new Label();
		
		// Get the Account
		
		TextField tfAccount = new TextField();
		Button search = new Button("Search");
		
		// Get Deposit or Withdraw Amount
		
		
		TextField tfInputValue = new TextField();
		Button submit = new Button("Submit");
		
		// Change the Page and methods depending on type
		switch (typeOf) {
		case "Deposit":
			DorP.setText("Deposit");
			break;
		case "Withdraw":
			DorP.setText("Withdraw");
			
			break;
		}
		
		// Handlers
		search.setOnAction(e->{
			int accountNum = Integer.parseInt(tfAccount.getText());
			// Search through Accounts
			Account account = searchAccount(accountNum);

			// Validation
			if(account == null ) {
				// Error Finding Account
				lbAccountFound.setText("Account Could not be found");
			} else {
				lbAccountFound.setText("Account" + account.toString());
			}
		});
		
		submit.setOnAction(e->{
			int accountNum = Integer.parseInt(tfAccount.getText());
			// Search through Accounts
			Account account = searchAccount(accountNum);
			int ammount = Integer.parseInt(tfInputValue.getText());
			// Validation 
			// Check if account was found
			if(account == null ) {
				// Error Finding Account
				lbAccountFound.setText("Account Could not be found");
			} else {
				// Account Found, Allow Button deposit or withdraw
				lbAccountFound.setText("Account" + account.getCustomer().toString());
				switch(typeOf) {
				case "Deposit":
					//Do deposit
					account.deposit(ammount);
					
					break;
				case "Withdraw":
					// Do Withdraw
					account.withdraw(ammount);
					break;
				}
				showAccountInfo(account, mainPane);
				
				
				
				
			}
		});
		HBox hbAmmount = new HBox(DorP, new Label(" ammount: $"));
		// Create VBoxes
		VBox vbInputValue = new VBox(hbAmmount, tfInputValue, submit);
		VBox vbAccount = new VBox(new Label("Account #:"),
				tfAccount, search, lbAccountFound);
		vbAccount.setAlignment(Pos.CENTER);
		vbInputValue.setAlignment(Pos.CENTER);
		// Add to BorderPane
		depositAndWithdraw.setLeft(vbAccount);
	    depositAndWithdraw.setRight(vbInputValue);
		depositAndWithdraw.setMinHeight(100);
		depositAndWithdraw.setMinWidth(300);
		
		// Add Padding
		depositAndWithdraw.setPadding(new Insets(5,5,5,5));
		return depositAndWithdraw;
	}
	
	public void showAccountInfo(Account account, BorderPane mainPane) {
		// This method is used to create a GUI for Account Info from a given account
		Button btnContinue = new Button("Continue");
		VBox accountInfo = accountInfo(account);
		accountInfo.getChildren().add(btnContinue);
		
		//Handle button
		btnContinue.setOnAction(e->{
			// Go back to splashScreen
			mainPage(mainPane);
		});
		
		mainPane.setCenter(accountInfo);
		
	}
	
	public Account searchAccount(int accountSearchInput) {
		Account foundAccount = null;
		for(Account account: accounts) {
			if(account.getAccountNumber() == accountSearchInput) {
				foundAccount = account;
			}
		}
		
		return foundAccount;
	}
	
	public BorderPane getDisplayInfo(BorderPane mainPane) {
		/*
		 * This method returns a GUI for displaying an Account Info
		 * The user searches for an account, if the account is found, 
		 * It changes the GUI to display the Account Info.
		 */
		BorderPane displayInfo = new BorderPane();
		
		// Start By Searching for Account
		HBox hbSearch = new HBox();
		Label lbSearch = new Label("Search Account number:");
		TextField tfSearch = new TextField();
		Button btnSearch = new Button("Search");
		Label lbCustomerNotFound = new Label();

		hbSearch.getChildren().addAll(lbSearch, tfSearch, btnSearch, lbCustomerNotFound);
		hbSearch.setSpacing(3);
		
		
		
		displayInfo.setCenter(hbSearch);
		
		// Button Handler For Searching
		btnSearch.setOnAction(e->{
			int searchValue = Integer.parseInt(tfSearch.getText());
			Account account = searchAccount(searchValue);
			if(account == null) {
				lbCustomerNotFound.setText("Account not found");
			} else {
				mainPane.setCenter(getAccountDisplayInfo(account));
			}
		});
		
		
		
		
		
		
		return displayInfo;
	}
	
	public VBox accountInfo(Account account) {
		/*
		 * This method displays a GUI for the account info.
		 */
		VBox  vbAccountInfo = new VBox();
		Label lbAccountTitle = new Label("Account Info:");
		Label lbAccountNumber = new Label("Account Number: " + account.getAccountNumber());
		Label lbBalance = new Label("Balance: $" + account.getBalance());
		vbAccountInfo.getChildren().addAll(lbAccountTitle, lbAccountNumber, lbBalance);
		return vbAccountInfo;
	}
	
	public BorderPane getAccountDisplayInfo(Account account) {
		/*
		 * This method displays a GUI for the Account info given an account
		 */
		BorderPane accountDisplayInfo = new BorderPane();
		
		
		// Customer Info
		Customer customer = account.getCustomer();
		
		Label lbCustomerTitle = new Label("Customer Info:");
		
		VBox vbCustomerInfo = new VBox();
		Label lbCustomerName = new Label("Name: " + customer.toString());
		
		Label lbCustomerAddress = new Label("Address: " + customer.getAddress());
		Label lbCustomerID = new Label("ID: " + customer.getCustomerID());
		Label lbPhoneNumber = new Label("Phone Number: " + customer.getPhoneNumber());
		
		Label lbOtherAccounts = new Label(customer.getFirstName() + "'s other Accounts:");
		ArrayList<Account> customerAccounts = customer.getAccounts();

		vbCustomerInfo.getChildren().addAll(lbCustomerTitle, 
				lbCustomerName, lbCustomerAddress, lbCustomerID, lbPhoneNumber, lbOtherAccounts );
		
		if(customerAccounts.size() > 1) {
			ComboBox<String> combo = new ComboBox<>();
			String[] accountNums= new String[customerAccounts.size()];
			
			for(int i = 0; i< customerAccounts.size(); i++) {
				accountNums[i] = Integer.toString(customerAccounts.get(i).getAccountNumber());
			}
			
			// Display the Customer Accounts
			ObservableList<String> customerAccountStrings = FXCollections.observableArrayList(accountNums);
			
			combo.getItems().addAll(customerAccountStrings);
			
			vbCustomerInfo.getChildren().addAll( combo );
			// Handle combo change
			combo.setOnAction(e->{
				VBox newAccountInfo = accountInfo(customerAccounts.get(customerAccountStrings.indexOf(combo.getValue())));
				accountDisplayInfo.setRight(newAccountInfo);
				newAccountInfo.setAlignment(Pos.CENTER);
			});
		} else {
			lbOtherAccounts.setText("This is this customer's only Account");
		}
		// Account Info
		VBox  vbAccountInfo = accountInfo(account);
		
		// Move to center
		vbAccountInfo.setAlignment(Pos.CENTER);
		vbCustomerInfo.setAlignment(Pos.CENTER);
		
		// Add Side by Side Info Panels to BorderPane 
		accountDisplayInfo.setLeft(vbCustomerInfo);
		accountDisplayInfo.setRight(vbAccountInfo);
		accountDisplayInfo.setPadding(new Insets(10,10,10,10));
		
		
		
		
		return accountDisplayInfo;
	}
	
	public BorderPane getBottom(BorderPane mainPane) {
		// Creates a Back button
		BorderPane bottom = new BorderPane();
		Button btnBack = new Button("Back");
		bottom.setCenter(btnBack);
		// Button Handler For Back
				btnBack.setOnAction(e->{
					mainPage(mainPane);
				});
		return bottom;
	}
	
	public BorderPane getEndOfMonthUpdates(BorderPane mainPane) {
		/*
		 * Applies monthly updates to all accounts if button is pressed
		 */
		BorderPane endOfMonthUpdates = new BorderPane();
		
		Button btnUpdate = new Button("Update");
		endOfMonthUpdates.setCenter(btnUpdate);
		
		btnUpdate.setOnAction(e->{
			for(Account account: accounts) {
				account.monthlyUpdates();
			}
			mainPage(mainPane);
		});
		
		
		return endOfMonthUpdates;
	}
	public void mainPage(BorderPane mainPane) {
		mainPane.setCenter(select);
		mainPane.setBottom(getSplashScreen());
		pageName.setText("Home");
		select.setValue(null);
	}
	
	public BorderPane getRemoveAccount(BorderPane mainPane) {
		/*
		 * This method displays a GUI 
		 * for searching accounts to remove
		 */
		BorderPane removeAccount = new BorderPane();
		
		// Start By Searching for Account
				HBox hbSearch = new HBox();
				Label lbSearch = new Label("Search Account number:");
				TextField tfSearch = new TextField();
				Button btnSearch = new Button("Search");
				Label lbCustomerNotFound = new Label();

				hbSearch.getChildren().addAll(lbSearch, tfSearch, btnSearch, lbCustomerNotFound);
				hbSearch.setSpacing(3);
		removeAccount.setCenter(hbSearch);
		
		// handle Search button
		btnSearch.setOnAction(e->{
			Account account = searchAccount(Integer.parseInt(tfSearch.getText()));
			if(account == null) {
				lbCustomerNotFound.setText("Customer not found");
			} else {
				removedUser(account, removeAccount, mainPane);
			}
		});
		
		return removeAccount;
	}
	
	public VBox removedUser(Account account, BorderPane removeAccount, BorderPane mainPane) {
		/*
		 * This method shows a GUI that confirms that a user has been deleted
		 * Displays the account that has been deleted info.
		 */
		VBox removedUser = new VBox();
		Button btnContinue = new Button("Continue");
		removedUser.getChildren().addAll(new Label("Customer Deleted"), accountInfo(account), btnContinue);
		account.removeAccount(account);
		removeAccount.setCenter(removedUser);
		accounts.remove(accounts.indexOf(account));
		
		btnContinue.setOnAction(e->{
			mainPage(mainPane);
		});
		return removedUser;
	}
	
	public BorderPane getBankStats() {
		// This method calculates and displays the Bank Stats
		BorderPane bankStats = new BorderPane();
		double sum = 0;
		int numZeroAcc = 0;
		double numOfAcc = 0;
		double largestBalance = 0;
		Account largestBalanceAccount = null;
		
		for(Account account: accounts) {
			sum += account.getBalance();
			if(account.getBalance() <=0) {
				numZeroAcc++;
			}
			if(account.getBalance() > largestBalance) {
				largestBalance = account.getBalance();
				largestBalanceAccount = account;
			}
			numOfAcc++;
		}
		double avg = (sum/numOfAcc);
		
		HBox hbTotalSum = new HBox();
		hbTotalSum.getChildren().addAll(new Label("Total Sum: $" + String.format("%.2f", sum)));
		HBox hbNumZeroAccount = new HBox();
		hbNumZeroAccount.getChildren().addAll(new Label("Number of $0 or less Accounts: " + numZeroAcc));
		HBox hbAvg = new HBox();
		hbAvg.getChildren().add(new Label("Average of All Accounts: $" + String.format("%.2f", avg)));
		HBox hbLargest = new HBox();
		hbLargest.getChildren().addAll(new Label("Largest Account: "), accountInfo(largestBalanceAccount));
		
		VBox vbBankStats = new VBox();
		vbBankStats.getChildren().addAll(hbTotalSum, hbNumZeroAccount, hbAvg, hbLargest);
		bankStats.setCenter(vbBankStats);
		return bankStats;
	}
	
	public BorderPane getNoAccounts() {
		/*
		 * This method displays that there were no accounts found
		 */
		BorderPane noAccount = new BorderPane();
		Label text = new Label("No Information to Display, Create an Account");
		noAccount.setCenter(text);
		return noAccount;
	}
	
	
	public BorderPane getSelection(BorderPane mainPane) {
		/*
		 * This method displays the Combo Box
		 */
		String[] menuOptions = {"1. Create a Checking account", 
				"2. Create a Gold account", "3. Create a Regular account",
				"4. Deposit", "5. Withdraw", "6. Display Account Info",
				"7. Remove an Account", "8. Apply end of month updates",
				"9. Display Bank Stats", "10. Exit"}; 
		BorderPane startPage = new BorderPane();
		BorderPane paneForComboBox = new BorderPane();
		paneForComboBox.setLeft(new Label("Select an option:"));
		paneForComboBox.setCenter(select);
		ObservableList<String> items = FXCollections.observableArrayList(menuOptions);
		select.getItems().addAll(items);
		
		startPage.getChildren().add(paneForComboBox);
		
		// Handlers
		select.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int selection = items.indexOf(select.getValue()) + 1;
				switch(selection) {
					case 1:
						pageName.setText("Create Checking Account");
						mainPane.setCenter(getCreateCheckingAccount(mainPane, "Checking"));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 2:
						pageName.setText("Create a Gold Account");
						mainPane.setCenter(getCreateGoldAccount(mainPane, "Gold"));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 3:
						pageName.setText("Create a Regular Account");
						mainPane.setCenter(getCreateRegularAccount(mainPane, "Regular"));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 4:
						pageName.setText("Deposit");
						mainPane.setCenter(getDW("Deposit", mainPane));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 5:
						pageName.setText("Withdraw");
						mainPane.setCenter(getDW("Withdraw", mainPane));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 6:
						pageName.setText("Display Account Info");
						mainPane.setCenter(getDisplayInfo(mainPane));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 7:
						pageName.setText("Remove an Account");
						mainPane.setCenter(getRemoveAccount(mainPane));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 8:
						pageName.setText("Apply end of month updates");
						mainPane.setCenter(getEndOfMonthUpdates(mainPane));
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 9:
						pageName.setText("Display Bank Stats");
						try {
							mainPane.setCenter(getBankStats());
						} catch(Exception ex) {
							mainPane.setCenter(getNoAccounts());
						}
						mainPane.setBottom(getBottom(mainPane));
						break;
					case 10:
						pageName.setText("Exiting");
						
						System.exit(0);
				}
			}
		});
		
		return startPage;
	}
	 
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
