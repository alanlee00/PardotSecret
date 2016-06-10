# PardotSecret
This is the solution for the Salesforce-Pardot secret() function problem

To run an example of this project, please locate the "secret()" function; currently it is set to 2x + 1, which is not additive. 
This "secret()" function can be changed to suit the user's tastes, but will ultimately be tested for the condition of additivity.

When run, the application will ask for an integer greater than one. If an integer greater than one is supplied, the application will quickly generate a list of prime numbers less than the supplied value. If not, it will ask the user to try again.

Once the list of prime numbers has been generated, the application will begin the test of additivity by applying the formula:

secret(x+y) = secret(x) + secret(y)

for all values of x and y, with x and y being prime numbers generated in the previously mentioned list. If at any point the values on either side of the equals sign do not coincide, the application will conclude that the "secret()" function specified by the user is not additive. Otherwise, if it runs to completion through the generated list of prime numbers, the application will conclude that the "secret()" function specified by the user is additive.

As examples that can be run:

int secret = (valueToSecret * 2) + 1; ** (2x + 1) Not additive

int secret = (valueToSecret * 4);     ** (4x) Additive
