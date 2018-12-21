
package com.megatimgroup.dao.test.parametres;

import com.bekosoftware.genericdaolayer.contexts.AnnotationsProcessor;
import com.bekosoftware.genericdaolayer.contexts.IocContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * SocieteDaoTest
 * 
 */
public class SocieteDaoTest {

    private static com.megatimgroup.dao.ifaces.parametres.SocieteDAO dao;
    /**
     * initialisation du conteneur
     * 
     */
    private static IocContext stub;

    /**
     * @throws java.lang.Exception
     * 
     */
    @BeforeClass
    public static void initialise()
        throws Exception
    {
        AnnotationsProcessor.setTest(true);
        stub = new IocContext();
        dao = ((com.megatimgroup.dao.ifaces.parametres.SocieteDAO) stub.lookup("com.megatimgroup.dao.impl.parametres.SocieteDAOImpl"));
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @AfterClass
    public static void finalise()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @Before
    public void before()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @After
    public void after()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     * 
     */
    @Test
    public void test()
        throws Exception
    {
    }

}
