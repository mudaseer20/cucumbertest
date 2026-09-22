Feature: Validate home page in lamps


      
      
@staging
  Scenario: Validate home page is correct
  Given user launches the browser
    Given user in home page "https://kapoorlampshades.com" for kapoor lamps
    When user validates the text in the menu items
    |  Chandeliers |
    |Wall Lights |
|Pendant Lights |
|Lamps  |
|Ceiling Lights  |
|Lamp Shades  |
|Outdoor Lights |
|Lantern Lights |
|Clearance Sale  |
Then user clicks on clearance sale
Then user validates the text is "Sale"
Then user scrolls till the last
Then user validates count of bulb
Then user clicks on chandeliers
Then user validates the text is "CHANDELIERS"
Then user scrolls till the last
Then user validates count of bulb
Then user clicks on outdoor lights
Then user validates the text is "OUTDOOR LIGHTS"
Then user scrolls till the last
Then user validates count of bulb
Then actor enters the text "Lamp Shades" in the searchbox
Then actor clicks on enter button
Then user validate text "Price, low to high"
Then user scrolls till the last
Then user gets the text and stores in an array
Then user clicks on clearance sale
Then user validates the text is "Sale"

              

