public class Pikachu extends Pokemon{
    //Constructor
    public Pikachu(String name){
        super(name, 10, "");
    }

    public Pikachu(String name, int maxHP){
        super(name, maxHP, "");
    }

    //Abstract Method from Pokemon class 
    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack "+ enemy.getName());
        enemy.damage(10);
    }
}