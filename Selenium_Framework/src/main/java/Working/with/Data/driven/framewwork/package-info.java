/**
 * 
 */
/**
 * @author Amul
 *
 */
package Working.with.Data.driven.framewwork;
/*
Data-driven is a test automation framework which stores test data in a table or spreadsheet format
This allows automation engineers to have a single test script which can execute tests for all the
test data in the table.In this framework, input values are read from data files and are stored into
variable in test scripts. Ddt (Data Driven testing) enables building both positive and negative
test cases into a single test.In Data-driven test automation framework, input data can be stored 
in single or multiple data sources like xls, XML, csv, and databases.
Why?
Frequently we have multiple data sets which we need to run the same tests on. To create an indivi
dual test for each data set is a lengthy and time-consuming process.Data Driven Testing framework 
resolves this problem by keeping the data separate from Functional tests. The same test script can
execute for different combinations of input test data and generate test results.

Advantages:
1.Allows to test application with multiple sets of data values during Regression testing
2.Test data and verification data can be organized in just one file, and it is separate from the test case logic.
3.Base on the tool, it is possible to have the test scripts in a single repository. This makes the 
texts easy to understand, maintain and manage.
4.Actions and Functions can be reused in different tests.
5.Some tools generate test data automatically. This is useful when large volumes of random test 
data are necessary, which helps to save the time.
6.Data-driven testing can perform any phase of the development. A data-driven test cares are 
generally merged in the single process. However, it can be used in multiple test cases.
7.Allows developers and testers to have clear separation for the logic of their test cases/scripts from the test data.
8.The same test cases can be executed several times which helps to reduce test case and scripts.
9.Any changes in the test script do not effect the test data

Disadvantages:
1.A text editor like Notepad is required to create and maintain data files.
2.Quality of the test is depended on the automation skills of the Implementing team
3.Data validation is a time-consuming task when testing large amount of data.
4.Maintenance is a big issue as large amount of coding needed for Data-Driven testing.
5.High-level technical skills are required. A tester may have to learn an entirely new scripting language.
6.There will be more documentation. Mostly related to scripts management tests infrastructure and testing results.

We test functionality with multiple set of data or test a field of data, usually take data from excel
file and use it as a input on a web application , requires looping and based on conditions
we check how many cases are passed or failed and even this information is stored into excel

*/