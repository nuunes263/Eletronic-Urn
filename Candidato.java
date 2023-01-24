public class Candidato {
  public String nome;
  public int numero;
  public String partido;
  public String cargo;  
  public static int totalCandidato = 0;

  public Candidato(String nome, int numero, String partido, String cargo){
    this.nome = nome;
    this.numero = numero;
    this.partido = partido;
    this.cargo = cargo;  
    Candidato.totalCandidato = Candidato.totalCandidato + 1;
  }

  public Candidato(){
    Candidato.totalCandidato = Candidato.totalCandidato + 1;
  }

  public static int getTotalCandidato(){
    return Candidato.totalCandidato;
  }
  
}
