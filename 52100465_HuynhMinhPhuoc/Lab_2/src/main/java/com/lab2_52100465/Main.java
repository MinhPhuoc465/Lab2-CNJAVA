package com.lab2_52100465;
import com.lab2_52100465.model.Product;
import com.lab2_52100465.repository.ProductRepository;

import java.util.Scanner;


public class Main {
    public static void Option() {
        System.out.println("Option:");
        System.out.println("1. Read all products");
        System.out.println("2. Read detail of a product by id");
        System.out.println("3. Add a new product");
        System.out.println("4. Update a product by id");
        System.out.println("5. Delete a product by id");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String price;
        String color;

        while (true) {
            System.out.println();
            System.out.println(">------------------------------------------<");
            Option();
            System.out.println();
            System.out.print("Your choice: ");
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1":
                        for (Product product : productRepository.readAll()) {
                            System.out.println(product);
                        }

                        break;
                    case "2":
                        System.out.print("Enter product id: ");
                        id = scanner.nextLine();
                        System.out.println(productRepository.read(Integer.parseInt(id)));

                        break;
                    case "3":
                        System.out.print("Enter product name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        price = scanner.nextLine();
                        System.out.print("Enter product color: ");
                        color = scanner.nextLine();

                        productRepository.add(new Product(name, Integer.parseInt(price), color));

                        break;
                    case "4":
                        System.out.print("Enter product id: ");
                        id = scanner.nextLine();
                        System.out.print("Enter product name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        price = scanner.nextLine();
                        System.out.print("Enter product color: ");
                        color = scanner.nextLine();

                        productRepository.update(new Product(Integer.parseInt(id), name, Integer.parseInt(price), color));
                        break;
                    case "5":
                        System.out.print("Enter product id: ");
                        id = scanner.nextLine();

                        productRepository.delete(Integer.parseInt(id));
                        break;
                    case "6":
                        System.out.println("Exiting the program");
                        System.exit(0);
                        break;
                    default:

                }
            } catch (Exception e) {
                System.out.println("Check your input!");
            }
        }
    }
}