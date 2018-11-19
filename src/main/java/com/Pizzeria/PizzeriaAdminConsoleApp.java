package com.Pizzeria;
/**
 * @author Samir BENAKCHA
 * @since	19/11/2018
 * Cette application nous permet de gérer une  pizzeria
 */
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
/**
 * Menu principal de la pizzeria
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
			}
			if (choix == 2) {
				System.out.println("Ajout d'une nouvelle pizza\r\n");
			}
			if (choix == 3) {
				System.out.println("Mise à jour d'une pizza\r\n");
			}
			if (choix == 4) {
				System.out.println("Suppression d'une pizza\r\n");
			}
			if (choix == 99) {
				System.out.println("Au revoir");
				break;
			}
			
		}
		sc.close(); //Fermeture du scanner
		
	}

}
