package Interfaces;

public interface iQueueBehaviour {
    public void takeInQueue(iActorBehaviour actor);
    public void releaseFromQueue();
    public void takeOrder ();
    public void giveOrder ();
}
