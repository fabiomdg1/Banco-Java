//Super Classe
public class Conta {
	
	public int numero;
	public String titular;
	public double saldo;
	
	//----- Construtor -----//
	public Conta(String titular, int numero, double saldo) {
		this.titular = titular;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	//----- Método mostrar Dados do Cliente -----//
	public void dados() {
		System.out.println("\n\n");
		System.out.println("|------------------------------ "+this.getTitular()+" Bem Vindo(a) ao Banco Java ------------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.println("Número da conta: "+this.getNumero());
		System.out.printf("Saldo da conta: R$%.2f %n",this.getSaldo());
	}
	
	
	//---------------------Getters and Setters-------------------//

	//-----Número da Conta-----//
	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	//-----Nome do titular da Conta-----//
	public void setTitular(String titular) {
		this.titular = titular;
	}

	//-----Saldo da Conta-----//
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	
}
