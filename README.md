# Online Pizza Ordering

This is a basic web application to handle online orders of a restaurant that sells pizzas. It is made using Java servlets. The web pages handle the customer end and the restaurant manager end, so we have separate
servlets handling the two categories of user profiles as described below.

## Customer View:

Customers could create a new order or track their placed order. So the first page should
provide the user with these two options.

* <b>For Option: Create new order</b>
	On creating a new order the system generates an order id which the user would use to
	track the placed order in future.
	Once the id is generated and displayed to the user, he/she is displayed a menu containing about 4 varieties of pizzas with 3 sizes available. The user can select the items required and input the quantity of each(set default to 1).
	On clicking submit, the webpage navigates to another form asking the user to enter
	his name, contact number and address as mandatory fields.	
	On entering the personal details the user can navigate to the tracking page of
	his/her order indicating the progress till Order Placed.
	States possible(transition possible in the same order): Order Placed, Preparation, Bake,
	Quality Check, Out for delivery, Delivered
* <b>For Option: Track my order</b>
	Customer is prompted to enter the order id. On submitting it, the webpage
	displaying the progress with the stage is displayed.

## Restaurant Managerial view:

The user is able to view all the pending(undelivered) orders and their state in
tabular form, with an update button corresponding to each row. On clicking the update, the
order the stage of that order should increment to the next stage.

## System:
The system maintains the status of every order at the backend( in a file) to be
able to update and track the current status.