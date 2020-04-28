public class Kabigon extends Pokemon{
    //Constructor
    public Kabigon(String name){
        super(name, 1000);
    }
    //Abstract Method from Pokemon class 
    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(5);
    }
}