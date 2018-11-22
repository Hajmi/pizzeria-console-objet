package com.Pizzeria;

/**
 * @author Samir BENAKCHA
 * @since	19/11/2018
 * Cette application nous permet de gérer une  pizzeria
 */
import java.util.Scanner;
import classe.Pizza;
import dao.PizzaMemDao;

public class PizzeriaAdminConsoleApp {
	/**
	 * Menu principal de la pizzeria
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PizzaMemDao dao = new PizzaMemDao();
		Pizza [] pizzas = dao.findAllPizzas();
		//dao.afficheTableau();
		int choix = 0; // variable pour mémoriser le choix de l'utilisateur
		Scanner sc = new Scanner(System.in); // ouverture du scanner
		while (choix != 99) {
			// Menu
			System.out.println("*****Pizzeria Administration*****");
			System.out.println("1.	Lister les pizzas");
			System.out.println("2.	Ajouter une nouvelle pizza");
			System.out.println("3.	Mettre à jour une pizza");
			System.out.println("4.	Supprimer une pizza");
			System.out.println("99.	Sortir");
			choix = sc.nextInt();
			// choix 1 : listes les pizzas disponible
			if (choix == 1) {
				System.out.println("Liste des pizzas\r\n");
				dao.afficheTableau();
				System.out.println("");

			}
			// choix 2 : ajouter une nouvelle pizza
			if (choix == 2) {
				sc.nextLine();
				System.out.println("Ajout d'une nouvelle pizza\r\n");
				System.out.println("Veuillez saisir le code : \r\n");
				String codePizza = "";
				String nomPizza = "";
				double prixPizza = 0.0;
				codePizza = sc.nextLine();
				System.out.println("Veuillez saisir le nom : \r\n");
				nomPizza = sc.nextLine();
				System.out.println("Veuillez saisir le prix : \r\n");
				prixPizza = sc.nextDouble();
				Pizza nouvellePizza = new Pizza(codePizza.toUpperCase(), nomPizza, prixPizza);
				dao.addPizza(nouvellePizza);
				System.out.println("");
			}
			// choix 3 : modifier une pizza en passant par son code
			if (choix == 3) {
				sc.nextLine();
				String choixCode = "";
				System.out.println("Mise à jour d'une pizza\r\n");
				System.out.println("Liste des pizzas\r\n");
				dao.afficheTableau();
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				//sc.nextLine();
				choixCode = sc.nextLine();

				for (Pizza pizza : pizzas) {
					if (pizza.code.equals(choixCode.toUpperCase())) {
						System.out.println("Veuillez saisir le nouveau  code : \r\n");
						String newCodePizza = "";
						String newNomPizza = "";
						double newPrixPizza = 0.0;
						newCodePizza = sc.nextLine();
						// sc.nextLine();
						System.out.println("Veuillez saisir le nouveau nom : \r\n");
						newNomPizza = sc.nextLine();
						// sc.nextLine();
						System.out.println("Veuillez saisir le nouveauc prix : \r\n");
						newPrixPizza = sc.nextDouble();
						Pizza newPizza = new Pizza(newCodePizza,newNomPizza,newPrixPizza);
						dao.updatePizza(choixCode.toUpperCase(), newPizza);
						
					} else
						continue;
				}
			}
			// choix 4 : supprimer une pizza en passant par son code
			if (choix == 4) {
				sc.nextLine();
				//boolean codeBon = true;
				System.out.println("Suppression d'une pizza\r\n");
				String choixCode = "";
				System.out.println("Liste des pizzas\r\n");
				dao.afficheTableau();
				System.out.println("Veuillez choisir le code de la pizza à supprimer.");
				//sc.nextLine();
				choixCode = sc.nextLine();
				dao.deletePizza(choixCode);
			}
			
			if (choix == 99) {
				System.out.println("Au revoir");
				break;
			}

		}
		sc.close(); // Fermeture du scanner

	}

}
