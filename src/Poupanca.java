
public class Poupanca extends Conta{
	
	public double saldoPoupanca;
	public double projecaoSaldo;
	public double rendimento = 0.35;
	public int prazo = 12;
	//----- Construtor -----//
	public Poupanca(String titular, int numero, double saldo, double saldoPoupanca) {		super(titular, numero, saldo);
		this.saldoPoupanca = saldoPoupanca;
	}
	
	//----- M�todo mostrar Dados do Cliente -----//
	public void dados() {
		super.dados();
		System.out.printf("Saldo atual da poupan�a: R$%.2f %n%n",this.getSaldoPoupanca());	
	}
	
	//----- M�todo Sacar -----//
	public void sacar(double valor) {
		System.out.println("|---------------------------- Banco Java - Conta Poupan�a - Saque -------------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Saldo atual da poupan�a: R$%.2f %n",this.getSaldoPoupanca());	
		System.out.printf("Solicita��o de saque no valor de R$%.2f %n",valor);
		
		
		// Se o valor solicitado para saque for suficiente
		if(this.getSaldoPoupanca() > valor) {
			System.out.printf("Saque realizado com sucesso.%n");
			this.setSaldoPoupanca(this.getSaldoPoupanca() - valor);
			System.out.printf("Saldo atual da poupan�a: R$%.2f %n%n",this.getSaldoPoupanca());			

		// Se o valor dispon�vel for menor que o valor solicitado para saque
		}else {
			System.out.printf("Saque n�o realizado. Limite indispon�vel %n%n");
		}			
	}
	
	//----- M�todo Depositar -----//
	public void depositar(double valor) {
		System.out.println("|------------------------- Banco Java - Conta Poupan�a - Dep�sito -------------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Foi efetuado um dep�sito de R$%.2f %n",valor);
		
		//Soma o valor depositado com o saldo da atual da poupan�a
		this.setSaldoPoupanca(this.getSaldoPoupanca() + valor);
		System.out.printf("Saldo atual da poupan�a: R$%.2f %n%n",this.getSaldoPoupanca());	
	}
	
	
	
	//----- M�todo Projetar Rendimento da Poupan�a -----//
	public void projecao() {
		System.out.println("|-------------------------- Banco Java - Conta Poupan�a - Rendimentos -----------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Saldo atual da poupan�a: R$%.2f %n",this.getSaldoPoupanca());	
		System.out.printf("Proje��o de rendimentos para os pr�ximo 12 meses:%n");
		System.out.println("Taxa mensal de rendimentos "+this.rendimento+"% \n");
		System.out.printf("Valor inicial: R%.2f %n",this.getSaldoPoupanca());

		for(int i=0; i<prazo; i++) {
			//Calcula o rendimento mensal
			this.setProjecaoSaldo(this.getProjecaoSaldo() + ((this.getSaldoPoupanca() * rendimento)/100));
			
			//Soma o saldo da poupan�a com o rendimento mensal e exibe na tela
			System.out.printf("%d� m�s: R$%.2f %n", (i+1),this.getSaldoPoupanca()+this.getProjecaoSaldo());
		}
		System.out.printf("%n");
	}
	
	//---------------------Getters and Setters-------------------//
	
	//-----Proje��o do Rendimento-----//
	public double getProjecaoSaldo() {
		return projecaoSaldo;
	}

	public void setProjecaoSaldo(double projecaoSaldo) {
		this.projecaoSaldo = projecaoSaldo;
	}
	
	//-----Saldo da Poupan�a-----//
	public double getSaldoPoupanca() {
		return saldoPoupanca;
	}

	public void setSaldoPoupanca(double saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}

	//-----Taxa de Rendimento-----//
	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
}
