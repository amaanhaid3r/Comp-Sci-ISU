
import java.util.ArrayList;
import java.util.Scanner;

public class AmaansMarketplace {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> plumbing = new ArrayList<>();
        plumbing.add("Toilet Repair - $50/hour");
        plumbing.add("Pipe Repair - $80/hour");

        ArrayList<String> tutoring = new ArrayList<>();
        tutoring.add("Ms Kim Math Help - $40/hour");
        tutoring.add("Ms Rastegar Comp Sci Help - $35/hour");

        ArrayList<String> cleaning = new ArrayList<>();
        cleaning.add("Toilet cleaning - $35/hour");
        cleaning.add("Carpet cleaning - $30/hour");

        ArrayList<String> carpentry = new ArrayList<>();
        carpentry.add("Closet repairs - $25/hour");
        carpentry.add("Door repairs - $20/hour");

        // initializes each of the categories as an arrayList that holds each service
        // two services are already given for each category in case the user does not enter anything

        ArrayList<Double> plumbingPrices = new ArrayList<>();
        plumbingPrices.add(50.0);
        plumbingPrices.add(80.0);

        ArrayList<Double> tutoringPrices = new ArrayList<>();
        tutoringPrices.add(40.0);
        tutoringPrices.add(35.0);

        ArrayList<Double> cleaningPrices = new ArrayList<>();
        cleaningPrices.add(35.0);
        cleaningPrices.add(30.0);

        ArrayList<Double> carpentryPrices = new ArrayList<>();
        carpentryPrices.add(25.0);
        carpentryPrices.add(20.0);

        // makes arrayLists to save the prices of each service
        // the prices of the two services for each category are also added to their corresponding arrayLists

        ArrayList<String> booked = new ArrayList<>();
        // to save booked services

        ArrayList<String> cart = new ArrayList<>();
        // final cart arrayList to show all the services the user has selected

        double FINALtotal = 0.0;
        // this variable is going to store the amount after every service is added to the cart
        // it only prints at the very end of the code when we make the final invoice

