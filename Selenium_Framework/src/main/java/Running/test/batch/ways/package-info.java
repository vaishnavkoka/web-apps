/**
 * 
 */
/**
 * @author Amul
 *
 */
package Running.test.batch.ways;
/*
A test batch is group of test cases is called test suite/test set/test chain.
Executing a group of related cases at one point of control is called batch testing.we can perform
batch testing by testng.xml file.
navigation: select required test cases---> right click ---> testng convert to testng, if required 
modify suite name and test name---> click finish,
Automatically testng.xml file will be created under project , right click on project and refresh 
---> open testng.xml file ---> execute testng.xml
After executing right click on project and refresh, A folder names 'test-output' is created and you
can find emailable and xml report there.

other way---------->
Step 1: Open notepad
Step 2: Paste the below lines of code - You may need to add your project location. In the example, project location is set as 'F:\Selenium\TestNGBatchExample'.
Step 3: Save the file as 'testNGBatchFile.bat' in location that you want to save.
set projectLocation=F:\Selenium\TestNGBatchExample
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause
 */