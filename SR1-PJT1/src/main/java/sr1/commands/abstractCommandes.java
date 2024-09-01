package sr1.commands;

import sr1.SocketCommandes;

public abstract class abstractCommandes implements Commandes{
  protected SocketCommandes s;

  public abstractCommandes(SocketCommandes s){
    this.s = s;
  }
}
