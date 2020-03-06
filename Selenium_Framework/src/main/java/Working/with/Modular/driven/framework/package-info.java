/**
 * 
 */
/**
 * @author Amul
 *
 */
package Working.with.Modular.driven.framework;

/*
The framework divides the entire “Application Under Test” into a number of logical and isolated 
modules. For each module, we create a separate and independent test script. Thus, when these test 
scripts took together builds a larger test script representing more than one modules.
These modules are separated by an abstraction layer in such a way that the changes made in the 
sections of the application doesn’t yield affects on this module.

Modular frameworks divides the test scripts into small modules where modules are small scripts 
written to perform certain tasks. Modules interact with each other in a hierarchical fashion to
form a big script which aims at doing a certain test run. Modular framework is like creation of 
small, independent scripts that represents modules, sections and functions of the application 
under test.
Testers use Modular testing framework to divide an  application into multiple modules and create 
test scripts individually. These individual test scripts can be combined to make larger test scripts
by using a master script to achieve the required scenarios. This master script is used to invoke 
the individual modules to run end to end test scenarios. In this framework, testers write function
libraries to use it whenever required.

Pros:
1.The framework introduces the high level of modularization which leads to easier and cost-efficient maintenance.
2.The framework is pretty much scalable
3.If the changes are implemented in one part of the application, only the test script representing
that part of the application needs to be fixed to leave all the other parts untouched.
Cons:
1.While implementing test scripts for each module separately, we embed the test data (Data with 
which we are supposed to perform testing) into the test scripts. Thus, whenever we are supposed 
to test with a different set of test data, it requires the manipulations to be made in the test 
scripts.
*/
