Feature: Login into qaclikacademy

Scenario Outline: Positive test validating login
Given initialize the browser with chrome
And navigate to "http://www.qaclickacademy.com/" website
And click on the sign in to get into sign in page
When user logs in by providing random username <username> and password <password> 
Then verify that user successfully logs in or not then click on forgot password


Examples:
|username								|password				|
|someone@example.com		|password123		|
|someone23@example.com	|password121		|
