package cars;

public class Cars {

    private Long id;
    private String name;
    private Integer speed;
    private Integer release_date;
    private Double engine;
    private String color;

    public Cars(Long id, String name, Integer speed, Integer release_date, Double engine, String color) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.release_date = release_date;
        this.engine = engine;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getRelease_date() {
        return release_date;
    }

    public Double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed='" + speed +
                ", release_date=" + release_date +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                '}';
    }
}
