import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.ggf.drmaa.DrmaaException;
import org.ggf.drmaa.JobInfo;
import org.ggf.drmaa.JobTemplate;
import org.ggf.drmaa.Session;
import org.ggf.drmaa.SessionFactory;

public class TestJob {
   public static void main(String[] args) {
      SessionFactory factory = SessionFactory.getFactory();
      Session session = factory.getSession();
      
      try {
		 String command = args[0];
         session.init("");
         JobTemplate jt = session.createJobTemplate();
         jt.setRemoteCommand(command);
         jt.setArgs(Collections.singletonList("5"));
         
         String id = session.runJob(jt);
         
         System.out.println("Your job has been submitted with id " + id);
         
         session.deleteJobTemplate(jt);
         
         JobInfo info = session.wait(id, Session.TIMEOUT_WAIT_FOREVER);
         
         if (info.wasAborted()) {
            System.out.println("Job " + info.getJobId() + " never ran");
         } else if (info.hasExited()) {
            System.out.println("Job " + info.getJobId() +
                  " finished regularly with exit status " +
                  info.getExitStatus());
         } else if (info.hasSignaled()) {
            System.out.println("Job " + info.getJobId() +
                  " finished due to signal " +
                  info.getTerminatingSignal());
         } else {
            System.out.println("Job " + info.getJobId() +
                  " finished with unclear conditions");
         }
         
         System.out.println("Job Usage:");
         
         Map rmap = info.getResourceUsage();
         Iterator i = rmap.keySet().iterator();
         
         while (i.hasNext()) {
            String name = (String)i.next();
            String value = (String)rmap.get(name);
            
            System.out.println("  " + name + "=" + value);
         }
         
         session.exit();
      } catch (DrmaaException e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}
