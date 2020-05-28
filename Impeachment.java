import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

class Impeachment{

	//CRIAÇÃO DE VARIÁVEIS GLOBAIS
	static Scanner pudim = new Scanner(System.in);
	static int votos;
	static String breakline = "";


	public static void main(String[]args){

        //SOLICITAÇÃO AO USUÁRIO DO NUMERO DE PARTICIPANTES DA VOTAÇÃO
		System.out.println("Digite o numero de participantes da votacao:");
		votos = pudim.nextInt();
		System.out.println("");
		breakline = pudim.nextLine();
       
       	//SET SÓ DE PARTIDOS
        HashSet<String> partidos = new HashSet<String>();
        //SET SÓ DE ESTADOS
        HashSet<String> estados = new HashSet<String>();
		
        //CRIAÇÃO DA MATRIZ DE DADOS DOS DEPUTADOS
		String[][]tabela = new String[votos][4];

        //CHAMANDO A FUNÇÃO QUE IRÁ SOLICITAR AO USUÁRIO O PREENCHIMENTO DA MATRIZ DE DADOS
        dados(tabela, estados, partidos);

		//CONVERTENDO SET => ARRAY
		String[] valorPartidos = partidos.toArray(new String[partidos.size()]);
		String[] valorEstados = estados.toArray(new String[estados.size()]);
        
        //APURAÇÃO DOS VOTOS E PRINT DO RESULTADO FINAL E DA VOTAÇÃO
        votacao(tabela);
        
        //APURAÇÃO DOS VOTOS POR PARTIDOS
        votosporPartidos(tabela, valorPartidos);
        //APURAÇÃO DOS VOTOS POR ESTADOS
        votosporEstados(tabela, valorEstados);

	}    

	public static void dados(String[][]tabela, HashSet<String> estados, HashSet<String> partidos){   
	//CRIAÇÃO DA MATRIZ
		//next line usado para a String armazenar espaços
		for(int i = 0; i < votos; i++){
			System.out.println("Digite o nome do deputado federal:");
			tabela[i][0] = pudim.nextLine();
			System.out.println("Digite o partido ao qual o deputado eh filiado:");
			tabela[i][1] = pudim.nextLine(); 
			partidos.add(tabela[i][1]); //ADICIONANDO OS PARTIDOS A SET LIST DE PARTIDOS
			System.out.println("Digite o estado (XX) que o deputado representa:");
			tabela[i][2] = pudim.nextLine();
			estados.add(tabela[i][2]); //ADICIONANDO OS PARTIDOS A SET LIST DE ESTADOS
			System.out.println("Digite o voto do deputado (favor, contra ou nulo):");
			tabela[i][3] = pudim.nextLine();
			}
		}	

	public static void votacao(String tabela[][]){
		//CONTABILIZAR VOTOS 
		String resultado = "";
		int favor = 0;
		int contra = 0;
		int nulo = 0;

		for(int i = 0;i < votos; i++){
				if(tabela[i][3].equalsIgnoreCase("favor")){
					favor++;
			}

				else if(tabela[i][3].equalsIgnoreCase("contra")){
					contra ++;	
				}

				else{
					nulo++;
				}

		}

		//VERIFICAR RESULTADO FINAL 
		if(favor >= votos * (2 / 3)){
			resultado = "IMPEACHMENT APROVADO";
		}

		else{
			resultado = "IMPEACHMENT REPROVADO";
		}

	
		//PRINT DO RESULTADO E DOS VOTOS GERAIS
		System.out.println(" ");
		System.out.println("                    " + resultado + "                    ");
		System.out.println(" ");
		System.out.println("FAVOR: " + favor + "   CONTRA: " +  contra + "   NULOS: " + nulo);

	}//votacao


	public static void votosporPartidos(String [][]tabela, String[]valorPartidos){
	//APURAÇÃO DOS VOTOS POR PARTIDOS
		System.out.println("_________________________________________________________");
		System.out.println(" ");
		System.out.println("                    VOTOS POR PARTIDOS                   ");
		System.out.println(" ");

		//VOTOS POR PARTIDOS
		int yes = 0;
		int no = 0;
		int blank = 0;

		for(int i = 0; i < valorPartidos.length; i++){
			for(int x = 0; x < votos; x++){
				if(tabela[x][1].equalsIgnoreCase(valorPartidos[i])){
					if(tabela[x][3].equalsIgnoreCase("favor")){
						yes++;	
					}

					else if(tabela[x][3].equalsIgnoreCase("contra")){
						no++;	
					}

					else{
						blank++;
					}
				}//if

				else{
					continue;
				}//else

			}//for interno

			System.out.println("VOTOS " + valorPartidos[i] + ":");
			System.out.println("Favor: " + yes + "	Contra: " + no + "	Nulo: " + blank);
			yes = 0; no = 0; blank = 0;

		}//for externo

	}

	public static void votosporEstados(String [][]tabela, String[]valorEstados){
	//APURAÇÃO DOS VOTOS POR ESTADOS
		//ESPAÇAMENTO
		System.out.println("_________________________________________________________");
		System.out.println(" ");
		System.out.println("                    VOTOS POR ESTADOS                   ");
		System.out.println(" ");

		int sim = 0;
		int nao = 0;
		int nulo = 0;

		//VOTOS POR ESTADOS
		for(int i = 0; i < valorEstados.length; i++){
			for(int x = 0; x < votos; x++){
				if(tabela[x][2].equalsIgnoreCase(valorEstados[i])){
					if(tabela[x][3].equalsIgnoreCase("favor")){
						sim++;	
					}

					else if(tabela[x][3].equalsIgnoreCase("contra")){
						nao++;	
					}

					else{
						nulo++;
					}
				}//if

				else{
					continue;
				}//else

			}//for interno
			System.out.println("VOTOS " + valorEstados[i] + ":");
			System.out.println("Favor: " + sim + "	Contra: " + nao + "	Nulo: " + nulo);
			sim = 0; nao = 0; nulo = 0;

		}//for externo
	
	}
}