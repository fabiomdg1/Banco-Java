
public class BancoPrincipal {

	public static void main(String[] args) {
		
		//Cliente de Conta Corrente Comum
		ContaCorrente c1 = new ContaCorrente("José Antônio", 100, 300.50);
		
		//Cliente de Conta Corrente Especial - Com limite de conta
		ContaEspecial c2 = new ContaEspecial("Lucina Almeida", 101,100,400);
		
		//Cliente de Conta Poupança
		Poupanca c3 = new Poupanca("Fernanda Lima", 102, 100, 100);
		
		
		//Conta Corrente
		c1.dados();
		c1.sacar(50);
		c1.depositar(60);
		
		//Conta Especial
		c2.dados();
		c2.sacar(350);
		c2.depositar(1000);
		
		//Conta Poupança
		c3.dados();
		c3.depositar(1000);
		c3.sacar(5000);		
		c3.projecao();
		
	}

}
