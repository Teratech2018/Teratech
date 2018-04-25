
package com.megatimgroup.smsgw.dao.test.referentiel;

import com.bekosoftware.genericdaolayer.contexts.AnnotationsProcessor;
import com.bekosoftware.genericdaolayer.contexts.IocContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * OrderDaoTest
 * 
 */
public class OrderDaoTest {

    private static com.megatimgroup.smsgw.dao.ifaces.referentiel.OrderDAO dao;
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
        dao = ((com.megatimgroup.smsgw.dao.ifaces.referentiel.OrderDAO) stub.lookup("com.megatimgroup.smsgw.dao.impl.referentiel.OrderDAOImpl"));
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
