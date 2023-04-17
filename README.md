# Group 7 - Car Buying and renting Web Application


#cicd pipeline

There are total four stages.

1) build :
   In the build stage whole springboot application is built at shared runner.

2) test :
   In the test stage all test created using JUnit runs.

3) prod deploy :
   In prod deploy only main branch is deployed to the heroku server.

4) test deploy :
   In test deploy every branch except main is deployed to the heroku server.
