public class IvreVoiture extends DecoratedVoiture{
    private int count;
    
    public IvreVoiture(IVoiture v){
        super(v);
        this.count = 0;
    }

    @Override
    public void moove() {
        if(count % 2 == 0){
            super.moove();
        }else{
            super.moove();
        }
    }

}
