
public class ContaEspecial extends Conta{
	
	private final String atendimento = "Com prioridades";
	public double chequeEspecial = 300;
	
	// ----- Construtor -----//
	public ContaEspecial(String titular, int numero, double saldo, double chequeEspecial) {
		super (titular, numero, saldo);
		this.chequeEspecial = chequeEspecial;
	}
	
	//----- Método mostrar Dados do Cliente -----//
	public void  dados() {
		super.dados();
		System.out.println("Atendimento: "+this.getAtendimento());
		System.out.printf("Limite Cheque Especial: R$%.2f %n%n",this.getChequeEspecial());		
	}
	
	//----- Método Sacar -----//
	public void sacar(double valor) {
		System.out.println("|---------------------- Banco Java - Conta Especial - Saque ----------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Solicitação de saque no valor de R$%.2f %n",valor);
		
		if(this.getSaldo() >= valor) {
			this.saldo -= valor;
			System.out.printf("Saque realizado com sucesso.%nSeu saldo atual é de: R$%.2f %n", this.getSaldo());
			System.out.printf("Seu limite atual é de: R$%.2f %n%n", this.getChequeEspecial());
			
		}else if((this.getSaldo()) < valor) {		
			this.chequeEspecial = this.chequeEspecial - (valor - this.getSaldo());
			
			if(this.getChequeEspecial() < 0) {
				System.out.printf("***Saque não realizado. Seu Limite Especial disponível não é suficiente*** %n%n");
			}else {
				System.out.printf("Seu saldo disponível não é suficiente. Você entrará no limite %n");
				this.setSaldo(this.getSaldo()-valor);
				System.out.printf("Saque realizado com sucesso%nO saldo atual da sua conta corrente é de: R$%.2f %n", this.getSaldo());
				System.out.printf("Seu saldo especial é: R$%.2f %n%n", this.getChequeEspecial());
			}
			
		}else {
			System.out.printf("Saque não realizado. Limite indisponível %n");
		}
	}
	
	//----- Método Depositar -----//
	public void depositar(double valor) {
		System.out.println("|--------------------- Banco Java - Conta Especial - Depósito ---------------------|");
		System.out.printf("Foi efetuado um depósito de R$%.2f %n",valor);
				
		if(this.getSaldo() < 0) {
			this.setSaldo(this.getSaldo() + valor);
			
			if(this.getSaldo() < 0) {
				System.out.printf("O saldo atual da sua conta corrente é: R$%.2f %n", this.getSaldo());
				this.setChequeEspecial(400 + this.getSaldo());
				System.out.printf("Seu saldo especial é: R$%.2f %n%n", this.getChequeEspecial());						
			}else {
				System.out.printf("O saldo atual da sua conta corrente é: R$%.2f %n", this.getSaldo());
				this.setChequeEspecial(400);
				System.out.printf("Seu saldo especial é: R$%.2f %n%n", this.getChequeEspecial());
			}
		}else {
			this.setSaldo(this.getSaldo()+valor);
			System.out.printf("O saldo atual da sua conta corrente é: R$%.2f %n", this.getSaldo());
			this.setChequeEspecial(400);
			System.out.printf("Seu saldo especial é: R$%.2f %n%n", this.getChequeEspecial());			
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
