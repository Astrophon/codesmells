import java.lang.*;
import java.util.*;


public class Shoptester {

	public void tester01() {
		String result;
		
		Rental rental = new Rental(new Movie("Star Wars I", Movie.NEW_RELEASE), 10);
		Customer customer = new Customer("Mueller");
		customer.addRental(rental);
		result = customer.statement();
		System.out.println(result);
	}
	
	public void tester02() {
		String result;
		
		Rental rental = new Rental(new Movie("Star Wars I", Movie.REGULAR), 2);
		Rental rental1 = new Rental(new Movie("Star Wars II", Movie.REGULAR), 3);
		Rental rental2 = new Rental(new Movie("Star Wars III", Movie.REGULAR), 5);
		Rental rental3 = new Rental(new Movie("Star Wars IV", Movie.NEW_RELEASE), 7);
		Rental rental4 = new Rental(new Movie("Die Eiskönigin", Movie.CHILDRENS), 7);
		Customer customer = new Customer("Bauer");
		customer.addRental(rental);
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		customer.addRental(rental4);
		
		result = customer.statement();
		System.out.println(result);
	}

	public void tester03() {
		String result;
		
		Rental rental = new Rental(new Movie("Star Wars VI Die Rückkehr der Jedi Ritter Extended Cut Special Edition mit Producer Kommentaren und Interviews", Movie.NEW_RELEASE), 1000000000);
		Customer customer = new Customer("Wieland");
		customer.addRental(rental);
		result = customer.statement();
		System.out.println(result);
	}
	
	
}
