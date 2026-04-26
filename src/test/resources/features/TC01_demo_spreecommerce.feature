Feature: Test Spree Ecommerce Sign up, Login and Adding to cart, Checkout

  @Smoke
  Scenario: User validate E2E Sign up, Login and Adding to cart, Checkout
    Given the user is on the Spree Store home page
    When the user clicks the Account icon in the top menu bar
    Then the user is navigated to the Account Login page
    When the user clicks the Sign Up link
    # SIGN UP
    Then the user is navigated to the Create Account page
    When the user create a new account:
      | field            | value            |
      | first name       | Pixie            |
      | last name        | Dust             |
      | email            | <auto.generated> |
      | password         | P!xie001122      |
      | confirm password | P!xie001122      |
    Then the user is navigated to the Account Overview page
    When the user sign out from the page
    Then the user is navigated to the Account Login page
    When the user sign in back using the new account created
    Then the user is navigated to the Account Overview page
    # BROWSER PRODUCT
    When the user clicks the Hamburger top menu icon in the top menu bar
    When the user clicks the All Products menu in the side menu bar
    Then the user is navigated to the All Products page
    When the user clicks the Product "Automatic Espresso Machine"
    Then the user is able to see the product details:
      | field        | value                                                                                                                                                                                                      |
      | product name | Automatic Espresso Machine                                                                                                                                                                                 |
      | price        | $879.99                                                                                                                                                                                                    |
      | description  | Fully automatic bean-to-cup espresso machine with ceramic grinder, 15-bar pressure system, and intuitive touch display. Delivers barista-quality espresso, cappuccino, and latte at the touch of a button. |
    # ADD TO CART
    When the user click Add To Cart button
    When the user click View Cart
    # VALIDATE SHOPPING CART
    Then the user is navigated to the Shopping Cart page
    Then the user validates the shopping cart details:
      | field        | value                      |
      | product name | Automatic Espresso Machine |
      | price        | $879.99                    |
      | quantity     | 1                          |
    # PROCEED TO CHECKOUT
    When the user click Proceed To Checkout
    Then the user is navigated to the Checkout page
    When the user fill the shipping address details:
      | field           | value              |
      | country         | United States      |
      | address         | 401 Seaward Rd #17 |
      | city            | Lakers             |
      | state/province  | California         |
      | zip/postal code | 92625              |
      | phone           | 213-555-0123       |
    When the user select the Shipping Method as Premium
    When the user select the Payment Method as Credit Card
    When the user fill the Credit Card details:
      | field           | value            |
      | card number     | 4000002500001001 |
      | expiration date | 01/30            |
      | security code   | 123              |
      | country         | Singapore        |
    When the user click Pay Now
    # VALIDATE ORDER CONFIRMATION
    Then the user is able to see Order Confirmation and Order Number
    Then the user validates the Order Items details:
      | field        | value                      |
      | product name | Automatic Espresso Machine |
      | quantity     | 1                          |
      | subtotal     | $879.99                    |
      | shipping     | $9.50                      |
      | tax          | $88.00                     |
      | total        | $977.49                    |
