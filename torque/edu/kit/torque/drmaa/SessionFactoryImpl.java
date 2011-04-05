package edu.kit.torque.drmaa;

import org.ggf.drmaa.Session;
import org.ggf.drmaa.SessionFactory;

/**
 * This class is used to create a SessionImpl instance.  In order to use the
 * Grid Engine binding, the $SGE_ROOT environment variable must be set, the
 * $SGE_ROOT/lib/drmaa.jar file must in included in the CLASSPATH environment
 * variable, and the $SGE_ROOT/lib/$ARCH directory must be included in the
 * library path, e.g. LD_LIBRARY_PATH.
 * @see org.ggf.drmaa.SessionFactory
 * @author dan.templeton@sun.com
 * @since 0.5
 * @version 1.0
 */
public class SessionFactoryImpl extends SessionFactory {
    private Session thisSession = null;
    
    /**
     * Creates a new instance of SessionFactoryImpl.
     */
    public SessionFactoryImpl() {
    }
    
    public Session getSession() {
        synchronized (this) {
            if (thisSession == null) {
                thisSession = new SessionImpl();
            }
        }
        
        return thisSession;
    }
}
