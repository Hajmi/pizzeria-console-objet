package com.Pizzeria;

/**
 * @author Samir BENAKCHA
 * @since	19/11/2018
 * Cette application nous permet de gérer une  pizzeria
 */
import java.util.Scanner;
import classe.Pizza;

public class PizzeriaAdminConsoleApp {
	/**
	 * Menu principal de la pizzeria
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza[] pizzas = { new Pizza("PEP", "Pépéroni", 12.50), new Pizza("MAR", "Margherita", 14.00),
				new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 frommages", 12.00),
				new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
				new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00), };

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
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
				System.out.println("");

			}
			// choix 2 : ajouter une nouvelle pizza
			if (choix == 2) {
				System.out.println("Ajout d'une nouvelle pizza\r\n");
				System.out.println("Veuillez saisir le code : \r\n");
				String codePizza = "";
				String nomPizza = "";
				double prixPizza = 0.0;
				codePizza = sc.nextLine();
				// sc.nextLine();
				System.out.println("Veuillez saisir le nom : \r\n");
				nomPizza = sc.nextLine();
				// sc.nextLine();
				System.out.println("Veuillez saisir le prix : \r\n");
				prixPizza = sc.nextDouble();

				Pizza nouvellePizza = new Pizza(codePizza, nomPizza, prixPizza);
				Pizza[] pizzasTemp = new Pizza[(pizzas.length) + 1];
				pizzasTemp = pizzas;
				pizzas = new Pizza[pizzasTemp.length];
				pizzas = pizzasTemp;
				pizzas[(pizzas.length) - 1] = nouvellePizza;

				System.out.println("");

			}
			// choix 3 : modifier une pizza en passant par son code
			if (choix == 3) {
				boolean codeBon = false;
				String choixCode = "";
				System.out.println("Mise à jour d'une pizza\r\n");
				System.out.println("Liste des pizzas\r\n");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				sc.nextLine();
				choixCode = sc.nextLine();

				for (Pizza pizza : pizzas) {
					if (pizza.code.equals(choixCode.toUpperCase())) {
						codeBon = true;
						System.out.println("Veuillez saisir le nouveau  code : \r\n");
						String newCodePizza = "";
						String newNomPizza = "";
						double newPrixPizza = 0.0;
						// Scanner scan = new Scanner(System.in);
						newCodePizza = sc.nextLine();
						// sc.nextLine();
						System.out.println("Veuillez saisir le nouveau nom : \r\n");
						newNomPizza = sc.nextLine();
						// sc.nextLine();
						System.out.println("Veuillez saisir le nouveauc prix : \r\n");
						newPrixPizza = sc.nextDouble();
						pizza.setCode(newCodePizza);
						pizza.setDesignation(newNomPizza);
						pizza.setPrix(newPrixPizza);

					} else
						continue;

				}
				if (codeBon == false) {
					System.out.println("Ce code n'existe pas !\r\n");
				}

			}
			// choix 4 : supprimer une pizza en passant par son code
			if (choix == 4) {
				boolean codeBon = true;
				System.out.println("Suppression d'une pizza\r\n");
				String choixCode = "";
				System.out.println("Liste des pizzas\r\n");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
				System.out.println("Veuillez choisir le code de la pizza à supprimer.");
				sc.nextLine();
				choixCode = sc.nextLine();
				int i = 0;
				Pizza[] pizzasTemp = new Pizza[pizzas.length];
				for (Pizza pizza : pizzas) {
					if (pizza.code.equals(choixCode.toUpperCase())) {
						pizzasTemp = new Pizza[(pizzas.length) - 1];
					} 
				}
				for (Pizza pizza : pizzas) {
					if (!pizza.code.equals(choixCode.toUpperCase())) {
						pizzasTemp[i] = pizza;
						i++;
					}
					else
						codeBon = false;
				}
				if (codeBon == true)
					System.out.println("le code n'est pas bon");
				pizzas = pizzasTemp;
			}
			
			if (choix == 99) {
				System.out.println("Au revoir");
				break;
			}

		}
		sc.close(); // Fermeture du scanner

	}

}
