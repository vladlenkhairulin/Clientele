/**
 * Название проекта: Магазин
 * Описание: Проект реализует очередь клиентов в магазине Small, ведёт запись всех пришедших за день клиентов.
 * Автор: Хайрулин Владлен
 * Дата создания: 10.03.2024
 * Версия: 1.0
 */

import Domain.*;
import Interfaces.iActorBehaviour;
import Service.Market;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
    Market small = new Market();

        Actor client1 = new OrdinaryClient("reiner");
        iActorBehaviour client2 = new OrdinaryClient("annie");
        iActorBehaviour client3 = new SpecialClient("zeke", 1);
        iActorBehaviour client4 = new TaxInspector();
        PromotionalClient client5 = new PromotionalClient("karla", 1, 5);
        PromotionalClient client6 = new PromotionalClient("karla2", 2, 5);
        PromotionalClient client7 = new PromotionalClient("karla3", 3, 5);
        PromotionalClient client8 = new PromotionalClient("karla4", 4, 5);
        PromotionalClient client9 = new PromotionalClient("karla5", 5, 5);
        PromotionalClient client10 = new PromotionalClient("karla6", 6, 5);
        PromotionalClient client11 = new PromotionalClient("7", 7, 5);

    small.acceptToMarket(client1);
    small.acceptToMarket(client2);
    small.acceptToMarket(client3);
    small.acceptToMarket(client4);
    small.acceptToMarket(client5);
    small.acceptToMarket(client6);
    small.acceptToMarket(client7);
    small.acceptToMarket(client8);
    small.acceptToMarket(client9);
    small.acceptToMarket(client10);
    small.acceptToMarket(client11);

    client1.initiateReturn();
    boolean canReturn = client1.canReturnItem();
    client1.confirmReturn(canReturn);

    small.checkAndParticipateInPromotion();



    small.update();
}
}
