package JavaApp;

public class Toy {
    private int id;
    private String name;
    private int amount;
    private int freq;

    public Toy(int id, String name, int amount, int freq) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.freq = freq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", amount=" + amount + ", freq=" + freq + "]";
    }
     
}
