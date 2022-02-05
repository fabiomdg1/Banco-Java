
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
		
		//Se o saldo for maior que o valor de saque solicitado
		if(this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo()-valor);
			System.out.printf("Saque realizado com sucesso.%nSeu saldo atual � de: R$%.2f %n", this.getSaldo());
			
			//Mostra o valor total do Limite
			//Limite n�o foi utilizado
			System.out.printf("Seu limite atual � de: R$%.2f %n%n", this.getChequeEspecial());
			
		//Se o saque solicitado for maior que o saldo da conta
		//O Limite da conta ser� usado
		}else if((this.getSaldo()) < valor) {	
			//Subtrai do Limite o valor sacado mais o valor do saldo existente na conta
			//Se n�o for suficiente o limite mais o saldo, o saque n�o � realizado
			this.chequeEspecial = this.chequeEspecial - (valor - this.getSaldo());
			
			//Limite da conta zerado
			if(this.getChequeEspecial() < 0) {
				System.out.printf("***Saque n�o realizado. Seu Limite Especial dispon�vel n�o � suficiente*** %n%n");
			
			//Limite suficiente para disponibilizar o saque solicitado
			}else {
				System.out.printf("Seu saldo dispon�vel n�o � suficiente. Voc� entrar� no limite %n");
				this.setSaldo(this.getSaldo()-valor);
				System.out.printf("Saque realizado com sucesso%nO saldo atual da sua conta corrente � de: R$%.2f %n", this.getSaldo());
				//Mostra Limite restante
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());
			}
			
		}else {
			//Saldo mais limite n�o foi suficiente para efetuar o saque
			System.out.printf("Saque n�o realizado. Limite indispon�vel %n");
		}
	}
	
	//----- M�todo Depositar -----//
	public void depositar(double valor) {
		System.out.println("|--------------------- Banco Java - Conta Especial - Dep�sito ---------------------|");
		System.out.printf("Foi efetuado um dep�sito de R$%.2f %n",valor);
				
		//Se o saldo for negativo, ser� enviado o valor depositado para o limite.
		if(this.getSaldo() < 0) {
			this.setSaldo(this.getSaldo() + valor);
			
			//Se o valor depositado n�o for suficiente para repor o limite.
			if(this.getSaldo() < 0) {
				System.out.printf("O saldo atual da sua conta corrente �: R$%.2f %n", this.getSaldo());
				
				//Atualiza o valor do cheque especial.
				this.setChequeEspecial(400 + this.getSaldo());
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());						
			
			//Se o valor do dep�sito for suficiente para zerar o limite utilizado.			
			}else {
				System.out.printf("O saldo atual da sua conta corrente �: R$%.2f %n", this.getSaldo());
				//O limite ser� reposto para o valor original e o valor excedente ir� para o saldo da conta.
				this.setChequeEspecial(400);
				System.out.printf("Seu saldo especial �: R$%.2f %n%n", this.getChequeEspecial());
			}
		
		//Se o limite n�o foi usado, o valor depositado � somano no saldo.
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
