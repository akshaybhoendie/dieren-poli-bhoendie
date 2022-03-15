package sr.unasat.library.entity;

import javax.smartcardio.CardTerminal;
import java.util.ArrayList;
import java.util.List;

public enum Categorie {

    INSECTEN ("Insecten"),
    ZOOGDIEREN ("Zoogdieren"),
    VISSEN ("Vissen"),
    REPTIELEN ("Reptielen"),
    AMFIBIEEN ("Amfibieen");

    private final String categorie;

    Categorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public static List<Categorie> getCategorieen(){
        List<Categorie> categorieen = new ArrayList<>();

        for(Categorie categorie : Categorie.values()){
            categorieen.add(categorie);
        }

        return categorieen;
    }
}
