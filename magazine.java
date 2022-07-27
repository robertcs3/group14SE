public class magazine implements UnCheckoutAble
{
    private String name;
    private double value;

    public magazine(String name, double value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }
}
