public class FactoryPattern {

    public static void main(String[] args) {
        ReciepientFactory rfactory = new ReciepientFactory(); // its better if the creating method is static so no need to create object of the factory
        Recipient reciepientdemo = rfactory.createRecipient("recipient1");
        reciepientdemo.receive();
    }
    
}

interface Recipient{
    void receive();
}

class ReciepientFactory{

    public Recipient createRecipient(String recipient) { //better if this is static
        switch(recipient.toLowerCase()){
            case "recipient1":
                return new Reciepient1();
            case "recipient2":
                return new Reciepient1();
            case "recipient3":
                return new Reciepient1();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + recipient);
        }
    }
     
}


class Reciepient1 implements Recipient{

  @Override
  public void receive(){
    System.out.println("receive1");
  }
}

class Reciepint2 implements Recipient{
    @Override
  public void receive(){
    System.out.println("receive2");
  }
}

class Reciepient3 implements Recipient{
    @Override
  public void receive(){
    System.out.println("receive3");
  }
}