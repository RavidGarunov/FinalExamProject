package service;

import cars.Cars;
import enums.Queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connection.DBConnection.connectionClose;
import static connection.DBConnection.getConnection;
import static enums.Queries.CREATE_CARS_TABLE;
import static enums.Queries.INSERT_CARS;

public class CarService {

private static PreparedStatement preparedStatement;


public static void createtable () {

    String query = CREATE_CARS_TABLE.getQuery();
    var connection = getConnection();
    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        System.out.println("Cars table created successfully");

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    finally {

        try {
            if (preparedStatement!=null){
                preparedStatement.close();}
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connectionClose(connection);
        System.out.println("Database connection closed");
    }

    }

    public static void createCar (Cars cars) {
    String query = INSERT_CARS.getQuery();
    var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,cars.getId() );
            preparedStatement.setString(2,cars.getName());
            preparedStatement.setInt(3,cars.getSpeed());
            preparedStatement.setInt(4,cars.getRelease_date());
            preparedStatement.setDouble(5,cars.getEngine());
            preparedStatement.setString(6,cars.getColor());
            preparedStatement.execute();
            System.out.println("Car created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closePrepareStatement(preparedStatement);
            connectionClose(connection);
            System.out.println("Database connection closed");
        }



    }

    public static List<Cars> getAllCars(){
    String query = Queries.GET_ALL_CARS.getQuery();
    List<Cars> carList = new ArrayList<>();
    var connection = getConnection();

        try {
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                var carId = resultSet.getLong(1);
                var carName =resultSet.getString(2);
                var carSpeed = resultSet.getInt(3);
                var carRelease_Date =resultSet.getInt(4);
                var carEngine = resultSet.getDouble(5);
                var carColor = resultSet.getString(6);

                var cars = new Cars(carId,carName,carSpeed,carRelease_Date,carEngine,carColor);
                carList.add(cars);
            }
            return carList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closePrepareStatement(preparedStatement);
            connectionClose(connection);
        }
    }

    public static Cars getCarById (Long id){
    String query = Queries.FIND_BY_ID.getQuery();
    var connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                var carId = resultSet.getLong(1);
                var carName =resultSet.getString(2);
                var carSpeed = resultSet.getInt(3);
                var carRelease_Date =resultSet.getInt(4);
                var carEngine = resultSet.getDouble(5);
                var carColor = resultSet.getString(6);

                return new Cars(carId,carName,carSpeed,carRelease_Date,carEngine,carColor);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closePrepareStatement(preparedStatement);
            connectionClose(connection);
        }
throw new RuntimeException("Not found");
    }

    public static void updateCarName (Long id , String name){
    String query =Queries.UPDATE_CAR_NAME.getQuery();
    var connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setLong(2,id);
            preparedStatement.execute();
            System.out.println("Car name updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closePrepareStatement(preparedStatement);
            connectionClose(connection);
            System.out.println("Database connection closed");
        }
    }


    public static void deleteCar (Long id){

    String query = Queries.DELETE_STUDENTS.getQuery();
    var connection = getConnection();

        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {

            closePrepareStatement(preparedStatement);
            connectionClose(connection);
        }


    }

    public static void closePrepareStatement (PreparedStatement preparedStatement){

    if (preparedStatement!=null){
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }


}
