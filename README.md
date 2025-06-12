VARIABLE NAMES:
- Scanner sc – Used throughout the entire program to take user input.
- ArrayList<String> plumbing / tutoring / cleaning / carpentry – Hold the service descriptions for each category; used when displaying and booking services.
- ArrayList<Double> plumbingPrices / tutoringPrices / cleaningPrices / carpentryPrices – Store the hourly cost of each corresponding service, used when calculating totals during booking.
- ArrayList<String> booked – Tracks which services have already been booked so users can’t double-book them.
- ArrayList<String> cart – Stores all booked service entries to be displayed during cart review and checkout.
- double FINALtotal – Cumulative total cost of all services in the cart, updated every time a service is booked and printed at checkout.
- int choice – Stores the user’s main menu selection (Add, Book, Remove, Checkout). Uused in the main while loop to decide program flow.
- int choice2 – Stores the category selection when booking a service (Plumbing, Tutoring, etc.). Used to direct which service list to show and process
