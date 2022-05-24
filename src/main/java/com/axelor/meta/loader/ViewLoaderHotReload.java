package com.axelor.meta.loader;

import com.google.inject.persist.Transactional;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;

public class ViewLoaderHotReload extends ViewLoader {
    @Transactional
    public void reloadView(URL url, String moduleName) throws JAXBException, IOException {
        final Module module = ModuleManager.getModule(moduleName);
        process(url, module, true);
        doCleanUp();
    }
}
