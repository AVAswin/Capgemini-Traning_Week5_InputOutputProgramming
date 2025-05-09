// Parent class
class Animal {
    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {
    // Overriding makeSound() using @Override annotation
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();  // Output: Dog barks
    }
}
