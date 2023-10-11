# Ecommerce_PlaceOrder_Automation
-----------------------------------------------
This project is to test an e-commerce site where user can place order on online.
-------------------------------------------------------------------------------
This is a maven project, so you will get all dependencies in pom.xml file.
------------------------------------------------------------------------------
To run this project, please run PlaceOrder.xml file in src/test/java folder
------------------------------------------------------------------------------
There are six test cases:
a) Verify Home Page Visibility, b) Verify Cart Page, c) Verify Sign Up Page, d) Verify Sign In Page, e) Verify Address Details and Order Details, f) Verify Place Order Successful Message

To automate these six test cases, I have created six corresponding classes named:
a) HomePageVisibility    b) CartPageDisplay   c) SignUpPage   d) SignInPage   e) ReviewAddressAndOrderDetails   f) PlaceOrderSuccessfulMessage
these each class automates corresponding each test cases mentioned above.

There are another two classes named:
g) EcommerceProducts_PageObjects  (this is page object model for Product page)
h) BrowserLaunchClose (this is parent class inherited by all six child classes mentioned above)

To verify each test cases, each time browser will launch, verify cases and then close the browser.





