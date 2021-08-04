package io.altar.jseproject.textinterface;

import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public class TextInterface {
	ScannerUtils scu = new ScannerUtils();
	ShelfRepository sr = ShelfRepository.getInstance();
	ProductRepository pr = ProductRepository.getInstance();

	public void printFirstMenu() {
		while (true) {
			System.out.println("1) Listar produtos\r\n" + "2) Listar prateleiras\r\n" + "3) Sair\n");
			informationTreatmentMenus(1);
		}
	}

	public void printSecondMenu() {
		while (true) {
			showProducts();
			System.out.println("Por favor selecione uma das seguintes opções:\r\n" + "1) Criar novo produto\r\n"
					+ "2) Editar um produto existente\r\n" + "3) Consultar o detalhe de um produto\r\n"
					+ "4) Remover um produto\r\n" + "5) Voltar ao ecrã anterior\n");
			informationTreatmentMenus(2);
		}
	}

	public void printThirdMenu() {
		while (true) {
			showShelves();
			System.out.println("Por favor selecione uma das seguintes opções:\r\n" + "1) Criar nova parteleira\r\n"
					+ "2) Editar uma parteleira existente\r\n" + "3) Consultar o detalhe de uma parteleira\r\n"
					+ "4) Remover uma parteleira\r\n" + "5) Voltar ao ecrã anterior");
			informationTreatmentMenus(3);
		}
	}

	public void informationTreatmentMenus(int menu) {
		int userInput;
		switch (menu) {

		case (1):
			userInput = scu.numberRange(1, 3);
			treatMenu1(userInput);
			break;
		case (2):

			userInput = scu.numberRange(1, 5);
			treatMenu2(userInput);
			break;

		case (3):

			userInput = scu.numberRange(1, 5);
			treatMenu3(userInput);
		}

	}

	public void exit() {
		System.out.println("Thank you.\n Bye!");
		System.exit(0);

	}

	public void treatMenu1(int userInput) {

		switch (userInput) {
		case (1):
			printSecondMenu();
			break;
		case 2:
			printThirdMenu();
			break;
		case 3:
			exit();
			break;
		default:
			printFirstMenu();
		}

	}

	public void treatMenu2(int userInput) {
		long userNewInput;
		switch (userInput) {
		case (1):

			createNewProduct();

			break;
		case 2:
			System.out.println("Introduza o Id do produto que pretende alterar:");
			userNewInput = scu.getLong();
			editProduct(userNewInput);
			break;
		case 3:
			System.out.println("Introduza o Id do produto que pretende visualizar:");
			userNewInput = scu.getLong();
			 showProduct(userNewInput);
			break;
		case 4:
			System.out.println("option 4");
			break;
		case 5:
			printFirstMenu();
			break;
		default:
			printSecondMenu();
		}

	}

	public void treatMenu3(int userInput) {
		long userNewInput;
		switch (userInput) {
		case (1):

			createNewShelf();
			break;
		case 2:

			System.out.println("Introduza o Id da parteleira que pretende alterar:");
			userNewInput = scu.getLong();
			editShelf(userNewInput);
			break;
		case 3:
			System.out.println("Introduza o Id da parteleira que pretende visualizar:");
			userNewInput = scu.getLong();
			showShelf(userNewInput);
			break;
		case 4:
			System.out.println("option 4");
			break;
		case 5:

			printFirstMenu();
			break;
		default:
			printThirdMenu();
		}
	}

	public void showProducts() {

		Iterator<Product> itP = pr.getAll().iterator();
		while (itP.hasNext()) {
			System.out.println(itP.next());

		}
	}

	public void showShelves() {

		Iterator<Shelf> itS = sr.getAll().iterator();
		while (itS.hasNext()) {
			System.out.println(itS.next());
		}
	}

	public void createNewProduct() {

		Product p = new Product();
		p.setId(pr.createEntity(p));
		System.out.println("Foi criada um novo Produto com id: " + p.getId());
		System.out.println("Quer alterar os seus dados? S \nCaso contrario pressione a tecla ENTER");
		scu.clearBuffer();
		if (scu.getText().equals("S")) {
			editProduct(p.getId());

		}

	}

	public void createNewShelf() {
		Shelf s = new Shelf();
		s.setId(sr.createEntity(s));
		System.out.println("Foi criada uma nova parteleira com id: " + s.getId());
		System.out.println("Quer alterar os seus dados? S \nCaso contrario pressione a tecla ENTER\n");
		scu.clearBuffer();
		if (scu.getText().equals("S")) {
			editShelf(s.getId());
		}

	}

	public void editProduct(long id) {

		Product p = pr.getEntity(id);
		float userInput;

		System.out.println("Insira o valor do IVA.\nCaso não queira aterar pressione ENTER\n");
		userInput = scu.getFloat();
		p.setProductIva(userInput);

		System.out.println("Insira o valor do PVP.\nCaso não queira aterar pressione ENTER\n");
		userInput = scu.getFloat();
		p.setProductPvp(userInput);

		System.out.println("Insira o valor do Desconto.\nCaso não queira aterar pressione ENTER\n");
		userInput = scu.getFloat();
		p.setValorUnitDesconto(userInput);
		
		// ask Lista de parteleiras
		System.out.println("Insira uma nova lista de parteleiras.\nCaso contrário a lista será apagada.\n");
		// FAZER
		pr.editEntity(p);
		printSecondMenu();

	}

	public void editShelf(long id) {
		Shelf s = sr.getEntity(id);
		int userInput;
		//scu.clearBuffer();
		System.out.println("Insira o valor da capacidade entre 0 e 1.\nCaso não queira aterar pressione ENTER\n");
		userInput = scu.numberRange(0, 1);
		s.setShelCapacity(userInput);
		
		System.out.println("Insira o id do seu Produto.\nCaso contrário a lista será apagada.\n");
		long userNumber = scu.getLong();
		s.setProduct(userNumber);
		
		System.out.println("Insira o preço de aluguer da parteleira.\nCaso não queira aterar pressione ENTER\n");	
		float uservalue = scu.getFloat();
		s.setPrecoDeAluguerD(uservalue);
		sr.editEntity(s);
	}

	public void showShelf(long id) {
	
		System.out.println(sr.getEntity(id));
		
	}
	
	public void showProduct(long id) {
		
		System.out.println(pr.getEntity(id));
		
	}
}
