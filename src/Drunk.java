public class Drunk extends VoitureDecorator
{
    boolean forward = true;

    public Drunk (IVoiture voiture)
    {
        super(voiture);
    }

    @Override
    public void moove(int random_nb, int pisteSize) {
        int posAvant = voiture.getPosition();

        voiture.moove(random_nb, pisteSize);

        int deplacement = voiture.getPosition() - posAvant;

        if (this.forward == false)
        {
            int newPos = posAvant - deplacement;
            voiture.setPosition(newPos);
            System.out.println("LE pilote est completement ivre, 1 verre d'alcool, 1 verre d'eau !");
            this.forward = true;
        }
        else
        {
            this.forward = false;
        }
    }
}
