
package com.megatimgroup.smsgw.core.test.referentiel;

import com.bekosoftware.genericmanagerlayer.tools.ejb.ServiceLocator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * ProductOrderManagerTest
 * 
 */
public class ProductOrderManagerTest {

    private static com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManager manager;

    /**
     * @throws java.lang.Exception
     * 
     */
    @BeforeClass
    public static void initialise()
        throws Exception
    {
        ServiceLocator.setDataSource("orion_ds");
        manager = ((com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManager) ServiceLocator.lookup(com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManager.SERVICE_NAME));
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
