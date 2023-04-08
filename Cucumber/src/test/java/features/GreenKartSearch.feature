Feature: Search products and validate name

Scenario: Search
Given User is on the greenkart landing page
When User searched with shortname "tom" and extract full name of the product
And User clicks on top deals link
And User search for the same shortname "tom" in offers page to check if product exists
Then User validate product name in offer page matches with search page
