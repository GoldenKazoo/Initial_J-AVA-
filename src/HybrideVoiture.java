public class HybrideVoiture extends DecoratedVoiture{
    private int batteryLevel;
    
    public HybrideVoiture(IVoiture v){
        super(v);
        this.batteryLevel = 100;
    }

    @Override
    public void moove() {
        if (batteryLevel > 0) {
            // Sauvegarde du carburant avant le déplacement
            int gasBefore = voiture.getGasLeft(); 
            
            // Appel du mouvement (qui va consommer du gas via l'état actuel)
            voiture.moove(); 
            
            // Calcul de la consommation effectuée par l'état (ex: 2 pour Normal, 5 pour Boost)
            int consumed = gasBefore - voiture.getGasLeft();
            if (consumed > 0) {
                ((Voiture)voiture).decreaseGas(-consumed); 
                batteryLevel -= 10; // Consommation de 10% de batterie par cycle
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

}
