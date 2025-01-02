package de.dhbw.exceptions.demo;

import java.io.*;
import java.util.Scanner;

public class DataLoader {

    private ExceptionHandler handler = new DefaultExceptionHandler();

    /**
     * Returns a product built with data from underlying CSV file.
     * Uses default 'try (-catch-finally)' statement
     *
     * @param file the file to load
     * @return the built Product
     * @throws IOException if file not found
     */
    public Product tryLoad(String file) {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Product product = null;

        // code that can produce exceptions
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            product = new Product(bufferedReader.readLine());
        }

        // the java exception handler (method)
        //tag::exception-handling-2[]
        catch (IOException ioe) {
            // we want to handle this exception
            // our own way, using an application-
            // specific exception handler!
            handler.handle(ioe);
        }
        //end::exception-handling-2[]

        // finally, we have to be aware of cleaning up resources!
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    fileReader.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        return product;
    }

    /**
     * The try-with-resources statement is a try statement that declares one or more resources. A resource
     * is an object that must be closed after the program is finished with it. The try-with-resources
     * statement ensures that each resource is closed at the end of the statement. Any object that implements
     * java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used
     * as a resource.
     *
     * @param csvFile the file to load
     * @return the loaded set of products
     */
    public Product tryLoadWithResources(String csvFile) {
        Product product = null;

        // try with resources statement
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                String csvLine = scanner.nextLine();
                product = new Product(csvLine);
            }
        // java exception handler
        //tag::exception-handling-1[]
        } catch (FileNotFoundException e) {
            // DON'T DO THIS!
            e.printStackTrace();
        }
        //end::exception-handling-1[]

        // What about 'finally'?
        // Cleaning up resources not required here, because of 'try-with-resources' statement!

        return product;
    }

}