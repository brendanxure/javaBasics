import AbstractClasses.*;


public class Main {
    public static void main(String[] args) {
        testItems();
        testItemOwner();
        testLevelled();
    }

    static void testItems() {
        FoodItem apple = new FoodItem("a shiny apple", 2);
        Sword sword = new Sword("a mighty sword", 50);
        InventoryItem item = new Sword("a cultlass", 25);

        testItemActions((apple));
        testItemActions(sword);
        testItemActions(item);
    }

    static void testItemActions(InventoryItem item) {
        int usage = 0; // sum the return values of .useItem()
        // Show some information about the item
        System.out.println("Testing Actions with " + item.getName());
        System.out.println("Item is a " + item.getClass());
        // Is the item a InventoryItem? (should always be true)
        System.out.println("Is item an instance of InventoryItem? "
                + (item instanceof InventoryItem));
        // Is the item a Sword (not always true).
        System.out.println("Is item an instance of Sword? "
                + (item instanceof Sword));
        pause();

        // Perform actions
        System.out.println("\nReadying...");
        item.readyItem();
        System.out.println("\nStoring from Ready...");
        item.storeItem();
        System.out.println("\nStoring from Stored...");
        item.storeItem();
        pause();
        System.out.println("\nReadying from Stored...");
        item.readyItem();
        System.out.println("\nReadying from Ready...");
        item.readyItem();
        System.out.println("\nUse from Ready...");
        usage += item.useItem();
        pause();
        System.out.println("\nUse from Using...");
        usage += item.useItem();
        System.out.println("\nStore from Using...");
        item.storeItem();
        System.out.println("\nUse from Stored...");
        usage += item.useItem();
        pause();

        // Display the total usage resulting from performing the actions.
        System.out.format("\nItem usage totalled: %d.\n\n", usage);
    }
    static void testItemOwner() {
        // Create a new player
        Player blago = new Player("Blago Blagoson");

        // Create a variety of InventoryItems
        FoodItem apple = new FoodItem("a shiny apple", 2);
        FoodItem jerky = new FoodItem("some vegan jerky", 10);
        FoodItem sandwich = new FoodItem("a sandwich", 15);
        Sword sword = new Sword("a mighty sword", 50);
        Sword cutlass = new Sword("a cutlass", 25);

        // Player takes ownership of some items
        blago.takeOwnership(apple);
        blago.takeOwnership(jerky);
//        blago.takeOwnership(jerky); // throws exception - already owned!

        // Show player inventory
        blago.showInventory();

        // Create a new armoury
        Armoury armoury = new Armoury();

        // Assign ownership of some items to the ramoury
//        armoury.takeOwnership(sandwich); // throws an exception - only weapons in an armoury!
        armoury.takeOwnership(sword);
        armoury.takeOwnership(cutlass);

        // Show the contents of the armoury
        System.out.println("\nThe Armoury contains:");
        System.out.println(armoury);
        pause();

        // Relinquish ownership of an item
//        blago.relinquishOwnership(sword); // throws an exception
        // change ownership of an item in the armoury to the player
        System.out.println("\nPlayer takes the first weapon from the Armoury.\n");
        blago.takeOwnership(armoury.relinquishOwnership(armoury.get(0)));

        // Show the player inventory
        blago.showInventory();

        // Show the contents of the armoury
        System.out.println("\nNow the Armoury contains:");
        System.out.println(armoury);
    }

    static void testLevelled() {
        // Create a new player
        Player blago = new Player("Blago Blagoson");
        // show the player name
        System.out.println(blago.getPlayerName());

        // level up the player and show player name
        blago.levelUp();
        System.out.println(blago.getPlayerName());

        // level up the player and show player name again
        blago.levelUp();
        System.out.println(blago.getPlayerName());

        // create a magic sword
        MagicSword theMagicSword = new MagicSword("The Magic Sword of Ones & Zeros", 100);

        // assign the magic sword to player
        blago.takeOwnership(theMagicSword);

        // use the magic sword
        blago.myInventory.get(0).readyItem();
        blago.myInventory.get(0).useItem();

        // level up the magic sword x 2 and use it
        ((MagicSword) blago.myInventory.get(0)).levelUp();
        theMagicSword.levelUp();
        blago.myInventory.get(0).useItem();

        // show player inventory
        System.out.println("");
        blago.showInventory();
    }

    static void pause() {
        System.out.print("\nPress \'ENTER\' to continue... ");
        (new java.util.Scanner(System.in)).nextLine();
        System.out.println("");
    }
}