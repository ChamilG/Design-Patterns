public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory factory1 = new LightFactory();
        Button btn1 = factory1.createButton();
        btn1.clicks();
    }
}

interface Button{
    void clicks();
}

interface TextField{
   void insert();
}


class LightButton implements Button{
    public void clicks(){
        System.out.println("light button clicks");
    }
}

class DarkButton implements Button{
    public void clicks(){
        System.out.println("dark button clicks");
    }
}

class LightText implements TextField{
    public void insert(){
        System.out.println("light insert");
    }
}
class DarkText implements TextField{
    public void insert(){
        System.out.println("dark insert");
    }
}



interface Factory{
    Button createButton();
    TextField createTextField();
}


class LightFactory implements Factory{
    public Button createButton(){
        return new LightButton();
    }

    public TextField createTextField(){
        return new LightText();
    }
}

class DarkFactory implements Factory{
     public Button createButton(){
        return new DarkButton();
    }

    public TextField createTextField(){
        return new DarkText();
    }

}