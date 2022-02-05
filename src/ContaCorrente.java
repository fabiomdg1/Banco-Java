public class ContaCorrente extends Conta{
	
	private final String atendimento = "Sem prioridades \n";
	
	//----- Construtor -----//
	public ContaCorrente(String titular, int numero, double saldo) {
		super(titular, numero, saldo);
	}

	//----- M�todo mostrar Dados do Cliente -----//
	public void dados() {
		super.dados();
		System.out.println("Atendimento " + this.getAtendimento());
	}
		
	//----- M�todo Sacar -----//
	public void sacar(double valor) {	
		System.out.println("|---------------------- Banco Java - Conta Corrente - Saque ------------------|");		
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Solicita��o de saque no valor de R$%.2f %n",valor);
	
		// Se o valor solicitado no saque for suficiente o saque � efetuado.
		if(valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo()-valor);
			System.out.printf("Saque realizado com sucesso%nSeu saldo atual � de: R$%.2f %n%n", this.getSaldo());
		}else {			
			System.out.println("*** N�o foi poss�vel efetuar o saque. Saldo insuficiente ***\n");
		}
	}
	
	//----- M�todo Depositar -----//
	public void depositar(double valor) {
		System.out.println("|--------------------- Banco Java - Conta Corrente - Dep�sito ----------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Efetuado dep�sito no valor de R$%.2f %n",valor);
		//Valor depositado � adicionado ao saldo da conta
		this.setSaldo(this.getSaldo()+valor);
		System.out.printf("Dep�sito realizado com sucesso.%nSeu saldo atual � de: R$%.2f %n%n", this.getSaldo());
	}
	
	
	//---------------------Getters and Setters-------------------//
	
	public String getAtendimento() {
		return atendimento;
	}
}


