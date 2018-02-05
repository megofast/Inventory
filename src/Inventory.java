import java.util.Scanner;

public class Inventory {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int selection = 0;
        int ingredient_choice = 0;
        boolean loop = false;
        boolean mainLoop = true;

        Object ingredients[][] = new Object[5][2];
        ingredients[0][0] = "Ice Cream";
        ingredients[1][0] = "Sprinkles";
        ingredients[2][0] = "Chocolate Syrup";
        ingredients[3][0] = "Caramel Syrup";
        ingredients[4][0] = "Cherries";

        // Set the initial inventory values to 10
        for (x = 0; x < 5; x++) {
            ingredients[x][1] = 10;
        }

        mLoop:
        do {
            do {
                System.out.println("Please make a selection of your inventory items.");
                for (x = 0; x < 5; x++) {
                    System.out.printf("%3.3s %-20.20s  %-20.20s%n", x + ".", ingredients[x][0], ingredients[x][1]);
                }
                System.out.printf("%3.3s %-20.20s%n", "5.", "Exit");
                System.out.print("Selection: ");

                try {
                    ingredient_choice = Integer.valueOf(scanner.next());
                } catch (Exception e) {
                    ingredient_choice = 6;
                    loop = true;
                }

                if (ingredient_choice < 0 || ingredient_choice > 5) {
                    System.out.println("Invalid entry, please try again.");
                    loop = true;
                } else if (ingredient_choice >= 0 && ingredient_choice <= 5) {
                    loop = false;
                    if (ingredient_choice == 5) {
                        mainLoop = false;
                        break mLoop;
                    }
                }
            } while (loop == true);

            do {
                System.out.println("Options for " + ingredients[ingredient_choice][0]);
                System.out.println("1. Add Inventory");
                System.out.println("2. Remove Inventory");
                System.out.println("3. Back to Main Menu");
                System.out.print("Selection: ");

                try {
                    selection = Integer.valueOf(scanner.next());
                } catch (Exception e) {
                    selection = 0;
                    loop = true;
                }

                if (selection < 1 || selection > 3) {
                    System.out.println("Invalid selection, please try again.");
                    loop = true;
                } else {
                    loop = false;
                    switch (selection) {
                        case 1:
                            add(ingredient_choice, ingredients, scanner);
                            break;
                        case 2:
                            subtract(ingredient_choice, ingredients, scanner);
                            break;
                        case 3:
                            loop = false;
                            break;
                        default:
                            System.out.println("Error, invalid selection, try again.");
                            loop = true;
                    }
                }
            } while (loop == true);
        } while (mainLoop == true);
    }

    public static void add(int inventory_index, Object ingredients[][], Scanner scan) {
        int amount = 0;
        int total;
        boolean loop = false;

        do {
            System.out.print("How much would you like to add: ");

            try {
                amount = Integer.valueOf(scan.next());
                loop = false;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                loop = true;
            }
        } while (loop == true);

        total = (Integer)ingredients[inventory_index][1] + amount;
        System.out.println(ingredients[inventory_index][0] + "..... (Old)" + ingredients[inventory_index][1] + " + " + amount + " = (New)" + total);
        ingredients[inventory_index][1] = total;
    }

    public static void subtract(int inventory_index, Object ingredients[][], Scanner scan) {
        int amount = 0;
        int total = 0;
        boolean loop = false;

        do {
            System.out.print("How much would you like to subtract: ");

            try {
                amount = Integer.valueOf(scan.next());
                loop = false;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                loop = true;
            }
        } while (loop == true);

        total = (Integer)ingredients[inventory_index][1] - amount;
        if (total < 0) {
            ingredients[inventory_index][1] = 0;
            System.out.println("Cannot have negative inventory, automatically set to 0.");
        } else {
            System.out.println(ingredients[inventory_index][0] + "..... (Old)" + ingredients[inventory_index][1] + " - " + amount + " = (New)" + total);
            ingredients[inventory_index][1] = total;
        }
    }

    public void search() {
        
    }
}
