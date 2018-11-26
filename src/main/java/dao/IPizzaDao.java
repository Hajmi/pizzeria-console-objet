package dao;
import java.util.List;
import java.util.ArrayList;

import classe.Pizza;

public interface IPizzaDao {
	
		List<Pizza> findAllPizzas();
		void updatePizza(String codePizza, Pizza pizza);
		Pizza findPizzaByCode(String codePizza);
		boolean isPizzaExists(String codePizza);
		void addPizza(Pizza pizza);
		void deletePizza(String codePizza);

}
