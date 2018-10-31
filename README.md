# QA tech test

This is a test framework implemented to test the backend api's using Cucumber BDD and Java.
This has a basic maven sure fire reporting feature.

Feature files: `src/test/resources/`

# Pre-requisite
The Sensyne mock API server should be up and running on `http://localhost:5000/v1`

# Running the tests
These tests can be run from terminal with the following commands:

`mvn dependency:resolve`
`mvn install`
 
 These tests can also be run from intelliJ
 
 -Simply run the junit runner file `RunTest.java`
 
After running the tests, test report can be found at `target/surefire-reports/RunTest.txt`
 
# Scenario 1
Get the products available on the server

# Scenario 2
Add a product and  verify if it was added

# Scenario 3
Update an existing product and verify if it was updated

# Scenario 4
Delete an existing product and verify if it was deleted


