package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import classe.Pizza;
/**
 * 
 * @author Samir Benakcha
 * @since 23/11/2018
 */

public class PizzaMemDao implements IPizzaDao{
	/**
	 * 
	 */
	static List<Pizza> pizzas = new ArrayList<Pizza>();
	{
	pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
	pizzas.add(new Pizza("REIN", "La Reine", 11.50));
	pizzas.add(new Pizza("MAR", "Margherita", 14.00));
	pizzas.add(new Pizza("FRO", "La 4 frommages", 12.00));
	pizzas.add(new Pizza("CAN", "La cannibale", 12.50));
	pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
	pizzas.add(new Pizza("ORI", "L'orientale", 13.50));
	pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}
	
	public void afficheListe () {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());
		}
	}
	/**
	 * Trouver toute les pizzas existantes dans la base de donnée
	 */
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return pizzas;
	}
	/**
	 * Modifier une pizza 
	 */
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		if (isPizzaExists(codePizza)) {
			Pizza pizzaUpdate = findPizzaByCode(codePizza);
			pizzaUpdate.setCode(pizza.getCode());
			pizzaUpdate.setDesignation(pizza.getDesignation());
			pizzaUpdate.setPrix(pizza.getPrix());
		}else {
				System.out.println("Ce code n'existe pas");
		}
	}
	/**
	 * Trouver une pizza en passant par son code
	 */
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pizza : pizzas) {
			if(pizza.getCode().equals(codePizza.toUpperCase())) {
				return pizza;
			}
		}
		return null;
	}
	/**
	 * Existence d'une pizza en passant par son code
	 */
	public boolean isPizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean exist = false;	
		for (Pizza pizza : pizzas) {
			if (pizza.code.equals(codePizza.toUpperCase())) {
				exist = true;
			} 
		}
		return exist;
	}
	/**
	 * Ajout d'une pizza 
	 */
	public void addPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		if (!isPizzaExists(pizza.getCode())) {
			pizzas.add(pizza);
		}
		else {
			System.out.println("Cette pizza existe");
		}
		
	}
	/**
	 * Suppression d'une pizza en passant par le code
	 */
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		if (isPizzaExists(codePizza)) {
			pizzas.remove(findPizzaByCode(codePizza));
		}
		else {
		System.out.println("Cette pizza n'existe pas");
		}
	}
	/**
	 * 
	 * @return liste des pizzas trier par prix dans l'ordre décroissant
	 */
	public List<Pizza> sortToPriceReversed() {
		pizzas.sort(Comparator.comparingDouble(Pizza::getPrix).reversed());
		return pizzas;
	}
	/**
	 * 
	 * @return liste des pizzas trier par code dans l'ordre croissant
	 */
	public List<Pizza> sortToCode() {
		pizzas.sort(Comparator.comparing(Pizza::getCode));
		return pizzas;
	}
		//Collections.sort(pizzas, new Comparator<>);
		//Comparator<Pizza> comparator = Comparator.comparing(Pizza::getCode).thenComparing(Comparator.comparing(Pizza::getPrix).reversed);
	
	
	//voici la classe PizzaMemDao avec tableau
	/*Pizza[] pizzas2 = { new Pizza("PEP", "Pépéroni", 12.50), new Pizza("MAR", "Margherita", 14.00),
			new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 frommages", 12.00),
			new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
			new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00), };

	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return pizzas;
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		if (isPizzaExists(codePizza)) {
			Pizza pizzaUpdate = findPizzaByCode(codePizza);
			//pizzas[pizzaUpdate.getId()]= pizza;
			pizzaUpdate.setCode(pizza.getCode());
			pizzaUpdate.setDesignation(pizza.getDesignation());
			pizzaUpdate.setPrix(pizza.getPrix());
		}else {
				System.out.println("Ce code n'existe pas");
		}
	}

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pizza : pizzas) {
			if(pizza.getCode().equals(codePizza)) {
				return pizza;
			}
		}
		return null;
	}

	public boolean isPizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean exist = false;	
		for (Pizza pizza : pizzas) {
			if (pizza.code.equals(codePizza.toUpperCase())) {
				exist = true;
			} 
		}
		return exist;
	}

	public void addPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		if (!isPizzaExists(pizza.getCode())) {
			Pizza[] pizzasTemp = new Pizza[(pizzas.length) + 1];
			for (int i = 0; i<pizzas.length; i++) {
				pizzasTemp[i] = pizzas[i];
			}
			pizzas = new Pizza[pizzasTemp.length];
			pizzas = pizzasTemp;
			pizzas[(pizzas.length)-1] = pizza;
		}
		else {
			System.out.println("Cette pizza existe");
		}
	}

	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		int i = 0;
		Pizza[] pizzasTemp = new Pizza[pizzas.length];
		boolean codeBon = true;
		if (isPizzaExists(codePizza)) {
			pizzasTemp = new Pizza[(pizzas.length) - 1];	
		}
			
		for (Pizza pizza : pizzas) {
				if (!pizza.code.equals(codePizza.toUpperCase())) {
					pizzasTemp[i] = pizza;
					i++;
				}
				else
					codeBon = false;
		}
		if (codeBon == true) {
			System.out.println("le code n'est pas bon");
		}
		pizzas = pizzasTemp;
		
	}
	
	public void afficheTableau() {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());
		}
	}*/
	

}
