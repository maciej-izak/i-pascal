package com.siberika.idea.pascal.lang.references;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.siberika.idea.pascal.lang.parser.PascalParserUtil;
import com.siberika.idea.pascal.lang.psi.PascalNamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 3/14/13
 * Author: George Bakhtadze
 */
public class PascalChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<PascalNamedElement> properties = PascalParserUtil.findTypes(project);
        List<String> names = new ArrayList<String>(properties.size());
        for (PascalNamedElement property : properties) {
            if (property.getName() != null && property.getName().length() > 0) {
                names.add(property.getName());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // todo include non project items
        //List<PascalNamedElement> properties = PascalParserUtil.findTypes(project.getProjectFile(), name);
        //return properties.toArray(new NavigationItem[properties.size()]);
        return null;
    }
}
