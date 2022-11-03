package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Main {

	public static void main(String[] args) {
		//create the person's name and email
		Person person1 = new Person(null, "Acir Rudson", "acir@rudson.com");
		Person person2 = new Person(null, "João da Silva", "joao@silva.com");
		Person person3 = new Person(null, "Maria Aparecida", "maria@aparecida.com");
		
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("example-jpa");
		EntityManager EM = EMF.createEntityManager();
		//save into database
		//EM.getTransaction().begin();
		//EM.persist(person1);
		//EM.persist(person2);
		//EM.persist(person3);
		//EM.getTransaction().commit();
		
		//get one person from id
		//Person p = EM.find(Person.class, 2);
		//System.out.println(p);
		
		//remove person from database
		EM.getTransaction().begin();
		Person p = EM.find(Person.class, 2);
		EM.remove(p);
		EM.getTransaction().commit();
		
		System.out.println("Done!");
		EM.close();
		EMF.close();
	}

}
