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
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza[] pizzas = {
							new Pizza("PEP", "Pépéroni", 12.50),
							new Pizza("MAR", "Margherita", 14.00) ,
							new Pizza("REIN", "La Reine", 11.50) ,
							new Pizza("FRO", "La 4 frommages", 12.00) ,
							new Pizza("CAN", "La cannibale", 12.50) ,
							new Pizza("SAV", "La savoyarde", 13.00) ,
							new Pizza("ORI", "L'orientale", 13.50) ,
							new Pizza("IND", "L'indienne", 14.00) ,
							};
	
		
		int choix = 0 ; //variable pour mémoriser le choix de l'utilisateur
		Scanner sc = new Scanner(System.in); //ouverture du scanner 
		while (choix != 99) {
			
			System.out.println("*****Pizzeria Administration*****");
			System.out.println("1.	Lister les pizzas");
			System.out.println("2.	Ajouter une nouvelle pizza");
			System.out.println("3.	Mettre à jour une pizza");
			System.out.println("4.	Supprimer une pizza");
			System.out.println("99.	Sortir");
			
			choix = sc.nextInt();

			if (choix == 1) {
				System.out.println("Liste des pizzas\r\n");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
			System.out.println("");
					
			}
			if (choix == 2) {
				System.out.println("Ajout d'une nouvelle pizza\r\n");
				System.out.println("Veuillez saisir le code : \r\n");
				String codePizza = "";
				String nomPizza ="";
				double prixPizza =0.0;
				Scanner scan = new Scanner(System.in);
				codePizza= scan.nextLine();
				//sc.nextLine();
				System.out.println("Veuillez saisir le nom : \r\n");
				nomPizza = scan.nextLine();
				//sc.nextLine();
				System.out.println("Veuillez saisir le prix : \r\n");
				prixPizza = scan.nextDouble();
				
				Pizza nouvellePizza = new Pizza(codePizza,nomPizza,prixPizza);
				Pizza[] pizzasTemp = new Pizza[(pizzas.length)+1];
				pizzasTemp = pizzas;
				pizzas = new Pizza [pizzasTemp.length];
				pizzas = pizzasTemp;
				pizzas[(pizzas.length)-1]= nouvellePizza;
				
			System.out.println("");	
				
			}
			if (choix == 3) {
				boolean codeBon = false;
				String choixCode = "";
				System.out.println("Mise à jour d'une pizza\r\n");
				System.out.println("Liste des pizzas\r\n");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
				System.out.println("Veuillez choisir le code de la pizza à modifier.");

				//Scanner scan = new Scanner(System.in);
				sc.nextLine();
				choixCode= sc.nextLine();
				
				for (Pizza pizza : pizzas) {
					if (pizza.code.equals(choixCode.toUpperCase())){
						codeBon = true;
						System.out.println("Veuillez saisir le nouveau  code : \r\n");
						String newCodePizza = "";
						String newNomPizza ="";
						double newPrixPizza =0.0;
						//Scanner scan = new Scanner(System.in);
						newCodePizza= sc.nextLine();
						//sc.nextLine();
						System.out.println("Veuillez saisir le nouveau nom : \r\n");
						newNomPizza = sc.nextLine();
						//sc.nextLine();
						System.out.println("Veuillez saisir le nouveauc prix : \r\n");
						newPrixPizza = sc.nextDouble();
						
						pizza.setCode(newCodePizza);
						pizza.setDesignation(newNomPizza);
						pizza.setPrix(newPrixPizza);
						
							
					}
					else 
						continue;
						
				}
				if (codeBon == false) {
					System.out.println("Ce code n'existe pas !\r\n");
				}
				
			}
			if (choix == 4) {
				boolean codeBon = false;
				System.out.println("Suppression d'une pizza\r\n");
				String choixCode = "";
				System.out.println("Liste des pizzas\r\n");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
				System.out.println("Veuillez choisir le code de la pizza à supprimer.");

				//Scanner scan = new Scanner(System.in);
				sc.nextLine();
				choixCode= sc.nextLine();
				
				for (Pizza pizza : pizzas) {
					if (pizza.code.equals(choixCode.toUpperCase())){
			
						pizza.setCode(null);
						pizza.setDesignation(null);
						pizza.setPrix(0);
							
					}
					else 
						continue;
						
				}
				if (codeBon == false) {
					System.out.println("Ce code n'existe pas !\r\n");
				}
				
			}
			if (choix == 99) {
				System.out.println("Au revoir");
				break;
			}
			
		}
		sc.close(); //Fermeture du scanner
		
	}

}
