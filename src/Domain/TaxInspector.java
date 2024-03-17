package Domain;

public class TaxInspector implements Interfaces.iActorBehaviour, Interfaces.iReturnOrder{
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;


    public TaxInspector() {
        this.name = "Tax Audit";
    }

    public String getName()
    {
        return name;
    }


    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setTakeOrder(boolean val) {
        isTakeOrder = val;
    }
    public void setMakeOrder(boolean val) {
        isMakeOrder = val;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }


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
