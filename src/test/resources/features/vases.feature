Feature: Validate home page in vases


        
@staging
  Scenario: Validate home page is correct
  Given user launches the browser
    Given user in home page "https://fabcuro.com/collections/vases" for kapoor lamps
   Then user validate text is "Vases"
   Then user clicks on Gifts
   Then user validate text is "Gifting"  
   Then get the text of prices
   Then get the text of vases
   Then validate the links of gifts for "href"
   Then validate the links of gifts for "id"
   Then get the text of categories
   #Then user clicks on checkbox for "Bowls"
   #Then user clicks on "Remove all" button
   #Then user clicks on checkbox for "Decor"
   #Then user clicks on "Remove all" button
   #Then user clicks on checkbox for "Cake Stands"
   #Then user clicks on "Remove all" button
   Then user clicks on checkbox for "Bowls"
   Then user clicks on choose options
   Then user validates the colors for "value"
  | Clear + Gold |
  |Clear + Bronze|
  | Purple + Gold|
   
                        
  Then user clicks on color option
  Then user gets the price
  Then user clicks on click cart
  Then user clicks on view cart
  Then user gets the price in cart
   