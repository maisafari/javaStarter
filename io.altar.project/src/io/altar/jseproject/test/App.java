package io.altar.jseproject.test;

/*import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;*/
import io.altar.jseproject.textinterface.TextInterface;

/*import java.util.Iterator;
import repositories.ProductRepository;
import repositories.ShelfRepository;*/

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TextInterface ti = new TextInterface();
		 ti.printFirstMenu();
		
		/*ProductRepository pr = ProductRepository.getInstance(); // construtor
		Product p = new Product();
		pr.createEntity(p);
		Product p2 = new Product();
		pr.createEntity(p2);

		Iterator<Product> it = pr.getAll().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}*/
		
		/*ShelfRepository sr = ShelfRepository.getInstance();
		Shelf s = new Shelf();
		sr.createEntity(s);
		Shelf s2 = new Shelf();
		sr.createEntity(s2);
		Iterator<Shelf> it2 = sr.getAll().iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}*/
	}
}
