package codesmells;
/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compiler IDE, only applets can.
 */
public class Program
{
    /**
     * This is the main entry point for the application
     */
    
    public static void main(String args[]) 
    {
        String result;
        
        System.out.println("Welcome to the Movie Store");
        
        Movie movie01 = new Movie("movie1", 1);
        Movie movie02 = new Movie("movie2", 2);
        Rental rental01 = new Rental(movie01, 10);
        Rental rental02 = new Rental(movie02, 5);
        Customer customer01 = new Customer("joe"); 
        customer01.addRental(rental01); 
        customer01.addRental(rental02);   
        
        System.out.println("Let's get all infos:");
        result = customer01.get_all_infos();
        System.out.println(result);
        
        Shoptester Franz = new Shoptester();
        Franz.tester01();
        Franz.tester02();
        Franz.tester03();
    
    }
}


