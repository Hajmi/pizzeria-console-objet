package com.Pizzeria;

import java.util.List;
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
		List<Pizza> listPizzas = dao.findAllPizzas();
		//dao.afficheListe();
		//Pizza [] pizzas = dao.findAllPizzas();
		//dao.afficheTableau();
		menu();
		int choix = 0; // variable pour mémoriser le choix de l'utilisateur
		Scanner sc = new Scanner(System.in); // ouverture du scanner
		choix = sc.nextInt();
		while (choix != 99) {
			// choix 1 : listes les pizzas disponible
			if (choix == 1) {
				System.out.println("Liste des pizzas\r\n");
				dao.afficheListe();
				System.out.println("");
				menu();
				choix = sc.nextInt();

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
				menu();
				choix = sc.nextInt();
			}
			// choix 3 : modifier une pizza en passant par son code
			if (choix == 3) {
				sc.nextLine();
				String choixCode = "";
				System.out.println("Mise à jour d'une pizza\r\n");
				System.out.println("Liste des pizzas\r\n");
				dao.afficheListe();
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				choixCode = sc.nextLine();
				if (dao.isPizzaExists(choixCode)) {
						System.out.println("Veuillez saisir le nouveau  code : \r\n");
						String newCodePizza = "";
						String newNomPizza = "";
						double newPrixPizza = 0.0;
						newCodePizza = sc.nextLine();
						System.out.println("Veuillez saisir le nouveau nom : \r\n");
						newNomPizza = sc.nextLine();
						System.out.println("Veuillez saisir le nouveauc prix : \r\n");
						newPrixPizza = sc.nextDouble();
						Pizza newPizza = new Pizza(newCodePizza,newNomPizza,newPrixPizza);
						dao.updatePizza(choixCode.toUpperCase(), newPizza);
				}
				else {
					System.out.println("Cette pizza n'existe pas");
				}
				menu();
				choix = sc.nextInt();
			}
			// choix 4 : supprimer une pizza en passant par son code
			if (choix == 4) {
				sc.nextLine();
				System.out.println("Suppression d'une pizza\r\n");
				String choixCode = "";
				System.out.println("Liste des pizzas\r\n");
				dao.afficheListe();
				System.out.println("Veuillez choisir le code de la pizza à supprimer.");
				choixCode = sc.nextLine();
				dao.deletePizza(choixCode);
				menu();
				choix = sc.nextInt();
			}
			// choix 5 : trier les pizzas par prix décroissant
			if (choix == 5) {
				System.out.println("liste des pizzas par prix décroissant ");
				dao.sortToPriceReversed();
				dao.afficheListe();
				menu();
				choix = sc.nextInt();
				
			}
			
			if (choix == 6) {
				dao.sortToCode();
				dao.afficheListe();
				menu();
				choix = sc.nextInt();
			}
			
			if (choix == 99) {
				System.out.println("Au revoir");
				break;
			}
			
			else {
				System.out.println("Veuillez saisir un choix existant : ");
				menu();
				choix = sc.nextInt();
			}
		}
		sc.close(); // Fermeture du scanner
		 
	}
	
	public static void menu() {
		// Menu
		System.out.println("*****Pizzeria Administration*****");
		System.out.println("1.	Lister les pizzas");
		System.out.println("2.	Ajouter une nouvelle pizza");
		System.out.println("3.	Mettre à jour une pizza");
		System.out.println("4.	Supprimer une pizza");
		System.out.println("5.	Trier les pizzas par prix décroissant");
		System.out.println("6.	Trier les pizzas par code croissant");
		System.out.println("99.	Sortir");
	}

}
