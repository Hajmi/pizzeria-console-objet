package dao;
import java.util.List;
import java.util.ArrayList;

import classe.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public interface IPizzaDao {
	
		List<Pizza> findAllPizzas();
		void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
		Pizza findPizzaByCode(String codePizza);
		boolean isPizzaExists(String codePizza);
		void addPizza(Pizza pizza) throws SavePizzaException;
		void deletePizza(String codePizza) throws DeletePizzaException ;

}
