package com.techelevator;

import java.util.List;

public class Menu {
    private final List<String> menuOptions;
    private final String promptSelection;

     public Menu(List<String> menuOptions, String promptSelection) {
         this.menuOptions = menuOptions;
         this.promptSelection = promptSelection;
     }

    public void print() {
        System.out.println(promptSelection);
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + menuOptions.get(i));
        }
        System.out.print("Option: ");
    }


}
