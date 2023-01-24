import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int opcao = 0;
    char resposta = ' ';
    int presidenteNulo = 0, presidenteBranco = 0, governadorNulo = 0, governadorBranco = 0, prefeitoNulo = 0, prefeitoBranco = 0;
    int votosTotal = 0;
    
    Presidente [] vetPresidente;
    vetPresidente = new Presidente[100];
    Governador [] vetGovernador;
    vetGovernador = new Governador[100];
    Prefeito [] vetPrefeito;
    vetPrefeito = new Prefeito[100];
    Eleitor [] vetEleitor;
    vetEleitor = new Eleitor[100];
  
    do {
      System.out.println(" \n ----- MENU - SIMULADOR DO SISTEMA DE VOTAÇÃO ----- \n\n");
      System.out.println("1. Cadastrar Candidatos");  
      System.out.println("2. Cadastrar Eleitores");  
      System.out.println("3. Votar");  
      System.out.println("4. Apurar resultados");  
      System.out.println("5. Relatorios e Estatisticas");  
      System.out.println("6. Encerrar");  
      System.out.print("Opcao escolhida: ");
      opcao = entrada.nextInt();
      switch(opcao){
        case 1:
          CandidatoLista(resposta, vetPrefeito, vetGovernador, vetPresidente);
          break;
        case 2:
          EleitorLista(vetEleitor, resposta);
          break;
        case 3:
          votoLista(vetPrefeito, vetGovernador, vetPresidente, presidenteNulo, presidenteBranco, governadorNulo, governadorBranco, prefeitoNulo, prefeitoBranco ); 
          break; 
        case 4:
          votosTotal = resultado(vetPrefeito, vetGovernador, vetPresidente, presidenteNulo, presidenteBranco, governadorNulo, governadorBranco, prefeitoNulo, prefeitoBranco);
          break;
        case 5:
          relatorio(vetEleitor, votosTotal);
          break;
      }
    } while(opcao != 6);    
  }
  
  public static void CandidatoLista(char resposta, Prefeito [] vetPrefeito,Governador [] vetGovernador,Presidente [] vetPresidente){
    Scanner input = new Scanner(System.in);
    
    do{
      System.out.println("\n");
      System.out.print("Adicionar candidato? (s/n) ");
      resposta = input.next().charAt(0);
      if (resposta == 's'){
        System.out.println("opcoes da urna: presidente, governador e prefeito.");
        System.out.print("digite o cargo do candidato: ");
        String c = input.next();      
        switch(c){
          case "presidente":
            Presidente novoPresidente = new Presidente(0);
            int totalPresidente = novoPresidente.getTotalPresidente() - 1;
            vetPresidente[totalPresidente] = novoPresidente;
            System.out.print("digite o nome do presidente: ");
            vetPresidente[totalPresidente].nome = input.next();
            System.out.print("digite o numero do presidente: ");
            vetPresidente[totalPresidente].numero = input.nextInt(); 
            System.out.print("digite o partido do presidente: ");
            vetPresidente[totalPresidente].partido = input.next();
            vetPresidente[totalPresidente].cargo = "presidente"; 
            System.out.println(" \n -- LISTA DE PRESIDENTES --\n");
            System.out.println("nome, numero e partido:\n ");
            for (int i = 0; i < totalPresidente + 1; i++){
              System.out.print(vetPresidente[i].nome);
              System.out.print(" "+ vetPresidente[i].numero);
              System.out.println(" "+ vetPresidente[i].partido);
            }
            break;
          case "governador":
            Governador novoGovernador = new Governador(0);
            int totalGovernador = novoGovernador.getTotalGovernador() - 1;
            vetGovernador[totalGovernador] = novoGovernador;
            System.out.print("digite o nome do governador: ");
            vetGovernador[totalGovernador].nome = input.next();
            System.out.print("digite o numero do governador: ");
            vetGovernador[totalGovernador].numero = input.nextInt(); 
            System.out.print("digite o partido do governador: ");
            vetGovernador[totalGovernador].partido = input.next();
            vetGovernador[totalGovernador].cargo = "governador"; 
            System.out.println(" \n -- LISTA DE GOVERNADORES --\n");
            System.out.println("nome, numero e partido:\n ");
            for (int i = 0; i < totalGovernador + 1; i++){
              System.out.print(vetGovernador[i].nome);
              System.out.print(" "+ vetGovernador[i].numero);
              System.out.println(" "+ vetGovernador[i].partido);
            }
            break;
          case "prefeito":
            Prefeito novoPrefeito = new Prefeito(0);
            int totalPrefeito = novoPrefeito.getTotalPrefeito() - 1;
            vetPrefeito[totalPrefeito] = novoPrefeito;
            System.out.print("digite o nome do prefeito: ");
            vetPrefeito[totalPrefeito].nome = input.next();
            System.out.print("digite o numero do prefeito: ");
            vetPrefeito[totalPrefeito].numero = input.nextInt(); 
            System.out.print("digite o partido do prefeito: ");
            vetPrefeito[totalPrefeito].partido = input.next();
            vetPrefeito[totalPrefeito].cargo = "prefeito"; 
            System.out.println(" \n -- LISTA DE PREFEITOS --\n");
            System.out.println("nome, numero e partido:\n ");
            for (int i = 0; i < totalPrefeito + 1; i++){
              System.out.print(vetPrefeito[i].nome);
              System.out.print(" "+ vetPrefeito[i].numero);
              System.out.println(" "+ vetPrefeito[i].partido);
            }
            break;
        }
               
       }
    }while(resposta != 'n');
  
  } 

  public static void EleitorLista(Eleitor [] vetEleitor, char resposta){
    do {
      Scanner x = new Scanner(System.in);
      System.out.println("\n");
      System.out.print("Adicionar eleitor? (s/n) ");
      resposta = x.next().charAt(0);
      if (resposta == 's'){
        Eleitor novoEleitor = new Eleitor();
        int totalEleitor = novoEleitor.getTotalEleitor() - 1;
        vetEleitor[totalEleitor] = novoEleitor;
        System.out.print("digite o nome do eleitor: ");
        vetEleitor[totalEleitor].nome = x.next();
        System.out.print("digite o cpf do eleitor: ");
        vetEleitor[totalEleitor].cpf = x.next();
        System.out.println(" \n -- LISTA DE ELEITORES --\n");
        System.out.println("nome e cpf:\n ");
          for (int i = 0; i < totalEleitor + 1; i++){
            System.out.print(vetEleitor[i].nome);
            System.out.println(" "+ vetEleitor[i].cpf);
          }
      }
    } while(resposta != 'n');
  }

  public static void votoLista(Prefeito [] vetPrefeito,Governador [] vetGovernador,Presidente [] vetPresidente, int presidenteNulo, int presidenteBranco, int governadorNulo, int governadorBranco, int prefeitoNulo, int prefeitoBranco){
    Scanner entrada = new Scanner(System.in);
    System.out.println("PRESIDENTE");
    System.out.print("digite o numero do candidato: ");
    int a = entrada.nextInt();
    if (a == -2){
      System.out.print("digite CONFIRMAR para anular o seu voto: ");
      String t = entrada.next();
      if (t.equals("CONFIRMAR")){
        presidenteNulo++;
      }
    }
    if (a == -1){
      System.out.print("digite CONFIRMAR para votar em branco: ");
      String t = entrada.next();
      if (t.equals("CONFIRMAR")){
        presidenteBranco++;
      }
    }
    
    for (int i = 0; i < vetPresidente[i].getTotalPresidente(); i++){
      if (a == vetPresidente[i].numero){
        System.out.print(vetPresidente[i].nome);
        System.out.print("digite CONFIRMAR para confirmar seu voto: ");
        String b = entrada.next();
        String c = "CONFIRMAR";
        if (b.equals(c)){          
          vetPresidente[i].votos = vetPresidente[i].votos + 1;        
        }
      } 
    }
    
    System.out.println("GOVERNADOR");
    System.out.print("digite o numero do candidato: ");
    int d = entrada.nextInt();
    if (d == -2){
      System.out.print("digite CONFIRMAR para anular o seu voto: ");
      String t = entrada.next();
      if (t.equals("CONFIRMAR")){
        governadorNulo++;
      }
    }
      if (d == -1){
        System.out.print("digite CONFIRMAR para votar em branco:");
        String t = entrada.next();
        if (t.equals("CONFIRMAR")){
          governadorBranco++;
        }
      }
    for (int i = 0; i < vetGovernador[i].getTotalGovernador(); i++){
      if (d == vetGovernador[i].numero){
        System.out.println(vetGovernador[i].nome);
        System.out.print("digite CONFIRMAR para confirmar seu voto: ");
        String e = entrada.next();
        String f = "CONFIRMAR";
        if (e.equals(f)){          
          vetGovernador[i].votos = vetGovernador[i].votos + 1;    
        }
      } 
    }
    System.out.println("PREFEITO");
    System.out.print("digite o numero do candidato: ");
    int ad = entrada.nextInt();
    if (ad == -2){
      System.out.print("digite CONFIRMAR para anular o seu voto: ");
      String q = entrada.next();
      if (q.equals("CONFIRMAR")){
        prefeitoNulo++;
      }
    }
    if (ad == -1){
      System.out.print("digite CONFIRMAR para votar em branco:");
      String t = entrada.next();
      if (t.equals("CONFIRMAR")){
        prefeitoBranco++;
        }
      }
    for (int i = 0; i < vetPrefeito[i].getTotalPrefeito(); i++){  
      if (ad == vetPrefeito[i].numero){
        System.out.println(vetPrefeito[i].nome);
        System.out.print("digite CONFIRMAR para confirmar seu voto: ");
        String h = entrada.next();
        String j = "CONFIRMAR";
        if (h.equals(j)){          
          vetPrefeito[i].votos = vetPrefeito[i].votos + 1;    
        }
      } 
    }
  }  
      
  public static int resultado(Prefeito [] vetPrefeito,Governador [] vetGovernador, Presidente [] vetPresidente, int presidenteNulo, int presidenteBranco, int governadorNulo, int governadorBranco, int prefeitoNulo, int prefeitoBranco){
    int maiorPresidente = 0;
    String nomePresidente = " ";
    int maiorGovernador = 0;
    String nomeGovernador = " ";
    int maiorPrefeito = 0;
    String nomePrefeito = " ";
    int totalVotosPresidente = 0;
    int totalVotosPrefeito = 0;
    int totalVotosGovernador = 0;
    
    for (int i = 0; i < 100; i++){
        if (vetPresidente[i] != null && vetPresidente[i].votos > maiorPresidente){
          maiorPresidente = vetPresidente[i].votos;
          nomePresidente = vetPresidente[i].nome;
        }
    }
    System.out.println("\nO vencedor para presidente foi "+ nomePresidente);
    for(int i = 0; i < 100; i++){
      if (vetPresidente[i] != null){
        totalVotosPresidente = totalVotosPresidente + vetPresidente[i].votos;
      }
    }
    System.out.printf("total de votos = %d\n", presidenteNulo+presidenteBranco+totalVotosPresidente );
    System.out.printf("total de votos validos = %d\n", totalVotosPresidente + presidenteBranco);
    System.out.printf("total de votos brancos = %d\n", presidenteBranco);
    System.out.printf("total de votos nulos = %d\n", presidenteNulo);
    for (int i = 0; i < 100; i++){
        if (vetGovernador[i] != null && vetGovernador[i].votos > maiorGovernador){
          maiorGovernador = vetGovernador[i].votos;
          nomeGovernador = vetGovernador[i].nome;
        }
    }
    System.out.println("\nO vencedor para governador foi "+ nomeGovernador);
    for(int i = 0; i < 100; i++){
      if (vetGovernador[i] != null){
        totalVotosGovernador = totalVotosGovernador + vetGovernador[i].votos;
      }
    }
    System.out.printf("total de votos = %d\n", governadorNulo+governadorBranco+totalVotosGovernador );
    System.out.printf("total de votos validos = %d\n", totalVotosGovernador + governadorBranco);
    System.out.printf("total de votos brancos = %d\n", governadorBranco);
    System.out.printf("total de votos nulos = %d\n", governadorNulo);
    for (int i = 0; i < 100; i++){
        if (vetPrefeito[i] != null && vetPrefeito[i].votos > maiorPrefeito){
          maiorPrefeito = vetPrefeito[i].votos;
          nomePrefeito = vetPrefeito[i].nome;
        }
    }
    System.out.println("\nO vencedor para prefeito foi "+ nomePrefeito + "\n");
    for(int i = 0; i < 100; i++){
      if (vetPrefeito[i] != null){
        totalVotosPrefeito = totalVotosPrefeito + vetPrefeito[i].votos;
      }
    }
    System.out.printf("total de votos = %d\n", prefeitoNulo+prefeitoBranco+totalVotosPrefeito);
    System.out.printf("total de votos validos = %d\n", totalVotosPrefeito+ prefeitoBranco);
    System.out.printf("total de votos brancos = %d\n", prefeitoBranco);
    System.out.printf("total de votos nulos = %d\n", prefeitoNulo);
    return presidenteNulo+presidenteBranco+totalVotosPresidente+governadorNulo+governadorBranco+totalVotosGovernador+prefeitoNulo+prefeitoBranco+totalVotosPrefeito;
  }
  

  public static void relatorio(Eleitor [] vetEleitor, int votosTotal){
    System.out.println(" \n -- LISTA DE ELEITORES --\n");
    System.out.println("nome e cpf:\n ");
    for (int i = 0; i < vetEleitor[i].getTotalEleitor() + 1; i++){
      if (vetEleitor[i] != null){
      System.out.print(vetEleitor[i].nome);
      System.out.println(" "+ vetEleitor[i].cpf);
      }
    }
    if(vetEleitor[0].getTotalEleitor() == votosTotal){
      System.out.println("O numero de eleitores condiz com os votos");
    }
    else{
      System.out.println("O numero de eleitores nao condiz com os votos");
    }  
  }
}