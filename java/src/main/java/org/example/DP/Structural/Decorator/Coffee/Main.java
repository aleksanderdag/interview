package org.example.DP.Structural.Decorator.Coffee;

import static org.example.DP.Structural.Decorator.Coffee.Coffee.SimpleCoffee;

/**
 * <p>
 * Decorator is meant to prevent class explosion by allowing any combination by wrapping.
 * This is done by having a wrapper class act as a "pass-though" -
 * that is why an abstract class MUST be used instead of an interface for the decorator,
 * else all pass through logic would be dupped for all wrappers.
 * The wrapper can also add functionality not found in simple class.
 * Additionally, an interface is introduced to share functionality across simple class and wrappers
 * This is to allow the wrappers to be passed into root wrapper, but other, more complex, solutions  can solve this:
 * <p>
 * Ex:
 * simple -AsSimple-> wrapperAdapter -AsInterface-> wrapperDecorator
 * <p>
 * Instead of:
 * simple -AsInterface-> wrapperDecorator
 * <p>
 * Decorators are great only when the changing logic is isolated to wrapper and unpredictable.
 * Issues arise if order of wrappers matters and interactivity between wrappers matter.
 * Aggregation in simple class would avoid this issue via passing List<AddOns>.
 * <p>
 * Decorators may have great use for deprecation of old functionality:
 * classV1 -> classV2 [pass through] -> oldUses
 * classV2 -> newUses
 * Is this really Decorator though vs Adapter?
 * <p>
 * Multiple Decorators can be used on a simple or decorator class to make a bottom-up tree. [like inheritance]
 */
public class Main {
    public static void main(String[] args) {
        Coffee c = SimpleCoffee;
        printInfo(c);
        c = new WithMilk(c);
        printInfo(c);
        c = new WithSprinkles(c);
        printInfo(c);
    }

    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }
}