        while (true) {
            // entire code in a loop so that the user can go back and forth instead of the entire code only being executed once

            System.out.println("\nWelcome to the Amaan's Marketplace Marketplace! What would you like to do?");
            System.out.println("\n1. Add a Service | 2. Book a service | 3. Remove items from cart | 4. Checkout");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine();
            // basic opening

            if (choice == 1) {
                // first choice is the option to add services

                while (true) {
                    System.out.println("New service chosen. What would you like to name your service");
                    String name = sc.nextLine();

                    System.out.println("\nWhich category does it belong to?");
                    System.out.println("1. Plumbing");
                    System.out.println("2. Tutoring");
                    System.out.println("3. Cleaning");
                    System.out.println("4. Carpentry");

                    System.out.print("\nEnter your choice (1-4): ");
                    int categorychoice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nHow much does this service cost per hour? ");
                    double servicecost = sc.nextDouble();
                    sc.nextLine();

                    String servicetitle = name + " - $" + servicecost + " per hour";
                    // makes a title for the new service added and formats it accordingly, this format is followed until the cart

                    if (categorychoice == 1) {
                        plumbing.add(servicetitle);
                        plumbingPrices.add(servicecost);
                        System.out.println("Your service has been added to plumbing: " + servicetitle);
                    } else if (categorychoice == 2) {
                        tutoring.add(servicetitle);
                        tutoringPrices.add(servicecost);
                        System.out.println("Your service has been added to tutoring: " + servicetitle);
                    } else if (categorychoice == 3) {
                        cleaning.add(servicetitle);
                        cleaningPrices.add(servicecost);
                        System.out.println("Your service has been added to cleaning: " + servicetitle);
                    } else if (categorychoice == 4) {
                        carpentry.add(servicetitle);
                        carpentryPrices.add(servicecost);
                        System.out.println("Your service has been added to carpentry: " + servicetitle);
                    } else {
                        System.out.println("Invalid category. Returning to main menu.");
                        break;
                    }

                    // this entire block adds the provided service title and service cost to whichever category the user wants

                    System.out.print("\nWould you like to add another service? (y/n): ");
                    String again = sc.nextLine();
                    if (!again.equals("y")) {
                        break;
                    }
                }
                // asks the user if they would like to enter any more services, y for yes n for no

            } else if (choice == 2) {
                // second choice is booking a service

                System.out.println("\nChoose a category to browse:");
                System.out.println("1. Plumbing");
                System.out.println("2. Tutoring");
                System.out.println("3. Cleaning");
                System.out.println("4. Carpentry");
                System.out.print("Enter your choice (1-4): ");

                int choice2 = sc.nextInt();

                sc.nextLine();

                if (choice2 == 1) {
                    System.out.println("Plumbing Services:");
                    for (int i = 0; i < plumbing.size(); i++) {
                        String service = plumbing.get(i);
                        if (booked.contains(service)) {
                            System.out.println((i + 1) + ". " + service + " [Fully Booked]");
                        } else {
                            System.out.println((i + 1) + ". " + service);
                        }
                    }

                    System.out.print("Enter the number of the service you'd like to book: ");
                    int serviceNum = sc.nextInt();
                    sc.nextLine();

                    if (serviceNum < 1 || serviceNum > plumbing.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        String chosenservice = plumbing.get(serviceNum - 1);
                        if (booked.contains(chosenservice)) {
                            System.out.println("Sorry, that service is fully booked.");
                        } else {
                            System.out.print("How many hours would you like to book? ");
                            int hours = sc.nextInt();
                            sc.nextLine();

                            double hourlycost = plumbingPrices.get(serviceNum - 1);
                            double total = hourlycost * hours;

                            String cartitem = chosenservice + " - $" + hourlycost + "/hour | " + hours + " hrs | Total: $" + total;
                            cart.add(cartitem);
                            FINALtotal += total;
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }

                } else if (choice2 == 2) {
                    System.out.println("Tutoring Services:");
                    for (int i = 0; i < tutoring.size(); i++) {
                        String service = tutoring.get(i);
                        if (booked.contains(service)) {
                            System.out.println((i + 1) + ". " + service + " [Fully Booked]");
                        } else {
                            System.out.println((i + 1) + ". " + service);
                        }
                    }

                    System.out.print("Enter the number of the service you'd like to book: ");
                    int serviceNum = sc.nextInt();
                    sc.nextLine();

                    if (serviceNum < 1 || serviceNum > tutoring.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        String chosenservice = tutoring.get(serviceNum - 1);
                        if (booked.contains(chosenservice)) {
                            System.out.println("Sorry, that service is fully booked.");
                        } else {
                            System.out.print("How many hours would you like to book? ");
                            int hours = sc.nextInt();
                            sc.nextLine();

                            double hourlycost = tutoringPrices.get(serviceNum - 1);
                            double total = hourlycost * hours;

                            String cartitem = chosenservice + " - $" + hourlycost + "/hour | " + hours + " hrs | Total: $" + total;
                            cart.add(cartitem);
                            FINALtotal += total;
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }

                } else if (choice2 == 3) {
                    System.out.println("Cleaning Services:");
                    for (int i = 0; i < cleaning.size(); i++) {
                        String service = cleaning.get(i);
                        if (booked.contains(service)) {
                            System.out.println((i + 1) + ". " + service + " [Fully Booked]");
                        } else {
                            System.out.println((i + 1) + ". " + service);
                        }
                    }

                    System.out.print("Enter the number of the service you'd like to book: ");
                    int serviceNum = sc.nextInt();
                    sc.nextLine();

                    if (serviceNum < 1 || serviceNum > cleaning.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        String chosenservice = cleaning.get(serviceNum - 1);
                        if (booked.contains(chosenservice)) {
                            System.out.println("Sorry, that service is fully booked.");
                        } else {
                            System.out.print("How many hours would you like to book? ");
                            int hours = sc.nextInt();
                            sc.nextLine();

                            double hourlycost = cleaningPrices.get(serviceNum - 1);
                            double total = hourlycost * hours;

                            String cartitem = chosenservice + " - $" + hourlycost + "/hour | " + hours + " hrs | Total: $" + total;
                            cart.add(cartitem);
                            FINALtotal += total;
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }


                } else if (choice2 == 4) {
                    System.out.println("Carpentry Services:");
                    for (int i = 0; i < carpentry.size(); i++) {
                        String service = carpentry.get(i);
                        System.out.println((i + 1) + ". " + service);
                    }

                    System.out.print("\nEnter the number of the service you'd like to book: ");
                    int serviceNum = sc.nextInt();
                    sc.nextLine();

                    if (serviceNum < 1 || serviceNum > carpentry.size()) {
                        System.out.println("Invalid service number.");
                    } else {
                        String chosenservice = carpentry.get(serviceNum - 1);
                        if (booked.contains(chosenservice)) {
                            System.out.println("Sorry, that service is fully booked.");
                        } else {
                            System.out.print("How many hours would you like to book? ");
                            int hours = sc.nextInt();
                            sc.nextLine();

                            double hourlycost = carpentryPrices.get(serviceNum - 1);
                            double total = hourlycost * hours;

                            String cartitem = chosenservice + " - $" + hourlycost + "/hour | " + hours + " hrs | Total: $" + total;
                            cart.add(cartitem);
                            FINALtotal += total;
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }
                }
            } else if (choice == 3) {
                if (cart.isEmpty()) {
                    System.out.println("Your cart is currently empty.");
                } else {
                    System.out.println("\n=== Current Cart ===");
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println((i + 1) + ". " + cart.get(i));
                    }

                    System.out.println("\nIf you'd like to remove any items, enter the number of the item.");
                    System.out.println("Enter 0 when you're done removing items.");

                    while (true) {
                        int removeNum = sc.nextInt();
                        sc.nextLine();

                        if (removeNum == 0) {
                            break;
                        } else if (removeNum >= 1 && removeNum <= cart.size()) {
                            cart.remove(removeNum - 1);
                            System.out.println("Item removed.");
                        }
                    }

                    System.out.println("\n=== Updated Cart ===");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is now empty.");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.println((i + 1) + ". " + cart.get(i));
                        }
                    }


                }
            } else if (choice == 4) {
                System.out.println("\n---==== Final Invoice ====---");
                for (int i = 0; i < cart.size(); i++) {
                    System.out.println((i + 1) + ". " + cart.get(i));
                }
                System.out.println("\nGrand total: $" + FINALtotal);
                System.out.println("Thank you for using Amaan's Marketplace. have a good day :) !");
                break;
            }
        }
    }
}



