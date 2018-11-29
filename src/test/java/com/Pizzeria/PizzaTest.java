package com.Pizzeria;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classe.Pizza;
import dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizzaEnum;

/**
 * 
 * @author formation
 *
 */

public class PizzaTest {
	
	//private Pizza nouvellePizza = new Pizza("POP", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
	public static final int PRIX_MAX = 100;
	public static final int PRIX_MIN = 5;
	static PizzaMemDao dao;
	List<Pizza> listPizzas; 
	
	@BeforeClass
	public static void setUpClass() {
		dao = new PizzaMemDao();
	}
	
	@Before
	public void setUp() {
		listPizzas = dao.findAllPizzas();
		listPizzas.get(1).setCode("REIN");
	}
	
	
	@Test
	public void exp0_declenche_StockageException_verif_code() {
		 
		Pizza nouvellePizza = new Pizza("POPe", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		try { 
			nouvellePizza.dataController();
			//le programme sort du try quand l'exception StockageException est levée
			fail("il n'y a pas d'exception car code bon");
			
		}catch (StockageException e) {
			assert (e.getMessage().contains("Veuillez saisir un autre code avec 3 caractères svp.")); //!= null;
			System.out.println(e.getMessage()+" --> exp0_declenche_StockageException_verif_code()  ");
		}
	}
	
	@Test
	public void exp0_declenche_StockageException_verif_designation() {
		 
		Pizza nouvellePizza = new Pizza("POP", "", 5.0 ,CategoriePizzaEnum.AUTRE);
		try { 
			nouvellePizza.dataController();
			//le programme sort du try quand l'exception StockageException est levée
			fail("il n'y a pas d'exception car designation bon");
			
		}catch (StockageException e) {
			assert (e.getMessage().contains("Veuillez saisir un autre nom avec 15 charactères max.")); //!= null;
			System.out.println(e.getMessage()+" --> exp0_declenche_StockageException_verif_designation()");
		}
	}
	
	@Test
	public void exp0_declenche_StockageException_verif_prix() {
		 
		Pizza nouvellePizza = new Pizza("POP", "populaire", -5.0 ,CategoriePizzaEnum.AUTRE);
		try { 
			nouvellePizza.dataController();
			//le programme sort du try quand l'exception StockageException est levée
			fail("il n'y a pas d'exception car prix bon");
			
		}catch (StockageException e) {
			assert (e.getMessage().contains("Veuillez saisir un prix compris entre 5.0 et 100.0")); 
			System.out.println(e.getMessage()+" --> exp0_declenche_StockageException_verif_prix()");
		}
	}
	
	/**
	 * test de non regression 
	 * @throws StockageException
	 */
	@Test(expected = StockageException.class)
	public void exp0_declenche_StockageException() throws StockageException {
		 
		Pizza nouvellePizza = new Pizza("POPt", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		nouvellePizza.dataController();
		fail("il n'y a pas d'exception StockageException");
		
	}
	/**
	 * test de non regression
	 * @throws UpdatePizzaException
	 */
	@Test(expected = UpdatePizzaException.class)
	public void exp_UpdatePizzaException() throws UpdatePizzaException {
		Pizza nouvellePizza = new Pizza("POP", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		dao.updatePizza("", nouvellePizza);
		System.out.println(listPizzas);
		fail("il n'y a pas d'exception UpdatePizzaException");
	}
	/**
	 * test de non regression
	 * @throws SavePizzaException
	 */
	@Test(expected = SavePizzaException.class)
	public void exp_SavePizzaException() throws SavePizzaException {
	Pizza nouvellePizza = new Pizza("pep", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
	dao.addPizza(nouvellePizza);
	fail("il n'y a pas d'exception UpdatePizzaException");
	}
	
	/**
	 * test de non regression
	 * @throws DeletePizzaException
	 */
	@Test(expected = DeletePizzaException.class)
	public void exp_DeletePizzaException() throws DeletePizzaException {
	String code = "iii";
	dao.deletePizza(code);
	fail("il n'y a pas d'exception DeletePizzaException");
	}
	/**
	 * 
	 */
	public void test_donnees_vide() {
		/**
		 * on teste si les attributs des pizzas ne sont pas vides dans la liste de pizza
		 * Pour soulever une erreure il suffit de modifier la nouvellePizza en remplacant un de ses attribut par un vide
		 */
		Pizza nouvellePizza = new Pizza("pop", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		listPizzas.add(nouvellePizza);
		for (Pizza pizza : listPizzas) {
		assertNotEquals("le code est vide : ID = "+pizza.getId(),"", pizza.getCode()); 
		assertNotEquals("le nom est vide  : ID = "+pizza.getId(),"", pizza.getDesignation());
		assertNotEquals("le prix est nul  : ID = "+pizza.getId(),null, pizza.getPrix());
		assertNotEquals("la catégorie est nulle : ID = "+pizza.getId(),null, pizza.getCategoriePizza());
		}	
	}
	
	@Test
	public void test_verification_majuscule_code() {
		/**
		 * On vient vérifier si le code de la pizza est en majuscule
		 * Pour soulever une erreure il suffit de mettre un code en minuscule
		 */
		Pizza nouvellePizza = new Pizza("POP", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		listPizzas.add(nouvellePizza);
		for (Pizza pizza : listPizzas) {
		assertTrue("Le code n'est pas en majuscule : ID ="+pizza.getId(),(pizza.getCode().equals(pizza.getCode().toUpperCase())));	
		}
		
		
	}
	@Test
	public void test_prix_negatif_non_compris_dans_intervalle() {
		Pizza nouvellePizza = new Pizza("POP", "populaire", 5.0 ,CategoriePizzaEnum.AUTRE);
		listPizzas.add(nouvellePizza);
		for (Pizza pizza : listPizzas) {
		assertTrue("le prix est négatif ou pas compris dans l'intervalle : ID ="+pizza.getId(), (!(pizza.getPrix() > PRIX_MAX || pizza.getPrix() < PRIX_MIN)));
		}
	}
	@Test
	public void test_doublon_ref_designation() {
		
		Set<Pizza> setPizza = new HashSet<Pizza>();
		for (Pizza pizza : listPizzas) {
			setPizza.add(pizza);
		}
		assertEquals("il existe un doublon", setPizza.size(), listPizzas.size());
	}
	
	
	

}
