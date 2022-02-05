public class ContaCorrente extends Conta{
	
	private final String atendimento = "Sem prioridades \n";
	
	//----- Construtor -----//
	public ContaCorrente(String titular, int numero, double saldo) {
		super(titular, numero, saldo);
	}

	//----- Método mostrar Dados do Cliente -----//
	public void dados() {
		super.dados();
		System.out.println("Atendimento " + this.getAtendimento());
	}
		
	//----- Método Sacar -----//
	public void sacar(double valor) {	
		System.out.println("|---------------------- Banco Java - Conta Corrente - Saque ------------------|");		
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Solicitação de saque no valor de R$%.2f %n",valor);
	
		// Se o valor solicitado no saque for suficiente o saque é efetuado.
		if(valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo()-valor);
			System.out.printf("Saque realizado com sucesso%nSeu saldo atual é de: R$%.2f %n%n", this.getSaldo());
		}else {			
			System.out.println("*** Não foi possível efetuar o saque. Saldo insuficiente ***\n");
		}
	}
	
	//----- Método Depositar -----//
	public void depositar(double valor) {
		System.out.println("|--------------------- Banco Java - Conta Corrente - Depósito ----------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Efetuado depósito no valor de R$%.2f %n",valor);
		//Valor depositado é adicionado ao saldo da conta
		this.setSaldo(this.getSaldo()+valor);
		System.out.printf("Depósito realizado com sucesso.%nSeu saldo atual é de: R$%.2f %n%n", this.getSaldo());
	}
	
	
	//---------------------Getters and Setters-------------------//
	
	public String getAtendimento() {
		return atendimento;
	}
}


