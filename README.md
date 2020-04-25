# Vodafone Egypt VIS Test automation technical assessment 
### A Test automation FramWork that automates the process of sending an email attachment and Verify the received email.



## what does the script do

•	Login from Email account #1

•	Send an email with a unique/dynamic title (with timestamp ex.: dd/mm/yyyy HH:MM) and an attachment to email 

• use the desktop tool to upload the file.

•	Log in to Email #2

•	Verify the received email content and download the attachment file




## Built With
* JAVA                  - Programming Language

* Selenium              -WebDriver

* TestNG                -testing framework

* Maven                 -software project management and comprehension tool

* Extent Reporting      -Extent Reporting Framework

* AUTtest Recorder       -Video Recording framework

* AutoIT Tool            -scripting Tool designed for automating windows GUI


## How to use it

- First you have to add AUTtestRecorder jar file to your local repository (Because it doesnot have an online maven dependcy)
  
  * You can find the jar file on the project folder (ATUTestRecorder_2.1.jar) copy the path of the jar file. open the Terminal copy the     below command
  
```
mvn install:install-file -Dfile={Path}/ATUTestRecorder_2.1.jar -DgroupId=org.aut.tm -DartifactId=cxf-bundle -Dversion=2.7.3 -Dpackaging=jar
```
  
- And then just open your command prompt and navigate to the directory where the project files are  , and then type these two command     lines

```
mvn clean
mvn test
```

## Solution features

•		Architecture: Hybrid Test Automation Framework (Modular *reusable methods* and Data-driven) with an Object-Oriented design

•		Nothing is hard-coded in the scripts:

•	Test data stored in external Excel file .

•	Selection of execution browser  managed from a configuration file Cross-browser support (Internet Explorer, Firefox, Chrome)

•		Desktop Support using tool AutoIt tool

•	TestNG tests to verify/assert that each action was performed successfully

•	Auto Generated  detailed execution status report containing the status of each of the executed steps and the executed test including screenshots for failures are preferred

•	Report Assertion failures and other exceptions properly in the execution report

• Recovery from assertion failures 


## Reports
* Report include

- Number of total executed test cases 

- Number of passed TestCases

- Number of Failed TestCases

- Total time taken 

- Pass percentage

- Screen Shots

-Video Records

## TestCases Execution

- Sending email & uploading attachment  test Case execution ( https://imgur.com/T2eTvWa )

![TestCase GIF](https://imgur.com/vsZjMZY.gif)

- Verfiy reciving email and downloading attachment  ( https://imgur.com/jlRh2sX )

![TestCase_GIF](https://media.giphy.com/media/XHLo5Gai8D41NRYq0t/giphy.gif)

## Reports Results Samples

<img src="https://imgur.com/p0M5eVB.png" width="80%">


<img src="https://imgur.com/oacY2Y6.png" width="80%">
