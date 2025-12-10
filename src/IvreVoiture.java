public class IvreVoiture extends DecoratedVoiture{
    private int count;
    
    public IvreVoiture(IVoiture v){
        super(v);
        this.count = 0;
    }

    @Override
    public void moove(int random_nb, int pisteSize) {
        if(count % 2 == 0){
            super.moove(random_nb, pisteSize);
        }else{
            super.moove((-1) * random_nb, pisteSize);
        }
    }

}
