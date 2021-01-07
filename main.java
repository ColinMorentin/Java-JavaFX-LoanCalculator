/*
################################################################################
Author  	: Colin Morentin
Created 	: 9/28/19
Updated 	: 10/13/19
Version 	: 1.2
Function	: To declare and instantiate objects of various derived classes 
			  of a common base class. 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
NOTES
A graphical interface to an application that calculates loan payments presents
a good option for a basic JavaFX project. It will present the user with 
TextFields for collecting loan data –annual interest rate, term
in years and amount loaned.The application will pass
this data into an object of the Loan class that you created in a previous 
assignment. In addition to loan data, the application will collect income 
data –salary and wages, interest income, investment income and other income. 
The purpose of collecting income data is to use it for determining a potential 
borrower’s eligibility for a loan of a given amount. The example below shows 
how this interface should look. Clicking “Calc Payment” will do the following:
>Calculate the potential borrower’s total income as the sum of salaries and 
wages, interest income, investment income and other incomeUse an object of 
the Loan class to store loan data in its attributes and calculate the periodic
payment and sum of payments over the life of a loan which has the specified 
interest rate, term and amountIndicate, by displaying a message in the 
position shown in the sample,whether the potential borrower is eligible for
the loan based on whether the periodic payment divided by one-twelfth of
total income(the monthly income)is less than or equal to 25%.If the loan
payment is greater than 25% of the monthly income, the potential borrower
 is not eligible for the loan. Incorporate the actual calculated percent 
 in the message.Because the percent used for determining eligibility may 
 change, use a named constant placed close to the beginning to represent it. 
 Clicking “Cancel” will close the application.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
OBJECTIVES
>refer to notes

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
PROPOSED CHANGES	
> clean up start
> optimize
> more functions
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
PROBLEMS:
>pressing enter throws error flag
################################################################################
*/

