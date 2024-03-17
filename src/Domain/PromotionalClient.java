package Domain;



public class PromotionalClient implements Interfaces.iActorBehaviour, Interfaces.iReturnOrder {
    private final String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private final int actorId;       // Id клиента
    private final int participantsCount;  // Количество участников в акции
    int spotsLeft = 0;   // Количество оставшихся мест в акции
    public boolean isRunning = true; // Проверяет, остались ли места для участия в акции


    public PromotionalClient(String name, int actorId, int participantsCount) {
        this.actorId = actorId;
        this.name = name;
        this.participantsCount = participantsCount;
        initializeSpotsLeft();
    }

    private void initializeSpotsLeft() { // устанавливает начальное значение оставшихся мест
        if (spotsLeft == 0) {
            spotsLeft = participantsCount;
        }
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
        return true;
    }

    @Override
    public void confirmReturn(boolean isSpecialClient) {
        if (isSpecialClient) {
            System.out.println("Подтвержден процесс возврата товара для специального клиента");
        } else {
            System.out.println("Вам недоступна опция возврата товара");
        }

    }


    public void decreaseSpotsLeft() {
        if (spotsLeft > 0) {
            spotsLeft--; // Уменьшаем количество оставшихся мест на один, если они еще есть
            if (spotsLeft == 0) {
                isRunning = false; // Если места закончились, акция завершена
            }
        }

    }

    public void participateInPromotion() {
        // Название акции
        String promotionName = "\"3-я пара обуви в подарок\"";
        if (isRunning && spotsLeft > 0) {
            System.out.println("Вы участвуете в акции " + promotionName + "!" + "Ваш номер - " + actorId);
            decreaseSpotsLeft();
            if (spotsLeft == 0) {
                isRunning = false;
            }
        }
            else {
                System.out.println("Извините, места в акции " + promotionName + " закончились.");
            }
        }
    }

