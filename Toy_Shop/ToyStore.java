import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private int frequency;

    public Toy(int id, String name, int quantity, int frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, int frequency) {
        Toy toy = new Toy(id, name, quantity, frequency);
        toys.add(toy);
    }

    public void updateToyFrequency(int id, int frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public Toy choosePrizeToy() {
        int totalFrequency = 0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }
        
        Random random = new Random();
        int randomNumber = random.nextInt(totalFrequency);
        
        for (Toy toy : toys) {
            if (randomNumber < toy.getFrequency()) {
                return toy;
            } else {
                randomNumber -= toy.getFrequency();
            }
        }
        
        return null;
    }

    public void givePrizeToy() {
        Toy prizeToy = choosePrizeToy();
        if (prizeToy != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("prizeToys.txt", true))) {
                writer.write(prizeToy.getName());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            int index = toys.indexOf(prizeToy);
            toys.remove(index);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            toys.add(index, prizeToy);
        }
    }
}
