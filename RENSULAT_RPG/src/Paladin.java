public class Paladin extends Swordsman{
    private boolean hasResurrected;
    
    public Paladin(){
        super();
        this.hasResurrected = false;
    }

    public boolean hasResurrected() {
        return hasResurrected;
    }

    public void setHasResurrected(boolean hasResurrected) {
        this.hasResurrected = hasResurrected;
    }
    
    @Override public void  receiveDamage(int damage){
        int finalDamage = Math.max(damage-getShield(), 0);
        
        if (finalDamage%2 == 0){
            finalDamage = finalDamage / 2; 
        }
        
        setHealth(getHealth() - finalDamage);
        if (getHealth() <= 0){
            resurrect();
        }
    }
    
    public void resurrect(){
        if (hasResurrected = false){
            hasResurrected = true;
            setHealth(100);
        }
        else {
            System.out.println("Paladin has died.");
        }
    }
}
