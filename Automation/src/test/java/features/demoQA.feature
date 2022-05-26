Feature: demoQA booking page


@demoQABook
Scenario Outline: book the book from bookstore
Given User login to demoQA with <Username> and password <password> 
Then User Navigate Back To Store
When User add all the books to collection
Then User enter the <Searchvalue> in search input field
Then Verify only <Bookname> is displayed
When User add gitPocketGuide to collection

Examples:
|Username  |password  |Searchvalue|Bookname					|
|8050302847|Sudha@@143|Git				|Git Pocket Guide |


@NiuliTest1
Scenario: Home page login
Given User is on niuli home page
When User click on language switch 
When User login to application
Then User book an demo


@PortalTest1
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "jin" and password "1234"
Then Home page is populated
And Cards displayed are "true"

@PortalTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "john" and password "4321"
Then Home page is populated
And Cards displayed are "false"

@PortalTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "john" and password "4321"
Then Home page is populated
And Cards displayed are "false"

@PortalTest
Scenario: Home page default login
Given User is on NetBanking landing page
When User sign up with following details
| jenny | abcd | john@abcd.com |Australia | 3242353|
Then Home page is populated
And Cards displayed are "false"



Scenario Outline: Home page default login
Given User is on NetBanking landing page
When User login in to application with <Username> and password <password>
Then Home page is populated
And Cards displayed are "true"

Examples:
|Username |password|
|user1    |pass1   |
|user2    |pass2   |
|user3    |pass3   |
|user4    |pass4   |








