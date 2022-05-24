package fr.phpierre.axelor.intellij.hotreload;

import com.axelor.inject.Beans;
import com.axelor.meta.loader.ViewLoaderHotReload;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ViewHotReloadController {

    public void reloadFiles(ActionRequest request, ActionResponse response) throws IOException, JAXBException {
        IdeHotReload ideHotReload = request.getContext().asType(IdeHotReload.class);
        List<IdeHotReloadView> views = ideHotReload.getViews();
        ViewLoaderHotReload viewLoader = Beans.get(ViewLoaderHotReload.class);

        for (IdeHotReloadView view : views) {
            Path path = Paths.get(view.getPath());
            viewLoader.reloadView(path.toUri().toURL(), HotReloadUti.getModuleName(path));
        }

        response.setNotify(views.size() + " views reloaded");
        response.setStatus(200);
    }
}
