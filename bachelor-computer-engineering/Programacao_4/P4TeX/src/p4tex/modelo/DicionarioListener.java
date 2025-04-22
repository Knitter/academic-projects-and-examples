package p4tex.modelo;

import java.util.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public interface DicionarioListener extends EventListener {
    public void dicionarioLoadFinished(DicionarioEvent event);
    public void dicionarioLoading(DicionarioEvent event);
    public void dicionarioStartLoading(DicionarioEvent event);
}
