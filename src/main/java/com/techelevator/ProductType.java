package com.techelevator;

public enum ProductType {
    DRINK("Glug Glug, Yum!", "Drink"),
    CANDY("Munch Munch, Yum!", "Candy"),
    CHIP("Crunch Crunch, Yum!", "Chip"),
    GUM("Chew Chew, Yum!", "Gum");

  private String message;
  private String name;

    ProductType(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public static ProductType fromName(String name){   //For larger list of products could use Map
        for (var each : ProductType.values()) {
            if (each.name.equals(name)) {
                return each;
            }
        }
        throw new IllegalArgumentException(name + " is not a valid ProductType");

    }
}
