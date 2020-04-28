public abstract class Pokemon{
    //Attribute
    protected static String name;
    protected static int hp;
    
    //Constructor
    public Pokemon(String name){
        this.name = name;
        this.hp = 0;
    }

    public Pokemon(String name, int maxHP){
        this.name = name;
        this.hp = (int)(Math.random()*maxHP);
    }

    //Accessor Method
    public static String getName(){
        return name;
    }

    public static int getHP(){
        return hp;
    }

    //Mutator Method
    public boolean damage(int value){
        if(hp == 0){
            return false;
        }
        int currentHP = hp - value;
        if(currentHP >= 0){
            this.hp = currentHP;
        }
        else{
            this.hp = 0;
        }
        return true;

    }

    //Abstract Method
    public abstract void attack(Pokemon enemy);

    //Method
    public String toString(){
        return name;
    }
}