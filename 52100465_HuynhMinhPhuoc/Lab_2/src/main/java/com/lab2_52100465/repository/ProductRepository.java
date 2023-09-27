package com.lab2_52100465.repository;

import com.lab2_52100465.core.Database;
import com.lab2_52100465.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends Database implements Repository <Product, Integer> {
    @Override
    public Integer add(Product item) {
        try {
            String query = "insert into Product(name, price, color) values(?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setString(3, item.getColor());
            statement.executeUpdate();

            System.out.println("Product added successfully");
            return null;
        } catch (Exception e) {
            System.out.println("Product added failed");
            return null;
        }
    }

    @Override
    public List<Product> readAll() {
        List <Product> products = new ArrayList<>();

        try {
            String query = "select * from Product";
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                Product product = new Product(data.getString("name"), data.getInt("price"), data.getString("color"));
                product.setId(data.getInt("id"));
                products.add(product);
            }

            System.out.println("Products read successfully");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Products read failed");
        }

        return products;
    }

    @Override
    public Product read(Integer id) {
        try {
            String query = "select * from Product where id = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet data = statement.executeQuery();

            if (data.next()) {
                Product product = new Product(id, data.getString("name"), data.getInt("price"), data.getString("color"));

                System.out.println("Products read successfully");
                return product;
            }

            System.out.println("Products read failed");
            return null;
        } catch (Exception e) {
            System.out.println("Products read failed");
            return null;
        }
    }

    @Override
    public boolean update(Product item) {
        try {
            String query = "update Product set name = ?, price = ?, color = ? where id = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setString(3, item.getColor());
            statement.setInt(4, item.getId());

            System.out.println("Product updated successfully");
            return statement.executeUpdate() != 0;
        } catch (Exception e) {
            System.out.println("Product updated failed");
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            String query =  "delete from Product where id = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);

            System.out.println("Product deleted successfully");
            return statement.executeUpdate() != 0;
        } catch (Exception e) {
            System.out.println("Product deleted failed");
            return false;
        }
    }
}
