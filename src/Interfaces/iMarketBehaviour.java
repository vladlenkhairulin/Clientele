package Interfaces;
import java.util.List;

public interface iMarketBehaviour {
    public void acceptToMarket(iActorBehaviour actor);
    public void releaseFromMarket(List<Domain.Actor> actors);
    public void update();
}
