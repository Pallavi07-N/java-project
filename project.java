{
            System.out.println("\n-- Menu --");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Transfer Money");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> System.out.println("Current Balance: ₹" + currentUser.balance);
                case 2 -> {
                    System.out.print("Enter deposit amount: ₹");
                    double amount = sc.nextDouble();
                    currentUser.deposit(amount);
                }
                case 3 -> {
                    System.out.print("Enter withdraw amount: ₹");
                    double amount = sc.nextDouble();
                    if (!currentUser.withdraw(amount)) {
                        System.out.println("Insufficient balance!");
                    }
                }
                case 4 -> currentUser.printTransactions();
                case 5 -> {
                    System.out.print("Enter recipient username: ");
                    String toUser = sc.nextLine();
                    if (!users.containsKey(toUser)) {
                        System.out.println("Recipient not found!");
                        break;
                    }
                    if (toUser.equals(currentUser.username)) {
                        System.out.println("You can't send money to yourself.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ₹");
                    double amount = sc.nextDouble();
                    if (currentUser.sendTransfer(users.get(toUser), amount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed due to insufficient funds.");
                    }
                }
                case 6 -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }