public class Raichu extends Pokemon {
    //Constructor
    public Raichu(String name){
        super(name, 500);
    }

    //Abstract Method from Pokemon class 
    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }
}