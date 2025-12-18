public class HybrideVoiture extends VoitureDecorator {
    private int batteryLevel;
    
    public HybrideVoiture(IVoiture v){
        super(v);
        this.batteryLevel = 100;
    }

    @Override
    public void moove() {
        if (batteryLevel > 0) {
            int gasBefore = voiture.getGasLeft(); 
            
            voiture.moove(); 
            
            int consumed = gasBefore - voiture.getGasLeft();
            if (consumed > 0) {
                ((Voiture)voiture).decreaseGas(-consumed); 
                batteryLevel -= 10;
                System.out.println("[Hybride] Moteur électrique actif. Batterie : " + batteryLevel + "%");
            }
        } else {
            voiture.moove();
        }
    }

    @Override
    public void decelerate() {
        super.decelerate();
        this.batteryLevel += 5;
        if (this.batteryLevel > 100){
            this.batteryLevel = 100;
        }
        System.out.println("[i] New Battery Level : " + this.batteryLevel + "%");
    }

    @Override
    public void decreaseGas(int nb) {
        voiture.decreaseGas(nb);;
    }

    @Override
    public void set_state(State new_state) {
        voiture.set_state(new_state);
    }
    
    @Override
    public State get_state() {
        return voiture.get_state();
    }
    
    

}
