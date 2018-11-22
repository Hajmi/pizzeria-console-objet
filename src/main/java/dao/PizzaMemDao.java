package dao;

import classe.Pizza;

public class PizzaMemDao implements IPizzaDao{
	
	Pizza[] pizzas = { new Pizza("PEP", "Pépéroni", 12.50), new Pizza("MAR", "Margherita", 14.00),
			new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 frommages", 12.00),
			new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
			new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00), };

	public Pizza[] findAllPizzas() {
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
	}
	

}