package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application 
{
	final String FONT_NAME = "Georgia";
	// font used in interface
	
	GridPane grid = null;
	
	final double WIDTH = 1070;
	final double HEIGHT = 335;
	// dimension of the window or "Stage"
	
	final int EQUALMARGINS = 25;
	// space surround edge of window
	final int FONTSIZE = 20;
	// size of the font
	
	Stage window;
	// Alternate name to stage

	double totalIncomeData = 0.0;
	// calculated total monthly income
	double monnthlyPayment = 0.0;
	// monthly payment required for loan
	
	Label salaryAndWages = null;
	Label annualInterestRate = null;
	Label interestIncome = null;
	Label termInYears = null;
	Label investmentIncome = null;
	Label loanAmount = null;
	Label otherIncome = null;
	Label monthlyPayment = null;
	Label totalIncome = null;
	Label totalPayments = null;
	// self explanatory labels for the text fields
	
	Label Results = null;
	// says if the customer can take out a loan
	
	
	TextField salaryAndWagesTextField = null;
	TextField annualInterestRateTextField = null;
	TextField interestIncomeTextField = null;
	TextField termInYearsTextField = null;
	TextField investmentIncomeTextField = null;
	TextField loanAmountTextField = null;
	TextField otherIncomeTextField = null;
	TextField monthlyPaymentTextField = null;
	TextField totalIncomeTextField = null;
	TextField totalPaymentsTextField = null;
	// will act as input/output for most correlating labels
	
	Button button = null;
	
	HBox hButton = null;
	
	final int INPUTVALID = 0;
	// no changes have occurred while checking user input
	
	final int COLUMN_1 = 0;
	final int COLUMN_2 = 1;
	final int COLUMN_3 = 2;
	final int COLUMN_4 = 3;
	// declared columns
	
	final int ROW_1 = 0;
	final int ROW_2 = 1;
	final int ROW_3 = 2;
	final int ROW_4 = 3;
	final int ROW_5 = 4;
	final int ROW_6 = 5;
	// declared rows
	
	final double TWENTY_FIVE_PERCENT = 0.25;
	// amount determines loan eligibility
	
	final double LARGE_PERCENTAGE = 1000000.00;
	// arbitrary large number 
	
	final double PERCENTAGE_FLAG = 0;
	// number associated with a percentage error
	final double DECIMAL_TO_PERCENT = 100;
	// conversion from percent to Decimal or vice versa
	
	final double MONTHS_IN_YEAR = 12;
	// number of months in a year
	
	final int HBOX_SIZE = 10;
	// Arbitrary size of the HBOXS
	
	final int INVALID_DATA = 1;
	// invalid data flag
	
	final double BAD_DATA = 0;
	// used to indicate bad data
	
	Color backgroundColor = null;
	// colors of background

	BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, null, null);
	// fills the background with said color

	Background background = new Background( backgroundFill ) ;
	// sets the background with filled color

	Border grayBorder = null;
	// creates grey border around textFields
	
	BorderStrokeStyle solidRoundStrokeStyle = null;
	// style of border
	
	CornerRadii radius5 = null;
	// style of border
	
	 Color colorWhite = null;
	 // color of border
	 
	 String textBox1 = "";
	 String textBox2 = "";
	 String textBox3 = "";
	 String textBox4 = "";
	 String textBox5 = "";
	 String textBox6 = "";
	 String textBox7 = "";
	 String Empty = " ";
	 // unintelligent way of storing data of the text fields
	
	 
	 boolean goodChar1 = false;
	 boolean goodChar2 = false;
	 boolean goodChar3 = false;
	 boolean goodChar4 = false;
	 boolean goodChar5 = false;
	 boolean goodChar6 = false;
	 boolean goodChar7 = false;
	 // used for character validation in changing background color

	 

	 
	 boolean backSpaced = false;
	 boolean backSpaced2 = false;
	 boolean backSpaced3 = false;
	 boolean backSpaced4 = false;
	 boolean backSpaced5= false;
	 boolean backSpaced6 = false;
	 boolean backSpaced7 = false;
	 // used to recognize backspace character in changing background color
	
	 
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			window = primaryStage;
			// renaming the stage for simplicity
			window.setTitle("Loan Payment and Eligibility Calculator Form");
			// title of the window
			
			grid = new GridPane();
			// grid format for the scene
		
			grid.setHgap(10);
			grid.setVgap(10);
			// space between elements on the grid
			grid.setPadding(new Insets(EQUALMARGINS, EQUALMARGINS, EQUALMARGINS, EQUALMARGINS)); 
			// area between the grid and the edge of the window 
			// enough space must be allocated
			
			
			salaryAndWages = new Label("Salary and wages");
			// declare label with set name
			salaryAndWages.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(salaryAndWages, COLUMN_1, ROW_1); 
			// declare place in grid like organization system
			
			salaryAndWagesTextField = new TextField();
			// declare empty text field for user input
			salaryAndWagesTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare stylized font to be used in the data field
			grid.add(salaryAndWagesTextField, COLUMN_2, ROW_1); 
			// declare place in grid like organization system
			greyBorder(salaryAndWagesTextField);
			// changes border color
			
			
			annualInterestRate = new Label("Annual interest rate(n.nnn%)");
			// declare label with set name
			annualInterestRate.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare font stylization 
			grid.add(annualInterestRate, COLUMN_3, ROW_1);
			// declare place in grid like organization system
			
			annualInterestRateTextField = new TextField();
			// declare empty text field for user input
			annualInterestRateTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			grid.add(annualInterestRateTextField, COLUMN_4, ROW_1); 
			// declare place in grid like organization system
			greyBorder(annualInterestRateTextField);
			
			interestIncome = new Label("Interest income");
			// declare label with set name
			interestIncome.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(interestIncome, COLUMN_1, ROW_2); 
			// declare place in grid like organization system
			
			interestIncomeTextField = new TextField();
			// declare empty text field for user input
			interestIncomeTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// font style
			grid.add(interestIncomeTextField, COLUMN_2, ROW_2); 
			// declare place in grid like organization system
			greyBorder(interestIncomeTextField);
			
			termInYears = new Label("Term in years");
			// declare label with set name
			termInYears.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(termInYears, COLUMN_3, ROW_2); 
			// declare place in grid like organization system
			
			termInYearsTextField = new TextField();
			// declare empty text field for user input
			termInYearsTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// font style
			grid.add(termInYearsTextField, COLUMN_4, ROW_2); 
			// declare place in grid like organization system
			greyBorder(termInYearsTextField);
			
			investmentIncome = new Label("Investment income");
			// declare label with set name
			investmentIncome.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(investmentIncome, COLUMN_1, ROW_3);
			// set location in grid
			
			investmentIncomeTextField = new TextField();
			// declare empty text field for user input
			investmentIncomeTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// set font style
			grid.add(investmentIncomeTextField, COLUMN_2, ROW_3); 
			// declare place in grid like organization system
			greyBorder(investmentIncomeTextField);
			
			loanAmount = new Label("Loan amount");
			// declare label with set name
			loanAmount.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare font stylization 
			grid.add(loanAmount, COLUMN_3, ROW_3); 
			// declare place in grid like organization system
			
			loanAmountTextField = new TextField();
			// declare empty text field for user input
			loanAmountTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// set font style
			grid.add(loanAmountTextField, COLUMN_4, ROW_3); 
			// declare place in grid like organization system
			greyBorder(loanAmountTextField);
			
			otherIncome = new Label("Other income");
			// declare label with set name
			otherIncome.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare font stylization 
			grid.add(otherIncome, COLUMN_1, ROW_4); 
			// declare place in grid like organization system
			
			otherIncomeTextField = new TextField();
			// declare empty text field for user input
			otherIncomeTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// set font style
			grid.add(otherIncomeTextField, COLUMN_2, ROW_4); 
			// declare place in grid like organization system
			greyBorder(otherIncomeTextField);
			
			monthlyPayment = new Label("Monthly Payment");
			// declare label with set name
			monthlyPayment.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare font stylization 
			grid.add(monthlyPayment, COLUMN_3, ROW_4); 
			// declare place in grid like organization system
			
			monthlyPaymentTextField = new TextField();
			// declare empty text field for user input
			monthlyPaymentTextField.setDisable(true);
			// disable user input
			monthlyPaymentTextField.setStyle("-fx-opacity: 1.0;");
			// return normal opacity
			monthlyPaymentTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			//font style
			grid.add(monthlyPaymentTextField, COLUMN_4, ROW_4);
			// declare place in grid like organization system
			greyBorder(monthlyPaymentTextField);
			
			totalIncome = new Label("Total income");
			// declare label with set name
			totalIncome.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(totalIncome, COLUMN_1, ROW_5);
			// declare place in grid like organization system
			
			totalIncomeTextField = new TextField();
			// declare empty text field for user input
			totalIncomeTextField.setDisable(true);
			// disable user input
			totalIncomeTextField.setStyle("-fx-opacity: 1.0;");
			// return to normal opacity
			totalIncomeTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// font style
			grid.add(totalIncomeTextField, COLUMN_2, ROW_5);
			// declare place in grid like organization system
			greyBorder(totalIncomeTextField);
			
			totalPayments = new Label("Total payments over life of loan");
			// declare label with set name
			totalPayments.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE)); 
			// declare font stylization 
			grid.add(totalPayments, COLUMN_3, ROW_5); 
			// declare place in grid like organization system
			
			totalPaymentsTextField = new TextField();
			// declare empty text field for user input
			totalPaymentsTextField.setDisable(true);
			// disable user input
			totalPaymentsTextField.setStyle("-fx-opacity: 1.0;");
			// return normal opacity from disabling input
			totalPaymentsTextField.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// font stylization 
			grid.add(totalPaymentsTextField, COLUMN_4, ROW_5);
			// declare place in grid like organization system
			greyBorder(totalPaymentsTextField);
			
			Results = new Label("");
			// declare label with set name
			Results.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// declare font stylization 
			grid.add(Results, COLUMN_3, ROW_6);
			// declare place in grid like organization system
			
		
			button = new Button("Calc Payment");
			// creates a button to press for Calculating
			button.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// font stylization 
			hButton = new HBox(HBOX_SIZE); 
			// creates a box around the button
			hButton.getChildren().add(button);
			// puts button in the box
			button.setOnAction(e ->
			//what happens when you push the button
			{
				totalIncomeData = 
				totalIncomeCalculator(salaryAndWagesTextField,interestIncomeTextField,
						investmentIncomeTextField, otherIncomeTextField,
						totalIncomeTextField);
				// calculate the total Income and return values to interface
				
				
				double periodicPayment = 
						periodicPaymentCalculator(annualInterestRateTextField, 
						termInYearsTextField, loanAmountTextField, 
						monthlyPaymentTextField, totalPaymentsTextField);
				// get periodic payment and return value to interface
				
				double percentage = 0.0;
				// used to determine loan eligibility
				
				try
				{
					double monthlyIncome = (totalIncomeData / MONTHS_IN_YEAR);
					// finds monthly income
					percentage = Math.round(periodicPayment / monthlyIncome);
					// finds how % of loan payment of your monthly income
				}
				catch( IllegalArgumentException ex)
				// attempted to use for diving by zero etc, but didnt' work
				{
					percentage = PERCENTAGE_FLAG;
					// raises flag for errors
				}
				if(percentage == PERCENTAGE_FLAG || percentage > LARGE_PERCENTAGE )
					// arbitrary values i deemed to raise flag
				{
					Results.setText("ERROR");
					// send error message to interface
				}
				else if((percentage <=  TWENTY_FIVE_PERCENT))
					// if the monthly payment is 25% or less of your monthly income
					// you get to take out a loan
				{
					String percentageText = Double.toString(percentage * DECIMAL_TO_PERCENT);
					// variable casting
					
					Results.setText(percentageText+ "%  of monthly income."
							+ "\nCustomer is eligible for Loan.");
					// output data to interface
				}
				else
				{
					String percentageText = Double.toString(percentage * DECIMAL_TO_PERCENT);
					// variable casting
					Results.setText(percentageText+ "% of monthly income." 
							+ "\nCustomer is not eligible for Loan.");
					// output to interface
				}
				
				
			});
			
			grid.add(hButton, COLUMN_1, ROW_6);
			// declare place in grid like organization system
			
			Button button2 = new Button("Cancel");
			// generate cancel button
			button2.setFont(Font.font(FONT_NAME, FontWeight.NORMAL, FONTSIZE));
			// style of font
			HBox hButton2 = new HBox(HBOX_SIZE);
			// create box around button
			hButton2.getChildren().add(button2); 
			// puts button in the box
			
			button2.setOnAction(e -> 
			// determines what the cancel button does
			{
				window.close();
				// close the window
			
			});
			
			grid.add(hButton2, COLUMN_2, ROW_6);
			// declare place in grid like organization system
			

		
			salaryAndWagesTextField.setOnKeyPressed(e1->
			// reads for pressed keys on text field
			// I was having difficulty creating a method for this
			// process using the lambda function
			// so i just replicated this code 7 times
			// this process is only commented once
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
					// if user enters backspace in text field
				{
					textBox1 = method(textBox1);
					// remove previous character
					backSpaced = true;
					// recognizes backspace has happened
				}
				
			});
		
			salaryAndWagesTextField.setOnKeyTyped(e->
			{
				goodChar1 = false;
				// assumes an invalid character is provided
				int check = INPUTVALID;
				//assumes valid input in the textBox
				textBox1 += e.getCharacter();
				// store the entered key into the textBox
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
					// valid numbers from 0 -9
				{
				    goodChar1 = true;
				    // valid character is entered
				}
				if(backSpaced == true)
					// if a backspace was entered
				{
					textBox1 = method(textBox1);
					// remove the collected backspace character
					backSpaced = false;
					// remove backspace flag
					check = validateData(textBox1);
					// check to see if rest of characters in text box are valid
					if(check == INPUTVALID)
						// checks text box validity
					{
						goodChar1 = true;
						// valid chars
					}
				}
				
			
				if(textBox1 != Empty)
					// if the textBox isn't empty
				{
					//System.out.printf("%s\n", textBox1);
					//redundant used for testing
					
					check = validateData(textBox1);
					// check for valid input
					
					if(check == INPUTVALID &&  goodChar1 == true)
						// if the character entered + rest of input entered is valid
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
						// change background to white
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					// configures the background color
					salaryAndWagesTextField.setBackground(background);
					// sets the background color
					greyBorder(salaryAndWagesTextField);
					// restores border
					
				}
				
				
			});
			
			interestIncomeTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox2 = method(textBox2);
					backSpaced2 = true;
				}
				
			});
		
			interestIncomeTextField.setOnKeyTyped(e->
			{
				goodChar2 = false;
				int check2 = INPUTVALID;
				textBox2 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar2 = true;
				}
				if(backSpaced2 == true)
				{
					textBox2 = method(textBox2);
					backSpaced2 = false;
					check2 = validateData(textBox2);
					if(check2 == INPUTVALID)
					{
						goodChar2 = true;
					}
				}
				
			
				if(textBox2 != Empty)
				{
					
					
					check2 = validateData(textBox2);
					
					if(check2 == INPUTVALID &&  goodChar2 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					interestIncomeTextField.setBackground(background);
					greyBorder(interestIncomeTextField);
					
				}
				
				
			});
			
			investmentIncomeTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox3 = method(textBox3);
					backSpaced3 = true;
				}
				
			});
		
			investmentIncomeTextField.setOnKeyTyped(e->
			{
				goodChar3 = false;
				int check3 = INPUTVALID;
				textBox3 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar3 = true;
				}
				if(backSpaced3 == true)
				{
					textBox3 = method(textBox3);
					backSpaced3 = false;
					check3 = validateData(textBox3);
					if(check3 == INPUTVALID)
					{
						goodChar3 = true;
					}
				}
				
			
				if(textBox3 != Empty)
				{
				
					
					check3 = validateData(textBox3);
					
					if(check3 == INPUTVALID &&  goodChar3 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					investmentIncomeTextField.setBackground(background);
					greyBorder(investmentIncomeTextField);
					
				}
				
				
			});
			
			otherIncomeTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox4 = method(textBox4);
					backSpaced4 = true;
				}
				
			});
		
			otherIncomeTextField.setOnKeyTyped(e->
			{
				goodChar4 = false;
				int check4 = INPUTVALID;
				textBox4 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar4 = true;
				}
				if(backSpaced4 == true)
				{
					textBox4 = method(textBox4);
					backSpaced4 = false;
					check4 = validateData(textBox4);
					if(check4 == INPUTVALID)
					{
						goodChar4 = true;
					}
				}
				
			
				if(textBox4 != Empty)
				{
					
					
					check4 = validateData(textBox4);
					
					if(check4 == INPUTVALID &&  goodChar4 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					otherIncomeTextField.setBackground(background);
					greyBorder(otherIncomeTextField);
					
				}
				
				
			});
			
			annualInterestRateTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox5 = method(textBox5);
					backSpaced5 = true;
				}
				
			});
		
			annualInterestRateTextField.setOnKeyTyped(e->
			{
				goodChar5 = false;
				int check5 = INPUTVALID;
				textBox5 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar5 = true;
				}
				if(backSpaced5 == true)
				{
					textBox5 = method(textBox5);
					backSpaced5 = false;
					check5 = validateData(textBox5);
					if(check5 == INPUTVALID)
					{
						goodChar5 = true;
					}
				}
				
			
				if(textBox5 != Empty)
				{
					System.out.printf("%s\n", textBox5);
					
					check5 = validateData(textBox5);
					
					if(check5 == INPUTVALID &&  goodChar5 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					annualInterestRateTextField.setBackground(background);
					greyBorder(annualInterestRateTextField);
					
				}
				
				
			});
			
			termInYearsTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox6 = method(textBox6);
					backSpaced6 = true;
				}
				
			});
		
			termInYearsTextField.setOnKeyTyped(e->
			{
				goodChar6 = false;
				int check6 = INPUTVALID;
				textBox6 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar6 = true;
				}
				if(backSpaced6 == true)
				{
					textBox6 = method(textBox6);
					backSpaced6 = false;
					check6 = validateData(textBox6);
					if(check6 == INPUTVALID)
					{
						goodChar6 = true;
					}
				}
				
			
				if(textBox6 != Empty)
				{
					System.out.printf("%s\n", textBox6);
					
					check6 = validateData(textBox6);
					
					if(check6 == INPUTVALID &&  goodChar6 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					termInYearsTextField.setBackground(background);
					greyBorder(termInYearsTextField);
					
				}
			});
			
			loanAmountTextField.setOnKeyPressed(e1->
			{
				if(e1.getCode() == KeyCode.BACK_SPACE)
				{
					textBox7 = method(textBox7);
					backSpaced7 = true;
				}
				
			});
		
			loanAmountTextField.setOnKeyTyped(e->
			{
				goodChar7 = false;
				int check7 = INPUTVALID;
				textBox7 += e.getCharacter();
			
				
				if ( (e.getCharacter().compareTo("0") >= 0 && e.getCharacter().compareTo("9") <= 0 ))
				{
				    goodChar7 = true;
				}
				if(backSpaced7 == true)
				{
					textBox7 = method(textBox7);
					backSpaced7 = false;
					check7 = validateData(textBox7);
					if(check7 == INPUTVALID)
					{
						goodChar7 = true;
					}
				}
				
			
				if(textBox7 != Empty)
				{
					System.out.printf("%s\n", textBox7);
					
					check7 = validateData(textBox7);
					
					if(check7 == INPUTVALID &&  goodChar7 == true)
					{
						backgroundColor = Color.rgb( 255, 255, 255, 1.0);
					}
					else
					{
						backgroundColor = Color.rgb( 128, 0 , 0, 0.5); 
						// turn background red if user types a letter
					}
					
				
					backgroundFill = new BackgroundFill(backgroundColor, null, null);
					background = new Background( backgroundFill ) ;
					loanAmountTextField.setBackground(background);
					greyBorder(loanAmountTextField);
					
				}
			});
			
			Scene scene = new Scene(grid, WIDTH,HEIGHT);
			// how what inside the window is organized and its dimensions
			window.setScene(scene);
			// put the interface inside the window
		
			window.show();
			// show what's inside the window
			
		
		
			
		} 
		catch(Exception e)
		// general catch for errors 
		{
			e.printStackTrace();
			// trace the location of the error
		} 
	
	}
	

	private double periodicPaymentCalculator(TextField annualInterestRateTextField, 
			TextField termInYearsTextField,
			TextField loanAmountTextField, TextField monthlyPaymentTextField, 
			TextField totalPaymentsTextField) 
	{
		double annualInterestRateData = 0.0;
		int termInYearsData = 0;
		double loanAmountData = 0.0;
		double monthlyPaymentData = 0.0;
		int totalPaymentsData = 0;
		// Straight forward values
		int validData = 0;
		// anything other than the value of 0 means an error occurred
		
		validData += validateData(annualInterestRateTextField);
		// check if user entered valid data
		annualInterestRateData = readData(annualInterestRateTextField) / DECIMAL_TO_PERCENT;
		// convert text field data to usable data 
		
		validData += validateData(termInYearsTextField);
		// check if user entered valid data
		termInYearsData = readIntData(termInYearsTextField);
		// convert text field data to usable data 
		
		validData += validateData(loanAmountTextField);
		// check if user entered valid data
		loanAmountData = readData(loanAmountTextField);
		// convert text field data to usable data 
		
		if(validData == INPUTVALID)
			// if user entered valid variable types
		{
			Mortgage mortgage = new Mortgage(1,1,'m',annualInterestRateData,
					loanAmountData, termInYearsData);
			// generate object to call methods
			
			monthlyPaymentData = mortgage.calcPeriodicpayment();
			// determine how much the monthly payment should be for the loan
			String monthlyPayments = Double.toString(monthlyPaymentData);
			// conversion
			monthlyPaymentTextField.setText(monthlyPayments);
			// output to interface
			
			totalPaymentsData = mortgage.calcNumPayments();
			// determine the # of payments till loan is paid off
			String totalPayments = Integer.toString(totalPaymentsData);
			// conversion
			totalPaymentsTextField.setText(totalPayments);
			// output to interface
			
		}
		else
			// user entered invalid data types
		{
			monthlyPaymentTextField.setText("ERROR");
			totalPaymentsTextField.setText("ERROR");
			// output error messages to the interface
		}
	
		
		return monthlyPaymentData;
		// return the periodic payment data
	}


	private double totalIncomeCalculator(TextField salaryAndWagesTextField, 
			TextField interestIncomeTextField,
			TextField investmentIncomeTextField, TextField otherIncomeTextField,
			TextField totalIncomeTextField) 
	// determines users total income
	{
		double salaryAndWagesData = 0.0;
		double interestIncomeData = 0.0;
		double investmentIncomeData = 0.0;
		double otherIncomeData = 0.0;
		double totalIncomeData = 0;
		// straight forward variables
		int validData = 0;
		// anything other than the value of 0 means an error occurred
		
		validData += validateData(salaryAndWagesTextField);
		// check user entered data type
		salaryAndWagesData = readData(salaryAndWagesTextField);
		// convert data
		
		validData += validateData(interestIncomeTextField);
		// check user entered data tye
		interestIncomeData = readData(interestIncomeTextField);
		// convert data
		
		validData += validateData(investmentIncomeTextField);
		// check user entered data type
		investmentIncomeData = readData(investmentIncomeTextField);
		// convert data
		
		validData += validateData(otherIncomeTextField);
		//check user entered data type
		otherIncomeData = readData(otherIncomeTextField);
		// convert data
		
		if(validData == INPUTVALID)
			// if user entered valid data types
		{
			totalIncomeData = salaryAndWagesData + interestIncomeData
			+ investmentIncomeData + otherIncomeData;
			// simple addition to determien total income
			String totalIncomeText = Double.toString(totalIncomeData);
			// data conversion
			totalIncomeTextField.setText(totalIncomeText);
			// output to interface
			
		}
		else
		{
			totalIncomeTextField.setText("ERROR");
			// output error message to interface
		}
		return totalIncomeData;
		// return income data
	}


	private int validateData(TextField input)
	// check if correct data type is used
	{
		
		double data = 0.0;
		// temporary data holder
		int check = 0;
		// anything other than 0 means invalid data
		// type was entered
		try
		{
			data = Double.parseDouble(input.getText());
			// read data
		}
		catch(NumberFormatException ex)
		// invalid data type was entered
		{
			check = INVALID_DATA;
			// raise flag invalid data was found
		}
		return check;
	}


	private double readData(TextField input) 
	{
		double data = 0.0;
		// used for reading data
		try
		{
			data = Double.parseDouble(input.getText());
			// read data
		}
		catch(NumberFormatException ex)
		{
			data = BAD_DATA;
			// flag bad data
		}
		return data;
		// return data
	}
	
	private int readIntData(TextField input) 
	{
		int data = 0;
		// used for reading data
		try
		{
			data = Integer.parseInt(input.getText());
			// read data
		}
		catch(NumberFormatException ex)
		// finds if bad data type used
		{
			data = INVALID_DATA;
			// flag bad data
		}
		return data;
		// return data
	}
	
	public String method(String str) 
	//ripped off stack overflow for removing 1 char off a string
	{
	    if (str != null && str.length() > 0) 
	    {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	

	private int validateData(String input)
	// check if correct data type is used
	{
		
		double data = 0.0;
		// temporary data holder
		int check = 0;
		// anything other than 0 means invalid data
		// type was entered
		try
		{
			data = Double.parseDouble(input);
			// read data
		}
		catch(NumberFormatException ex)
		// invalid data type was entered
		{
			check = INVALID_DATA;
			// raise flag invalid data was found
		}
		return check;
	}

	private void greyBorder(TextField text)
	// changes border of a text field to a grey color
	{
		colorWhite = Color.rgb(164,164,164,0.75); 
		// red green blue  for grey
		BorderStrokeStyle solidRoundStrokeStyle =  new BorderStrokeStyle(StrokeType.OUTSIDE, StrokeLineJoin.ROUND, null, 1.0, 0.0, null); 
    	radius5 = new CornerRadii(5.0);
    	BorderStroke borderStroke = new BorderStroke(colorWhite, solidRoundStrokeStyle, radius5, BorderStroke.THIN);
		grayBorder = new Border(borderStroke);
		text.setBorder(grayBorder);
		
	}
	public static void main(String[] args)
	{
		launch(args);
		// launch interface
	}
	


	
}
