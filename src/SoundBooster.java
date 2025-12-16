import java.awt.Color;

public class SoundBooster extends VoitureDecorator
{

    public SoundBooster(IVoiture voiture) {
        super(voiture);
    }
    
    public void moove(int random_nb, int pisteSize)
    {
        this.voiture.moove(random_nb, pisteSize);
        if(this.voiture.get_state().get_name().equals("BOOST"))
        {
            System.out.println("VROOOOOOOOOOOOOOOOOOOM");
        }
    }
}
