
public class Poupanca extends Conta{
	
	public double saldoPoupanca;
	public double projecaoSaldo;
	public double rendimento = 0.35;
	public int prazo = 12;
	//----- Construtor -----//
	public Poupanca(String titular, int numero, double saldo, double saldoPoupanca) {		super(titular, numero, saldo);
		this.saldoPoupanca = saldoPoupanca;
	}
	
	//----- Método mostrar Dados do Cliente -----//
	public void dados() {
		super.dados();
		System.out.printf("Saldo atual da poupança: R$%.2f %n%n",this.getSaldoPoupanca());	
	}
	
	//----- Método Sacar -----//
	public void sacar(double valor) {
		System.out.println("|---------------------------- Banco Java - Conta Poupança - Saque -------------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Saldo atual da poupança: R$%.2f %n",this.getSaldoPoupanca());	
		System.out.printf("Solicitação de saque no valor de R$%.2f %n",valor);
		
		
		// Se o valor solicitado para saque for suficiente
		if(this.getSaldoPoupanca() > valor) {
			System.out.printf("Saque realizado com sucesso.%n");
			this.setSaldoPoupanca(this.getSaldoPoupanca() - valor);
			System.out.printf("Saldo atual da poupança: R$%.2f %n%n",this.getSaldoPoupanca());			

		// Se o valor disponível for menor que o valor solicitado para saque
		}else {
			System.out.printf("Saque não realizado. Limite indisponível %n%n");
		}			
	}
	
	//----- Método Depositar -----//
	public void depositar(double valor) {
		System.out.println("|------------------------- Banco Java - Conta Poupança - Depósito -------------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Foi efetuado um depósito de R$%.2f %n",valor);
		
		//Soma o valor depositado com o saldo da atual da poupança
		this.setSaldoPoupanca(this.getSaldoPoupanca() + valor);
		System.out.printf("Saldo atual da poupança: R$%.2f %n%n",this.getSaldoPoupanca());	
	}
	
	
	
	//----- Método Projetar Rendimento da Poupança -----//
	public void projecao() {
		System.out.println("|-------------------------- Banco Java - Conta Poupança - Rendimentos -----------------------|");
		System.out.println("Titular da conta: "+this.getTitular());
		System.out.printf("Saldo atual da poupança: R$%.2f %n",this.getSaldoPoupanca());	
		System.out.printf("Projeção de rendimentos para os próximo 12 meses:%n");
		System.out.println("Taxa mensal de rendimentos "+this.rendimento+"% \n");
		System.out.printf("Valor inicial: R%.2f %n",this.getSaldoPoupanca());

		for(int i=0; i<prazo; i++) {
			//Calcula o rendimento mensal
			this.setProjecaoSaldo(this.getProjecaoSaldo() + ((this.getSaldoPoupanca() * rendimento)/100));
			
			//Soma o saldo da poupança com o rendimento mensal e exibe na tela
			System.out.printf("%dº mês: R$%.2f %n", (i+1),this.getSaldoPoupanca()+this.getProjecaoSaldo());
		}
		System.out.printf("%n");
	}
	
	//---------------------Getters and Setters-------------------//
	
	//-----Projeção do Rendimento-----//
	public double getProjecaoSaldo() {
		return projecaoSaldo;
	}

	public void setProjecaoSaldo(double projecaoSaldo) {
		this.projecaoSaldo = projecaoSaldo;
	}
	
	//-----Saldo da Poupança-----//
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
