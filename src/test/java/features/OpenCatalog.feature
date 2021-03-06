Feature: To ensure search is working fine

  As a user
  I want to get desired search results
  So that business goal will be executed

  Scenario Outline: Verify search results are correct

    Given user is on main page and goes to menu section <section>
    When user selects category <category> and subcategory <subcategory> and subcategory item <item>
    And sets min <min> diagonal
    And sets max <max> diagonal
    And sets brand <brand>
    And sets price <price>
    And sets resolution <resolution>
    Then search result matches desired brand <brand>
    * search result matches desired price <price>
    * search result matches desired resolution <resolution>
    * search result matches desired diagonal from <min> to <max>

    Examples:
      | section | category    | subcategory | item       | min | max | brand   | price | resolution          |
      | Каталог | Электроника | Телевидение | Телевизоры | 40" | 50" | Samsung | 1000  | 1920x1080 (Full HD) |
