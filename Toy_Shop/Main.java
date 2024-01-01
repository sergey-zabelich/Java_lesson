public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        
        toyStore.addNewToy(1, "Constructor", 5, 10);
        toyStore.addNewToy(2, "Robot", 10, 30);
        toyStore.addNewToy(3, "Doll", 3, 20);
        toyStore.addNewToy(4, "Teddy", 7, 40);
        
        toyStore.updateToyFrequency(1, 15);
        toyStore.updateToyFrequency(4, 50);
        
        toyStore.givePrizeToy();
    }
}
