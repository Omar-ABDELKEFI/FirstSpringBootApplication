package tn.iit.bean;

import org.springframework.stereotype.Component;

@Component // --> c'est un bean de spring
public class Hello {
	// Première méthode d'injection: injection sur attribut
	// @Autowired
	private Hamza hamza;

	// Deuxième méthode d'injection: injection via Setter
	/*
	 * @Autowired public void setHamza(Hamza hamza) { this.hamza = hamza; }
	 */

	// Troisième méthode d'injection: injection via constructeur
	// @Autowired // non recommandé
	public Hello(Hamza hamza) {
		this.hamza = hamza;
	}

	public void sofien() {
		hamza.forKallal();

	}

}
