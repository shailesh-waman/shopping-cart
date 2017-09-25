#####STORY 1: Add a product to the shopping cart.

*Given* -
Empty shopping cart
Product - Dove Soap; Unit price - 30

*When* -
User adds 5 Dove Soaps in the shopping cart.

*Then* -
Shopping Cart contains 5 Dove Soaps of unit price 30.
Shopping Cart's total price is 150.



#####STORY 2: Add multiple products to the shopping cart
*Given* -
Empty shopping cart
Product - Dove Soap; Unit price – 30;
Product - Axe Deo; Unit price – 100;

*When* -
User adds 3 Dove Soaps in the Shopping Cart.
And user adds 2 Axe Deo in the Shopping Cart.

*Then* -
Shopping Cart contains 3 Dove Soaps of unit price 30.
Shopping Cart contains 2 Axe Deo of unit price 100.
Shopping Cart's total price is 290.



#####STORY 3: Add products to the shopping cart, which have "Buy X, Get Y free" offer.

*Given* -
Empty shopping cart
Product - Dove Soap; Unit price – 30; Offer – Buy 2 Get 1 free.
Product - Axe Deo; Unit price – 100; No Offer.

*When* -
User adds 3 Dove Soaps in the Shopping Cart.

*Then* -
Shopping Cart contains 3 Dove Soaps of unit price 30.
Discount – 30
Shopping Cart’s total price is 60.

*When* -
User adds 5 Dove Soaps in the Shopping Cart.

*Then* -
Shopping Cart contains 5 Dove Soaps of unit price 30.
Discount – 30
Shopping Cart’s total price is 120.

*When* -
User adds 3 Dove Soaps in the Shopping Cart.
User adds 2 Axe Deos in the Shopping Cart.

*Then* -
Shopping Cart contains 3 Dove Soaps of unit price 30 and 2 Axe Deos of unit price 100.
Discount – 30
Shopping Cart’s total price is 260.
