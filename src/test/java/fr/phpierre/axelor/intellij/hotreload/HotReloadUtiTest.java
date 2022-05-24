package fr.phpierre.axelor.intellij.hotreload;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class HotReloadUtiTest {

    @Test
    public void testGetModuleNameFromPath() {
        assertEquals("axelor-plugin", HotReloadUti.getModuleName(Paths.get("C:/Users/Lala/IdeaProjects/axelor/custom/axelor-plugin/src/main/resources/views/View.xml")));
        assertEquals("axelor-plugin", HotReloadUti.getModuleName(Paths.get("C:/Users/Lala/IdeaProjects/axelor/custom/axelor-plugin/src/main/resources/views/Func1/View.xml")));
        assertEquals("axelor-plugin", HotReloadUti.getModuleName(Paths.get("C:/Users/Lala/IdeaProjects/axelor/custom/axelor-plugin/src/main/resources/domains/View.xml")));
    }
}