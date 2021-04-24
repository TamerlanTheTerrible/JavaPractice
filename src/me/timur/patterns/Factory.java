package me.timur.patterns;

/**
 * Created by Timur on 24.04.2021
 */

public class Factory{
    public static void main(String[] args) {

        PlovFactory.cookPlov(PlovType.WEDDING).prepare();

        PlovFactory.cookPlov(PlovType.ZIGIR).prepare();

        PlovFactory.cookPlov(PlovType.CHOYXONA).prepare();

    }
}


class PlovFactory {

    public static Plov cookPlov(PlovType type){
        switch (type) {
            case ZIGIR:
                return new ZigirPlov();
            case WEDDING:
                return new WeddingPlov();
            default:
                return new ChoyxonaPlov();
        }
    }
}

interface Plov {

    void prepare();
}

enum PlovType {
    WEDDING,
    CHOYXONA,
    ZIGIR
}

class WeddingPlov implements Plov {
    @Override
    public void prepare() {
        System.out.println("Wedding plov is ready");
    }
}
class ChoyxonaPlov implements Plov  {
    @Override
    public void prepare() { System.out.println("Choyxona plov is ready"); }
}
class ZigirPlov implements Plov  {
    @Override
    public void prepare() { System.out.println("Zigir plov is ready"); }
}



