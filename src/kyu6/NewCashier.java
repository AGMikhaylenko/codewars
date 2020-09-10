package kyu6;

/**
 * Some new cashiers started to work at your restaurant.
 * They are good at taking orders, but they don't know how to capitalize words, or use a space bar!
 * All the orders they create look something like this:
 * "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"
 * The kitchen staff are threatening to quit, because of how difficult it is to read the orders.
 * Their preference is to get the orders as a nice clean string with spaces and capitals like so:
 * "Burger Fries Chicken Pizza Pizza Pizza Sandwich Milkshake Milkshake Coke"
 * The kitchen staff expect the items to be in the same order as they appear in the menu.
 */
public class NewCashier {

    public static void main(String[] args) {
        System.out.println(getOrder("milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"));
        System.out.println(getOrder("pizzachickenfriesburgercokemilkshakefriessandwich"));
    }

      //Медленный способ
//    public static String getOrder(String input) {
//        if ("".equals(input) || input == null)
//            return "";
//
//        String[] menuItems = new String[]{"Burger", "Fries", "Chicken", "Pizza", "Sandwich",
//                "Onionrings", "Milkshake", "Coke"};
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < menuItems.length && !"".equals(input); i++) {
//            String lower = menuItems[i].toLowerCase();
//            while (input.indexOf(lower) != -1) {
//                sb.append(menuItems[i] + " ");
//                input = input.replaceFirst(lower,"");
//            }
//        }
//        return sb.toString().trim();
//    }

    public static String getOrder(String input) {
        if ("".equals(input) || input == null)
            return "";

        String[] menuItems = new String[]{"Burger", "Fries", "Chicken", "Pizza", "Sandwich",
                "Onionrings", "Milkshake", "Coke"};

        //Массив из первых 4-х букв
        String[] itemFourBook = new String[menuItems.length];
        for (int i = 0; i < menuItems.length; i++)
            itemFourBook[i] = menuItems[i].toLowerCase().substring(0, 4);

        StringBuilder[] sbArray = new StringBuilder[menuItems.length];

        for (int i = 0; i < sbArray.length; i++)
            sbArray[i] = new StringBuilder();

        while (!"".equals(input)) {
            String first = input.substring(0, 4);
            for (int i = 0; i < itemFourBook.length; i++) {
                if (first.equals(itemFourBook[i])) {
                    sbArray[i].append(menuItems[i] + " ");
                    input = input.replaceFirst(menuItems[i].toLowerCase(), "");
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbArray.length; i++) {
            if(!"".equals(sbArray[i].toString())) {
                res.append(sbArray[i].toString().trim());
                res.append(" ");
            }
        }

        return res.toString().trim();
    }
}
