/**
 * 
 */
/**
 * @author Amul
 *
 */
package Working.with.Keyword.driven.framework;
/*
It is a scripting technique that uses data files to contain the keywords related to the application
being tested. These keywords describe the set of actions that is required to perform a specific step.
A keyword-driven test consists of high and low-level keywords, including the keyword arguments, 
which is composed to describe the action of a test case. It is also called table-driven testing or
action word based testing.
In this, you first identify a set of keywords and then associate an action (or function) related 
to these keywords. Here, every testing action like opening or closing of browser, mouse click, 
keystrokes, etc. is described by a keyword such as openbrowser, click, Typtext and so on.
Each keyword needs to be linked with atleast one command, test scripts or function, which impleme
nt the actions related to that keyword.When test cases are executed, keywords are interpreted by 
a test library, which is called by a test automation framework.
The major activities involved in keyword driven testing are
Step 1. Identifying low level as well as high-level keywords
Step 2. Implementing the keywords as executable
Step 3. Creating test cases
Step 4. Creating the driver scripts
Step 5. Executing the automation test scripts

Advantages of Keyword Driven Testing
1.It allows functional testers to plan test automation before the application is ready
2.Tests can be developed without programming knowledge
3.It is not dependent on a specific programming language or tool
Compatible with any automation tools available in the market
In this framework divide the test case into 4 parts
1. step no  	2.description		3.keyword		4.run mode

 */