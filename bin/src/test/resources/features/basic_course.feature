Feature: Tatoc basic course Feature

Scenario: Tatoc basic course Scenario

Given User is already on basic course page
When Title of first page is Tatoc
Then click on basic course 
Then user is on Grid Gate page

Scenario: Tatoc Green box Scenario

Given User is already on grid gate page
When Title of page is Grid Gate
Then Click on green box 
Then user is on Frame Dungeon page

Scenario: Totoc Box 1 and Box 2 Scenario

Given User is already on Frame Dungeon page
When Title of page is Frame Dungeon
Then Click on repaint Repaint box 2 then proceed
Then User is on Drag Around page

Scenario: Tatoc Drag and drop Scenario

Given User is already on drag and drop box
When Title of the page is Drag Around
Then Drag the box and release in drop box
Then Click on proceed
Then User is on Popup Windows

Scenario: Tatoc Popup Window Scenario

Given User is already on Popup window page
When Title of the page is Popup Window 
Then Click on Launch popup Window and Enter the name and click on Submit
Then Click on Proceed
Then User is on Cookie Handling page 

Scenario: Tatoc Cookie Handling Scenarios

Given User is already on Cookie Handling page 
When Title of the page is Cookie Handling 
Then Click on Generate Token
Then Copy token and click on proceed
Then User is on End page 

