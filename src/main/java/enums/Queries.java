package enums;

public enum Queries {

    CREATE_CARS_TABLE ("CREATE TABLE cars(" +
            "                            id BIGINT PRIMARY KEY NOT NULL," +
            "                            name VARCHAR(30)NOT NULL," +
            "                            speed INT NOT NULL," +
            "                            release_date INT NOT NULL," +
            "                            engine FLOAT NOT NULL," +
            "                            color VARCHAR(10)  NOT NULL)"),
    INSERT_CARS ("INSERT INTO cars(id,name,speed,release_date,engine,color)"+
            "VALUES(?,?,?,?,?,?)"),
    GET_ALL_CARS("SELECT * FROM cars"),
    FIND_BY_ID("SELECT * FROM cars WHERE id = ?"),
    UPDATE_CAR_NAME("UPDATE cars SET name = ? WHERE id = ?"),
    DELETE_STUDENTS("DELETE FROM cars WHERE id = ?");


    public final String query;


    Queries(String query) {
        this.query = query;
    }

    public String getQuery(){return this.query;}
}
