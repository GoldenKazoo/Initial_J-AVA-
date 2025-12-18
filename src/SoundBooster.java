public class SoundBooster extends VoitureDecorator {
    
    public SoundBooster(IVoiture v){
        super(v);
    }

    @Override
    public void accelerate() {
        // TODO Auto-generated method stub
        super.accelerate();
        System.out.println("VROOUUUUM !");
    }
}
