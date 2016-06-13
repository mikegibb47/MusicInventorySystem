package musicinventorysystem;

/**
 *
 * @author Matt Gulbronson
 */
class InstrumentBeta {

    enum InstrumentType {

        TRUMPET("Trumpet"),
        CLARINET("Clarinet"),
        TROMBONE("Trombone"),
        BASSCLAR("Bass Clarinet"),
        FLUTE("Flute"),
        TUBA("Tuba"),
        ALTOSAX("Alto Saxophone"),
        BARISAX("Baritone Saxophone");

        String name; // displayed name of the instrument type

        InstrumentType(String name) {
            this.name = name;
        }
    }

    int num;
    String dispName;
    boolean signedOut, repair;

    InstrumentBeta(InstrumentType instrType, int n) {
        this.num = n;
        this.dispName = instrType.name;
    }
}
