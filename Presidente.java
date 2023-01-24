public class Presidente extends Candidato {
  private static int totalPresidente = 0;
  public int votos;
  
  public Presidente (String nome, int numero, String partido, String cargo){
    super(nome, numero, partido, cargo);
    Presidente.totalPresidente = Presidente.totalPresidente + 1;   
  }

  public Presidente(){
    Presidente.totalPresidente = Presidente.totalPresidente + 1;    
  } 

  public Presidente(int votos){
    this.votos = votos;
    Presidente.totalPresidente = Presidente.totalPresidente + 1;   
  }

  public static int getTotalPresidente(){
    return Presidente.totalPresidente;
  }
  
}