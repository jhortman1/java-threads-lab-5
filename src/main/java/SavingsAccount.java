public class SavingsAccount {

  private long total = 0;

  public synchronized boolean withdraw(long amount) {
      if(this.total >= amount)
      {
        this.total -= amount;
        return true;
      }
      return false;
  }

  public void deposit(long amount) {
        this.total += amount;
  }

  public long getTotal() {
      return total;
  }
}