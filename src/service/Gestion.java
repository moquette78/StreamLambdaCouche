package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.GestionDao;
import interfaces.IGestion;
import metier.Etudiant;

/**
 * Classe Gestion : permet de faire la liaison entre le dao et le metier.
 * Implémente l'interface IGestion.
 */
public class Gestion implements IGestion {
	
	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public Etudiant creerEtudiant (Etudiant etudiant) {
		return GestionDao.creerEtudiant(etudiant);
	}
	
	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void lireEtudiant(String email) {
		GestionDao.lireEtudiant(email);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void supprimerEtudiant(String email) {
		GestionDao.supprimerEtudiant(email);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void modifierAdresseEtudiant(String email,String nouvelleAdresse) {
		GestionDao.modifierAdresseEtudiant(email, nouvelleAdresse);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void associerCoursEtudiant(String mailEtudiant,String theme) {
		GestionDao.associerCoursEtudiant(mailEtudiant, theme);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void listerEtudiants() {
		GestionDao.listerEtudiants();
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public String connecter(String email, String mdp) {
		return GestionDao.connecter(email, mdp);
	}

	public void listerEtudiantsFemmes() {
		List<Etudiant> etudiantes=new ArrayList<Etudiant>();
		etudiantes= GestionDao
				.listerEtudiantsFemmes()
				.stream()
				.filter(person -> person.getGenre().equals("F"))
				.collect(Collectors.toList());
		
		etudiantes.forEach(etudiante->System.out.println(etudiante.getPrenom() + " " + etudiante.getNom()));
		
	}
}
