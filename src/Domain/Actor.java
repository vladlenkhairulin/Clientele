package Domain;

import Interfaces.iReturnOrder;

public abstract class Actor implements Interfaces.iActorBehaviour, iReturnOrder {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract void setName(String name);
    @Override
    public void initiateReturn() {
        System.out.println("Запрошен возврат товара");
    }

    @Override
    public boolean canReturnItem() {
        return false;
    }

    @Override
    public void confirmReturn(boolean isSpecialClient) {
        if (isSpecialClient) {
            System.out.println("Подтвержден процесс возврата товара для специального клиента");
        } else {
            System.out.println("Вам недоступна опция возврата товара");
        }

    }
}
