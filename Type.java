public class Type {
// Each event can be classified as sports, social, religious or academic depending on
// the classification; specific event information is stored.

    private String name;
    private String info;

    public Type(String name, String info) {
        this.name = name;
        this.info = info;
    }


    public String getInfo() {
        return this.info;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
