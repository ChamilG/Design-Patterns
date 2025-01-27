public class singleton {
    
    public static void main(String[] args) {
        Instance instance1 = Instance.getInstance();
        Instance instance2 = Instance.getInstance();

        System.out.println(instance1 == instance2);
    }
    
}

class Instance{
     private static Instance instance;

     private Instance(){

     }
    
     public static Instance getInstance(){
        if(instance == null){
            instance = new Instance();
        }

        return instance;
     }


}
