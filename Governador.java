public class Governador extends Candidato {
  public static int totalGovernador = 0;
  public int votos;
  
  public Governador (String nome, int numero, String partido, String cargo){
    super(nome, numero, partido, cargo);
    Governador.totalGovernador = Governador.totalGovernador + 1;
  }

  public Governador(){
    Governador.totalGovernador = Governador.totalGovernador + 1; 
  }

  public Governador(int votos){
    this.votos = votos;
    Governador.totalGovernador = Governador.totalGovernador + 1;   
  }

  public static int getTotalGovernador(){
    return Governador.totalGovernador;
  }

}