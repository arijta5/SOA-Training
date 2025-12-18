package graphql;

import business.ModuleBusiness;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;

public class ModuleMutationResolver implements GraphQLRootResolver {

    private ModuleBusiness helper;

    public ModuleMutationResolver() {
        helper = new ModuleBusiness();
    }

    // ADD MODULE
    public boolean addModule(
            String matricule,
            String nom,
            int coefficient,
            int volumeHoraire,
            Module.TypeModule type,
            int ueCode
    ) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(ueCode);

        Module module = new Module(
                matricule,
                nom,
                coefficient,
                volumeHoraire,
                type,
                ue
        );

        return helper.addModule(module);
    }

    // UPDATE MODULE
    public boolean updateModule(
            String matricule,
            String nom,
            int coefficient,
            int volumeHoraire,
            Module.TypeModule type,
            int ueCode
    ) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(ueCode);

        Module updatedModule = new Module(
                matricule,
                nom,
                coefficient,
                volumeHoraire,
                type,
                ue
        );

        return helper.updateModule(matricule, updatedModule);
    }

    // DELETE MODULE

    public boolean deleteModule(String matricule) {
        return helper.deleteModule(matricule);
    }
}