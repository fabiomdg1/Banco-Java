
public class ContaEspecial extends Conta{
	
	private final String atendimento = "Com prioridades";
	public double chequeEspecial = 300;
	
	// ----- Construtor -----//
	public ContaEspecial(String titular, int numero, double saldo, double chequeEspecial) {
		super (titular, numero, saldo);
		this.chequeEspecial = chequeEspecial;
	}
	
	//----- M�todo mostrar Dados do Cliente -----//
	public void  dados() {
		super.dados();
		System.out.println("Atendimento: "+this.getAtendimento());
		System.out.printf("Limite Cheque Especial: R$%.2f %n%n",this.getChequeEspecial());		
	}
	
	//----- M�todo Sacar -----//
	public void sacar(double valor) {
		System.out.println("|---------------------- Banco Java - Conta Especial - Saque ----------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Solicita��o de saque no valor de R$%.2f %n",valor);
		
		if(this.getSaldo() >= valor) {
			this.saldo -= valor;
			System.out.printf("Saque realizado com sucesso.%nSeu saldo atual � de: R$%.2f %n", this.getSaldo());
			System.out.printf("Seu limite atual � de: R$%.2f %n%n", this.getChequeEspecial());
			
		}else if((this.getSaldo()) < valor) {		
			this.chequeEspecial = this.chequeEspecial - (valor - this.getSaldo());
			
			if(this.getChequeEspecial() < 0) {
				System.out.printf("***Saque n�o realizado. Seu Limite Especial dispon�vel n�o � suficiente*** %n%n");
			}else {
				System.out.printf("Seu saldo dispon�vel n�o � suficiente. Voc� entrar� no limite %n");
				this.setSaldo(this.getSaldo()-valor);
				System.out.printf("Saque realizado com sucesso%nO saldo atual da sua conta corrente � de: R$%.2f %n", this.getSaldo());
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());
			}
			
		}else {
			System.out.printf("Saque n�o realizado. Limite indispon�vel %n");
		}
	}
	
	//----- M�todo Depositar -----//
	public void depositar(double valor) {
		System.out.println("|--------------------- Banco Java - Conta Especial - Dep�sito ---------------------|");
		System.out.printf("Foi efetuado um dep�sito de R$%.2f %n",valor);
				
		if(this.getSaldo() < 0) {
			this.setSaldo(this.getSaldo() + valor);
			
			if(this.getSaldo() < 0) {
				System.out.printf("O saldo atual da sua conta corrente �: R$%.2f %n", this.getSaldo());
				this.setChequeEspecial(400 + this.getSaldo());
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());						
			}else {
				System.out.printf("O saldo atual da sua conta corrente �: R$%.2f %n", this.getSaldo());
				this.setChequeEspecial(400);
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());
			}
		}else {
			this.setSaldo(this.getSaldo()+valor);
			System.out.printf("O saldo atual da sua conta corrente �: R$%.2f %n", this.getSaldo());
			this.setChequeEspecial(400);
			System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());			
		}		
	}
	
	
	
	//---------------------Getters and Setters-------------------//

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public String getAtendimento() {
		return atendimento;
	}	
	
}
