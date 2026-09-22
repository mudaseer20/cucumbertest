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
   