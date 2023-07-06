import java.util.ArrayList;
import java.util.Scanner;

class InventoryItem {
  String name;
  int cost;
  String serialNumber;

  public InventoryItem(String n, int c, String s) {
    name = n;
    cost = c;
    serialNumber = s;
  }
}

class Main {
  public static void main(String[] args) {
    ArrayList<InventoryItem> al = new ArrayList<>();
    al.add(new InventoryItem("Default Item", 0, "000"));

    Scanner scanner = new Scanner(System.in);
    int userInput;

    do {
      System.out.print(Menu());
      userInput = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character after reading the user input

      switch (userInput) {
        case 1:
          System.out.println("Enter the name:");
          String itemName = scanner.nextLine();
          System.out.println("Enter the serial number:");
          String itemSerialNumber = scanner.nextLine();
          System.out.println("Enter the value in dollars (whole number):");
          int itemCost = scanner.nextInt();
          al.add(new InventoryItem(itemName, itemCost, itemSerialNumber));
          break;

        case 2:
          System.out.println("Enter the serial number of the item to delete:");
          String deleteSerialNumber = scanner.next();
          deleteItem(al, deleteSerialNumber);
          break;

        case 3:
          System.out.println("Enter the serial number of the item to update:");
          String updateSerialNumber = scanner.next();
          updateItem(al, updateSerialNumber, scanner); // Pass the scanner object
          break;

        case 4:
          showAllItems(al);
          break;

        case 5:
          break;

        default:
          System.out.println("Please select a correct option.");
      }
    } while (userInput != 5);

    // Close the scanner
    scanner.close();
  }

  static String Menu() {
    return "\nPress 1 to add an item.\nPress 2 to delete an item.\nPress 3 to update an item.\nPress 4 to show all items.\nPress 5 to quit the program.\n";
  }

  static void deleteItem(ArrayList<InventoryItem> itemList, String serialNumber) {
    for (InventoryItem item : itemList) {
      if (item.serialNumber.equals(serialNumber)) {
        itemList.remove(item);
        System.out.println("Item deleted successfully.");
        return;
      }
    }
    System.out.println("Item not found.");
  }

  static void updateItem(ArrayList<InventoryItem> itemList, String serialNumber, Scanner scanner) {
    for (InventoryItem item : itemList) {
      if (item.serialNumber.equals(serialNumber)) {
        // Update the item details
        System.out.println("Enter the new name:");
        String newName = scanner.next();
        System.out.println("Enter the new value in dollars (whole number):");
        int newCost = scanner.nextInt();
        item.name = newName;
        item.cost = newCost;
        System.out.println("Item updated successfully.");
        return;
      }
    }
    System.out.println("Item not found.");
  }

  static void showAllItems(ArrayList<InventoryItem> itemList) {
    // Skip the default item when displaying the inventory
    for (InventoryItem item : itemList) {
      if (!item.name.equals("Default Item")) {
        System.out.print( item.name + ",");
        System.out.print(item.serialNumber + ",");
        System.out.print(item.cost);
        
      }
    }
  }
}
