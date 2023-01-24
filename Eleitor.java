public class Eleitor {
  public String nome;
  public String cpf;
  public static int totalEleitor = 0;

  public Eleitor(String nome, String cpf){
    this.nome = nome;
    this.cpf = cpf;
    Eleitor.totalEleitor = Eleitor.totalEleitor + 1;
  }

  public Eleitor(){
    Eleitor.totalEleitor = Eleitor.totalEleitor + 1;
  }

  public static int getTotalEleitor(){
    return Eleitor.totalEleitor;
  }

}