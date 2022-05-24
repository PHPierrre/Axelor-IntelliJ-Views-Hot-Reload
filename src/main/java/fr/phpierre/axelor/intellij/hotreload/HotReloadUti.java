package fr.phpierre.axelor.intellij.hotreload;

import java.nio.file.Path;

public class HotReloadUti {

    public static final String RESOURCES_FOLDER = "resources";
    public static final String MAIN_FOLDER = "main";
    public static final String SRC_FOLDER = "src";

    public static String getModuleName(Path initialPath) {
        Path path = initialPath.getParent();
        boolean found = false;
        String moduleName = null;

        while(!found) {
            if(path.getFileName().toString().equals(RESOURCES_FOLDER)) {
                int resourcesIndex = path.getNameCount();
                if(isChildToMainAndSrcFolder(path, resourcesIndex)) {
                    found = true;
                    moduleName = path.getName(resourcesIndex-4).toString();
                }
            }
            path = path.getParent();
        }

        return moduleName;
    }

    private static boolean isChildToMainAndSrcFolder(Path initialPath, int resourcesIndex) {
        if(resourcesIndex-2 <= 0) {
            return false;
        }

        return initialPath.getName(resourcesIndex-2).toString().equals(MAIN_FOLDER) &&
                initialPath.getName(resourcesIndex-3).toString().equals(SRC_FOLDER);
    }


}
