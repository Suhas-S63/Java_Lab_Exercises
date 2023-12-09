// Abstract class representing a Robber
abstract class Robber {
    // Method to print information about the class
    public void robbingClass() {
        System.out.println("MScAIML");
    }

    // Abstract methods to be implemented by subclasses
    public abstract int rowHouses(int[] houses);
    public abstract int roundHouses(int[] houses);
    public abstract int squareHouse(int[] houses);
    public abstract int rectangleHouses(int[] houses);

    // Constructor for the Robber class
    public Robber() {
        System.out.println("MScAI&ML");
    }

    // Method to express love for Machine Learning
    public void machineLearning() {
        System.out.println("I Love Machine Learning");
    }
}

// Subclass JavaProfessionalRobbery extending the Robber class
class JavaProfessionalRobbery extends Robber {
    // Implementation of squareHouse method
    @Override
    public int squareHouse(int[] houses) {
        return common(houses);
    }

    // Implementation of rowHouses method
    @Override
    public int rowHouses(int[] houses) {
        // Return the maximum value between common(houses) and sum of the first and last elements
        return common(houses) > houses[0] + houses[3] ? common(houses) : houses[0] + houses[3];
    }

    // Implementation of roundHouses method
    @Override
    public int roundHouses(int[] houses) {
        // Return the common value
        return common(houses);
    }

    // Implementation of rectangleHouses method
    @Override
    public int rectangleHouses(int[] houses) {
        // Check if the length of the array is 4, if not throw an exception
        if (houses.length != 4) {
            throw new IllegalArgumentException("Only 4 houses accepted!");
        }
        // Return the common value
        return common(houses);
    }

    // Private helper method to calculate the common value
    private int common(int[] houses) {
        // Check if the length of the array is 4, if not throw an exception
        if (houses.length != 4) {
            throw new IllegalArgumentException("Only 4 houses accepted!");
        }
        // Calculate the sum of the first and third elements
        int a = houses[0] + houses[2];
        // Calculate the sum of the second and fourth elements
        int b = houses[1] + houses[3];
        // Return the maximum value between a and b
        return Math.max(a, b);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an instance of JavaProfessionalRobbery
        JavaProfessionalRobbery robj = new JavaProfessionalRobbery();
        // Arrays representing different house configurations
        int a[] = {1, 2, 3, 0};
        int b[] = {1, 2, 3, 4};
        int c[] = {5, 10, 2, 7};
        int d[] = {10, 12, 7, 6};

        // Print the results for different house configurations
        System.out.println("For square houses: " + robj.squareHouse(a));
        System.out.println("For round houses: " + robj.roundHouses(b));
        System.out.println("For row houses: " + robj.rowHouses(c));
        System.out.println("For rectangle houses: " + robj.rectangleHouses(d));
    }
}
