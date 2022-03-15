package sr.unasat.library.entity;

import java.util.ArrayList;
import java.util.List;

public enum RolType {

    ARTS ("Arts"),
    ARTS_ASSISTENT ("Arts assistent"),
    BALI_MEDEWERKER ("Bali-medewerker"),
    ADMINISTRATIE ("Administratie");

    private final String rol;

    RolType(String rol){
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static List<RolType> getAllRoles(){
        List<RolType> rollen = new ArrayList<>();

        for (RolType rol : RolType.values()) {
            rollen.add(rol);
        }

        return rollen;
    }
}
