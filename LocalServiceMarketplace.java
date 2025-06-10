
import java.util.ArrayList;
import java.util.Scanner;

public class LocalServiceMarketplace {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> plumbing = new ArrayList<>();
        ArrayList<String> tutoring = new ArrayList<>();
        ArrayList<String> cleaning = new ArrayList<>();
        ArrayList<String> carpentry = new ArrayList<>();

        // initializes each of the categories as an arrayList that holds each service

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

        plumbing.add("Toilet Repair - $50/hour");
        plumbing.add("Pipe Repair - $80/hour");

        tutoring.add("Ms Kim Math Help - $40/hour");
        tutoring.add("Ms Rastegar Comp Sci Help - $35/hour");

        cleaning.add("Toilet cleaning - $35/hour");
        cleaning.add("Carpet cleaning - $30/hour");

        carpentry.add("Closet repairs - $25/hour");
        carpentry.add("Door repairs - $20/hour");

        // starts the code with 2 services already available for each category

        while (true) {
            System.out.println("Welcome to the Amaan's Marketplace Marketplace! What would you like to do?"); //
            System.out.println("1. Add a Service | 2. Book a service | 3. View Cart & Checkout | 4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                while (true) {
                    System.out.println("New service chosen. What would you like to name your service");
                    String name = sc.nextLine();

                    System.out.println("Which category does it belong to?");
                    System.out.println("1. Plumbing");
                    System.out.println("2. Tutoring");
                    System.out.println("3. Cleaning");
                    System.out.println("4. Carpentry");

                    System.out.print("Enter your choice (1-4): ");
                    int categorychoice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("How much does this service cost per hour? ");
                    double servicecost = sc.nextDouble();
                    sc.nextLine();

                    String servicetitle = name + " - $" + servicecost + " per hour";

                    if (categorychoice == 1) {
                        plumbing.add(servicetitle);
                        System.out.println("Your service has been added to plumbing: " + servicetitle);
                    } else if (categorychoice == 2) {
                        tutoring.add(servicetitle);
                        System.out.println("Your service has been added to tutoring: " + servicetitle);
                    } else if (categorychoice == 3) {
                        cleaning.add(servicetitle);
                        System.out.println("Your service has been added to cleaning: " + servicetitle);
                    } else if (categorychoice == 4) {
                        carpentry.add(servicetitle);
                        System.out.println("Your service has been added to carpentry: " + servicetitle);
                    } else {
                        System.out.println("Invalid category. Returning to main menu.");
                        break;
                    }

                    System.out.print("Would you like to add another service? (y/n): ");
                    String again = sc.nextLine().toLowerCase();
                    if (!again.equals("y")) {
                        break;
                    }
                }

            } else if (choice == 2) {
                System.out.println("Choose a category to browse:");
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
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }


                } else if (choice2 == 4) {
                    System.out.println("\nCarpentry Services:");
                    for (int i = 0; i < carpentry.size(); i++) {
                        String service = carpentry.get(i);
                        System.out.println((i + 1) + ". " + service);
                    }

                    System.out.print("Enter the number of the service you'd like to book: ");
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
                            booked.add(chosenservice);

                            System.out.println("Added to cart: " + cartitem);
                        }
                    }

                } else {
                    System.out.println("Invalid category. Returning to main menu.");
                }
            } else if (choice == 3) {
                System.out.println("Final Checkout Summary:");
                for (String item : cart) {
                    System.out.println("- " + item);
                }
                System.out.println("Thank you for booking with Amaan's Marketplace!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            sc.close();

        }
    }
}

