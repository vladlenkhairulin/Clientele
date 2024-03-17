package Interfaces;

public interface iReturnOrder {
    void initiateReturn(); // поступление запроса на возврат товара
    boolean canReturnItem(); // проверяет, относится ли клиент к специальным или акционным клиентам
    void confirmReturn(boolean isSpecialClient); // подтверждает возврат товара
}
