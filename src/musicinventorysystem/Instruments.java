package musicinventorysystem;

/**
 *
 * @author Matt Gulbronson
 */
abstract class Instrument {

    int num;
    boolean signedOut, repair;

    Instrument(int n) {
        this.num = n;
    }
}

class Trumpet extends Instrument {

    String name = "Trumpet " + num;

    public Trumpet(int n) {
        super(n);
    }
}

class Clarinet extends Instrument {

    String name = "Clarinet " + num;

    public Clarinet(int n) {
        super(n);
    }
}

class Flute extends Instrument {

    String name = "Flute " + num;

    public Flute(int n) {
        super(n);
    }
}

class Trombone extends Instrument {

    String name = "Trombone " + num;

    public Trombone(int n) {
        super(n);
    }
}

class x extends Instrument {

    String name = "x " + num;

    public x(int n) {
        super(n);
    }
}
