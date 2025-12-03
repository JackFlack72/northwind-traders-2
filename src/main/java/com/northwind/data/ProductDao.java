package com.northwind.data;

import com.northwind.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String query = """
                SELECT ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued
                FROM products;
                """;


        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Product product = new Product(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("ProductName"),
                            resultSet.getString("SupplierID"),
                            resultSet.getString("CategoryID"),
                            resultSet.getString("QuantityPerUnit"),
                            resultSet.getString("UnitPrice"),
                            resultSet.getString("UnitsInStock"),
                            resultSet.getString("UnitsOnOrder"),
                            resultSet.getString("ReorderLevel"),
                            resultSet.getString("Discontinued"));

                    products.add(product);
                }

            }
        } catch (SQLException e) {
            System.out.println("There was an error retrieving the data. Please try again.");
            e.printStackTrace();
        }

        return products;
    }

    public Product find(int productId) {
        Product product = null;

        String query = """
                SELECT ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued
                FROM Products
                WHERE ProductID = ?;
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    product = new Product(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("ProductName"),
                            resultSet.getString("UnitPrice"),
                            resultSet.getString("CategoryID"),
                            resultSet.getString("QuantityPerUnit"),
                            resultSet.getString("UnitPrice"),
                            resultSet.getString("UnitsInStock"),
                            resultSet.getString("UnitsOnOrder"),
                            resultSet.getString("ReorderLevel"),
                            resultSet.getString("Discontinued"));
                }

            }
        } catch (SQLException e) {
            System.out.println("There was an error retrieving the data. Please try again.");
            e.printStackTrace();
        }

        return product;
    }

    public Product add(Product product) {
        String query = """
                INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getProductName());
            statement.setString(2, product.getUnitPrice());
            statement.setString(3, product.getCategoryId());
            statement.setString(4, product.getQuantityPerUnit());
            statement.setString(5, product.getUnitPrice());
            statement.setString(6, product.getUnitsInStock());
            statement.setString(7, product.getUnitsOnOrder());
            statement.setString(8, product.getReorderLevel());
            statement.setString(9, product.getDiscontinued());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductId(generatedId);
                }
            }

        } catch (SQLException e) {
            System.out.println("There was an error adding the shipper. Please try again.");
            e.printStackTrace();
        }

        return product;
    }

    public void update(Product product) {
        String query = """
                UPDATE Products
                SET ProductName = ?, SupplierID = ?, CategoryID = ?, QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, ReorderLevel = ?, Discontinued = ?
                WHERE ProductsID = ?;
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, product.getProductName());
            statement.setString(2, product.getSupplierId());
            statement.setString(3, product.getCategoryId());
            statement.setString(4, product.getQuantityPerUnit());
            statement.setString(5, product.getUnitPrice());
            statement.setString(6, product.getUnitsInStock());
            statement.setString(7, product.getUnitsOnOrder());
            statement.setString(8, product.getReorderLevel());
            statement.setString(9, product.getDiscontinued());
            statement.setInt(10, product.getProductId());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There was an error updating the shipper. Please try again.");
            e.printStackTrace();
        }
    }

    public void delete(int productId) {
        String query = """
                DELETE FROM Products
                WHERE ProductID = ?;
                """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There was an error deleting the shipper. Please try again.");
            e.printStackTrace();
        }
    }

}