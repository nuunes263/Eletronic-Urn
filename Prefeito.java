public class Prefeito extends Candidato {
  public static int totalPrefeito = 0;
  public int votos;
  
  public Prefeito (String nome, int numero, String partido, String cargo){
    super(nome, numero, partido, cargo);
    Prefeito.totalPrefeito = Prefeito.totalPrefeito + 1; 
  }

  public Prefeito(){
    Prefeito.totalPrefeito = Prefeito.totalPrefeito + 1; 
  }

  public Prefeito(int votos){
    this.votos = votos;
    Prefeito.totalPrefeito = Prefeito.totalPrefeito + 1;   
  }

  public static int getTotalPrefeito(){
    return Prefeito.totalPrefeito;
  }
}