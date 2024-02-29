Topic : Hackathon Project

Contents of the File

1.Introduction
2.Description
3.Pre-requisites
4.Tools Used
5.Procedure
6.Running the project
7.Reports


1.Introduction:
------------
The main objective of the project is to capture the new bikes name , price and launch date from the manfacturers of honda and bike price should be less than 4lakhs;

2.Description:
-----------
	1.Problem Statement: Identify New Bikes
	-----------------
		Display upcoming bikes details like , bike name, its price and expected launch date in India
		1. Manufacturer should be Honda.
		2. Bike price should be less than 4Lac
		(Suggested site: zigwheels however you are free to use any legitimate site)
	
	2.Detailed Description:
	----------------------
		1. Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac.
		2. For Used cars in Chennai, extract all the popular models in a List; Display the same
		3. Try to 'Login' with google, give invalid account details & capture the error message
		

3.Pre-requisites:
----------------
	-URL for https://www.zigwheels.com/

4.FrameWorks & Tools Used:
-----------------
	- Selenium Web Driver 
	- TestNG 
	- Java
	- POM 
	- HTML Extend Report
	- Cucumber BDD framework
	
5.Procedure for accessing:
-------------------------

	1.Open the website with the given URL and navigate to "NewBikes" under the dropdown click on "Upcoming Bikes" option
	2.Select manfacturer name as Honda
	3.Now Store bike name , price , and expected launch date in the excel
	4.Open the website with the given URL and navigate to "Used Cars" under the dropdown click on "Chennai" option
	5.Extract all the popular models in a list; and display the same
	6.Click on "Login" with google, give inavlid account details & capture the error message

6.To Run the Project:
--------------------
 1.Run the testng.xml file using TestNG suite- Hybrid Framework(Run as TestNG Suite).	
 2.Run the project using test Runner file - For cucumber BDD Framework(TestNG test).
 3.Run the project using jenkins by running the war file.
 4.Run the project using pom.xml by using option RunAs->Maven Test
 5.Run the project using command prompt open the project folder and write the following command "mvn test"
 
7.Report:
--------
	1.To access the Report generated in Excel Format:/Identify_NewBikes/ExtentReports/SparkReport 27-02-24 10-05-33/ExcelReports/ExcelReport.xlsx
	2.To access the Report generated in HTML format cucumber:/Identify_NewBikes/ExtentReports/SparkReport 27-02-24 10-05-33/Report/CucumberExtentReport.html
	3.To access the Report generated in Jenkins: /Identify_NewBikes/Jenkins-Report/surefire-reports/index.html
	4.To access the Report generated in Cucumber HTML Report:/Identify_NewBikes/Cucumber-reports/report.html
